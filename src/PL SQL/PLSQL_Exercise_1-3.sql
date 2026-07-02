CREATE TABLE Customers (
    CustomerID    NUMERIC PRIMARY KEY,
    Name          VARCHAR(100),
    DOB           DATE,
    Balance       NUMERIC,
    LastModified  DATE,
    IsVIP         BOOLEAN DEFAULT FALSE 
);

CREATE TABLE Accounts (
    AccountID     NUMERIC PRIMARY KEY,
    CustomerID    NUMERIC REFERENCES Customers(CustomerID),
    AccountType   VARCHAR(20),
    Balance       NUMERIC,
    LastModified  DATE
);

CREATE TABLE Transactions (
    TransactionID     NUMERIC PRIMARY KEY,
    AccountID         NUMERIC REFERENCES Accounts(AccountID),
    TransactionDate   DATE,
    Amount            NUMERIC,
    TransactionType   VARCHAR(10)
);

CREATE TABLE Loans (
    LoanID        NUMERIC PRIMARY KEY,
    CustomerID    NUMERIC REFERENCES Customers(CustomerID),
    LoanAmount    NUMERIC,
    InterestRate  NUMERIC,
    StartDate     DATE,
    EndDate       DATE
);

CREATE TABLE Employees (
    EmployeeID  NUMERIC PRIMARY KEY,
    Name        VARCHAR(100),
    Position    VARCHAR(50),
    Salary      NUMERIC,
    Department  VARCHAR(50),
    HireDate    DATE
);

CREATE TABLE AuditLog (
    LogID         SERIAL PRIMARY KEY,
    LogTime       TIMESTAMP DEFAULT NOW(),
    LogType       VARCHAR(20),
    Message       TEXT
);

-- SAMPLE DATA

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, CURRENT_DATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, CURRENT_DATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (3, 'Robert Old', TO_DATE('1955-01-10', 'YYYY-MM-DD'), 12000, CURRENT_DATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, CURRENT_DATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, CURRENT_DATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (3, 3, 'Savings', 12000, CURRENT_DATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, CURRENT_DATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, CURRENT_DATE, 300, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, CURRENT_DATE, CURRENT_DATE + INTERVAL '60 months');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 3, 8000, 6, CURRENT_DATE - INTERVAL '59 months', CURRENT_DATE + INTERVAL '10 days');

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

-- EXERCISE 1: CONTROL STRUCTURES
-- Scenario 1: apply 1% discount to loan interest rate for customers over 60
DO $$
DECLARE
    cust RECORD;
BEGIN
    FOR cust IN SELECT CustomerID, DOB FROM Customers LOOP
        IF DATE_PART('year', AGE(CURRENT_DATE, cust.DOB)) > 60 THEN
            UPDATE Loans
               SET InterestRate = InterestRate * 0.99
             WHERE CustomerID = cust.CustomerID;
            RAISE NOTICE 'Discount applied for CustomerID %', cust.CustomerID;
        END IF;
    END LOOP;
END $$;

-- Scenario 2: set IsVIP = TRUE for customers with balance > 10000
DO $$
DECLARE
    cust RECORD;
BEGIN
    FOR cust IN SELECT CustomerID, Balance FROM Customers LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers SET IsVIP = TRUE WHERE CustomerID = cust.CustomerID;
            RAISE NOTICE 'CustomerID % promoted to VIP', cust.CustomerID;
        END IF;
    END LOOP;
END $$;

-- Scenario 3: print a reminder for loans due within the next 30 days
DO $$
DECLARE
    ln RECORD;
BEGIN
    FOR ln IN
        SELECT LoanID, CustomerID, EndDate
          FROM Loans
         WHERE EndDate BETWEEN CURRENT_DATE AND CURRENT_DATE + INTERVAL '30 days'
    LOOP
        RAISE NOTICE 'Reminder: LoanID % for CustomerID % is due on %',
            ln.LoanID, ln.CustomerID, ln.EndDate;
    END LOOP;
END $$;


-- EXERCISE 2: ERROR HANDLING
-- Scenario 1: SafeTransferFunds
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account NUMERIC,
    p_to_account   NUMERIC,
    p_amount       NUMERIC
)
LANGUAGE plpgsql
AS $$
DECLARE
    v_from_balance NUMERIC;
BEGIN
    SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account;

    IF v_from_balance IS NULL THEN
        RAISE EXCEPTION 'Source account % does not exist', p_from_account;
    END IF;

    IF v_from_balance < p_amount THEN
        RAISE EXCEPTION 'Insufficient funds in account %', p_from_account;
    END IF;

    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;

    INSERT INTO AuditLog (LogType, Message)
    VALUES ('TRANSACTION', FORMAT('Transferred %s from %s to %s', p_amount, p_from_account, p_to_account));

EXCEPTION
    WHEN OTHERS THEN
        INSERT INTO AuditLog (LogType, Message) VALUES ('ERROR', SQLERRM);
END;
$$;

-- Scenario 2: UpdateSalary
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id NUMERIC,
    p_percent     NUMERIC
)
LANGUAGE plpgsql
AS $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Employees WHERE EmployeeID = p_employee_id) THEN
        RAISE EXCEPTION 'EmployeeID % does not exist', p_employee_id;
    END IF;

    UPDATE Employees
       SET Salary = Salary + (Salary * p_percent / 100)
     WHERE EmployeeID = p_employee_id;

EXCEPTION
    WHEN OTHERS THEN
        INSERT INTO AuditLog (LogType, Message) VALUES ('ERROR', SQLERRM);
END;
$$;

-- Scenario 3: AddNewCustomer
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id NUMERIC,
    p_name        VARCHAR,
    p_dob         DATE,
    p_balance     NUMERIC
)
LANGUAGE plpgsql
AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM Customers WHERE CustomerID = p_customer_id) THEN
        RAISE EXCEPTION 'CustomerID % already exists', p_customer_id;
    END IF;

    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, CURRENT_DATE);

EXCEPTION
    WHEN OTHERS THEN
        INSERT INTO AuditLog (LogType, Message) VALUES ('ERROR', SQLERRM);
END;
$$;

-- EXERCISE 3: STORED PROCEDURES
-- Scenario 1: ProcessMonthlyInterest — apply 1% interest to all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest()
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE Accounts
       SET Balance = Balance * 1.01,
           LastModified = CURRENT_DATE
     WHERE AccountType = 'Savings';
END;
$$;

-- Scenario 2: UpdateEmployeeBonus — add a bonus % to salaries in a department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department VARCHAR,
    p_bonus_pct  NUMERIC
)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE Employees
       SET Salary = Salary + (Salary * p_bonus_pct / 100)
     WHERE Department = p_department;
END;
$$;

-- Scenario 3: TransferFunds — transfer between accounts, checking balance first
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account NUMERIC,
    p_to_account   NUMERIC,
    p_amount       NUMERIC
)
LANGUAGE plpgsql
AS $$
DECLARE
    v_balance NUMERIC;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;

    IF v_balance IS NULL THEN
        RAISE EXCEPTION 'Account % not found', p_from_account;
    END IF;

    IF v_balance < p_amount THEN
        RAISE EXCEPTION 'Insufficient balance in account %', p_from_account;
    END IF;

    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;
END;
$$;

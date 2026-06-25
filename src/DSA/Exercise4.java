package DSA;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return "Employee{id=" + employeeId + ", name='" + name + "', position='" + position + "', salary=" + salary + "}";
    }
}

public class Exercise4 {
    private Employee[] employees;
    private int size;

    Exercise4(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee e) {
        if (size == employees.length) {
            System.out.println("Array full.");
            return;
        }
        employees[size++] = e;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) return employees[i];
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                System.out.println("Deleted employee " + employeeId);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        Exercise4 empSys = new Exercise4(10);

        empSys.addEmployee(new Employee(1, "Alice", "Manager", 75000));
        empSys.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        empSys.addEmployee(new Employee(3, "Charlie", "Designer", 55000));

        System.out.println("All employees:");
        empSys.traverse();

        System.out.println("\nSearching for id 2: " + empSys.searchEmployee(2));

        empSys.deleteEmployee(2);

        System.out.println("\nAfter deletion:");
        empSys.traverse();
    }
}

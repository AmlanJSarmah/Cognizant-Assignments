## Usage Instructions
1. In the `src` folder *packages* are created for respective topics like *DSA*, *Design Patterns*, *TDD*, *Mockito*, *Logging*, *Spring Core & Maven*, *PL/SQL* etc.  
2. Inside those packages files such as *Exercise1.java*, *Exercise2.java* are created where solutions of each individual exercise is present.  
3. A corresponding markdown file such as *Exercise1.md* outlines all the theory.
4. The **Spring Data JPA with Spring Boot & Hibernate** exercise is inside the `orm-learn` directory as a standalone Maven project.
5. The **Spring Web** exercise is inside the `spring-learn` directory as a standalone Maven project.
6. The **Hello World REST** exercise is inside the `Hello-World-Rest` directory as a standalone Maven project.
7. The **Country REST API** exercise is inside the `Country-Api` directory as a standalone Maven project.
8. The **JWT Authentication** exercise is inside the `JWT-Demo` directory as a standalone Maven project.
9. The **Microservices Account & Loan** exercise is inside the `Microservices-Account-Exercise` directory with two sub-projects: `account` and `loan`.
10. The **React Exercise 1** is inside the `React-Exercise-1` directory as a Vite + React project.
11. The **React Exercise 2 (Student Management Portal)** is inside the `React-Exercise-2` directory as a Vite + React project with Home, About, and Contact components.
12. The **React Exercise 3 (Score Calculator App)** is inside the `React-Exercise-3` directory as a Vite + React project with a CalculateScore component.
13. The **React Exercise 4 (Blog App)** is inside the `React-Exercise-4` directory as a Vite + React project using class components to fetch and display posts from JSONPlaceholder.

### Running orm-learn

**Prerequisites:** PostgreSQL running on localhost:5432 with a database named `ormlearn` and the `country` table seeded.

```bash
# Build
cd orm-learn
../apache-maven-3.9.6/bin/mvn clean compile

# Run
../apache-maven-3.9.6/bin/mvn spring-boot:run
```

The app starts, connects to PostgreSQL, fetches all countries via Spring Data JPA, and logs them before shutting down.

### Running spring-learn

The `pom.xml` specifies which exercise to run via `<mainClass>`. To switch, edit `pom.xml` and change the value.

**Exercise 1** — Spring Web with embedded Tomcat:

```bash
cd spring-learn
../apache-maven-3.9.6/bin/mvn spring-boot:run
```

Starts Tomcat on port 8080 and logs "Inside main".

**Exercise 2** — Load Country from Spring XML config:

```bash
cd spring-learn
# First edit pom.xml: <mainClass>com.cognizant.springlearn.Exercise2</mainClass>
../apache-maven-3.9.6/bin/mvn spring-boot:run
```

Loads `country.xml`, creates 4 Country beans, logs constructor/setter calls, and prints one country.

### Running Hello-World-Rest

```bash
cd Hello-World-Rest
../apache-maven-3.9.6/bin/mvn spring-boot:run
```

Starts on port 8083. Test the endpoint:

```bash
curl http://localhost:8083/hello
# Response: Hello World!!
```

Controller logs `Start` and `End` around each request.

### Running Country-Api

```bash
cd Country-Api
../apache-maven-3.9.6/bin/mvn spring-boot:run
```

Starts on port 8083. Test the endpoints:

```bash
curl http://localhost:8083/country
# Response: {"code":"IN","name":"India"}

curl http://localhost:8083/countries/in
# Response: {"code":"IN","name":"India"}

curl http://localhost:8083/countries/US
# Response: {"code":"US","name":"United States"}
```

`/country` returns India. `/countries/{code}` returns any country from `country.xml` with case-insensitive matching.

### Running JWT-Demo

```bash
cd JWT-Demo
../apache-maven-3.9.6/bin/mvn spring-boot:run
```

Starts on port 8090. Test authentication:

```bash
curl -s -u user:pwd http://localhost:8090/authenticate
# Response: {"token":"eyJhbGciOiJIUzM4NCJ9..."}
```

Valid credentials (`user`/`pwd`) return a JWT token. Invalid credentials return 401 Unauthorized.

### Running Microservices-Account-Exercise

Two independent Spring Boot microservices for account and loan management.

**Account service** (port 8080):

```bash
cd Microservices-Account-Exercise/account
../apache-maven-3.9.6/bin/mvn spring-boot:run
```

```bash
curl http://localhost:8080/accounts/00987987973432
# {"balance":234343,"number":"00987987973432","type":"savings"}
```

**Loan service** (port 8081):

```bash
cd Microservices-Account-Exercise/loan
../apache-maven-3.9.6/bin/mvn spring-boot:run
```

```bash
curl http://localhost:8081/loans/H00987987972342
# {"loan":400000,"emi":3258,"tenure":18,"number":"H00987987972342","type":"car"}
```

Both must run simultaneously on different ports.

### Running React-Exercise-1

```bash
cd React-Exercise-1
npm install
npm run dev
```

Opens at `http://localhost:5173`. Displays "Welcome to the first session of react".

### Running React-Exercise-2 (Student Management Portal)

```bash
cd React-Exercise-2
npm install
npm run dev
```

Opens at `http://localhost:5173`. Renders three components:
- **Home** — "Welcome to the Home page of Student Management Portal"
- **About** — "Welcome to the About page of the Student Management Portal"
- **Contact** — "Welcome to the Contact page of the Student Management Portal"

### Running React-Exercise-3 (Score Calculator App)

```bash
cd React-Exercise-3
npm install
npm run dev
```

Opens at `http://localhost:5173`. The `CalculateScore` component accepts `name`, `school`, `total`, and `goal` as props, calculates the average percentage, and displays a styled score card.

### Running React-Exercise-4 (Blog App)

```bash
cd React-Exercise-4
npm install
npm run dev
```

Opens at `http://localhost:5173`. Uses a class-based `Posts` component that fetches posts from `https://jsonplaceholder.typicode.com/posts` via `componentDidMount`, renders titles and bodies, and uses `componentDidCatch` for error handling.
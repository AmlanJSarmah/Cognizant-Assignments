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
14. The **React Exercise 9 (Cricket App)** is inside the `React-Exercise-9` directory as a Vite + React project demonstrating ES6 features: `map()`, `filter()`, arrow functions, destructuring, and array spread in a cricket players context.
15. The **React Exercise 10 (Office Space Rental App)** is inside the `React-Exercise-10` directory as a Vite + React project displaying office spaces with JSX, inline CSS for rent coloring, and list rendering via `map()`.
16. The **React Exercise 11 (Event Examples App)** is inside the `React-Exercise-11` directory as a Vite + React project demonstrating event handling: counters, synthetic events, and currency conversion.
17. The **React Exercise 12 (Ticket Booking App)** is inside the `React-Exercise-12` directory as a Vite + React project demonstrating conditional rendering with guest/user pages and flight booking.
18. The **React Exercise 13 (Blogger App)** is inside the `React-Exercise-13` directory as a Vite + React project demonstrating three conditional rendering methods: if/else, short-circuit `&&`, and ternary operator across Book, Blog, and Course components.
11. The **React Exercise 5 (Cohort Dashboard)** is inside the `React-Exercise-5` directory as a Vite + React project demonstrating CSS Modules for styling cohort cards with conditional color for ongoing/completed status.

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

### Running React-Exercise-9 (Cricket App)

```bash
cd React-Exercise-9
npm install
npm run dev
```

Opens at `http://localhost:5173`. Demonstrates ES6 features in a cricket context:
- **ListofPlayers** — 11 players displayed via `map()`; filtered below 70 using arrow functions.
- **IndianPlayers** — Odd/even teams via destructuring; T20 and Ranji Trophy arrays merged with spread (`...`).
- Toggle `flag` in `App.jsx` to switch between the two components.

### Running React-Exercise-10 (Office Space Rental App)

```bash
cd React-Exercise-10
npm install
npm run dev
```

Opens at `http://localhost:5173`. Displays office spaces using JSX:
- A featured office object with Name, Rent, and Address.
- A list of office objects rendered via `map()`.
- Rent color is **red** if below 60000, **green** if above 60000, using inline CSS.

### Running React-Exercise-11 (Event Examples App)

```bash
cd React-Exercise-11
npm install
npm run dev
```

Opens at `http://localhost:5173`. Demonstrates React event handling:
- **Counter** — Increment/Decrement buttons; "Increase" button calls both `increment()` and `sayHello()` simultaneously.
- **Say Welcome** — Button passes `'Welcome!'` as an argument to `sayWelcome()`.
- **Synthetic Event** — "OnPress" button uses a synthetic event to display "I was clicked".
- **Currency Convertor** — Form converts Euro to Indian Rupees (rate: 96.5) on submit.

### Running React-Exercise-12 (Ticket Booking App)

```bash
cd React-Exercise-12
npm install
npm run dev
```

Opens at `http://localhost:5173`. Demonstrates conditional rendering:
- **Guest Page** — Browse flight details with no booking option.
- **User Page** — Login to see Book buttons on each flight; booking shows a confirmation message.
- Login/Logout buttons toggle between the two views using `isLoggedIn` state.

### Running React-Exercise-13 (Blogger App)

```bash
cd React-Exercise-13
npm install
npm run dev
```

Opens at `http://localhost:5173`. Demonstrates three conditional rendering methods:
- **BookDetails** — Uses `if/else` to return `null` when hidden.
- **BlogDetails** — Uses short-circuit `&&` to conditionally render the table.
- **CourseDetails** — Uses ternary `? :` to switch between table and fallback message.
- Control buttons toggle visibility of all, none, or individual components.

### Running React-Exercise-5 (Cohort Dashboard)

```bash
cd React-Exercise-5
npm install
npm run dev
```

Opens at `http://localhost:5173`. Demonstrates CSS Modules styling:
- **CohortDetails.module.css** — `.box` class with 300px width, inline-block, 10px margin, 10px/20px padding, 1px black border, 10px border-radius; `<dt>` tag selector with font-weight 500.
- **CohortDetails component** — Imports CSS module, applies `styles.box` to container div, uses inline `style` for conditional `<h3>` color: green if ongoing, blue if completed.
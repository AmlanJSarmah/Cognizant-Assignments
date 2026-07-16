## Usage Instructions
1. In the `src` folder *packages* are created for respective topics like *DSA*, *Design Patterns*, *TDD*, *Mockito*, *Logging*, *Spring Core & Maven*, *PL/SQL* etc.  
2. Inside those packages files such as *Exercise1.java*, *Exercise2.java* are created where solutions of each individual exercise is present.  
3. A corresponding markdown file such as *Exercise1.md* outlines all the theory.
4. The **Spring Data JPA with Spring Boot & Hibernate** exercise is inside the `orm-learn` directory as a standalone Maven project.
5. The **Spring Web** exercise is inside the `spring-learn` directory as a standalone Maven project.
6. The **Hello World REST** exercise is inside the `Hello-World-Rest` directory as a standalone Maven project.
7. The **Country REST API** exercise is inside the `Country-Api` directory as a standalone Maven project.

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
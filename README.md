## Usage Instructions
1. In the `src` folder *packages* are created for respective topics like *DSA*, *Design Patterns*, *TDD*, *Mockito*, *Logging*, *Spring Core & Maven*, *PL/SQL* etc.  
2. Inside those packages files such as *Exercise1.java*, *Exercise2.java* are created where solutions of each individual exercise is present.  
3. A corresponding markdown file such as *Exercise1.md* outlines all the theory.
4. The **Spring Data JPA with Spring Boot & Hibernate** exercise is inside the `orm-learn` directory as a standalone Maven project.

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
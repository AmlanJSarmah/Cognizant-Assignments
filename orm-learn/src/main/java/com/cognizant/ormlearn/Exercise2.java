package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

@SpringBootApplication
public class Exercise2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Exercise2.class);
    private static EmployeeRepository employeeRepository;
    private static EntityManager entityManager;

    // Hibernate native approach
    private static Integer addEmployeeHibernate(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = null;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(employee);
            tx.commit();
            LOGGER.debug("Hibernate: saved employee with id={}", id);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            LOGGER.error("Hibernate error", e);
        } finally {
            session.close();
        }
        return id;
    }

    // Spring Data JPA approach
    @Transactional
    private static void addEmployeeSpringData(Employee employee) {
        employeeRepository.save(employee);
        LOGGER.debug("Spring Data JPA: saved employee with id={}", employee.getId());
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Exercise2.class, args);
        employeeRepository = context.getBean(EmployeeRepository.class);
        entityManager = context.getBean(EntityManager.class);

        LOGGER.info("=== Hibernate Native Approach ===");
        Employee emp1 = new Employee();
        emp1.setName("Charlie");
        emp1.setSalary(70000.0);
        addEmployeeHibernate(emp1);

        LOGGER.info("=== Spring Data JPA Approach ===");
        Employee emp2 = new Employee();
        emp2.setName("Diana");
        emp2.setSalary(80000.0);
        addEmployeeSpringData(emp2);

        LOGGER.info("All employees:");
        employeeRepository.findAll().forEach(e -> LOGGER.debug("{}", e));

        ((org.springframework.context.ConfigurableApplicationContext) context).close();
    }
}

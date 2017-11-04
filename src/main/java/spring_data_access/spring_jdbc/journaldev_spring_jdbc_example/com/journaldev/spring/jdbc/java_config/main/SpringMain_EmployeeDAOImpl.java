package spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.java_config.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.java_config.dao.EmployeeDAO;
import spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.java_config.dao.EmployeeDAOImpl;
import spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.java_config.model.Employee2;

import java.util.List;
import java.util.Random;

public class SpringMain_EmployeeDAOImpl {
    public static void main(String[] args) {
        //Get the Spring Context
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        EmployeeDAO employeeDAO = ctx.getBean(EmployeeDAOImpl.class);

        //Run some tests for JDBC CRUD operations
        Employee2 emp = new Employee2();
        int rand = new Random().nextInt(1000);
        emp.setId(rand);
        emp.setNameE("Pankaj");
        emp.setRole("Java DeveloperProselyte");

        //Create
        employeeDAO.save(emp);

        //Read
        Employee2 emp1 = employeeDAO.getById(rand);
        System.out.println("Employee2 Retrieved::"+emp1);

        //Update
        emp.setRole("CEO");
        employeeDAO.update(emp);

        //Get All
        List<Employee2> empList = employeeDAO.getAll();
        System.out.println(empList);

        //Delete
        employeeDAO.deleteById(rand);


        System.out.println("DONE");
    }

}


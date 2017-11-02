package spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.xml.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.xml.dao.EmployeeDAO;
import spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.xml.model.Employee2;


import java.util.List;
import java.util.Random;

public class SpringMain {

	public static void main(String[] args) {
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Data-Access/SpringJDBC/journaldev_spring-jdbc-example/spring.xml");
		
		//Get the EmployeeDAO Bean
		//EmployeeDAO employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);
		//To use JdbcTemplate
		EmployeeDAO employeeDAO = ctx.getBean("employeeDAOJDBCTemplate", EmployeeDAO.class);
		
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
		
		//Close Spring Context
		ctx.close();
		
		System.out.println("DONE");
	}

}

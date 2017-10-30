package spring_data_access.spring_jdbc.head_01.topjava_tutorial.java_config;


import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_data_access.spring_jdbc.head_01.topjava_tutorial.java_config.dao.EmployeeDAO;

public class App {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                SpringJDBCConfiguration.class);

        EmployeeDAO empDAO = applicationContext.getBean(EmployeeDAO.class);

        String empName = empDAO.getEmployeeName(1);

        System.out.println("Employee name is " + empName);

        applicationContext.close();
    }
}

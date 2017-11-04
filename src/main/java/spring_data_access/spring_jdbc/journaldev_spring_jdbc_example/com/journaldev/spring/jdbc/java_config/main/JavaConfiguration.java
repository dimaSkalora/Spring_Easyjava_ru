package spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.java_config.main;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.java_config.dao.EmployeeDAOImpl;
import spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.java_config.dao.EmployeeDAOJDBCTemplateImpl;

import javax.sql.DataSource;


public class JavaConfiguration {
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_easyjava");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    @Bean
    public EmployeeDAOImpl employeeDAO(){
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        employeeDAO.setDataSource(getDataSource());

        return employeeDAO;
    }

    @Bean
    public EmployeeDAOJDBCTemplateImpl employeeDAOJDBCTemplate(){
        EmployeeDAOJDBCTemplateImpl employeeDAOJDBCTemplate = new EmployeeDAOJDBCTemplateImpl();
        employeeDAOJDBCTemplate.setDataSource(getDataSource());

        return employeeDAOJDBCTemplate;
    }

}

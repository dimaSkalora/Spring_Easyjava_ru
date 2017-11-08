package spring_data_access.spring_jdbc.w3ii_com_jdbc_example.com.tutorialspoint.java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import spring_data_access.spring_jdbc.w3ii_com_jdbc_example.com.tutorialspoint.java_config.dao.StudentJDBCTemplate;

import javax.sql.DataSource;

public class JavaConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_easyjava");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    @Bean
    public StudentJDBCTemplate studentJDBCTemplate(){
        StudentJDBCTemplate studentJDBCTemplate = new StudentJDBCTemplate();
        studentJDBCTemplate.setDataSource(dataSource());
        return studentJDBCTemplate;
    }
}

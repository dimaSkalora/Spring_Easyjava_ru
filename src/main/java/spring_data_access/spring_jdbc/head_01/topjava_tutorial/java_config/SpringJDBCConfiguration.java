package spring_data_access.spring_jdbc.head_01.topjava_tutorial.java_config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import spring_data_access.spring_jdbc.head_01.topjava_tutorial.java_config.dao.EmployeeDAO;
import spring_data_access.spring_jdbc.head_01.topjava_tutorial.java_config.dao.EmployeeDAOImpl;

import javax.sql.DataSource;

@Configuration
public class SpringJDBCConfiguration {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //MySQL database we are using
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_easyjava");//change url
        dataSource.setUsername("root");//change userid
        dataSource.setPassword("root");//change pwd

        //H2 database
        /*
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");*/
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public EmployeeDAO employeeDAO(){
        EmployeeDAOImpl empDao = new EmployeeDAOImpl();
        empDao.setJdbcTemplate(jdbcTemplate());
        return empDao;
    }

}

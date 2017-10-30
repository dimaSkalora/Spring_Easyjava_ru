package spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.java_config.dao.GreeterDaoImpl;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.java_config.service.DBInitServiceImpl;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.java_config.service.GreeterImpl;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //MySQL database we are using
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_easyjava");//change url
        dataSource.setUsername("root");//change userid
        dataSource.setPassword("root");//change pwd

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public GreeterDaoImpl greeterDao(){
        return new GreeterDaoImpl(jdbcTemplate());
    }

    @Bean
    public DBInitServiceImpl dbInitService(){
        return new DBInitServiceImpl(jdbcTemplate());
    }

    @Bean
    public GreeterImpl greeter(){
        return new GreeterImpl(greeterDao());
    }

}

package spring_data_access_test.spring_jdbc_test.head_01_test.spring_data_jdbc_hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.annotations.service.DBInitService;

import javax.inject.Inject;

@ContextConfiguration("/Spring-Data-Access/SpringJDBC/Head_01/spring-data-jdbc-hello/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DBInitServiceImplTest {
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Inject
    private DBInitService testDbObject;

    @Test
    public void testInitialize(){
        testDbObject.initializeDatabase();
        jdbcTemplate.execute("SELECT GREETING_ FROM EXAMPLE");
    }

}

package spring_data_access_test.spring_jdbc_test.head_01_test.spring_data_jdbc_hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.annotations.dao.GreeterDao;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.annotations.service.DBInitService;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@ContextConfiguration("/Spring-Data-Access/SpringJDBC/Head_01/spring-data-jdbc-hello/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GreeterDaoImplTest {
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Inject
    private DBInitService testDbObject;

    @Inject
    private GreeterDao greeterDao;

    @Test
    public void testInitialize(){
        //testDbObject.initializeDatabase();
        greeterDao.addGreet("Test","TEST");

        List<Map<String,Object>> actual = greeterDao.getGreetings();
        Iterator<Map<String,Object>> it = actual.iterator();
        Map<String, Object> row = it.next();
        assertThat(row.get("GREETING_"), is("Test"));
        assertThat(row.get("TARGET_"), is("TEST"));
        System.out.println(row.get("GREETING_"));
        System.out.println(row.get("TARGET_"));
    }
}

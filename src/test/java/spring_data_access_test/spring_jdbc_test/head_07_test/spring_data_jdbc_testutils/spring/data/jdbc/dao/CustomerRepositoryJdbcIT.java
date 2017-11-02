package spring_data_access_test.spring_jdbc_test.head_07_test.spring_data_jdbc_testutils.spring.data.jdbc.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import spring_data_access.spring_jdbc.head_07.spring_data_jdbc_testutils.spring.data.jdbc.dao.CustomerRepositoryJdbc;

import javax.inject.Inject;
import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration("/Spring-Data-Access/SpringJDBC/Head_07/spring-data-jdbc-testutils/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerRepositoryJdbcIT {
    @Inject
    private DataSource dataSource;

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Inject
    private CustomerRepositoryJdbc testedObject;

    @Before
    public void setUp() {
        ResourceDatabasePopulator tables = new ResourceDatabasePopulator();
        tables.addScript(new ClassPathResource("/customers-table.sql"));
        tables.addScript(new ClassPathResource("/customers-data.sql"));

        DatabasePopulatorUtils.execute(tables, dataSource);
    }

    @After
    public void tearDown() {
        JdbcTestUtils.dropTables(jdbcTemplate, "customers");
    }

    @Test
    public void testGetEmail() {
        assertThat(testedObject.getEmail(100L), is("TEST"));
    }

    @Test
    public void testAllEmails() {
        assertThat(testedObject.allEmails(), hasItem("TEST"));
    }

    @Test
    public void testAll() {
        //assertTrue(testedObject.all().stream().filter(m -> "TEST".equals(m.get("EMAIL"))).findFirst().isPresent());
    }

    @Test
    public void testAdd() {
        Number actual = testedObject.add("new@example.org");

        assertThat(testedObject.getEmail(actual.longValue()), is("new@example.org"));
    }
}
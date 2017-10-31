package spring_data_access_test.spring_jdbc_test.head_04_test.spring_data_jdbc_identity.spring.data.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_data_access.spring_jdbc.head_04.spring_data_jdbc_identity.spring.data.jdbc.dao.CustomerRepositoryJdbc;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ContextConfiguration("/Spring-Data-Access/SpringJDBC/Head_04/spring-data-jdbc-identity/testContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerRepositoryJdbcIT {
    @Inject
    private CustomerRepositoryJdbc testedObject;

    @Test
    public void testAdd() {
        Number id = testedObject.add("new@example.org");

        assertThat(testedObject.getEmail((Long) id), is("new@example.org"));
    }

}
package spring_data_access_test.spring_jdbc_test.head_03_test.spring_data_jdbc_query.spring.data.jdbc.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.dao.OrderRepositoryJdbc;
import spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.entity.Customer;
import spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.entity.Order;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ContextConfiguration("/Spring-Data-Access/SpringJDBC/Head_03/spring-data-jdbc-query/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderRepositoryJdbcIT {
    @Inject
    private OrderRepositoryJdbc testedObject;

    @DirtiesContext
    @Test
    public void testGet() {
        Order actual = testedObject.get(100);
        assertThat(actual.getId(), is(100));
        assertThat(actual.getCustomer().getId(), is(100));
        assertThat(actual.getCustomer().getEmail(), is("TEST"));
    }

    @DirtiesContext
    @Test
    public void testAll() {
        assertThat(testedObject.all().size(), is(7));
    }

    @DirtiesContext
    @Test
    public void testOrderCount() {
        Customer c = new Customer();
        c.setId(2);

        Assert.assertThat(testedObject.ordersForCustomer(c), is(3));
    }
}
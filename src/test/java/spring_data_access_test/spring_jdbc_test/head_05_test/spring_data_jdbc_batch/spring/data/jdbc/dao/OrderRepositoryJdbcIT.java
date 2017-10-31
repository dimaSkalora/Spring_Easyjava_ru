package spring_data_access_test.spring_jdbc_test.head_05_test.spring_data_jdbc_batch.spring.data.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.dao.CustomerRepository;
import spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.dao.OrderRepositoryJdbc;
import spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.entity.Customer;
import spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.entity.Order;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@ContextConfiguration("/Spring-Data-Access/SpringJDBC/Head_05/spring-data-jdbc-batch/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderRepositoryJdbcIT {
    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private OrderRepositoryJdbc testedObject;

    @DirtiesContext
    @Test
    public void testGet() {
        Collection<Order> actual = new ArrayList<>();
        for (Customer c : customerRepository.all()) {
            for (int i=0; i<50; i++) {
                Order o = new Order();
                o.setId(c.getId()*1000+i);
                o.setCustomer(c);
                actual.add(o);
            }
        }

        testedObject.add(actual);

        assertThat(testedObject.get(100000).getCustomer().getId(), is(100));
    }
}
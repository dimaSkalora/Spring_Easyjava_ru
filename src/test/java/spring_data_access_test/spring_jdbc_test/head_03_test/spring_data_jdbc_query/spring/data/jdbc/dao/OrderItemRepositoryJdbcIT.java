package spring_data_access_test.spring_jdbc_test.head_03_test.spring_data_jdbc_query.spring.data.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.dao.OrderItemRepositoryJdbc;
import spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.dao.OrderRepository;
import spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.entity.Order;

import javax.inject.Inject;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@ContextConfiguration("/Spring-Data-Access/SpringJDBC/Head_03/spring-data-jdbc-query/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemRepositoryJdbcIT {
    @Inject
    private OrderRepository orderRepository;

    @Inject
    private OrderItemRepositoryJdbc testedObject;

    @DirtiesContext
    @Test
    public void testItemsCount() {
        Order o = orderRepository.get(2);
        assertThat(testedObject.itemsInOrder(o), is(6));
    }
}
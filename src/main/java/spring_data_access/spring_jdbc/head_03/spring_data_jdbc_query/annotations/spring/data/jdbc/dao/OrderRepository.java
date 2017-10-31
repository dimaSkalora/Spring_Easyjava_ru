package spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.dao;

import spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.entity.Customer;
import spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.entity.Order;

import java.util.Collection;

/**
 * Order database layer.
 */
public interface OrderRepository {
    /**
     * Loads order from the database by it's id.
     * @param id id of order to load.
     * @return Loaded object or null.
     */
    Order get(Integer id);

    /**
     * Loads all orders from the database.
     * @return Collection of order.
     */
    Collection<Order> all();

    /**
     * Calculates, how many orders customer have.
     * @param c customer to query.
     * @return Quantity of customer's orders.
     */
    Number ordersForCustomer(Customer c);
}

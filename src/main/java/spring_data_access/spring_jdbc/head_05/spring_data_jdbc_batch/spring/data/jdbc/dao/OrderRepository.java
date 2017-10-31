package spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.dao;

import spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.entity.Order;

import java.util.Collection;

/**
 * Order database layer.
 */
public interface OrderRepository {
    /**
     * Adds new orders.
     * @param orders data to add.
     */
    void add(Collection<Order> orders);

    /**
     * Loads order from the database by it's id.
     * @param id id of order to load.
     * @return Loaded object or null.
     */
    Order get(Integer id);
}

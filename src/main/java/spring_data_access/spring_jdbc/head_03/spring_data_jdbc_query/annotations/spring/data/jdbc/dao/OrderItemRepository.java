package spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.dao;

import spring_data_access.spring_jdbc.head_03.spring_data_jdbc_query.annotations.spring.data.jdbc.entity.Order;

/**
 * OrderItem database layer.
 */
public interface OrderItemRepository {
    /**
     * Counts total quantity of items in specific order.
     * @param o Order to query.
     * @return Number of items.
     */
    Number itemsInOrder(Order o);
}

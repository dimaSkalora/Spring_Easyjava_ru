package spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.dao;

import spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.entity.Customer;

import java.util.List;

/**
 * Customer database layer.
 */
public interface CustomerRepository {
    /**
     * Creates several customers in a batch.
     * @param data data to add.
     */
    void add(List<Customer> data);

    /**
     * Retrieves all the customer data from the database.
     * @return Collection of key-value customers data.
     */
    List<Customer> all();
}

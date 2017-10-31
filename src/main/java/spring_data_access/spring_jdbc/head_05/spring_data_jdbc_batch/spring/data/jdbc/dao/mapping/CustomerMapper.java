package spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.dao.mapping;


import org.springframework.jdbc.core.RowMapper;
import spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper for Customer entity.
 */
public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public final Customer mapRow(final ResultSet resultSet, final int i)
            throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getInt("id"));
        customer.setEmail(resultSet.getString("email"));
        return customer;
    }
}

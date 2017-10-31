package spring_data_access.spring_jdbc.head_04.spring_data_jdbc_identity.spring.data.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC implementation of CustomerRepository.
 */
@Repository
public class CustomerRepositoryJdbc implements CustomerRepository {
    /**
     * Email retrieval query.
     */
    private static final String EMAIL_QUERY
            = "SELECT EMAIL FROM CUSTOMERS WHERE ID=?";

    /**
     * Customer creation query.
     */
    private static final String CREATE_QUERY
            = "INSERT INTO CUSTOMERS (EMAIL) VALUES(?)";

    /**
     * Database connection.
     */
    @Inject
    private JdbcTemplate jdbcTemplate;

    /**
     * PSC for customer creation query.
     */
    private static class CreationStatement implements PreparedStatementCreator {

        /**
         * We keep e-mail here to use it during callback.
         */
        private String email;

        /**
         * Obviously a constructor.
         * @param e email of newly created user.
         */
        public CreationStatement(final String e) {
            this.email = e;
        }

        @Override
        public final PreparedStatement createPreparedStatement(
                final Connection con) throws SQLException {
            PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
            ps.setString(1, email);
            return ps;
        }
    }

    @Override
    public final Number add(final String email) {
        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(new CreationStatement(email), key);
        return key.getKey();
    }

    @Override
    public final String getEmail(final Long id) {
        return jdbcTemplate.queryForObject(EMAIL_QUERY, String.class, id);
    }
}

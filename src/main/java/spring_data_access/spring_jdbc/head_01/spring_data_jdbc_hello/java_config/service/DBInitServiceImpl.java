package spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.java_config.service;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Database preparation service implementation.
 */
public class DBInitServiceImpl implements DBInitService {
    /**
     * Query that create table.
     */
    private static final String CREATE_QUERY =
            "CREATE TABLE EXAMPLE (GREETING VARCHAR(6), TARGET VARCHAR(6))";

    /**
     * Our data layer.
     */
    private JdbcTemplate jdbcTemplate;

    public DBInitServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public final void initializeDatabase() {
        jdbcTemplate.execute(CREATE_QUERY);
    }
}
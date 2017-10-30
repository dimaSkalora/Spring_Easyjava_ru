package spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.java_config.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * JDBC based implementation of GreeterDao.
 */
public class GreeterDaoImpl implements GreeterDao {
    /**
     * Query that populates table with data.
     */
    private static final String DATA_QUERY =
            "INSERT INTO EXAMPLE VALUES(?, ?)";

    /**
     * Query that extracts data from table.
     */
    private static final String GREET_QUERY =
            "SELECT GREETING_, TARGET_ FROM EXAMPLE";

    /**
     * Our data layer.
     */
     private JdbcTemplate jdbcTemplate;

    public GreeterDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public final void addGreet(final String greeting, final String target) {
        jdbcTemplate.update(DATA_QUERY, greeting, target);
    }

    @Override
    public final List<Map<String, Object>> getGreetings() {
        return jdbcTemplate.queryForList(GREET_QUERY);
    }
}

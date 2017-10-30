package spring_data_access.spring_jdbc.head_02.easyjava.spring.data.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * JDBC based implementation of GreeterDao.
 */
@Repository
public class GreeterDaoImpl implements GreeterDao {
    /**
     * Query that extracts data from table.
     */
    private static final String GREET_QUERY =
            "SELECT GREETING, TARGET FROM EXAMPLE";

    /**
     * H2 database.
     */
    @Inject
    private JdbcTemplate h2Template;

    /**
     * Derby database.
     */
    @Inject
    private JdbcTemplate derbyTemplate;

    /**
     * HSQLDB database.
     */
    @Inject
    private JdbcTemplate hsqlTemplate;

    @Override
    public final List<Map<String, Object>> getGreetings() {
        List<Map<String, Object>> result = h2Template.queryForList(GREET_QUERY);
        result.addAll(derbyTemplate.queryForList(GREET_QUERY));
        result.addAll(hsqlTemplate.queryForList(GREET_QUERY));

        return result;
    }
}

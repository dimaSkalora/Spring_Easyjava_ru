package spring_data_access.spring_jdbc.head_06.spring_data_jdbc_exception.spring.data.jdbc.dao;

import org.springframework.dao.NonTransientDataAccessException;

/**
 * Custom DataAccessException which should be thrown
 * when fail_me SQL procedure is called.
 */
public class FailingFunctionCallException
        extends NonTransientDataAccessException {
    /**
     * Obviously a constructor.
     * @param msg Error message.
     */
    public FailingFunctionCallException(final String msg) {
        super(msg);
    }
}

package spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.service;

/**
 * Database preparation service.
 */
public interface DBInitService {
    /**
     * Creates tables in the database.
     */
    void initializeDatabase();
}

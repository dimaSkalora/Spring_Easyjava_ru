package spring_data_access.spring_jdbc.head_04.spring_data_jdbc_identity.spring.data.jdbc.dao;

/**
 * Customer database layer.
 */
public interface CustomerRepository {
    /**
     * Creates new customer using only e-mail value.
     * @param email New customer's e-mail.
     * @return Id of generated entity.
     */
    Number add(String email);

    /**
     * Gets customer's email by it's id.
     * @param id id to query.
     * @return email value or null.
     */
    String getEmail(Long id);
}


package spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.entity;

/**
 * Customer entity.
 */

public class Customer {
    /**
     * ID field.
     */
    private Integer id;

    /**
     * EMAIL field.
     */
    private String email;

    public Customer() {
    }

    public Customer(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

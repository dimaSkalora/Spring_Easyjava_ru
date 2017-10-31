package spring_data_access.spring_jdbc.head_05.spring_data_jdbc_batch.spring.data.jdbc.entity;

/**
 * Order entity.
 */
public class Order {
    /**
     * ID field.
     */
    private Integer id;

    /**
     * CUSTOMER field.
     */
    private Customer customer;

    public Order() {
    }

    public Order(Integer id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

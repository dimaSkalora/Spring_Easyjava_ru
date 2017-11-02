package spring_data_access.spring_jdbc.head_07.spring_data_jdbc_testutils.spring.data.jdbc.entity;

/**
 * SKU entity.
**/
public class Sku {
    /**
     * ID field.
     */
    private Integer id;
    /**
     * DESCRIPTION field.
     */
    private String description;

    public Sku() {
    }

    public Sku(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

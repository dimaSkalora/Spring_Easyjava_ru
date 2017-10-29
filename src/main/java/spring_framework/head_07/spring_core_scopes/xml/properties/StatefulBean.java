package spring_framework.head_07.spring_core_scopes.xml.properties;

/**
 * Simple stateful bean.
 */
public interface StatefulBean {
    /**
     * Gets bean state.
     * @return state value.
     */
    String getState();

    /**
     * Sets bean state.
     * @param state new state value.
     */
    void setState(String state);
}

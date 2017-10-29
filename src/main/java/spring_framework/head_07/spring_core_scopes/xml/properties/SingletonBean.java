package spring_framework.head_07.spring_core_scopes.xml.properties;

/**
 * Example of default scope bean (Singleton).
 */
public class SingletonBean implements StatefulBean {
    /**
     * Some state.
     */
    private String state;

    /**
     * Initial state is set here.
     */
    public final void init() {
        this.state = "Initial state";
    }

    @Override
    public final String getState() {
        return state;
    }

    @Override
    public final void setState(final String s) {
        this.state = s;
    }
}

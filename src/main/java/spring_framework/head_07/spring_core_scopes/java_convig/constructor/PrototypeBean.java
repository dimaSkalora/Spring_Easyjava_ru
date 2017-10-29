package spring_framework.head_07.spring_core_scopes.java_convig.constructor;


/**
 * Example of custom scope bean (Prototype).
 */
public class PrototypeBean implements StatefulBean {
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

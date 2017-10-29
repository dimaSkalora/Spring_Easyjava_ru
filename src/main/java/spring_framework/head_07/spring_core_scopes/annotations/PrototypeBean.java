package spring_framework.head_07.spring_core_scopes.annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Example of custom scope bean (Prototype).
 */
@Service
@Scope(value = "prototype")
public class PrototypeBean implements StatefulBean {
    /**
     * Some state.
     */
    private String state;

    /**
     * Initial state is set here.
     */
    @PostConstruct
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

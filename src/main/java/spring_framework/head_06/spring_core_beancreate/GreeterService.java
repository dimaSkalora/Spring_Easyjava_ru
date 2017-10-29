package spring_framework.head_06.spring_core_beancreate;

import javax.inject.Inject;

/**
 * Sample class to be used as manually created bean.
 */
public class GreeterService {
    /**
     * We need something to be injected for test purposes.
     */
    @Inject
    private TargetService target;

    /**
     * Uses injected object.
     * @return greeting string.
     */
    public final String greet() {
        return "Hello " + target.getTarget() + "!";
    }
}

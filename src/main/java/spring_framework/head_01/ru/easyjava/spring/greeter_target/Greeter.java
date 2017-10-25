package spring_framework.head_01.ru.easyjava.spring.greeter_target;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Greeting service.
 */
@Service
public class Greeter {
    /**
     * Here we ask, who we are greeting.
     */
    private  GreeterTarget target;

    /**
     * Simple constructor.
     * @param newTarget Greeter target selector to use.
     */
    @Inject
    public Greeter(final GreeterTarget newTarget) {
        this.target = newTarget;
    }

    /**
     * Generates greeting.
     * @return "Hello-style" string.
     */
    public final String greet() {
        return "Hello " + target.get();
    }
}

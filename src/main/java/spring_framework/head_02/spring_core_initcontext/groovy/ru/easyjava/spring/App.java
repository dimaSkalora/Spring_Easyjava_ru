package spring_framework.head_02.spring_core_initcontext.groovy.ru.easyjava.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * Application main class.
 */
public final class App {
    /**
     * Do not construct me.
     */
    private App() { };

    /**
     * Application entry point.
     * @param args Array of command line arguments.
     */
    public static void main(final String[] args) {
        ApplicationContext context =
          new GenericGroovyApplicationContext("Spring-framework/Head_02/Spring-Core-InitContext/groovy/applicationContext.groovy");
        Greeter greeter = context.getBean(Greeter.class);

        System.out.println(greeter.greet());
    }
}

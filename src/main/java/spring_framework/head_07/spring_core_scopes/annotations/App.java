package spring_framework.head_07.spring_core_scopes.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context
        .annotation.AnnotationConfigApplicationContext;

/**
 * Application main class.
 */
public final class App {
    /**
     * Do not construct me.
     */
    private App() { }

    /**
     * Application entry point.
     * @param args Array of command line arguments.
     */
    public static void main(final String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("spring_framework.head_07.spring_core_scopes");

        FirstConsumer firstConsumer = context.getBean(FirstConsumer.class);
        SecondConsumer secondConsumer = context.getBean(SecondConsumer.class);

        firstConsumer.processState();
        secondConsumer.processState();
        firstConsumer.processState();
    }
}

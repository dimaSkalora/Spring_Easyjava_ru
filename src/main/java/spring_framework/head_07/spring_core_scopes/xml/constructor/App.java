package spring_framework.head_07.spring_core_scopes.xml.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
               new ClassPathXmlApplicationContext(
                       "Spring-framework/spring-core-scopes/Constructor/applicationContext.xml");

        FirstConsumer firstConsumer = (FirstConsumer) context.getBean("firstConsumer");
        SecondConsumer secondConsumer = (SecondConsumer) context.getBean("secondConsumer");

        firstConsumer.processState();
        secondConsumer.processState();
        firstConsumer.processState();
    }
}

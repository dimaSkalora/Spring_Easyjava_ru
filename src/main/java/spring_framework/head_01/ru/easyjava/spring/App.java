package spring_framework.head_01.ru.easyjava.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_framework.head_01.ru.easyjava.spring.greeter_target.Greeter;

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
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        Greeter greeter = context.getBean(Greeter.class);

        System.out.println(greeter.greet());
    }
}

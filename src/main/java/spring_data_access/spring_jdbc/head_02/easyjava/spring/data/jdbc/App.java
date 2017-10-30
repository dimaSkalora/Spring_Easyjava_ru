package spring_data_access.spring_jdbc.head_02.easyjava.spring.data.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easyjava.spring.data.jdbc.service.Greeter;

/**
 * Simple example of JDBC usage.
 */
public final class App {
    /**
     * Do not construct me.
     */
    private App() {
    }

    /**
     * Entry point.
     *
     * @param args Command line args. Not used.
     */
    public static void main(final String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("/applicationContext.xml");
        Greeter greeter = context.getBean(Greeter.class);

        System.out.println(greeter.greet());
    }
}

package spring_framework.head_02.spring_core_initcontext.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_framework.head_02.spring_core_initcontext.xml.greeter.Greeter;

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
                new ClassPathXmlApplicationContext("Spring-framework/Head_02/Spring-Core-InitContext/xml/applicationContext.xml");
        Greeter greeter = context.getBean(Greeter.class);

        System.out.println(greeter.greet());
    }
}

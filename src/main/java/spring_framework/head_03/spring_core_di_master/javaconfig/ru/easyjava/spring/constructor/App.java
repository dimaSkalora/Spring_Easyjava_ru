package spring_framework.head_03.spring_core_di_master.javaconfig.ru.easyjava.spring.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class App {

    private App() { };

    /**
     * Application entry point.
     * @param args Array of command line arguments.
     */
    public static void main(final String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        DependentService dependent = context.getBean(DependentService.class);

        System.out.println(dependent.process());
    }
}

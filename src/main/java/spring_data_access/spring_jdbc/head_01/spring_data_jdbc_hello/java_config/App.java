package spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.java_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.java_config.dao.GreeterDao;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.java_config.service.DBInitService;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.java_config.service.Greeter;

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
              new AnnotationConfigApplicationContext(AppConfiguration.class);
        Greeter greeter = context.getBean(Greeter.class);
        GreeterDao dao = context.getBean(GreeterDao.class);
        DBInitService init = context.getBean(DBInitService.class);

        //init.initializeDatabase();

        dao.addGreet("Hello", "World");

        System.out.println(greeter.greet());
    }
}

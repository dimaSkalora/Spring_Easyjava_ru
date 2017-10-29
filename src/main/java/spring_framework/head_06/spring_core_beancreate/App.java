package spring_framework.head_06.spring_core_beancreate;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
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
                new AnnotationConfigApplicationContext("spring_framework.head_06.spring_core_beancreate");

        AutowireCapableBeanFactory bf = context.getAutowireCapableBeanFactory();
        GreeterService greeterBean = bf.createBean(GreeterService.class);

        System.out.println(greeterBean.greet());

    }
}

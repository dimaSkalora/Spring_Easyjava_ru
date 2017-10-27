package spring_framework.head_05.spring_core_lifecycle.dependency.init.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_framework.head_05.spring_core_lifecycle.dependency.init.DependencyWithConfig;

public class ApplicationContext_WithConfig {
    public static void main(final String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-framework/Head_05/spring-core-lifecycle/applicationContext.xml");
        DependencyWithConfig dependency =(DependencyWithConfig)context.getBean("dependencyWithConfig");
    }
}

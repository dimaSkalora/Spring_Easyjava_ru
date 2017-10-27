package spring_framework.head_05.spring_core_lifecycle.dependency.init.java_config.dependency_with_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_framework.head_05.spring_core_lifecycle.dependency.init.DependencyWithConfig;

public class ApplicationContext_InitWithAnnotation {
    public static void main(final String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration_DependencyWithConfig.class);
        DependencyWithConfig dependency = context.getBean(DependencyWithConfig.class);
        dependency.callService();
    }
}

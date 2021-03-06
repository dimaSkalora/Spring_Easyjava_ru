package spring_framework.head_03.spring_core_di_master.xml.ru.easyjava.spring.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class App {

    private App() { };

    public static void main(final String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "Spring-framework/Head_03/spring-core-di-master/properties/applicationContextConstructor.xml");
        DependentService dependent = context.getBean(DependentService.class);

        System.out.println(dependent.process());
    }
}

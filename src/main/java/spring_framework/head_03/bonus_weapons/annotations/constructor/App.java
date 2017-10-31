package spring_framework.head_03.bonus_weapons.annotations.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("spring_framework.head_03.bonus_weapons.annotations.constructor");
        DependentService dependentService = context.getBean(DependentService.class);
        dependentService.areLocated();
    }
}

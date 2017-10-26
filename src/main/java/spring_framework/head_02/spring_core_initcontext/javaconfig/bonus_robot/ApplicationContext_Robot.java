package spring_framework.head_02.spring_core_initcontext.javaconfig.bonus_robot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_framework.head_02.spring_core_initcontext.javaconfig.bonus_robot.robot.ModelT800;

public class ApplicationContext_Robot {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfigurationRobot.class);
        ModelT800 robot_modelT800 = context.getBean(ModelT800.class);
        robot_modelT800.action();
    }
}

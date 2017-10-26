package spring_framework.head_02.spring_core_initcontext.xml.bonus_robot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_framework.head_02.spring_core_initcontext.xml.bonus_robot.robot.Robot;

public class ApplicationContext_Robot {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-framework/Head_02/Spring-Core-InitContext/xml/Bonus_Robot/bonus_robot.xml");
        Robot robot_modelT800 = (Robot)context.getBean("modelT800");
        robot_modelT800.action();

    }
}

package spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.consumer.MyXMLApplication;

public class ClientXMLApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "Spring-framework/BecomeJavaSenior-com/applicationContext.xml");
        MyXMLApplication app = context.getBean(MyXMLApplication.class);

        app.processMessage("Hi Dmytro", "dmytro@becomejavasenior_com.com");

        // close the context
        context.close();
    }
}

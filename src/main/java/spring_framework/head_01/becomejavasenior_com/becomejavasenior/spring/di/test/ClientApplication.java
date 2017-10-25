package spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.configuration.DIConfiguration;
import spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.consumer.MyApplication;

public class ClientApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApplication app = context.getBean(MyApplication.class);

        app.processMessage("Hi Dmytro", "dmytro@becomejavasenior_com.com");

        //close the context
        context.close();
    }
}

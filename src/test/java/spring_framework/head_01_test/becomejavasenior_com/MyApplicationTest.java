package spring_framework.head_01_test.becomejavasenior_com;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.consumer.MyApplication;
import spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.services.MessageService;

@Configuration
@ComponentScan(value= "spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.consumer")
public class MyApplicationTest {

    private AnnotationConfigApplicationContext context = null;

    @Bean
    public MessageService getMessageService() {
        return new MessageService(){

            public boolean sendMessage(String msg, String rec) {
                System.out.println("Mock Service");
                return true;
            }

        };
    }

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(MyApplicationTest.class);
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }

    @Test
    public void test() {
        MyApplication app = context.getBean(MyApplication.class);
        Assert.assertTrue(app.processMessage("Hi Dmytro", "dmytro@becomejavasenior_com.com"));
    }
}

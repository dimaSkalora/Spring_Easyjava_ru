package spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.services.EmailService;
import spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.services.MessageService;

@Configuration
@ComponentScan(value={"spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.consumer"})
public class DIConfiguration {
    @Bean
    public MessageService getMessageService(){
        return new EmailService();
    }
}

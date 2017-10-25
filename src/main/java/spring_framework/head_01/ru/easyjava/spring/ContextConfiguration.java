package spring_framework.head_01.ru.easyjava.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * Spring context configuration descriptor.
 */
@Configuration
@ComponentScan("spring_framework.head_01.ru.easyjava.spring")
public class ContextConfiguration {
    /**
     * "Random" service bean.
     * @return Java's built-in random generator.
     */
    @Bean
    public Random random() {
        return new Random();
    }
}

package spring_framework.head_02.spring_core_initcontext.javaconfig.ru.easyjava.spring;

import org.springframework.context.annotation.Bean;
import spring_framework.head_02.spring_core_initcontext.javaconfig.ru.easyjava.spring.coin.Coin;
import spring_framework.head_02.spring_core_initcontext.javaconfig.ru.easyjava.spring.coin.CoinImpl;
import spring_framework.head_02.spring_core_initcontext.javaconfig.ru.easyjava.spring.greeter.Greeter;
import spring_framework.head_02.spring_core_initcontext.javaconfig.ru.easyjava.spring.greeter.GreeterTarget;
import spring_framework.head_02.spring_core_initcontext.javaconfig.ru.easyjava.spring.greeter.GreeterTargetImpl;

import java.util.Random;

/**
 * Spring context configuration descriptor.
 */
public class ContextConfiguration {
    /**
     * "Random" service bean.
     * @return Java's built-in random generator.
     */
    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public Coin coin() {
        return new CoinImpl(random());
    }

    @Bean
    public GreeterTarget greeterTarget() {
        return new GreeterTargetImpl(coin());
    }

    @Bean
    public Greeter greeter() {
        return new Greeter(greeterTarget());
    }
}

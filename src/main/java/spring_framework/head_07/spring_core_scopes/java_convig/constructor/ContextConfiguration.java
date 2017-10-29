package spring_framework.head_07.spring_core_scopes.java_convig.constructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * Spring context configuration descriptor.
 */
public class ContextConfiguration {
    /**
     * Prototype bean
     * @return Prototype bean instance
     */
    @Bean
    @Scope("prototype")
    public StatefulBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    public  StatefulBean singletonBean(){
        return new SingletonBean();
    }

    @Bean
    public FirstConsumer firstConsumer(){
        return new FirstConsumer(singletonBean(),prototypeBean());
    }

    @Bean
    public SecondConsumer secondConsumer(){
        return new SecondConsumer(singletonBean(),prototypeBean());
    }
}

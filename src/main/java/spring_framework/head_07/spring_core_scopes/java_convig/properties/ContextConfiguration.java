package spring_framework.head_07.spring_core_scopes.java_convig.properties;

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
    public StatefulBean singletonBean(){
        return new SingletonBean();
    }

    @Bean
    public FirstConsumer firstConsumer(){
       FirstConsumer firstConsumer = new FirstConsumer();
       firstConsumer.setSingletonBean(singletonBean());
       firstConsumer.setPrototypeBean(prototypeBean());
       return firstConsumer;
    }

    @Bean
    public SecondConsumer secondConsumer(){
        SecondConsumer secondConsumer = new SecondConsumer();
        secondConsumer.setSingletonBean(singletonBean());
        secondConsumer.setPrototypeBean(prototypeBean());
        return secondConsumer;
    }
}

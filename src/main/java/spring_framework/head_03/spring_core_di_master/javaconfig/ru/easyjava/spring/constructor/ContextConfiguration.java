package spring_framework.head_03.spring_core_di_master.javaconfig.ru.easyjava.spring.constructor;

import org.springframework.context.annotation.Bean;

public class ContextConfiguration {
    @Bean
    public BaseRepository baseRepository(){
        return new BaseRepository();
    }

    @Bean
    public BaseService baseService(){
        return new BaseService();
    }

    @Bean
    public DependentService dependentService(){
        return new DependentService(baseRepository(),baseService());
    }
}

package spring_framework.head_03.spring_core_di_master.javaconfig.ru.easyjava.spring.properties;

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
        DependentService dependentService = new DependentService();
        dependentService.setRepository(baseRepository());
        dependentService.setService(baseService());

        return dependentService;
    }
}

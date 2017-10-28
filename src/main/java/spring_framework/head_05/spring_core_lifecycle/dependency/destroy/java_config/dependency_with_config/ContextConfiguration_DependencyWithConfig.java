package spring_framework.head_05.spring_core_lifecycle.dependency.destroy.java_config.dependency_with_config;

import org.springframework.context.annotation.Bean;
import spring_framework.head_05.spring_core_lifecycle.SomeService;
import spring_framework.head_05.spring_core_lifecycle.dependency.destroy.DependencyWithConfig;

public class ContextConfiguration_DependencyWithConfig {
    @Bean
    public SomeService service(){
        return new SomeService();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public DependencyWithConfig dependencyWithConfig(){
        DependencyWithConfig dependencyWithConfig = new DependencyWithConfig();
        return dependencyWithConfig;
    }

}

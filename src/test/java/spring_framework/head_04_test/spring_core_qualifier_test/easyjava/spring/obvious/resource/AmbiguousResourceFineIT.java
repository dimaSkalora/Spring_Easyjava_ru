package spring_framework.head_04_test.spring_core_qualifier_test.easyjava.spring.obvious.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.FineDay;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.HeavyFine;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.qualifier.resource.AmbiguousResourceFine;

import javax.inject.Inject;

import static org.junit.Assert.assertFalse;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AmbiguousResourceFineIT {
    @Inject
    private ApplicationContext context;

    @Configuration
    @ComponentScan("spring_framework.head_04.spring_core_qualifier.easyjava.spring.qualifier.resource")
    public static class SpringConfig {
        @Bean
        public FineDay fineDay() { return new FineDay(); }

        @Bean
        public HeavyFine hardFine() { return new HeavyFine(); }
    }

    @Test
    public void testSpring() {
        AmbiguousResourceFine testedObject = context.getBean(AmbiguousResourceFine.class);

        assertFalse(testedObject.getFine().isEmpty());
    }
}
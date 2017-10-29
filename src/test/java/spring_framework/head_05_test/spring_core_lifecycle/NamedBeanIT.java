package spring_framework.head_05_test.spring_core_lifecycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_framework.head_05.spring_core_lifecycle.dependency.NamedBean;

import javax.inject.Inject;

@ContextConfiguration("/Spring-framework/Head_05/spring-core-lifecycle/NamedBeanContext.groovy")
@RunWith(SpringJUnit4ClassRunner.class)
public class NamedBeanIT {
    @Inject
    private ApplicationContext context;

    @Test
    public void testBeanNames() {
        context.getBeansOfType(NamedBean.class).keySet().forEach(name -> System.out.println("Bean name in context is: " + name));
        context.getBeansOfType(NamedBean.class).values().forEach(bean -> System.out.println("Bean name is: " + bean.getName()));
    }
}

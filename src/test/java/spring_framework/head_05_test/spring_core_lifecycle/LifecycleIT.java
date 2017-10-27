package spring_framework.head_05_test.spring_core_lifecycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_framework.head_05.spring_core_lifecycle.dependency.init.Dependency;
import spring_framework.head_05.spring_core_lifecycle.dependency.init.DependencyInitWithAnnotation;
import spring_framework.head_05.spring_core_lifecycle.dependency.init.DependencyInitWithInterface;
import spring_framework.head_05.spring_core_lifecycle.dependency.init.DependencyWithConfig;

import javax.inject.Inject;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration("/Spring-framework/Head_05/spring-core-lifecycle/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class LifecycleIT {

    @Inject
    private ApplicationContext context;

    @Test
    public void testWithAnnotation() {
        Dependency dep = context.getBean(DependencyInitWithAnnotation.class);

        assertThat(dep.callService(), is("I'm a service"));
    }

    @Test
    public void testWithInterface() {
        Dependency dep = context.getBean(DependencyInitWithInterface.class);

        assertThat(dep.callService(), is("I'm a service"));
    }

    @Test
    public void testWithConfig() {
        Dependency dep = context.getBean(DependencyWithConfig.class);

        assertThat(dep.callService(), is("I'm a service"));
    }
}

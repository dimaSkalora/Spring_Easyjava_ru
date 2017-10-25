package spring_framework.head_01_test.ru.easyjava.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import spring_framework.head_01.ru.easyjava.spring.greeter_target.Greeter;

import javax.inject.Inject;

import static junit.framework.Assert.assertTrue;

@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = spring_framework.head_01.ru.easyjava.spring.ContextConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppIT {

    @Inject
    private ApplicationContext context;

    @Test
    public void testSpring() {
        Greeter greeter = context.getBean(Greeter.class);

        assertTrue(greeter.greet().startsWith("Hello"));
    }
}

package spring_framework.head_02_test.spring_core_initcontext.annotations.ru.easyjava.spring;

import org.junit.Test;
import spring_framework.head_02.spring_core_initcontext.annotations.ru.easyjava.spring.greeter.Greeter;
import spring_framework.head_02.spring_core_initcontext.annotations.ru.easyjava.spring.greeter.GreeterTarget;

import static org.junit.Assert.assertEquals;

public class GreeterTest {
    @Test
    public void testGreet() throws Exception {
        /* Prepare the mock */
        GreeterTarget target = new StubGreeterTarget();

        /* Prepare the Object */
        Greeter testedObject = new Greeter(target);

        /* Test it! */
        assertEquals("Hello TEST", testedObject.greet());
    }
}

package spring_framework.head_01_test.ru.easyjava.spring;

import org.junit.Test;
import spring_framework.head_01.ru.easyjava.spring.greeter_target.Greeter;
import spring_framework.head_01.ru.easyjava.spring.greeter_target.GreeterTarget;
import spring_framework.head_01.ru.easyjava.spring.greeter_target.StubGreeterTarget;

import static junit.framework.TestCase.assertEquals;

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

package spring_framework.head_02_test.spring_core_initcontext.xml;

import org.junit.Test;
import spring_framework.head_02.spring_core_initcontext.xml.greeter.Greeter;
import spring_framework.head_02.spring_core_initcontext.xml.greeter.GreeterTarget;

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

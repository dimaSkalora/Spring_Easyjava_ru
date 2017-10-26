package spring_framework.head_02_test.spring_core_initcontext.annotations.ru.easyjava.spring;

import org.junit.Test;
import spring_framework.head_02.spring_core_initcontext.annotations.ru.easyjava.spring.greeter.GreeterTarget;
import spring_framework.head_02.spring_core_initcontext.annotations.ru.easyjava.spring.greeter.GreeterTargetImpl;

import static junit.framework.Assert.assertEquals;

public class GreeterTargetTest {
    @Test
    public void testGet() throws Exception {
        /* Prepare the mock */
        StubCoin coin = new StubCoin();

        /* Prepare the Object */
        GreeterTarget testedObject = new GreeterTargetImpl(coin);

        /* Test it! */
        coin.setConstantResult(true);
        assertEquals("World", testedObject.get());

        coin.setConstantResult(false);
        assertEquals("Spring", testedObject.get());
    }
}

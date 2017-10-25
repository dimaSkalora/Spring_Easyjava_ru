package spring_framework.head_01_test.ru.easyjava.spring;

import org.junit.Test;
import spring_framework.head_01.ru.easyjava.spring.coin.StubCoin;
import spring_framework.head_01.ru.easyjava.spring.greeter_target.GreeterTarget;
import spring_framework.head_01.ru.easyjava.spring.greeter_target.GreeterTargetImpl;

import static junit.framework.TestCase.assertEquals;

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

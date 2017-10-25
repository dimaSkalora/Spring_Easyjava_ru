package spring_framework.head_01_test.ru.easyjava.spring;

import org.junit.Test;
import spring_framework.head_01.ru.easyjava.spring.StubRandom;
import spring_framework.head_01.ru.easyjava.spring.coin.Coin;
import spring_framework.head_01.ru.easyjava.spring.coin.CoinImpl;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class CoinTest {
    @Test
    public void testToss() throws Exception{
        /** Prepare the mock */
        StubRandom random = new StubRandom();

        /** Prepare the object */
        Coin testedObject = new CoinImpl(random);

        /** Test it! */
        random.setConstantResult(true);
        assertTrue(testedObject.toss());

        random.setConstantResult(false);
        assertFalse(testedObject.toss());
    }
}

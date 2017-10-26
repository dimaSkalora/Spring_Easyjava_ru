package spring_framework.head_02_test.spring_core_initcontext.xml;

import org.junit.Test;
import spring_framework.head_02.spring_core_initcontext.xml.coin.Coin;
import spring_framework.head_02.spring_core_initcontext.xml.coin.CoinImpl;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class CoinTest {
    @Test
    public void testToss() throws Exception {
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

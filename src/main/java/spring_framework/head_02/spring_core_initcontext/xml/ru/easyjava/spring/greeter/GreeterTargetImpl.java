package spring_framework.head_02.spring_core_initcontext.xml.ru.easyjava.spring.greeter;

import spring_framework.head_02.spring_core_initcontext.xml.ru.easyjava.spring.coin.Coin;

/**
 * Simple implementation with
 * hardcoded targets.
 */
public class GreeterTargetImpl implements GreeterTarget {
    /**
     * Coin, we toss to define greeting target.
     */
    private Coin coin;

    /**
     * Simple constructor.
     * @param newCoin Coin, that we will be tossing.
     */
    public GreeterTargetImpl(final Coin newCoin) {
        this.coin = newCoin;
    }

    /**
     * Selects greeting target tossing a coin.
     * @return "World" or "Spring".
     */
    @Override
    public final String get() {
        if (coin.toss()) {
            return "World";
        }
        return "Spring";
    }
}

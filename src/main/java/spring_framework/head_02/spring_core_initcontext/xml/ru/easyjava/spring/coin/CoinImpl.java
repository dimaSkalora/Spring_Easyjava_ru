package spring_framework.head_02.spring_core_initcontext.xml.ru.easyjava.spring.coin;

import java.util.Random;

/**
 * A simple implementation of Coin,
 * based on Random class.
 */
public class CoinImpl implements Coin {
    /**
     * Random data source.
     */
    private Random random;

    /**
     * Simple constructor.
     * @param newRandom Supplied random generator.
     */
    public CoinImpl(final Random newRandom) {
        this.random = newRandom;
    }

    /**
     * Here we toss the coin.
     * @return unpredicted true of false.
     */
    @Override
    public final boolean toss() {
        return random.nextBoolean();
    }
}

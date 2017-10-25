package spring_framework.head_01.ru.easyjava.spring.coin;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Random;

@Service
public class CoinImpl implements Coin{

    /**
     * Random data source.
     */
    private Random random;

    /**
     * Simple constructor.
     * @param newRandom Supplied random generator.
     */
    @Inject
    public CoinImpl(final Random newRandom) {
        this.random = newRandom;
    }

    /**
     * Here we toss the coin.
     * @return unpredicted true of false.
     */
    @Override
    public boolean toss() {
        return random.nextBoolean();
    }
}

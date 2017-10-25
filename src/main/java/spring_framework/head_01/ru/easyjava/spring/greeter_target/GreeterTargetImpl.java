package spring_framework.head_01.ru.easyjava.spring.greeter_target;

import org.springframework.stereotype.Service;
import spring_framework.head_01.ru.easyjava.spring.coin.Coin;

import javax.inject.Inject;

@Service
public class GreeterTargetImpl implements GreeterTarget {
    /**
     * Coin, we toss to define greeting target.
     */
    private Coin coin;

    /**
     * Simple constructor.
     * @param newCoin Coin, that we will be tossing.
     */
    @Inject
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

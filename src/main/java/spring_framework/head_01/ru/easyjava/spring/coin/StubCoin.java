package spring_framework.head_01.ru.easyjava.spring.coin;

public class StubCoin implements Coin {
    private boolean constantResult;

    public final void setConstantResult(final boolean newResult) {
        this.constantResult = newResult;
    }

    @Override
    public boolean toss() {
        return constantResult;
    }
}

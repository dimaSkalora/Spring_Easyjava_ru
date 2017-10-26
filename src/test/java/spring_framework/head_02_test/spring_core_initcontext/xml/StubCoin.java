package spring_framework.head_02_test.spring_core_initcontext.xml;

import spring_framework.head_02.spring_core_initcontext.xml.coin.Coin;

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

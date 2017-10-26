package spring_framework.head_02_test.spring_core_initcontext.xml;

import java.util.Random;

public class StubRandom extends Random {
    private boolean constantResult;

    public final void setConstantResult(final boolean newResult) {
        this.constantResult = newResult;
    }

    @Override
    public boolean nextBoolean() {
        return constantResult;
    }
}

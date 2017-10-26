package spring_framework.head_02_test.spring_core_initcontext.xml;

import spring_framework.head_02.spring_core_initcontext.xml.greeter.GreeterTarget;

public class StubGreeterTarget implements GreeterTarget {
    @Override
    public String get() {
        return "TEST";
    }
}

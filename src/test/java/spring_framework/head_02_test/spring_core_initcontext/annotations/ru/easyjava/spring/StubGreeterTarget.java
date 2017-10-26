package spring_framework.head_02_test.spring_core_initcontext.annotations.ru.easyjava.spring;

import spring_framework.head_02.spring_core_initcontext.annotations.ru.easyjava.spring.greeter.GreeterTarget;

public class StubGreeterTarget implements GreeterTarget {
    @Override
    public String get() {
        return "TEST";
    }
}

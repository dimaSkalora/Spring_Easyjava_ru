package spring_framework.head_01.ru.easyjava.spring.greeter_target;

public class StubGreeterTarget implements GreeterTarget {
    @Override
    public String get() {
        return "TEST";
    }
}

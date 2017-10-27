package spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine;

import org.springframework.stereotype.Component;

@Component
public class HeavyFine implements Fine {
    @Override
    public String whatIsFine() {
        return "A fine is heavy";
    }
}

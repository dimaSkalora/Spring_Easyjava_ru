package spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine;

import org.springframework.stereotype.Component;

@Component
@FineDayQualifier
public class FineDay implements Fine {
    @Override
    public String whatIsFine() {
        return "A day is fine";
    }
}

package spring_framework.head_04.spring_core_qualifier.easyjava.spring.inject_qualifier.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.FineDayQualifier;

@Component
public class AmbiguousAutowiredFine {
    @Autowired
    @FineDayQualifier
    private Fine fine;

    public String getFine() { return fine.whatIsFine(); }
}

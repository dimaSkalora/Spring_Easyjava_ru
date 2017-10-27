package spring_framework.head_04.spring_core_qualifier.easyjava.spring.inject_qualifier.resource;

import org.springframework.stereotype.Component;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.FineDayQualifier;

import javax.annotation.Resource;

@Component
public class AmbiguousResourceFine {
    @Resource
    @FineDayQualifier
    private Fine fine;

    public String getFine() { return fine.whatIsFine(); }
}

package spring_framework.head_04.spring_core_qualifier.easyjava.spring.implicit.inject;

import org.springframework.stereotype.Component;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

import javax.inject.Inject;


@Component
public class AmbiguousInjectFine {
    @Inject
    private Fine fineDay;   //Неявный выбор бина по имени

    public String getFine() { return fineDay.whatIsFine(); }

}

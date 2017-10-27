package spring_framework.head_04.spring_core_qualifier.easyjava.spring.implicit.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

@Component
public class AmbiguousAutowiredFine {
    @Autowired
    private Fine fineDay;   //Неявный выбор бина по имени

    public String getFine() { return fineDay.whatIsFine(); }
}

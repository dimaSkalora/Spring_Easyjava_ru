package spring_framework.head_04.spring_core_qualifier.easyjava.spring.implicit.resource;

import org.springframework.stereotype.Component;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

import javax.annotation.Resource;

@Component
public class AmbiguousResourceFine {
    @Resource
    private Fine fineDay;       //Неявный выбор бина по имени

    public String getFine() { return fineDay.whatIsFine(); }
}

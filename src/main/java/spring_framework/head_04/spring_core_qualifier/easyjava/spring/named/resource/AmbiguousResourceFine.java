package spring_framework.head_04.spring_core_qualifier.easyjava.spring.named.resource;

import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

import javax.annotation.Resource;
import javax.inject.Named;

@Named
public class AmbiguousResourceFine {
    @Resource
    @Named("fineDay")
    private Fine fine;

    public String getFine() { return fine.whatIsFine(); }
}

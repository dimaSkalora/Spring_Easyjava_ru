package spring_framework.head_04.spring_core_qualifier.easyjava.spring.qualifier.resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

import javax.annotation.Resource;

@Component
public class AmbiguousResourceFine {
    @Resource
    @Qualifier("fineDay")
    private Fine fine;

    public String getFine() { return fine.whatIsFine(); }
}

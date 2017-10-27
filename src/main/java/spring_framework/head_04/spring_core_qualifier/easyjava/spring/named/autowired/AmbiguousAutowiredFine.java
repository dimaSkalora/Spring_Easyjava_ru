package spring_framework.head_04.spring_core_qualifier.easyjava.spring.named.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

import javax.inject.Named;

@Named
public class AmbiguousAutowiredFine {
    @Autowired
    @Named("fineDay")
    private Fine fine;

    public String getFine() { return fine.whatIsFine(); }
}

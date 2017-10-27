package spring_framework.head_04.spring_core_qualifier.easyjava.spring.named.inject;

import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AmbiguousInjectFine {
    @Inject
    @Named("fineDay")
    private Fine fine;

    public String getFine() { return fine.whatIsFine(); }

}

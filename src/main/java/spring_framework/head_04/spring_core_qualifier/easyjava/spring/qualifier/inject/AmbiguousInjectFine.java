package spring_framework.head_04.spring_core_qualifier.easyjava.spring.qualifier.inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

import javax.inject.Inject;

@Component
public class AmbiguousInjectFine {
    @Inject
    @Qualifier("fineDay")
    private Fine fine;

    public String getFine() { return fine.whatIsFine(); }

}

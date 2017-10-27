package spring_framework.head_04.spring_core_qualifier.easyjava.spring.qualifier.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

@Component
public class AmbiguousAutowiredFine {
    @Autowired
    @Qualifier("fineDay")
    private Fine fine;

    public String getFine() { return fine.whatIsFine(); }
}

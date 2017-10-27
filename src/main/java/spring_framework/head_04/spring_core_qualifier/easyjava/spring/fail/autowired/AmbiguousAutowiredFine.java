package spring_framework.head_04.spring_core_qualifier.easyjava.spring.fail.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

@Component
public class AmbiguousAutowiredFine {
    @Autowired
    private Fine fine;

    public String getFine() { return fine.whatIsFine(); }
}

package spring_framework.head_04.spring_core_qualifier.easyjava.spring.list.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AmbiguousAutowiredFine {
    @Autowired
    private List<Fine> fine;

    public String getFine() {
        return "Two options: " + fine.stream()
                .map(Fine::whatIsFine)
                .collect(Collectors.joining(" and "));
    }
}

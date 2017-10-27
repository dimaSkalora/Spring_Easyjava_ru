package spring_framework.head_04.spring_core_qualifier.easyjava.spring.list.resource;

import org.springframework.stereotype.Component;
import spring_framework.head_04.spring_core_qualifier.easyjava.spring.fine.Fine;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AmbiguousResourceFine {
    @Resource
    private List<Fine> fine;

    public String getFine() {
        return "Two options: " + fine.stream()
                .map(Fine::whatIsFine)
                .collect(Collectors.joining(" and "));
    }
}

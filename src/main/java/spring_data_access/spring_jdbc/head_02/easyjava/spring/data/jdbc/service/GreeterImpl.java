package spring_data_access.spring_jdbc.head_02.easyjava.spring.data.jdbc.service;

import org.springframework.stereotype.Service;
import ru.easyjava.spring.data.jdbc.dao.GreeterDao;

import javax.inject.Inject;
import java.util.stream.Collectors;

/**
 * Simple greeter implementation.
 */
@Service
public class GreeterImpl implements Greeter {
    /**
     * Our data layer.
     */
    @Inject
    private GreeterDao dao;

    @Override
    public final String greet() {
        return dao
          .getGreetings()
          .stream()
          .collect(
             Collectors.mapping(r -> r.get("GREETING") + ", " + r.get("TARGET"),
               Collectors.joining("\n")));
    }
}

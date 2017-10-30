package spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.annotations.service;

import org.springframework.stereotype.Service;
import spring_data_access.spring_jdbc.head_01.spring_data_jdbc_hello.annotations.dao.GreeterDao;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        List<Map<String, Object>>  greets = dao.getGreetings();
        Iterator<Map<String, Object>> it = greets.iterator();
        if (!it.hasNext()) {
            return "No greets";
        }
        Map<String, Object> row = it.next();
        return row.get("GREETING_") + ", " + row.get("TARGET_");
    }
}

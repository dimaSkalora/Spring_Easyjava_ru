package spring_framework.head_03.spring_core_di_master.annotations.ru.easyjava.spring.properties;

import org.springframework.stereotype.Service;

@Service
public class BaseService {
    Boolean isMany(Integer number){
        return number > 5;
    }
}

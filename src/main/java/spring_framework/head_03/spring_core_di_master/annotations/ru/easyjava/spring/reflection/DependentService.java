package spring_framework.head_03.spring_core_di_master.annotations.ru.easyjava.spring.reflection;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class DependentService {
    @Inject
    private BaseRepository repository;
    @Inject
    private BaseService service;

    public String process(){
        if(service.isMany(repository.count()))
            return "Too big number";
        else
            return "Everything is fine";
    }
}

package spring_framework.head_03.spring_core_di_master.annotations.ru.easyjava.spring.properties;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class DependentService {
    private BaseRepository repository;
    private BaseService service;

    @Inject
    public void setRepository(BaseRepository repository) {
        this.repository = repository;
    }

    @Inject
    public void setService(BaseService service) {
        this.service = service;
    }

    public String process(){
        if(service.isMany(repository.count()))
            return "Too big number";
        else
            return "Everything is fine";
    }
}

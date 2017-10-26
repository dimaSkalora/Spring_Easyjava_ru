package spring_framework.head_03.spring_core_di_master.javaconfig.ru.easyjava.spring.constructor;

public class DependentService {
    private final BaseRepository repository;
    private final BaseService service;

    public DependentService(BaseRepository repository, BaseService service) {
        this.repository = repository;
        this.service = service;
    }

    public String process(){
        if(service.isMany(repository.count()))
            return "Too big number";
        else
            return "Everything is fine";
    }
}

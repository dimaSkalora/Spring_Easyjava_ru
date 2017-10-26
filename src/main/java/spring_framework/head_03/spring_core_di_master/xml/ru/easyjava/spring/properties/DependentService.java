package spring_framework.head_03.spring_core_di_master.xml.ru.easyjava.spring.properties;

public class DependentService {
    private BaseRepository repository;
    private BaseService service;

    public void setRepository(BaseRepository repository) {
        this.repository = repository;
    }

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

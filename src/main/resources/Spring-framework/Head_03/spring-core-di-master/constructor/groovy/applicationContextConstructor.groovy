import ru.easyjava.spring.BaseRepository
import ru.easyjava.spring.BaseService
import ru.easyjava.spring.constructor.DependentService

beans {
    base BaseService
    repository BaseRepository

    dependent(DependentService, repository, base)
}
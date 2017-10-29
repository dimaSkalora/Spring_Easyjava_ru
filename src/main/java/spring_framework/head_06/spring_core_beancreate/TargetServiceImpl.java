package spring_framework.head_06.spring_core_beancreate;

import org.springframework.stereotype.Service;

/**
 * GreeterTarget implementation.
 *
 * It is annotated as @Service, so Spring should instantiate
 * it automatically.
 */
@Service
public class TargetServiceImpl implements TargetService {
    @Override
    public final String getTarget() {
        return "World";
    }
}

package spring_framework.head_05.spring_core_lifecycle.dependency.destroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import spring_framework.head_05.spring_core_lifecycle.SomeService;

import javax.inject.Inject;
import java.util.logging.Logger;

@Service
public class DependencyInitWithInterface implements Dependency, InitializingBean, DisposableBean {
    private final static Logger LOGGER = Logger.getLogger(DependencyInitWithAnnotation.class.getName());

    @Inject
    private SomeService service;

    public DependencyInitWithInterface() {
        LOGGER.info("I'm a constructor");
        if (service == null) {
            LOGGER.info("service is NOT set in the constructor");
        } else {
            LOGGER.info("service is set in the constructor");
        }
    }

    @Override
    public String callService() {
        return service.act();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("I'm init function");
        if (service == null) {
            LOGGER.info("service is NOT set in init function");
        } else {
            LOGGER.info("service is set in init function");
        }
    }

    @Override
    public void destroy() throws Exception {
        LOGGER.info("I'm destroy function. I have nothing to do");
    }
}

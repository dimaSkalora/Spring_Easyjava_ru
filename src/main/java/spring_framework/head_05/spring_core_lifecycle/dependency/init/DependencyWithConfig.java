package spring_framework.head_05.spring_core_lifecycle.dependency.init;

import spring_framework.head_05.spring_core_lifecycle.SomeService;

import javax.inject.Inject;
import java.util.logging.Logger;

public class DependencyWithConfig implements Dependency {
    private final static Logger LOGGER = Logger.getLogger(DependencyInitWithAnnotation.class.getName());

    @Inject
    private SomeService service;

    public DependencyWithConfig() {
        LOGGER.info("I'm a constructor");
        if (service == null) {
            LOGGER.info("service is NOT set in the constructor");
        } else {
            LOGGER.info("service is set in the constructor");
        }
    }

    public void init() {
        LOGGER.info("I'm init function");
        if (service == null) {
            LOGGER.info("service is NOT set in init function");
        } else {
            LOGGER.info("service is set in init function");
        }
    }

    @Override
    public String callService() {
        return service.act();
    }

}

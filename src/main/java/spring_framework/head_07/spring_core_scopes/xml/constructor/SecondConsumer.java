package spring_framework.head_07.spring_core_scopes.xml.constructor;

import java.util.logging.Logger;

/**
 * Bean consumer for differently scoped beans.
 */
public class SecondConsumer {
    /**
     * Logger.
     */
    private static final Logger LOG =
            Logger.getLogger(SecondConsumer.class.getName());

    /**
     * Singleton scope bean instance.
     */
    private StatefulBean singletonBean;

    /**
     * Prototype scope bean instance.
     */
    private StatefulBean prototypeBean;

    public SecondConsumer(StatefulBean singletonBean, StatefulBean prototypeBean) {
        this.singletonBean = singletonBean;
        this.prototypeBean = prototypeBean;
    }

    /**
     * Bean states alteration.
     */
    public final void processState() {
        LOG.info("singletonBean state is: " + singletonBean.getState());
        LOG.info("prototypeBean state is: " + prototypeBean.getState());

        singletonBean.setState("After SecondConsumer");
        prototypeBean.setState("After SecondConsumer");

        LOG.info("singletonBean state set to: " + singletonBean.getState());
        LOG.info("prototypeBean state set to: " + prototypeBean.getState());
    }
}

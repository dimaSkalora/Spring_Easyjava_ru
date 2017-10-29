package spring_framework.head_07.spring_core_scopes.java_convig.constructor;

import java.util.logging.Logger;

/**
 * Bean consumer for differently scoped beans.
 */

public class FirstConsumer {
    /**
     * Logger.
     */
    private static final Logger LOG =
            Logger.getLogger(FirstConsumer.class.getName());

    /**
     * Singleton scope bean instance.
     */
    private StatefulBean singletonBean;

    /**
     * Prototype scope bean instance.
     */
    private StatefulBean prototypeBean;

    public FirstConsumer(StatefulBean singletonBean, StatefulBean prototypeBean) {
        this.singletonBean = singletonBean;
        this.prototypeBean = prototypeBean;
    }

    /**
     * Bean states alteration.
     */
    public final void processState() {
        LOG.info("singletonBean state is: " + singletonBean.getState());
        LOG.info("prototypeBean state is: " + prototypeBean.getState());

        singletonBean.setState("After FirstConsumer");
        prototypeBean.setState("After FirstConsumer");

        LOG.info("singletonBean state set to: " + singletonBean.getState());
        LOG.info("prototypeBean state set to: " + prototypeBean.getState());
    }
}

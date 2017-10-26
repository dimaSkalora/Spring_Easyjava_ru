package spring_framework.head_02.spring_core_initcontext.xml.greeter;

/**
 * Here we determine, who we are greeting today.
 */
public interface GreeterTarget {
    /**
     * Selects greeting target tossing a coin.
     * @return "World" or "Spring".
     */
    String get();
}

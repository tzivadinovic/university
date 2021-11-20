package main.dz1;

public class ComparisoFailure extends AssertionError{
    /**
     * The maximum length for excepted and actual strings. If it is exceeded, the strings should be shortened.
     *
     * @see junit.framework.ComparisonCompactor
     * */
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1L;

    /*
    * We have to use the f prefix until the next major release to ensure
    * serialization compatibility
    * See https://github.com/junit-team/junit4/issues/976
     */

    private String fExcepted;
    private String fActual;
}

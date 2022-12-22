package org.osgi.framework.hooks.weaving;

public class WeavingException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public WeavingException(String str, Throwable th) {
        super(str, th);
    }

    public WeavingException(String str) {
        super(str);
    }
}

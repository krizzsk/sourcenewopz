package org.osgi.framework;

public class ServiceException extends RuntimeException {
    public static final int ASYNC_ERROR = 7;
    public static final int FACTORY_ERROR = 2;
    public static final int FACTORY_EXCEPTION = 3;
    public static final int FACTORY_RECURSION = 6;
    public static final int REMOTE = 5;
    public static final int SUBCLASSED = 4;
    public static final int UNREGISTERED = 1;
    public static final int UNSPECIFIED = 0;
    static final long serialVersionUID = 3038963223712959631L;
    private final int type;

    public ServiceException(String str, Throwable th) {
        this(str, 0, th);
    }

    public ServiceException(String str) {
        this(str, 0);
    }

    public ServiceException(String str, int i, Throwable th) {
        super(str, th);
        this.type = i;
    }

    public ServiceException(String str, int i) {
        super(str);
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}

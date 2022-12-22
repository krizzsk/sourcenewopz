package org.osgi.framework;

public class BundleException extends Exception {
    public static final int ACTIVATOR_ERROR = 5;
    public static final int DUPLICATE_BUNDLE_ERROR = 9;
    public static final int INVALID_OPERATION = 2;
    public static final int MANIFEST_ERROR = 3;
    public static final int NATIVECODE_ERROR = 8;
    public static final int READ_ERROR = 11;
    public static final int REJECTED_BY_HOOK = 12;
    public static final int RESOLVE_ERROR = 4;
    public static final int SECURITY_ERROR = 6;
    public static final int START_TRANSIENT_ERROR = 10;
    public static final int STATECHANGE_ERROR = 7;
    public static final int UNSPECIFIED = 0;
    public static final int UNSUPPORTED_OPERATION = 1;
    static final long serialVersionUID = 3571095144220455665L;
    private final int type;

    public BundleException(String str, Throwable th) {
        this(str, 0, th);
    }

    public BundleException(String str) {
        this(str, 0);
    }

    public BundleException(String str, int i, Throwable th) {
        super(str, th);
        this.type = i;
    }

    public BundleException(String str, int i) {
        super(str);
        this.type = i;
    }

    public Throwable getNestedException() {
        return getCause();
    }

    public Throwable getCause() {
        return super.getCause();
    }

    public Throwable initCause(Throwable th) {
        return super.initCause(th);
    }

    public int getType() {
        return this.type;
    }
}

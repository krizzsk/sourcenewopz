package org.osgi.framework;

public class InvalidSyntaxException extends Exception {
    static final long serialVersionUID = -4295194420816491875L;
    private final String filter;

    public InvalidSyntaxException(String str, String str2) {
        super(message(str, str2));
        this.filter = str2;
    }

    public InvalidSyntaxException(String str, String str2, Throwable th) {
        super(message(str, str2), th);
        this.filter = str2;
    }

    private static String message(String str, String str2) {
        if (str == null || str2 == null || str.indexOf(str2) >= 0) {
            return str;
        }
        return str + ": " + str2;
    }

    public String getFilter() {
        return this.filter;
    }

    public Throwable getCause() {
        return super.getCause();
    }

    public Throwable initCause(Throwable th) {
        return super.initCause(th);
    }
}

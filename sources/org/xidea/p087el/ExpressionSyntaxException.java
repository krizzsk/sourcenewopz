package org.xidea.p087el;

/* renamed from: org.xidea.el.ExpressionSyntaxException */
public class ExpressionSyntaxException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public ExpressionSyntaxException(String str, Throwable th) {
        super(str, th);
    }

    public ExpressionSyntaxException(String str) {
        super(str);
    }
}

package com.didichuxing.security.quickjs;

public class JSEvaluationException extends RuntimeException {
    private JSException jsException;

    JSEvaluationException(JSException jSException) {
        super(jSException.toString());
    }

    public JSException getJSException() {
        return this.jsException;
    }
}

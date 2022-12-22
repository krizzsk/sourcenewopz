package com.didi.dimina.starbox.module.jsbridge.gift;

public class InterceptorResult<T> {
    public int dCode;
    public T data;
    public String message;

    public InterceptorResult() {
    }

    public InterceptorResult(T t) {
        this.data = t;
    }

    public String toString() {
        return "InterceptorResult{data=" + this.data + ", message='" + this.message + '\'' + ", dCode=" + this.dCode + '}';
    }
}

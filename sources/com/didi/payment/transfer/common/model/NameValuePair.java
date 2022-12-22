package com.didi.payment.transfer.common.model;

public class NameValuePair<T> {
    public String name;
    public T value;

    public NameValuePair(String str, T t) {
        this.name = str;
        this.value = t;
    }

    public String toString() {
        return String.valueOf(this.value) + " " + this.name;
    }
}

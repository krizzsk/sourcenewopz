package com.didi.hawaii.basic;

public class DataHolder<T> {
    private T val;

    public DataHolder() {
    }

    public DataHolder(T t) {
        this.val = t;
    }

    public T getVal() {
        return this.val;
    }

    public void setVal(T t) {
        this.val = t;
    }
}

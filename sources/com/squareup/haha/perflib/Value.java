package com.squareup.haha.perflib;

public class Value {
    private final Instance instance;
    private Object mValue;

    public Value(Instance instance2) {
        this.instance = instance2;
    }

    public Object getValue() {
        return this.mValue;
    }

    public void setValue(Object obj) {
        this.mValue = obj;
        if (obj instanceof Instance) {
            ((Instance) obj).addReference((Field) null, this.instance);
        }
    }
}

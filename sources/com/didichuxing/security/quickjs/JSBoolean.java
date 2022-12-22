package com.didichuxing.security.quickjs;

public class JSBoolean extends JSValue {
    private final boolean value;

    JSBoolean(long j, JSContext jSContext, boolean z) {
        super(j, jSContext);
        this.value = z;
    }

    public boolean getBoolean() {
        return this.value;
    }
}

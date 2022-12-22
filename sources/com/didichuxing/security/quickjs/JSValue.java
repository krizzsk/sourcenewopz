package com.didichuxing.security.quickjs;

public abstract class JSValue {
    final JSContext jsContext;
    final long pointer;

    JSValue(long j, JSContext jSContext) {
        this.pointer = j;
        this.jsContext = jSContext;
    }

    public final <T extends JSValue> T cast(Class<T> cls) {
        if (cls.isInstance(this)) {
            return this;
        }
        throw new JSDataException("expected: " + cls.getSimpleName() + ", actual: " + getClass().getSimpleName());
    }

    /* access modifiers changed from: package-private */
    public final void checkSameJSContext(JSValue jSValue) {
        if (jSValue.jsContext != this.jsContext) {
            throw new IllegalStateException("Two JSValues are not from the same JSContext");
        }
    }
}

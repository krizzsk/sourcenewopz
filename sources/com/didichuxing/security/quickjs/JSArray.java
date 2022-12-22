package com.didichuxing.security.quickjs;

public final class JSArray extends JSObject {
    JSArray(long j, JSContext jSContext) {
        super(j, jSContext, (Object) null);
    }

    public int getLength() {
        return ((JSNumber) getProperty("length").cast(JSNumber.class)).getInt();
    }
}

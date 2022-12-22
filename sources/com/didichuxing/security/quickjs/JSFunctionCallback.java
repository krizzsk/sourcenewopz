package com.didichuxing.security.quickjs;

public interface JSFunctionCallback {
    JSValue invoke(JSContext jSContext, JSValue[] jSValueArr);
}

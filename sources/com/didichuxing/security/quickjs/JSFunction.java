package com.didichuxing.security.quickjs;

public final class JSFunction extends JSObject {
    JSFunction(long j, JSContext jSContext) {
        super(j, jSContext, (Object) null);
    }

    public JSValue invoke(JSValue jSValue, JSValue[] jSValueArr) {
        JSValue wrapAsJSValue;
        if (jSValue != null) {
            checkSameJSContext(jSValue);
        }
        for (JSValue checkSameJSContext : jSValueArr) {
            checkSameJSContext(checkSameJSContext);
        }
        long[] jArr = new long[jSValueArr.length];
        for (int i = 0; i < jSValueArr.length; i++) {
            jArr[i] = jSValueArr[i].pointer;
        }
        synchronized (this.jsContext.jsRuntime) {
            wrapAsJSValue = this.jsContext.wrapAsJSValue(QuickJS.invokeValueFunction(this.jsContext.checkClosed(), this.pointer, jSValue != null ? jSValue.pointer : 0, jArr));
        }
        return wrapAsJSValue;
    }
}

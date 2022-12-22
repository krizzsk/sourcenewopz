package com.didi.soda.web;

import com.didi.onehybrid.jsbridge.CallbackFunction;

public interface IFusionCallback {
    void bindCallbackWithName(String str, CallbackFunction callbackFunction);

    void doCallbackWithName(String str, Object... objArr);
}

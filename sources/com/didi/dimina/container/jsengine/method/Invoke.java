package com.didi.dimina.container.jsengine.method;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.jsengine.JSArray;

public class Invoke implements JSCallback {

    /* renamed from: a */
    DMMina f16837a;

    public Invoke(DMMina dMMina) {
        this.f16837a = dMMina;
    }

    public Object callback(JSArray jSArray) {
        return this.f16837a.getMessageTransfer().invokeNativeFromService(jSArray);
    }
}

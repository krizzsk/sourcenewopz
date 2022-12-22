package com.didi.dimina.p108v8.debug.mirror;

import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.mirror.ValueMirror */
public class ValueMirror extends Mirror {
    private static final String VALUE = "value";

    public boolean isValue() {
        return true;
    }

    ValueMirror(V8Object v8Object) {
        super(v8Object);
    }

    public Object getValue() {
        return this.v8Object.executeFunction("value", (V8Array) null);
    }
}

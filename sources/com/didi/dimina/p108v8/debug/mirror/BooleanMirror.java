package com.didi.dimina.p108v8.debug.mirror;

import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.mirror.BooleanMirror */
public class BooleanMirror extends ValueMirror {
    public boolean isBoolean() {
        return true;
    }

    BooleanMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String toString() {
        return this.v8Object.executeStringFunction("toText", (V8Array) null);
    }
}

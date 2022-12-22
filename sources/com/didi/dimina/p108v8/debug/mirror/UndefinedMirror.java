package com.didi.dimina.p108v8.debug.mirror;

import com.didi.dimina.p108v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.mirror.UndefinedMirror */
public class UndefinedMirror extends ValueMirror {
    public boolean isUndefined() {
        return true;
    }

    public String toString() {
        return "undefined";
    }

    UndefinedMirror(V8Object v8Object) {
        super(v8Object);
    }
}

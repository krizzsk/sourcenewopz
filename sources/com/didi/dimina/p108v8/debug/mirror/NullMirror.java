package com.didi.dimina.p108v8.debug.mirror;

import com.didi.dimina.p108v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.mirror.NullMirror */
public class NullMirror extends ValueMirror {
    public boolean isNull() {
        return true;
    }

    public String toString() {
        return "null";
    }

    NullMirror(V8Object v8Object) {
        super(v8Object);
    }
}

package com.didi.dimina.p108v8.debug.mirror;

import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.mirror.ArrayMirror */
public class ArrayMirror extends ObjectMirror {
    private static final String LENGTH = "length";

    public boolean isArray() {
        return true;
    }

    ArrayMirror(V8Object v8Object) {
        super(v8Object);
    }

    public int length() {
        return this.v8Object.executeIntegerFunction(LENGTH, (V8Array) null);
    }
}

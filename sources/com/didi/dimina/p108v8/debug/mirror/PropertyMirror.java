package com.didi.dimina.p108v8.debug.mirror;

import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.mirror.PropertyMirror */
public class PropertyMirror extends Mirror {
    public boolean isProperty() {
        return true;
    }

    PropertyMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String getName() {
        return this.v8Object.executeStringFunction("name", (V8Array) null);
    }

    public Mirror getValue() {
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction("value", (V8Array) null);
        try {
            return createMirror(executeObjectFunction);
        } finally {
            executeObjectFunction.close();
        }
    }
}

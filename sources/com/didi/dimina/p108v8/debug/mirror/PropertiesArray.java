package com.didi.dimina.p108v8.debug.mirror;

import com.didi.dimina.p108v8.Releasable;
import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.mirror.PropertiesArray */
public class PropertiesArray implements Releasable {
    private V8Array v8Array;

    PropertiesArray(V8Array v8Array2) {
        this.v8Array = v8Array2.twin();
    }

    public PropertyMirror getProperty(int i) {
        V8Object object = this.v8Array.getObject(i);
        try {
            return new PropertyMirror(object);
        } finally {
            object.close();
        }
    }

    public void close() {
        if (!this.v8Array.isReleased()) {
            this.v8Array.close();
        }
    }

    @Deprecated
    public void release() {
        close();
    }

    public int length() {
        return this.v8Array.length();
    }
}

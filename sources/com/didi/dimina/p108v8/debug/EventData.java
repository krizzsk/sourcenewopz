package com.didi.dimina.p108v8.debug;

import com.didi.dimina.p108v8.Releasable;
import com.didi.dimina.p108v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.EventData */
public class EventData implements Releasable {
    protected V8Object v8Object;

    EventData(V8Object v8Object2) {
        this.v8Object = v8Object2.twin();
    }

    public void close() {
        if (!this.v8Object.isReleased()) {
            this.v8Object.close();
        }
    }

    @Deprecated
    public void release() {
        close();
    }
}

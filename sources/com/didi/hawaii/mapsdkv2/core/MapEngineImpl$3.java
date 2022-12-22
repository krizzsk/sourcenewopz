package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.jni.SwigMJOCallback;

class MapEngineImpl$3 extends SwigMJOCallback {
    final /* synthetic */ C9186f this$0;

    MapEngineImpl$3(C9186f fVar) {
        this.this$0 = fVar;
    }

    public void OnMJOEvent(int i, int i2) {
        if (this.this$0.f24030g != null) {
            this.this$0.f24030g.onMJOEvent((long) i, i2);
        }
    }
}

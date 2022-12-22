package com.didi.map.global.component.recmarker;

import com.didi.map.global.component.recmarker.model.RecPoint;

public interface RecMarkerCallback {

    /* renamed from: com.didi.map.global.component.recmarker.RecMarkerCallback$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onRecMarkerShow(RecMarkerCallback recMarkerCallback, RecPoint recPoint, boolean z) {
        }
    }

    void onRecMarkerShow(RecPoint recPoint, boolean z);
}

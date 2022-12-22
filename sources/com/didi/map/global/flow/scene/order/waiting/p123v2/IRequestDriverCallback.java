package com.didi.map.global.flow.scene.order.waiting.p123v2;

import com.didi.common.map.model.LatLng;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.IRequestDriverCallback */
public interface IRequestDriverCallback {
    void onFailure();

    void onSuccess(int i, LatLng latLng);
}

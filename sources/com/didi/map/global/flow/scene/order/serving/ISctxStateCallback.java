package com.didi.map.global.flow.scene.order.serving;

import com.didi.map.sdk.nav.inertia.SctxStateInfo;

public interface ISctxStateCallback {
    void onSctxStateUpdate(SctxStateInfo sctxStateInfo);
}

package com.didi.map.sdk.nav.inertia;

import com.didi.common.map.model.LatLng;
import com.map.sdk.nav.libc.common.DMKEventPoint;

public interface OnLocationMatched {

    /* renamed from: com.didi.map.sdk.nav.inertia.OnLocationMatched$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onSctxSuspiciousJumpError(OnLocationMatched onLocationMatched, SctxInertiaSuspiciousStatus sctxInertiaSuspiciousStatus) {
        }
    }

    void onMatched(LatLng latLng, int i, int i2, int i3, int i4, boolean z, DMKEventPoint dMKEventPoint);

    void onOffRoute();

    void onSctxStateUpdate(SctxStateInfo sctxStateInfo);

    void onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus sctxInertiaSuspiciousStatus);
}

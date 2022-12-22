package com.didi.ifx.license;

import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;

/* renamed from: com.didi.ifx.license.c */
/* compiled from: IFXTracker */
class C9283c {

    /* renamed from: a */
    boolean f24381a = false;

    /* renamed from: b */
    IFXTrackCallback f24382b = null;

    C9283c() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71682a(String str, Map<String, Object> map) {
        if (this.f24381a) {
            IFXTrackCallback iFXTrackCallback = this.f24382b;
            if (iFXTrackCallback != null) {
                iFXTrackCallback.trackEvent(str, map);
                return;
            }
            return;
        }
        OmegaSDKAdapter.trackEvent(str, map);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71681a(String str, Throwable th) {
        if (this.f24381a) {
            IFXTrackCallback iFXTrackCallback = this.f24382b;
            if (iFXTrackCallback != null) {
                iFXTrackCallback.trackError(str, th);
                return;
            }
            return;
        }
        OmegaSDK.trackError(str, th);
    }
}

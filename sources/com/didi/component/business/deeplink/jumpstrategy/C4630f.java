package com.didi.component.business.deeplink.jumpstrategy;

import android.app.Activity;
import android.net.Uri;
import com.didi.safetoolkit.business.sdk.SafeToolKit;

/* renamed from: com.didi.component.business.deeplink.jumpstrategy.f */
/* compiled from: SosDeepLink */
class C4630f implements INewActivityDeepLink {
    C4630f() {
    }

    public void deepLink(Activity activity, Uri uri) {
        SafeToolKit.getIns().startEmergencyAssistanceActivity(activity);
    }
}

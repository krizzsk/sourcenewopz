package com.didi.component.business.deeplink.jumpstrategy;

import android.app.Activity;
import android.net.Uri;
import com.didi.safetoolkit.business.sdk.SafeToolKit;

/* renamed from: com.didi.component.business.deeplink.jumpstrategy.c */
/* compiled from: SafeCenterDeepLink */
class C4627c implements INewActivityDeepLink {
    C4627c() {
    }

    public void deepLink(Activity activity, Uri uri) {
        SafeToolKit.getIns().startSafeCenterPage(activity);
    }
}

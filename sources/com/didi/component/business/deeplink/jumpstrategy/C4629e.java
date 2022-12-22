package com.didi.component.business.deeplink.jumpstrategy;

import android.app.Activity;
import android.net.Uri;
import com.didi.safetoolkit.business.sdk.SafeToolKit;

/* renamed from: com.didi.component.business.deeplink.jumpstrategy.e */
/* compiled from: SharedBySMSDeepLink */
class C4629e implements INewActivityDeepLink {
    C4629e() {
    }

    public void deepLink(Activity activity, Uri uri) {
        SafeToolKit.getIns().startSharePage(activity, 0);
    }
}

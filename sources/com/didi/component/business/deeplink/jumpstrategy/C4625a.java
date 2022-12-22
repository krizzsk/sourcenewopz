package com.didi.component.business.deeplink.jumpstrategy;

import android.app.Activity;
import android.net.Uri;
import com.didi.safetoolkit.business.sdk.SafeToolKit;

/* renamed from: com.didi.component.business.deeplink.jumpstrategy.a */
/* compiled from: ManagerContactsDeepLink */
class C4625a implements INewActivityDeepLink {
    C4625a() {
    }

    public void deepLink(Activity activity, Uri uri) {
        SafeToolKit.getIns().startContactsManagerPage(activity);
    }
}

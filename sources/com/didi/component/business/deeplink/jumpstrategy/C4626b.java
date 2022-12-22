package com.didi.component.business.deeplink.jumpstrategy;

import android.app.Activity;
import android.net.Uri;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;

/* renamed from: com.didi.component.business.deeplink.jumpstrategy.b */
/* compiled from: ModifyPassWordDeepLink */
class C4626b implements INewActivityDeepLink {
    C4626b() {
    }

    public void deepLink(Activity activity, Uri uri) {
        OneLoginFacade.getAction().go2ModifyPassword(activity, (LoginListeners.ModifyPasswordListener) null);
    }
}

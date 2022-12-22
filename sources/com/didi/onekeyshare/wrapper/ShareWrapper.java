package com.didi.onekeyshare.wrapper;

import android.app.Activity;
import android.content.Context;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sharesdk.ShareApi;

public final class ShareWrapper {

    /* renamed from: a */
    private static final String f29849a = ShareWrapper.class.getSimpleName();

    public static void shareToPlatform(Context context, OneKeyShareInfo oneKeyShareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        if (context == null || oneKeyShareInfo == null) {
            SystemUtils.log(6, f29849a, "context or shareInfo maybe is null", (Throwable) null, "com.didi.onekeyshare.wrapper.ShareWrapper", 30);
        } else {
            ShareApi.show((Activity) context, oneKeyShareInfo, iPlatformShareCallback);
        }
    }
}

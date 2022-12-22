package com.didi.onekeyshare.wrapper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.ShareConvertCompat;
import com.didi.onekeyshare.util.Utils;
import com.didi.sdk.util.ToastHelper;
import com.didi.sharesdk.OneKeyShareModel;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.taxis99.R;

@ServiceProvider({IPlatform.class})
public class FacebookPlatform implements IPlatform {

    /* renamed from: a */
    private static final String f29839a = "com.facebook.katana";

    /* renamed from: b */
    private static CallbackManager f29840b = CallbackManager.Factory.create();
    public static Bitmap sBitmap;
    public static ICallback.IPlatformShareCallback sCallback;

    public void share(Context context, OneKeyShareInfo oneKeyShareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        OneKeyShareModel convert = ShareConvertCompat.convert(oneKeyShareInfo);
        Activity activity = (Activity) context;
        new ShareCallback(iPlatformShareCallback);
        if (!FacebookSdk.isInitialized()) {
            FacebookSdk.sdkInitialize(activity.getApplicationContext());
        }
        if (Utils.isAppInstalled(activity, "com.facebook.katana")) {
            sCallback = iPlatformShareCallback;
            sBitmap = convert.bitmap;
            Intent intent = new Intent(activity, DispatchFacebookShareCbActivity.class);
            intent.putExtra("url", convert.url);
            intent.putExtra("title", convert.title);
            intent.putExtra("content", convert.content);
            intent.putExtra("imgUrl", convert.imgUrl);
            intent.putExtra("imgPath", convert.imgPath);
            activity.startActivity(intent);
            return;
        }
        ToastHelper.showLongError((Context) activity, activity.getString(R.string.tip_facebook_not_install));
    }

    public boolean matchPlatform(String str) {
        return SharePlatform.FACEBOOK_PLATFORM.platformName().equals(str);
    }

    public static class ShareCallback implements FacebookCallback<Sharer.Result> {
        private ICallback.IPlatformShareCallback callback;

        public ShareCallback(ICallback.IPlatformShareCallback iPlatformShareCallback) {
            this.callback = iPlatformShareCallback;
        }

        public void onSuccess(Sharer.Result result) {
            ICallback.IPlatformShareCallback iPlatformShareCallback = this.callback;
            if (iPlatformShareCallback != null) {
                iPlatformShareCallback.onComplete(SharePlatform.FACEBOOK_PLATFORM);
            }
        }

        public void onCancel() {
            ICallback.IPlatformShareCallback iPlatformShareCallback = this.callback;
            if (iPlatformShareCallback != null) {
                iPlatformShareCallback.onCancel(SharePlatform.FACEBOOK_PLATFORM);
            }
        }

        public void onError(FacebookException facebookException) {
            ICallback.IPlatformShareCallback iPlatformShareCallback = this.callback;
            if (iPlatformShareCallback != null) {
                iPlatformShareCallback.onError(SharePlatform.FACEBOOK_PLATFORM);
            }
        }
    }
}

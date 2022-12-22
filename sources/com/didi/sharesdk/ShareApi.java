package com.didi.sharesdk;

import android.app.Activity;
import android.content.Intent;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.callback.ShareCallbackDelegate;
import com.didi.onekeyshare.callback.ShareCallbackDelegate2;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.ShareConvertCompat;
import com.didi.onekeyshare.wrapper.IPlatform;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.component.share.IActivityResultProcessor;
import com.didi.sdk.util.TextUtil;
import com.didi.share.spi.ComponentManager;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.Iterator;

public class ShareApi {
    public static final String PLATFORM_ALIPAY_FRIENDS = "ALIPAY_FRIENDS";
    public static final String PLATFORM_ALIPAY_TIMELINE = "ALIPAY_TIMELINE";
    private static final String TAG = "ShareApi";

    public static void show(Activity activity, OneKeyShareModel oneKeyShareModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        ICallback.IPlatformShareCallback iPlatformShareCallback2;
        SystemUtils.log(3, TAG, "share show OneKeyShareModel1 model = " + oneKeyShareModel, (Throwable) null, "com.didi.sharesdk.ShareApi", 39);
        if (oneKeyShareModel == null || activity == null) {
            throw new IllegalStateException("Context or OneKeyShareModel can't be null");
        }
        IPlatform platform = getPlatform(oneKeyShareModel.getPlatform());
        if (iPlatformShareCallback instanceof ICallback.IPlatformShareCallback2) {
            iPlatformShareCallback2 = new ShareCallbackDelegate2((ICallback.IPlatformShareCallback2) iPlatformShareCallback, oneKeyShareModel.extra);
        } else {
            iPlatformShareCallback2 = iPlatformShareCallback instanceof ICallback.IPlatformShareCallback ? new ShareCallbackDelegate(iPlatformShareCallback, oneKeyShareModel.extra) : null;
        }
        if (platform != null) {
            platform.share(activity, ShareConvertCompat.convert(oneKeyShareModel), iPlatformShareCallback2);
        } else if (iPlatformShareCallback2 != null) {
            iPlatformShareCallback2.onError((SharePlatform) null);
        }
    }

    public static void show(Activity activity, OneKeyShareInfo oneKeyShareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        SystemUtils.log(3, TAG, "share show OneKeyShareInfo2 model = " + oneKeyShareInfo, (Throwable) null, "com.didi.sharesdk.ShareApi", 63);
        if (oneKeyShareInfo == null || activity == null) {
            throw new IllegalStateException("Context or OneKeyShareModel can't be null");
        }
        String platformName = oneKeyShareInfo.platform.platformName();
        IPlatform platform = getPlatform(platformName);
        ICallback.IPlatformShareCallback iPlatformShareCallback2 = null;
        if (iPlatformShareCallback instanceof ICallback.IPlatformShareCallback2) {
            iPlatformShareCallback2 = new ShareCallbackDelegate2((ICallback.IPlatformShareCallback2) iPlatformShareCallback, oneKeyShareInfo.extra);
        } else if (iPlatformShareCallback instanceof ICallback.IPlatformShareCallback) {
            iPlatformShareCallback2 = new ShareCallbackDelegate(iPlatformShareCallback, oneKeyShareInfo.extra);
        }
        if (platform != null) {
            String channelKey = ShareChannelKey.getInstance().getChannelKey();
            if (!TextUtil.isEmpty(oneKeyShareInfo.url)) {
                if (oneKeyShareInfo.url.indexOf(63) == -1) {
                    oneKeyShareInfo.url += "?" + channelKey + "=" + TextUtil.encode(platformName);
                } else {
                    oneKeyShareInfo.url += ParamKeys.SIGN_AND + channelKey + "=" + TextUtil.encode(platformName);
                }
            }
            platform.share(activity, oneKeyShareInfo, iPlatformShareCallback2);
        } else if (iPlatformShareCallback2 != null) {
            iPlatformShareCallback2.onError(oneKeyShareInfo.platform);
        }
    }

    public static void handleShareActivityResult(int i, int i2, Intent intent) {
        Iterator<S> componentIterator = ComponentManager.getInstance().getComponentIterator(IActivityResultProcessor.class);
        while (componentIterator.hasNext()) {
            ((IActivityResultProcessor) componentIterator.next()).handleResult(i, i2, intent);
        }
    }

    private static IPlatform getPlatform(String str) {
        Iterator<S> componentIterator = ComponentManager.getInstance().getComponentIterator(IPlatform.class);
        while (componentIterator.hasNext()) {
            IPlatform iPlatform = (IPlatform) componentIterator.next();
            if (iPlatform.matchPlatform(str)) {
                return iPlatform;
            }
        }
        return null;
    }
}

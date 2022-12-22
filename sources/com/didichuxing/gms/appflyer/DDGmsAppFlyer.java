package com.didichuxing.gms.appflyer;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didi.sdk.p154ms.push.PushTokenInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.p194ms.appflyer.AppsflyerUtil;
import com.didichuxing.p194ms.appflyer.DefaultAppsFlyerConversionListener;
import com.didichuxing.p194ms.appflyer.IAppFlyer;

@ServiceProvider({IAppFlyer.class})
public class DDGmsAppFlyer implements IAppFlyer {
    public static final String TAG = "DDAppFlyerLib_GMS";
    private static PushTokenInterceptor.Interceptor interceptor = new PushTokenInterceptor.Interceptor() {
        public void onNewToken(Context context, String str, String str2) {
            if (IMSType.GMS.equals(str2)) {
                AppsFlyerLib.getInstance().updateServerUninstallToken(context, str);
            }
        }
    };

    @Deprecated
    public void init(Application application, String str) {
        init(application, str, "");
        LogUtil.m26097d(TAG, "init ... key : " + str);
    }

    @Deprecated
    public void init(Application application, String str, String str2) {
        AppsFlyerLib.getInstance().startTracking(application, str);
        AppsFlyerLib.getInstance().setCustomerUserId(str2);
        setFcmInterceptor();
        LogUtil.m26097d(TAG, "init ... key : " + str + " , userid : " + str2);
    }

    public void initialize(Application application, String str, String str2) {
        initialize(application, str, new DefaultAppsFlyerConversionListener(), str2);
        LogUtil.m26097d(TAG, "initialize ... key : " + str + " , userid : " + str2);
    }

    public void initialize(Application application, String str, AppsFlyerConversionListener appsFlyerConversionListener, String str2) {
        AppsFlyerLib.getInstance().init(str, appsFlyerConversionListener, application);
        AppsFlyerLib.getInstance().startTracking(application);
        AppsFlyerLib.getInstance().setCustomerUserId(str2);
        setFcmInterceptor();
        LogUtil.m26097d(TAG, "initialize ... key : " + str + " , userid : " + str2);
    }

    public void delayInit(Application application, String str, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (AppsflyerUtil.getAppsFlyerDebuggable(application)) {
            setDebuggable(true);
        }
        if (AppsflyerUtil.getPreinstallEnable(application)) {
            setPreinstallAttrbution(AppsflyerUtil.getAppsFlyerCampaignName(application), AppsflyerUtil.getAppsFlyerCampaignId(application));
        }
        AppsFlyerLib.getInstance().init(str, appsFlyerConversionListener, application);
        AppsFlyerLib.getInstance().waitForCustomerUserId(true);
        setFcmInterceptor();
        LogUtil.m26097d(TAG, "delayInit ... key : " + str);
    }

    public void delayInit(Application application, String str) {
        delayInit(application, str, new DefaultAppsFlyerConversionListener());
        LogUtil.m26097d(TAG, "delayInit ...  key : " + str);
    }

    public void setDebuggable(boolean z) {
        AppsFlyerLib.getInstance().setDebugLog(z);
        LogUtil.m26097d(TAG, "setDebuggable ... " + z);
    }

    public void setPreinstallAttrbution(String str, String str2) {
        AppsFlyerLib.getInstance().setPreinstallAttribution(Build.MANUFACTURER, str, str2);
        LogUtil.m26097d(TAG, "setPreinstallAttrbution ... campaignName : " + str + " , testId : " + str2);
    }

    public void delayUploadCustomerId(Application application, String str) {
        AppsFlyerLib.getInstance().startTracking(application);
        AppsFlyerLib.getInstance().setCustomerIdAndTrack(str, application);
        LogUtil.m26097d(TAG, "delayUploadCustomerId ... userId : " + str);
    }

    private static void setFcmInterceptor() {
        PushTokenInterceptor.addInterceptor(interceptor);
    }
}

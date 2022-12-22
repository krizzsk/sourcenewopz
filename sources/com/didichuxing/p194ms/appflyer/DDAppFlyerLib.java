package com.didichuxing.p194ms.appflyer;

import android.app.Application;
import com.appsflyer.AppsFlyerConversionListener;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didichuxing.foundation.spi.ServiceLoader;

/* renamed from: com.didichuxing.ms.appflyer.DDAppFlyerLib */
public class DDAppFlyerLib {
    public static final String TAG = "DDAppFlyerLib";

    /* renamed from: com.didichuxing.ms.appflyer.DDAppFlyerLib$Instance */
    private static final class Instance {
        /* access modifiers changed from: private */
        public static final IAppFlyer INSTANCE;

        private Instance() {
        }

        static {
            IAppFlyer iAppFlyer = (IAppFlyer) ServiceLoader.load(IAppFlyer.class).get();
            if (iAppFlyer != null) {
                INSTANCE = iAppFlyer;
                LogUtil.m26097d(DDAppFlyerLib.TAG, iAppFlyer.getClass().getSimpleName() + "  load");
                return;
            }
            INSTANCE = null;
        }
    }

    @Deprecated
    public static void init(Application application, String str) {
        if (Instance.INSTANCE != null) {
            Instance.INSTANCE.init(application, str);
        }
        LogUtil.m26097d(TAG, "init ... key : " + str);
    }

    @Deprecated
    public static void init(Application application, String str, String str2) {
        if (Instance.INSTANCE != null) {
            Instance.INSTANCE.init(application, str, str2);
        }
        LogUtil.m26097d(TAG, "init ... key : " + str + " , userid : " + str2);
    }

    public static void initialize(Application application, String str, String str2) {
        if (Instance.INSTANCE != null) {
            Instance.INSTANCE.initialize(application, str, str2);
        }
        LogUtil.m26097d(TAG, "initialize ... key : " + str + " , userid : " + str2);
    }

    public static void initialize(Application application, String str, AppsFlyerConversionListener appsFlyerConversionListener, String str2) {
        if (Instance.INSTANCE != null) {
            Instance.INSTANCE.initialize(application, str, appsFlyerConversionListener, str2);
        }
        LogUtil.m26097d(TAG, "initialize ... key : " + str + " , userid : " + str2);
    }

    public static void delayInit(Application application, String str, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (Instance.INSTANCE != null) {
            Instance.INSTANCE.delayInit(application, str, appsFlyerConversionListener);
        }
        LogUtil.m26097d(TAG, "delayInit ... key : " + str);
    }

    public static void delayInit(Application application, String str) {
        delayInit(application, str, new DefaultAppsFlyerConversionListener());
        LogUtil.m26097d(TAG, "delayInit ...  key : " + str);
    }

    public static void setDebuggable(boolean z) {
        if (Instance.INSTANCE != null) {
            Instance.INSTANCE.setDebuggable(z);
        }
        LogUtil.m26097d(TAG, "setDebuggable ... " + z);
    }

    public static void setPreinstallAttrbution(String str, String str2) {
        if (Instance.INSTANCE != null) {
            Instance.INSTANCE.setPreinstallAttrbution(str, str2);
        }
        LogUtil.m26097d(TAG, "setPreinstallAttrbution ... campaignName : " + str + " , testId : " + str2);
    }

    public static void delayUploadCustomerId(Application application, String str) {
        if (Instance.INSTANCE != null) {
            Instance.INSTANCE.delayUploadCustomerId(application, str);
        }
        LogUtil.m26097d(TAG, "delayUploadCustomerId ... userId : " + str);
    }
}

package com.didichuxing.p194ms.appflyer;

import android.app.Application;
import com.appsflyer.AppsFlyerConversionListener;

/* renamed from: com.didichuxing.ms.appflyer.IAppFlyer */
public interface IAppFlyer {
    void delayInit(Application application, String str);

    void delayInit(Application application, String str, AppsFlyerConversionListener appsFlyerConversionListener);

    void delayUploadCustomerId(Application application, String str);

    @Deprecated
    void init(Application application, String str);

    @Deprecated
    void init(Application application, String str, String str2);

    void initialize(Application application, String str, AppsFlyerConversionListener appsFlyerConversionListener, String str2);

    void initialize(Application application, String str, String str2);

    void setDebuggable(boolean z);

    void setPreinstallAttrbution(String str, String str2);
}

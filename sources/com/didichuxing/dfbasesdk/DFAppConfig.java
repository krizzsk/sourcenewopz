package com.didichuxing.dfbasesdk;

import android.content.Context;
import com.didichuxing.dfbasesdk.utils.LogUtils;

public class DFAppConfig {

    /* renamed from: c */
    private static DFAppConfig f46468c = new DFAppConfig();

    /* renamed from: a */
    private IAppConfig f46469a;

    /* renamed from: b */
    private ILogReporter f46470b;

    private DFAppConfig() {
    }

    public static DFAppConfig getInstance() {
        return f46468c;
    }

    @Deprecated
    public void setAppConfig(IAppConfig iAppConfig) {
        LogUtils.m33569i("DFAppConfig#setAppConfig, config====" + iAppConfig);
        this.f46469a = iAppConfig;
        if (iAppConfig != null) {
            AppContextHolder.init(iAppConfig.getAppContext());
        }
    }

    public IAppConfig getAppConfig() {
        return this.f46469a;
    }

    public Context getAppContext() {
        return AppContextHolder.getAppContext();
    }

    public boolean isDebug() {
        IAppConfig iAppConfig = this.f46469a;
        return iAppConfig != null && iAppConfig.isDebug();
    }

    public ILogReporter logReporter() {
        return this.f46470b;
    }

    public void setLogReporter(ILogReporter iLogReporter) {
        this.f46470b = iLogReporter;
    }
}

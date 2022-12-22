package com.kwai.koom.javaoom.common;

import android.app.Application;
import com.kwai.koom.javaoom.monitor.HeapThreshold;
import com.kwai.koom.javaoom.report.DefaultRunningInfoFetcher;
import java.io.File;

public class KGlobalConfig {

    /* renamed from: a */
    static final String f55587a = "koom";

    /* renamed from: b */
    static final String f55588b = "hprof";

    /* renamed from: c */
    static final String f55589c = "report";

    /* renamed from: d */
    private static KGlobalConfig f55590d;

    /* renamed from: g */
    private static String f55591g;

    /* renamed from: h */
    private static String f55592h;

    /* renamed from: i */
    private static String f55593i;

    /* renamed from: e */
    private Application f55594e;

    /* renamed from: f */
    private KConfig f55595f;

    /* renamed from: j */
    private RunningInfoFetcher f55596j;

    /* renamed from: k */
    private KSoLoader f55597k;

    private KGlobalConfig() {
    }

    /* renamed from: a */
    private static KGlobalConfig m40095a() {
        KGlobalConfig kGlobalConfig = f55590d;
        if (kGlobalConfig != null) {
            return kGlobalConfig;
        }
        KGlobalConfig kGlobalConfig2 = new KGlobalConfig();
        f55590d = kGlobalConfig2;
        return kGlobalConfig2;
    }

    public void setApplicationInternal(Application application) {
        this.f55594e = application;
        this.f55596j = new DefaultRunningInfoFetcher(application);
    }

    public static void setApplication(Application application) {
        m40095a().setApplicationInternal(application);
    }

    public static Application getApplication() {
        return m40095a().f55594e;
    }

    public static void setKConfig(KConfig kConfig) {
        m40095a().setKConfigInternal(kConfig);
    }

    public void setKConfigInternal(KConfig kConfig) {
        this.f55595f = kConfig;
    }

    public static KConfig getKConfig() {
        return m40095a().f55595f;
    }

    public static HeapThreshold getHeapThreshold() {
        return m40095a().f55595f.getHeapThreshold();
    }

    public static void setRootDir(String str) {
        m40095a().f55595f.setRootDir(str);
    }

    public static String getRootDir() {
        String str = f55591g;
        if (str != null) {
            return str;
        }
        String rootDir = m40095a().f55595f.getRootDir();
        f55591g = rootDir;
        return rootDir;
    }

    public static String getReportDir() {
        String str = f55592h;
        if (str != null) {
            return str;
        }
        String str2 = getRootDir() + File.separator + f55589c;
        f55592h = str2;
        return str2;
    }

    public static String getHprofDir() {
        String str = f55593i;
        if (str != null) {
            return str;
        }
        String str2 = getRootDir() + File.separator + f55588b;
        f55593i = str2;
        return str2;
    }

    public static RunningInfoFetcher getRunningInfoFetcher() {
        return m40095a().f55596j;
    }

    public static void setSoLoader(KSoLoader kSoLoader) {
        m40095a().f55597k = kSoLoader;
    }

    public static KSoLoader getSoLoader() {
        KSoLoader kSoLoader = m40095a().f55597k;
        if (kSoLoader != null) {
            return kSoLoader;
        }
        KGlobalConfig a = m40095a();
        DefaultKSoLoader defaultKSoLoader = new DefaultKSoLoader();
        a.f55597k = defaultKSoLoader;
        return defaultKSoLoader;
    }
}

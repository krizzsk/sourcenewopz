package com.didi.dimina.container.bundle;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.bundle.bean.BundleConfig;
import com.didi.dimina.container.util.LogUtil;

public class BundleManager {
    public static final String TAG_PCK = "Dimina-PM ";

    /* renamed from: a */
    private static final String f16782a = "Dimina-PM BundleManager";

    public static BundleManager getInstance() {
        return Holder.HOLD;
    }

    private static class Holder {
        static BundleManager HOLD = new BundleManager();

        private Holder() {
        }
    }

    private BundleManager() {
    }

    public void cancelDownloadOtherPackage(DMMina dMMina) {
        LogUtil.iRelease(f16782a, "cancelDownloadOtherModule() >>>> ");
        dMMina.getConfig().getLaunchConfig().getBundleManagerStrategy().cancelDownloadOtherPackage(dMMina);
    }

    public void install(DMMina dMMina, BundleManagerStrategy.InstallCallback installCallback) {
        LogUtil.iRelease(f16782a, "install() >>>> mina=" + dMMina + "\t cb=" + installCallback);
        dMMina.getConfig().getLaunchConfig().getBundleManagerStrategy().install(dMMina, installCallback);
    }

    public void installSubpackage(boolean z, DMMina dMMina, String str, BundleManagerStrategy.SubpackageInfoCallback subpackageInfoCallback) {
        LogUtil.iRelease(f16782a, "installSubPackage() >>>> mina=" + dMMina + "\t moduleName=" + str + "\t cb=" + subpackageInfoCallback);
        dMMina.getConfig().getLaunchConfig().getBundleManagerStrategy().installSubpackage(z, dMMina, str, subpackageInfoCallback);
    }

    public void isSubpackageInstalled(DMMina dMMina, String str, BundleManagerStrategy.SubpackageInstallCallback subpackageInstallCallback) {
        LogUtil.iRelease(f16782a, "isModuleInstalled() >>>> mina=" + dMMina + "\t moduleName=" + str + "\t cb=" + subpackageInstallCallback);
        dMMina.getConfig().getLaunchConfig().getBundleManagerStrategy().isSubpackageInstalled(dMMina, str, subpackageInstallCallback);
    }

    public void requireContent(DMMina dMMina, String str, String str2, BundleManagerStrategy.ReadFileCallBack readFileCallBack) {
        LogUtil.iRelease(f16782a, "requireContent() >>>> mina=" + dMMina + "\t moduleName=" + str + "\t subPath=" + str2 + "\t cb=" + readFileCallBack);
        dMMina.getConfig().getLaunchConfig().getBundleManagerStrategy().requireContent(dMMina, str, str2, readFileCallBack);
    }

    public String transform2AbsolutePath(DMMina dMMina, String str, String str2) {
        LogUtil.iRelease(f16782a, "transformPureUrl() 进入>>>> mina=" + dMMina + "\t moduleName=" + str + "\t subPath=" + str2);
        return dMMina.getConfig().getLaunchConfig().getBundleManagerStrategy().transform2AbsolutePath(dMMina, str, str2);
    }

    public String transformUrl(DMMina dMMina, String str, String str2) {
        LogUtil.iRelease(f16782a, "transformUrl() >>>> 进入" + dMMina + "\t moduleName=" + str);
        String transform2AbsolutePath = transform2AbsolutePath(dMMina, str, str2);
        if (TextUtils.isEmpty(transform2AbsolutePath)) {
            return "";
        }
        if (!transform2AbsolutePath.startsWith("http")) {
            transform2AbsolutePath = "file://" + transform2AbsolutePath;
        }
        LogUtil.iRelease(f16782a, "transformUrl()-> moduleName=" + str + "\t subPath=" + str2 + "\t resultStr=" + transform2AbsolutePath);
        return transform2AbsolutePath;
    }

    public AppInfo.ModuleInfo getAppPackageInfo(DMMina dMMina, String str) {
        if (dMMina == null || dMMina.getJsAppBundleConfig() == null) {
            return null;
        }
        BundleConfig jsAppBundleConfig = dMMina.getJsAppBundleConfig();
        AppInfo.ModuleInfo moduleInfo = new AppInfo.ModuleInfo();
        moduleInfo.moduleName = str;
        moduleInfo.version = jsAppBundleConfig.versionCode;
        moduleInfo.versionName = jsAppBundleConfig.versionName;
        return moduleInfo;
    }

    public AppInfo.ModuleInfo getSDKPackageInfo(DMMina dMMina, String str) {
        BundleConfig jsSdkBundleConfig;
        if (dMMina == null || dMMina.getJsSdkBundleConfig() == null || (jsSdkBundleConfig = dMMina.getJsSdkBundleConfig()) == null) {
            return null;
        }
        AppInfo.ModuleInfo moduleInfo = new AppInfo.ModuleInfo();
        moduleInfo.version = jsSdkBundleConfig.versionCode;
        moduleInfo.versionName = jsSdkBundleConfig.versionName;
        moduleInfo.moduleName = str;
        return moduleInfo;
    }
}

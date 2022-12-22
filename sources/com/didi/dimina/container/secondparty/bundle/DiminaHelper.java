package com.didi.dimina.container.secondparty.bundle;

import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.bundle.bean.BundleConfig;
import com.didi.dimina.container.mina.DMMinaHelper;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.strategy.ReleaseBundleMangerStrategy;
import com.didi.dimina.container.secondparty.bundle.util.ReleaseBundleDataAdapter;
import com.didi.dimina.container.util.CollectionsUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0007J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0007J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/DiminaHelper;", "", "()V", "TAG", "", "getAppInfo", "Lcom/didi/dimina/container/bundle/bean/AppInfo;", "mina", "Lcom/didi/dimina/container/DMMina;", "jsId", "config", "Lcom/didi/dimina/container/bundle/bean/BundleConfig;", "getJsAppAssetDir", "dmmina", "getJsAppId", "dmMina", "getJsAppVersionCode", "getJsAppVersionName", "getJsSdkAssetDir", "getJsSdkId", "getJsSdkVersionCode", "getJsSdkVersionName", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DiminaHelper.kt */
public final class DiminaHelper {
    public static final DiminaHelper INSTANCE = new DiminaHelper();
    public static final String TAG = "DiminaHelper";

    private DiminaHelper() {
    }

    @JvmStatic
    public static final String getJsSdkId(DMMina dMMina) {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        String jsSdkId = config.getJsSdkId();
        return jsSdkId != null ? jsSdkId : Constant.DEFAULT_JS_SDK_ID;
    }

    @JvmStatic
    public static final String getJsAppId(DMMina dMMina) {
        Intrinsics.checkParameterIsNotNull(dMMina, "dmMina");
        return DMMinaHelper.getJsAppId(dMMina);
    }

    @JvmStatic
    public static final String getJsSdkAssetDir(DMMina dMMina) {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        if (config.isJsSdkDefault()) {
            return PmConstant.JSSDK_ASSETS_DIR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PmConstant.JSSDK_ASSETS_DIR);
        sb.append(File.separator);
        Dimina.Config config2 = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config2, "Dimina.getConfig()");
        sb.append(config2.getJsSdkId());
        return sb.toString();
    }

    @JvmStatic
    public static final String getJsAppAssetDir(DMMina dMMina) {
        Intrinsics.checkParameterIsNotNull(dMMina, "dmmina");
        String str = null;
        DMConfig config = dMMina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "dmmina.config");
        DMConfig.LaunchConfig launchConfig = config.getLaunchConfig();
        Intrinsics.checkExpressionValueIsNotNull(launchConfig, "dmmina.config.launchConfig");
        if (launchConfig.getBundleManagerStrategy() instanceof ReleaseBundleMangerStrategy) {
            DMConfig config2 = dMMina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config2, "dmmina.config");
            DMConfig.LaunchConfig launchConfig2 = config2.getLaunchConfig();
            Intrinsics.checkExpressionValueIsNotNull(launchConfig2, "dmmina.config.launchConfig");
            BundleManagerStrategy bundleManagerStrategy = launchConfig2.getBundleManagerStrategy();
            if (bundleManagerStrategy != null) {
                str = ((ReleaseBundleMangerStrategy) bundleManagerStrategy).getAssetPath();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.didi.dimina.container.secondparty.bundle.strategy.ReleaseBundleMangerStrategy");
            }
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        if (str != null) {
            return str;
        }
        Intrinsics.throwNpe();
        return str;
    }

    @JvmStatic
    public static final AppInfo getAppInfo(DMMina dMMina, String str, BundleConfig bundleConfig) {
        DMConfigBean DMMina2DMConfigBean = ReleaseBundleDataAdapter.DMMina2DMConfigBean(dMMina);
        if (DMMina2DMConfigBean == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        CharSequence charSequence = str;
        if (TextUtils.equals(charSequence, DMMina2DMConfigBean.getAppId())) {
            appInfo.f16786id = str;
            appInfo.version = DMMina2DMConfigBean.getAppVersionCode();
            appInfo.versionName = DMMina2DMConfigBean.getAppVersionName();
            if (CollectionsUtil.isEmpty((Collection) DMMina2DMConfigBean.getAppModules())) {
                return appInfo;
            }
            List<AppInfo.ModuleInfo> arrayList = new ArrayList<>();
            for (DMConfigBean.AppModulesBean next : DMMina2DMConfigBean.getAppModules()) {
                AppInfo.ModuleInfo moduleInfo = new AppInfo.ModuleInfo();
                Intrinsics.checkExpressionValueIsNotNull(next, "appModule");
                moduleInfo.moduleName = next.getModuleName();
                moduleInfo.version = next.getVersion();
                moduleInfo.versionName = next.getVersionName();
                arrayList.add(moduleInfo);
            }
            appInfo.moduleInfos = arrayList;
            return appInfo;
        } else if (!TextUtils.equals(charSequence, DMMina2DMConfigBean.getSdkId(dMMina))) {
            return null;
        } else {
            appInfo.f16786id = str;
            appInfo.version = DMMina2DMConfigBean.getSdkVersionCode();
            appInfo.versionName = DMMina2DMConfigBean.getSdkVersionName();
            if (DMMina2DMConfigBean.getSdkModule() == null) {
                return appInfo;
            }
            AppInfo.ModuleInfo moduleInfo2 = new AppInfo.ModuleInfo();
            DMConfigBean.AppModulesBean sdkModule = DMMina2DMConfigBean.getSdkModule();
            Intrinsics.checkExpressionValueIsNotNull(sdkModule, "appInfoDmConfigBean.sdkModule");
            moduleInfo2.moduleName = sdkModule.getModuleName();
            moduleInfo2.version = DMMina2DMConfigBean.getSdkVersionCode();
            moduleInfo2.versionName = DMMina2DMConfigBean.getSdkVersionName();
            List<AppInfo.ModuleInfo> arrayList2 = new ArrayList<>();
            arrayList2.add(moduleInfo2);
            appInfo.moduleInfos = arrayList2;
            return appInfo;
        }
    }

    @JvmStatic
    public static final String getJsSdkVersionCode(DMMina dMMina) {
        BundleConfig jsSdkBundleConfig;
        if (dMMina == null || (jsSdkBundleConfig = dMMina.getJsSdkBundleConfig()) == null) {
            return null;
        }
        return jsSdkBundleConfig.versionCode;
    }

    @JvmStatic
    public static final String getJsAppVersionCode(DMMina dMMina) {
        BundleConfig jsAppBundleConfig;
        if (dMMina == null || (jsAppBundleConfig = dMMina.getJsAppBundleConfig()) == null) {
            return null;
        }
        return jsAppBundleConfig.versionCode;
    }

    @JvmStatic
    public static final String getJsAppVersionName(DMMina dMMina) {
        BundleConfig jsAppBundleConfig;
        if (dMMina == null || (jsAppBundleConfig = dMMina.getJsAppBundleConfig()) == null) {
            return null;
        }
        return jsAppBundleConfig.versionName;
    }

    @JvmStatic
    public static final String getJsSdkVersionName(DMMina dMMina) {
        BundleConfig jsSdkBundleConfig;
        if (dMMina == null || (jsSdkBundleConfig = dMMina.getJsSdkBundleConfig()) == null) {
            return null;
        }
        return jsSdkBundleConfig.versionName;
    }
}

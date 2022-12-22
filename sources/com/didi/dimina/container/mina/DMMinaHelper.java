package com.didi.dimina.container.mina;

import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.RemoteBundleMangerStrategy;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.NavigateUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/dimina/container/mina/DMMinaHelper;", "", "()V", "TAG", "", "getCurPath", "mina", "Lcom/didi/dimina/container/DMMina;", "getEntryPath", "getJsAppId", "dmMina", "getJsSdkId", "getLaunchType", "", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DMMinaHelper.kt */
public final class DMMinaHelper {
    public static final DMMinaHelper INSTANCE = new DMMinaHelper();
    public static final String TAG = "DMMinaHelper";

    private DMMinaHelper() {
    }

    @JvmStatic
    public static final String getEntryPath(DMMina dMMina) {
        JSAppConfig jSAppConfig;
        DMConfig config;
        DMConfig.LaunchConfig launchConfig;
        String entryPath;
        if (dMMina != null && (config = dMMina.getConfig()) != null && (launchConfig = config.getLaunchConfig()) != null && (entryPath = launchConfig.getEntryPath()) != null) {
            return entryPath;
        }
        if (dMMina == null || (jSAppConfig = dMMina.getJSAppConfig()) == null) {
            return null;
        }
        return jSAppConfig.entryPagePath;
    }

    @JvmStatic
    public static final String getCurPath(DMMina dMMina) {
        try {
            DMPage curPage = NavigateUtil.getCurPage(dMMina);
            return HttpUtil.splitPath(curPage != null ? curPage.getUrl() : null);
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final int getLaunchType(DMMina dMMina) {
        String remoteUrl;
        int i = -1;
        if (dMMina != null) {
            DMConfig config = dMMina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config, "mina.config");
            DMConfig.LaunchConfig launchConfig = config.getLaunchConfig();
            Intrinsics.checkExpressionValueIsNotNull(launchConfig, "mina.config.launchConfig");
            String tag = launchConfig.getBundleManagerStrategy().getTag();
            int hashCode = tag.hashCode();
            if (hashCode != -934610874) {
                if (hashCode != 103145323) {
                    if (hashCode == 1090594823 && tag.equals("release")) {
                        return 0;
                    }
                } else if (tag.equals("local")) {
                    return 2;
                }
            } else if (tag.equals("remote")) {
                DMConfig config2 = dMMina.getConfig();
                Intrinsics.checkExpressionValueIsNotNull(config2, "mina.config");
                DMConfig.LaunchConfig launchConfig2 = config2.getLaunchConfig();
                Intrinsics.checkExpressionValueIsNotNull(launchConfig2, "mina.config.launchConfig");
                BundleManagerStrategy bundleManagerStrategy = launchConfig2.getBundleManagerStrategy();
                if (!(bundleManagerStrategy instanceof RemoteBundleMangerStrategy)) {
                    bundleManagerStrategy = null;
                }
                RemoteBundleMangerStrategy remoteBundleMangerStrategy = (RemoteBundleMangerStrategy) bundleManagerStrategy;
                i = 1;
                if (remoteBundleMangerStrategy == null || (remoteUrl = remoteBundleMangerStrategy.getRemoteUrl()) == null || !StringsKt.startsWith$default(remoteUrl, "http", false, 2, (Object) null)) {
                    return i;
                }
                return 3;
            }
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r1 = (r1 = r1.getLaunchConfig()).getAppId();
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getJsAppId(com.didi.dimina.container.DMMina r1) {
        /*
            java.lang.String r0 = "dmMina"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            com.didi.dimina.container.DMConfig r1 = r1.getConfig()
            if (r1 == 0) goto L_0x0018
            com.didi.dimina.container.DMConfig$LaunchConfig r1 = r1.getLaunchConfig()
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = r1.getAppId()
            if (r1 == 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            java.lang.String r1 = ""
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.mina.DMMinaHelper.getJsAppId(com.didi.dimina.container.DMMina):java.lang.String");
    }

    @JvmStatic
    public static final String getJsSdkId() {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        String jsSdkId = config.getJsSdkId();
        return jsSdkId != null ? jsSdkId : Constant.DEFAULT_JS_SDK_ID;
    }
}

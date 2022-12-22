package com.didi.dimina.container.bridge;

import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;
import org.json.JSONObject;

public class PreLoadSubPackageSubJSBridge {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final DMMina f16647a;

    public PreLoadSubPackageSubJSBridge(DMMina dMMina, DMConfig dMConfig) {
        this.f16647a = dMMina;
        LogUtil.m13411i("PreLoadSubPackageSubJSBridge init");
    }

    public void preloadSubPackage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int minaIndex = this.f16647a.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PACKAGE_PRELOAD_SUB_PACKAGE_START, "params: " + jSONObject);
        String optString = jSONObject.optString("package", "");
        if (TextUtils.isEmpty(optString)) {
            int minaIndex2 = this.f16647a.getMinaIndex();
            TraceUtil.trackEventCoreDotting(minaIndex2, Constant.CORE_DOTTING.PACKAGE_PRELOAD_SUB_PACKAGE_FAILED, "params: " + jSONObject);
            CallBackUtil.onFail("预加载传入页面为空", callbackFunction);
            return;
        }
        LogUtil.iRelease(InternalJSMethod.PRELOAD_SUB_PACKAGE, "开始预加载分包 packageName:" + optString);
        BundleManager.getInstance().isSubpackageInstalled(this.f16647a, optString, new BundleManagerStrategy.SubpackageInstallCallback(optString, this.f16647a.getConfig().getLaunchConfig().getBundleManagerStrategy(), callbackFunction) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ BundleManagerStrategy f$2;
            public final /* synthetic */ CallbackFunction f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void callback(boolean z) {
                PreLoadSubPackageSubJSBridge.this.m12278a(this.f$1, this.f$2, this.f$3, z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12278a(String str, BundleManagerStrategy bundleManagerStrategy, CallbackFunction callbackFunction, boolean z) {
        if (z) {
            LogUtil.iRelease(InternalJSMethod.PRELOAD_SUB_PACKAGE, "加载分包已存在，直接加载 packageName:" + str);
            int minaIndex = this.f16647a.getMinaIndex();
            TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PACKAGE_PRELOAD_SUB_PACKAGE_SUCCESS, "type: " + bundleManagerStrategy.getTag() + ", isInstall");
            CallBackUtil.onSuccess(callbackFunction);
            return;
        }
        final long currentNanoMillis = TimeUtil.currentNanoMillis();
        final CallbackFunction callbackFunction2 = callbackFunction;
        final String str2 = str;
        BundleManager.getInstance().installSubpackage(true, this.f16647a, str, new BundleManagerStrategy.SubpackageInfoCallback() {
            public void callback(int i, AppInfo.ModuleInfo moduleInfo) {
                if (i == 0) {
                    PreLoadSubPackageSubJSBridge.this.f16647a.getPerformance().appendStartSubPackageLoadTime(TimeUtil.currentNanoMillis() - currentNanoMillis);
                    int minaIndex = PreLoadSubPackageSubJSBridge.this.f16647a.getMinaIndex();
                    TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PACKAGE_PRELOAD_SUB_PACKAGE_SUCCESS, "type: releaseAction, moduleInfo: " + moduleInfo);
                    CallBackUtil.onSuccess(callbackFunction2);
                    return;
                }
                int minaIndex2 = PreLoadSubPackageSubJSBridge.this.f16647a.getMinaIndex();
                TraceUtil.trackEventCoreDotting(minaIndex2, Constant.CORE_DOTTING.PACKAGE_PRELOAD_SUB_PACKAGE_FAILED, "type: releaseAction, errCode: " + i);
                CallBackUtil.onFail("预加载分包" + str2 + "失败", callbackFunction2);
            }
        });
    }
}

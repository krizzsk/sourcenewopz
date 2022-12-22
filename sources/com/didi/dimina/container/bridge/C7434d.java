package com.didi.dimina.container.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.loading.DefaultLoadingManager;
import com.didi.dimina.container.bridge.loadsubpackage.CustomSubpackageLoadingManager;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.monitor.TrackSubPackExec;
import com.didi.dimina.container.p106ui.loadpage.AbsLoadingManager;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.d */
/* compiled from: PackageSubJSBridge */
class C7434d {

    /* renamed from: a */
    public static final String f16711a = "PackageSubJSBridge";

    /* renamed from: b */
    private final DMConfig f16712b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final DMMina f16713c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AbsLoadingManager f16714d;

    public C7434d(DMMina dMMina, Context context, DMConfig dMConfig) {
        this.f16713c = dMMina;
        this.f16712b = dMConfig;
        if (dMConfig == null || dMConfig.getUIConfig().getSubPackageLoadingViewClazz() == null) {
            this.f16714d = new DefaultLoadingManager(context, (String) null, this.f16713c);
        } else {
            this.f16714d = new CustomSubpackageLoadingManager(context, this.f16713c);
        }
        LogUtil.m13411i("PackageSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54694a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int minaIndex = this.f16713c.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_START, "params: " + jSONObject);
        String optString = jSONObject.optString("package", "");
        if (TextUtils.isEmpty(optString)) {
            optString = "app";
        }
        this.f16713c.getPerformance().markJSPackageStart();
        LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, "开始加载分包 packageName:" + optString);
        BundleManager.getInstance().isSubpackageInstalled(this.f16713c, optString, new BundleManagerStrategy.SubpackageInstallCallback(optString, callbackFunction, "/app-service.js") {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ CallbackFunction f$2;
            public final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void callback(boolean z) {
                C7434d.this.m12385a(this.f$1, this.f$2, this.f$3, z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12385a(String str, CallbackFunction callbackFunction, String str2, boolean z) {
        if (z) {
            LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, "分包已存在，直接读取分包 packageName:" + str);
            m12382a(callbackFunction, str, str2);
            return;
        }
        this.f16714d.show();
        LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, "isInstall 为false, packageName:" + str);
        BundleManager.getInstance().cancelDownloadOtherPackage(this.f16713c);
        BundleManager.getInstance().installSubpackage(false, this.f16713c, str, new PackageSubJSBridge$1(this, TimeUtil.currentNanoMillis(), callbackFunction, str, str2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12382a(CallbackFunction callbackFunction, String str, String str2) {
        BundleManager.getInstance().requireContent(this.f16713c, str, str2, new BundleManagerStrategy.ReadFileCallBack(str, str2, callbackFunction) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ CallbackFunction f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onRead(boolean z, BundleManagerStrategy.FileInfo fileInfo) {
                C7434d.this.m12386a(this.f$1, this.f$2, this.f$3, z, fileInfo);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12386a(String str, String str2, CallbackFunction callbackFunction, boolean z, BundleManagerStrategy.FileInfo fileInfo) {
        if (!z) {
            LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, "分包：" + str + str2 + "  内容为空");
            this.f16714d.dismiss();
            CallBackUtil.onFail("加载包" + str + str2 + "失败", callbackFunction);
            TraceUtil.trackEventCoreDotting(this.f16713c.getMinaIndex(), Constant.CORE_DOTTING.PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_FAILED, "content is empty");
            return;
        }
        LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, "分包：" + str + str2 + "  加载成功");
        String appId = this.f16713c.getConfig().getLaunchConfig().getAppId();
        StringBuilder sb = new StringBuilder();
        sb.append("loadJSFileToDataThread-> mDmMina.getJsAppBundleConfig");
        sb.append(this.f16713c.getJsAppBundleConfig());
        LogUtil.iRelease(f16711a, sb.toString());
        AppInfo.ModuleInfo appPackageInfo = BundleManager.getInstance().getAppPackageInfo(this.f16713c, str);
        String str3 = appPackageInfo != null ? appPackageInfo.version : "";
        if (TextUtils.isEmpty(str3)) {
            this.f16713c.getJSEngine().executeScriptFile(fileInfo.getContent(), fileInfo.getFilePath(), new TrackSubPackExec(this.f16713c, str, new IDMCommonAction(callbackFunction) {
                public final /* synthetic */ CallbackFunction f$1;

                {
                    this.f$1 = r2;
                }

                public final void callback(Object obj) {
                    C7434d.this.m12388b(this.f$1, (Void) obj);
                }
            }));
        } else {
            this.f16713c.getJSEngine().executeScriptFile(fileInfo.getContent(), fileInfo.getFilePath(), this.f16713c.getMinaIndex(), appId, str, str2, str3, new TrackSubPackExec(this.f16713c, str, new IDMCommonAction(callbackFunction) {
                public final /* synthetic */ CallbackFunction f$1;

                {
                    this.f$1 = r2;
                }

                public final void callback(Object obj) {
                    C7434d.this.m12383a(this.f$1, (Void) obj);
                }
            }));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m12388b(CallbackFunction callbackFunction, Void voidR) {
        this.f16713c.getPerformance().markJSPackageEnd();
        this.f16714d.dismiss();
        CallBackUtil.onSuccess(callbackFunction);
        TraceUtil.trackEventCoreDotting(this.f16713c.getMinaIndex(), Constant.CORE_DOTTING.PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_SUCCESS, "type: localAction/remoteAction, isInstall");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12383a(CallbackFunction callbackFunction, Void voidR) {
        this.f16713c.getPerformance().markJSPackageEnd();
        this.f16714d.dismiss();
        CallBackUtil.onSuccess(callbackFunction);
        TraceUtil.trackEventCoreDotting(this.f16713c.getMinaIndex(), Constant.CORE_DOTTING.PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_SUCCESS, "type: releaseAction, isInstall");
    }
}

package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.LocalBundleMangerStrategy;
import com.didi.dimina.container.bundle.RemoteBundleMangerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.NavigateUtil;
import com.didi.dimina.container.util.PixUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didichuxing.omega.sdk.common.utils.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.f */
/* compiled from: SystemInfoSubJSBridge */
class C7436f {

    /* renamed from: a */
    private final Activity f16725a;

    /* renamed from: b */
    private final DMMina f16726b;

    /* renamed from: c */
    private final JSONObject f16727c = new JSONObject();

    /* renamed from: d */
    private final JSONObject f16728d = new JSONObject();

    /* renamed from: e */
    private final HashMap<Integer, JSONObject> f16729e = new HashMap<>();

    /* renamed from: f */
    private JSONObject f16730f;

    C7436f(DMMina dMMina, Activity activity) {
        this.f16725a = activity;
        this.f16726b = dMMina;
        m12407e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0203 A[SYNTHETIC, Splitter:B:12:0x0203] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0282 A[SYNTHETIC, Splitter:B:27:0x0282] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x02a7 A[SYNTHETIC, Splitter:B:34:0x02a7] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12407e() {
        /*
            r15 = this;
            java.lang.String r0 = "SDKVersion"
            java.lang.String r1 = "SDKVersion 为空"
            java.lang.String r2 = "appVersion"
            java.lang.String r3 = "jssdkid"
            java.lang.String r4 = "jssdkVersion"
            com.didi.dimina.container.Dimina$Config r5 = com.didi.dimina.container.Dimina.getConfig()
            com.didi.dimina.container.Dimina$AdapterConfig r5 = r5.getAdapterConfig()
            com.didi.dimina.container.service.WsgService r5 = r5.getWsgService()
            android.app.Activity r6 = r15.f16725a
            java.lang.String r5 = r5.getBrand(r6)
            com.didi.dimina.container.Dimina$Config r6 = com.didi.dimina.container.Dimina.getConfig()
            com.didi.dimina.container.Dimina$AdapterConfig r6 = r6.getAdapterConfig()
            com.didi.dimina.container.service.WsgService r6 = r6.getWsgService()
            android.app.Activity r7 = r15.f16725a
            java.lang.String r6 = r6.getModel(r7)
            float r7 = r15.m12408f()
            int r8 = r15.mo54709c()
            int r9 = r15.mo54711d()
            java.lang.String r10 = r15.mo54707b()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            com.didi.dimina.container.DMMina r12 = r15.f16726b
            com.didi.dimina.container.DMConfig r12 = r12.getConfig()
            com.didi.dimina.container.DMConfig$LaunchConfig r12 = r12.getLaunchConfig()
            java.lang.String r12 = r12.getAppId()
            r11.append(r12)
            java.lang.String r12 = ""
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            android.app.Activity r12 = r15.f16725a
            int r12 = com.didi.dimina.container.p106ui.statusbar.ImmersionBar.getNavigationBarHeight((android.app.Activity) r12)
            int r12 = r9 - r12
            org.json.JSONObject r13 = r15.f16727c
            java.lang.String r14 = "brand"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r13, (java.lang.String) r14, (java.lang.Object) r5)
            org.json.JSONObject r5 = r15.f16727c
            java.lang.String r13 = "model"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r13, (java.lang.Object) r6)
            org.json.JSONObject r5 = r15.f16727c
            double r6 = (double) r7
            java.lang.String r13 = "pixelRatio"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r13, (double) r6)
            org.json.JSONObject r5 = r15.f16727c
            android.app.Activity r6 = r15.f16725a
            float r7 = (float) r8
            int r6 = com.didi.dimina.container.util.PixUtil.px2dip(r6, r7)
            java.lang.String r8 = "screenWidth"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r8, (int) r6)
            org.json.JSONObject r5 = r15.f16727c
            android.app.Activity r6 = r15.f16725a
            float r8 = (float) r9
            int r6 = com.didi.dimina.container.util.PixUtil.px2dip(r6, r8)
            java.lang.String r8 = "screenHeight"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r8, (int) r6)
            org.json.JSONObject r5 = r15.f16727c
            android.app.Activity r6 = r15.f16725a
            int r6 = com.didi.dimina.container.util.PixUtil.px2dip(r6, r7)
            java.lang.String r8 = "windowWidth"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r8, (int) r6)
            org.json.JSONObject r5 = r15.f16727c
            android.app.Activity r6 = r15.f16725a
            float r8 = (float) r12
            int r6 = com.didi.dimina.container.util.PixUtil.px2dip(r6, r8)
            java.lang.String r9 = "windowHeight"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r9, (int) r6)
            org.json.JSONObject r5 = r15.f16727c
            java.lang.String r6 = "system"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r6, (java.lang.Object) r10)
            org.json.JSONObject r5 = r15.f16727c
            java.lang.String r6 = "platform"
            java.lang.String r9 = "android"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r6, (java.lang.Object) r9)
            org.json.JSONObject r5 = r15.f16727c
            java.lang.String r6 = "appid"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r6, (java.lang.Object) r11)
            org.json.JSONObject r5 = r15.f16727c
            com.didi.dimina.container.Dimina$Config r6 = com.didi.dimina.container.Dimina.getConfig()
            com.didi.dimina.container.Dimina$AdapterConfig r6 = r6.getAdapterConfig()
            com.didi.dimina.container.service.WsgService r6 = r6.getWsgService()
            android.app.Activity r9 = r15.f16725a
            java.lang.String r6 = r6.getAppVersionName(r9)
            java.lang.String r9 = "version"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r9, (java.lang.Object) r6)
            org.json.JSONObject r5 = r15.f16727c
            android.app.Activity r6 = r15.f16725a
            int r9 = com.didi.dimina.container.p106ui.statusbar.ImmersionBar.getStatusBarHeight((android.app.Activity) r6)
            float r9 = (float) r9
            int r6 = com.didi.dimina.container.util.PixUtil.px2dip(r6, r9)
            java.lang.String r9 = "statusBarHeight"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r9, (int) r6)
            com.didi.dimina.container.Dimina$Config r5 = com.didi.dimina.container.Dimina.getConfig()
            com.didi.dimina.container.Dimina$AdapterConfig r5 = r5.getAdapterConfig()
            com.didi.dimina.container.service.WsgService r5 = r5.getWsgService()
            android.app.Activity r6 = r15.f16725a
            java.lang.String r5 = r5.getDeviceId(r6)
            org.json.JSONObject r6 = r15.f16727c
            java.lang.String r9 = "device_id"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r6, (java.lang.String) r9, (java.lang.Object) r5)
            org.json.JSONObject r6 = r15.f16727c
            java.lang.String r9 = "imei"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r6, (java.lang.String) r9, (java.lang.Object) r5)
            org.json.JSONObject r6 = r15.f16727c
            com.didi.dimina.container.Dimina$Config r9 = com.didi.dimina.container.Dimina.getConfig()
            com.didi.dimina.container.Dimina$AdapterConfig r9 = r9.getAdapterConfig()
            com.didi.dimina.container.service.WsgService r9 = r9.getWsgService()
            java.lang.String r9 = r9.getOAID()
            java.lang.String r10 = "oaid"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r6, (java.lang.String) r10, (java.lang.Object) r9)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r9 = "deviceId "
            r6.append(r9)
            r6.append(r5)
            java.lang.String r9 = " imei "
            r6.append(r9)
            r6.append(r5)
            java.lang.String r5 = "  oaid "
            r6.append(r5)
            com.didi.dimina.container.Dimina$Config r5 = com.didi.dimina.container.Dimina.getConfig()
            com.didi.dimina.container.Dimina$AdapterConfig r5 = r5.getAdapterConfig()
            com.didi.dimina.container.service.WsgService r5 = r5.getWsgService()
            java.lang.String r5 = r5.getOAID()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.didi.dimina.container.util.LogUtil.m13411i(r5)
            org.json.JSONObject r5 = r15.f16728d
            java.lang.String r6 = "left"
            r9 = 0
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r6, (int) r9)
            org.json.JSONObject r5 = r15.f16728d
            android.app.Activity r6 = r15.f16725a
            int r6 = com.didi.dimina.container.util.PixUtil.px2dip(r6, r7)
            java.lang.String r10 = "right"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r10, (int) r6)
            org.json.JSONObject r5 = r15.f16728d
            android.app.Activity r6 = r15.f16725a
            float r10 = (float) r9
            int r6 = com.didi.dimina.container.util.PixUtil.px2dip(r6, r10)
            java.lang.String r10 = "top"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r10, (int) r6)
            org.json.JSONObject r5 = r15.f16728d
            android.app.Activity r6 = r15.f16725a
            int r12 = r12 + r9
            float r9 = (float) r12
            int r6 = com.didi.dimina.container.util.PixUtil.px2dip(r6, r9)
            java.lang.String r9 = "bottom"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r9, (int) r6)
            org.json.JSONObject r5 = r15.f16728d
            android.app.Activity r6 = r15.f16725a
            int r6 = com.didi.dimina.container.util.PixUtil.px2dip(r6, r7)
            java.lang.String r7 = "width"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r7, (int) r6)
            org.json.JSONObject r5 = r15.f16728d
            android.app.Activity r6 = r15.f16725a
            int r6 = com.didi.dimina.container.util.PixUtil.px2dip(r6, r8)
            java.lang.String r7 = "height"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r7, (int) r6)
            org.json.JSONObject r5 = r15.f16727c
            org.json.JSONObject r6 = r15.f16728d
            java.lang.String r7 = "safeArea"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r7, (java.lang.Object) r6)
            org.json.JSONObject r5 = r15.f16727c
            com.didi.dimina.container.Dimina$Config r6 = com.didi.dimina.container.Dimina.getConfig()
            com.didi.dimina.container.Dimina$AdapterConfig r6 = r6.getAdapterConfig()
            com.didi.dimina.container.service.WsgService r6 = r6.getWsgService()
            android.app.Activity r7 = r15.f16725a
            boolean r6 = r6.isDebug(r7)
            java.lang.String r7 = "debugEnv"
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r5, (java.lang.String) r7, (int) r6)
            r5 = 0
            com.didi.dimina.container.bundle.BundleManager r6 = com.didi.dimina.container.bundle.BundleManager.getInstance()     // Catch:{ Exception -> 0x022b }
            com.didi.dimina.container.DMMina r7 = r15.f16726b     // Catch:{ Exception -> 0x022b }
            java.lang.String r8 = "DIMINA_JSSDK"
            com.didi.dimina.container.bundle.bean.AppInfo$ModuleInfo r6 = r6.getSDKPackageInfo(r7, r8)     // Catch:{ Exception -> 0x022b }
            java.lang.String r7 = "sdkVersionName"
            if (r6 == 0) goto L_0x01f5
            java.lang.String r8 = r6.versionName     // Catch:{ Exception -> 0x022b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x022b }
            if (r8 != 0) goto L_0x01f5
            org.json.JSONObject r8 = r15.f16727c     // Catch:{ Exception -> 0x022b }
            java.lang.String r9 = r6.versionName     // Catch:{ Exception -> 0x022b }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r8, (java.lang.String) r4, (java.lang.Object) r9)     // Catch:{ Exception -> 0x022b }
            org.json.JSONObject r8 = r15.f16727c     // Catch:{ Exception -> 0x022b }
            java.lang.String r9 = r6.versionName     // Catch:{ Exception -> 0x022b }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r8, (java.lang.String) r7, (java.lang.Object) r9)     // Catch:{ Exception -> 0x022b }
            goto L_0x01ff
        L_0x01f5:
            org.json.JSONObject r8 = r15.f16727c     // Catch:{ Exception -> 0x022b }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r8, (java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ Exception -> 0x022b }
            org.json.JSONObject r8 = r15.f16727c     // Catch:{ Exception -> 0x022b }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r8, (java.lang.String) r7, (java.lang.Object) r5)     // Catch:{ Exception -> 0x022b }
        L_0x01ff:
            java.lang.String r7 = "sdkVersionCode"
            if (r6 == 0) goto L_0x0220
            java.lang.String r8 = r6.version     // Catch:{ Exception -> 0x022b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x022b }
            if (r8 != 0) goto L_0x0220
            org.json.JSONObject r8 = r15.f16727c     // Catch:{ Exception -> 0x022b }
            java.lang.String r6 = r6.version     // Catch:{ Exception -> 0x022b }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r8, (java.lang.String) r7, (java.lang.Object) r6)     // Catch:{ Exception -> 0x022b }
            org.json.JSONObject r6 = r15.f16727c     // Catch:{ Exception -> 0x022b }
            com.didi.dimina.container.Dimina$Config r7 = com.didi.dimina.container.Dimina.getConfig()     // Catch:{ Exception -> 0x022b }
            java.lang.String r7 = r7.getJsSdkId()     // Catch:{ Exception -> 0x022b }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r6, (java.lang.String) r3, (java.lang.Object) r7)     // Catch:{ Exception -> 0x022b }
            goto L_0x024c
        L_0x0220:
            org.json.JSONObject r6 = r15.f16727c     // Catch:{ Exception -> 0x022b }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r6, (java.lang.String) r7, (java.lang.Object) r5)     // Catch:{ Exception -> 0x022b }
            org.json.JSONObject r6 = r15.f16727c     // Catch:{ Exception -> 0x022b }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r6, (java.lang.String) r3, (java.lang.Object) r5)     // Catch:{ Exception -> 0x022b }
            goto L_0x024c
        L_0x022b:
            r6 = move-exception
            org.json.JSONObject r7 = r15.f16727c
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r7, (java.lang.String) r4, (java.lang.Object) r5)
            org.json.JSONObject r4 = r15.f16727c
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r4, (java.lang.String) r3, (java.lang.Object) r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r4 = android.util.Log.getStackTraceString(r6)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.didi.dimina.container.util.LogUtil.m13409e(r3)
        L_0x024c:
            org.json.JSONObject r3 = r15.f16727c     // Catch:{ Exception -> 0x0256 }
            java.lang.String r4 = com.didi.dimina.container.Dimina.getVersion()     // Catch:{ Exception -> 0x0256 }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r3, (java.lang.String) r0, (java.lang.Object) r4)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0272
        L_0x0256:
            r3 = move-exception
            org.json.JSONObject r4 = r15.f16727c
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r4, (java.lang.String) r0, (java.lang.Object) r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = android.util.Log.getStackTraceString(r3)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.didi.dimina.container.util.LogUtil.m13409e(r0)
        L_0x0272:
            com.didi.dimina.container.bundle.BundleManager r0 = com.didi.dimina.container.bundle.BundleManager.getInstance()     // Catch:{ Exception -> 0x02bd }
            com.didi.dimina.container.DMMina r1 = r15.f16726b     // Catch:{ Exception -> 0x02bd }
            java.lang.String r3 = "app"
            com.didi.dimina.container.bundle.bean.AppInfo$ModuleInfo r0 = r0.getAppPackageInfo(r1, r3)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r1 = "appVersionName"
            if (r0 == 0) goto L_0x0299
            java.lang.String r3 = r0.versionName     // Catch:{ Exception -> 0x02bd }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x02bd }
            if (r3 != 0) goto L_0x0299
            org.json.JSONObject r3 = r15.f16727c     // Catch:{ Exception -> 0x02bd }
            java.lang.String r4 = r0.versionName     // Catch:{ Exception -> 0x02bd }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r3, (java.lang.String) r2, (java.lang.Object) r4)     // Catch:{ Exception -> 0x02bd }
            org.json.JSONObject r3 = r15.f16727c     // Catch:{ Exception -> 0x02bd }
            java.lang.String r4 = r0.versionName     // Catch:{ Exception -> 0x02bd }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r3, (java.lang.String) r1, (java.lang.Object) r4)     // Catch:{ Exception -> 0x02bd }
            goto L_0x02a3
        L_0x0299:
            org.json.JSONObject r3 = r15.f16727c     // Catch:{ Exception -> 0x02bd }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r3, (java.lang.String) r2, (java.lang.Object) r5)     // Catch:{ Exception -> 0x02bd }
            org.json.JSONObject r3 = r15.f16727c     // Catch:{ Exception -> 0x02bd }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r3, (java.lang.String) r1, (java.lang.Object) r5)     // Catch:{ Exception -> 0x02bd }
        L_0x02a3:
            java.lang.String r1 = "appVersionCode"
            if (r0 == 0) goto L_0x02b7
            java.lang.String r3 = r0.version     // Catch:{ Exception -> 0x02bd }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x02bd }
            if (r3 != 0) goto L_0x02b7
            org.json.JSONObject r3 = r15.f16727c     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = r0.version     // Catch:{ Exception -> 0x02bd }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r3, (java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ Exception -> 0x02bd }
            goto L_0x02db
        L_0x02b7:
            org.json.JSONObject r0 = r15.f16727c     // Catch:{ Exception -> 0x02bd }
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r0, (java.lang.String) r1, (java.lang.Object) r5)     // Catch:{ Exception -> 0x02bd }
            goto L_0x02db
        L_0x02bd:
            r0 = move-exception
            org.json.JSONObject r1 = r15.f16727c
            com.didi.dimina.container.util.JSONUtil.put((org.json.JSONObject) r1, (java.lang.String) r2, (java.lang.Object) r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "appVersion 为空"
            r1.append(r2)
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.didi.dimina.container.util.LogUtil.m13409e(r0)
        L_0x02db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.C7436f.m12407e():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo54706a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            return mo54705a();
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54708b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject a = mo54705a();
            JSONUtil.put(jSONObject2, "success", true);
            JSONUtil.put(jSONObject2, "data", (Object) a);
        } catch (Exception e) {
            e.printStackTrace();
            JSONUtil.put(jSONObject2, "success", false);
        }
        callbackFunction.onCallBack(jSONObject2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo54705a() {
        if (TextUtils.isEmpty(this.f16727c.optString(Constants.JSON_KEY_OMEGA_OAID))) {
            LogUtil.m13409e("重新获取oaid " + Dimina.getConfig().getAdapterConfig().getWsgService().getOAID());
            JSONUtil.put(this.f16727c, Constants.JSON_KEY_OMEGA_OAID, (Object) Dimina.getConfig().getAdapterConfig().getWsgService().getOAID());
        }
        JSONUtil.put(this.f16727c, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, (Object) this.f16726b.getConfig().getLaunchConfig().getExtraOptions());
        WebViewEngine webViewEngine = null;
        try {
            DMPage curPage = NavigateUtil.getCurPage(this.f16726b);
            if (!(curPage == null || curPage.getWebViewContainer() == null || curPage.getWebViewContainer().getWebView() == null)) {
                webViewEngine = curPage.getWebViewContainer().getWebView();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (webViewEngine != null) {
            int id = webViewEngine.getWebView().getId();
            if (this.f16729e.containsKey(Integer.valueOf(id))) {
                JSONUtil.put(this.f16727c, "safeArea", (Object) this.f16729e.get(Integer.valueOf(id)));
            } else {
                JSONObject jSONObject = new JSONObject();
                int width = webViewEngine.getWebView().getWidth();
                int height = webViewEngine.getWebView().getHeight();
                int[] iArr = new int[2];
                webViewEngine.getWebView().getLocationOnScreen(iArr);
                int i = iArr[1];
                JSONUtil.put(jSONObject, "left", 0);
                JSONUtil.put(jSONObject, "top", PixUtil.px2dip(this.f16725a, (float) i));
                JSONUtil.put(jSONObject, "width", PixUtil.px2dip(this.f16725a, (float) width));
                JSONUtil.put(jSONObject, "height", PixUtil.px2dip(this.f16725a, (float) height));
                JSONUtil.put(this.f16727c, "safeArea", (Object) jSONObject);
                this.f16729e.put(Integer.valueOf(id), jSONObject);
            }
        }
        SystemInfoRecorder.SYSTEM_INFO = this.f16727c.toString();
        return this.f16727c;
    }

    /* renamed from: b */
    public String mo54707b() {
        String str = Build.VERSION.RELEASE;
        StringBuilder sb = new StringBuilder();
        sb.append("Android ");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: f */
    private float m12408f() {
        WindowManager windowManager;
        Activity activity = this.f16725a;
        if (activity == null || (windowManager = activity.getWindowManager()) == null) {
            return -1.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    /* renamed from: c */
    public int mo54709c() {
        WindowManager windowManager = (WindowManager) this.f16725a.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.x;
    }

    /* renamed from: d */
    public int mo54711d() {
        WindowManager windowManager = (WindowManager) this.f16725a.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.y;
    }

    /* renamed from: c */
    public JSONObject mo54710c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (this.f16730f == null) {
            this.f16730f = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            BundleManagerStrategy bundleManagerStrategy = this.f16726b.getConfig().getLaunchConfig().getBundleManagerStrategy();
            if (bundleManagerStrategy instanceof LocalBundleMangerStrategy) {
                JSONUtil.put(jSONObject2, "envVersion", (Object) "trial");
                JSONUtil.put(jSONObject2, "version", (Object) "");
            } else if (bundleManagerStrategy instanceof RemoteBundleMangerStrategy) {
                JSONUtil.put(jSONObject2, "envVersion", (Object) "develop");
                JSONUtil.put(jSONObject2, "version", (Object) "");
            } else {
                JSONUtil.put(jSONObject2, "appId", (Object) this.f16726b.getConfig().getLaunchConfig().getAppId());
                JSONUtil.put(jSONObject2, "envVersion", (Object) "release");
                AppInfo.ModuleInfo appPackageInfo = BundleManager.getInstance().getAppPackageInfo(this.f16726b, "app");
                if (appPackageInfo == null || TextUtils.isEmpty(appPackageInfo.versionName)) {
                    JSONUtil.put(jSONObject2, "version", (Object) null);
                } else {
                    JSONUtil.put(jSONObject2, "version", (Object) appPackageInfo.versionName);
                }
            }
            JSONUtil.put(this.f16730f, "miniProgram", (Object) jSONObject2);
        }
        return this.f16730f;
    }
}

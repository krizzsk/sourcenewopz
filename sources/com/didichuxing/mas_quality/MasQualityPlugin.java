package com.didichuxing.mas_quality;

import android.content.Context;
import android.text.TextUtils;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.mas.sdk.quality.init.MASSDK;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

public class MasQualityPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private MethodChannel f48292a;

    /* renamed from: b */
    private Context f48293b;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f48293b = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "mas_quality");
        this.f48292a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(p242io.flutter.plugin.common.MethodCall r3, p242io.flutter.plugin.common.MethodChannel.Result r4) {
        /*
            r2 = this;
            java.lang.String r0 = r3.method
            int r1 = r0.hashCode()
            switch(r1) {
                case -638150029: goto L_0x0046;
                case -462110611: goto L_0x003c;
                case 1061502142: goto L_0x0032;
                case 1135871869: goto L_0x0028;
                case 1135978511: goto L_0x001e;
                case 1385449135: goto L_0x0014;
                case 2043013050: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0050
        L_0x000a:
            java.lang.String r1 = "apolloAllow"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0050
            r0 = 4
            goto L_0x0051
        L_0x0014:
            java.lang.String r1 = "getPlatformVersion"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0050
            r0 = 0
            goto L_0x0051
        L_0x001e:
            java.lang.String r1 = "trackEvent"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0050
            r0 = 1
            goto L_0x0051
        L_0x0028:
            java.lang.String r1 = "trackError"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0050
            r0 = 2
            goto L_0x0051
        L_0x0032:
            java.lang.String r1 = "trackDartError"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0050
            r0 = 3
            goto L_0x0051
        L_0x003c:
            java.lang.String r1 = "apolloGetParams"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0050
            r0 = 5
            goto L_0x0051
        L_0x0046:
            java.lang.String r1 = "postCaughtException"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0050
            r0 = 6
            goto L_0x0051
        L_0x0050:
            r0 = -1
        L_0x0051:
            switch(r0) {
                case 0: goto L_0x0070;
                case 1: goto L_0x006c;
                case 2: goto L_0x0068;
                case 3: goto L_0x0064;
                case 4: goto L_0x0060;
                case 5: goto L_0x005c;
                case 6: goto L_0x0058;
                default: goto L_0x0054;
            }
        L_0x0054:
            r4.notImplemented()
            goto L_0x0086
        L_0x0058:
            r2.m34426a(r3, r4)
            goto L_0x0086
        L_0x005c:
            r2.m34431f(r3, r4)
            goto L_0x0086
        L_0x0060:
            r2.m34430e(r3, r4)
            goto L_0x0086
        L_0x0064:
            r2.m34427b(r3, r4)
            goto L_0x0086
        L_0x0068:
            r2.m34428c(r3, r4)
            goto L_0x0086
        L_0x006c:
            r2.m34429d(r3, r4)
            goto L_0x0086
        L_0x0070:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Android "
            r3.append(r0)
            java.lang.String r0 = android.os.Build.VERSION.RELEASE
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r4.success(r3)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas_quality.MasQualityPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    /* renamed from: a */
    private void m34426a(MethodCall methodCall, MethodChannel.Result result) {
        MASSDK.reportDartException(this.f48293b, (Map) methodCall.argument(RavenKey.ATTRS));
        result.success(true);
    }

    /* renamed from: b */
    private void m34427b(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.argument(RavenKey.ATTRS);
        Event event = new Event("OMGFLUCrash");
        event.setFrom("fl");
        event.putAllAttrs(map);
        OmegaSDKAdapter.trackEvent(event);
        OmegaSDK.trackError("flutter-crash", (String) map.get("error_name"), "flutter-crash", (String) map.get("error_msg"), map);
        result.success(true);
    }

    /* renamed from: c */
    private void m34428c(MethodCall methodCall, MethodChannel.Result result) {
        OmegaSDK.trackError((String) methodCall.argument("moduleName"), (String) methodCall.argument("errorName"), (String) methodCall.argument("errorType"), (String) methodCall.argument("errorMsg"), (Map) methodCall.argument("exAttrs"));
        result.success(true);
    }

    /* renamed from: d */
    private void m34429d(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("id");
        if (!TextUtils.isEmpty(str)) {
            Event event = new Event(str);
            event.setFrom("fl");
            event.putAllAttrs((Map) methodCall.argument(RavenKey.ATTRS));
            OmegaSDKAdapter.trackEvent(event);
            result.success(true);
            return;
        }
        result.success(false);
    }

    /* renamed from: e */
    private void m34430e(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument(GlobalCashierCoreModule.APOLLO);
        boolean allow = Apollo.getToggle(str).allow();
        SystemUtils.log(6, "SEE_THIS", str + ": allow = " + allow, (Throwable) null, "com.didichuxing.mas_quality.MasQualityPlugin", 126);
        result.success(Boolean.valueOf(allow));
    }

    /* renamed from: f */
    private void m34431f(MethodCall methodCall, MethodChannel.Result result) {
        result.success((String) Apollo.getToggle((String) methodCall.argument(GlobalCashierCoreModule.APOLLO)).getExperiment().getParam((String) methodCall.argument("params"), (String) methodCall.argument("def")));
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f48292a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}

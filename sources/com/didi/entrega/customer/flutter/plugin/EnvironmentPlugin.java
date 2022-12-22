package com.didi.entrega.customer.flutter.plugin;

import android.content.res.Resources;
import android.os.Build;
import com.didi.entrega.customer.app.GlobalContext;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.JSONMethodCodec;
import p242io.flutter.plugin.common.MethodChannel;

public class EnvironmentPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static String getOSType() {
        return "android";
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.didi.rlab/environment_plugin", JSONMethodCodec.INSTANCE).setMethodCallHandler(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(p242io.flutter.plugin.common.MethodCall r7, p242io.flutter.plugin.common.MethodChannel.Result r8) {
        /*
            r6 = this;
            java.lang.String r7 = r7.method
            int r0 = r7.hashCode()
            r1 = -85904877(0xfffffffffae13213, float:-5.846412E35)
            r2 = 0
            java.lang.String r3 = "timeOffset"
            r4 = 2
            r5 = 1
            if (r0 == r1) goto L_0x002e
            r1 = 370789020(0x1619ca9c, float:1.2423174E-25)
            if (r0 == r1) goto L_0x0024
            r1 = 665490880(0x27aa95c0, float:4.7346838E-15)
            if (r0 == r1) goto L_0x001c
            goto L_0x0038
        L_0x001c:
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x0038
            r7 = 1
            goto L_0x0039
        L_0x0024:
            java.lang.String r0 = "getOmegaCommonParams"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0038
            r7 = 2
            goto L_0x0039
        L_0x002e:
            java.lang.String r0 = "environment"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0038
            r7 = 0
            goto L_0x0039
        L_0x0038:
            r7 = -1
        L_0x0039:
            if (r7 == 0) goto L_0x0057
            if (r7 == r5) goto L_0x004a
            if (r7 == r4) goto L_0x0041
            goto L_0x0128
        L_0x0041:
            java.util.Map r7 = com.didi.entrega.customer.foundation.tracker.OmegaCommonParamHelper.getCommonParam()
            r8.success(r7)
            goto L_0x0128
        L_0x004a:
            long r0 = com.didi.entrega.customer.foundation.rpc.Clock.timeOffsetSeconds()
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            r8.success(r7)
            goto L_0x0128
        L_0x0057:
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.util.Map r0 = com.didi.entrega.customer.foundation.rpc.ParamsHelper.getCommonParams()
            java.lang.String r1 = "brandName"
            java.lang.String r4 = "99"
            r7.put(r1, r4)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "country"
            java.lang.String r4 = com.didi.entrega.customer.foundation.util.LocationUtil.getCountryCode()     // Catch:{ JSONException -> 0x0121 }
            r7.put(r1, r4)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "lang"
            java.lang.Class<com.didi.entrega.customer.service.ILocaleService> r4 = com.didi.entrega.customer.service.ILocaleService.class
            com.didi.entrega.customer.service.IService r4 = com.didi.entrega.customer.service.CustomerServiceManager.getService(r4)     // Catch:{ JSONException -> 0x0121 }
            com.didi.entrega.customer.service.ILocaleService r4 = (com.didi.entrega.customer.service.ILocaleService) r4     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r4 = r4.getLangTag()     // Catch:{ JSONException -> 0x0121 }
            r7.put(r1, r4)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "statusbarHeight"
            int r4 = r6.m14728a()     // Catch:{ JSONException -> 0x0121 }
            r7.put(r1, r4)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "immersiveStatusbarHeight"
            android.content.Context r4 = com.didi.entrega.customer.app.GlobalContext.getContext()     // Catch:{ JSONException -> 0x0121 }
            int r4 = com.didi.entrega.customer.foundation.util.CustomerSystemUtil.getImmersiveStatusBarHeight(r4)     // Catch:{ JSONException -> 0x0121 }
            r7.put(r1, r4)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "isEmbed"
            boolean r4 = com.didi.entrega.customer.app.GlobalContext.isEmbed()     // Catch:{ JSONException -> 0x0121 }
            if (r4 == 0) goto L_0x00a1
            r2 = 1
        L_0x00a1:
            r7.put(r1, r2)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "utcOffset"
            int r2 = com.didi.foundation.sdk.utils.LocalizationUtils.getTimeZoneUtcOffset()     // Catch:{ JSONException -> 0x0121 }
            r7.put(r1, r2)     // Catch:{ JSONException -> 0x0121 }
            long r1 = com.didi.entrega.customer.foundation.rpc.Clock.timeOffsetSeconds()     // Catch:{ JSONException -> 0x0121 }
            r7.put(r3, r1)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "buildType"
            java.lang.String r2 = "release"
            r7.put(r1, r2)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "osVersion"
            java.lang.String r2 = getOSVersion()     // Catch:{ JSONException -> 0x0121 }
            r7.put(r1, r2)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "manufacturer"
            java.lang.String r2 = getManufacturer()     // Catch:{ JSONException -> 0x0121 }
            r7.put(r1, r2)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "model"
            java.lang.String r2 = getModel()     // Catch:{ JSONException -> 0x0121 }
            r7.put(r1, r2)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "callingCode"
            java.lang.String r2 = com.didi.entrega.customer.foundation.util.LoginUtil.getCallingCode()     // Catch:{ JSONException -> 0x0121 }
            r7.put(r1, r2)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "dataType"
            java.lang.String r2 = "16"
            r7.put(r1, r2)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "uid"
            java.lang.String r2 = com.didi.entrega.customer.foundation.util.LoginUtil.getUid()     // Catch:{ JSONException -> 0x0121 }
            r7.put(r1, r2)     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r1 = "deviceToken"
            com.didi.security.uuid.adapter.DeviceTokenWrapper r2 = com.didi.security.uuid.adapter.DeviceTokenWrapper.getInstance()     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r2 = r2.getDeviceToken()     // Catch:{ JSONException -> 0x0121 }
            r7.put(r1, r2)     // Catch:{ JSONException -> 0x0121 }
            java.util.Set r1 = r0.keySet()     // Catch:{ JSONException -> 0x0121 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ JSONException -> 0x0121 }
        L_0x0108:
            boolean r2 = r1.hasNext()     // Catch:{ JSONException -> 0x0121 }
            if (r2 == 0) goto L_0x0125
            java.lang.Object r2 = r1.next()     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x0121 }
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x011c }
            r7.put(r2, r3)     // Catch:{ JSONException -> 0x011c }
            goto L_0x0108
        L_0x011c:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ JSONException -> 0x0121 }
            goto L_0x0108
        L_0x0121:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0125:
            r8.success(r7)
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.flutter.plugin.EnvironmentPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    /* renamed from: a */
    private int m14728a() {
        try {
            Resources resources = GlobalContext.getContext().getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE + ":" + Build.VERSION.SDK_INT;
    }
}

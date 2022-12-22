package com.didichuxing.omega.omega_plugin;

import android.os.Build;
import android.text.TextUtils;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.alpha.fps.OmegaFPS;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.record.LagRecord;
import com.didichuxing.omega.sdk.common.record.RecordFactory;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

public class OmegaPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static FlutterOmegaCommonAttrsSupplier supplier;
    private MethodChannel channel;

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -638150029:
                    if (str.equals("postCaughtException")) {
                        c = 4;
                        break;
                    }
                    break;
                case -462110611:
                    if (str.equals("apolloGetParams")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1135978511:
                    if (str.equals("trackEvent")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1270281741:
                    if (str.equals("traceLag")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1385449135:
                    if (str.equals("getPlatformVersion")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2043013050:
                    if (str.equals("apolloAllow")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                result.success("Android " + Build.VERSION.RELEASE);
            } else if (c == 1) {
                String str2 = (String) methodCall.argument("id");
                if (!TextUtils.isEmpty(str2)) {
                    Map map = (Map) methodCall.argument(RavenKey.ATTRS);
                    Event event = new Event(str2);
                    if (supplier != null) {
                        event.putAllAttrs(supplier.getCommonAttrs());
                    }
                    event.setFrom("fl");
                    event.putAllAttrs(map);
                    OmegaSDKAdapter.trackEvent(event);
                    SystemUtils.log(6, "SEE_THIS", "trackEvent: " + event.toString(), (Throwable) null, "com.didichuxing.omega.omega_plugin.OmegaPlugin", 50);
                    result.success(true);
                    return;
                }
                result.success(false);
            } else if (c == 2) {
                boolean allow = Apollo.getToggle((String) methodCall.argument(GlobalCashierCoreModule.APOLLO)).allow();
                SystemUtils.log(6, "SEE_THIS", "apolloAllow: allow = " + allow, (Throwable) null, "com.didichuxing.omega.omega_plugin.OmegaPlugin", 60);
                result.success(Boolean.valueOf(allow));
            } else if (c == 3) {
                String str3 = (String) Apollo.getToggle((String) methodCall.argument(GlobalCashierCoreModule.APOLLO)).getExperiment().getParam((String) methodCall.argument("params"), (String) methodCall.argument("def"));
                SystemUtils.log(6, "SEE_THIS", "apolloGetParams: value = " + str3, (Throwable) null, "com.didichuxing.omega.omega_plugin.OmegaPlugin", 68);
                result.success(str3);
            } else if (c == 4) {
                Map map2 = (Map) methodCall.argument(RavenKey.ATTRS);
                Event event2 = new Event("OMGFLUCrash");
                event2.setFrom("fl");
                event2.putAllAttrs(map2);
                OmegaSDKAdapter.trackEvent(event2);
                String str4 = "";
                String obj = map2.get("error_name") != null ? map2.get("error_name").toString() : str4;
                if (map2.get("error_msg") != null) {
                    str4 = map2.get("error_msg").toString();
                }
                OmegaSDK.trackError("flutter-crash", obj, "flutter-crash", str4, map2);
                SystemUtils.log(6, "SEE_THIS", "postCaughtException: " + event2.toString(), (Throwable) null, "com.didichuxing.omega.omega_plugin.OmegaPlugin", 81);
            } else if (c != 5) {
                result.notImplemented();
            } else {
                Map map3 = (Map) methodCall.argument(RavenKey.ATTRS);
                String str5 = (String) map3.get("lag_info");
                Double d = (Double) map3.get("start_time");
                Double d2 = (Double) map3.get("end_time");
                LagRecord createLagRecord = RecordFactory.createLagRecord();
                createLagRecord.takeLogcat();
                createLagRecord.setLatestFPS(str5);
                createLagRecord.setSystemRefreshRate(OmegaFPS.getInstance().getSystemRefreshRate());
                map3.putAll(createLagRecord.toMap());
                SystemUtils.log(6, "SEE_THIS", "laginfo: " + str5 + " startTime:" + d.longValue() + " endTime:" + d2.longValue(), (Throwable) null, "com.didichuxing.omega.omega_plugin.OmegaPlugin", 98);
                StringBuilder sb = new StringBuilder();
                sb.append("time:");
                sb.append(d2.longValue() - d.longValue());
                OmegaSDK.trackError("flutter-lag", sb.toString(), "flutter-lag", str5, map3);
                Event event3 = new Event("tech_flutter_lag");
                event3.setFrom("fl");
                event3.putAllAttrs(map3);
                OmegaSDKAdapter.trackEvent(event3);
            }
        } catch (Exception e) {
            SystemUtils.log(6, "SEE_THIS", "onMethodCall failed. ", e, "com.didichuxing.omega.omega_plugin.OmegaPlugin", 112);
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initChannel(flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    private void initChannel(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "omega_plugin");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void setSupplier(FlutterOmegaCommonAttrsSupplier flutterOmegaCommonAttrsSupplier) {
        supplier = flutterOmegaCommonAttrsSupplier;
    }
}

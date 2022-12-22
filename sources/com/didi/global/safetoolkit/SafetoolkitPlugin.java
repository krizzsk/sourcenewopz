package com.didi.global.safetoolkit;

import java.util.HashMap;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.PluginRegistry;

public class SafetoolkitPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final String NAME = "com.didi.flutter.safetoolkit";

    /* renamed from: a */
    private MethodChannel f22931a;

    /* renamed from: b */
    private DataHandler f22932b;

    public interface DataHandler {
        void onDetached();

        void onGetInfo(MethodChannel.Result result);
    }

    public DataHandler getDataHandler() {
        return this.f22932b;
    }

    public void setDataHandler(DataHandler dataHandler) {
        this.f22932b = dataHandler;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), NAME);
        this.f22931a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), NAME).setMethodCallHandler(new SafetoolkitPlugin());
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if ("getInfo".equals(methodCall.method)) {
            DataHandler dataHandler = this.f22932b;
            if (dataHandler != null) {
                dataHandler.onGetInfo(result);
            }
        } else if ("onDetached".equals(methodCall.method)) {
            DataHandler dataHandler2 = this.f22932b;
            if (dataHandler2 != null) {
                try {
                    dataHandler2.onDetached();
                    result.success(true);
                } catch (Exception e) {
                    result.success(false);
                    e.printStackTrace();
                }
            } else {
                result.success(true);
            }
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f22931a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void updateInfo(String str) {
        if (this.f22931a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("safetoolkit_rsp", str);
            this.f22931a.invokeMethod("safeToolkitDataUpdate", hashMap);
        }
    }

    public void buttonStatusChanged(String str, String str2) {
        if (this.f22931a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("action", str);
            hashMap.put("status", str2);
            this.f22931a.invokeMethod("buttonStatusChanged", hashMap);
        }
    }
}

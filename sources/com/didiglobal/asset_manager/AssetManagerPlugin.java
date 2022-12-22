package com.didiglobal.asset_manager;

import android.content.Context;
import com.didiglobal.font.DIDIFontUtils;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.PluginRegistry;

public class AssetManagerPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private MethodChannel f49734a;

    /* renamed from: b */
    private Context f49735b;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f49735b = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "asset_manager");
        this.f49734a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), "asset_manager").setMethodCallHandler(new AssetManagerPlugin());
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getSupportFontFromNative")) {
            result.success(DIDIFontUtils.Companion.getFontByteArrayMap(this.f49735b));
        } else if (methodCall.method.equals("getFontWeightConf")) {
            String weightRuleConfig = DIDIFontUtils.Companion.getWeightRuleConfig();
            if (weightRuleConfig == null) {
                result.success("");
            } else {
                result.success(weightRuleConfig);
            }
        } else {
            result.notImplemented();
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f49734a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}

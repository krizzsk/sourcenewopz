package com.wallet.flutter.wallet_flutter.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/http/WalletFlutterHttpPluginImpl;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "()V", "httpChannel", "Lcom/wallet/flutter/wallet_flutter/http/WalletFlutterHttpChannel;", "onAttachedToActivity", "", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onReattachedToActivityForConfigChanges", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletFlutterHttpPluginImpl.kt */
public final class WalletFlutterHttpPluginImpl implements FlutterPlugin, ActivityAware {

    /* renamed from: a */
    private WalletFlutterHttpChannel f56066a;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.f56066a = new WalletFlutterHttpChannel(flutterPluginBinding);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        WalletFlutterHttpChannel walletFlutterHttpChannel = this.f56066a;
        if (walletFlutterHttpChannel != null) {
            walletFlutterHttpChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.f56066a = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        WalletFlutterHttpChannel walletFlutterHttpChannel = this.f56066a;
        if (walletFlutterHttpChannel != null) {
            walletFlutterHttpChannel.onAttachedToActivity(activityPluginBinding);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        WalletFlutterHttpChannel walletFlutterHttpChannel = this.f56066a;
        if (walletFlutterHttpChannel != null) {
            walletFlutterHttpChannel.onDetachedFromActivityForConfigChanges();
        }
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        WalletFlutterHttpChannel walletFlutterHttpChannel = this.f56066a;
        if (walletFlutterHttpChannel != null) {
            walletFlutterHttpChannel.onReattachedToActivityForConfigChanges(activityPluginBinding);
        }
    }

    public void onDetachedFromActivity() {
        WalletFlutterHttpChannel walletFlutterHttpChannel = this.f56066a;
        if (walletFlutterHttpChannel != null) {
            walletFlutterHttpChannel.onDetachedFromActivity();
        }
    }
}

package com.wallet.flutter.wallet_flutter;

import com.wallet.flutter.wallet_flutter.base.FlutterHelper;
import com.wallet.flutter.wallet_flutter.base.IFlutterPluginBindingOwner;
import com.wallet.flutter.wallet_flutter.function.WalletFlutterMethodChannel;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/WalletFlutterPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Lcom/wallet/flutter/wallet_flutter/base/IFlutterPluginBindingOwner;", "()V", "activityBinding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "ownerId", "", "walletFlutterChannel", "Lcom/wallet/flutter/wallet_flutter/function/WalletFlutterMethodChannel;", "getFlutterActivityBinding", "getFlutterPluginBinding", "onAttachedToActivity", "", "onAttachedToEngine", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onReattachedToActivityForConfigChanges", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletFlutterPlugin.kt */
public final class WalletFlutterPlugin implements IFlutterPluginBindingOwner, FlutterPlugin, ActivityAware {

    /* renamed from: a */
    private WalletFlutterMethodChannel f56036a;

    /* renamed from: b */
    private FlutterPlugin.FlutterPluginBinding f56037b;

    /* renamed from: c */
    private String f56038c;

    /* renamed from: d */
    private ActivityPluginBinding f56039d;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.f56037b = flutterPluginBinding;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.f56038c = uuid;
        FlutterHelper.Companion.registerFlutterPluginBindingOwner(uuid, this);
        this.f56036a = new WalletFlutterMethodChannel(flutterPluginBinding, uuid);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        FlutterHelper.Companion.unregisterFlutterPluginBindingOwner(this.f56038c);
        this.f56037b = null;
        WalletFlutterMethodChannel walletFlutterMethodChannel = this.f56036a;
        if (walletFlutterMethodChannel != null) {
            walletFlutterMethodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.f56036a = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.f56039d = activityPluginBinding;
        WalletFlutterMethodChannel walletFlutterMethodChannel = this.f56036a;
        if (walletFlutterMethodChannel != null) {
            walletFlutterMethodChannel.onAttachedToActivity(activityPluginBinding);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        this.f56039d = null;
        WalletFlutterMethodChannel walletFlutterMethodChannel = this.f56036a;
        if (walletFlutterMethodChannel != null) {
            walletFlutterMethodChannel.onDetachedFromActivityForConfigChanges();
        }
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.f56039d = activityPluginBinding;
        WalletFlutterMethodChannel walletFlutterMethodChannel = this.f56036a;
        if (walletFlutterMethodChannel != null) {
            walletFlutterMethodChannel.onReattachedToActivityForConfigChanges(activityPluginBinding);
        }
    }

    public void onDetachedFromActivity() {
        this.f56039d = null;
        WalletFlutterMethodChannel walletFlutterMethodChannel = this.f56036a;
        if (walletFlutterMethodChannel != null) {
            walletFlutterMethodChannel.onDetachedFromActivity();
        }
    }

    public FlutterPlugin.FlutterPluginBinding getFlutterPluginBinding() {
        return this.f56037b;
    }

    public ActivityPluginBinding getFlutterActivityBinding() {
        return this.f56039d;
    }
}

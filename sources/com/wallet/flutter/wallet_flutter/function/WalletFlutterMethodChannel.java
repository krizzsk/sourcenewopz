package com.wallet.flutter.wallet_flutter.function;

import androidx.core.app.NotificationCompat;
import com.wallet.flutter.wallet_flutter.base.FlutterHelperKt;
import com.wallet.flutter.wallet_flutter.base.IActivityAwareOwner;
import com.wallet.flutter.wallet_flutter.base.IFlutterMethodCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\n\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\nH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/function/WalletFlutterMethodChannel;", "Lio/flutter/plugin/common/MethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Lcom/wallet/flutter/wallet_flutter/base/IActivityAwareOwner;", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "pluginBindingId", "", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;Ljava/lang/String;)V", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "getBinding", "()Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "setBinding", "(Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;)V", "getActivityPluginBinding", "onAttachedToActivity", "", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onReattachedToActivityForConfigChanges", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletFlutterMethodChannel.kt */
public final class WalletFlutterMethodChannel extends MethodChannel implements IActivityAwareOwner, ActivityAware, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private final String f56062a;

    /* renamed from: b */
    private ActivityPluginBinding f56063b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletFlutterMethodChannel(FlutterPlugin.FlutterPluginBinding flutterPluginBinding, String str) {
        super(flutterPluginBinding.getBinaryMessenger(), "wallet_flutter");
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        Intrinsics.checkNotNullParameter(str, "pluginBindingId");
        this.f56062a = str;
        setMethodCallHandler(this);
    }

    public final ActivityPluginBinding getBinding() {
        return this.f56063b;
    }

    public final void setBinding(ActivityPluginBinding activityPluginBinding) {
        this.f56063b = activityPluginBinding;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        Class cls = FlutterHelperKt.getMethodMap().get(methodCall.method);
        if (cls == null) {
            result.success((Object) null);
        } else {
            ((IFlutterMethodCall) cls.newInstance()).onCall(methodCall, result, this, this.f56062a);
        }
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.f56063b = activityPluginBinding;
    }

    public void onDetachedFromActivityForConfigChanges() {
        this.f56063b = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.f56063b = activityPluginBinding;
    }

    public void onDetachedFromActivity() {
        this.f56063b = null;
    }

    public ActivityPluginBinding getActivityPluginBinding() {
        return this.f56063b;
    }
}

package com.wallet.flutter.wallet_flutter.function;

import android.app.Activity;
import androidx.core.app.NotificationCompat;
import com.didi.unifylogin.api.OneLoginFacade;
import com.wallet.flutter.wallet_flutter.base.IActivityAwareOwner;
import com.wallet.flutter.wallet_flutter.base.IFlutterMethodCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/function/FlutterLoginMethod;", "Lcom/wallet/flutter/wallet_flutter/base/IFlutterMethodCall;", "()V", "onCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "bindingOwner", "Lcom/wallet/flutter/wallet_flutter/base/IActivityAwareOwner;", "pluginBindingId", "", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterLoginMethod.kt */
public final class FlutterLoginMethod implements IFlutterMethodCall {
    public void onCall(MethodCall methodCall, MethodChannel.Result result, IActivityAwareOwner iActivityAwareOwner, String str) {
        Activity activity;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(iActivityAwareOwner, "bindingOwner");
        Intrinsics.checkNotNullParameter(str, "pluginBindingId");
        ActivityPluginBinding activityPluginBinding = iActivityAwareOwner.getActivityPluginBinding();
        if (!(activityPluginBinding == null || (activity = activityPluginBinding.getActivity()) == null)) {
            OneLoginFacade.getAction().go2Login(activity);
        }
        result.success((Object) null);
    }
}

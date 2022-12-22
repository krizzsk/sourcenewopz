package com.wallet.flutter.wallet_flutter.function;

import androidx.core.app.NotificationCompat;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletTopUpOmegaUtil;
import com.wallet.flutter.wallet_flutter.base.IActivityAwareOwner;
import com.wallet.flutter.wallet_flutter.base.IFlutterMethodCall;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/function/FlutterTrackMethod;", "Lcom/wallet/flutter/wallet_flutter/base/IFlutterMethodCall;", "()V", "onCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "bindingOwner", "Lcom/wallet/flutter/wallet_flutter/base/IActivityAwareOwner;", "pluginBindingId", "", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterTrackMethod.kt */
public final class FlutterTrackMethod implements IFlutterMethodCall {
    public void onCall(MethodCall methodCall, MethodChannel.Result result, IActivityAwareOwner iActivityAwareOwner, String str) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(iActivityAwareOwner, "bindingOwner");
        Intrinsics.checkNotNullParameter(str, "pluginBindingId");
        Object obj = methodCall.arguments;
        Map map = obj instanceof Map ? (Map) obj : null;
        Object obj2 = map == null ? null : map.get("trackEvent");
        if (!(obj2 instanceof String)) {
            obj2 = null;
        }
        String str2 = (String) obj2;
        if (str2 != null) {
            Object obj3 = methodCall.arguments;
            Map map2 = obj3 instanceof Map ? (Map) obj3 : null;
            Object obj4 = map2 == null ? null : map2.get("trackAttr");
            if (!(obj4 instanceof HashMap)) {
                obj4 = null;
            }
            HashMap hashMap = (HashMap) obj4;
            WalletTopUpOmegaUtil.Companion companion = WalletTopUpOmegaUtil.Companion;
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            companion.trackEvent(str2, hashMap);
        }
        result.success((Object) null);
    }
}

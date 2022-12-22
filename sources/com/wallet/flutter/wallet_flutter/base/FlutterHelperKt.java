package com.wallet.flutter.wallet_flutter.base;

import android.content.Intent;
import androidx.lifecycle.LifecycleObserver;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.google.gson.Gson;
import com.wallet.flutter.wallet_flutter.function.FlutterGetVersionMethod;
import com.wallet.flutter.wallet_flutter.function.FlutterLoginMethod;
import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import com.wallet.flutter.wallet_flutter.function.FlutterShareProxyCall;
import com.wallet.flutter.wallet_flutter.function.FlutterToDRouterMethod;
import com.wallet.flutter.wallet_flutter.function.FlutterToTopUpCreateOrder;
import com.wallet.flutter.wallet_flutter.function.FlutterTrackMethod;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import p242io.flutter.plugin.common.MethodCall;

@Metadata(mo175977d1 = {"\u0000^\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a\"\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0006\b\u0000\u0010\u000e\u0018\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\b¢\u0006\u0002\u0010\u000f\u001ah\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00122O\b\u0004\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0011*\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\b¢\u0006\u0002\u0010!\u001a$\u0010\"\u001a\u0004\u0018\u0001H\u000e\"\u0006\b\u0000\u0010\u000e\u0018\u0001*\u00020#2\u0006\u0010$\u001a\u00020\u0002H\b¢\u0006\u0002\u0010%\"'\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"'\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006&"}, mo175978d2 = {"methodMap", "", "", "Ljava/lang/Class;", "Lcom/wallet/flutter/wallet_flutter/base/IFlutterMethodCall;", "getMethodMap", "()Ljava/util/Map;", "methodProxyMap", "Lcom/wallet/flutter/wallet_flutter/base/IFlutterProxyActivityCall;", "getMethodProxyMap", "jsonToMap", "", "json", "jsonToT", "T", "(Ljava/lang/String;)Ljava/lang/Object;", "addActivityResultListener", "", "Lcom/wallet/flutter/wallet_flutter/base/IActivityAwareOwner;", "block", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "(Lcom/wallet/flutter/wallet_flutter/base/IActivityAwareOwner;Lkotlin/jvm/functions/Function3;)Lkotlin/Unit;", "addLifecycleObserver", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "(Lcom/wallet/flutter/wallet_flutter/base/IActivityAwareOwner;Landroidx/lifecycle/LifecycleObserver;)Lkotlin/Unit;", "getValue", "Lio/flutter/plugin/common/MethodCall;", "key", "(Lio/flutter/plugin/common/MethodCall;Ljava/lang/String;)Ljava/lang/Object;", "wallet_flutter_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterHelper.kt */
public final class FlutterHelperKt {

    /* renamed from: a */
    private static final Map<String, Class<? extends IFlutterMethodCall>> f56043a = MapsKt.mapOf(TuplesKt.m42317to("share", FlutterShareMethod.class), TuplesKt.m42317to("router", FlutterToDRouterMethod.class), TuplesKt.m42317to("getPlatformVersion", FlutterGetVersionMethod.class), TuplesKt.m42317to("createOrder", FlutterToTopUpCreateOrder.class), TuplesKt.m42317to(InvitationPageActivity.TRACK, FlutterTrackMethod.class), TuplesKt.m42317to("login", FlutterLoginMethod.class));

    /* renamed from: b */
    private static final Map<String, Class<? extends IFlutterProxyActivityCall>> f56044b = MapsKt.mapOf(TuplesKt.m42317to("share", FlutterShareProxyCall.class));

    public static final Map<String, Class<? extends IFlutterMethodCall>> getMethodMap() {
        return f56043a;
    }

    public static final Map<String, Class<? extends IFlutterProxyActivityCall>> getMethodProxyMap() {
        return f56044b;
    }

    public static final /* synthetic */ <T> T getValue(MethodCall methodCall, String str) {
        Intrinsics.checkNotNullParameter(methodCall, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = methodCall.arguments;
        T t = null;
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map != null) {
            t = map.get(str);
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return (Object) t;
    }

    public static final /* synthetic */ <T> T jsonToT(String str) {
        if (str == null) {
            return null;
        }
        try {
            Gson gson = FlutterHelper.Companion.getGson();
            Intrinsics.needClassReification();
            return gson.fromJson(str, new FlutterHelperKt$jsonToT$1().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Unit addActivityResultListener(IActivityAwareOwner iActivityAwareOwner, Function3<? super Integer, ? super Integer, ? super Intent, Boolean> function3) {
        Intrinsics.checkNotNullParameter(iActivityAwareOwner, "<this>");
        Intrinsics.checkNotNullParameter(function3, "block");
        ActivityPluginBinding activityPluginBinding = iActivityAwareOwner.getActivityPluginBinding();
        if (activityPluginBinding == null) {
            return null;
        }
        activityPluginBinding.addActivityResultListener(new FlutterHelperKt$addActivityResultListener$1$1(activityPluginBinding, function3));
        return Unit.INSTANCE;
    }

    public static final Unit addLifecycleObserver(IActivityAwareOwner iActivityAwareOwner, LifecycleObserver lifecycleObserver) {
        Intrinsics.checkNotNullParameter(iActivityAwareOwner, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        ActivityPluginBinding activityPluginBinding = iActivityAwareOwner.getActivityPluginBinding();
        if (activityPluginBinding == null) {
            return null;
        }
        FlutterLifecycleAdapter.getActivityLifecycle(activityPluginBinding).addObserver(lifecycleObserver);
        return Unit.INSTANCE;
    }

    public static final Map<String, Object> jsonToMap(String str) {
        Object obj = null;
        if (str != null) {
            try {
                obj = FlutterHelper.Companion.getGson().fromJson(str, new FlutterHelperKt$jsonToMap$$inlined$jsonToT$1().getType());
            } catch (Exception unused) {
            }
        }
        return (Map) obj;
    }
}

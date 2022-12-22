package com.didiglobal.ibg_rpc_service;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.didi.drouter.api.DRouter;
import com.didiglobal.ibg_rpc_service.internal.HttpClient;
import com.didiglobal.ibg_rpc_service.internal.HttpMethod;
import com.didiglobal.ibg_rpc_service.internal.Logger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00020\u000b2\b\b\u0001\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/IbgRpcServicePlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "isApplicationDebug", "", "walletPluginProxy", "onAttachedToActivity", "", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onReattachedToActivityForConfigChanges", "Companion", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IbgRpcServicePlugin.kt */
public final class IbgRpcServicePlugin implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d */
    private static final String f50237d = "IbgRpcServicePlugin";

    /* renamed from: e */
    private static final String f50238e = "WalletFlutterHttpPluginImpl";

    /* renamed from: a */
    private MethodChannel f50239a;

    /* renamed from: b */
    private boolean f50240b;

    /* renamed from: c */
    private FlutterPlugin f50241c;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IbgRpcServicePlugin.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            iArr[HttpMethod.GET.ordinal()] = 1;
            iArr[HttpMethod.POST.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/IbgRpcServicePlugin$Companion;", "", "()V", "TAG", "", "WALLET_FLUTTER_HTTP_PLUGIN_IMPL", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IbgRpcServicePlugin.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        boolean z = false;
        FlutterPlugin service = DRouter.build(FlutterPlugin.class).setAlias(f50238e).getService(new Object[0]);
        if (service == null) {
            MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "ibg_rpc_service");
            this.f50239a = methodChannel;
            if (methodChannel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
                methodChannel = null;
            }
            methodChannel.setMethodCallHandler(this);
            HttpClient httpClient = HttpClient.INSTANCE;
            Context applicationContext = flutterPluginBinding.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "flutterPluginBinding.applicationContext");
            httpClient.init$ibg_rpc_service_release(applicationContext);
            if ((flutterPluginBinding.getApplicationContext().getApplicationInfo().flags & 2) != 0) {
                z = true;
            }
            this.f50240b = z;
            Logger.INSTANCE.setEnable(this.f50240b);
            return;
        }
        this.f50241c = service;
        service.onAttachedToEngine(flutterPluginBinding);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        Intrinsics.checkNotNullParameter(methodCall2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result2, "result");
        Logger.m36210v(f50237d, "onMethodCall: call=[method=" + methodCall2.method + ",arguments=" + methodCall2.arguments + VersionRange.RIGHT_CLOSED);
        String str = methodCall2.method;
        boolean z = false;
        if (Intrinsics.areEqual((Object) str, (Object) "request")) {
            Integer num = (Integer) methodCall2.argument("method");
            HttpMethod fromMethodId = HttpMethod.Companion.fromMethodId(num);
            if (fromMethodId == null) {
                result2.error("-1", "the method id:" + num + " is NOT support now!", (Object) null);
                return;
            }
            String str2 = (String) methodCall2.argument("host");
            CharSequence charSequence = str2;
            if (charSequence == null || charSequence.length() == 0) {
                result2.error("-1", "host must not be null or empty", (Object) null);
                return;
            }
            String str3 = (String) methodCall2.argument("url");
            if (charSequence == null || charSequence.length() == 0) {
                z = true;
            }
            if (z) {
                result2.error("-1", "url must not be null or empty", (Object) null);
                return;
            }
            Map map = (Map) methodCall2.argument("params");
            Map map2 = (Map) methodCall2.argument("header");
            Function1 ibgRpcServicePlugin$onMethodCall$callback$1 = new IbgRpcServicePlugin$onMethodCall$callback$1(result2);
            String stringPlus = Intrinsics.stringPlus(str2, str3);
            int i = WhenMappings.$EnumSwitchMapping$0[fromMethodId.ordinal()];
            if (i == 1) {
                HttpClient.INSTANCE.get(stringPlus, map, map2, ibgRpcServicePlugin$onMethodCall$callback$1);
            } else if (i == 2) {
                HttpClient.INSTANCE.post(stringPlus, (Map<String, ? extends Object>) null, map, map2, ibgRpcServicePlugin$onMethodCall$callback$1);
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) "isReleaseMode")) {
            result2.success(MapsKt.hashMapOf(TuplesKt.m42317to("isReleaseMode", Boolean.valueOf(true ^ this.f50240b))));
        } else {
            result.notImplemented();
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        FlutterPlugin flutterPlugin = this.f50241c;
        if (flutterPlugin == null) {
            MethodChannel methodChannel = this.f50239a;
            if (methodChannel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
                methodChannel = null;
            }
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
            return;
        }
        flutterPlugin.onDetachedFromEngine(flutterPluginBinding);
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        FlutterPlugin flutterPlugin = this.f50241c;
        if (flutterPlugin != null && (flutterPlugin instanceof ActivityAware)) {
            ((ActivityAware) flutterPlugin).onAttachedToActivity(activityPluginBinding);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        FlutterPlugin flutterPlugin = this.f50241c;
        if (flutterPlugin != null && (flutterPlugin instanceof ActivityAware)) {
            ((ActivityAware) flutterPlugin).onDetachedFromActivityForConfigChanges();
        }
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        FlutterPlugin flutterPlugin = this.f50241c;
        if (flutterPlugin != null && (flutterPlugin instanceof ActivityAware)) {
            ((ActivityAware) flutterPlugin).onReattachedToActivityForConfigChanges(activityPluginBinding);
        }
    }

    public void onDetachedFromActivity() {
        FlutterPlugin flutterPlugin = this.f50241c;
        if (flutterPlugin != null && (flutterPlugin instanceof ActivityAware)) {
            ((ActivityAware) flutterPlugin).onDetachedFromActivity();
        }
    }
}

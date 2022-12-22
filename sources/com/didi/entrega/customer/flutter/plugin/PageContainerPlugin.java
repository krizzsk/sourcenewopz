package com.didi.entrega.customer.flutter.plugin;

import androidx.core.app.NotificationCompat;
import com.didi.entrega.customer.flutter.CustomerFlutterPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.android.BaseNachoSkeletonPage;
import p242io.flutter.embedding.android.registry.NFlutterContainerRegistry;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/entrega/customer/flutter/plugin/PageContainerPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "platformPluginName", "", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PageContainerPlugin.kt */
public final class PageContainerPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private final String f19899a = "com.didi.rlab/container_plugin";

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), this.f19899a).setMethodCallHandler(this);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        String str2 = (String) methodCall.argument("pageId");
        if (NFlutterContainerRegistry.getContainer(str2) != null) {
            BaseNachoSkeletonPage container = NFlutterContainerRegistry.getContainer(str2);
            if (container != null) {
                CustomerFlutterPage customerFlutterPage = (CustomerFlutterPage) container;
                if (Intrinsics.areEqual((Object) str, (Object) "setStatusBarColor")) {
                    Long l = (Long) methodCall.argument("color");
                    if (l != null) {
                        customerFlutterPage.setStatusBarColor((int) l.longValue());
                    }
                } else if (Intrinsics.areEqual((Object) str, (Object) "setAdapterStatusBarEnable") && (bool = (Boolean) methodCall.argument("enable")) != null) {
                    customerFlutterPage.setAdaptStatusBarEnable(bool.booleanValue());
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.customer.flutter.CustomerFlutterPage");
            }
        }
    }
}

package com.didi.entrega.customer.flutter.plugin;

import com.didi.entrega.customer.flutter.plugin.listener.OnPluginResultListener;
import kotlin.Metadata;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/entrega/customer/flutter/plugin/SimplePlugin$onMethodCall$1$2", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnPluginResultListener;", "onError", "", "name", "", "msg", "value", "", "onResult", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SimplePlugin.kt */
public final class SimplePlugin$onMethodCall$1$2 implements OnPluginResultListener {
    final /* synthetic */ MethodChannel.Result $result;

    SimplePlugin$onMethodCall$1$2(MethodChannel.Result result) {
        this.$result = result;
    }

    public void onResult(Object obj) {
        this.$result.success(obj);
    }

    public void onError(String str, String str2, Object obj) {
        this.$result.error(str, str2, obj);
    }
}

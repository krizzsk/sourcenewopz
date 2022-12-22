package com.didi.soda.customer.flutter.plugin;

import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import kotlin.Metadata;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/customer/flutter/plugin/PaymentPlugin$onMethodCall$1", "Lcom/didi/soda/customer/flutter/plugin/listener/OnPluginResultListener;", "onResult", "", "value", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaymentPlugin.kt */
public final class PaymentPlugin$onMethodCall$1 implements OnPluginResultListener {
    final /* synthetic */ MethodChannel.Result $result;

    PaymentPlugin$onMethodCall$1(MethodChannel.Result result) {
        this.$result = result;
    }

    public void onError(String str, String str2, Object obj) {
        OnPluginResultListener.DefaultImpls.onError(this, str, str2, obj);
    }

    public void onResult(Object obj) {
        this.$result.success((Object) null);
    }
}

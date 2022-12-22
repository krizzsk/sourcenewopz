package com.didi.entrega.customer.flutter.plugin.listener;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ/\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0000\u0010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0010\u0010\u0013\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f¢\u0006\u0002\u0010\u0014J2\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00032\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/entrega/customer/flutter/plugin/listener/SimpleCallPluginListener;", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnCallPluginListener;", "pageId", "", "(Ljava/lang/String;)V", "getPageId", "()Ljava/lang/String;", "setPageId", "callPlugin", "", "action", "params", "", "", "resultListener", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnPluginResultListener;", "get", "T", "key", "map", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/Object;", "onMethodCall", "method", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SimpleCallPluginListener.kt */
public abstract class SimpleCallPluginListener implements OnCallPluginListener {

    /* renamed from: a */
    private String f19900a;

    public abstract void onMethodCall(String str, Map<String, ? extends Object> map, OnPluginResultListener onPluginResultListener);

    public SimpleCallPluginListener(String str) {
        Intrinsics.checkNotNullParameter(str, "pageId");
        this.f19900a = str;
    }

    public final String getPageId() {
        return this.f19900a;
    }

    public final void setPageId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f19900a = str;
    }

    public final void callPlugin(String str, Map<String, ? extends Object> map, OnPluginResultListener onPluginResultListener) {
        Intrinsics.checkNotNullParameter(str, "action");
        if (Intrinsics.areEqual((Object) this.f19900a, (Object) str) && map != null) {
            Object obj = map.get("method");
            if (obj instanceof String) {
                onMethodCall((String) obj, map, onPluginResultListener);
            }
        }
    }

    public final <T> T get(String str, Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static /* synthetic */ void onMethodCall$default(SimpleCallPluginListener simpleCallPluginListener, String str, Map map, OnPluginResultListener onPluginResultListener, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                onPluginResultListener = null;
            }
            simpleCallPluginListener.onMethodCall(str, map, onPluginResultListener);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onMethodCall");
    }
}

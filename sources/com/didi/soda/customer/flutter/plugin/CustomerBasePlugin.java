package com.didi.soda.customer.flutter.plugin;

import com.didi.soda.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J4\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/customer/flutter/plugin/CustomerBasePlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "listeners", "Ljava/util/ArrayList;", "Lcom/didi/soda/customer/flutter/plugin/listener/OnCallPluginListener;", "Lkotlin/collections/ArrayList;", "getListeners", "()Ljava/util/ArrayList;", "setListeners", "(Ljava/util/ArrayList;)V", "addCallPluginListener", "", "listener", "notifyAllObserver", "action", "", "params", "", "", "resultListener", "Lcom/didi/soda/customer/flutter/plugin/listener/OnPluginResultListener;", "removeCallPluginListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBasePlugin.kt */
public abstract class CustomerBasePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private ArrayList<OnCallPluginListener> f40901a = new ArrayList<>();

    public final ArrayList<OnCallPluginListener> getListeners() {
        return this.f40901a;
    }

    public final void setListeners(ArrayList<OnCallPluginListener> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f40901a = arrayList;
    }

    public final void addCallPluginListener(OnCallPluginListener onCallPluginListener) {
        Intrinsics.checkNotNullParameter(onCallPluginListener, "listener");
        this.f40901a.add(onCallPluginListener);
    }

    public final void removeCallPluginListener(OnCallPluginListener onCallPluginListener) {
        Intrinsics.checkNotNullParameter(onCallPluginListener, "listener");
        this.f40901a.remove(onCallPluginListener);
    }

    public static /* synthetic */ void notifyAllObserver$default(CustomerBasePlugin customerBasePlugin, String str, Map map, OnPluginResultListener onPluginResultListener, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                map = null;
            }
            if ((i & 4) != 0) {
                onPluginResultListener = null;
            }
            customerBasePlugin.notifyAllObserver(str, map, onPluginResultListener);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyAllObserver");
    }

    public final void notifyAllObserver(String str, Map<String, ? extends Object> map, OnPluginResultListener onPluginResultListener) {
        Intrinsics.checkNotNullParameter(str, "action");
        for (OnCallPluginListener callPlugin : this.f40901a) {
            callPlugin.callPlugin(str, map, onPluginResultListener);
        }
    }
}

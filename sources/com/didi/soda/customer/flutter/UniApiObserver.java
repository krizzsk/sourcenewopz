package com.didi.soda.customer.flutter;

import com.didi.soda.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J4\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/customer/flutter/UniApiObserver;", "", "()V", "listeners", "Ljava/util/ArrayList;", "Lcom/didi/soda/customer/flutter/plugin/listener/OnCallPluginListener;", "Lkotlin/collections/ArrayList;", "getListeners", "()Ljava/util/ArrayList;", "setListeners", "(Ljava/util/ArrayList;)V", "addCallPluginListener", "", "listener", "notifyAllObserver", "action", "", "params", "", "resultListener", "Lcom/didi/soda/customer/flutter/plugin/listener/OnPluginResultListener;", "removeCallPluginListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UniApiObserver.kt */
public class UniApiObserver {

    /* renamed from: a */
    private ArrayList<OnCallPluginListener> f40900a = new ArrayList<>();

    public final ArrayList<OnCallPluginListener> getListeners() {
        return this.f40900a;
    }

    public final void setListeners(ArrayList<OnCallPluginListener> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f40900a = arrayList;
    }

    public final void addCallPluginListener(OnCallPluginListener onCallPluginListener) {
        Intrinsics.checkNotNullParameter(onCallPluginListener, "listener");
        this.f40900a.add(onCallPluginListener);
    }

    public final void removeCallPluginListener(OnCallPluginListener onCallPluginListener) {
        Intrinsics.checkNotNullParameter(onCallPluginListener, "listener");
        this.f40900a.remove(onCallPluginListener);
    }

    public static /* synthetic */ void notifyAllObserver$default(UniApiObserver uniApiObserver, String str, Map map, OnPluginResultListener onPluginResultListener, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                map = null;
            }
            if ((i & 4) != 0) {
                onPluginResultListener = null;
            }
            uniApiObserver.notifyAllObserver(str, map, onPluginResultListener);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyAllObserver");
    }

    public final void notifyAllObserver(String str, Map<String, ? extends Object> map, OnPluginResultListener onPluginResultListener) {
        Intrinsics.checkNotNullParameter(str, "action");
        for (OnCallPluginListener callPlugin : this.f40900a) {
            callPlugin.callPlugin(str, map, onPluginResultListener);
        }
    }
}

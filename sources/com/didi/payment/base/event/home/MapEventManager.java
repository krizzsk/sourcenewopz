package com.didi.payment.base.event.home;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/payment/base/event/home/MapEventManager;", "", "()V", "mapEvent", "", "", "", "Lcom/didi/payment/base/event/home/WalletEvent;", "postWalletEvent", "", "key", "register", "event", "unRegister", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MapEventManager.kt */
public final class MapEventManager {
    public static final MapEventManager INSTANCE = new MapEventManager();

    /* renamed from: a */
    private static final Map<String, List<WalletEvent>> f29899a = new LinkedHashMap();

    private MapEventManager() {
    }

    public final void register(String str, WalletEvent walletEvent) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(walletEvent, "event");
        List list = f29899a.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        list.add(walletEvent);
        f29899a.put(str, list);
    }

    public final void unRegister(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        List list = f29899a.get(str);
        if (list != null) {
            list.clear();
        }
    }

    public final void postWalletEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        List<WalletEvent> list = f29899a.get(str);
        if (list != null) {
            for (WalletEvent onWalletEvent : list) {
                onWalletEvent.onWalletEvent(str);
            }
        }
    }
}

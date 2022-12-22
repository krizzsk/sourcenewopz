package com.didiglobal.travel.biz.ride.trip;

import androidx.collection.ArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.Supplier;
import com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0006\"\u0006\b\u0000\u0010\f\u0018\u0001H\bJ\u001c\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fJ\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0007J\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u0006\"\u0006\b\u0000\u0010\f\u0018\u0001H\bR\"\u0010\u0003\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didiglobal/travel/biz/ride/trip/TripBehaviorController;", "", "()V", "typedBehaviorPool", "Landroidx/collection/ArrayMap;", "Ljava/lang/Class;", "Landroidx/collection/SparseArrayCompat;", "checkRspBehavior", "Lcom/didiglobal/travel/biz/ride/strategy/WaitRspBehaviorStrategy;", "pageId", "", "ensureTypedElement", "T", "getOrPutRspBehavior", "supplier", "Lkotlin/Function0;", "Landroidx/core/util/Supplier;", "getTypedElement", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TripBehaviorController.kt */
public final class TripBehaviorController {
    public static final TripBehaviorController INSTANCE = new TripBehaviorController();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final ArrayMap<Class<?>, SparseArrayCompat<?>> f51414a = new ArrayMap<>();

    private TripBehaviorController() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy checkRspBehavior(int r4) {
        /*
            com.didiglobal.travel.biz.ride.trip.TripBehaviorController r0 = INSTANCE
            monitor-enter(r0)
            androidx.collection.ArrayMap r1 = f51414a     // Catch:{ all -> 0x0022 }
            java.lang.Class<com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy> r2 = com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy.class
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0022 }
            boolean r2 = r1 instanceof androidx.collection.SparseArrayCompat     // Catch:{ all -> 0x0022 }
            r3 = 0
            if (r2 == 0) goto L_0x0015
            androidx.collection.SparseArrayCompat r1 = (androidx.collection.SparseArrayCompat) r1     // Catch:{ all -> 0x0022 }
            goto L_0x0016
        L_0x0015:
            r1 = r3
        L_0x0016:
            if (r1 != 0) goto L_0x0019
            goto L_0x0020
        L_0x0019:
            java.lang.Object r4 = r1.get(r4)     // Catch:{ all -> 0x0022 }
            r3 = r4
            com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy r3 = (com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy) r3     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r0)
            return r3
        L_0x0022:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.biz.ride.trip.TripBehaviorController.checkRspBehavior(int):com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy");
    }

    public final WaitRspBehaviorStrategy getOrPutRspBehavior(int i, Function0<WaitRspBehaviorStrategy> function0) {
        WaitRspBehaviorStrategy waitRspBehaviorStrategy;
        Intrinsics.checkNotNullParameter(function0, "supplier");
        synchronized (this) {
            Map access$getTypedBehaviorPool$p = f51414a;
            Class<WaitRspBehaviorStrategy> cls = WaitRspBehaviorStrategy.class;
            Object obj = access$getTypedBehaviorPool$p.get(cls);
            if (obj == null) {
                obj = new SparseArrayCompat();
                access$getTypedBehaviorPool$p.put(cls, obj);
            }
            SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) obj;
            waitRspBehaviorStrategy = (WaitRspBehaviorStrategy) sparseArrayCompat.get(i);
            if (waitRspBehaviorStrategy == null) {
                WaitRspBehaviorStrategy invoke = function0.invoke();
                sparseArrayCompat.put(i, invoke);
                waitRspBehaviorStrategy = invoke;
            }
            Intrinsics.checkNotNullExpressionValue(waitRspBehaviorStrategy, "mem.get(pageId) ?: suppl…o { mem.put(pageId, it) }");
        }
        return waitRspBehaviorStrategy;
    }

    @JvmStatic
    public static final WaitRspBehaviorStrategy getOrPutRspBehavior(int i, Supplier<WaitRspBehaviorStrategy> supplier) {
        WaitRspBehaviorStrategy orPutRspBehavior;
        Intrinsics.checkNotNullParameter(supplier, "supplier");
        synchronized (INSTANCE) {
            orPutRspBehavior = INSTANCE.getOrPutRspBehavior(i, (Function0<WaitRspBehaviorStrategy>) new TripBehaviorController$getOrPutRspBehavior$2$1(supplier));
        }
        return orPutRspBehavior;
    }

    /* renamed from: a */
    private final /* synthetic */ <T> SparseArrayCompat<T> m36810a() {
        ArrayMap access$getTypedBehaviorPool$p = f51414a;
        Intrinsics.reifiedOperationMarker(4, "T");
        Object obj = access$getTypedBehaviorPool$p.get(Object.class);
        if (obj instanceof SparseArrayCompat) {
            return (SparseArrayCompat) obj;
        }
        return null;
    }

    /* renamed from: b */
    private final /* synthetic */ <T> SparseArrayCompat<T> m36811b() {
        Map access$getTypedBehaviorPool$p = f51414a;
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        Object obj = access$getTypedBehaviorPool$p.get(cls);
        if (obj == null) {
            obj = new SparseArrayCompat();
            access$getTypedBehaviorPool$p.put(cls, obj);
        }
        return (SparseArrayCompat) obj;
    }
}

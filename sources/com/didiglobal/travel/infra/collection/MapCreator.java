package com.didiglobal.travel.infra.collection;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b@\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u001e\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u001c\u0010\u0011\u001a\u00020\u0012*\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u0012*\u00028\u00002\b\u0010\u0013\u001a\u0004\u0018\u00018\u0001H\u0004¢\u0006\u0004\b\u0017\u0010\u0015R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/collection/MapCreator;", "K", "V", "", "actualMap", "", "constructor-impl", "(Ljava/util/Map;)Ljava/util/Map;", "getActualMap", "()Ljava/util/Map;", "equals", "", "other", "hashCode", "", "toString", "", "kv", "", "value", "kv-impl", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "kvNotNull", "kvNotNull-impl", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Map.kt */
public final class MapCreator<K, V> {

    /* renamed from: a */
    private final Map<K, V> f51418a;

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Map m47062constructorimpl(Map<K, V> map) {
        Intrinsics.checkParameterIsNotNull(map, "actualMap");
        return map;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47063equalsimpl(Map map, Object obj) {
        return (obj instanceof MapCreator) && Intrinsics.areEqual((Object) map, (Object) ((MapCreator) obj).m47069unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47064equalsimpl0(Map map, Map map2) {
        return Intrinsics.areEqual((Object) map, (Object) map2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47065hashCodeimpl(Map map) {
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47068toStringimpl(Map map) {
        return "MapCreator(actualMap=" + map + ")";
    }

    public boolean equals(Object obj) {
        return m47063equalsimpl(this.f51418a, obj);
    }

    public int hashCode() {
        return m47065hashCodeimpl(this.f51418a);
    }

    public String toString() {
        return m47068toStringimpl(this.f51418a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Map<K, V> m47069unboximpl() {
        return this.f51418a;
    }

    private /* synthetic */ MapCreator(Map<K, V> map) {
        Intrinsics.checkParameterIsNotNull(map, "actualMap");
        this.f51418a = map;
    }

    public final Map<K, V> getActualMap() {
        return this.f51418a;
    }

    /* renamed from: kv-impl  reason: not valid java name */
    public static final void m47066kvimpl(Map<K, V> map, K k, V v) {
        map.put(k, v);
    }

    /* renamed from: kvNotNull-impl  reason: not valid java name */
    public static final void m47067kvNotNullimpl(Map<K, V> map, K k, V v) {
        if (v != null) {
            map.put(k, v);
        }
    }
}

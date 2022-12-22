package com.didiglobal.travel.infra.collection;

import androidx.collection.ArrayMap;
import com.didi.raven.config.RavenKey;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006¢\u0006\u0002\u0010\u0007\u001a2\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006\u001aF\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006\u001aZ\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006\u001an\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006\u001aE\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00012\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\u0013\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\bø\u0001\u0000\u001aE\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0002\u001a0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, mo175978d2 = {"lightMapOf", "", "K", "V", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/Map;", "", "pair", "p1", "p2", "p3", "p4", "simplyMapOf", "", "", "capacity", "", "supplier", "Lkotlin/Function1;", "Lcom/didiglobal/travel/infra/collection/MapCreator;", "", "Lkotlin/ExtensionFunctionType;", "plus", "takeIfNotEmpty", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Map.kt */
public final class MapKt {
    public static final Map<String, Object> simplyMapOf(int i, Function1<? super MapCreator<String, Object>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "supplier");
        MapCreator r1 = Intrinsics.checkParameterIsNotNull(MapCreator.m47062constructorimpl(new ArrayMap(i)), RavenKey.VERSION);
        function1.invoke(r1);
        return r1.m47069unboximpl();
    }

    public static final <K, V> Map<K, V> lightMapOf(Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.checkExpressionValueIsNotNull(singletonMap, "Collections.singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> lightMapOf(Pair<? extends K, ? extends V> pair, Pair<? extends K, ? extends V> pair2) {
        Intrinsics.checkParameterIsNotNull(pair, "p1");
        Intrinsics.checkParameterIsNotNull(pair2, "p2");
        ArrayMap arrayMap = new ArrayMap(2);
        arrayMap.put(pair.getFirst(), pair.getSecond());
        arrayMap.put(pair2.getFirst(), pair2.getSecond());
        return arrayMap;
    }

    public static final <K, V> Map<K, V> lightMapOf(Pair<? extends K, ? extends V> pair, Pair<? extends K, ? extends V> pair2, Pair<? extends K, ? extends V> pair3) {
        Intrinsics.checkParameterIsNotNull(pair, "p1");
        Intrinsics.checkParameterIsNotNull(pair2, "p2");
        Intrinsics.checkParameterIsNotNull(pair3, "p3");
        ArrayMap arrayMap = new ArrayMap(3);
        arrayMap.put(pair.getFirst(), pair.getSecond());
        arrayMap.put(pair2.getFirst(), pair2.getSecond());
        arrayMap.put(pair3.getFirst(), pair3.getSecond());
        return arrayMap;
    }

    public static final <K, V> Map<K, V> lightMapOf(Pair<? extends K, ? extends V> pair, Pair<? extends K, ? extends V> pair2, Pair<? extends K, ? extends V> pair3, Pair<? extends K, ? extends V> pair4) {
        Intrinsics.checkParameterIsNotNull(pair, "p1");
        Intrinsics.checkParameterIsNotNull(pair2, "p2");
        Intrinsics.checkParameterIsNotNull(pair3, "p3");
        Intrinsics.checkParameterIsNotNull(pair4, "p4");
        ArrayMap arrayMap = new ArrayMap(4);
        arrayMap.put(pair.getFirst(), pair.getSecond());
        arrayMap.put(pair2.getFirst(), pair2.getSecond());
        arrayMap.put(pair3.getFirst(), pair3.getSecond());
        arrayMap.put(pair4.getFirst(), pair4.getSecond());
        return arrayMap;
    }

    public static final <K, V> Map<K, V> lightMapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkParameterIsNotNull(pairArr, "pairs");
        Map<K, V> arrayMap = new ArrayMap<>(pairArr.length);
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            arrayMap.put(pair.getFirst(), pair.getSecond());
        }
        return arrayMap;
    }

    public static final <K, V> Map<K, V> takeIfNotEmpty(Map<K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "$this$takeIfNotEmpty");
        if (!map.isEmpty()) {
            return map;
        }
        return null;
    }

    public static final <K, V> Map<K, V> plus(Map<K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkParameterIsNotNull(map, "$this$plus");
        Intrinsics.checkParameterIsNotNull(pair, "pair");
        Object component1 = pair.component1();
        Object component2 = pair.component2();
        if (TypeIntrinsics.isMutableMap(map)) {
            map.put(component1, component2);
            return map;
        }
        Map<K, V> mutableMap = MapsKt.toMutableMap(map);
        mutableMap.put(component1, component2);
        return mutableMap;
    }
}

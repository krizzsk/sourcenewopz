package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

@Metadata(mo175977d1 = {"\u0000(\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0002\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\rH\u0000\u001a(\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00110\rH\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"ALL_TIMINGS", "", "", "CONNECT_TIMING", "DNS_TIMING", "DOWNLOAD_TIMING", "DURATION_KEY", "FIRST_BYTE_TIMING", "SSL_TIMING", "START_TIME_KEY", "createResourceTiming", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "timings", "", "Lcom/datadog/android/rum/internal/domain/scope/Timing;", "extractResourceTiming", "timingsPayload", "", "extractTiming", "name", "source", "dd-sdk-android_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExternalResourceTimings.kt */
public final class ExternalResourceTimingsKt {

    /* renamed from: a */
    private static final String f3715a = "firstByte";

    /* renamed from: b */
    private static final String f3716b = "download";

    /* renamed from: c */
    private static final String f3717c = "ssl";

    /* renamed from: d */
    private static final String f3718d = "connect";

    /* renamed from: e */
    private static final String f3719e = "dns";

    /* renamed from: f */
    private static final List<String> f3720f = CollectionsKt.listOf(f3715a, "download", f3717c, "connect", "dns");

    /* renamed from: g */
    private static final String f3721g = "startTime";

    /* renamed from: h */
    private static final String f3722h = "duration";

    public static final ResourceTiming extractResourceTiming(Map<String, ? extends Object> map) {
        if (map == null) {
            return null;
        }
        Iterable iterable = f3720f;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(next, m2425a((String) next, map));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((C2199a) entry.getValue()) == null) {
                z = false;
            }
            if (z) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        Map map2 = linkedHashMap2;
        if (!map2.isEmpty()) {
            return m2424a(map2);
        }
        return null;
    }

    /* renamed from: a */
    private static final ResourceTiming m2424a(Map<String, C2199a> map) {
        Map<String, C2199a> map2 = map;
        C2199a aVar = map2.get(f3715a);
        long j = 0;
        long a = aVar == null ? 0 : aVar.mo20828a();
        C2199a aVar2 = map2.get(f3715a);
        long b = aVar2 == null ? 0 : aVar2.mo20830b();
        C2199a aVar3 = map2.get("download");
        long a2 = aVar3 == null ? 0 : aVar3.mo20828a();
        C2199a aVar4 = map2.get("download");
        long b2 = aVar4 == null ? 0 : aVar4.mo20830b();
        C2199a aVar5 = map2.get("dns");
        long a3 = aVar5 == null ? 0 : aVar5.mo20828a();
        C2199a aVar6 = map2.get("dns");
        long b3 = aVar6 == null ? 0 : aVar6.mo20830b();
        C2199a aVar7 = map2.get("connect");
        long a4 = aVar7 == null ? 0 : aVar7.mo20828a();
        C2199a aVar8 = map2.get("connect");
        long b4 = aVar8 == null ? 0 : aVar8.mo20830b();
        C2199a aVar9 = map2.get(f3717c);
        long a5 = aVar9 == null ? 0 : aVar9.mo20828a();
        C2199a aVar10 = map2.get(f3717c);
        if (aVar10 != null) {
            j = aVar10.mo20830b();
        }
        return new ResourceTiming(a3, b3, a4, b4, a5, j, a, b, a2, b2);
    }

    /* renamed from: a */
    private static final C2199a m2425a(String str, Map<String, ? extends Object> map) {
        Object obj = map.get(str);
        if (obj == null || !(obj instanceof Map)) {
            return null;
        }
        Map map2 = (Map) obj;
        Object obj2 = map2.get("startTime");
        Number number = obj2 instanceof Number ? (Number) obj2 : null;
        Long valueOf = number == null ? null : Long.valueOf(number.longValue());
        Object obj3 = map2.get("duration");
        Number number2 = obj3 instanceof Number ? (Number) obj3 : null;
        Long valueOf2 = number2 == null ? null : Long.valueOf(number2.longValue());
        if (valueOf == null || valueOf2 == null) {
            return null;
        }
        return new C2199a(valueOf.longValue(), valueOf2.longValue());
    }
}

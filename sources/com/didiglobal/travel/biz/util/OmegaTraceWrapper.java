package com.didiglobal.travel.biz.util;

import androidx.collection.ArrayMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@TraceDsl
@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jf\u0010\u000e\u001a\u00020\u000f2W\u0010\u0010\u001aS\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\t\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000f0\u0011H\u0000¢\u0006\u0002\b\u0016J\u0017\u0010\u0017\u001a\u00020\u000f*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didiglobal/travel/biz/util/OmegaTraceWrapper;", "", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "eventLabel", "getEventLabel", "setEventLabel", "propertiesMap", "", "toComponents", "", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "", "params", "toComponents$common_release", "prop", "value", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TraceUtils.kt */
public final class OmegaTraceWrapper {

    /* renamed from: a */
    private String f51415a = "";

    /* renamed from: b */
    private String f51416b = "";

    /* renamed from: c */
    private Map<String, Object> f51417c;

    public final String getEventId() {
        return this.f51415a;
    }

    public final void setEventId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f51415a = str;
    }

    public final String getEventLabel() {
        return this.f51416b;
    }

    public final void setEventLabel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f51416b = str;
    }

    public final void prop(String str, Object obj) {
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        if (charSequence != null) {
            String str2 = (String) charSequence;
            if (obj != null) {
                synchronized (str) {
                    map = this.f51417c;
                    if (map == null) {
                        map = new ArrayMap<>(4);
                    }
                }
                map.put(str2, obj);
            }
        }
    }

    public final void toComponents$common_release(Function3<? super String, ? super String, ? super Map<String, ? extends Object>, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "action");
        String str = this.f51415a;
        String str2 = this.f51416b;
        Map<String, Object> map = this.f51417c;
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        function3.invoke(str, str2, map);
    }
}

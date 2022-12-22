package com.didi.dimina.container.util;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/dimina/container/util/CoreDottingExtra;", "", "()V", "hashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "toInfo", "with", "key", "value", "Companion", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CoreDottingExtra.kt */
public final class CoreDottingExtra {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final HashMap<String, Object> f17930a = new HashMap<>();

    @JvmStatic
    public static final CoreDottingExtra create() {
        return Companion.create();
    }

    public final CoreDottingExtra with(String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.f17930a.put(str, obj);
        return this;
    }

    public final String toInfo() {
        String str;
        ArrayList arrayList = new ArrayList();
        Map map = this.f17930a;
        Collection arrayList2 = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(Typography.quote);
            sb.append((String) entry.getKey());
            sb.append("\":");
            if (value instanceof String) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Typography.quote);
                sb2.append(value);
                sb2.append(Typography.quote);
                str = sb2.toString();
            } else {
                str = String.valueOf(value);
            }
            sb.append(str);
            arrayList2.add(Boolean.valueOf(arrayList.add(sb.toString())));
        }
        List list = (List) arrayList2;
        return CollectionsKt.joinToString$default(arrayList, ",", Const.joLeft, "}", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/dimina/container/util/CoreDottingExtra$Companion;", "", "()V", "create", "Lcom/didi/dimina/container/util/CoreDottingExtra;", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: CoreDottingExtra.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CoreDottingExtra create() {
            return new CoreDottingExtra();
        }
    }
}

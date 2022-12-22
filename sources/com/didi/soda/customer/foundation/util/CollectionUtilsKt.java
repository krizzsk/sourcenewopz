package com.didi.soda.customer.foundation.util;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a0\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u001aC\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b0\u0005\u001a,\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00102\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u001a'\u0010\u0011\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0001¢\u0006\u0002\u0010\u0013\u001a\u0018\u0010\u0014\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003¨\u0006\u0015"}, mo175978d2 = {"count", "", "T", "", "predicate", "Lkotlin/Function1;", "", "dividerBy", "", "div", "content", "Lkotlin/ParameterName;", "name", "ele", "removeAll", "", "Landroid/util/SparseArray;", "safeGet", "index", "(Ljava/util/List;I)Ljava/lang/Object;", "sizeOrNull", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CollectionUtils.kt */
public final class CollectionUtilsKt {
    public static final <T> int sizeOrNull(List<? extends T> list) {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public static /* synthetic */ int count$default(List list, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return count(list, function1);
    }

    public static final <T> int count(List<? extends T> list, Function1<? super T, Boolean> function1) {
        Integer num;
        int i = 0;
        if (list == null) {
            return 0;
        }
        if (function1 == null) {
            num = null;
        } else {
            for (Object invoke : list) {
                if (function1.invoke(invoke).booleanValue()) {
                    i++;
                }
            }
            num = Integer.valueOf(i);
        }
        if (num == null) {
            return sizeOrNull(list);
        }
        return num.intValue();
    }

    public static final <T> void removeAll(SparseArray<T> sparseArray, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (sparseArray != null) {
            List<Number> arrayList = new ArrayList<>();
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                if (function1.invoke(sparseArray.valueAt(i)).booleanValue()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            if (arrayList.size() > 0) {
                for (Number intValue : arrayList) {
                    sparseArray.remove(intValue.intValue());
                }
            }
        }
    }

    public static final <T> T safeGet(List<? extends T> list, int i) {
        if (list == null || i < 0 || i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static final <T> String dividerBy(List<? extends T> list, String str, Function1<? super T, String> function1) {
        Intrinsics.checkNotNullParameter(str, "div");
        Intrinsics.checkNotNullParameter(function1, "content");
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (i > 0) {
                sb.append(str);
            }
            sb.append(function1.invoke(next));
            i = i2;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "result.toString()");
        return sb2;
    }
}

package com.didi.entrega.customer.foundation.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u001a\u0018\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003¨\u0006\b"}, mo175978d2 = {"count", "", "T", "", "predicate", "Lkotlin/Function1;", "", "sizeOrNull", "entrega-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
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
}

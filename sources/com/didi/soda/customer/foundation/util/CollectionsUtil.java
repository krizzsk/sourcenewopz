package com.didi.soda.customer.foundation.util;

import com.didi.soda.customer.foundation.util.function.Function1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class CollectionsUtil {
    private CollectionsUtil() {
    }

    public static <T extends Collection> boolean isEmpty(T t) {
        return t == null || t.size() <= 0;
    }

    public static <T> List<T> iteratorToList(Iterator<T> it) {
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <T> T find(Collection<T> collection, Function1<T, Boolean> function1) {
        if (!(collection == null || function1 == null)) {
            for (T next : collection) {
                if (function1.apply(next).booleanValue()) {
                    return next;
                }
            }
        }
        return null;
    }
}

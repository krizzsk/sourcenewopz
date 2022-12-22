package p242io.reactivex.internal.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p242io.reactivex.functions.Function;

/* renamed from: io.reactivex.internal.util.SorterFunction */
public final class SorterFunction<T> implements Function<List<T>, List<T>> {

    /* renamed from: a */
    final Comparator<? super T> f59301a;

    public SorterFunction(Comparator<? super T> comparator) {
        this.f59301a = comparator;
    }

    public List<T> apply(List<T> list) throws Exception {
        Collections.sort(list, this.f59301a);
        return list;
    }
}

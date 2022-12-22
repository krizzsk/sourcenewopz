package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import java.util.Iterator;

public final class Iterables {
    public static String toString(Iterable<?> iterable) {
        return Iterators.toString(iterable.iterator());
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        final ImmutableList<E> of = ImmutableList.m40366of(iterable, iterable2);
        Joiner.checkNotNull(of);
        return new FluentIterable<T>() {
            public final Iterator<T> iterator() {
                return Iterators.concat(Iterables.access$100(of));
            }
        };
    }

    static /* synthetic */ Iterator access$100(Iterable iterable) {
        return new TransformedIterator<Iterable<? extends T>, Iterator<? extends T>>(iterable.iterator()) {
            /* access modifiers changed from: package-private */
            public final /* synthetic */ Object transform(Object obj) {
                return ((Iterable) obj).iterator();
            }
        };
    }
}

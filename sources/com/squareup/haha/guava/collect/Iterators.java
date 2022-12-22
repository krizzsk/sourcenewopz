package com.squareup.haha.guava.collect;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.squareup.haha.guava.base.Function;
import com.squareup.haha.guava.base.Joiner;
import com.squareup.haha.guava.base.Predicate;
import com.squareup.haha.guava.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import org.osgi.framework.VersionRange;

public final class Iterators {
    private static UnmodifiableListIterator<Object> EMPTY_LIST_ITERATOR = new UnmodifiableListIterator<Object>() {
        public final boolean hasNext() {
            return false;
        }

        public final boolean hasPrevious() {
            return false;
        }

        public final int nextIndex() {
            return 0;
        }

        public final int previousIndex() {
            return -1;
        }

        public final Object next() {
            throw new NoSuchElementException();
        }

        public final Object previous() {
            throw new NoSuchElementException();
        }
    };
    private static final Iterator<Object> EMPTY_MODIFIABLE_ITERATOR = new Iterator<Object>() {
        public final boolean hasNext() {
            return false;
        }

        public final Object next() {
            throw new NoSuchElementException();
        }

        public final void remove() {
            Joiner.checkRemove(false);
        }
    };

    static <T> Iterator<T> emptyModifiableIterator() {
        return EMPTY_MODIFIABLE_ITERATOR;
    }

    public static boolean removeAll(Iterator<?> it, Collection<?> collection) {
        Predicate<T> in = Predicates.m40363in(collection);
        Joiner.checkNotNull(in);
        boolean z = false;
        while (it.hasNext()) {
            if (in.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0007  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean elementsEqual(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L_0x0000:
            boolean r0 = r3.hasNext()
            r1 = 0
            if (r0 == 0) goto L_0x001d
            boolean r0 = r4.hasNext()
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = com.squareup.haha.guava.base.Joiner.equal(r0, r2)
            if (r0 != 0) goto L_0x0000
            return r1
        L_0x001d:
            boolean r3 = r4.hasNext()
            if (r3 != 0) goto L_0x0025
            r3 = 1
            return r3
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.haha.guava.collect.Iterators.elementsEqual(java.util.Iterator, java.util.Iterator):boolean");
    }

    public static String toString(Iterator<?> it) {
        StringBuilder appendTo = Collections2.STANDARD_JOINER.appendTo(new StringBuilder(Const.jaLeft), it);
        appendTo.append(VersionRange.RIGHT_CLOSED);
        return appendTo.toString();
    }

    public static <T> Iterator<T> concat(final Iterator<? extends Iterator<? extends T>> it) {
        Joiner.checkNotNull(it);
        return new Iterator<T>() {
            private Iterator<? extends T> current = Iterators.emptyIterator();
            private Iterator<? extends T> removeFrom;

            public final boolean hasNext() {
                boolean hasNext;
                while (true) {
                    hasNext = ((Iterator) Joiner.checkNotNull(this.current)).hasNext();
                    if (hasNext || !it.hasNext()) {
                        return hasNext;
                    }
                    this.current = (Iterator) it.next();
                }
                return hasNext;
            }

            public final T next() {
                if (hasNext()) {
                    Iterator<? extends T> it = this.current;
                    this.removeFrom = it;
                    return it.next();
                }
                throw new NoSuchElementException();
            }

            public final void remove() {
                Joiner.checkRemove(this.removeFrom != null);
                this.removeFrom.remove();
                this.removeFrom = null;
            }
        };
    }

    public static <F, T> Iterator<T> transform(Iterator<F> it, final Function<? super F, ? extends T> function) {
        Joiner.checkNotNull(function);
        return new TransformedIterator<F, T>(it) {
            /* access modifiers changed from: package-private */
            public final T transform(F f) {
                return function.apply(f);
            }
        };
    }

    static void clear(Iterator<?> it) {
        Joiner.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    static <T> UnmodifiableListIterator<T> forArray(final T[] tArr, final int i, int i2, int i3) {
        Joiner.checkArgument(i2 >= 0);
        Joiner.checkPositionIndexes(i, i + i2, tArr.length);
        Joiner.checkPositionIndex(i3, i2);
        if (i2 == 0) {
            return EMPTY_LIST_ITERATOR;
        }
        return new AbstractIndexedListIterator<T>(i2, i3) {
            /* access modifiers changed from: protected */
            public final T get(int i) {
                return tArr[i + i];
            }
        };
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@Nullable final T t) {
        return new UnmodifiableIterator<T>() {
            private boolean done;

            public final boolean hasNext() {
                return !this.done;
            }

            public final T next() {
                if (!this.done) {
                    this.done = true;
                    return t;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return EMPTY_LIST_ITERATOR;
    }
}

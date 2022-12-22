package com.squareup.haha.guava.base;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

public final class Predicates {
    /* renamed from: in */
    public static <T> Predicate<T> m40363in(Collection<? extends T> collection) {
        return new InPredicate(collection, (byte) 0);
    }

    static class InPredicate<T> implements Predicate<T>, Serializable {
        private final Collection<?> target;

        /* synthetic */ InPredicate(Collection collection, byte b) {
            this(collection);
        }

        private InPredicate(Collection<?> collection) {
            this.target = (Collection) Joiner.checkNotNull(collection);
        }

        public final boolean apply(@Nullable T t) {
            try {
                return this.target.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        public final boolean equals(@Nullable Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        public final int hashCode() {
            return this.target.hashCode();
        }

        public final String toString() {
            return "Predicates.in(" + this.target + ")";
        }
    }

    static {
        new Joiner(",");
    }
}

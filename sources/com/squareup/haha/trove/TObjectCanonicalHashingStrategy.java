package com.squareup.haha.trove;

final class TObjectCanonicalHashingStrategy<T> implements TObjectHashingStrategy<T> {
    TObjectCanonicalHashingStrategy() {
    }

    public final int computeHashCode(T t) {
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    public final boolean equals(T t, T t2) {
        if (t != null) {
            return t.equals(t2);
        }
        return t2 == null;
    }
}

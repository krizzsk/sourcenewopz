package org.apache.commons.lang3.tuple;

public final class ImmutableTriple<L, M, R> extends Triple<L, M, R> {
    private static final ImmutableTriple NULL = m3623of((Object) null, (Object) null, (Object) null);
    private static final long serialVersionUID = 1;
    public final L left;
    public final M middle;
    public final R right;

    public static <L, M, R> ImmutableTriple<L, M, R> nullTriple() {
        return NULL;
    }

    /* renamed from: of */
    public static <L, M, R> ImmutableTriple<L, M, R> m3623of(L l, M m, R r) {
        return new ImmutableTriple<>(l, m, r);
    }

    public ImmutableTriple(L l, M m, R r) {
        this.left = l;
        this.middle = m;
        this.right = r;
    }

    public L getLeft() {
        return this.left;
    }

    public M getMiddle() {
        return this.middle;
    }

    public R getRight() {
        return this.right;
    }
}

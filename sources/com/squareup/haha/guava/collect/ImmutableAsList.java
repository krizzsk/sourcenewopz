package com.squareup.haha.guava.collect;

abstract class ImmutableAsList<E> extends ImmutableList<E> {
    /* access modifiers changed from: package-private */
    public abstract ImmutableCollection<E> delegateCollection();

    ImmutableAsList() {
    }

    public boolean contains(Object obj) {
        return delegateCollection().contains(obj);
    }

    public int size() {
        return delegateCollection().size();
    }

    public boolean isEmpty() {
        return delegateCollection().isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return delegateCollection().isPartialView();
    }
}

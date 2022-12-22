package com.squareup.haha.trove;

final class TObjectHashIterator<E> extends THashIterator<E> {
    private TObjectHash<E> _objectHash;

    public TObjectHashIterator(TObjectHash<E> tObjectHash) {
        super(tObjectHash);
        this._objectHash = tObjectHash;
    }

    /* access modifiers changed from: protected */
    public final E objectAtIndex(int i) {
        return this._objectHash._set[i];
    }
}

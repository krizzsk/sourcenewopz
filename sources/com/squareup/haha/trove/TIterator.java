package com.squareup.haha.trove;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

abstract class TIterator {
    protected int _expectedSize;
    private THash _hash;
    protected int _index = this._hash.capacity();

    /* access modifiers changed from: protected */
    public abstract int nextIndex();

    public TIterator(THash tHash) {
        this._hash = tHash;
        this._expectedSize = tHash.size();
    }

    public boolean hasNext() {
        return nextIndex() >= 0;
    }

    /* JADX INFO: finally extract failed */
    public void remove() {
        if (this._expectedSize == this._hash.size()) {
            this._hash.stopCompactingOnRemove();
            try {
                this._hash.removeAt(this._index);
                this._hash.startCompactingOnRemove(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.startCompactingOnRemove(false);
                throw th;
            }
        } else {
            throw new ConcurrentModificationException();
        }
    }

    /* access modifiers changed from: protected */
    public final void moveToNextIndex() {
        int nextIndex = nextIndex();
        this._index = nextIndex;
        if (nextIndex < 0) {
            throw new NoSuchElementException();
        }
    }
}

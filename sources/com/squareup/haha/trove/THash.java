package com.squareup.haha.trove;

public abstract class THash implements Cloneable {
    protected static final int DEFAULT_INITIAL_CAPACITY = 4;
    protected static final float DEFAULT_LOAD_FACTOR = 0.8f;
    protected transient int _deadkeys;
    protected transient int _free;
    protected final float _loadFactor;
    protected int _maxSize;
    protected transient int _size;

    /* access modifiers changed from: protected */
    public abstract int capacity();

    /* access modifiers changed from: protected */
    public abstract void rehash(int i);

    public THash() {
        this(4, 0.8f);
    }

    public THash(int i) {
        this(i, 0.8f);
    }

    public THash(int i, float f) {
        this._loadFactor = f;
        setUp(((int) (((float) i) / f)) + 1);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean isEmpty() {
        return this._size == 0;
    }

    public int size() {
        return this._size;
    }

    public void ensureCapacity(int i) {
        if (i > this._maxSize - size()) {
            rehash(PrimeFinder.nextPrime(((int) (((float) i) + (((float) size()) / this._loadFactor))) + 2));
            computeMaxSize(capacity());
        }
    }

    public void compact() {
        rehash(PrimeFinder.nextPrime(((int) (((float) size()) / this._loadFactor)) + 2));
        computeMaxSize(capacity());
    }

    public final void trimToSize() {
        compact();
    }

    /* access modifiers changed from: protected */
    public void removeAt(int i) {
        this._size--;
        this._deadkeys++;
        compactIfNecessary();
    }

    private void compactIfNecessary() {
        if (this._deadkeys > this._size && capacity() > 42) {
            compact();
        }
    }

    public final void stopCompactingOnRemove() {
        int i = this._deadkeys;
        if (i >= 0) {
            this._deadkeys = i - capacity();
            return;
        }
        throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }

    public final void startCompactingOnRemove(boolean z) {
        int i = this._deadkeys;
        if (i < 0) {
            this._deadkeys = i + capacity();
            if (z) {
                compactIfNecessary();
                return;
            }
            return;
        }
        throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }

    public void clear() {
        this._size = 0;
        this._free = capacity();
        this._deadkeys = 0;
    }

    /* access modifiers changed from: protected */
    public int setUp(int i) {
        int nextPrime = PrimeFinder.nextPrime(i);
        computeMaxSize(nextPrime);
        return nextPrime;
    }

    private void computeMaxSize(int i) {
        this._maxSize = Math.min(i - 1, (int) (((float) i) * this._loadFactor));
        this._free = i - this._size;
        this._deadkeys = 0;
    }

    /* access modifiers changed from: protected */
    public final void postInsertHook(boolean z) {
        if (z) {
            this._free--;
        } else {
            this._deadkeys--;
        }
        int i = this._size + 1;
        this._size = i;
        if (i > this._maxSize || this._free == 0) {
            rehash(PrimeFinder.nextPrime(calculateGrownCapacity()));
            computeMaxSize(capacity());
        }
    }

    /* access modifiers changed from: protected */
    public int calculateGrownCapacity() {
        return capacity() << 1;
    }
}

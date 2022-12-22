package com.squareup.haha.trove;

public abstract class TPrimitiveHash extends THash {
    protected transient byte[] _states;

    public Object clone() {
        TPrimitiveHash tPrimitiveHash = (TPrimitiveHash) super.clone();
        tPrimitiveHash._states = (byte[]) this._states.clone();
        return tPrimitiveHash;
    }

    /* access modifiers changed from: protected */
    public int capacity() {
        return this._states.length;
    }

    /* access modifiers changed from: protected */
    public void removeAt(int i) {
        this._states[i] = 2;
        super.removeAt(i);
    }

    /* access modifiers changed from: protected */
    public int setUp(int i) {
        int up = super.setUp(i);
        this._states = new byte[up];
        return up;
    }
}

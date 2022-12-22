package com.didi.app.nova.skeleton.conductor.internal;

import android.os.Bundle;

public class TransactionIndexer {

    /* renamed from: a */
    private static final String f8406a = "TransactionIndexer.currentIndex";

    /* renamed from: b */
    private int f8407b;

    public int nextIndex() {
        int i = this.f8407b + 1;
        this.f8407b = i;
        return i;
    }

    public void saveInstanceState(Bundle bundle) {
        bundle.putInt(f8406a, this.f8407b);
    }

    public void restoreInstanceState(Bundle bundle) {
        this.f8407b = bundle.getInt(f8406a);
    }
}

package com.microblink.blinkbarcode.util;

import android.os.Handler;

/* compiled from: line */
public class llIIIlllll implements IllIIIllII {
    private Handler llIIlIlIIl = new Handler();

    public void llIIlIlIIl(Runnable runnable) {
        this.llIIlIlIIl.post(runnable);
    }

    public void llIIlIlIIl(Runnable runnable, long j) {
        this.llIIlIlIIl.postDelayed(runnable, j);
    }

    public Handler llIIlIlIIl() {
        return this.llIIlIlIIl;
    }
}

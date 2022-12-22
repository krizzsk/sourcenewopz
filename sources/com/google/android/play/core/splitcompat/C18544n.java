package com.google.android.play.core.splitcompat;

import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.google.android.play.core.splitcompat.n */
final class C18544n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitCompat f53249a;

    C18544n(SplitCompat splitCompat) {
        this.f53249a = splitCompat;
    }

    public final void run() {
        try {
            this.f53249a.f53224b.mo149219a();
        } catch (Exception e) {
            SystemUtils.log(6, "SplitCompat", "Failed to cleanup splitcompat storage", e, "com.google.android.play.core.splitcompat.n", -1);
        }
    }
}

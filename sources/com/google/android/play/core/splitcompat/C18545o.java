package com.google.android.play.core.splitcompat;

import com.didi.sdk.apm.SystemUtils;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.o */
final class C18545o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Set f53250a;

    /* renamed from: b */
    final /* synthetic */ SplitCompat f53251b;

    C18545o(SplitCompat splitCompat, Set set) {
        this.f53251b = splitCompat;
        this.f53250a = set;
    }

    public final void run() {
        try {
            for (String f : this.f53250a) {
                this.f53251b.f53224b.mo149229f(f);
            }
        } catch (Exception e) {
            SystemUtils.log(6, "SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e, "com.google.android.play.core.splitcompat.o", -1);
        }
    }
}

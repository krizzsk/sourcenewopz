package com.didi.beatles.p099im.views.widget.photoview;

import android.os.Build;
import android.view.View;

/* renamed from: com.didi.beatles.im.views.widget.photoview.a */
/* compiled from: Compat */
class C4407a {

    /* renamed from: a */
    private static final int f10651a = 16;

    C4407a() {
    }

    /* renamed from: a */
    public static void m7261a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            m7262b(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    /* renamed from: b */
    private static void m7262b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}

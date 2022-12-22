package com.didi.nova.assembly.components.bigimage.photoview;

import android.os.Build;
import android.view.View;

/* renamed from: com.didi.nova.assembly.components.bigimage.photoview.a */
/* compiled from: Compat */
class C10260a {

    /* renamed from: a */
    private static final int f29138a = 16;

    C10260a() {
    }

    /* renamed from: a */
    public static void m20551a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            m20552b(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    /* renamed from: b */
    private static void m20552b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}

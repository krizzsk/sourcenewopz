package com.didi.component.business.accessibility;

import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: com.didi.component.business.accessibility.a */
/* compiled from: FocusedAccessibilityTask */
class C4610a implements Runnable {

    /* renamed from: a */
    private WeakReference<View> f11166a;

    public C4610a(View view) {
        this.f11166a = new WeakReference<>(view);
    }

    public void run() {
        View view = (View) this.f11166a.get();
        if (view != null) {
            view.setFocusable(true);
            view.sendAccessibilityEvent(128);
        }
    }
}

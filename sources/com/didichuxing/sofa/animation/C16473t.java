package com.didichuxing.sofa.animation;

import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: com.didichuxing.sofa.animation.t */
/* compiled from: RunnableWrapper */
class C16473t {

    /* renamed from: a */
    private WeakReference<View> f49130a;

    /* renamed from: b */
    private Runnable f49131b;

    C16473t(View view, Runnable runnable) {
        WeakReference<View> weakReference;
        if (view == null) {
            weakReference = null;
        } else {
            weakReference = new WeakReference<>(view);
        }
        this.f49130a = weakReference;
        this.f49131b = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo121140a() {
        WeakReference<View> weakReference = this.f49130a;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Runnable mo121141b() {
        return this.f49131b;
    }
}

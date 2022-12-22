package com.didi.soda.cart;

import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;

public class SecurityHandlerHelper {

    /* renamed from: a */
    private AtomicReference<InnerRunable> f39892a = new AtomicReference<>();

    public void post(Runnable runnable) {
        clear();
        UiHandlerUtil.post(m28450a(runnable));
    }

    public void postDelayed(Runnable runnable, long j) {
        clear();
        UiHandlerUtil.postDelayed(m28450a(runnable), j);
    }

    public void clear() {
        m28451a();
        if (this.f39892a.get() != null) {
            this.f39892a.get().clear();
            this.f39892a.set((Object) null);
        }
    }

    /* renamed from: a */
    private void m28451a() {
        UiHandlerUtil.removeCallbacks(this.f39892a.get());
    }

    /* renamed from: a */
    private Runnable m28450a(Runnable runnable) {
        InnerRunable innerRunable;
        do {
            InnerRunable innerRunable2 = this.f39892a.get();
            if (innerRunable2 != null) {
                return innerRunable2;
            }
            innerRunable = new InnerRunable(runnable);
        } while (!this.f39892a.compareAndSet((Object) null, innerRunable));
        return innerRunable;
    }

    public static class InnerRunable implements Runnable {
        private WeakReference<Runnable> mWeakReference;

        public InnerRunable(Runnable runnable) {
            this.mWeakReference = new WeakReference<>(runnable);
        }

        public void clear() {
            WeakReference<Runnable> weakReference = this.mWeakReference;
            if (weakReference != null) {
                weakReference.clear();
            }
        }

        public void run() {
            if (this.mWeakReference.get() != null) {
                ((Runnable) this.mWeakReference.get()).run();
            }
            clear();
        }
    }
}

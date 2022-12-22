package com.didi.zxing.barcodescanner.camera;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.didi.zxing.barcodescanner.camera.a */
/* compiled from: CameraThread */
class C14946a {

    /* renamed from: a */
    private static final String f45392a = "CameraThread";

    /* renamed from: b */
    private static C14946a f45393b;

    /* renamed from: c */
    private Handler f45394c;

    /* renamed from: d */
    private HandlerThread f45395d;

    /* renamed from: e */
    private int f45396e = 0;

    /* renamed from: f */
    private final Object f45397f = new Object();

    /* renamed from: a */
    public static C14946a m32580a() {
        if (f45393b == null) {
            f45393b = new C14946a();
        }
        return f45393b;
    }

    private C14946a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo113752a(Runnable runnable) {
        synchronized (this.f45397f) {
            m32581c();
            this.f45394c.post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo113753a(Runnable runnable, long j) {
        synchronized (this.f45397f) {
            m32581c();
            this.f45394c.postDelayed(runnable, j);
        }
    }

    /* renamed from: c */
    private void m32581c() {
        synchronized (this.f45397f) {
            if (this.f45394c == null) {
                if (this.f45396e > 0) {
                    HandlerThread handlerThread = new HandlerThread(f45392a);
                    this.f45395d = handlerThread;
                    handlerThread.start();
                    this.f45394c = new Handler(this.f45395d.getLooper());
                } else {
                    throw new IllegalStateException("CameraThread is not open");
                }
            }
        }
    }

    /* renamed from: d */
    private void m32582d() {
        synchronized (this.f45397f) {
            this.f45395d.quit();
            this.f45395d = null;
            this.f45394c = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo113754b() {
        synchronized (this.f45397f) {
            int i = this.f45396e - 1;
            this.f45396e = i;
            if (i == 0) {
                m32582d();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo113755b(Runnable runnable) {
        synchronized (this.f45397f) {
            this.f45396e++;
            mo113752a(runnable);
        }
    }
}

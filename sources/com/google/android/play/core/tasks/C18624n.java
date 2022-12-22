package com.google.android.play.core.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.play.core.tasks.n */
final class C18624n implements OnFailureListener, OnSuccessListener {

    /* renamed from: a */
    private final CountDownLatch f53440a = new CountDownLatch(1);

    private C18624n() {
    }

    /* synthetic */ C18624n(byte[] bArr) {
    }

    /* renamed from: a */
    public final void mo149349a() throws InterruptedException {
        this.f53440a.await();
    }

    /* renamed from: a */
    public final boolean mo149350a(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f53440a.await(j, timeUnit);
    }

    public final void onFailure(Exception exc) {
        this.f53440a.countDown();
    }

    public final void onSuccess(Object obj) {
        this.f53440a.countDown();
    }
}

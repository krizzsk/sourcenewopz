package didihttp.internal.http2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: didihttp.internal.http2.b */
/* compiled from: Ping */
final class C20773b {

    /* renamed from: a */
    private final CountDownLatch f56844a = new CountDownLatch(1);

    /* renamed from: b */
    private long f56845b = -1;

    /* renamed from: c */
    private long f56846c = -1;

    C20773b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170207a() {
        if (this.f56845b == -1) {
            this.f56845b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo170208b() {
        if (this.f56846c != -1 || this.f56845b == -1) {
            throw new IllegalStateException();
        }
        this.f56846c = System.nanoTime();
        this.f56844a.countDown();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo170209c() {
        if (this.f56846c == -1) {
            long j = this.f56845b;
            if (j != -1) {
                this.f56846c = j - 1;
                this.f56844a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: d */
    public long mo170210d() throws InterruptedException {
        this.f56844a.await();
        return this.f56846c - this.f56845b;
    }

    /* renamed from: a */
    public long mo170206a(long j, TimeUnit timeUnit) throws InterruptedException {
        if (this.f56844a.await(j, timeUnit)) {
            return this.f56846c - this.f56845b;
        }
        return -2;
    }
}

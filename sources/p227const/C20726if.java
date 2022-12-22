package p227const;

import p093switch.C3122goto;

/* renamed from: const.if */
/* compiled from: FPSMeter */
public class C20726if {

    /* renamed from: a */
    private final C3122goto f56300a = new C3122goto(10);

    /* renamed from: b */
    private long f56301b = -1;

    /* renamed from: c */
    private volatile long f56302c = -1;

    /* renamed from: d */
    private long f56303d = 0;

    /* renamed from: do */
    public float mo169173do() {
        return 1.0f / this.f56300a.mo38623do();
    }

    /* renamed from: for  reason: not valid java name */
    public synchronized void m47606for() {
        if (!mo169175if()) {
            long nanoTime = System.nanoTime();
            long j = this.f56301b;
            if (j != -1) {
                this.f56300a.mo38624do(((double) ((nanoTime - j) - this.f56303d)) / 1.0E9d);
            }
            this.f56301b = nanoTime;
            this.f56303d = 0;
        }
    }

    /* renamed from: if */
    public boolean mo169175if() {
        return this.f56302c != -1;
    }

    /* renamed from: new  reason: not valid java name */
    public synchronized void m47607new() {
        if (!mo169175if()) {
            this.f56302c = System.nanoTime();
        }
    }

    /* renamed from: try  reason: not valid java name */
    public synchronized void m47608try() {
        if (mo169175if()) {
            this.f56303d = System.nanoTime() - this.f56302c;
            this.f56302c = -1;
        }
    }
}

package bolts;

import java.io.Closeable;

public class CancellationTokenRegistration implements Closeable {

    /* renamed from: a */
    private final Object f403a = new Object();

    /* renamed from: b */
    private CancellationTokenSource f404b;

    /* renamed from: c */
    private Runnable f405c;

    /* renamed from: d */
    private boolean f406d;

    CancellationTokenRegistration(CancellationTokenSource cancellationTokenSource, Runnable runnable) {
        this.f404b = cancellationTokenSource;
        this.f405c = runnable;
    }

    public void close() {
        synchronized (this.f403a) {
            if (!this.f406d) {
                this.f406d = true;
                this.f404b.mo14013a(this);
                this.f404b = null;
                this.f405c = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14009a() {
        synchronized (this.f403a) {
            m923b();
            this.f405c.run();
            close();
        }
    }

    /* renamed from: b */
    private void m923b() {
        if (this.f406d) {
            throw new IllegalStateException("Object already closed");
        }
    }
}

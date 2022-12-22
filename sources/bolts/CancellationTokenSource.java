package bolts;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CancellationTokenSource implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Object f407a = new Object();

    /* renamed from: b */
    private final List<CancellationTokenRegistration> f408b = new ArrayList();

    /* renamed from: c */
    private final ScheduledExecutorService f409c = BoltsExecutors.m920b();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ScheduledFuture<?> f410d;

    /* renamed from: e */
    private boolean f411e;

    /* renamed from: f */
    private boolean f412f;

    public boolean isCancellationRequested() {
        boolean z;
        synchronized (this.f407a) {
            m929b();
            z = this.f411e;
        }
        return z;
    }

    public CancellationToken getToken() {
        CancellationToken cancellationToken;
        synchronized (this.f407a) {
            m929b();
            cancellationToken = new CancellationToken(this);
        }
        return cancellationToken;
    }

    public void cancel() {
        synchronized (this.f407a) {
            m929b();
            if (!this.f411e) {
                m930c();
                this.f411e = true;
                ArrayList arrayList = new ArrayList(this.f408b);
                m928a((List<CancellationTokenRegistration>) arrayList);
            }
        }
    }

    public void cancelAfter(long j) {
        m927a(j, TimeUnit.MILLISECONDS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m927a(long r5, java.util.concurrent.TimeUnit r7) {
        /*
            r4 = this;
            r0 = -1
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0030
            r0 = 0
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x0010
            r4.cancel()
            return
        L_0x0010:
            java.lang.Object r0 = r4.f407a
            monitor-enter(r0)
            boolean r1 = r4.f411e     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x0019:
            r4.m930c()     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.util.concurrent.ScheduledExecutorService r1 = r4.f409c     // Catch:{ all -> 0x002d }
            bolts.CancellationTokenSource$1 r2 = new bolts.CancellationTokenSource$1     // Catch:{ all -> 0x002d }
            r2.<init>()     // Catch:{ all -> 0x002d }
            java.util.concurrent.ScheduledFuture r5 = r1.schedule(r2, r5, r7)     // Catch:{ all -> 0x002d }
            r4.f410d = r5     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r5
        L_0x0030:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Delay must be >= -1"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bolts.CancellationTokenSource.m927a(long, java.util.concurrent.TimeUnit):void");
    }

    public void close() {
        synchronized (this.f407a) {
            if (!this.f412f) {
                m930c();
                for (CancellationTokenRegistration close : this.f408b) {
                    close.close();
                }
                this.f408b.clear();
                this.f412f = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CancellationTokenRegistration mo14011a(Runnable runnable) {
        CancellationTokenRegistration cancellationTokenRegistration;
        synchronized (this.f407a) {
            m929b();
            cancellationTokenRegistration = new CancellationTokenRegistration(this, runnable);
            if (this.f411e) {
                cancellationTokenRegistration.mo14009a();
            } else {
                this.f408b.add(cancellationTokenRegistration);
            }
        }
        return cancellationTokenRegistration;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14012a() throws CancellationException {
        synchronized (this.f407a) {
            m929b();
            if (this.f411e) {
                throw new CancellationException();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14013a(CancellationTokenRegistration cancellationTokenRegistration) {
        synchronized (this.f407a) {
            m929b();
            this.f408b.remove(cancellationTokenRegistration);
        }
    }

    /* renamed from: a */
    private void m928a(List<CancellationTokenRegistration> list) {
        for (CancellationTokenRegistration a : list) {
            a.mo14009a();
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested())});
    }

    /* renamed from: b */
    private void m929b() {
        if (this.f412f) {
            throw new IllegalStateException("Object already closed");
        }
    }

    /* renamed from: c */
    private void m930c() {
        ScheduledFuture<?> scheduledFuture = this.f410d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f410d = null;
        }
    }
}

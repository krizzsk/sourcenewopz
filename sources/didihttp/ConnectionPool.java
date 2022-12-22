package didihttp;

import didihttp.internal.C20747Util;
import didihttp.internal.connection.RealConnection;
import didihttp.internal.connection.RouteDatabase;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.platform.Platform;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool {

    /* renamed from: c */
    static final /* synthetic */ boolean f56348c = (!ConnectionPool.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final Executor f56349d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C20747Util.threadFactory("OkHttp ConnectionPool", true));

    /* renamed from: a */
    final RouteDatabase f56350a;

    /* renamed from: b */
    boolean f56351b;

    /* renamed from: e */
    private final int f56352e;

    /* renamed from: f */
    private final long f56353f;

    /* renamed from: g */
    private final Runnable f56354g;

    /* renamed from: h */
    private final Deque<RealConnection> f56355h;

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.f56354g = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                L_0x0000:
                    didihttp.ConnectionPool r0 = didihttp.ConnectionPool.this
                    long r1 = java.lang.System.nanoTime()
                    long r0 = r0.mo169424a((long) r1)
                    r2 = -1
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 != 0) goto L_0x0011
                    return
                L_0x0011:
                    r2 = 0
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 <= 0) goto L_0x0000
                    r2 = 1000000(0xf4240, double:4.940656E-318)
                    long r4 = r0 / r2
                    long r2 = r2 * r4
                    long r0 = r0 - r2
                    didihttp.ConnectionPool r2 = didihttp.ConnectionPool.this
                    monitor-enter(r2)
                    didihttp.ConnectionPool r3 = didihttp.ConnectionPool.this     // Catch:{ InterruptedException -> 0x002b }
                    int r1 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
                    r3.wait(r4, r1)     // Catch:{ InterruptedException -> 0x002b }
                    goto L_0x002b
                L_0x0029:
                    r0 = move-exception
                    goto L_0x002d
                L_0x002b:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    goto L_0x0000
                L_0x002d:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: didihttp.ConnectionPool.C207341.run():void");
            }
        };
        this.f56355h = new ArrayDeque();
        this.f56350a = new RouteDatabase();
        this.f56352e = i;
        this.f56353f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    public synchronized int idleConnectionCount() {
        int i;
        i = 0;
        for (RealConnection realConnection : this.f56355h) {
            if (realConnection.allocations.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    public synchronized int connectionCount() {
        return this.f56355h.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public RealConnection mo169425a(Address address, StreamAllocation streamAllocation) {
        if (f56348c || Thread.holdsLock(this)) {
            for (RealConnection next : this.f56355h) {
                if (next.isEligible(address)) {
                    streamAllocation.acquire(next);
                    return next;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Socket mo169427b(Address address, StreamAllocation streamAllocation) {
        if (f56348c || Thread.holdsLock(this)) {
            for (RealConnection next : this.f56355h) {
                if (next.isEligible(address) && next.isMultiplexed() && next != streamAllocation.connection()) {
                    return streamAllocation.releaseAndAcquire(next);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo169426a(RealConnection realConnection) {
        if (f56348c || Thread.holdsLock(this)) {
            if (!this.f56351b) {
                this.f56351b = true;
                f56349d.execute(this.f56354g);
            }
            this.f56355h.add(realConnection);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo169428b(RealConnection realConnection) {
        if (!f56348c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (realConnection.noNewStreams || this.f56352e == 0) {
            this.f56355h.remove(realConnection);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    public void evictAll() {
        ArrayList<RealConnection> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator<RealConnection> it = this.f56355h.iterator();
            while (it.hasNext()) {
                RealConnection next = it.next();
                if (next.allocations.isEmpty()) {
                    next.noNewStreams = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        for (RealConnection socket : arrayList) {
            C20747Util.closeQuietly(socket.socket());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo169424a(long j) {
        synchronized (this) {
            RealConnection realConnection = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (RealConnection next : this.f56355h) {
                if (m40566a(next, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - next.idleAtNanos;
                    if (j3 > j2) {
                        realConnection = next;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f56353f) {
                if (i <= this.f56352e) {
                    if (i > 0) {
                        long j4 = this.f56353f - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.f56353f;
                        return j5;
                    } else {
                        this.f56351b = false;
                        return -1;
                    }
                }
            }
            this.f56355h.remove(realConnection);
            C20747Util.closeQuietly(realConnection.socket());
            return 0;
        }
    }

    /* renamed from: a */
    private int m40566a(RealConnection realConnection, long j) {
        List<Reference<StreamAllocation>> list = realConnection.allocations;
        int i = 0;
        while (i < list.size()) {
            Reference reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).callStackTrace);
                list.remove(i);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j - this.f56353f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}

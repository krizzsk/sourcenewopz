package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.C2434Util;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpCodec;

public final class StreamAllocation {

    /* renamed from: a */
    static final /* synthetic */ boolean f5339a = (!StreamAllocation.class.desiredAssertionStatus());
    public final Address address;

    /* renamed from: b */
    private RouteSelector.Selection f5340b;

    /* renamed from: c */
    private Route f5341c;
    public final Call call;

    /* renamed from: d */
    private final ConnectionPool f5342d;

    /* renamed from: e */
    private final Object f5343e;
    public final EventListener eventListener;

    /* renamed from: f */
    private final RouteSelector f5344f;

    /* renamed from: g */
    private int f5345g;

    /* renamed from: h */
    private RealConnection f5346h;

    /* renamed from: i */
    private boolean f5347i;

    /* renamed from: j */
    private boolean f5348j;

    /* renamed from: k */
    private boolean f5349k;

    /* renamed from: l */
    private HttpCodec f5350l;

    public StreamAllocation(ConnectionPool connectionPool, Address address2, Call call2, EventListener eventListener2, Object obj) {
        this.f5342d = connectionPool;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.f5344f = new RouteSelector(address2, m3430b(), call2, eventListener2);
        this.f5343e = obj;
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            HttpCodec newCodec = m3428a(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain, this);
            synchronized (this.f5342d) {
                this.f5350l = newCodec;
            }
            return newCodec;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.isHealthy(r9) != false) goto L_0x0018;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.RealConnection m3428a(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.RealConnection r0 = r3.m3427a(r4, r5, r6, r7, r8)
            okhttp3.ConnectionPool r1 = r3.f5342d
            monitor-enter(r1)
            int r2 = r0.successCount     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.isHealthy(r9)
            if (r1 != 0) goto L_0x0018
            r3.noNewStreams()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.m3428a(int, int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    /* renamed from: a */
    private RealConnection m3427a(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket a;
        Socket socket;
        RealConnection realConnection;
        RealConnection realConnection2;
        boolean z2;
        Route route;
        boolean z3;
        RouteSelector.Selection selection;
        synchronized (this.f5342d) {
            if (this.f5348j) {
                throw new IllegalStateException("released");
            } else if (this.f5350l != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.f5349k) {
                RealConnection realConnection3 = this.f5346h;
                a = m3425a();
                socket = null;
                if (this.f5346h != null) {
                    realConnection2 = this.f5346h;
                    realConnection = null;
                } else {
                    realConnection = realConnection3;
                    realConnection2 = null;
                }
                if (!this.f5347i) {
                    realConnection = null;
                }
                if (realConnection2 == null) {
                    Internal.instance.get(this.f5342d, this.address, this, (Route) null);
                    if (this.f5346h != null) {
                        realConnection2 = this.f5346h;
                        route = null;
                        z2 = true;
                    } else {
                        route = this.f5341c;
                    }
                } else {
                    route = null;
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        C2434Util.closeQuietly(a);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (route != null || ((selection = this.f5340b) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.f5340b = this.f5344f.next();
            z3 = true;
        }
        synchronized (this.f5342d) {
            if (!this.f5349k) {
                if (z3) {
                    List<Route> all = this.f5340b.getAll();
                    int size = all.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        Route route2 = all.get(i5);
                        Internal.instance.get(this.f5342d, this.address, this, route2);
                        if (this.f5346h != null) {
                            realConnection2 = this.f5346h;
                            this.f5341c = route2;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (route == null) {
                        route = this.f5340b.next();
                    }
                    this.f5341c = route;
                    this.f5345g = 0;
                    realConnection2 = new RealConnection(this.f5342d, route);
                    acquire(realConnection2, false);
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
            return realConnection2;
        }
        realConnection2.connect(i, i2, i3, i4, z, this.call, this.eventListener);
        m3430b().connected(realConnection2.route());
        synchronized (this.f5342d) {
            this.f5347i = true;
            Internal.instance.put(this.f5342d, realConnection2);
            if (realConnection2.isMultiplexed()) {
                socket = Internal.instance.deduplicate(this.f5342d, this.address, this);
                realConnection2 = this.f5346h;
            }
        }
        C2434Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, realConnection2);
        return realConnection2;
    }

    /* renamed from: a */
    private Socket m3425a() {
        if (f5339a || Thread.holdsLock(this.f5342d)) {
            RealConnection realConnection = this.f5346h;
            if (realConnection == null || !realConnection.noNewStreams) {
                return null;
            }
            return m3426a(false, false, true);
        }
        throw new AssertionError();
    }

    public void streamFinished(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket a;
        boolean z2;
        this.eventListener.responseBodyEnd(this.call, j);
        synchronized (this.f5342d) {
            if (httpCodec != null) {
                if (httpCodec == this.f5350l) {
                    if (!z) {
                        this.f5346h.successCount++;
                    }
                    realConnection = this.f5346h;
                    a = m3426a(z, false, true);
                    if (this.f5346h != null) {
                        realConnection = null;
                    }
                    z2 = this.f5348j;
                }
            }
            throw new IllegalStateException("expected " + this.f5350l + " but was " + httpCodec);
        }
        C2434Util.closeQuietly(a);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, iOException));
        } else if (z2) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.callEnd(this.call);
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.f5342d) {
            httpCodec = this.f5350l;
        }
        return httpCodec;
    }

    /* renamed from: b */
    private RouteDatabase m3430b() {
        return Internal.instance.routeDatabase(this.f5342d);
    }

    public Route route() {
        return this.f5341c;
    }

    public synchronized RealConnection connection() {
        return this.f5346h;
    }

    public void release() {
        RealConnection realConnection;
        Socket a;
        synchronized (this.f5342d) {
            realConnection = this.f5346h;
            a = m3426a(false, true, false);
            if (this.f5346h != null) {
                realConnection = null;
            }
        }
        C2434Util.closeQuietly(a);
        if (realConnection != null) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket a;
        synchronized (this.f5342d) {
            realConnection = this.f5346h;
            a = m3426a(true, false, false);
            if (this.f5346h != null) {
                realConnection = null;
            }
        }
        C2434Util.closeQuietly(a);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    /* renamed from: a */
    private Socket m3426a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (f5339a || Thread.holdsLock(this.f5342d)) {
            if (z3) {
                this.f5350l = null;
            }
            if (z2) {
                this.f5348j = true;
            }
            RealConnection realConnection = this.f5346h;
            if (realConnection == null) {
                return null;
            }
            if (z) {
                realConnection.noNewStreams = true;
            }
            if (this.f5350l != null) {
                return null;
            }
            if (!this.f5348j && !this.f5346h.noNewStreams) {
                return null;
            }
            m3429a(this.f5346h);
            if (this.f5346h.allocations.isEmpty()) {
                this.f5346h.idleAtNanos = System.nanoTime();
                if (Internal.instance.connectionBecameIdle(this.f5342d, this.f5346h)) {
                    socket = this.f5346h.socket();
                    this.f5346h = null;
                    return socket;
                }
            }
            socket = null;
            this.f5346h = null;
            return socket;
        }
        throw new AssertionError();
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.f5342d) {
            this.f5349k = true;
            httpCodec = this.f5350l;
            realConnection = this.f5346h;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void streamFailed(java.io.IOException r7) {
        /*
            r6 = this;
            okhttp3.ConnectionPool r0 = r6.f5342d
            monitor-enter(r0)
            boolean r1 = r7 instanceof okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x0069 }
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            okhttp3.internal.http2.StreamResetException r7 = (okhttp3.internal.http2.StreamResetException) r7     // Catch:{ all -> 0x0069 }
            okhttp3.internal.http2.ErrorCode r7 = r7.errorCode     // Catch:{ all -> 0x0069 }
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0069 }
            if (r7 != r1) goto L_0x001c
            int r7 = r6.f5345g     // Catch:{ all -> 0x0069 }
            int r7 = r7 + r4
            r6.f5345g = r7     // Catch:{ all -> 0x0069 }
            if (r7 <= r4) goto L_0x004a
            r6.f5341c = r3     // Catch:{ all -> 0x0069 }
            goto L_0x0048
        L_0x001c:
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ all -> 0x0069 }
            if (r7 == r1) goto L_0x004a
            r6.f5341c = r3     // Catch:{ all -> 0x0069 }
            goto L_0x0048
        L_0x0023:
            okhttp3.internal.connection.RealConnection r1 = r6.f5346h     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x004a
            okhttp3.internal.connection.RealConnection r1 = r6.f5346h     // Catch:{ all -> 0x0069 }
            boolean r1 = r1.isMultiplexed()     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0033
            boolean r1 = r7 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x004a
        L_0x0033:
            okhttp3.internal.connection.RealConnection r1 = r6.f5346h     // Catch:{ all -> 0x0069 }
            int r1 = r1.successCount     // Catch:{ all -> 0x0069 }
            if (r1 != 0) goto L_0x0048
            okhttp3.Route r1 = r6.f5341c     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0046
            if (r7 == 0) goto L_0x0046
            okhttp3.internal.connection.RouteSelector r1 = r6.f5344f     // Catch:{ all -> 0x0069 }
            okhttp3.Route r5 = r6.f5341c     // Catch:{ all -> 0x0069 }
            r1.connectFailed(r5, r7)     // Catch:{ all -> 0x0069 }
        L_0x0046:
            r6.f5341c = r3     // Catch:{ all -> 0x0069 }
        L_0x0048:
            r7 = 1
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            okhttp3.internal.connection.RealConnection r1 = r6.f5346h     // Catch:{ all -> 0x0069 }
            java.net.Socket r7 = r6.m3426a(r7, r2, r4)     // Catch:{ all -> 0x0069 }
            okhttp3.internal.connection.RealConnection r2 = r6.f5346h     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x005b
            boolean r2 = r6.f5347i     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r3 = r1
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            okhttp3.internal.C2434Util.closeQuietly((java.net.Socket) r7)
            if (r3 == 0) goto L_0x0068
            okhttp3.EventListener r7 = r6.eventListener
            okhttp3.Call r0 = r6.call
            r7.connectionReleased(r0, r3)
        L_0x0068:
            return
        L_0x0069:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.streamFailed(java.io.IOException):void");
    }

    public void acquire(RealConnection realConnection, boolean z) {
        if (!f5339a && !Thread.holdsLock(this.f5342d)) {
            throw new AssertionError();
        } else if (this.f5346h == null) {
            this.f5346h = realConnection;
            this.f5347i = z;
            realConnection.allocations.add(new StreamAllocationReference(this, this.f5343e));
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private void m3429a(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.allocations.get(i).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (!f5339a && !Thread.holdsLock(this.f5342d)) {
            throw new AssertionError();
        } else if (this.f5350l == null && this.f5346h.allocations.size() == 1) {
            Socket a = m3426a(true, false, false);
            this.f5346h = realConnection;
            realConnection.allocations.add(this.f5346h.allocations.get(0));
            return a;
        } else {
            throw new IllegalStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f5340b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasMoreRoutes() {
        /*
            r1 = this;
            okhttp3.Route r0 = r1.f5341c
            if (r0 != 0) goto L_0x0019
            okhttp3.internal.connection.RouteSelector$Selection r0 = r1.f5340b
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x0019
        L_0x000e:
            okhttp3.internal.connection.RouteSelector r0 = r1.f5344f
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.hasMoreRoutes():boolean");
    }

    public String toString() {
        RealConnection connection = connection();
        return connection != null ? connection.toString() : this.address.toString();
    }

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }
}

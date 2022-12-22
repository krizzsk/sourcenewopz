package com.koushikdutta.async;

import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.ListenCallback;
import com.koushikdutta.async.callback.SocketCreateCallback;
import com.koushikdutta.async.callback.ValueFunction;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.util.StreamUtility;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AsyncServer {
    public static final String LOGTAG = "NIO";

    /* renamed from: a */
    static AsyncServer f55179a = new AsyncServer();

    /* renamed from: g */
    static final /* synthetic */ boolean f55180g = (!AsyncServer.class.desiredAssertionStatus());

    /* renamed from: i */
    private static ExecutorService f55181i = m39706a("AsyncServer-worker-");
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Comparator<InetAddress> f55182j = new Comparator<InetAddress>() {
        public int compare(InetAddress inetAddress, InetAddress inetAddress2) {
            boolean z = inetAddress instanceof Inet4Address;
            if (z && (inetAddress2 instanceof Inet4Address)) {
                return 0;
            }
            if (!(inetAddress instanceof Inet6Address) || !(inetAddress2 instanceof Inet6Address)) {
                return (!z || !(inetAddress2 instanceof Inet6Address)) ? 1 : -1;
            }
            return 0;
        }
    };

    /* renamed from: k */
    private static ExecutorService f55183k = m39706a("AsyncServer-resolver-");
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final ThreadLocal<AsyncServer> f55184l = new ThreadLocal<>();

    /* renamed from: m */
    private static final long f55185m = Long.MAX_VALUE;

    /* renamed from: b */
    String f55186b;

    /* renamed from: c */
    boolean f55187c;

    /* renamed from: d */
    int f55188d;

    /* renamed from: e */
    PriorityQueue<Scheduled> f55189e;

    /* renamed from: f */
    Thread f55190f;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C20148c f55191h;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ InetAddress m39703a(InetAddress inetAddress) throws Exception {
        return inetAddress;
    }

    /* access modifiers changed from: protected */
    public void onDataReceived(int i) {
    }

    /* access modifiers changed from: protected */
    public void onDataSent(int i) {
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 8) {
                System.setProperty("java.net.preferIPv4Stack", "true");
                System.setProperty("java.net.preferIPv6Addresses", SDKConsts.BOOLEAN_FALSE);
            }
        } catch (Throwable unused) {
        }
    }

    private static class RunnableWrapper implements Runnable {
        Handler handler;
        boolean hasRun;
        Runnable runnable;
        ThreadQueue threadQueue;

        private RunnableWrapper() {
        }

        public void run() {
            synchronized (this) {
                if (!this.hasRun) {
                    this.hasRun = true;
                    try {
                        this.runnable.run();
                    } finally {
                        this.threadQueue.remove(this);
                        this.handler.removeCallbacks(this);
                        this.threadQueue = null;
                        this.handler = null;
                        this.runnable = null;
                    }
                }
            }
        }
    }

    public static void post(Handler handler, Runnable runnable) {
        RunnableWrapper runnableWrapper = new RunnableWrapper();
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(handler.getLooper().getThread());
        runnableWrapper.threadQueue = orCreateThreadQueue;
        runnableWrapper.handler = handler;
        runnableWrapper.runnable = runnable;
        orCreateThreadQueue.add((Runnable) runnableWrapper);
        handler.post(runnableWrapper);
        orCreateThreadQueue.queueSemaphore.release();
    }

    public static AsyncServer getDefault() {
        return f55179a;
    }

    public boolean isRunning() {
        return this.f55191h != null;
    }

    public AsyncServer() {
        this((String) null);
    }

    public AsyncServer(String str) {
        this.f55188d = 0;
        this.f55189e = new PriorityQueue<>(1, Scheduler.INSTANCE);
        this.f55186b = str == null ? "AsyncServer" : str;
    }

    /* renamed from: b */
    private static void m39719b(C20148c cVar) {
        f55181i.execute(new Runnable() {
            public final void run() {
                AsyncServer.m39725f(C20148c.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ void m39725f(C20148c cVar) {
        try {
            cVar.mo163916g();
        } catch (Exception unused) {
        }
    }

    public void kill() {
        synchronized (this) {
            this.f55187c = true;
        }
        stop(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.koushikdutta.async.future.Cancellable postDelayed(java.lang.Runnable r5, long r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.f55187c     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0009
            com.koushikdutta.async.future.Cancellable r5 = com.koushikdutta.async.future.SimpleCancellable.CANCELLED     // Catch:{ all -> 0x0056 }
            monitor-exit(r4)     // Catch:{ all -> 0x0056 }
            return r5
        L_0x0009:
            r0 = 0
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0015
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0056 }
            long r0 = r0 + r6
            goto L_0x0038
        L_0x0015:
            if (r2 != 0) goto L_0x001f
            int r6 = r4.f55188d     // Catch:{ all -> 0x0056 }
            int r7 = r6 + 1
            r4.f55188d = r7     // Catch:{ all -> 0x0056 }
            long r0 = (long) r6     // Catch:{ all -> 0x0056 }
            goto L_0x0038
        L_0x001f:
            java.util.PriorityQueue<com.koushikdutta.async.AsyncServer$Scheduled> r6 = r4.f55189e     // Catch:{ all -> 0x0056 }
            int r6 = r6.size()     // Catch:{ all -> 0x0056 }
            if (r6 <= 0) goto L_0x0038
            java.util.PriorityQueue<com.koushikdutta.async.AsyncServer$Scheduled> r6 = r4.f55189e     // Catch:{ all -> 0x0056 }
            java.lang.Object r6 = r6.peek()     // Catch:{ all -> 0x0056 }
            com.koushikdutta.async.AsyncServer$Scheduled r6 = (com.koushikdutta.async.AsyncServer.Scheduled) r6     // Catch:{ all -> 0x0056 }
            long r6 = r6.time     // Catch:{ all -> 0x0056 }
            r2 = 1
            long r6 = r6 - r2
            long r0 = java.lang.Math.min(r0, r6)     // Catch:{ all -> 0x0056 }
        L_0x0038:
            java.util.PriorityQueue<com.koushikdutta.async.AsyncServer$Scheduled> r6 = r4.f55189e     // Catch:{ all -> 0x0056 }
            com.koushikdutta.async.AsyncServer$Scheduled r7 = new com.koushikdutta.async.AsyncServer$Scheduled     // Catch:{ all -> 0x0056 }
            r7.<init>(r4, r5, r0)     // Catch:{ all -> 0x0056 }
            r6.add(r7)     // Catch:{ all -> 0x0056 }
            com.koushikdutta.async.c r5 = r4.f55191h     // Catch:{ all -> 0x0056 }
            if (r5 != 0) goto L_0x0049
            r4.m39720c()     // Catch:{ all -> 0x0056 }
        L_0x0049:
            boolean r5 = r4.isAffinityThread()     // Catch:{ all -> 0x0056 }
            if (r5 != 0) goto L_0x0054
            com.koushikdutta.async.c r5 = r4.f55191h     // Catch:{ all -> 0x0056 }
            m39719b((com.koushikdutta.async.C20148c) r5)     // Catch:{ all -> 0x0056 }
        L_0x0054:
            monitor-exit(r4)     // Catch:{ all -> 0x0056 }
            return r7
        L_0x0056:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0056 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.AsyncServer.postDelayed(java.lang.Runnable, long):com.koushikdutta.async.future.Cancellable");
    }

    public Cancellable postImmediate(Runnable runnable) {
        if (Thread.currentThread() != getAffinity()) {
            return postDelayed(runnable, -1);
        }
        runnable.run();
        return null;
    }

    public Cancellable post(Runnable runnable) {
        return postDelayed(runnable, 0);
    }

    public Cancellable post(CompletedCallback completedCallback, Exception exc) {
        return post(new Runnable(exc) {
            public final /* synthetic */ Exception f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                CompletedCallback.this.onCompleted(this.f$1);
            }
        });
    }

    public void run(Runnable runnable) {
        if (Thread.currentThread() == this.f55190f) {
            post(runnable);
            m39700a(this, this.f55189e);
            return;
        }
        synchronized (this) {
            if (!this.f55187c) {
                Semaphore semaphore = new Semaphore(0);
                post(new Runnable(runnable, semaphore) {
                    public final /* synthetic */ Runnable f$0;
                    public final /* synthetic */ Semaphore f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void run() {
                        AsyncServer.m39715a(this.f$0, this.f$1);
                    }
                });
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    SystemUtils.log(6, LOGTAG, "run", e, "com.koushikdutta.async.AsyncServer", 214);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m39715a(Runnable runnable, Semaphore semaphore) {
        runnable.run();
        semaphore.release();
    }

    private static class Scheduled implements Cancellable, Runnable {
        boolean cancelled;
        public Runnable runnable;
        public AsyncServer server;
        public long time;

        public Scheduled(AsyncServer asyncServer, Runnable runnable2, long j) {
            this.server = asyncServer;
            this.runnable = runnable2;
            this.time = j;
        }

        public void run() {
            this.runnable.run();
        }

        public boolean isDone() {
            boolean z;
            synchronized (this.server) {
                z = !this.cancelled && !this.server.f55189e.contains(this);
            }
            return z;
        }

        public boolean isCancelled() {
            return this.cancelled;
        }

        public boolean cancel() {
            boolean remove;
            synchronized (this.server) {
                remove = this.server.f55189e.remove(this);
                this.cancelled = remove;
            }
            return remove;
        }
    }

    static class Scheduler implements Comparator<Scheduled> {
        public static Scheduler INSTANCE = new Scheduler();

        private Scheduler() {
        }

        public int compare(Scheduled scheduled, Scheduled scheduled2) {
            if (scheduled.time == scheduled2.time) {
                return 0;
            }
            return scheduled.time > scheduled2.time ? 1 : -1;
        }
    }

    public void stop() {
        stop(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2.acquire();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003f, code lost:
        if (r0 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        if (r9 == false) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stop(boolean r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.isAffinityThread()     // Catch:{ all -> 0x0047 }
            com.koushikdutta.async.c r1 = r8.f55191h     // Catch:{ all -> 0x0047 }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r8)     // Catch:{ all -> 0x0047 }
            return
        L_0x000b:
            java.util.concurrent.Semaphore r2 = new java.util.concurrent.Semaphore     // Catch:{ all -> 0x0047 }
            r3 = 0
            r2.<init>(r3)     // Catch:{ all -> 0x0047 }
            java.util.PriorityQueue<com.koushikdutta.async.AsyncServer$Scheduled> r3 = r8.f55189e     // Catch:{ all -> 0x0047 }
            com.koushikdutta.async.AsyncServer$Scheduled r4 = new com.koushikdutta.async.AsyncServer$Scheduled     // Catch:{ all -> 0x0047 }
            com.koushikdutta.async.AsyncServer$1 r5 = new com.koushikdutta.async.AsyncServer$1     // Catch:{ all -> 0x0047 }
            r5.<init>(r1, r2)     // Catch:{ all -> 0x0047 }
            r6 = 0
            r4.<init>(r8, r5, r6)     // Catch:{ all -> 0x0047 }
            r3.add(r4)     // Catch:{ all -> 0x0047 }
            java.util.concurrent.ExecutorService r3 = f55181i     // Catch:{ all -> 0x0047 }
            com.koushikdutta.async.-$$Lambda$AsyncServer$8yJXPNRymfs3mLZjfIRfkgqaSH0 r4 = new com.koushikdutta.async.-$$Lambda$AsyncServer$8yJXPNRymfs3mLZjfIRfkgqaSH0     // Catch:{ all -> 0x0047 }
            r4.<init>()     // Catch:{ all -> 0x0047 }
            r3.execute(r4)     // Catch:{ all -> 0x0047 }
            m39722c(r1)     // Catch:{ all -> 0x0047 }
            java.util.PriorityQueue r1 = new java.util.PriorityQueue     // Catch:{ all -> 0x0047 }
            r3 = 1
            com.koushikdutta.async.AsyncServer$Scheduler r4 = com.koushikdutta.async.AsyncServer.Scheduler.INSTANCE     // Catch:{ all -> 0x0047 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0047 }
            r8.f55189e = r1     // Catch:{ all -> 0x0047 }
            r1 = 0
            r8.f55191h = r1     // Catch:{ all -> 0x0047 }
            r8.f55190f = r1     // Catch:{ all -> 0x0047 }
            monitor-exit(r8)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0046
            if (r9 == 0) goto L_0x0046
            r2.acquire()     // Catch:{ Exception -> 0x0046 }
        L_0x0046:
            return
        L_0x0047:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0047 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.AsyncServer.stop(boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m39724e(C20148c cVar) {
        try {
            cVar.mo163916g();
        } catch (Exception unused) {
        }
    }

    private static class ObjectHolder<T> {
        T held;

        private ObjectHolder() {
        }
    }

    public AsyncServerSocket listen(InetAddress inetAddress, int i, ListenCallback listenCallback) {
        ObjectHolder objectHolder = new ObjectHolder();
        final InetAddress inetAddress2 = inetAddress;
        final int i2 = i;
        final ListenCallback listenCallback2 = listenCallback;
        final ObjectHolder objectHolder2 = objectHolder;
        run(new Runnable() {
            public void run() {
                ServerSocketChannel serverSocketChannel;
                C20149d dVar;
                IOException e;
                InetSocketAddress inetSocketAddress;
                try {
                    final ServerSocketChannel open = ServerSocketChannel.open();
                    try {
                        final C20149d dVar2 = new C20149d(open);
                        try {
                            if (inetAddress2 == null) {
                                inetSocketAddress = new InetSocketAddress(i2);
                            } else {
                                inetSocketAddress = new InetSocketAddress(inetAddress2, i2);
                            }
                            open.socket().bind(inetSocketAddress);
                            final SelectionKey a = dVar2.mo163892a(AsyncServer.this.f55191h.mo163908a());
                            a.attach(listenCallback2);
                            ListenCallback listenCallback = listenCallback2;
                            ObjectHolder objectHolder = objectHolder2;
                            T r5 = new AsyncServerSocket() {
                                public int getLocalPort() {
                                    return open.socket().getLocalPort();
                                }

                                public void stop() {
                                    StreamUtility.closeQuietly(dVar2);
                                    try {
                                        a.cancel();
                                    } catch (Exception unused) {
                                    }
                                }
                            };
                            objectHolder.held = r5;
                            listenCallback.onListening((AsyncServerSocket) r5);
                        } catch (IOException e2) {
                            e = e2;
                            serverSocketChannel = open;
                            dVar = dVar2;
                            SystemUtils.log(6, AsyncServer.LOGTAG, "wtf", e, "com.koushikdutta.async.AsyncServer$2", 368);
                            StreamUtility.closeQuietly(dVar, serverSocketChannel);
                            listenCallback2.onCompleted(e);
                        }
                    } catch (IOException e3) {
                        serverSocketChannel = open;
                        dVar = null;
                        e = e3;
                        SystemUtils.log(6, AsyncServer.LOGTAG, "wtf", e, "com.koushikdutta.async.AsyncServer$2", 368);
                        StreamUtility.closeQuietly(dVar, serverSocketChannel);
                        listenCallback2.onCompleted(e);
                    }
                } catch (IOException e4) {
                    serverSocketChannel = null;
                    e = e4;
                    dVar = null;
                    SystemUtils.log(6, AsyncServer.LOGTAG, "wtf", e, "com.koushikdutta.async.AsyncServer$2", 368);
                    StreamUtility.closeQuietly(dVar, serverSocketChannel);
                    listenCallback2.onCompleted(e);
                }
            }
        });
        return (AsyncServerSocket) objectHolder.held;
    }

    private class ConnectFuture extends SimpleFuture<AsyncNetworkSocket> {
        ConnectCallback callback;
        SocketChannel socket;

        private ConnectFuture() {
        }

        /* access modifiers changed from: protected */
        public void cancelCleanup() {
            super.cancelCleanup();
            try {
                if (this.socket != null) {
                    this.socket.close();
                }
            } catch (IOException unused) {
            }
        }
    }

    public Cancellable connectResolvedInetSocketAddress(InetSocketAddress inetSocketAddress, ConnectCallback connectCallback) {
        return connectResolvedInetSocketAddress(inetSocketAddress, connectCallback, (SocketCreateCallback) null);
    }

    public ConnectFuture connectResolvedInetSocketAddress(InetSocketAddress inetSocketAddress, ConnectCallback connectCallback, SocketCreateCallback socketCreateCallback) {
        ConnectFuture connectFuture = new ConnectFuture();
        if (f55180g || !inetSocketAddress.isUnresolved()) {
            final ConnectFuture connectFuture2 = connectFuture;
            final ConnectCallback connectCallback2 = connectCallback;
            final SocketCreateCallback socketCreateCallback2 = socketCreateCallback;
            final InetSocketAddress inetSocketAddress2 = inetSocketAddress;
            post(new Runnable() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.nio.channels.SelectionKey} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.Closeable[]} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.nio.channels.SelectionKey} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.nio.channels.SocketChannel} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.nio.channels.SelectionKey} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r5 = this;
                        com.koushikdutta.async.AsyncServer$ConnectFuture r0 = r2
                        boolean r0 = r0.isCancelled()
                        if (r0 == 0) goto L_0x0009
                        return
                    L_0x0009:
                        com.koushikdutta.async.AsyncServer$ConnectFuture r0 = r2
                        com.koushikdutta.async.callback.ConnectCallback r1 = r3
                        r0.callback = r1
                        r0 = 0
                        r1 = 0
                        com.koushikdutta.async.AsyncServer$ConnectFuture r2 = r2     // Catch:{ all -> 0x004a }
                        java.nio.channels.SocketChannel r3 = java.nio.channels.SocketChannel.open()     // Catch:{ all -> 0x004a }
                        r2.socket = r3     // Catch:{ all -> 0x004a }
                        r3.configureBlocking(r0)     // Catch:{ all -> 0x0048 }
                        com.koushikdutta.async.AsyncServer r2 = com.koushikdutta.async.AsyncServer.this     // Catch:{ all -> 0x0048 }
                        com.koushikdutta.async.c r2 = r2.f55191h     // Catch:{ all -> 0x0048 }
                        java.nio.channels.Selector r2 = r2.mo163908a()     // Catch:{ all -> 0x0048 }
                        r4 = 8
                        java.nio.channels.SelectionKey r1 = r3.register(r2, r4)     // Catch:{ all -> 0x0048 }
                        com.koushikdutta.async.AsyncServer$ConnectFuture r2 = r2     // Catch:{ all -> 0x0048 }
                        r1.attach(r2)     // Catch:{ all -> 0x0048 }
                        com.koushikdutta.async.callback.SocketCreateCallback r2 = r4     // Catch:{ all -> 0x0048 }
                        if (r2 == 0) goto L_0x0042
                        com.koushikdutta.async.callback.SocketCreateCallback r2 = r4     // Catch:{ all -> 0x0048 }
                        java.net.Socket r4 = r3.socket()     // Catch:{ all -> 0x0048 }
                        int r4 = r4.getLocalPort()     // Catch:{ all -> 0x0048 }
                        r2.onSocketCreated(r4)     // Catch:{ all -> 0x0048 }
                    L_0x0042:
                        java.net.InetSocketAddress r2 = r5     // Catch:{ all -> 0x0048 }
                        r3.connect(r2)     // Catch:{ all -> 0x0048 }
                        goto L_0x0063
                    L_0x0048:
                        r2 = move-exception
                        goto L_0x004c
                    L_0x004a:
                        r2 = move-exception
                        r3 = r1
                    L_0x004c:
                        if (r1 == 0) goto L_0x0051
                        r1.cancel()
                    L_0x0051:
                        r1 = 1
                        java.io.Closeable[] r1 = new java.io.Closeable[r1]
                        r1[r0] = r3
                        com.koushikdutta.async.util.StreamUtility.closeQuietly(r1)
                        com.koushikdutta.async.AsyncServer$ConnectFuture r0 = r2
                        java.lang.RuntimeException r1 = new java.lang.RuntimeException
                        r1.<init>(r2)
                        r0.setComplete((java.lang.Exception) r1)
                    L_0x0063:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.AsyncServer.C201173.run():void");
                }
            });
            return connectFuture;
        }
        throw new AssertionError();
    }

    public Cancellable connectSocket(final InetSocketAddress inetSocketAddress, final ConnectCallback connectCallback) {
        if (!inetSocketAddress.isUnresolved()) {
            return connectResolvedInetSocketAddress(inetSocketAddress, connectCallback);
        }
        final SimpleFuture simpleFuture = new SimpleFuture();
        Future<InetAddress> byName = getByName(inetSocketAddress.getHostName());
        simpleFuture.setParent(byName);
        byName.setCallback(new FutureCallback<InetAddress>() {
            public void onCompleted(Exception exc, InetAddress inetAddress) {
                if (exc != null) {
                    connectCallback.onConnectCompleted(exc, (AsyncSocket) null);
                    simpleFuture.setComplete(exc);
                    return;
                }
                simpleFuture.setComplete((ConnectFuture) AsyncServer.this.connectResolvedInetSocketAddress(new InetSocketAddress(inetAddress, inetSocketAddress.getPort()), connectCallback));
            }
        });
        return simpleFuture;
    }

    public Cancellable connectSocket(String str, int i, ConnectCallback connectCallback) {
        return connectSocket(InetSocketAddress.createUnresolved(str, i), connectCallback);
    }

    /* renamed from: a */
    private static ExecutorService m39706a(String str) {
        return new ThreadPoolExecutor(0, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(str));
    }

    public Future<InetAddress[]> getAllByName(final String str) {
        final SimpleFuture simpleFuture = new SimpleFuture();
        f55183k.execute(new Runnable() {
            public void run() {
                try {
                    final InetAddress[] allByName = InetAddress.getAllByName(str);
                    Arrays.sort(allByName, AsyncServer.f55182j);
                    if (allByName == null || allByName.length == 0) {
                        throw new HostnameResolutionException("no addresses for host");
                    }
                    AsyncServer.this.post(new Runnable() {
                        public void run() {
                            simpleFuture.setComplete((Exception) null, allByName);
                        }
                    });
                } catch (Exception e) {
                    AsyncServer.this.post(new Runnable() {
                        public void run() {
                            simpleFuture.setComplete(e, null);
                        }
                    });
                }
            }
        });
        return simpleFuture;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ InetAddress m39704a(InetAddress[] inetAddressArr) throws Exception {
        return inetAddressArr[0];
    }

    public Future<InetAddress> getByName(String str) {
        return getAllByName(str).thenConvert($$Lambda$AsyncServer$zHHwF2UL22BheSxMVusGefadVZw.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39709a(AsyncNetworkSocket asyncNetworkSocket) throws ClosedChannelException {
        SelectionKey a = asyncNetworkSocket.mo163688a().mo163892a(this.f55191h.mo163908a());
        a.attach(asyncNetworkSocket);
        asyncNetworkSocket.mo163689a(this, a);
    }

    public AsyncDatagramSocket connectDatagram(String str, int i) throws IOException {
        final DatagramChannel open = DatagramChannel.open();
        AsyncDatagramSocket asyncDatagramSocket = new AsyncDatagramSocket();
        asyncDatagramSocket.mo163691a(open);
        final String str2 = str;
        final int i2 = i;
        final AsyncDatagramSocket asyncDatagramSocket2 = asyncDatagramSocket;
        run(new Runnable() {
            public void run() {
                try {
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(str2, i2);
                    AsyncServer.this.m39709a((AsyncNetworkSocket) asyncDatagramSocket2);
                    open.connect(inetSocketAddress);
                } catch (IOException e) {
                    SystemUtils.log(6, AsyncServer.LOGTAG, "Datagram error", e, "com.koushikdutta.async.AsyncServer$7", 536);
                    StreamUtility.closeQuietly(open);
                }
            }
        });
        return asyncDatagramSocket;
    }

    public AsyncDatagramSocket openDatagram() {
        return openDatagram((InetAddress) null, 0, false);
    }

    public Cancellable createDatagram(String str, int i, boolean z, FutureCallback<AsyncDatagramSocket> futureCallback) {
        return m39702a((ValueFunction<InetAddress>) new ValueFunction(str) {
            public final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Object getValue() {
                return InetAddress.getByName(this.f$0);
            }
        }, i, z, futureCallback);
    }

    public Cancellable createDatagram(InetAddress inetAddress, int i, boolean z, FutureCallback<AsyncDatagramSocket> futureCallback) {
        return m39702a((ValueFunction<InetAddress>) new ValueFunction(inetAddress) {
            public final /* synthetic */ InetAddress f$0;

            {
                this.f$0 = r1;
            }

            public final Object getValue() {
                return AsyncServer.m39703a(this.f$0);
            }
        }, i, z, futureCallback);
    }

    /* renamed from: a */
    private Cancellable m39702a(ValueFunction<InetAddress> valueFunction, int i, boolean z, FutureCallback<AsyncDatagramSocket> futureCallback) {
        SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setCallback(futureCallback);
        post(new Runnable(valueFunction, i, z, simpleFuture) {
            public final /* synthetic */ ValueFunction f$1;
            public final /* synthetic */ int f$2;
            public final /* synthetic */ boolean f$3;
            public final /* synthetic */ SimpleFuture f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                AsyncServer.this.m39714a(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        });
        return simpleFuture;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39714a(ValueFunction valueFunction, int i, boolean z, SimpleFuture simpleFuture) {
        DatagramChannel datagramChannel;
        InetSocketAddress inetSocketAddress;
        try {
            datagramChannel = DatagramChannel.open();
            try {
                AsyncDatagramSocket asyncDatagramSocket = new AsyncDatagramSocket();
                asyncDatagramSocket.mo163691a(datagramChannel);
                if (valueFunction == null) {
                    inetSocketAddress = new InetSocketAddress(i);
                } else {
                    inetSocketAddress = new InetSocketAddress((InetAddress) valueFunction.getValue(), i);
                }
                if (z) {
                    datagramChannel.socket().setReuseAddress(z);
                }
                datagramChannel.socket().bind(inetSocketAddress);
                m39709a((AsyncNetworkSocket) asyncDatagramSocket);
                if (!simpleFuture.setComplete(asyncDatagramSocket)) {
                    datagramChannel.close();
                }
            } catch (Exception e) {
                e = e;
                StreamUtility.closeQuietly(datagramChannel);
                simpleFuture.setComplete(e);
            }
        } catch (Exception e2) {
            e = e2;
            datagramChannel = null;
            StreamUtility.closeQuietly(datagramChannel);
            simpleFuture.setComplete(e);
        }
    }

    public AsyncDatagramSocket openDatagram(InetAddress inetAddress, int i, boolean z) {
        AsyncDatagramSocket asyncDatagramSocket = new AsyncDatagramSocket();
        $$Lambda$AsyncServer$hVmrsV3wfbB_oqqNjM41tbeWkg r0 = new Runnable(asyncDatagramSocket, inetAddress, i, z) {
            public final /* synthetic */ AsyncDatagramSocket f$1;
            public final /* synthetic */ InetAddress f$2;
            public final /* synthetic */ int f$3;
            public final /* synthetic */ boolean f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                AsyncServer.this.m39707a(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        };
        if (getAffinity() != Thread.currentThread()) {
            run(r0);
            return asyncDatagramSocket;
        }
        r0.run();
        return asyncDatagramSocket;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39707a(AsyncDatagramSocket asyncDatagramSocket, InetAddress inetAddress, int i, boolean z) {
        InetSocketAddress inetSocketAddress;
        try {
            DatagramChannel open = DatagramChannel.open();
            try {
                asyncDatagramSocket.mo163691a(open);
                if (inetAddress == null) {
                    inetSocketAddress = new InetSocketAddress(i);
                } else {
                    inetSocketAddress = new InetSocketAddress(inetAddress, i);
                }
                if (z) {
                    open.socket().setReuseAddress(z);
                }
                open.socket().bind(inetSocketAddress);
                m39709a((AsyncNetworkSocket) asyncDatagramSocket);
            } catch (IOException e) {
                SystemUtils.log(6, LOGTAG, "Datagram error", e, "com.koushikdutta.async.AsyncServer", 617);
                StreamUtility.closeQuietly(open);
            }
        } catch (Exception unused) {
        }
    }

    public AsyncDatagramSocket connectDatagram(SocketAddress socketAddress) throws IOException {
        AsyncDatagramSocket asyncDatagramSocket = new AsyncDatagramSocket();
        DatagramChannel open = DatagramChannel.open();
        asyncDatagramSocket.mo163691a(open);
        $$Lambda$AsyncServer$ngF0quY5LOiTehUN_2qgoyf95Yo r2 = new Runnable(asyncDatagramSocket, open, socketAddress) {
            public final /* synthetic */ AsyncDatagramSocket f$1;
            public final /* synthetic */ DatagramChannel f$2;
            public final /* synthetic */ SocketAddress f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                AsyncServer.this.m39708a(this.f$1, this.f$2, this.f$3);
            }
        };
        if (getAffinity() != Thread.currentThread()) {
            run(r2);
            return asyncDatagramSocket;
        }
        r2.run();
        return asyncDatagramSocket;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39708a(AsyncDatagramSocket asyncDatagramSocket, DatagramChannel datagramChannel, SocketAddress socketAddress) {
        try {
            m39709a((AsyncNetworkSocket) asyncDatagramSocket);
            datagramChannel.connect(socketAddress);
        } catch (IOException unused) {
            StreamUtility.closeQuietly(datagramChannel);
        }
    }

    public static AsyncServer getCurrentThreadServer() {
        return f55184l.get();
    }

    /* renamed from: c */
    private void m39720c() {
        synchronized (this) {
            if (this.f55191h == null) {
                try {
                    final C20148c cVar = new C20148c(SelectorProvider.provider().openSelector());
                    this.f55191h = cVar;
                    final PriorityQueue<Scheduled> priorityQueue = this.f55189e;
                    C201248 r2 = new Thread(this.f55186b) {
                        public void run() {
                            try {
                                AsyncServer.f55184l.set(AsyncServer.this);
                                AsyncServer.m39718b(AsyncServer.this, cVar, priorityQueue);
                            } finally {
                                AsyncServer.f55184l.remove();
                            }
                        }
                    };
                    this.f55190f = r2;
                    r2.start();
                } catch (IOException e) {
                    throw new RuntimeException("unable to create selector?", e);
                }
            } else {
                C20148c cVar2 = this.f55191h;
                PriorityQueue<Scheduled> priorityQueue2 = this.f55189e;
                try {
                    m39721c(this, cVar2, priorityQueue2);
                } catch (AsyncSelectorException e2) {
                    SystemUtils.log(4, LOGTAG, "Selector closed", e2, "com.koushikdutta.async.AsyncServer", 706);
                    try {
                        cVar2.mo163908a().close();
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m39718b(AsyncServer asyncServer, C20148c cVar, PriorityQueue<Scheduled> priorityQueue) {
        while (true) {
            try {
                m39721c(asyncServer, cVar, priorityQueue);
            } catch (AsyncSelectorException e) {
                if (!(e.getCause() instanceof ClosedSelectorException)) {
                    SystemUtils.log(4, LOGTAG, "Selector exception, shutting down", e, "com.koushikdutta.async.AsyncServer", 731);
                }
                StreamUtility.closeQuietly(cVar);
            }
            synchronized (asyncServer) {
                if (!cVar.mo163915f() || (cVar.mo163913d().size() <= 0 && priorityQueue.size() <= 0)) {
                    m39723d(cVar);
                }
            }
        }
        m39723d(cVar);
        if (asyncServer.f55191h == cVar) {
            asyncServer.f55189e = new PriorityQueue<>(1, Scheduler.INSTANCE);
            asyncServer.f55191h = null;
            asyncServer.f55190f = null;
        }
    }

    /* renamed from: c */
    private static void m39722c(C20148c cVar) {
        try {
            for (SelectionKey next : cVar.mo163913d()) {
                StreamUtility.closeQuietly(next.channel());
                try {
                    next.cancel();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m39723d(C20148c cVar) {
        m39722c(cVar);
        StreamUtility.closeQuietly(cVar);
    }

    /* renamed from: a */
    private static long m39700a(AsyncServer asyncServer, PriorityQueue<Scheduled> priorityQueue) {
        long j = Long.MAX_VALUE;
        while (true) {
            Scheduled scheduled = null;
            synchronized (asyncServer) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (priorityQueue.size() > 0) {
                    Scheduled scheduled2 = (Scheduled) priorityQueue.remove();
                    if (scheduled2.time <= elapsedRealtime) {
                        scheduled = scheduled2;
                    } else {
                        j = scheduled2.time - elapsedRealtime;
                        priorityQueue.add(scheduled2);
                    }
                }
            }
            if (scheduled == null) {
                asyncServer.f55188d = 0;
                return j;
            }
            scheduled.run();
        }
        while (true) {
        }
    }

    private static class AsyncSelectorException extends IOException {
        public AsyncSelectorException(Exception exc) {
            super(exc);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.nio.channels.SelectionKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.nio.channels.SelectionKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.nio.channels.SocketChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.nio.channels.SelectionKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.nio.channels.SelectionKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.nio.channels.SelectionKey} */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        if (r0 == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r2 != Long.MAX_VALUE) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r17.mo163911c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        r17.mo163909a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        r2 = r17.mo163914e();
        r3 = r2.iterator();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m39721c(com.koushikdutta.async.AsyncServer r16, com.koushikdutta.async.C20148c r17, java.util.PriorityQueue<com.koushikdutta.async.AsyncServer.Scheduled> r18) throws com.koushikdutta.async.AsyncServer.AsyncSelectorException {
        /*
            r1 = r16
            r0 = r18
            long r2 = m39700a((com.koushikdutta.async.AsyncServer) r1, (java.util.PriorityQueue<com.koushikdutta.async.AsyncServer.Scheduled>) r0)
            monitor-enter(r16)     // Catch:{ Exception -> 0x013f }
            int r0 = r17.mo163910b()     // Catch:{ all -> 0x013c }
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = 0
            r7 = 1
            if (r0 != 0) goto L_0x0028
            java.util.Set r0 = r17.mo163913d()     // Catch:{ all -> 0x013c }
            int r0 = r0.size()     // Catch:{ all -> 0x013c }
            if (r0 != 0) goto L_0x0026
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0026
            monitor-exit(r16)     // Catch:{ all -> 0x013c }
            return
        L_0x0026:
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            monitor-exit(r16)     // Catch:{ all -> 0x013c }
            if (r0 == 0) goto L_0x003a
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0034
            r17.mo163911c()     // Catch:{ Exception -> 0x013f }
            goto L_0x003a
        L_0x0034:
            r4 = r17
            r4.mo163909a(r2)     // Catch:{ Exception -> 0x013f }
            goto L_0x003c
        L_0x003a:
            r4 = r17
        L_0x003c:
            java.util.Set r2 = r17.mo163914e()
            java.util.Iterator r3 = r2.iterator()
        L_0x0044:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0138
            java.lang.Object r0 = r3.next()
            r5 = r0
            java.nio.channels.SelectionKey r5 = (java.nio.channels.SelectionKey) r5
            boolean r0 = r5.isAcceptable()     // Catch:{ CancelledKeyException -> 0x0135 }
            r8 = 0
            if (r0 == 0) goto L_0x00a4
            java.nio.channels.SelectableChannel r0 = r5.channel()     // Catch:{ CancelledKeyException -> 0x0135 }
            java.nio.channels.ServerSocketChannel r0 = (java.nio.channels.ServerSocketChannel) r0     // Catch:{ CancelledKeyException -> 0x0135 }
            java.nio.channels.SocketChannel r0 = r0.accept()     // Catch:{ IOException -> 0x0096 }
            if (r0 != 0) goto L_0x0065
            goto L_0x0044
        L_0x0065:
            r0.configureBlocking(r6)     // Catch:{ IOException -> 0x0092 }
            java.nio.channels.Selector r9 = r17.mo163908a()     // Catch:{ IOException -> 0x0092 }
            java.nio.channels.SelectionKey r8 = r0.register(r9, r7)     // Catch:{ IOException -> 0x0092 }
            java.lang.Object r5 = r5.attachment()     // Catch:{ IOException -> 0x0092 }
            com.koushikdutta.async.callback.ListenCallback r5 = (com.koushikdutta.async.callback.ListenCallback) r5     // Catch:{ IOException -> 0x0092 }
            com.koushikdutta.async.AsyncNetworkSocket r9 = new com.koushikdutta.async.AsyncNetworkSocket     // Catch:{ IOException -> 0x0092 }
            r9.<init>()     // Catch:{ IOException -> 0x0092 }
            java.net.Socket r10 = r0.socket()     // Catch:{ IOException -> 0x0092 }
            java.net.SocketAddress r10 = r10.getRemoteSocketAddress()     // Catch:{ IOException -> 0x0092 }
            java.net.InetSocketAddress r10 = (java.net.InetSocketAddress) r10     // Catch:{ IOException -> 0x0092 }
            r9.mo163692a((java.nio.channels.SocketChannel) r0, (java.net.InetSocketAddress) r10)     // Catch:{ IOException -> 0x0092 }
            r9.mo163689a((com.koushikdutta.async.AsyncServer) r1, (java.nio.channels.SelectionKey) r8)     // Catch:{ IOException -> 0x0092 }
            r8.attach(r9)     // Catch:{ IOException -> 0x0092 }
            r5.onAccepted(r9)     // Catch:{ IOException -> 0x0092 }
            goto L_0x0044
        L_0x0092:
            r15 = r8
            r8 = r0
            r0 = r15
            goto L_0x0097
        L_0x0096:
            r0 = r8
        L_0x0097:
            java.io.Closeable[] r5 = new java.io.Closeable[r7]     // Catch:{ CancelledKeyException -> 0x0135 }
            r5[r6] = r8     // Catch:{ CancelledKeyException -> 0x0135 }
            com.koushikdutta.async.util.StreamUtility.closeQuietly(r5)     // Catch:{ CancelledKeyException -> 0x0135 }
            if (r0 == 0) goto L_0x0044
            r0.cancel()     // Catch:{ CancelledKeyException -> 0x0135 }
            goto L_0x0044
        L_0x00a4:
            boolean r0 = r5.isReadable()     // Catch:{ CancelledKeyException -> 0x0135 }
            if (r0 == 0) goto L_0x00b8
            java.lang.Object r0 = r5.attachment()     // Catch:{ CancelledKeyException -> 0x0135 }
            com.koushikdutta.async.AsyncNetworkSocket r0 = (com.koushikdutta.async.AsyncNetworkSocket) r0     // Catch:{ CancelledKeyException -> 0x0135 }
            int r0 = r0.mo163693b()     // Catch:{ CancelledKeyException -> 0x0135 }
            r1.onDataReceived(r0)     // Catch:{ CancelledKeyException -> 0x0135 }
            goto L_0x0044
        L_0x00b8:
            boolean r0 = r5.isWritable()     // Catch:{ CancelledKeyException -> 0x0135 }
            if (r0 == 0) goto L_0x00c9
            java.lang.Object r0 = r5.attachment()     // Catch:{ CancelledKeyException -> 0x0135 }
            com.koushikdutta.async.AsyncNetworkSocket r0 = (com.koushikdutta.async.AsyncNetworkSocket) r0     // Catch:{ CancelledKeyException -> 0x0135 }
            r0.onDataWritable()     // Catch:{ CancelledKeyException -> 0x0135 }
            goto L_0x0044
        L_0x00c9:
            boolean r0 = r5.isConnectable()     // Catch:{ CancelledKeyException -> 0x0135 }
            if (r0 == 0) goto L_0x0120
            java.lang.Object r0 = r5.attachment()     // Catch:{ CancelledKeyException -> 0x0135 }
            r9 = r0
            com.koushikdutta.async.AsyncServer$ConnectFuture r9 = (com.koushikdutta.async.AsyncServer.ConnectFuture) r9     // Catch:{ CancelledKeyException -> 0x0135 }
            java.nio.channels.SelectableChannel r0 = r5.channel()     // Catch:{ CancelledKeyException -> 0x0135 }
            r10 = r0
            java.nio.channels.SocketChannel r10 = (java.nio.channels.SocketChannel) r10     // Catch:{ CancelledKeyException -> 0x0135 }
            r5.interestOps(r7)     // Catch:{ CancelledKeyException -> 0x0135 }
            r10.finishConnect()     // Catch:{ IOException -> 0x0108 }
            com.koushikdutta.async.AsyncNetworkSocket r0 = new com.koushikdutta.async.AsyncNetworkSocket     // Catch:{ IOException -> 0x0108 }
            r0.<init>()     // Catch:{ IOException -> 0x0108 }
            r0.mo163689a((com.koushikdutta.async.AsyncServer) r1, (java.nio.channels.SelectionKey) r5)     // Catch:{ IOException -> 0x0108 }
            java.net.Socket r11 = r10.socket()     // Catch:{ IOException -> 0x0108 }
            java.net.SocketAddress r11 = r11.getRemoteSocketAddress()     // Catch:{ IOException -> 0x0108 }
            java.net.InetSocketAddress r11 = (java.net.InetSocketAddress) r11     // Catch:{ IOException -> 0x0108 }
            r0.mo163692a((java.nio.channels.SocketChannel) r10, (java.net.InetSocketAddress) r11)     // Catch:{ IOException -> 0x0108 }
            r5.attach(r0)     // Catch:{ IOException -> 0x0108 }
            boolean r5 = r9.setComplete(r0)     // Catch:{ CancelledKeyException -> 0x0135 }
            if (r5 == 0) goto L_0x0044
            com.koushikdutta.async.callback.ConnectCallback r5 = r9.callback     // Catch:{ CancelledKeyException -> 0x0135 }
            r5.onConnectCompleted(r8, r0)     // Catch:{ CancelledKeyException -> 0x0135 }
            goto L_0x0044
        L_0x0108:
            r0 = move-exception
            r5.cancel()     // Catch:{ CancelledKeyException -> 0x0135 }
            java.io.Closeable[] r5 = new java.io.Closeable[r7]     // Catch:{ CancelledKeyException -> 0x0135 }
            r5[r6] = r10     // Catch:{ CancelledKeyException -> 0x0135 }
            com.koushikdutta.async.util.StreamUtility.closeQuietly(r5)     // Catch:{ CancelledKeyException -> 0x0135 }
            boolean r5 = r9.setComplete((java.lang.Exception) r0)     // Catch:{ CancelledKeyException -> 0x0135 }
            if (r5 == 0) goto L_0x0044
            com.koushikdutta.async.callback.ConnectCallback r5 = r9.callback     // Catch:{ CancelledKeyException -> 0x0135 }
            r5.onConnectCompleted(r0, r8)     // Catch:{ CancelledKeyException -> 0x0135 }
            goto L_0x0044
        L_0x0120:
            java.lang.String r10 = "NIO"
            java.lang.String r11 = "wtf"
            r9 = 4
            r12 = 0
            java.lang.String r13 = "com.koushikdutta.async.AsyncServer"
            r14 = 909(0x38d, float:1.274E-42)
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)     // Catch:{ CancelledKeyException -> 0x0135 }
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ CancelledKeyException -> 0x0135 }
            java.lang.String r5 = "Unknown key state."
            r0.<init>(r5)     // Catch:{ CancelledKeyException -> 0x0135 }
            throw r0     // Catch:{ CancelledKeyException -> 0x0135 }
        L_0x0135:
            goto L_0x0044
        L_0x0138:
            r2.clear()
            return
        L_0x013c:
            r0 = move-exception
            monitor-exit(r16)     // Catch:{ all -> 0x013c }
            throw r0     // Catch:{ Exception -> 0x013f }
        L_0x013f:
            r0 = move-exception
            com.koushikdutta.async.AsyncServer$AsyncSelectorException r1 = new com.koushikdutta.async.AsyncServer$AsyncSelectorException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.AsyncServer.m39721c(com.koushikdutta.async.AsyncServer, com.koushikdutta.async.c, java.util.PriorityQueue):void");
    }

    public void dump() {
        post(new Runnable() {
            public void run() {
                if (AsyncServer.this.f55191h == null) {
                    SystemUtils.log(4, AsyncServer.LOGTAG, "Server dump not possible. No selector?", (Throwable) null, "com.koushikdutta.async.AsyncServer$9", 924);
                    return;
                }
                SystemUtils.log(4, AsyncServer.LOGTAG, "Key Count: " + AsyncServer.this.f55191h.mo163913d().size(), (Throwable) null, "com.koushikdutta.async.AsyncServer$9", 927);
                for (SelectionKey selectionKey : AsyncServer.this.f55191h.mo163913d()) {
                    SystemUtils.log(4, AsyncServer.LOGTAG, "Key: " + selectionKey, (Throwable) null, "com.koushikdutta.async.AsyncServer$9", 930);
                }
            }
        });
    }

    public Thread getAffinity() {
        return this.f55190f;
    }

    public boolean isAffinityThread() {
        return this.f55190f == Thread.currentThread();
    }

    public boolean isAffinityThreadOrStopped() {
        Thread thread = this.f55190f;
        return thread == null || thread == Thread.currentThread();
    }

    private static class NamedThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        NamedThreadFactory(String str) {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.group = threadGroup;
            this.namePrefix = str;
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }
}

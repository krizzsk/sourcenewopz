package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.C2434Util;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class Http2Connection implements Closeable {

    /* renamed from: a */
    static final int f5438a = 16777216;

    /* renamed from: s */
    static final /* synthetic */ boolean f5439s = (!Http2Connection.class.desiredAssertionStatus());
    /* access modifiers changed from: private */

    /* renamed from: t */
    public static final ExecutorService f5440t = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C2434Util.threadFactory("OkHttp Http2Connection", true));

    /* renamed from: b */
    final boolean f5441b;

    /* renamed from: c */
    final Listener f5442c;

    /* renamed from: d */
    final Map<Integer, Http2Stream> f5443d = new LinkedHashMap();

    /* renamed from: e */
    final String f5444e;

    /* renamed from: f */
    int f5445f;

    /* renamed from: g */
    int f5446g;

    /* renamed from: h */
    boolean f5447h;

    /* renamed from: i */
    final PushObserver f5448i;

    /* renamed from: j */
    long f5449j = 0;

    /* renamed from: k */
    long f5450k;

    /* renamed from: l */
    Settings f5451l = new Settings();

    /* renamed from: m */
    final Settings f5452m = new Settings();

    /* renamed from: n */
    boolean f5453n = false;

    /* renamed from: o */
    final Socket f5454o;

    /* renamed from: p */
    final C2458a f5455p;

    /* renamed from: q */
    final ReaderRunnable f5456q;

    /* renamed from: r */
    final Set<Integer> f5457r = new LinkedHashSet();
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final ScheduledExecutorService f5458u;

    /* renamed from: v */
    private final ExecutorService f5459v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f5460w;

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            public void onStream(Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo25250c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    Http2Connection(Builder builder) {
        Builder builder2 = builder;
        this.f5448i = builder2.pushObserver;
        this.f5441b = builder2.client;
        this.f5442c = builder2.listener;
        this.f5446g = builder2.client ? 1 : 2;
        if (builder2.client) {
            this.f5446g += 2;
        }
        if (builder2.client) {
            this.f5451l.mo25315a(7, 16777216);
        }
        this.f5444e = builder2.hostname;
        this.f5458u = new ScheduledThreadPoolExecutor(1, C2434Util.threadFactory(C2434Util.format("OkHttp %s Writer", this.f5444e), false));
        if (builder2.pingIntervalMillis != 0) {
            this.f5458u.scheduleAtFixedRate(new PingRunnable(false, 0, 0), (long) builder2.pingIntervalMillis, (long) builder2.pingIntervalMillis, TimeUnit.MILLISECONDS);
        }
        this.f5459v = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C2434Util.threadFactory(C2434Util.format("OkHttp %s Push Observer", this.f5444e), true));
        this.f5452m.mo25315a(7, 65535);
        this.f5452m.mo25315a(5, 16384);
        this.f5450k = (long) this.f5452m.mo25324d();
        this.f5454o = builder2.socket;
        this.f5455p = new C2458a(builder2.sink, this.f5441b);
        this.f5456q = new ReaderRunnable(new Http2Reader(builder2.source, this.f5441b));
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public synchronized int openStreamCount() {
        return this.f5443d.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized Http2Stream mo25234a(int i) {
        return this.f5443d.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized Http2Stream mo25246b(int i) {
        Http2Stream remove;
        remove = this.f5443d.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public synchronized int maxConcurrentStreams() {
        return this.f5452m.mo25323c(Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo25242a(long j) {
        long j2 = this.f5449j + j;
        this.f5449j = j2;
        if (j2 >= ((long) (this.f5451l.mo25324d() / 2))) {
            mo25236a(0, this.f5449j);
            this.f5449j = 0;
        }
    }

    public Http2Stream pushStream(int i, List<Header> list, boolean z) throws IOException {
        if (!this.f5441b) {
            return m3459b(i, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    public Http2Stream newStream(List<Header> list, boolean z) throws IOException {
        return m3459b(0, list, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.http2.Http2Stream m3459b(int r11, java.util.List<okhttp3.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.a r7 = r10.f5455p
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0078 }
            int r0 = r10.f5446g     // Catch:{ all -> 0x0075 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0075 }
            r10.shutdown(r0)     // Catch:{ all -> 0x0075 }
        L_0x0013:
            boolean r0 = r10.f5447h     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x006f
            int r8 = r10.f5446g     // Catch:{ all -> 0x0075 }
            int r0 = r10.f5446g     // Catch:{ all -> 0x0075 }
            int r0 = r0 + 2
            r10.f5446g = r0     // Catch:{ all -> 0x0075 }
            okhttp3.internal.http2.Http2Stream r9 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0075 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0075 }
            if (r13 == 0) goto L_0x003c
            long r0 = r10.f5450k     // Catch:{ all -> 0x0075 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003c
            long r0 = r9.f5468b     // Catch:{ all -> 0x0075 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r13 = 0
            goto L_0x003d
        L_0x003c:
            r13 = 1
        L_0x003d:
            boolean r0 = r9.isOpen()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x004c
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r0 = r10.f5443d     // Catch:{ all -> 0x0075 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0075 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0075 }
        L_0x004c:
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            if (r11 != 0) goto L_0x0055
            okhttp3.internal.http2.a r0 = r10.f5455p     // Catch:{ all -> 0x0078 }
            r0.mo25337a((boolean) r6, (int) r8, (int) r11, (java.util.List<okhttp3.internal.http2.Header>) r12)     // Catch:{ all -> 0x0078 }
            goto L_0x005e
        L_0x0055:
            boolean r0 = r10.f5441b     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0067
            okhttp3.internal.http2.a r0 = r10.f5455p     // Catch:{ all -> 0x0078 }
            r0.mo25330a((int) r11, (int) r8, (java.util.List<okhttp3.internal.http2.Header>) r12)     // Catch:{ all -> 0x0078 }
        L_0x005e:
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            if (r13 == 0) goto L_0x0066
            okhttp3.internal.http2.a r11 = r10.f5455p
            r11.mo25340b()
        L_0x0066:
            return r9
        L_0x0067:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0078 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0078 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x006f:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0075 }
            r11.<init>()     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.m3459b(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25241a(int i, boolean z, List<Header> list) throws IOException {
        this.f5455p.mo25338a(z, i, list);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.f5450k), r8.f5455p.mo25343c());
        r6 = (long) r3;
        r8.f5450k -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeData(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            okhttp3.internal.http2.a r12 = r8.f5455p
            r12.mo25339a((boolean) r10, (int) r9, (okio.Buffer) r11, (int) r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0069
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f5450k     // Catch:{ InterruptedException -> 0x005a }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r3 = r8.f5443d     // Catch:{ InterruptedException -> 0x005a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005a }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x005a }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x005a }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005a }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x005a }
            throw r9     // Catch:{ InterruptedException -> 0x005a }
        L_0x0030:
            long r3 = r8.f5450k     // Catch:{ all -> 0x0058 }
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0058 }
            int r4 = (int) r3     // Catch:{ all -> 0x0058 }
            okhttp3.internal.http2.a r3 = r8.f5455p     // Catch:{ all -> 0x0058 }
            int r3 = r3.mo25343c()     // Catch:{ all -> 0x0058 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0058 }
            long r4 = r8.f5450k     // Catch:{ all -> 0x0058 }
            long r6 = (long) r3     // Catch:{ all -> 0x0058 }
            long r4 = r4 - r6
            r8.f5450k = r4     // Catch:{ all -> 0x0058 }
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            long r12 = r12 - r6
            okhttp3.internal.http2.a r4 = r8.f5455p
            if (r10 == 0) goto L_0x0053
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            r4.mo25339a((boolean) r5, (int) r9, (okio.Buffer) r11, (int) r3)
            goto L_0x000d
        L_0x0058:
            r9 = move-exception
            goto L_0x0067
        L_0x005a:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0058 }
            r9.interrupt()     // Catch:{ all -> 0x0058 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0058 }
            r9.<init>()     // Catch:{ all -> 0x0058 }
            throw r9     // Catch:{ all -> 0x0058 }
        L_0x0067:
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            throw r9
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25239a(int i, ErrorCode errorCode) {
        try {
            final int i2 = i;
            final ErrorCode errorCode2 = errorCode;
            this.f5458u.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.f5444e, Integer.valueOf(i)}) {
                public void execute() {
                    try {
                        Http2Connection.this.mo25248b(i2, errorCode2);
                    } catch (IOException unused) {
                        Http2Connection.this.m3461d();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25248b(int i, ErrorCode errorCode) throws IOException {
        this.f5455p.mo25333a(i, errorCode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25236a(int i, long j) {
        try {
            final int i2 = i;
            final long j2 = j;
            this.f5458u.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.f5444e, Integer.valueOf(i)}) {
                public void execute() {
                    try {
                        Http2Connection.this.f5455p.mo25331a(i2, j2);
                    } catch (IOException unused) {
                        Http2Connection.this.m3461d();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.f5444e, Integer.valueOf(i), Integer.valueOf(i2));
            this.reply = z;
            this.payload1 = i;
            this.payload2 = i2;
        }

        public void execute() {
            Http2Connection.this.mo25245a(this.reply, this.payload1, this.payload2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25245a(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.f5460w;
                this.f5460w = true;
            }
            if (z2) {
                m3461d();
                return;
            }
        }
        try {
            this.f5455p.mo25336a(z, i, i2);
        } catch (IOException unused) {
            m3461d();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25235a() throws InterruptedException {
        mo25245a(false, 1330343787, -257978967);
        mo25247b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo25247b() throws InterruptedException {
        while (this.f5460w) {
            wait();
        }
    }

    public void flush() throws IOException {
        this.f5455p.mo25340b();
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.f5455p) {
            synchronized (this) {
                if (!this.f5447h) {
                    this.f5447h = true;
                    int i = this.f5445f;
                    this.f5455p.mo25334a(i, errorCode, C2434Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void close() throws IOException {
        mo25243a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25243a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        if (f5439s || !Thread.holdsLock(this)) {
            Http2Stream[] http2StreamArr = null;
            try {
                shutdown(errorCode);
                e = null;
            } catch (IOException e) {
                e = e;
            }
            synchronized (this) {
                if (!this.f5443d.isEmpty()) {
                    http2StreamArr = (Http2Stream[]) this.f5443d.values().toArray(new Http2Stream[this.f5443d.size()]);
                    this.f5443d.clear();
                }
            }
            if (http2StreamArr != null) {
                for (Http2Stream close : http2StreamArr) {
                    try {
                        close.close(errorCode2);
                    } catch (IOException e2) {
                        if (e != null) {
                            e = e2;
                        }
                    }
                }
            }
            try {
                this.f5455p.close();
            } catch (IOException e3) {
                if (e == null) {
                    e = e3;
                }
            }
            try {
                this.f5454o.close();
            } catch (IOException e4) {
                e = e4;
            }
            this.f5458u.shutdown();
            this.f5459v.shutdown();
            if (e != null) {
                throw e;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m3461d() {
        try {
            mo25243a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    public void start() throws IOException {
        mo25244a(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25244a(boolean z) throws IOException {
        if (z) {
            this.f5455p.mo25327a();
            this.f5455p.mo25341b(this.f5451l);
            int d = this.f5451l.mo25324d();
            if (d != 65535) {
                this.f5455p.mo25331a(0, (long) (d - 65535));
            }
        }
        new Thread(this.f5456q).start();
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.f5455p) {
            synchronized (this) {
                if (!this.f5447h) {
                    this.f5451l.mo25317a(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.f5455p.mo25341b(settings);
        }
    }

    public synchronized boolean isShutdown() {
        return this.f5447h;
    }

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        int pingIntervalMillis;
        PushObserver pushObserver = PushObserver.CANCEL;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;

        public Builder(boolean z) {
            this.client = z;
        }

        public Builder socket(Socket socket2) throws IOException {
            return socket(socket2, ((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket2)), Okio.buffer(Okio.sink(socket2)));
        }

        public Builder socket(Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket2;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }

        public Builder listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;

        public void ackSettings() {
        }

        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.f5444e);
            this.reader = http2Reader;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
            r1 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r2 = r4.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r4.this$0.mo25243a(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
            okhttp3.internal.C2434Util.closeQuietly((java.io.Closeable) r4.reader);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r4 = this;
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                okhttp3.internal.http2.Http2Reader r2 = r4.reader     // Catch:{ IOException -> 0x001c }
                r2.mo25280a((okhttp3.internal.http2.Http2Reader.Handler) r4)     // Catch:{ IOException -> 0x001c }
            L_0x0009:
                okhttp3.internal.http2.Http2Reader r2 = r4.reader     // Catch:{ IOException -> 0x001c }
                r3 = 0
                boolean r2 = r2.mo25281a((boolean) r3, (okhttp3.internal.http2.Http2Reader.Handler) r4)     // Catch:{ IOException -> 0x001c }
                if (r2 == 0) goto L_0x0013
                goto L_0x0009
            L_0x0013:
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x001c }
                okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x001c }
                okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0025 }
                goto L_0x0022
            L_0x001a:
                r2 = move-exception
                goto L_0x002b
            L_0x001c:
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x001a }
                okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x001a }
                okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0025 }
            L_0x0022:
                r2.mo25243a((okhttp3.internal.http2.ErrorCode) r0, (okhttp3.internal.http2.ErrorCode) r1)     // Catch:{ IOException -> 0x0025 }
            L_0x0025:
                okhttp3.internal.http2.Http2Reader r0 = r4.reader
                okhttp3.internal.C2434Util.closeQuietly((java.io.Closeable) r0)
                return
            L_0x002b:
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0030 }
                r3.mo25243a((okhttp3.internal.http2.ErrorCode) r0, (okhttp3.internal.http2.ErrorCode) r1)     // Catch:{ IOException -> 0x0030 }
            L_0x0030:
                okhttp3.internal.http2.Http2Reader r0 = r4.reader
                okhttp3.internal.C2434Util.closeQuietly((java.io.Closeable) r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.execute():void");
        }

        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.this.mo25250c(i)) {
                Http2Connection.this.mo25240a(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream a = Http2Connection.this.mo25234a(i);
            if (a == null) {
                Http2Connection.this.mo25239a(i, ErrorCode.PROTOCOL_ERROR);
                long j = (long) i2;
                Http2Connection.this.mo25242a(j);
                bufferedSource.skip(j);
                return;
            }
            a.mo25287a(bufferedSource, i2);
            if (z) {
                a.mo25283a();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0074, code lost:
            r0.mo25285a(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0079, code lost:
            r0.mo25283a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r10, int r11, int r12, java.util.List<okhttp3.internal.http2.Header> r13) {
            /*
                r9 = this;
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this
                boolean r12 = r12.mo25250c(r11)
                if (r12 == 0) goto L_0x000e
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this
                r12.mo25238a((int) r11, (java.util.List<okhttp3.internal.http2.Header>) r13, (boolean) r10)
                return
            L_0x000e:
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this
                monitor-enter(r12)
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.Http2Stream r0 = r0.mo25234a((int) r11)     // Catch:{ all -> 0x007d }
                if (r0 != 0) goto L_0x0073
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                boolean r0 = r0.f5447h     // Catch:{ all -> 0x007d }
                if (r0 == 0) goto L_0x0021
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                return
            L_0x0021:
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                int r0 = r0.f5445f     // Catch:{ all -> 0x007d }
                if (r11 > r0) goto L_0x0029
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                return
            L_0x0029:
                int r0 = r11 % 2
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                int r1 = r1.f5446g     // Catch:{ all -> 0x007d }
                r2 = 2
                int r1 = r1 % r2
                if (r0 != r1) goto L_0x0035
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                return
            L_0x0035:
                okhttp3.Headers r8 = okhttp3.internal.C2434Util.toHeaders(r13)     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.Http2Stream r13 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.Http2Connection r5 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                r6 = 0
                r3 = r13
                r4 = r11
                r7 = r10
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.Http2Connection r10 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                r10.f5445f = r11     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.Http2Connection r10 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r10 = r10.f5443d     // Catch:{ all -> 0x007d }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007d }
                r10.put(r0, r13)     // Catch:{ all -> 0x007d }
                java.util.concurrent.ExecutorService r10 = okhttp3.internal.http2.Http2Connection.f5440t     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.Http2Connection$ReaderRunnable$1 r0 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$1     // Catch:{ all -> 0x007d }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x007d }
                r3 = 0
                okhttp3.internal.http2.Http2Connection r4 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                java.lang.String r4 = r4.f5444e     // Catch:{ all -> 0x007d }
                r2[r3] = r4     // Catch:{ all -> 0x007d }
                r3 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007d }
                r2[r3] = r11     // Catch:{ all -> 0x007d }
                r0.<init>(r1, r2, r13)     // Catch:{ all -> 0x007d }
                r10.execute(r0)     // Catch:{ all -> 0x007d }
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                return
            L_0x0073:
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                r0.mo25285a((java.util.List<okhttp3.internal.http2.Header>) r13)
                if (r10 == 0) goto L_0x007c
                r0.mo25283a()
            L_0x007c:
                return
            L_0x007d:
                r10 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.headers(boolean, int, int, java.util.List):void");
        }

        public void rstStream(int i, ErrorCode errorCode) {
            if (Http2Connection.this.mo25250c(i)) {
                Http2Connection.this.mo25249c(i, errorCode);
                return;
            }
            Http2Stream b = Http2Connection.this.mo25246b(i);
            if (b != null) {
                b.mo25286a(errorCode);
            }
        }

        /* JADX WARNING: type inference failed for: r1v13, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void settings(boolean r11, okhttp3.internal.http2.Settings r12) {
            /*
                r10 = this;
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this
                monitor-enter(r0)
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.Settings r1 = r1.f5452m     // Catch:{ all -> 0x008f }
                int r1 = r1.mo25324d()     // Catch:{ all -> 0x008f }
                if (r11 == 0) goto L_0x0014
                okhttp3.internal.http2.Http2Connection r11 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.Settings r11 = r11.f5452m     // Catch:{ all -> 0x008f }
                r11.mo25316a()     // Catch:{ all -> 0x008f }
            L_0x0014:
                okhttp3.internal.http2.Http2Connection r11 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.Settings r11 = r11.f5452m     // Catch:{ all -> 0x008f }
                r11.mo25317a((okhttp3.internal.http2.Settings) r12)     // Catch:{ all -> 0x008f }
                r10.applyAndAckSettings(r12)     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.Http2Connection r11 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.Settings r11 = r11.f5452m     // Catch:{ all -> 0x008f }
                int r11 = r11.mo25324d()     // Catch:{ all -> 0x008f }
                r12 = -1
                r2 = 0
                r4 = 1
                r5 = 0
                if (r11 == r12) goto L_0x005f
                if (r11 == r1) goto L_0x005f
                int r11 = r11 - r1
                long r11 = (long) r11     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008f }
                boolean r1 = r1.f5453n     // Catch:{ all -> 0x008f }
                if (r1 != 0) goto L_0x003b
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008f }
                r1.f5453n = r4     // Catch:{ all -> 0x008f }
            L_0x003b:
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008f }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r1 = r1.f5443d     // Catch:{ all -> 0x008f }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x008f }
                if (r1 != 0) goto L_0x0060
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008f }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r1 = r1.f5443d     // Catch:{ all -> 0x008f }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.Http2Connection r5 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008f }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r5 = r5.f5443d     // Catch:{ all -> 0x008f }
                int r5 = r5.size()     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.Http2Stream[] r5 = new okhttp3.internal.http2.Http2Stream[r5]     // Catch:{ all -> 0x008f }
                java.lang.Object[] r1 = r1.toArray(r5)     // Catch:{ all -> 0x008f }
                r5 = r1
                okhttp3.internal.http2.Http2Stream[] r5 = (okhttp3.internal.http2.Http2Stream[]) r5     // Catch:{ all -> 0x008f }
                goto L_0x0060
            L_0x005f:
                r11 = r2
            L_0x0060:
                java.util.concurrent.ExecutorService r1 = okhttp3.internal.http2.Http2Connection.f5440t     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.Http2Connection$ReaderRunnable$2 r6 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$2     // Catch:{ all -> 0x008f }
                java.lang.String r7 = "OkHttp %s settings"
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.Http2Connection r8 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008f }
                java.lang.String r8 = r8.f5444e     // Catch:{ all -> 0x008f }
                r9 = 0
                r4[r9] = r8     // Catch:{ all -> 0x008f }
                r6.<init>(r7, r4)     // Catch:{ all -> 0x008f }
                r1.execute(r6)     // Catch:{ all -> 0x008f }
                monitor-exit(r0)     // Catch:{ all -> 0x008f }
                if (r5 == 0) goto L_0x008e
                int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x008e
                int r0 = r5.length
            L_0x007f:
                if (r9 >= r0) goto L_0x008e
                r1 = r5[r9]
                monitor-enter(r1)
                r1.mo25284a((long) r11)     // Catch:{ all -> 0x008b }
                monitor-exit(r1)     // Catch:{ all -> 0x008b }
                int r9 = r9 + 1
                goto L_0x007f
            L_0x008b:
                r11 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x008b }
                throw r11
            L_0x008e:
                return
            L_0x008f:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x008f }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.settings(boolean, okhttp3.internal.http2.Settings):void");
        }

        private void applyAndAckSettings(final Settings settings) {
            try {
                Http2Connection.this.f5458u.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.f5444e}) {
                    public void execute() {
                        try {
                            Http2Connection.this.f5455p.mo25335a(settings);
                        } catch (IOException unused) {
                            Http2Connection.this.m3461d();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        public void ping(boolean z, int i, int i2) {
            if (z) {
                synchronized (Http2Connection.this) {
                    boolean unused = Http2Connection.this.f5460w = false;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            try {
                Http2Connection.this.f5458u.execute(new PingRunnable(true, i, i2));
            } catch (RejectedExecutionException unused2) {
            }
        }

        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.f5443d.values().toArray(new Http2Stream[Http2Connection.this.f5443d.size()]);
                Http2Connection.this.f5447h = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.mo25286a(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.mo25246b(http2Stream.getId());
                }
            }
        }

        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f5450k += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream a = Http2Connection.this.mo25234a(i);
            if (a != null) {
                synchronized (a) {
                    a.mo25284a(j);
                }
            }
        }

        public void pushPromise(int i, int i2, List<Header> list) {
            Http2Connection.this.mo25237a(i2, list);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25237a(int i, List<Header> list) {
        synchronized (this) {
            if (this.f5457r.contains(Integer.valueOf(i))) {
                mo25239a(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f5457r.add(Integer.valueOf(i));
            try {
                final int i2 = i;
                final List<Header> list2 = list;
                m3455a((NamedRunnable) new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.f5444e, Integer.valueOf(i)}) {
                    public void execute() {
                        if (Http2Connection.this.f5448i.onRequest(i2, list2)) {
                            try {
                                Http2Connection.this.f5455p.mo25333a(i2, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.f5457r.remove(Integer.valueOf(i2));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25238a(int i, List<Header> list, boolean z) {
        try {
            final int i2 = i;
            final List<Header> list2 = list;
            final boolean z2 = z;
            m3455a((NamedRunnable) new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.f5444e, Integer.valueOf(i)}) {
                public void execute() {
                    boolean onHeaders = Http2Connection.this.f5448i.onHeaders(i2, list2, z2);
                    if (onHeaders) {
                        try {
                            Http2Connection.this.f5455p.mo25333a(i2, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (onHeaders || z2) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.f5457r.remove(Integer.valueOf(i2));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25240a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = (long) i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            m3455a((NamedRunnable) new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.f5444e, Integer.valueOf(i)}) {
                public void execute() {
                    try {
                        boolean onData = Http2Connection.this.f5448i.onData(i3, buffer, i4, z2);
                        if (onData) {
                            Http2Connection.this.f5455p.mo25333a(i3, ErrorCode.CANCEL);
                        }
                        if (onData || z2) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.f5457r.remove(Integer.valueOf(i3));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo25249c(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        m3455a((NamedRunnable) new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.f5444e, Integer.valueOf(i)}) {
            public void execute() {
                Http2Connection.this.f5448i.onReset(i2, errorCode2);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f5457r.remove(Integer.valueOf(i2));
                }
            }
        });
    }

    /* renamed from: a */
    private synchronized void m3455a(NamedRunnable namedRunnable) {
        if (!isShutdown()) {
            this.f5459v.execute(namedRunnable);
        }
    }
}

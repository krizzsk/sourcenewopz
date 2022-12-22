package didihttp.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream {

    /* renamed from: i */
    static final /* synthetic */ boolean f56810i = (!Http2Stream.class.desiredAssertionStatus());

    /* renamed from: a */
    long f56811a = 0;

    /* renamed from: b */
    long f56812b;

    /* renamed from: c */
    final int f56813c;

    /* renamed from: d */
    final Http2Connection f56814d;

    /* renamed from: e */
    final FramingSink f56815e;

    /* renamed from: f */
    final StreamTimeout f56816f = new StreamTimeout();

    /* renamed from: g */
    final StreamTimeout f56817g = new StreamTimeout();

    /* renamed from: h */
    ErrorCode f56818h = null;

    /* renamed from: j */
    private final List<Header> f56819j;

    /* renamed from: k */
    private List<Header> f56820k;

    /* renamed from: l */
    private boolean f56821l;

    /* renamed from: m */
    private final FramingSource f56822m;

    Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, List<Header> list) {
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.f56813c = i;
            this.f56814d = http2Connection;
            this.f56812b = (long) http2Connection.f56796m.mo170185d();
            this.f56822m = new FramingSource((long) http2Connection.f56795l.mo170185d());
            this.f56815e = new FramingSink();
            this.f56822m.finished = z2;
            this.f56815e.finished = z;
            this.f56819j = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    public int getId() {
        return this.f56813c;
    }

    public synchronized boolean isOpen() {
        if (this.f56818h != null) {
            return false;
        }
        if ((this.f56822m.finished || this.f56822m.closed) && ((this.f56815e.finished || this.f56815e.closed) && this.f56821l)) {
            return false;
        }
        return true;
    }

    public boolean isLocallyInitiated() {
        if (this.f56814d.f56785b == ((this.f56813c & 1) == 1)) {
            return true;
        }
        return false;
    }

    public Http2Connection getConnection() {
        return this.f56814d;
    }

    public List<Header> getRequestHeaders() {
        return this.f56819j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
        r2.f56816f.exitAndThrowIfTimedOut();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<didihttp.internal.http2.Header> takeResponseHeaders() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isLocallyInitiated()     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0035
            didihttp.internal.http2.Http2Stream$StreamTimeout r0 = r2.f56816f     // Catch:{ all -> 0x003d }
            r0.enter()     // Catch:{ all -> 0x003d }
        L_0x000c:
            java.util.List<didihttp.internal.http2.Header> r0 = r2.f56820k     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0018
            didihttp.internal.http2.ErrorCode r0 = r2.f56818h     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0018
            r2.mo170154d()     // Catch:{ all -> 0x002e }
            goto L_0x000c
        L_0x0018:
            didihttp.internal.http2.Http2Stream$StreamTimeout r0 = r2.f56816f     // Catch:{ all -> 0x003d }
            r0.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x003d }
            java.util.List<didihttp.internal.http2.Header> r0 = r2.f56820k     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0026
            r1 = 0
            r2.f56820k = r1     // Catch:{ all -> 0x003d }
            monitor-exit(r2)
            return r0
        L_0x0026:
            didihttp.internal.http2.StreamResetException r0 = new didihttp.internal.http2.StreamResetException     // Catch:{ all -> 0x003d }
            didihttp.internal.http2.ErrorCode r1 = r2.f56818h     // Catch:{ all -> 0x003d }
            r0.<init>(r1)     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x002e:
            r0 = move-exception
            didihttp.internal.http2.Http2Stream$StreamTimeout r1 = r2.f56816f     // Catch:{ all -> 0x003d }
            r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x0035:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x003d }
            java.lang.String r1 = "servers cannot read response headers"
            r0.<init>(r1)     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x003d:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.http2.Http2Stream.takeResponseHeaders():java.util.List");
    }

    public synchronized ErrorCode getErrorCode() {
        return this.f56818h;
    }

    public void sendResponseHeaders(List<Header> list, boolean z) throws IOException {
        if (!f56810i && Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (list != null) {
            boolean z2 = false;
            synchronized (this) {
                this.f56821l = true;
                if (!z) {
                    this.f56815e.finished = true;
                    z2 = true;
                }
            }
            this.f56814d.mo170102a(this.f56813c, z2, list);
            if (z2) {
                this.f56814d.flush();
            }
        } else {
            throw new NullPointerException("responseHeaders == null");
        }
    }

    public Timeout readTimeout() {
        return this.f56816f;
    }

    public Timeout writeTimeout() {
        return this.f56817g;
    }

    public Source getSource() {
        return this.f56822m;
    }

    public Sink getSink() {
        synchronized (this) {
            if (!this.f56821l) {
                if (!isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f56815e;
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (m40759b(errorCode)) {
            this.f56814d.mo170108b(this.f56813c, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (m40759b(errorCode)) {
            this.f56814d.mo170098a(this.f56813c, errorCode);
        }
    }

    /* renamed from: b */
    private boolean m40759b(ErrorCode errorCode) {
        if (f56810i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f56818h != null) {
                    return false;
                }
                if (this.f56822m.finished && this.f56815e.finished) {
                    return false;
                }
                this.f56818h = errorCode;
                notifyAll();
                this.f56814d.mo170107b(this.f56813c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170148a(List<Header> list) {
        boolean z;
        if (f56810i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = true;
                this.f56821l = true;
                if (this.f56820k == null) {
                    this.f56820k = list;
                    z = isOpen();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f56820k);
                    arrayList.add((Object) null);
                    arrayList.addAll(list);
                    this.f56820k = arrayList;
                }
            }
            if (!z) {
                this.f56814d.mo170107b(this.f56813c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170149a(BufferedSource bufferedSource, int i) throws IOException {
        if (f56810i || !Thread.holdsLock(this)) {
            this.f56822m.receive(bufferedSource, (long) i);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170145a() {
        boolean isOpen;
        if (f56810i || !Thread.holdsLock(this)) {
            synchronized (this) {
                this.f56822m.finished = true;
                isOpen = isOpen();
                notifyAll();
            }
            if (!isOpen) {
                this.f56814d.mo170107b(this.f56813c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo170147a(ErrorCode errorCode) {
        if (this.f56818h == null) {
            this.f56818h = errorCode;
            notifyAll();
        }
    }

    private final class FramingSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer = new Buffer();
        private final Buffer receiveBuffer = new Buffer();

        static {
            Class<Http2Stream> cls = Http2Stream.class;
        }

        FramingSource(long j) {
            this.maxByteCount = j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
            r10 = r7.this$0.f56814d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r7.this$0.f56814d.f56793j += r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0080, code lost:
            if (r7.this$0.f56814d.f56793j < ((long) (r7.this$0.f56814d.f56795l.mo170185d() / 2))) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
            r7.this$0.f56814d.mo170097a(0, r7.this$0.f56814d.f56793j);
            r7.this$0.f56814d.f56793j = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0096, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0097, code lost:
            return r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(okio.Buffer r8, long r9) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 < 0) goto L_0x009e
                didihttp.internal.http2.Http2Stream r2 = didihttp.internal.http2.Http2Stream.this
                monitor-enter(r2)
                r7.waitUntilReadable()     // Catch:{ all -> 0x009b }
                r7.checkNotClosed()     // Catch:{ all -> 0x009b }
                okio.Buffer r3 = r7.readBuffer     // Catch:{ all -> 0x009b }
                long r3 = r3.size()     // Catch:{ all -> 0x009b }
                int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r5 != 0) goto L_0x001d
                r8 = -1
                monitor-exit(r2)     // Catch:{ all -> 0x009b }
                return r8
            L_0x001d:
                okio.Buffer r3 = r7.readBuffer     // Catch:{ all -> 0x009b }
                okio.Buffer r4 = r7.readBuffer     // Catch:{ all -> 0x009b }
                long r4 = r4.size()     // Catch:{ all -> 0x009b }
                long r9 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x009b }
                long r8 = r3.read(r8, r9)     // Catch:{ all -> 0x009b }
                didihttp.internal.http2.Http2Stream r10 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x009b }
                long r3 = r10.f56811a     // Catch:{ all -> 0x009b }
                long r3 = r3 + r8
                r10.f56811a = r3     // Catch:{ all -> 0x009b }
                didihttp.internal.http2.Http2Stream r10 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x009b }
                long r3 = r10.f56811a     // Catch:{ all -> 0x009b }
                didihttp.internal.http2.Http2Stream r10 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x009b }
                didihttp.internal.http2.Http2Connection r10 = r10.f56814d     // Catch:{ all -> 0x009b }
                didihttp.internal.http2.Settings r10 = r10.f56795l     // Catch:{ all -> 0x009b }
                int r10 = r10.mo170185d()     // Catch:{ all -> 0x009b }
                int r10 = r10 / 2
                long r5 = (long) r10     // Catch:{ all -> 0x009b }
                int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r10 < 0) goto L_0x005c
                didihttp.internal.http2.Http2Stream r10 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x009b }
                didihttp.internal.http2.Http2Connection r10 = r10.f56814d     // Catch:{ all -> 0x009b }
                didihttp.internal.http2.Http2Stream r3 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x009b }
                int r3 = r3.f56813c     // Catch:{ all -> 0x009b }
                didihttp.internal.http2.Http2Stream r4 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x009b }
                long r4 = r4.f56811a     // Catch:{ all -> 0x009b }
                r10.mo170097a((int) r3, (long) r4)     // Catch:{ all -> 0x009b }
                didihttp.internal.http2.Http2Stream r10 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x009b }
                r10.f56811a = r0     // Catch:{ all -> 0x009b }
            L_0x005c:
                monitor-exit(r2)     // Catch:{ all -> 0x009b }
                didihttp.internal.http2.Http2Stream r10 = didihttp.internal.http2.Http2Stream.this
                didihttp.internal.http2.Http2Connection r10 = r10.f56814d
                monitor-enter(r10)
                didihttp.internal.http2.Http2Stream r2 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0098 }
                didihttp.internal.http2.Http2Connection r2 = r2.f56814d     // Catch:{ all -> 0x0098 }
                long r3 = r2.f56793j     // Catch:{ all -> 0x0098 }
                long r3 = r3 + r8
                r2.f56793j = r3     // Catch:{ all -> 0x0098 }
                didihttp.internal.http2.Http2Stream r2 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0098 }
                didihttp.internal.http2.Http2Connection r2 = r2.f56814d     // Catch:{ all -> 0x0098 }
                long r2 = r2.f56793j     // Catch:{ all -> 0x0098 }
                didihttp.internal.http2.Http2Stream r4 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0098 }
                didihttp.internal.http2.Http2Connection r4 = r4.f56814d     // Catch:{ all -> 0x0098 }
                didihttp.internal.http2.Settings r4 = r4.f56795l     // Catch:{ all -> 0x0098 }
                int r4 = r4.mo170185d()     // Catch:{ all -> 0x0098 }
                int r4 = r4 / 2
                long r4 = (long) r4     // Catch:{ all -> 0x0098 }
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 < 0) goto L_0x0096
                didihttp.internal.http2.Http2Stream r2 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0098 }
                didihttp.internal.http2.Http2Connection r2 = r2.f56814d     // Catch:{ all -> 0x0098 }
                r3 = 0
                didihttp.internal.http2.Http2Stream r4 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0098 }
                didihttp.internal.http2.Http2Connection r4 = r4.f56814d     // Catch:{ all -> 0x0098 }
                long r4 = r4.f56793j     // Catch:{ all -> 0x0098 }
                r2.mo170097a((int) r3, (long) r4)     // Catch:{ all -> 0x0098 }
                didihttp.internal.http2.Http2Stream r2 = didihttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0098 }
                didihttp.internal.http2.Http2Connection r2 = r2.f56814d     // Catch:{ all -> 0x0098 }
                r2.f56793j = r0     // Catch:{ all -> 0x0098 }
            L_0x0096:
                monitor-exit(r10)     // Catch:{ all -> 0x0098 }
                return r8
            L_0x0098:
                r8 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x0098 }
                throw r8
            L_0x009b:
                r8 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x009b }
                throw r8
            L_0x009e:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.http2.Http2Stream.FramingSource.read(okio.Buffer, long):long");
        }

        private void waitUntilReadable() throws IOException {
            Http2Stream.this.f56816f.enter();
            while (this.readBuffer.size() == 0 && !this.finished && !this.closed && Http2Stream.this.f56818h == null) {
                try {
                    Http2Stream.this.mo170154d();
                } finally {
                    Http2Stream.this.f56816f.exitAndThrowIfTimedOut();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void receive(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.size() + j > this.maxByteCount;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long read = bufferedSource.read(this.receiveBuffer, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (Http2Stream.this) {
                            if (this.readBuffer.size() != 0) {
                                z2 = false;
                            }
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (z2) {
                                Http2Stream.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public Timeout timeout() {
            return Http2Stream.this.f56816f;
        }

        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                this.closed = true;
                this.readBuffer.clear();
                Http2Stream.this.notifyAll();
            }
            Http2Stream.this.mo170150b();
        }

        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            } else if (Http2Stream.this.f56818h != null) {
                throw new StreamResetException(Http2Stream.this.f56818h);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo170150b() throws IOException {
        boolean z;
        boolean isOpen;
        if (f56810i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.f56822m.finished && this.f56822m.closed && (this.f56815e.finished || this.f56815e.closed);
                isOpen = isOpen();
            }
            if (z) {
                close(ErrorCode.CANCEL);
            } else if (!isOpen) {
                this.f56814d.mo170107b(this.f56813c);
            }
        } else {
            throw new AssertionError();
        }
    }

    final class FramingSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final Buffer sendBuffer = new Buffer();

        static {
            Class<Http2Stream> cls = Http2Stream.class;
        }

        FramingSink() {
        }

        public void write(Buffer buffer, long j) throws IOException {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.size() >= 16384) {
                emitFrame(false);
            }
        }

        /* JADX INFO: finally extract failed */
        private void emitFrame(boolean z) throws IOException {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.f56817g.enter();
                while (Http2Stream.this.f56812b <= 0 && !this.finished && !this.closed && Http2Stream.this.f56818h == null) {
                    try {
                        Http2Stream.this.mo170154d();
                    } catch (Throwable th) {
                        Http2Stream.this.f56817g.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                Http2Stream.this.f56817g.exitAndThrowIfTimedOut();
                Http2Stream.this.mo170151c();
                min = Math.min(Http2Stream.this.f56812b, this.sendBuffer.size());
                Http2Stream.this.f56812b -= min;
            }
            Http2Stream.this.f56817g.enter();
            try {
                Http2Stream.this.f56814d.writeData(Http2Stream.this.f56813c, z && min == this.sendBuffer.size(), this.sendBuffer, min);
            } finally {
                Http2Stream.this.f56817g.exitAndThrowIfTimedOut();
            }
        }

        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.mo170151c();
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.f56814d.flush();
            }
        }

        public Timeout timeout() {
            return Http2Stream.this.f56817g;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            if (r8.sendBuffer.size() <= 0) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (r8.sendBuffer.size() <= 0) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            emitFrame(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
            r8.this$0.f56814d.writeData(r8.this$0.f56813c, true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
            r2 = r8.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8.closed = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
            r8.this$0.f56814d.flush();
            r8.this$0.mo170150b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.this$0.f56815e.finished != false) goto L_0x003c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r8 = this;
                didihttp.internal.http2.Http2Stream r0 = didihttp.internal.http2.Http2Stream.this
                monitor-enter(r0)
                boolean r1 = r8.closed     // Catch:{ all -> 0x0052 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0052 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x0052 }
                didihttp.internal.http2.Http2Stream r0 = didihttp.internal.http2.Http2Stream.this
                didihttp.internal.http2.Http2Stream$FramingSink r0 = r0.f56815e
                boolean r0 = r0.finished
                r1 = 1
                if (r0 != 0) goto L_0x003c
                okio.Buffer r0 = r8.sendBuffer
                long r2 = r0.size()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002d
            L_0x001f:
                okio.Buffer r0 = r8.sendBuffer
                long r2 = r0.size()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003c
                r8.emitFrame(r1)
                goto L_0x001f
            L_0x002d:
                didihttp.internal.http2.Http2Stream r0 = didihttp.internal.http2.Http2Stream.this
                didihttp.internal.http2.Http2Connection r2 = r0.f56814d
                didihttp.internal.http2.Http2Stream r0 = didihttp.internal.http2.Http2Stream.this
                int r3 = r0.f56813c
                r4 = 1
                r5 = 0
                r6 = 0
                r2.writeData(r3, r4, r5, r6)
            L_0x003c:
                didihttp.internal.http2.Http2Stream r2 = didihttp.internal.http2.Http2Stream.this
                monitor-enter(r2)
                r8.closed = r1     // Catch:{ all -> 0x004f }
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                didihttp.internal.http2.Http2Stream r0 = didihttp.internal.http2.Http2Stream.this
                didihttp.internal.http2.Http2Connection r0 = r0.f56814d
                r0.flush()
                didihttp.internal.http2.Http2Stream r0 = didihttp.internal.http2.Http2Stream.this
                r0.mo170150b()
                return
            L_0x004f:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                throw r0
            L_0x0052:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0052 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.http2.Http2Stream.FramingSink.close():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170146a(long j) {
        this.f56812b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo170151c() throws IOException {
        if (this.f56815e.closed) {
            throw new IOException("stream closed");
        } else if (this.f56815e.finished) {
            throw new IOException("stream finished");
        } else if (this.f56818h != null) {
            throw new StreamResetException(this.f56818h);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo170154d() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
        }

        /* access modifiers changed from: protected */
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }
    }
}

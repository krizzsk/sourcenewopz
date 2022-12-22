package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.C2434Util;
import okhttp3.internal.http2.Header;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream {

    /* renamed from: i */
    static final /* synthetic */ boolean f5466i = (!Http2Stream.class.desiredAssertionStatus());

    /* renamed from: a */
    long f5467a = 0;

    /* renamed from: b */
    long f5468b;

    /* renamed from: c */
    final int f5469c;

    /* renamed from: d */
    final Http2Connection f5470d;

    /* renamed from: e */
    final FramingSink f5471e;

    /* renamed from: f */
    final StreamTimeout f5472f = new StreamTimeout();

    /* renamed from: g */
    final StreamTimeout f5473g = new StreamTimeout();

    /* renamed from: h */
    ErrorCode f5474h = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Deque<Headers> f5475j = new ArrayDeque();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Header.Listener f5476k;

    /* renamed from: l */
    private boolean f5477l;

    /* renamed from: m */
    private final FramingSource f5478m;

    Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, @Nullable Headers headers) {
        if (http2Connection != null) {
            this.f5469c = i;
            this.f5470d = http2Connection;
            this.f5468b = (long) http2Connection.f5452m.mo25324d();
            this.f5478m = new FramingSource((long) http2Connection.f5451l.mo25324d());
            this.f5471e = new FramingSink();
            this.f5478m.finished = z2;
            this.f5471e.finished = z;
            if (headers != null) {
                this.f5475j.add(headers);
            }
            if (isLocallyInitiated() && headers != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!isLocallyInitiated() && headers == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    public int getId() {
        return this.f5469c;
    }

    public synchronized boolean isOpen() {
        if (this.f5474h != null) {
            return false;
        }
        if ((this.f5478m.finished || this.f5478m.closed) && ((this.f5471e.finished || this.f5471e.closed) && this.f5477l)) {
            return false;
        }
        return true;
    }

    public boolean isLocallyInitiated() {
        if (this.f5470d.f5441b == ((this.f5469c & 1) == 1)) {
            return true;
        }
        return false;
    }

    public Http2Connection getConnection() {
        return this.f5470d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r2.f5472f.exitAndThrowIfTimedOut();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.Headers takeHeaders() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.f5472f     // Catch:{ all -> 0x003c }
            r0.enter()     // Catch:{ all -> 0x003c }
        L_0x0006:
            java.util.Deque<okhttp3.Headers> r0 = r2.f5475j     // Catch:{ all -> 0x0035 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0016
            okhttp3.internal.http2.ErrorCode r0 = r2.f5474h     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0016
            r2.mo25292d()     // Catch:{ all -> 0x0035 }
            goto L_0x0006
        L_0x0016:
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.f5472f     // Catch:{ all -> 0x003c }
            r0.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x003c }
            java.util.Deque<okhttp3.Headers> r0 = r2.f5475j     // Catch:{ all -> 0x003c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x002d
            java.util.Deque<okhttp3.Headers> r0 = r2.f5475j     // Catch:{ all -> 0x003c }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x003c }
            okhttp3.Headers r0 = (okhttp3.Headers) r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)
            return r0
        L_0x002d:
            okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x003c }
            okhttp3.internal.http2.ErrorCode r1 = r2.f5474h     // Catch:{ all -> 0x003c }
            r0.<init>(r1)     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x0035:
            r0 = move-exception
            okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r2.f5472f     // Catch:{ all -> 0x003c }
            r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.takeHeaders():okhttp3.Headers");
    }

    public synchronized ErrorCode getErrorCode() {
        return this.f5474h;
    }

    public void writeHeaders(List<Header> list, boolean z) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        if (!f5466i && Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (list != null) {
            synchronized (this) {
                z2 = true;
                this.f5477l = true;
                if (!z) {
                    this.f5471e.finished = true;
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
            }
            if (!z3) {
                synchronized (this.f5470d) {
                    if (this.f5470d.f5450k != 0) {
                        z2 = false;
                    }
                }
                z3 = z2;
            }
            this.f5470d.mo25241a(this.f5469c, z4, list);
            if (z3) {
                this.f5470d.flush();
            }
        } else {
            throw new NullPointerException("headers == null");
        }
    }

    public Timeout readTimeout() {
        return this.f5472f;
    }

    public Timeout writeTimeout() {
        return this.f5473g;
    }

    public Source getSource() {
        return this.f5478m;
    }

    public Sink getSink() {
        synchronized (this) {
            if (!this.f5477l) {
                if (!isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f5471e;
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (m3496b(errorCode)) {
            this.f5470d.mo25248b(this.f5469c, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (m3496b(errorCode)) {
            this.f5470d.mo25239a(this.f5469c, errorCode);
        }
    }

    /* renamed from: b */
    private boolean m3496b(ErrorCode errorCode) {
        if (f5466i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f5474h != null) {
                    return false;
                }
                if (this.f5478m.finished && this.f5471e.finished) {
                    return false;
                }
                this.f5474h = errorCode;
                notifyAll();
                this.f5470d.mo25246b(this.f5469c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25285a(List<Header> list) {
        boolean isOpen;
        if (f5466i || !Thread.holdsLock(this)) {
            synchronized (this) {
                this.f5477l = true;
                this.f5475j.add(C2434Util.toHeaders(list));
                isOpen = isOpen();
                notifyAll();
            }
            if (!isOpen) {
                this.f5470d.mo25246b(this.f5469c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25287a(BufferedSource bufferedSource, int i) throws IOException {
        if (f5466i || !Thread.holdsLock(this)) {
            this.f5478m.receive(bufferedSource, (long) i);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25283a() {
        boolean isOpen;
        if (f5466i || !Thread.holdsLock(this)) {
            synchronized (this) {
                this.f5478m.finished = true;
                isOpen = isOpen();
                notifyAll();
            }
            if (!isOpen) {
                this.f5470d.mo25246b(this.f5469c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo25286a(ErrorCode errorCode) {
        if (this.f5474h == null) {
            this.f5474h = errorCode;
            notifyAll();
        }
    }

    public synchronized void setHeadersListener(Header.Listener listener) {
        this.f5476k = listener;
        if (!this.f5475j.isEmpty() && listener != null) {
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

        public long read(Buffer buffer, long j) throws IOException {
            ErrorCode errorCode;
            long j2;
            Header.Listener listener;
            Headers headers;
            long j3 = j;
            if (j3 >= 0) {
                while (true) {
                    synchronized (Http2Stream.this) {
                        Http2Stream.this.f5472f.enter();
                        try {
                            errorCode = Http2Stream.this.f5474h != null ? Http2Stream.this.f5474h : null;
                            if (!this.closed) {
                                if (Http2Stream.this.f5475j.isEmpty() || Http2Stream.this.f5476k == null) {
                                    if (this.readBuffer.size() > 0) {
                                        j2 = this.readBuffer.read(buffer, Math.min(j3, this.readBuffer.size()));
                                        Http2Stream.this.f5467a += j2;
                                        if (errorCode == null && Http2Stream.this.f5467a >= ((long) (Http2Stream.this.f5470d.f5451l.mo25324d() / 2))) {
                                            Http2Stream.this.f5470d.mo25236a(Http2Stream.this.f5469c, Http2Stream.this.f5467a);
                                            Http2Stream.this.f5467a = 0;
                                        }
                                    } else {
                                        Buffer buffer2 = buffer;
                                        if (this.finished || errorCode != null) {
                                            j2 = -1;
                                        } else {
                                            Http2Stream.this.mo25292d();
                                        }
                                    }
                                    headers = null;
                                    listener = null;
                                } else {
                                    headers = (Headers) Http2Stream.this.f5475j.removeFirst();
                                    listener = Http2Stream.this.f5476k;
                                    Buffer buffer3 = buffer;
                                    j2 = -1;
                                }
                                Http2Stream.this.f5472f.exitAndThrowIfTimedOut();
                                if (headers != null && listener != null) {
                                    listener.onHeaders(headers);
                                }
                            } else {
                                throw new IOException("stream closed");
                            }
                        } finally {
                            Http2Stream.this.f5472f.exitAndThrowIfTimedOut();
                        }
                    }
                }
                if (j2 != -1) {
                    updateConnectionFlowControl(j2);
                    return j2;
                } else if (errorCode == null) {
                    return -1;
                } else {
                    throw new StreamResetException(errorCode);
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: " + j3);
            }
        }

        private void updateConnectionFlowControl(long j) {
            Http2Stream.this.f5470d.mo25242a(j);
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
            return Http2Stream.this.f5472f;
        }

        public void close() throws IOException {
            long size;
            Header.Listener listener;
            ArrayList<Headers> arrayList;
            synchronized (Http2Stream.this) {
                this.closed = true;
                size = this.readBuffer.size();
                this.readBuffer.clear();
                listener = null;
                if (Http2Stream.this.f5475j.isEmpty() || Http2Stream.this.f5476k == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(Http2Stream.this.f5475j);
                    Http2Stream.this.f5475j.clear();
                    ArrayList arrayList3 = arrayList2;
                    listener = Http2Stream.this.f5476k;
                    arrayList = arrayList3;
                }
                Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            Http2Stream.this.mo25288b();
            if (listener != null) {
                for (Headers onHeaders : arrayList) {
                    listener.onHeaders(onHeaders);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25288b() throws IOException {
        boolean z;
        boolean isOpen;
        if (f5466i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.f5478m.finished && this.f5478m.closed && (this.f5471e.finished || this.f5471e.closed);
                isOpen = isOpen();
            }
            if (z) {
                close(ErrorCode.CANCEL);
            } else if (!isOpen) {
                this.f5470d.mo25246b(this.f5469c);
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
                Http2Stream.this.f5473g.enter();
                while (Http2Stream.this.f5468b <= 0 && !this.finished && !this.closed && Http2Stream.this.f5474h == null) {
                    try {
                        Http2Stream.this.mo25292d();
                    } catch (Throwable th) {
                        Http2Stream.this.f5473g.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                Http2Stream.this.f5473g.exitAndThrowIfTimedOut();
                Http2Stream.this.mo25289c();
                min = Math.min(Http2Stream.this.f5468b, this.sendBuffer.size());
                Http2Stream.this.f5468b -= min;
            }
            Http2Stream.this.f5473g.enter();
            try {
                Http2Stream.this.f5470d.writeData(Http2Stream.this.f5469c, z && min == this.sendBuffer.size(), this.sendBuffer, min);
            } finally {
                Http2Stream.this.f5473g.exitAndThrowIfTimedOut();
            }
        }

        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.mo25289c();
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.f5470d.flush();
            }
        }

        public Timeout timeout() {
            return Http2Stream.this.f5473g;
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
            r8.this$0.f5470d.writeData(r8.this$0.f5469c, true, (okio.Buffer) null, 0);
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
            r8.this$0.f5470d.flush();
            r8.this$0.mo25288b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.this$0.f5471e.finished != false) goto L_0x003c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r8 = this;
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                boolean r1 = r8.closed     // Catch:{ all -> 0x0052 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0052 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x0052 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$FramingSink r0 = r0.f5471e
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
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r2 = r0.f5470d
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                int r3 = r0.f5469c
                r4 = 1
                r5 = 0
                r6 = 0
                r2.writeData(r3, r4, r5, r6)
            L_0x003c:
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r2)
                r8.closed = r1     // Catch:{ all -> 0x004f }
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r0 = r0.f5470d
                r0.flush()
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                r0.mo25288b()
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
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSink.close():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25284a(long j) {
        this.f5468b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo25289c() throws IOException {
        if (this.f5471e.closed) {
            throw new IOException("stream closed");
        } else if (this.f5471e.finished) {
            throw new IOException("stream finished");
        } else if (this.f5474h != null) {
            throw new StreamResetException(this.f5474h);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo25292d() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
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

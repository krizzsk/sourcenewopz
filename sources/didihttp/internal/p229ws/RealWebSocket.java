package didihttp.internal.p229ws;

import com.didichuxing.diface.logger.DiFaceLogger;
import com.google.common.net.HttpHeaders;
import didihttp.Call;
import didihttp.Callback;
import didihttp.DidiHttpClient;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.Response;
import didihttp.WebSocket;
import didihttp.WebSocketListener;
import didihttp.internal.C20747Util;
import didihttp.internal.Internal;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.p229ws.WebSocketReader;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: didihttp.internal.ws.RealWebSocket */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {

    /* renamed from: d */
    static final /* synthetic */ boolean f56912d = (!RealWebSocket.class.desiredAssertionStatus());

    /* renamed from: e */
    private static final List<Protocol> f56913e = Collections.singletonList(Protocol.HTTP_1_1);

    /* renamed from: f */
    private static final long f56914f = 16777216;

    /* renamed from: g */
    private static final long f56915g = 60000;

    /* renamed from: a */
    final WebSocketListener f56916a;

    /* renamed from: b */
    int f56917b;

    /* renamed from: c */
    int f56918c;

    /* renamed from: h */
    private final Request f56919h;

    /* renamed from: i */
    private final Random f56920i;

    /* renamed from: j */
    private final String f56921j;

    /* renamed from: k */
    private Call f56922k;

    /* renamed from: l */
    private final Runnable f56923l;

    /* renamed from: m */
    private WebSocketReader f56924m;

    /* renamed from: n */
    private WebSocketWriter f56925n;

    /* renamed from: o */
    private ScheduledExecutorService f56926o;

    /* renamed from: p */
    private Streams f56927p;

    /* renamed from: q */
    private final ArrayDeque<ByteString> f56928q = new ArrayDeque<>();

    /* renamed from: r */
    private final ArrayDeque<Object> f56929r = new ArrayDeque<>();

    /* renamed from: s */
    private long f56930s;

    /* renamed from: t */
    private boolean f56931t;

    /* renamed from: u */
    private ScheduledFuture<?> f56932u;

    /* renamed from: v */
    private int f56933v = -1;

    /* renamed from: w */
    private String f56934w;

    /* renamed from: x */
    private boolean f56935x;

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random) {
        if ("GET".equals(request.method())) {
            this.f56919h = request;
            this.f56916a = webSocketListener;
            this.f56920i = random;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.f56921j = ByteString.m3607of(bArr).base64();
            this.f56923l = new Runnable() {
                public void run() {
                    do {
                        try {
                        } catch (IOException e) {
                            RealWebSocket.this.failWebSocket(e, (Response) null);
                            return;
                        }
                    } while (RealWebSocket.this.mo170379e());
                }
            };
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.method());
    }

    public Request request() {
        return this.f56919h;
    }

    public synchronized long queueSize() {
        return this.f56930s;
    }

    public void cancel() {
        this.f56922k.cancel();
    }

    public void connect(DidiHttpClient didiHttpClient) {
        DidiHttpClient build = didiHttpClient.newBuilder().protocols(f56913e).build();
        final int pingIntervalMillis = build.pingIntervalMillis();
        final Request build2 = this.f56919h.newBuilder().header(HttpHeaders.UPGRADE, p242io.socket.engineio.client.transports.WebSocket.NAME).header(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE).header(HttpHeaders.SEC_WEBSOCKET_KEY, this.f56921j).header(HttpHeaders.SEC_WEBSOCKET_VERSION, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS).build();
        Call newWebSocketCall = Internal.instance.newWebSocketCall(build, build2);
        this.f56922k = newWebSocketCall;
        newWebSocketCall.enqueue(new Callback() {
            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.mo170371a(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket.this.f56916a.onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), (long) pingIntervalMillis, newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, (Response) null);
                    }
                } catch (ProtocolException e2) {
                    RealWebSocket.this.failWebSocket(e2, response);
                    C20747Util.closeQuietly((Closeable) response);
                }
            }

            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, (Response) null);
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170371a(Response response) throws ProtocolException {
        if (response.code() == 101) {
            String header = response.header(HttpHeaders.CONNECTION);
            if (HttpHeaders.UPGRADE.equalsIgnoreCase(header)) {
                String header2 = response.header(HttpHeaders.UPGRADE);
                if (p242io.socket.engineio.client.transports.WebSocket.NAME.equalsIgnoreCase(header2)) {
                    String header3 = response.header(HttpHeaders.SEC_WEBSOCKET_ACCEPT);
                    String base64 = ByteString.encodeUtf8(this.f56921j + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
                    if (!base64.equals(header3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header3 + "'");
                    }
                    return;
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
    }

    public void initReaderAndWriter(String str, long j, Streams streams) throws IOException {
        synchronized (this) {
            this.f56927p = streams;
            this.f56925n = new WebSocketWriter(streams.client, streams.sink, this.f56920i);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C20747Util.threadFactory(str, false));
            this.f56926o = scheduledThreadPoolExecutor;
            if (j != 0) {
                scheduledThreadPoolExecutor.scheduleAtFixedRate(new PingRunnable(), j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.f56929r.isEmpty()) {
                m40866g();
            }
        }
        this.f56924m = new WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws IOException {
        while (this.f56933v == -1) {
            this.f56924m.mo170392a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo170372a() throws IOException {
        try {
            this.f56924m.mo170392a();
            if (this.f56933v == -1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            failWebSocket(e, (Response) null);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170370a(int i, TimeUnit timeUnit) throws InterruptedException {
        this.f56926o.awaitTermination((long) i, timeUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo170375b() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.f56932u;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f56926o.shutdown();
        this.f56926o.awaitTermination(10, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized int mo170376c() {
        return this.f56917b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized int mo170378d() {
        return this.f56918c;
    }

    public void onReadMessage(String str) throws IOException {
        this.f56916a.onMessage((WebSocket) this, str);
    }

    public void onReadMessage(ByteString byteString) throws IOException {
        this.f56916a.onMessage((WebSocket) this, byteString);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f56935x     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0022
            boolean r0 = r1.f56931t     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            java.util.ArrayDeque<java.lang.Object> r0 = r1.f56929r     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            goto L_0x0022
        L_0x0012:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.f56928q     // Catch:{ all -> 0x0024 }
            r0.add(r2)     // Catch:{ all -> 0x0024 }
            r1.m40866g()     // Catch:{ all -> 0x0024 }
            int r2 = r1.f56917b     // Catch:{ all -> 0x0024 }
            int r2 = r2 + 1
            r1.f56917b = r2     // Catch:{ all -> 0x0024 }
            monitor-exit(r1)
            return
        L_0x0022:
            monitor-exit(r1)
            return
        L_0x0024:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.p229ws.RealWebSocket.onReadPing(okio.ByteString):void");
    }

    public synchronized void onReadPong(ByteString byteString) {
        this.f56918c++;
    }

    public void onReadClose(int i, String str) {
        Streams streams;
        if (i != -1) {
            synchronized (this) {
                if (this.f56933v == -1) {
                    this.f56933v = i;
                    this.f56934w = str;
                    streams = null;
                    if (this.f56931t && this.f56929r.isEmpty()) {
                        Streams streams2 = this.f56927p;
                        this.f56927p = streams;
                        if (this.f56932u != null) {
                            this.f56932u.cancel(false);
                        }
                        this.f56926o.shutdown();
                        streams = streams2;
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.f56916a.onClosing(this, i, str);
                if (streams != null) {
                    this.f56916a.onClosed(this, i, str);
                }
            } finally {
                C20747Util.closeQuietly((Closeable) streams);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean send(String str) {
        if (str != null) {
            return m40865a(ByteString.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public boolean send(ByteString byteString) {
        if (byteString != null) {
            return m40865a(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean m40865a(okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f56935x     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 != 0) goto L_0x003c
            boolean r0 = r6.f56931t     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000b
            goto L_0x003c
        L_0x000b:
            long r2 = r6.f56930s     // Catch:{ all -> 0x003e }
            int r0 = r7.size()     // Catch:{ all -> 0x003e }
            long r4 = (long) r0     // Catch:{ all -> 0x003e }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            r7 = 1001(0x3e9, float:1.403E-42)
            r8 = 0
            r6.close(r7, r8)     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            return r1
        L_0x0022:
            long r0 = r6.f56930s     // Catch:{ all -> 0x003e }
            int r2 = r7.size()     // Catch:{ all -> 0x003e }
            long r2 = (long) r2     // Catch:{ all -> 0x003e }
            long r0 = r0 + r2
            r6.f56930s = r0     // Catch:{ all -> 0x003e }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.f56929r     // Catch:{ all -> 0x003e }
            didihttp.internal.ws.RealWebSocket$Message r1 = new didihttp.internal.ws.RealWebSocket$Message     // Catch:{ all -> 0x003e }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            r6.m40866g()     // Catch:{ all -> 0x003e }
            r7 = 1
            monitor-exit(r6)
            return r7
        L_0x003c:
            monitor-exit(r6)
            return r1
        L_0x003e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.p229ws.RealWebSocket.m40865a(okio.ByteString, int):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo170374a(ByteString byteString) {
        if (!this.f56935x) {
            if (!this.f56931t || !this.f56929r.isEmpty()) {
                this.f56928q.add(byteString);
                m40866g();
                return true;
            }
        }
        return false;
    }

    public boolean close(int i, String str) {
        return mo170373a(i, str, 60000);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo170373a(int i, String str, long j) {
        WebSocketProtocol.m40879b(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (((long) byteString.size()) > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.f56935x) {
            if (!this.f56931t) {
                this.f56931t = true;
                this.f56929r.add(new Close(i, byteString, j));
                m40866g();
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private void m40866g() {
        if (f56912d || Thread.holdsLock(this)) {
            ScheduledExecutorService scheduledExecutorService = this.f56926o;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.execute(this.f56923l);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r2 == null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0.mo170398b(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        if ((r4 instanceof didihttp.internal.p229ws.RealWebSocket.Message) == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        r2 = ((didihttp.internal.p229ws.RealWebSocket.Message) r4).data;
        r0 = okio.Okio.buffer(r0.mo170394a(((didihttp.internal.p229ws.RealWebSocket.Message) r4).formatOpcode, (long) r2.size()));
        r0.write(r2);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        monitor-enter(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r12.f56930s -= (long) r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
        monitor-exit(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008e, code lost:
        if ((r4 instanceof didihttp.internal.p229ws.RealWebSocket.Close) == false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0090, code lost:
        r4 = (didihttp.internal.p229ws.RealWebSocket.Close) r4;
        r0.mo170396a(r4.code, r4.reason);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (r1 == null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009b, code lost:
        r12.f56916a.onClosed(r12, r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a0, code lost:
        didihttp.internal.C20747Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a4, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00aa, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ab, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ac, code lost:
        didihttp.internal.C20747Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00af, code lost:
        throw r0;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo170379e() throws java.io.IOException {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.f56935x     // Catch:{ all -> 0x00b0 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            return r1
        L_0x0008:
            didihttp.internal.ws.WebSocketWriter r0 = r12.f56925n     // Catch:{ all -> 0x00b0 }
            java.util.ArrayDeque<okio.ByteString> r2 = r12.f56928q     // Catch:{ all -> 0x00b0 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x00b0 }
            okio.ByteString r2 = (okio.ByteString) r2     // Catch:{ all -> 0x00b0 }
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L_0x0053
            java.util.ArrayDeque<java.lang.Object> r5 = r12.f56929r     // Catch:{ all -> 0x00b0 }
            java.lang.Object r5 = r5.poll()     // Catch:{ all -> 0x00b0 }
            boolean r6 = r5 instanceof didihttp.internal.p229ws.RealWebSocket.Close     // Catch:{ all -> 0x00b0 }
            if (r6 == 0) goto L_0x004b
            int r1 = r12.f56933v     // Catch:{ all -> 0x00b0 }
            java.lang.String r6 = r12.f56934w     // Catch:{ all -> 0x00b0 }
            if (r1 == r3) goto L_0x0034
            didihttp.internal.ws.RealWebSocket$Streams r3 = r12.f56927p     // Catch:{ all -> 0x00b0 }
            r12.f56927p = r4     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ScheduledExecutorService r4 = r12.f56926o     // Catch:{ all -> 0x00b0 }
            r4.shutdown()     // Catch:{ all -> 0x00b0 }
            r4 = r5
            r11 = r3
            r3 = r1
            r1 = r11
            goto L_0x0055
        L_0x0034:
            java.util.concurrent.ScheduledExecutorService r3 = r12.f56926o     // Catch:{ all -> 0x00b0 }
            didihttp.internal.ws.RealWebSocket$CancelRunnable r7 = new didihttp.internal.ws.RealWebSocket$CancelRunnable     // Catch:{ all -> 0x00b0 }
            r7.<init>()     // Catch:{ all -> 0x00b0 }
            r8 = r5
            didihttp.internal.ws.RealWebSocket$Close r8 = (didihttp.internal.p229ws.RealWebSocket.Close) r8     // Catch:{ all -> 0x00b0 }
            long r8 = r8.cancelAfterCloseMillis     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ScheduledFuture r3 = r3.schedule(r7, r8, r10)     // Catch:{ all -> 0x00b0 }
            r12.f56932u = r3     // Catch:{ all -> 0x00b0 }
            r3 = r1
            r1 = r4
            goto L_0x0051
        L_0x004b:
            if (r5 != 0) goto L_0x004f
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            return r1
        L_0x004f:
            r1 = r4
            r6 = r1
        L_0x0051:
            r4 = r5
            goto L_0x0055
        L_0x0053:
            r1 = r4
            r6 = r1
        L_0x0055:
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x005c
            r0.mo170398b(r2)     // Catch:{ all -> 0x00ab }
            goto L_0x00a0
        L_0x005c:
            boolean r2 = r4 instanceof didihttp.internal.p229ws.RealWebSocket.Message     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x008c
            r2 = r4
            didihttp.internal.ws.RealWebSocket$Message r2 = (didihttp.internal.p229ws.RealWebSocket.Message) r2     // Catch:{ all -> 0x00ab }
            okio.ByteString r2 = r2.data     // Catch:{ all -> 0x00ab }
            didihttp.internal.ws.RealWebSocket$Message r4 = (didihttp.internal.p229ws.RealWebSocket.Message) r4     // Catch:{ all -> 0x00ab }
            int r3 = r4.formatOpcode     // Catch:{ all -> 0x00ab }
            int r4 = r2.size()     // Catch:{ all -> 0x00ab }
            long r4 = (long) r4     // Catch:{ all -> 0x00ab }
            okio.Sink r0 = r0.mo170394a((int) r3, (long) r4)     // Catch:{ all -> 0x00ab }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r0)     // Catch:{ all -> 0x00ab }
            r0.write((okio.ByteString) r2)     // Catch:{ all -> 0x00ab }
            r0.close()     // Catch:{ all -> 0x00ab }
            monitor-enter(r12)     // Catch:{ all -> 0x00ab }
            long r3 = r12.f56930s     // Catch:{ all -> 0x0089 }
            int r0 = r2.size()     // Catch:{ all -> 0x0089 }
            long r5 = (long) r0     // Catch:{ all -> 0x0089 }
            long r3 = r3 - r5
            r12.f56930s = r3     // Catch:{ all -> 0x0089 }
            monitor-exit(r12)     // Catch:{ all -> 0x0089 }
            goto L_0x00a0
        L_0x0089:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0089 }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x008c:
            boolean r2 = r4 instanceof didihttp.internal.p229ws.RealWebSocket.Close     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x00a5
            didihttp.internal.ws.RealWebSocket$Close r4 = (didihttp.internal.p229ws.RealWebSocket.Close) r4     // Catch:{ all -> 0x00ab }
            int r2 = r4.code     // Catch:{ all -> 0x00ab }
            okio.ByteString r4 = r4.reason     // Catch:{ all -> 0x00ab }
            r0.mo170396a((int) r2, (okio.ByteString) r4)     // Catch:{ all -> 0x00ab }
            if (r1 == 0) goto L_0x00a0
            didihttp.WebSocketListener r0 = r12.f56916a     // Catch:{ all -> 0x00ab }
            r0.onClosed(r12, r3, r6)     // Catch:{ all -> 0x00ab }
        L_0x00a0:
            r0 = 1
            didihttp.internal.C20747Util.closeQuietly((java.io.Closeable) r1)
            return r0
        L_0x00a5:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x00ab }
            r0.<init>()     // Catch:{ all -> 0x00ab }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r0 = move-exception
            didihttp.internal.C20747Util.closeQuietly((java.io.Closeable) r1)
            throw r0
        L_0x00b0:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.p229ws.RealWebSocket.mo170379e():boolean");
    }

    /* renamed from: didihttp.internal.ws.RealWebSocket$PingRunnable */
    private final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        public void run() {
            RealWebSocket.this.mo170380f();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo170380f() {
        synchronized (this) {
            if (!this.f56935x) {
                WebSocketWriter webSocketWriter = this.f56925n;
                try {
                    webSocketWriter.mo170397a(ByteString.EMPTY);
                } catch (IOException e) {
                    failWebSocket(e, (Response) null);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r3.f56916a.onFailure(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        didihttp.internal.C20747Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void failWebSocket(java.lang.Exception r4, didihttp.Response r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f56935x     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0007:
            r0 = 1
            r3.f56935x = r0     // Catch:{ all -> 0x0031 }
            didihttp.internal.ws.RealWebSocket$Streams r0 = r3.f56927p     // Catch:{ all -> 0x0031 }
            r1 = 0
            r3.f56927p = r1     // Catch:{ all -> 0x0031 }
            java.util.concurrent.ScheduledFuture<?> r1 = r3.f56932u     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0019
            java.util.concurrent.ScheduledFuture<?> r1 = r3.f56932u     // Catch:{ all -> 0x0031 }
            r2 = 0
            r1.cancel(r2)     // Catch:{ all -> 0x0031 }
        L_0x0019:
            java.util.concurrent.ScheduledExecutorService r1 = r3.f56926o     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0022
            java.util.concurrent.ScheduledExecutorService r1 = r3.f56926o     // Catch:{ all -> 0x0031 }
            r1.shutdown()     // Catch:{ all -> 0x0031 }
        L_0x0022:
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            didihttp.WebSocketListener r1 = r3.f56916a     // Catch:{ all -> 0x002c }
            r1.onFailure(r3, r4, r5)     // Catch:{ all -> 0x002c }
            didihttp.internal.C20747Util.closeQuietly((java.io.Closeable) r0)
            return
        L_0x002c:
            r4 = move-exception
            didihttp.internal.C20747Util.closeQuietly((java.io.Closeable) r0)
            throw r4
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.p229ws.RealWebSocket.failWebSocket(java.lang.Exception, didihttp.Response):void");
    }

    /* renamed from: didihttp.internal.ws.RealWebSocket$Message */
    static final class Message {
        final ByteString data;
        final int formatOpcode;

        Message(int i, ByteString byteString) {
            this.formatOpcode = i;
            this.data = byteString;
        }
    }

    /* renamed from: didihttp.internal.ws.RealWebSocket$Close */
    static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        Close(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }
    }

    /* renamed from: didihttp.internal.ws.RealWebSocket$Streams */
    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final BufferedSink sink;
        public final BufferedSource source;

        public Streams(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    /* renamed from: didihttp.internal.ws.RealWebSocket$CancelRunnable */
    final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        public void run() {
            RealWebSocket.this.cancel();
        }
    }
}

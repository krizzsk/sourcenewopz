package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Agent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.io.CountingInputStream */
public final class CountingInputStream extends InputStream implements StreamCompleteListenerSource {

    /* renamed from: f */
    private static final AgentLog f47988f = AgentLogManager.getAgentLog();

    /* renamed from: a */
    private final InputStream f47989a;

    /* renamed from: b */
    private long f47990b;

    /* renamed from: c */
    private final C15778a f47991c = new C15778a();

    /* renamed from: d */
    private final ByteBuffer f47992d;

    /* renamed from: e */
    private boolean f47993e = false;

    public CountingInputStream(InputStream inputStream) {
        this.f47989a = inputStream;
        if (0 != 0) {
            this.f47992d = ByteBuffer.allocate(Agent.getResponseBodyLimit());
            fillBuffer();
            return;
        }
        this.f47992d = null;
    }

    public CountingInputStream(InputStream inputStream, boolean z) {
        this.f47989a = inputStream;
        this.f47993e = z;
        if (z) {
            this.f47992d = ByteBuffer.allocate(Agent.getResponseBodyLimit());
            fillBuffer();
            return;
        }
        this.f47992d = null;
    }

    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.f47991c.mo118238a(streamCompleteListener);
    }

    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.f47991c.mo118241b(streamCompleteListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r6.f47993e
            r1 = 1
            if (r0 == 0) goto L_0x0021
            java.nio.ByteBuffer r0 = r6.f47992d
            monitor-enter(r0)
            boolean r3 = r6.m34254a((long) r1)     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001c
            int r3 = r6.m34250a()     // Catch:{ all -> 0x001e }
            if (r3 < 0) goto L_0x001a
            long r4 = r6.f47990b     // Catch:{ all -> 0x001e }
            long r4 = r4 + r1
            r6.f47990b = r4     // Catch:{ all -> 0x001e }
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return r3
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            goto L_0x0021
        L_0x001e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r1
        L_0x0021:
            java.io.InputStream r0 = r6.f47989a     // Catch:{ IOException -> 0x0033 }
            int r0 = r0.read()     // Catch:{ IOException -> 0x0033 }
            if (r0 < 0) goto L_0x002f
            long r3 = r6.f47990b     // Catch:{ IOException -> 0x0033 }
            long r3 = r3 + r1
            r6.f47990b = r3     // Catch:{ IOException -> 0x0033 }
            goto L_0x0032
        L_0x002f:
            r6.m34256c()     // Catch:{ IOException -> 0x0033 }
        L_0x0032:
            return r0
        L_0x0033:
            r0 = move-exception
            r6.m34253a((java.lang.Exception) r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingInputStream.read():int");
    }

    public int read(byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = 0;
        if (this.f47993e) {
            synchronized (this.f47992d) {
                if (m34254a((long) length)) {
                    int a = m34251a(bArr);
                    if (a >= 0) {
                        this.f47990b += (long) a;
                        return a;
                    }
                    throw new IOException("readBufferBytes failed");
                }
                int remaining = this.f47992d.remaining();
                if (remaining > 0) {
                    i = m34252a(bArr, 0, remaining);
                    if (i >= 0) {
                        length -= i;
                        this.f47990b += (long) i;
                    } else {
                        throw new IOException("partial read from buffer failed");
                    }
                }
            }
        }
        try {
            int read = this.f47989a.read(bArr, i, length);
            if (read >= 0) {
                this.f47990b += (long) read;
                return read + i;
            } else if (i > 0) {
                return i;
            } else {
                m34256c();
                return read;
            }
        } catch (IOException e) {
            f47988f.error(e.toString());
            System.out.println("NOTIFY STREAM ERROR: " + e);
            e.printStackTrace();
            m34253a((Exception) e);
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (this.f47993e) {
            synchronized (this.f47992d) {
                if (m34254a((long) i2)) {
                    int a = m34252a(bArr, i, i2);
                    if (a >= 0) {
                        this.f47990b += (long) a;
                        return a;
                    }
                    throw new IOException("readBufferBytes failed");
                }
                int remaining = this.f47992d.remaining();
                if (remaining > 0) {
                    i3 = m34252a(bArr, i, remaining);
                    if (i3 >= 0) {
                        i2 -= i3;
                        this.f47990b += (long) i3;
                    } else {
                        throw new IOException("partial read from buffer failed");
                    }
                }
            }
        }
        try {
            int read = this.f47989a.read(bArr, i + i3, i2);
            if (read >= 0) {
                this.f47990b += (long) read;
                return read + i3;
            } else if (i3 > 0) {
                return i3;
            } else {
                m34256c();
                return read;
            }
        } catch (IOException e) {
            m34253a((Exception) e);
            throw e;
        }
    }

    public long skip(long j) throws IOException {
        if (this.f47993e) {
            synchronized (this.f47992d) {
                if (m34254a(j)) {
                    this.f47992d.position((int) j);
                    this.f47990b += j;
                    return j;
                }
                j -= (long) this.f47992d.remaining();
                if (j > 0) {
                    this.f47992d.position(this.f47992d.remaining());
                } else {
                    throw new IOException("partial read from buffer (skip) failed");
                }
            }
        }
        try {
            long skip = this.f47989a.skip(j);
            this.f47990b += skip;
            return skip;
        } catch (IOException e) {
            m34253a((Exception) e);
            throw e;
        }
    }

    public int available() throws IOException {
        try {
            return (this.f47993e ? this.f47992d.remaining() : 0) + this.f47989a.available();
        } catch (IOException e) {
            m34253a((Exception) e);
            throw e;
        }
    }

    public void close() throws IOException {
        try {
            this.f47989a.close();
            m34256c();
        } catch (IOException e) {
            m34253a((Exception) e);
            throw e;
        }
    }

    public void mark(int i) {
        if (markSupported()) {
            this.f47989a.mark(i);
        }
    }

    public boolean markSupported() {
        return this.f47989a.markSupported();
    }

    public void reset() throws IOException {
        if (markSupported()) {
            try {
                this.f47989a.reset();
            } catch (IOException e) {
                m34253a((Exception) e);
                throw e;
            }
        }
    }

    /* renamed from: a */
    private int m34250a() {
        if (m34255b()) {
            return -1;
        }
        return this.f47992d.get();
    }

    /* renamed from: a */
    private int m34251a(byte[] bArr) {
        return m34252a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private int m34252a(byte[] bArr, int i, int i2) {
        if (m34255b()) {
            return -1;
        }
        int remaining = this.f47992d.remaining();
        this.f47992d.get(bArr, i, i2);
        return remaining - this.f47992d.remaining();
    }

    /* renamed from: a */
    private boolean m34254a(long j) {
        return ((long) this.f47992d.remaining()) >= j;
    }

    /* renamed from: b */
    private boolean m34255b() {
        return !this.f47992d.hasRemaining();
    }

    public void fillBuffer() {
        int i;
        ByteBuffer byteBuffer = this.f47992d;
        if (byteBuffer != null && byteBuffer.hasArray()) {
            synchronized (this.f47992d) {
                try {
                    i = this.f47989a.read(this.f47992d.array(), 0, this.f47992d.capacity());
                } catch (IOException e) {
                    f47988f.error(e.toString());
                    i = 0;
                }
                if (i <= 0) {
                    this.f47992d.limit(0);
                } else if (i < this.f47992d.capacity()) {
                    this.f47992d.limit(i);
                }
            }
        }
    }

    /* renamed from: c */
    private void m34256c() {
        if (!this.f47991c.mo118239a()) {
            this.f47991c.mo118237a(new StreamCompleteEvent(this, this.f47990b));
        }
    }

    /* renamed from: a */
    private void m34253a(Exception exc) {
        if (!this.f47991c.mo118239a()) {
            this.f47991c.mo118240b(new StreamCompleteEvent(this, this.f47990b, exc));
        }
    }

    public void setBufferingEnabled(boolean z) {
        this.f47993e = z;
    }

    public String getBufferAsString() {
        String str;
        ByteBuffer byteBuffer = this.f47992d;
        if (byteBuffer == null) {
            return "";
        }
        synchronized (byteBuffer) {
            byte[] bArr = new byte[this.f47992d.limit()];
            for (int i = 0; i < this.f47992d.limit(); i++) {
                bArr[i] = this.f47992d.get(i);
            }
            str = new String(bArr);
        }
        return str;
    }
}

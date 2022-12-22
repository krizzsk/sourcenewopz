package com.didichuxing.ditest.agent.android.instrumentation.p187io;

import com.didichuxing.ditest.agent.android.Agent;
import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.didichuxing.ditest.agent.android.instrumentation.io.CountingInputStream */
public final class CountingInputStream extends InputStream implements StreamCompleteListenerSource {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final ByteBuffer buffer;
    private long count;
    private boolean enableBuffering = false;
    private final InputStream impl;
    private final StreamCompleteListenerManager listenerManager = new StreamCompleteListenerManager();

    public CountingInputStream(InputStream inputStream) {
        this.impl = inputStream;
        if (0 != 0) {
            this.buffer = ByteBuffer.allocate(Agent.getResponseBodyLimit());
            fillBuffer();
            return;
        }
        this.buffer = null;
    }

    public CountingInputStream(InputStream inputStream, boolean z) {
        this.impl = inputStream;
        this.enableBuffering = z;
        if (z) {
            this.buffer = ByteBuffer.allocate(Agent.getResponseBodyLimit());
            fillBuffer();
            return;
        }
        this.buffer = null;
    }

    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.listenerManager.addStreamCompleteListener(streamCompleteListener);
    }

    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.listenerManager.removeStreamCompleteListener(streamCompleteListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r6.enableBuffering
            r1 = 1
            if (r0 == 0) goto L_0x0021
            java.nio.ByteBuffer r0 = r6.buffer
            monitor-enter(r0)
            boolean r3 = r6.bufferHasBytes(r1)     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001c
            int r3 = r6.readBuffer()     // Catch:{ all -> 0x001e }
            if (r3 < 0) goto L_0x001a
            long r4 = r6.count     // Catch:{ all -> 0x001e }
            long r4 = r4 + r1
            r6.count = r4     // Catch:{ all -> 0x001e }
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
            java.io.InputStream r0 = r6.impl     // Catch:{ IOException -> 0x0033 }
            int r0 = r0.read()     // Catch:{ IOException -> 0x0033 }
            if (r0 < 0) goto L_0x002f
            long r3 = r6.count     // Catch:{ IOException -> 0x0033 }
            long r3 = r3 + r1
            r6.count = r3     // Catch:{ IOException -> 0x0033 }
            goto L_0x0032
        L_0x002f:
            r6.notifyStreamComplete()     // Catch:{ IOException -> 0x0033 }
        L_0x0032:
            return r0
        L_0x0033:
            r0 = move-exception
            r6.notifyStreamError(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.ditest.agent.android.instrumentation.p187io.CountingInputStream.read():int");
    }

    public int read(byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = 0;
        if (this.enableBuffering) {
            synchronized (this.buffer) {
                if (bufferHasBytes((long) length)) {
                    int readBufferBytes = readBufferBytes(bArr);
                    if (readBufferBytes >= 0) {
                        this.count += (long) readBufferBytes;
                        return readBufferBytes;
                    }
                    throw new IOException("readBufferBytes failed");
                }
                int remaining = this.buffer.remaining();
                if (remaining > 0) {
                    i = readBufferBytes(bArr, 0, remaining);
                    if (i >= 0) {
                        length -= i;
                        this.count += (long) i;
                    } else {
                        throw new IOException("partial read from buffer failed");
                    }
                }
            }
        }
        try {
            int read = this.impl.read(bArr, i, length);
            if (read >= 0) {
                this.count += (long) read;
                return read + i;
            } else if (i > 0) {
                return i;
            } else {
                notifyStreamComplete();
                return read;
            }
        } catch (IOException e) {
            log.error(e.toString());
            System.out.println("NOTIFY STREAM ERROR: " + e);
            e.printStackTrace();
            notifyStreamError(e);
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (this.enableBuffering) {
            synchronized (this.buffer) {
                if (bufferHasBytes((long) i2)) {
                    int readBufferBytes = readBufferBytes(bArr, i, i2);
                    if (readBufferBytes >= 0) {
                        this.count += (long) readBufferBytes;
                        return readBufferBytes;
                    }
                    throw new IOException("readBufferBytes failed");
                }
                int remaining = this.buffer.remaining();
                if (remaining > 0) {
                    i3 = readBufferBytes(bArr, i, remaining);
                    if (i3 >= 0) {
                        i2 -= i3;
                        this.count += (long) i3;
                    } else {
                        throw new IOException("partial read from buffer failed");
                    }
                }
            }
        }
        try {
            int read = this.impl.read(bArr, i + i3, i2);
            if (read >= 0) {
                this.count += (long) read;
                return read + i3;
            } else if (i3 > 0) {
                return i3;
            } else {
                notifyStreamComplete();
                return read;
            }
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    public long skip(long j) throws IOException {
        if (this.enableBuffering) {
            synchronized (this.buffer) {
                if (bufferHasBytes(j)) {
                    this.buffer.position((int) j);
                    this.count += j;
                    return j;
                }
                j -= (long) this.buffer.remaining();
                if (j > 0) {
                    this.buffer.position(this.buffer.remaining());
                } else {
                    throw new IOException("partial read from buffer (skip) failed");
                }
            }
        }
        try {
            long skip = this.impl.skip(j);
            this.count += skip;
            return skip;
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    public int available() throws IOException {
        try {
            return (this.enableBuffering ? this.buffer.remaining() : 0) + this.impl.available();
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    public void close() throws IOException {
        try {
            this.impl.close();
            notifyStreamComplete();
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    public void mark(int i) {
        if (markSupported()) {
            this.impl.mark(i);
        }
    }

    public boolean markSupported() {
        return this.impl.markSupported();
    }

    public void reset() throws IOException {
        if (markSupported()) {
            try {
                this.impl.reset();
            } catch (IOException e) {
                notifyStreamError(e);
                throw e;
            }
        }
    }

    private int readBuffer() {
        if (bufferEmpty()) {
            return -1;
        }
        return this.buffer.get();
    }

    private int readBufferBytes(byte[] bArr) {
        return readBufferBytes(bArr, 0, bArr.length);
    }

    private int readBufferBytes(byte[] bArr, int i, int i2) {
        if (bufferEmpty()) {
            return -1;
        }
        int remaining = this.buffer.remaining();
        this.buffer.get(bArr, i, i2);
        return remaining - this.buffer.remaining();
    }

    private boolean bufferHasBytes(long j) {
        return ((long) this.buffer.remaining()) >= j;
    }

    private boolean bufferEmpty() {
        return !this.buffer.hasRemaining();
    }

    public void fillBuffer() {
        int i;
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer != null && byteBuffer.hasArray()) {
            synchronized (this.buffer) {
                try {
                    i = this.impl.read(this.buffer.array(), 0, this.buffer.capacity());
                } catch (IOException e) {
                    log.error(e.toString());
                    i = 0;
                }
                if (i <= 0) {
                    this.buffer.limit(0);
                } else if (i < this.buffer.capacity()) {
                    this.buffer.limit(i);
                }
            }
        }
    }

    private void notifyStreamComplete() {
        if (!this.listenerManager.isComplete()) {
            this.listenerManager.notifyStreamComplete(new StreamCompleteEvent(this, this.count));
        }
    }

    private void notifyStreamError(Exception exc) {
        if (!this.listenerManager.isComplete()) {
            this.listenerManager.notifyStreamError(new StreamCompleteEvent(this, this.count, exc));
        }
    }

    public void setBufferingEnabled(boolean z) {
        this.enableBuffering = z;
    }

    public String getBufferAsString() {
        String str;
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null) {
            return "";
        }
        synchronized (byteBuffer) {
            byte[] bArr = new byte[this.buffer.limit()];
            for (int i = 0; i < this.buffer.limit(); i++) {
                bArr[i] = this.buffer.get(i);
            }
            str = new String(bArr);
        }
        return str;
    }
}

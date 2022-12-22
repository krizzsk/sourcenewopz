package okhttp3.internal.p070ws;

import android.support.p003v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* renamed from: okhttp3.internal.ws.WebSocketWriter */
final class WebSocketWriter {

    /* renamed from: a */
    final boolean f5601a;

    /* renamed from: b */
    final Random f5602b;

    /* renamed from: c */
    final BufferedSink f5603c;

    /* renamed from: d */
    final Buffer f5604d;

    /* renamed from: e */
    boolean f5605e;

    /* renamed from: f */
    final Buffer f5606f = new Buffer();

    /* renamed from: g */
    final FrameSink f5607g = new FrameSink();

    /* renamed from: h */
    boolean f5608h;

    /* renamed from: i */
    private final byte[] f5609i;

    /* renamed from: j */
    private final Buffer.UnsafeCursor f5610j;

    WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random != null) {
            this.f5601a = z;
            this.f5603c = bufferedSink;
            this.f5604d = bufferedSink.buffer();
            this.f5602b = random;
            Buffer.UnsafeCursor unsafeCursor = null;
            this.f5609i = z ? new byte[4] : null;
            this.f5610j = z ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25422a(ByteString byteString) throws IOException {
        m3598b(9, byteString);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25423b(ByteString byteString) throws IOException {
        m3598b(10, byteString);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25421a(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i == 0 && byteString == null)) {
            if (i != 0) {
                WebSocketProtocol.m3591b(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            m3598b(8, byteString2);
        } finally {
            this.f5605e = true;
        }
    }

    /* renamed from: b */
    private void m3598b(int i, ByteString byteString) throws IOException {
        if (!this.f5605e) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.f5604d.writeByte(i | 128);
                if (this.f5601a) {
                    this.f5604d.writeByte(size | 128);
                    this.f5602b.nextBytes(this.f5609i);
                    this.f5604d.write(this.f5609i);
                    if (size > 0) {
                        long size2 = this.f5604d.size();
                        this.f5604d.write(byteString);
                        this.f5604d.readAndWriteUnsafe(this.f5610j);
                        this.f5610j.seek(size2);
                        WebSocketProtocol.m3590a(this.f5610j, this.f5609i);
                        this.f5610j.close();
                    }
                } else {
                    this.f5604d.writeByte(size);
                    this.f5604d.write(byteString);
                }
                this.f5603c.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Sink mo25419a(int i, long j) {
        if (!this.f5608h) {
            this.f5608h = true;
            this.f5607g.formatOpcode = i;
            this.f5607g.contentLength = j;
            this.f5607g.isFirstFrame = true;
            this.f5607g.closed = false;
            return this.f5607g;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25420a(int i, long j, boolean z, boolean z2) throws IOException {
        if (!this.f5605e) {
            int i2 = 0;
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= 128;
            }
            this.f5604d.writeByte(i);
            if (this.f5601a) {
                i2 = 128;
            }
            if (j <= 125) {
                this.f5604d.writeByte(((int) j) | i2);
            } else if (j <= 65535) {
                this.f5604d.writeByte(i2 | 126);
                this.f5604d.writeShort((int) j);
            } else {
                this.f5604d.writeByte(i2 | 127);
                this.f5604d.writeLong(j);
            }
            if (this.f5601a) {
                this.f5602b.nextBytes(this.f5609i);
                this.f5604d.write(this.f5609i);
                if (j > 0) {
                    long size = this.f5604d.size();
                    this.f5604d.write(this.f5606f, j);
                    this.f5604d.readAndWriteUnsafe(this.f5610j);
                    this.f5610j.seek(size);
                    WebSocketProtocol.m3590a(this.f5610j, this.f5609i);
                    this.f5610j.close();
                }
            } else {
                this.f5604d.write(this.f5606f, j);
            }
            this.f5603c.emit();
            return;
        }
        throw new IOException("closed");
    }

    /* renamed from: okhttp3.internal.ws.WebSocketWriter$FrameSink */
    final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (!this.closed) {
                WebSocketWriter.this.f5606f.write(buffer, j);
                boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.f5606f.size() > this.contentLength - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                long completeSegmentByteCount = WebSocketWriter.this.f5606f.completeSegmentByteCount();
                if (completeSegmentByteCount > 0 && !z) {
                    WebSocketWriter.this.mo25420a(this.formatOpcode, completeSegmentByteCount, this.isFirstFrame, false);
                    this.isFirstFrame = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        public void flush() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.mo25420a(this.formatOpcode, webSocketWriter.f5606f.size(), this.isFirstFrame, false);
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }

        public Timeout timeout() {
            return WebSocketWriter.this.f5603c.timeout();
        }

        public void close() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.mo25420a(this.formatOpcode, webSocketWriter.f5606f.size(), this.isFirstFrame, true);
                this.closed = true;
                WebSocketWriter.this.f5608h = false;
                return;
            }
            throw new IOException("closed");
        }
    }
}

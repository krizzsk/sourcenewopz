package didihttp.internal.p229ws;

import android.support.p003v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* renamed from: didihttp.internal.ws.WebSocketWriter */
final class WebSocketWriter {

    /* renamed from: j */
    static final /* synthetic */ boolean f56972j = (!WebSocketWriter.class.desiredAssertionStatus());

    /* renamed from: a */
    final boolean f56973a;

    /* renamed from: b */
    final Random f56974b;

    /* renamed from: c */
    final BufferedSink f56975c;

    /* renamed from: d */
    boolean f56976d;

    /* renamed from: e */
    final Buffer f56977e = new Buffer();

    /* renamed from: f */
    final FrameSink f56978f = new FrameSink();

    /* renamed from: g */
    boolean f56979g;

    /* renamed from: h */
    final byte[] f56980h;

    /* renamed from: i */
    final byte[] f56981i;

    WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random != null) {
            this.f56973a = z;
            this.f56975c = bufferedSink;
            this.f56974b = random;
            byte[] bArr = null;
            this.f56980h = z ? new byte[4] : null;
            this.f56981i = z ? new byte[8192] : bArr;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170397a(ByteString byteString) throws IOException {
        synchronized (this) {
            m40886b(9, byteString);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo170398b(ByteString byteString) throws IOException {
        synchronized (this) {
            m40886b(10, byteString);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170396a(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i == 0 && byteString == null)) {
            if (i != 0) {
                WebSocketProtocol.m40879b(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        synchronized (this) {
            try {
                m40886b(8, byteString2);
                this.f56976d = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    private void m40886b(int i, ByteString byteString) throws IOException {
        if (!f56972j && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (!this.f56976d) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.f56975c.writeByte(i | 128);
                if (this.f56973a) {
                    this.f56975c.writeByte(size | 128);
                    this.f56974b.nextBytes(this.f56980h);
                    this.f56975c.write(this.f56980h);
                    byte[] byteArray = byteString.toByteArray();
                    WebSocketProtocol.m40878a(byteArray, (long) byteArray.length, this.f56980h, 0);
                    this.f56975c.write(byteArray);
                } else {
                    this.f56975c.writeByte(size);
                    this.f56975c.write(byteString);
                }
                this.f56975c.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Sink mo170394a(int i, long j) {
        if (!this.f56979g) {
            this.f56979g = true;
            this.f56978f.formatOpcode = i;
            this.f56978f.contentLength = j;
            this.f56978f.isFirstFrame = true;
            this.f56978f.closed = false;
            return this.f56978f;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170395a(int i, long j, boolean z, boolean z2) throws IOException {
        if (!f56972j && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (!this.f56976d) {
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= 128;
            }
            this.f56975c.writeByte(i);
            int i2 = this.f56973a ? 128 : 0;
            if (j <= 125) {
                this.f56975c.writeByte(i2 | ((int) j));
            } else if (j <= 65535) {
                this.f56975c.writeByte(i2 | 126);
                this.f56975c.writeShort((int) j);
            } else {
                this.f56975c.writeByte(i2 | 127);
                this.f56975c.writeLong(j);
            }
            if (this.f56973a) {
                this.f56974b.nextBytes(this.f56980h);
                this.f56975c.write(this.f56980h);
                long j2 = 0;
                while (j2 < j) {
                    int read = this.f56977e.read(this.f56981i, 0, (int) Math.min(j, (long) this.f56981i.length));
                    if (read != -1) {
                        long j3 = (long) read;
                        WebSocketProtocol.m40878a(this.f56981i, j3, this.f56980h, j2);
                        this.f56975c.write(this.f56981i, 0, read);
                        j2 += j3;
                    } else {
                        throw new AssertionError();
                    }
                }
            } else {
                this.f56975c.write(this.f56977e, j);
            }
            this.f56975c.emit();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: didihttp.internal.ws.WebSocketWriter$FrameSink */
    final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (!this.closed) {
                WebSocketWriter.this.f56977e.write(buffer, j);
                boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.f56977e.size() > this.contentLength - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                long completeSegmentByteCount = WebSocketWriter.this.f56977e.completeSegmentByteCount();
                if (completeSegmentByteCount > 0 && !z) {
                    synchronized (WebSocketWriter.this) {
                        WebSocketWriter.this.mo170395a(this.formatOpcode, completeSegmentByteCount, this.isFirstFrame, false);
                    }
                    this.isFirstFrame = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        public void flush() throws IOException {
            if (!this.closed) {
                synchronized (WebSocketWriter.this) {
                    WebSocketWriter.this.mo170395a(this.formatOpcode, WebSocketWriter.this.f56977e.size(), this.isFirstFrame, false);
                }
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }

        public Timeout timeout() {
            return WebSocketWriter.this.f56975c.timeout();
        }

        public void close() throws IOException {
            if (!this.closed) {
                synchronized (WebSocketWriter.this) {
                    WebSocketWriter.this.mo170395a(this.formatOpcode, WebSocketWriter.this.f56977e.size(), this.isFirstFrame, true);
                }
                this.closed = true;
                WebSocketWriter.this.f56979g = false;
                return;
            }
            throw new IOException("closed");
        }
    }
}

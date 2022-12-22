package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.C2434Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

/* renamed from: okhttp3.internal.http2.a */
/* compiled from: Http2Writer */
final class C2458a implements Closeable {

    /* renamed from: b */
    private static final Logger f5493b = Logger.getLogger(Http2.class.getName());

    /* renamed from: a */
    final Hpack.Writer f5494a;

    /* renamed from: c */
    private final BufferedSink f5495c;

    /* renamed from: d */
    private final boolean f5496d;

    /* renamed from: e */
    private final Buffer f5497e;

    /* renamed from: f */
    private int f5498f = 16384;

    /* renamed from: g */
    private boolean f5499g;

    C2458a(BufferedSink bufferedSink, boolean z) {
        this.f5495c = bufferedSink;
        this.f5496d = z;
        Buffer buffer = new Buffer();
        this.f5497e = buffer;
        this.f5494a = new Hpack.Writer(buffer);
    }

    /* renamed from: a */
    public synchronized void mo25327a() throws IOException {
        if (this.f5499g) {
            throw new IOException("closed");
        } else if (this.f5496d) {
            if (f5493b.isLoggable(Level.FINE)) {
                f5493b.fine(C2434Util.format(">> CONNECTION %s", Http2.f5400a.hex()));
            }
            this.f5495c.write(Http2.f5400a.toByteArray());
            this.f5495c.flush();
        }
    }

    /* renamed from: a */
    public synchronized void mo25335a(Settings settings) throws IOException {
        if (!this.f5499g) {
            this.f5498f = settings.mo25325d(this.f5498f);
            if (settings.mo25322c() != -1) {
                this.f5494a.setHeaderTableSizeSetting(settings.mo25322c());
            }
            mo25329a(0, 0, (byte) 4, (byte) 1);
            this.f5495c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo25330a(int i, int i2, List<Header> list) throws IOException {
        if (!this.f5499g) {
            this.f5494a.writeHeaders(list);
            long size = this.f5497e.size();
            int min = (int) Math.min((long) (this.f5498f - 4), size);
            long j = (long) min;
            int i3 = (size > j ? 1 : (size == j ? 0 : -1));
            mo25329a(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : 0);
            this.f5495c.writeInt(i2 & Integer.MAX_VALUE);
            this.f5495c.write(this.f5497e, j);
            if (i3 > 0) {
                m3524b(i, size - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void mo25340b() throws IOException {
        if (!this.f5499g) {
            this.f5495c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo25337a(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (!this.f5499g) {
            mo25342b(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo25338a(boolean z, int i, List<Header> list) throws IOException {
        if (!this.f5499g) {
            mo25342b(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo25332a(int i, List<Header> list) throws IOException {
        if (!this.f5499g) {
            mo25342b(false, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo25333a(int i, ErrorCode errorCode) throws IOException {
        if (this.f5499g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo25329a(i, 4, (byte) 3, (byte) 0);
            this.f5495c.writeInt(errorCode.httpCode);
            this.f5495c.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: c */
    public int mo25343c() {
        return this.f5498f;
    }

    /* renamed from: a */
    public synchronized void mo25339a(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (!this.f5499g) {
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            mo25328a(i, b, buffer, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25328a(int i, byte b, Buffer buffer, int i2) throws IOException {
        mo25329a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f5495c.write(buffer, (long) i2);
        }
    }

    /* renamed from: b */
    public synchronized void mo25341b(Settings settings) throws IOException {
        if (!this.f5499g) {
            int i = 0;
            mo25329a(0, settings.mo25320b() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (settings.mo25318a(i)) {
                    this.f5495c.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f5495c.writeInt(settings.mo25321b(i));
                }
                i++;
            }
            this.f5495c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo25336a(boolean z, int i, int i2) throws IOException {
        if (!this.f5499g) {
            mo25329a(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f5495c.writeInt(i);
            this.f5495c.writeInt(i2);
            this.f5495c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo25334a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f5499g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo25329a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f5495c.writeInt(i);
            this.f5495c.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.f5495c.write(bArr);
            }
            this.f5495c.flush();
        } else {
            throw Http2.m3451a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    /* renamed from: a */
    public synchronized void mo25331a(int i, long j) throws IOException {
        if (this.f5499g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw Http2.m3451a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            mo25329a(i, 4, (byte) 8, (byte) 0);
            this.f5495c.writeInt((int) j);
            this.f5495c.flush();
        }
    }

    /* renamed from: a */
    public void mo25329a(int i, int i2, byte b, byte b2) throws IOException {
        if (f5493b.isLoggable(Level.FINE)) {
            f5493b.fine(Http2.m3453a(false, i, i2, b, b2));
        }
        int i3 = this.f5498f;
        if (i2 > i3) {
            throw Http2.m3451a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            m3523a(this.f5495c, i2);
            this.f5495c.writeByte(b & 255);
            this.f5495c.writeByte(b2 & 255);
            this.f5495c.writeInt(i & Integer.MAX_VALUE);
        } else {
            throw Http2.m3451a("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    public synchronized void close() throws IOException {
        this.f5499g = true;
        this.f5495c.close();
    }

    /* renamed from: a */
    private static void m3523a(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    /* renamed from: b */
    private void m3524b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f5498f, j);
            long j2 = (long) min;
            j -= j2;
            mo25329a(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f5495c.write(this.f5497e, j2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25342b(boolean z, int i, List<Header> list) throws IOException {
        if (!this.f5499g) {
            this.f5494a.writeHeaders(list);
            long size = this.f5497e.size();
            int min = (int) Math.min((long) this.f5498f, size);
            long j = (long) min;
            int i2 = (size > j ? 1 : (size == j ? 0 : -1));
            byte b = i2 == 0 ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            mo25329a(i, min, (byte) 1, b);
            this.f5495c.write(this.f5497e, j);
            if (i2 > 0) {
                m3524b(i, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}

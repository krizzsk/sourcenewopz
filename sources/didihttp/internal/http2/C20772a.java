package didihttp.internal.http2;

import didihttp.internal.C20747Util;
import didihttp.internal.http2.Hpack;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;

/* renamed from: didihttp.internal.http2.a */
/* compiled from: Http2Writer */
final class C20772a implements Closeable {

    /* renamed from: b */
    private static final Logger f56837b = Logger.getLogger(Http2.class.getName());

    /* renamed from: a */
    final Hpack.Writer f56838a;

    /* renamed from: c */
    private final BufferedSink f56839c;

    /* renamed from: d */
    private final boolean f56840d;

    /* renamed from: e */
    private final Buffer f56841e;

    /* renamed from: f */
    private int f56842f = 16384;

    /* renamed from: g */
    private boolean f56843g;

    public C20772a(BufferedSink bufferedSink, boolean z) {
        this.f56839c = bufferedSink;
        this.f56840d = z;
        Buffer buffer = new Buffer();
        this.f56841e = buffer;
        this.f56838a = new Hpack.Writer(buffer);
    }

    /* renamed from: a */
    public synchronized void mo170188a() throws IOException {
        if (this.f56843g) {
            throw new IOException("closed");
        } else if (this.f56840d) {
            if (f56837b.isLoggable(Level.FINE)) {
                f56837b.fine(C20747Util.format(">> CONNECTION %s", Http2.f56743a.hex()));
            }
            this.f56839c.write(Http2.f56743a.toByteArray());
            this.f56839c.flush();
        }
    }

    /* renamed from: a */
    public synchronized void mo170196a(Settings settings) throws IOException {
        if (!this.f56843g) {
            this.f56842f = settings.mo170186d(this.f56842f);
            if (settings.mo170183c() != -1) {
                this.f56838a.setHeaderTableSizeSetting(settings.mo170183c());
            }
            mo170190a(0, 0, (byte) 4, (byte) 1);
            this.f56839c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo170191a(int i, int i2, List<Header> list) throws IOException {
        if (!this.f56843g) {
            this.f56838a.writeHeaders(list);
            long size = this.f56841e.size();
            int min = (int) Math.min((long) (this.f56842f - 4), size);
            long j = (long) min;
            int i3 = (size > j ? 1 : (size == j ? 0 : -1));
            mo170190a(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : 0);
            this.f56839c.writeInt(i2 & Integer.MAX_VALUE);
            this.f56839c.write(this.f56841e, j);
            if (i3 > 0) {
                m40787b(i, size - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void mo170201b() throws IOException {
        if (!this.f56843g) {
            this.f56839c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo170198a(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (!this.f56843g) {
            mo170203b(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo170199a(boolean z, int i, List<Header> list) throws IOException {
        if (!this.f56843g) {
            mo170203b(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo170195a(int i, List<Header> list) throws IOException {
        if (!this.f56843g) {
            mo170203b(false, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo170193a(int i, ErrorCode errorCode) throws IOException {
        if (this.f56843g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo170190a(i, 4, (byte) 3, (byte) 0);
            this.f56839c.writeInt(errorCode.httpCode);
            this.f56839c.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: c */
    public int mo170204c() {
        return this.f56842f;
    }

    /* renamed from: a */
    public synchronized void mo170200a(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (!this.f56843g) {
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            mo170189a(i, b, buffer, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170189a(int i, byte b, Buffer buffer, int i2) throws IOException {
        mo170190a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f56839c.write(buffer, (long) i2);
        }
    }

    /* renamed from: b */
    public synchronized void mo170202b(Settings settings) throws IOException {
        if (!this.f56843g) {
            int i = 0;
            mo170190a(0, settings.mo170181b() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (settings.mo170179a(i)) {
                    this.f56839c.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f56839c.writeInt(settings.mo170182b(i));
                }
                i++;
            }
            this.f56839c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo170197a(boolean z, int i, int i2) throws IOException {
        if (!this.f56843g) {
            mo170190a(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f56839c.writeInt(i);
            this.f56839c.writeInt(i2);
            this.f56839c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo170194a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f56843g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo170190a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f56839c.writeInt(i);
            this.f56839c.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.f56839c.write(bArr);
            }
            this.f56839c.flush();
        } else {
            throw Http2.m40722a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    /* renamed from: a */
    public synchronized void mo170192a(int i, long j) throws IOException {
        if (this.f56843g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw Http2.m40722a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            mo170190a(i, 4, (byte) 8, (byte) 0);
            this.f56839c.writeInt((int) j);
            this.f56839c.flush();
        }
    }

    /* renamed from: a */
    public void mo170190a(int i, int i2, byte b, byte b2) throws IOException {
        if (f56837b.isLoggable(Level.FINE)) {
            f56837b.fine(Http2.m40724a(false, i, i2, b, b2));
        }
        int i3 = this.f56842f;
        if (i2 > i3) {
            throw Http2.m40722a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            m40786a(this.f56839c, i2);
            this.f56839c.writeByte(b & 255);
            this.f56839c.writeByte(b2 & 255);
            this.f56839c.writeInt(i & Integer.MAX_VALUE);
        } else {
            throw Http2.m40722a("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    public synchronized void close() throws IOException {
        this.f56843g = true;
        this.f56839c.close();
    }

    /* renamed from: a */
    private static void m40786a(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    /* renamed from: b */
    private void m40787b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f56842f, j);
            long j2 = (long) min;
            j -= j2;
            mo170190a(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f56839c.write(this.f56841e, j2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo170203b(boolean z, int i, List<Header> list) throws IOException {
        if (!this.f56843g) {
            this.f56838a.writeHeaders(list);
            long size = this.f56841e.size();
            int min = (int) Math.min((long) this.f56842f, size);
            long j = (long) min;
            int i2 = (size > j ? 1 : (size == j ? 0 : -1));
            byte b = i2 == 0 ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            mo170190a(i, min, (byte) 1, b);
            this.f56839c.write(this.f56841e, j);
            if (i2 > 0) {
                m40787b(i, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}

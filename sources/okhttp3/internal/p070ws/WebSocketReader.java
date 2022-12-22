package okhttp3.internal.p070ws;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: okhttp3.internal.ws.WebSocketReader */
final class WebSocketReader {

    /* renamed from: a */
    final boolean f5589a;

    /* renamed from: b */
    final BufferedSource f5590b;

    /* renamed from: c */
    final FrameCallback f5591c;

    /* renamed from: d */
    boolean f5592d;

    /* renamed from: e */
    int f5593e;

    /* renamed from: f */
    long f5594f;

    /* renamed from: g */
    boolean f5595g;

    /* renamed from: h */
    boolean f5596h;

    /* renamed from: i */
    private final Buffer f5597i = new Buffer();

    /* renamed from: j */
    private final Buffer f5598j = new Buffer();

    /* renamed from: k */
    private final byte[] f5599k;

    /* renamed from: l */
    private final Buffer.UnsafeCursor f5600l;

    /* renamed from: okhttp3.internal.ws.WebSocketReader$FrameCallback */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback != null) {
            this.f5589a = z;
            this.f5590b = bufferedSource;
            this.f5591c = frameCallback;
            Buffer.UnsafeCursor unsafeCursor = null;
            this.f5599k = z ? null : new byte[4];
            this.f5600l = !z ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25418a() throws IOException {
        m3592b();
        if (this.f5596h) {
            m3593c();
        } else {
            m3594d();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    private void m3592b() throws IOException {
        if (!this.f5592d) {
            long timeoutNanos = this.f5590b.timeout().timeoutNanos();
            this.f5590b.timeout().clearTimeout();
            try {
                byte readByte = this.f5590b.readByte() & 255;
                this.f5590b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.f5593e = readByte & Ascii.f53593SI;
                boolean z = true;
                this.f5595g = (readByte & 128) != 0;
                boolean z2 = (readByte & 8) != 0;
                this.f5596h = z2;
                if (!z2 || this.f5595g) {
                    boolean z3 = (readByte & 64) != 0;
                    boolean z4 = (readByte & 32) != 0;
                    boolean z5 = (readByte & 16) != 0;
                    if (z3 || z4 || z5) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.f5590b.readByte() & 255;
                    if ((readByte2 & 128) == 0) {
                        z = false;
                    }
                    if (z == this.f5589a) {
                        throw new ProtocolException(this.f5589a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    long j = (long) (readByte2 & Byte.MAX_VALUE);
                    this.f5594f = j;
                    if (j == 126) {
                        this.f5594f = ((long) this.f5590b.readShort()) & 65535;
                    } else if (j == 127) {
                        long readLong = this.f5590b.readLong();
                        this.f5594f = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f5594f) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    if (this.f5596h && this.f5594f > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (z) {
                        this.f5590b.readFully(this.f5599k);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.f5590b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: c */
    private void m3593c() throws IOException {
        String str;
        long j = this.f5594f;
        if (j > 0) {
            this.f5590b.readFully(this.f5597i, j);
            if (!this.f5589a) {
                this.f5597i.readAndWriteUnsafe(this.f5600l);
                this.f5600l.seek(0);
                WebSocketProtocol.m3590a(this.f5600l, this.f5599k);
                this.f5600l.close();
            }
        }
        switch (this.f5593e) {
            case 8:
                short s = 1005;
                long size = this.f5597i.size();
                if (size != 1) {
                    if (size != 0) {
                        s = this.f5597i.readShort();
                        str = this.f5597i.readUtf8();
                        String a = WebSocketProtocol.m3589a(s);
                        if (a != null) {
                            throw new ProtocolException(a);
                        }
                    } else {
                        str = "";
                    }
                    this.f5591c.onReadClose(s, str);
                    this.f5592d = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.f5591c.onReadPing(this.f5597i.readByteString());
                return;
            case 10:
                this.f5591c.onReadPong(this.f5597i.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f5593e));
        }
    }

    /* renamed from: d */
    private void m3594d() throws IOException {
        int i = this.f5593e;
        if (i == 1 || i == 2) {
            m3596f();
            if (i == 1) {
                this.f5591c.onReadMessage(this.f5598j.readUtf8());
            } else {
                this.f5591c.onReadMessage(this.f5598j.readByteString());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
    }

    /* renamed from: e */
    private void m3595e() throws IOException {
        while (!this.f5592d) {
            m3592b();
            if (this.f5596h) {
                m3593c();
            } else {
                return;
            }
        }
    }

    /* renamed from: f */
    private void m3596f() throws IOException {
        while (!this.f5592d) {
            long j = this.f5594f;
            if (j > 0) {
                this.f5590b.readFully(this.f5598j, j);
                if (!this.f5589a) {
                    this.f5598j.readAndWriteUnsafe(this.f5600l);
                    this.f5600l.seek(this.f5598j.size() - this.f5594f);
                    WebSocketProtocol.m3590a(this.f5600l, this.f5599k);
                    this.f5600l.close();
                }
            }
            if (!this.f5595g) {
                m3595e();
                if (this.f5593e != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f5593e));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }
}

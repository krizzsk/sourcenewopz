package didihttp.internal.p229ws;

import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: didihttp.internal.ws.WebSocketReader */
final class WebSocketReader {

    /* renamed from: a */
    final boolean f56960a;

    /* renamed from: b */
    final BufferedSource f56961b;

    /* renamed from: c */
    final FrameCallback f56962c;

    /* renamed from: d */
    boolean f56963d;

    /* renamed from: e */
    int f56964e;

    /* renamed from: f */
    long f56965f;

    /* renamed from: g */
    long f56966g;

    /* renamed from: h */
    boolean f56967h;

    /* renamed from: i */
    boolean f56968i;

    /* renamed from: j */
    boolean f56969j;

    /* renamed from: k */
    final byte[] f56970k = new byte[4];

    /* renamed from: l */
    final byte[] f56971l = new byte[8192];

    /* renamed from: didihttp.internal.ws.WebSocketReader$FrameCallback */
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
            this.f56960a = z;
            this.f56961b = bufferedSource;
            this.f56962c = frameCallback;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170392a() throws IOException {
        m40881c();
        if (this.f56968i) {
            m40882d();
        } else {
            m40883e();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: c */
    private void m40881c() throws IOException {
        if (!this.f56963d) {
            long timeoutNanos = this.f56961b.timeout().timeoutNanos();
            this.f56961b.timeout().clearTimeout();
            try {
                byte readByte = this.f56961b.readByte() & 255;
                this.f56961b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.f56964e = readByte & Ascii.f53593SI;
                boolean z = true;
                this.f56967h = (readByte & 128) != 0;
                boolean z2 = (readByte & 8) != 0;
                this.f56968i = z2;
                if (!z2 || this.f56967h) {
                    boolean z3 = (readByte & 64) != 0;
                    boolean z4 = (readByte & 32) != 0;
                    boolean z5 = (readByte & 16) != 0;
                    if (z3 || z4 || z5) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.f56961b.readByte() & 255;
                    if ((readByte2 & 128) == 0) {
                        z = false;
                    }
                    this.f56969j = z;
                    if (z == this.f56960a) {
                        throw new ProtocolException(this.f56960a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    long j = (long) (readByte2 & Byte.MAX_VALUE);
                    this.f56965f = j;
                    if (j == 126) {
                        this.f56965f = ((long) this.f56961b.readShort()) & 65535;
                    } else if (j == 127) {
                        long readLong = this.f56961b.readLong();
                        this.f56965f = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f56965f) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    this.f56966g = 0;
                    if (this.f56968i && this.f56965f > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (this.f56969j) {
                        this.f56961b.readFully(this.f56970k);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.f56961b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: d */
    private void m40882d() throws IOException {
        String str;
        Buffer buffer = new Buffer();
        long j = this.f56966g;
        long j2 = this.f56965f;
        if (j < j2) {
            if (!this.f56960a) {
                while (true) {
                    long j3 = this.f56966g;
                    long j4 = this.f56965f;
                    if (j3 >= j4) {
                        break;
                    }
                    int read = this.f56961b.read(this.f56971l, 0, (int) Math.min(j4 - j3, (long) this.f56971l.length));
                    if (read != -1) {
                        long j5 = (long) read;
                        WebSocketProtocol.m40878a(this.f56971l, j5, this.f56970k, this.f56966g);
                        buffer.write(this.f56971l, 0, read);
                        this.f56966g += j5;
                    } else {
                        throw new EOFException();
                    }
                }
            } else {
                this.f56961b.readFully(buffer, j2);
            }
        }
        switch (this.f56964e) {
            case 8:
                short s = 1005;
                long size = buffer.size();
                if (size != 1) {
                    if (size != 0) {
                        s = buffer.readShort();
                        str = buffer.readUtf8();
                        String a = WebSocketProtocol.m40877a(s);
                        if (a != null) {
                            throw new ProtocolException(a);
                        }
                    } else {
                        str = "";
                    }
                    this.f56962c.onReadClose(s, str);
                    this.f56963d = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.f56962c.onReadPing(buffer.readByteString());
                return;
            case 10:
                this.f56962c.onReadPong(buffer.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f56964e));
        }
    }

    /* renamed from: e */
    private void m40883e() throws IOException {
        int i = this.f56964e;
        if (i == 1 || i == 2) {
            Buffer buffer = new Buffer();
            m40880a(buffer);
            if (i == 1) {
                this.f56962c.onReadMessage(buffer.readUtf8());
            } else {
                this.f56962c.onReadMessage(buffer.readByteString());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo170393b() throws IOException {
        while (!this.f56963d) {
            m40881c();
            if (this.f56968i) {
                m40882d();
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m40880a(Buffer buffer) throws IOException {
        long j;
        while (!this.f56963d) {
            if (this.f56966g == this.f56965f) {
                if (!this.f56967h) {
                    mo170393b();
                    if (this.f56964e != 0) {
                        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f56964e));
                    } else if (this.f56967h && this.f56965f == 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            long j2 = this.f56965f - this.f56966g;
            if (this.f56969j) {
                j = (long) this.f56961b.read(this.f56971l, 0, (int) Math.min(j2, (long) this.f56971l.length));
                if (j != -1) {
                    WebSocketProtocol.m40878a(this.f56971l, j, this.f56970k, this.f56966g);
                    buffer.write(this.f56971l, 0, (int) j);
                } else {
                    throw new EOFException();
                }
            } else {
                j = this.f56961b.read(buffer, j2);
                if (j == -1) {
                    throw new EOFException();
                }
            }
            this.f56966g += j;
        }
        throw new IOException("closed");
    }
}

package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;
import okhttp3.internal.C2434Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Http2Reader implements Closeable {

    /* renamed from: a */
    static final Logger f5461a = Logger.getLogger(Http2.class.getName());

    /* renamed from: b */
    final Hpack.Reader f5462b;

    /* renamed from: c */
    private final BufferedSource f5463c;

    /* renamed from: d */
    private final ContinuationSource f5464d;

    /* renamed from: e */
    private final boolean f5465e;

    interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.f5463c = bufferedSource;
        this.f5465e = z;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.f5464d = continuationSource;
        this.f5462b = new Hpack.Reader(4096, continuationSource);
    }

    /* renamed from: a */
    public void mo25280a(Handler handler) throws IOException {
        if (!this.f5465e) {
            ByteString readByteString = this.f5463c.readByteString((long) Http2.f5400a.size());
            if (f5461a.isLoggable(Level.FINE)) {
                f5461a.fine(C2434Util.format("<< CONNECTION %s", readByteString.hex()));
            }
            if (!Http2.f5400a.equals(readByteString)) {
                throw Http2.m3454b("Expected a connection header but was %s", readByteString.utf8());
            }
        } else if (!mo25281a(true, handler)) {
            throw Http2.m3454b("Required SETTINGS preface not received", new Object[0]);
        }
    }

    /* renamed from: a */
    public boolean mo25281a(boolean z, Handler handler) throws IOException {
        try {
            this.f5463c.require(9);
            int a = m3480a(this.f5463c);
            if (a < 0 || a > 16384) {
                throw Http2.m3454b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
            }
            byte readByte = (byte) (this.f5463c.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.f5463c.readByte() & 255);
                int readInt = this.f5463c.readInt() & Integer.MAX_VALUE;
                if (f5461a.isLoggable(Level.FINE)) {
                    f5461a.fine(Http2.m3453a(true, readInt, a, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        m3484b(handler, a, readByte2, readInt);
                        break;
                    case 1:
                        m3483a(handler, a, readByte2, readInt);
                        break;
                    case 2:
                        m3485c(handler, a, readByte2, readInt);
                        break;
                    case 3:
                        m3486d(handler, a, readByte2, readInt);
                        break;
                    case 4:
                        m3487e(handler, a, readByte2, readInt);
                        break;
                    case 5:
                        m3488f(handler, a, readByte2, readInt);
                        break;
                    case 6:
                        m3489g(handler, a, readByte2, readInt);
                        break;
                    case 7:
                        m3490h(handler, a, readByte2, readInt);
                        break;
                    case 8:
                        m3491i(handler, a, readByte2, readInt);
                        break;
                    default:
                        this.f5463c.skip((long) a);
                        break;
                }
                return true;
            }
            throw Http2.m3454b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m3483a(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.f5463c.readByte() & 255);
            }
            if ((b & 32) != 0) {
                m3482a(handler, i2);
                i -= 5;
            }
            handler.headers(z, i2, -1, m3481a(m3479a(i, b, s), s, b, i2));
            return;
        }
        throw Http2.m3454b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    /* renamed from: a */
    private List<Header> m3481a(int i, short s, byte b, int i2) throws IOException {
        ContinuationSource continuationSource = this.f5464d;
        continuationSource.left = i;
        continuationSource.length = i;
        this.f5464d.padding = s;
        this.f5464d.flags = b;
        this.f5464d.streamId = i2;
        this.f5462b.readHeaders();
        return this.f5462b.getAndResetHeaderList();
    }

    /* renamed from: b */
    private void m3484b(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.f5463c.readByte() & 255);
                }
                handler.data(z2, i2, this.f5463c, m3479a(i, b, s));
                this.f5463c.skip((long) s);
                return;
            }
            throw Http2.m3454b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw Http2.m3454b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    /* renamed from: c */
    private void m3485c(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw Http2.m3454b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 != 0) {
            m3482a(handler, i2);
        } else {
            throw Http2.m3454b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    /* renamed from: a */
    private void m3482a(Handler handler, int i) throws IOException {
        int readInt = this.f5463c.readInt();
        handler.priority(i, readInt & Integer.MAX_VALUE, (this.f5463c.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    /* renamed from: d */
    private void m3486d(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.m3454b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 != 0) {
            int readInt = this.f5463c.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                handler.rstStream(i2, fromHttp2);
            } else {
                throw Http2.m3454b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            }
        } else {
            throw Http2.m3454b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    /* renamed from: e */
    private void m3487e(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw Http2.m3454b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b & 1) != 0) {
            if (i == 0) {
                handler.ackSettings();
                return;
            }
            throw Http2.m3454b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i % 6 == 0) {
            Settings settings = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short readShort = this.f5463c.readShort() & UShort.MAX_VALUE;
                int readInt = this.f5463c.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            throw Http2.m3454b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        throw Http2.m3454b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    throw Http2.m3454b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                settings.mo25315a(readShort, readInt);
            }
            handler.settings(false, settings);
        } else {
            throw Http2.m3454b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
    }

    /* renamed from: f */
    private void m3488f(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.f5463c.readByte() & 255);
            }
            handler.pushPromise(i2, this.f5463c.readInt() & Integer.MAX_VALUE, m3481a(m3479a(i - 4, b, s), s, b, i2));
            return;
        }
        throw Http2.m3454b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    /* renamed from: g */
    private void m3489g(Handler handler, int i, byte b, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            throw Http2.m3454b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int readInt = this.f5463c.readInt();
            int readInt2 = this.f5463c.readInt();
            if ((b & 1) != 0) {
                z = true;
            }
            handler.ping(z, readInt, readInt2);
        } else {
            throw Http2.m3454b("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    /* renamed from: h */
    private void m3490h(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw Http2.m3454b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int readInt = this.f5463c.readInt();
            int readInt2 = this.f5463c.readInt();
            int i3 = i - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i3 > 0) {
                    byteString = this.f5463c.readByteString((long) i3);
                }
                handler.goAway(readInt, fromHttp2, byteString);
                return;
            }
            throw Http2.m3454b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        } else {
            throw Http2.m3454b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    /* renamed from: i */
    private void m3491i(Handler handler, int i, byte b, int i2) throws IOException {
        if (i == 4) {
            long readInt = ((long) this.f5463c.readInt()) & 2147483647L;
            if (readInt != 0) {
                handler.windowUpdate(i2, readInt);
            } else {
                throw Http2.m3454b("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
        } else {
            throw Http2.m3454b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
    }

    public void close() throws IOException {
        this.f5463c.close();
    }

    static final class ContinuationSource implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        public void close() throws IOException {
        }

        ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        public long read(Buffer buffer, long j) throws IOException {
            while (true) {
                int i = this.left;
                if (i == 0) {
                    this.source.skip((long) this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(buffer, Math.min(j, (long) i));
                    if (read == -1) {
                        return -1;
                    }
                    this.left = (int) (((long) this.left) - read);
                    return read;
                }
            }
        }

        public Timeout timeout() {
            return this.source.timeout();
        }

        private void readContinuationHeader() throws IOException {
            int i = this.streamId;
            int a = Http2Reader.m3480a(this.source);
            this.left = a;
            this.length = a;
            byte readByte = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            if (Http2Reader.f5461a.isLoggable(Level.FINE)) {
                Http2Reader.f5461a.fine(Http2.m3453a(true, this.streamId, this.length, readByte, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (readByte != 9) {
                throw Http2.m3454b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (readInt != i) {
                throw Http2.m3454b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    static int m3480a(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* renamed from: a */
    static int m3479a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw Http2.m3454b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}

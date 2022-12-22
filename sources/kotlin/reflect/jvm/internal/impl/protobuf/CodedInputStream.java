package kotlin.reflect.jvm.internal.impl.protobuf;

import android.view.View;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

public final class CodedInputStream {

    /* renamed from: a */
    private final byte[] f60747a;

    /* renamed from: b */
    private final boolean f60748b;

    /* renamed from: c */
    private int f60749c;

    /* renamed from: d */
    private int f60750d;

    /* renamed from: e */
    private int f60751e;

    /* renamed from: f */
    private final InputStream f60752f;

    /* renamed from: g */
    private int f60753g;

    /* renamed from: h */
    private boolean f60754h;

    /* renamed from: i */
    private int f60755i;

    /* renamed from: j */
    private int f60756j;

    /* renamed from: k */
    private int f60757k;

    /* renamed from: l */
    private int f60758l;

    /* renamed from: m */
    private int f60759m;

    /* renamed from: n */
    private RefillCallback f60760n;

    private interface RefillCallback {
        void onRefill();
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    /* renamed from: a */
    static CodedInputStream m44778a(LiteralByteString literalByteString) {
        CodedInputStream codedInputStream = new CodedInputStream(literalByteString);
        try {
            codedInputStream.pushLimit(literalByteString.size());
            return codedInputStream;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.f60753g = 0;
            return 0;
        }
        int readRawVarint32 = readRawVarint32();
        this.f60753g = readRawVarint32;
        if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
            return this.f60753g;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
        if (this.f60753g != i) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
        int a = WireFormat.m44829a(i);
        if (a == 0) {
            long readInt64 = readInt64();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeUInt64NoTag(readInt64);
            return true;
        } else if (a == 1) {
            long readRawLittleEndian64 = readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
            return true;
        } else if (a == 2) {
            ByteString readBytes = readBytes();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeBytesNoTag(readBytes);
            return true;
        } else if (a == 3) {
            codedOutputStream.writeRawVarint32(i);
            skipMessage(codedOutputStream);
            int a2 = WireFormat.m44830a(WireFormat.getTagFieldNumber(i), 4);
            checkLastTagWas(a2);
            codedOutputStream.writeRawVarint32(a2);
            return true;
        } else if (a == 4) {
            return false;
        } else {
            if (a == 5) {
                int readRawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void skipMessage(kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r2) throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.readTag()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.skipField(r0, r2)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.skipMessage(kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream):void");
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public boolean readBool() throws IOException {
        return readRawVarint64() != 0;
    }

    public String readString() throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 <= this.f60749c - this.f60751e && readRawVarint32 > 0) {
            String str = new String(this.f60747a, this.f60751e, readRawVarint32, "UTF-8");
            this.f60751e += readRawVarint32;
            return str;
        } else if (readRawVarint32 == 0) {
            return "";
        } else {
            return new String(m44783d(readRawVarint32), "UTF-8");
        }
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] bArr;
        int readRawVarint32 = readRawVarint32();
        int i = this.f60751e;
        if (readRawVarint32 <= this.f60749c - i && readRawVarint32 > 0) {
            bArr = this.f60747a;
            this.f60751e = i + readRawVarint32;
        } else if (readRawVarint32 == 0) {
            return "";
        } else {
            bArr = m44783d(readRawVarint32);
            i = 0;
        }
        if (C21706a.m44836a(bArr, i, i + readRawVarint32)) {
            return new String(bArr, i, readRawVarint32, "UTF-8");
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i2 = this.f60757k;
        if (i2 < this.f60758l) {
            this.f60757k = i2 + 1;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.m44830a(i, 4));
            this.f60757k--;
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.f60757k < this.f60758l) {
            int pushLimit = pushLimit(readRawVarint32);
            this.f60757k++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.f60757k--;
            popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.f60757k < this.f60758l) {
            int pushLimit = pushLimit(readRawVarint32);
            this.f60757k++;
            T t = (MessageLite) parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.f60757k--;
            popLimit(pushLimit);
            return t;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public ByteString readBytes() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i = this.f60749c;
        int i2 = this.f60751e;
        if (readRawVarint32 <= i - i2 && readRawVarint32 > 0) {
            ByteString copyFrom = (!this.f60748b || !this.f60754h) ? ByteString.copyFrom(this.f60747a, this.f60751e, readRawVarint32) : new BoundedByteString(this.f60747a, i2, readRawVarint32);
            this.f60751e += readRawVarint32;
            return copyFrom;
        } else if (readRawVarint32 == 0) {
            return ByteString.EMPTY;
        } else {
            return new LiteralByteString(m44783d(readRawVarint32));
        }
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        if (r2[r3] < 0) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int readRawVarint32() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f60751e
            int r1 = r9.f60749c
            if (r1 != r0) goto L_0x0008
            goto L_0x007c
        L_0x0008:
            byte[] r2 = r9.f60747a
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0013
            r9.f60751e = r3
            return r0
        L_0x0013:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L_0x0019
            goto L_0x007c
        L_0x0019:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            long r3 = (long) r0
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x002d
            r5 = -128(0xffffffffffffff80, double:NaN)
        L_0x0029:
            long r2 = r3 ^ r5
            int r0 = (int) r2
            goto L_0x0082
        L_0x002d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            long r7 = (long) r0
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x003f
            r0 = 16256(0x3f80, double:8.0315E-320)
            long r0 = r0 ^ r7
            int r0 = (int) r0
        L_0x003d:
            r1 = r3
            goto L_0x0082
        L_0x003f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            long r3 = (long) r0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x004f
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L_0x0029
        L_0x004f:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            long r4 = (long) r0
            r6 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r4 = r4 ^ r6
            int r0 = (int) r4
            if (r1 >= 0) goto L_0x003d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0082
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x003d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0082
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x003d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 >= 0) goto L_0x0082
        L_0x007c:
            long r0 = r9.mo179157a()
            int r1 = (int) r0
            return r1
        L_0x0082:
            r9.f60751e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawVarint32():int");
    }

    public static int readRawVarint32(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i2 |= (read & 127) << i3;
                if ((read & 128) == 0) {
                    return i2;
                }
                i3 += 7;
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if ((read2 & 128) == 0) {
                return i2;
            } else {
                i3 += 7;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b6, code lost:
        if (((long) r2[r0]) < 0) goto L_0x00b8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readRawVarint64() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f60751e
            int r1 = r9.f60749c
            if (r1 != r0) goto L_0x0008
            goto L_0x00b8
        L_0x0008:
            byte[] r2 = r9.f60747a
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0014
            r9.f60751e = r3
            long r0 = (long) r0
            return r0
        L_0x0014:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L_0x001b
            goto L_0x00b8
        L_0x001b:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            long r3 = (long) r0
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x002f
            r5 = -128(0xffffffffffffff80, double:NaN)
        L_0x002b:
            long r2 = r3 ^ r5
            goto L_0x00bf
        L_0x002f:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            long r7 = (long) r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0042
            r1 = 16256(0x3f80, double:8.0315E-320)
        L_0x003d:
            long r2 = r3 ^ r1
            r1 = r0
            goto L_0x00bf
        L_0x0042:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            int r0 = r0 << 21
            long r7 = (long) r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0052
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L_0x002b
        L_0x0052:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 28
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0063
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            goto L_0x003d
        L_0x0063:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0076
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            goto L_0x002b
        L_0x0076:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0089
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x003d
        L_0x0089:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x009c
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x002b
        L_0x009c:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00bd
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00be
        L_0x00b8:
            long r0 = r9.mo179157a()
            return r0
        L_0x00bd:
            r1 = r0
        L_0x00be:
            r2 = r3
        L_0x00bf:
            r9.f60751e = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawVarint64():long");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo179157a() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte readRawByte = readRawByte();
            j |= ((long) (readRawByte & Byte.MAX_VALUE)) << i;
            if ((readRawByte & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readRawLittleEndian32() throws IOException {
        int i = this.f60751e;
        if (this.f60749c - i < 4) {
            m44781b(4);
            i = this.f60751e;
        }
        byte[] bArr = this.f60747a;
        this.f60751e = i + 4;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public long readRawLittleEndian64() throws IOException {
        int i = this.f60751e;
        if (this.f60749c - i < 8) {
            m44781b(8);
            i = this.f60751e;
        }
        byte[] bArr = this.f60747a;
        this.f60751e = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private CodedInputStream(InputStream inputStream) {
        this.f60754h = false;
        this.f60756j = Integer.MAX_VALUE;
        this.f60758l = 64;
        this.f60759m = View.STATUS_BAR_TRANSIENT;
        this.f60760n = null;
        this.f60747a = new byte[4096];
        this.f60749c = 0;
        this.f60751e = 0;
        this.f60755i = 0;
        this.f60752f = inputStream;
        this.f60748b = false;
    }

    private CodedInputStream(LiteralByteString literalByteString) {
        this.f60754h = false;
        this.f60756j = Integer.MAX_VALUE;
        this.f60758l = 64;
        this.f60759m = View.STATUS_BAR_TRANSIENT;
        this.f60760n = null;
        this.f60747a = literalByteString.f60778b;
        int a = literalByteString.mo179128a();
        this.f60751e = a;
        this.f60749c = a + literalByteString.size();
        this.f60755i = -this.f60751e;
        this.f60752f = null;
        this.f60748b = true;
    }

    public int pushLimit(int i) throws InvalidProtocolBufferException {
        if (i >= 0) {
            int i2 = i + this.f60755i + this.f60751e;
            int i3 = this.f60756j;
            if (i2 <= i3) {
                this.f60756j = i2;
                m44780b();
                return i3;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* renamed from: b */
    private void m44780b() {
        int i = this.f60749c + this.f60750d;
        this.f60749c = i;
        int i2 = this.f60755i + i;
        int i3 = this.f60756j;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.f60750d = i4;
            this.f60749c = i - i4;
            return;
        }
        this.f60750d = 0;
    }

    public void popLimit(int i) {
        this.f60756j = i;
        m44780b();
    }

    public int getBytesUntilLimit() {
        int i = this.f60756j;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.f60755i + this.f60751e);
    }

    public boolean isAtEnd() throws IOException {
        return this.f60751e == this.f60749c && !m44782c(1);
    }

    /* renamed from: a */
    private void m44779a(int i) throws IOException {
        if (this.f60749c - this.f60751e < i) {
            m44781b(i);
        }
    }

    /* renamed from: b */
    private void m44781b(int i) throws IOException {
        if (!m44782c(i)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    /* renamed from: c */
    private boolean m44782c(int i) throws IOException {
        int i2 = this.f60751e;
        if (i2 + i <= this.f60749c) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        } else if (this.f60755i + i2 + i > this.f60756j) {
            return false;
        } else {
            RefillCallback refillCallback = this.f60760n;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            if (this.f60752f != null) {
                int i3 = this.f60751e;
                if (i3 > 0) {
                    int i4 = this.f60749c;
                    if (i4 > i3) {
                        byte[] bArr = this.f60747a;
                        System.arraycopy(bArr, i3, bArr, 0, i4 - i3);
                    }
                    this.f60755i += i3;
                    this.f60749c -= i3;
                    this.f60751e = 0;
                }
                InputStream inputStream = this.f60752f;
                byte[] bArr2 = this.f60747a;
                int i5 = this.f60749c;
                int read = inputStream.read(bArr2, i5, bArr2.length - i5);
                if (read == 0 || read < -1 || read > this.f60747a.length) {
                    StringBuilder sb2 = new StringBuilder(102);
                    sb2.append("InputStream#read(byte[]) returned invalid result: ");
                    sb2.append(read);
                    sb2.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb2.toString());
                } else if (read > 0) {
                    this.f60749c += read;
                    if ((this.f60755i + i) - this.f60759m <= 0) {
                        m44780b();
                        if (this.f60749c >= i) {
                            return true;
                        }
                        return m44782c(i);
                    }
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
            }
            return false;
        }
    }

    public byte readRawByte() throws IOException {
        if (this.f60751e == this.f60749c) {
            m44781b(1);
        }
        byte[] bArr = this.f60747a;
        int i = this.f60751e;
        this.f60751e = i + 1;
        return bArr[i];
    }

    /* renamed from: d */
    private byte[] m44783d(int i) throws IOException {
        if (i > 0) {
            int i2 = this.f60755i;
            int i3 = this.f60751e;
            int i4 = i2 + i3 + i;
            int i5 = this.f60756j;
            if (i4 > i5) {
                skipRawBytes((i5 - i2) - i3);
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i < 4096) {
                byte[] bArr = new byte[i];
                int i6 = this.f60749c - i3;
                System.arraycopy(this.f60747a, i3, bArr, 0, i6);
                this.f60751e = this.f60749c;
                int i7 = i - i6;
                m44779a(i7);
                System.arraycopy(this.f60747a, 0, bArr, i6, i7);
                this.f60751e = i7;
                return bArr;
            } else {
                int i8 = this.f60749c;
                this.f60755i = i2 + i8;
                this.f60751e = 0;
                this.f60749c = 0;
                int i9 = i8 - i3;
                int i10 = i - i9;
                ArrayList<byte[]> arrayList = new ArrayList<>();
                while (i10 > 0) {
                    int min = Math.min(i10, 4096);
                    byte[] bArr2 = new byte[min];
                    int i11 = 0;
                    while (i11 < min) {
                        InputStream inputStream = this.f60752f;
                        int read = inputStream == null ? -1 : inputStream.read(bArr2, i11, min - i11);
                        if (read != -1) {
                            this.f60755i += read;
                            i11 += read;
                        } else {
                            throw InvalidProtocolBufferException.truncatedMessage();
                        }
                    }
                    i10 -= min;
                    arrayList.add(bArr2);
                }
                byte[] bArr3 = new byte[i];
                System.arraycopy(this.f60747a, i3, bArr3, 0, i9);
                for (byte[] bArr4 : arrayList) {
                    System.arraycopy(bArr4, 0, bArr3, i9, bArr4.length);
                    i9 += bArr4.length;
                }
                return bArr3;
            }
        } else if (i == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    public void skipRawBytes(int i) throws IOException {
        int i2 = this.f60749c;
        int i3 = this.f60751e;
        if (i > i2 - i3 || i < 0) {
            m44784e(i);
        } else {
            this.f60751e = i3 + i;
        }
    }

    /* renamed from: e */
    private void m44784e(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.f60755i;
            int i3 = this.f60751e;
            int i4 = i2 + i3 + i;
            int i5 = this.f60756j;
            if (i4 <= i5) {
                int i6 = this.f60749c;
                int i7 = i6 - i3;
                this.f60751e = i6;
                m44781b(1);
                while (true) {
                    int i8 = i - i7;
                    int i9 = this.f60749c;
                    if (i8 > i9) {
                        i7 += i9;
                        this.f60751e = i9;
                        m44781b(1);
                    } else {
                        this.f60751e = i8;
                        return;
                    }
                }
            } else {
                skipRawBytes((i5 - i2) - i3);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }
}

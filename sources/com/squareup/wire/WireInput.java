package com.squareup.wire;

import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class WireInput {
    private static final String ENCOUNTERED_A_MALFORMED_VARINT = "WireInput encountered a malformed varint.";
    private static final String ENCOUNTERED_A_NEGATIVE_SIZE = "Encountered a negative size";
    private static final String INPUT_ENDED_UNEXPECTEDLY = "The input ended unexpectedly in the middle of a field";
    private static final String PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO = "Protocol message contained an invalid tag (zero).";
    private static final String PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG = "Protocol message end-group tag did not match expected tag.";
    public static final int RECURSION_LIMIT = 64;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private int currentLimit = Integer.MAX_VALUE;
    private int lastTag;
    private int pos = 0;
    public int recursionDepth;
    private final BufferedSource source;

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static WireInput newInstance(byte[] bArr) {
        return new WireInput(new Buffer().write(bArr));
    }

    public static WireInput newInstance(byte[] bArr, int i, int i2) {
        return new WireInput(new Buffer().write(bArr, i, i2));
    }

    public static WireInput newInstance(InputStream inputStream) {
        return new WireInput(Okio.buffer(Okio.source(inputStream)));
    }

    public static WireInput newInstance(Source source2) {
        return new WireInput(Okio.buffer(source2));
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int readVarint32 = readVarint32();
        this.lastTag = readVarint32;
        if (readVarint32 != 0) {
            return readVarint32;
        }
        throw new IOException(PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO);
    }

    public void checkLastTagWas(int i) throws IOException {
        if (this.lastTag != i) {
            throw new IOException(PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG);
        }
    }

    public String readString() throws IOException {
        int readVarint32 = readVarint32();
        this.pos += readVarint32;
        return this.source.readString((long) readVarint32, UTF_8);
    }

    public ByteString readBytes() throws IOException {
        return readBytes(readVarint32());
    }

    public ByteString readBytes(int i) throws IOException {
        this.pos += i;
        long j = (long) i;
        this.source.require(j);
        return this.source.readByteString(j);
    }

    public int readVarint32() throws IOException {
        int i;
        this.pos++;
        byte readByte = this.source.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        byte b = readByte & Byte.MAX_VALUE;
        this.pos++;
        byte readByte2 = this.source.readByte();
        if (readByte2 >= 0) {
            i = readByte2 << 7;
        } else {
            b |= (readByte2 & Byte.MAX_VALUE) << 7;
            this.pos++;
            byte readByte3 = this.source.readByte();
            if (readByte3 >= 0) {
                i = readByte3 << Ascii.f53594SO;
            } else {
                b |= (readByte3 & Byte.MAX_VALUE) << Ascii.f53594SO;
                this.pos++;
                byte readByte4 = this.source.readByte();
                if (readByte4 >= 0) {
                    i = readByte4 << Ascii.NAK;
                } else {
                    byte b2 = b | ((readByte4 & Byte.MAX_VALUE) << Ascii.NAK);
                    this.pos++;
                    byte readByte5 = this.source.readByte();
                    byte b3 = b2 | (readByte5 << Ascii.f53587FS);
                    if (readByte5 >= 0) {
                        return b3;
                    }
                    for (int i2 = 0; i2 < 5; i2++) {
                        this.pos++;
                        if (this.source.readByte() >= 0) {
                            return b3;
                        }
                    }
                    throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
                }
            }
        }
        return b | i;
    }

    public long readVarint64() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            this.pos++;
            byte readByte = this.source.readByte();
            j |= ((long) (readByte & Byte.MAX_VALUE)) << i;
            if ((readByte & 128) == 0) {
                return j;
            }
        }
        throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
    }

    public int readFixed32() throws IOException {
        this.pos += 4;
        return this.source.readIntLe();
    }

    public long readFixed64() throws IOException {
        this.pos += 8;
        return this.source.readLongLe();
    }

    private WireInput(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    public int pushLimit(int i) throws IOException {
        if (i >= 0) {
            int i2 = i + this.pos;
            int i3 = this.currentLimit;
            if (i2 <= i3) {
                this.currentLimit = i2;
                return i3;
            }
            throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
        }
        throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
    }

    public void popLimit(int i) {
        this.currentLimit = i;
    }

    private boolean isAtEnd() throws IOException {
        if (getPosition() == ((long) this.currentLimit)) {
            return true;
        }
        return this.source.exhausted();
    }

    public long getPosition() {
        return (long) this.pos;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void skipGroup() throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.readTag()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.skipField(r0)
            if (r0 == 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.WireInput.skipGroup():void");
    }

    /* renamed from: com.squareup.wire.WireInput$1 */
    static /* synthetic */ class C205841 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$WireType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.squareup.wire.WireType[] r0 = com.squareup.wire.WireType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$squareup$wire$WireType = r0
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.VARINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.LENGTH_DELIMITED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.START_GROUP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.END_GROUP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.WireInput.C205841.<clinit>():void");
        }
    }

    private boolean skipField(int i) throws IOException {
        switch (C205841.$SwitchMap$com$squareup$wire$WireType[WireType.valueOf(i).ordinal()]) {
            case 1:
                readVarint64();
                return false;
            case 2:
                readFixed32();
                return false;
            case 3:
                readFixed64();
                return false;
            case 4:
                skip((long) readVarint32());
                return false;
            case 5:
                skipGroup();
                checkLastTagWas((i & -8) | WireType.END_GROUP.value());
                return false;
            case 6:
                return true;
            default:
                throw new AssertionError();
        }
    }

    private void skip(long j) throws IOException {
        this.pos = (int) (((long) this.pos) + j);
        this.source.skip(j);
    }
}

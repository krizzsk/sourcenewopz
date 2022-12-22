package com.koushikdutta.async.http;

import com.didi.sdk.apm.SystemUtils;
import com.google.common.base.Ascii;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataEmitterReader;
import com.koushikdutta.async.callback.DataCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

abstract class HybiParser {
    private static final long BASE = 2;
    private static final int BYTE = 255;
    private static final int FIN = 128;
    private static final List<Integer> FRAGMENTED_OPCODES = Arrays.asList(new Integer[]{0, 1, 2});
    private static final int LENGTH = 127;
    private static final int MASK = 128;
    private static final int MODE_BINARY = 2;
    private static final int MODE_TEXT = 1;
    private static final int OPCODE = 15;
    private static final List<Integer> OPCODES = Arrays.asList(new Integer[]{0, 1, 2, 8, 9, 10});
    private static final int OP_BINARY = 2;
    private static final int OP_CLOSE = 8;
    private static final int OP_CONTINUATION = 0;
    private static final int OP_PING = 9;
    private static final int OP_PONG = 10;
    private static final int OP_TEXT = 1;
    private static final int RSV1 = 64;
    private static final int RSV2 = 32;
    private static final int RSV3 = 16;
    private static final String TAG = "HybiParser";
    private static final long _2_TO_16_ = 65536;
    private static final long _2_TO_24 = 16777216;
    private static final long _2_TO_32_ = 4294967296L;
    private static final long _2_TO_40_ = 1099511627776L;
    private static final long _2_TO_48_ = 281474976710656L;
    private static final long _2_TO_56_ = 72057594037927936L;
    private static final long _2_TO_8_ = 256;
    private ByteArrayOutputStream mBuffer = new ByteArrayOutputStream();
    private boolean mClosed = false;
    private boolean mDeflate = false;
    private boolean mDeflated;
    private boolean mFinal;
    private byte[] mInflateBuffer = new byte[4096];
    private Inflater mInflater = new Inflater(true);
    /* access modifiers changed from: private */
    public int mLength;
    /* access modifiers changed from: private */
    public int mLengthSize;
    /* access modifiers changed from: private */
    public byte[] mMask = new byte[0];
    private boolean mMasked;
    private boolean mMasking = true;
    private int mMode;
    private int mOpcode;
    /* access modifiers changed from: private */
    public byte[] mPayload = new byte[0];
    private DataEmitterReader mReader;
    /* access modifiers changed from: private */
    public int mStage;
    DataCallback mStage0 = new DataCallback() {
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            try {
                HybiParser.this.parseOpcode(byteBufferList.get());
            } catch (ProtocolError e) {
                HybiParser.this.report(e);
                e.printStackTrace();
            }
            HybiParser.this.parse();
        }
    };
    DataCallback mStage1 = new DataCallback() {
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            HybiParser.this.parseLength(byteBufferList.get());
            HybiParser.this.parse();
        }
    };
    DataCallback mStage2 = new DataCallback() {
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[HybiParser.this.mLengthSize];
            byteBufferList.get(bArr);
            try {
                HybiParser.this.parseExtendedLength(bArr);
            } catch (ProtocolError e) {
                HybiParser.this.report(e);
                e.printStackTrace();
            }
            HybiParser.this.parse();
        }
    };
    DataCallback mStage3 = new DataCallback() {
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            byte[] unused = HybiParser.this.mMask = new byte[4];
            byteBufferList.get(HybiParser.this.mMask);
            int unused2 = HybiParser.this.mStage = 4;
            HybiParser.this.parse();
        }
    };
    DataCallback mStage4 = new DataCallback() {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
            Class<HybiParser> cls = HybiParser.class;
        }

        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            HybiParser hybiParser = HybiParser.this;
            byte[] unused = hybiParser.mPayload = new byte[hybiParser.mLength];
            byteBufferList.get(HybiParser.this.mPayload);
            try {
                HybiParser.this.emitFrame();
            } catch (IOException e) {
                HybiParser.this.report(e);
                e.printStackTrace();
            }
            int unused2 = HybiParser.this.mStage = 0;
            HybiParser.this.parse();
        }
    };

    /* access modifiers changed from: protected */
    public abstract void onDisconnect(int i, String str);

    /* access modifiers changed from: protected */
    public abstract void onMessage(String str);

    /* access modifiers changed from: protected */
    public abstract void onMessage(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract void onPing(String str);

    /* access modifiers changed from: protected */
    public abstract void onPong(String str);

    /* access modifiers changed from: protected */
    public abstract void report(Exception exc);

    /* access modifiers changed from: protected */
    public abstract void sendFrame(byte[] bArr);

    private static byte[] mask(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length == 0) {
            return bArr;
        }
        for (int i2 = 0; i2 < bArr.length - i; i2++) {
            int i3 = i + i2;
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i2 % 4]);
        }
        return bArr;
    }

    private byte[] inflate(byte[] bArr) throws DataFormatException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.mInflater.setInput(bArr);
        while (!this.mInflater.needsInput()) {
            byteArrayOutputStream.write(this.mInflateBuffer, 0, this.mInflater.inflate(this.mInflateBuffer));
        }
        this.mInflater.setInput(new byte[]{0, 0, -1, -1});
        while (!this.mInflater.needsInput()) {
            byteArrayOutputStream.write(this.mInflateBuffer, 0, this.mInflater.inflate(this.mInflateBuffer));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void setMasking(boolean z) {
        this.mMasking = z;
    }

    public void setDeflate(boolean z) {
        this.mDeflate = z;
    }

    /* access modifiers changed from: package-private */
    public void parse() {
        int i = this.mStage;
        if (i == 0) {
            this.mReader.read(1, this.mStage0);
        } else if (i == 1) {
            this.mReader.read(1, this.mStage1);
        } else if (i == 2) {
            this.mReader.read(this.mLengthSize, this.mStage2);
        } else if (i == 3) {
            this.mReader.read(4, this.mStage3);
        } else if (i == 4) {
            this.mReader.read(this.mLength, this.mStage4);
        }
    }

    public HybiParser(DataEmitter dataEmitter) {
        DataEmitterReader dataEmitterReader = new DataEmitterReader();
        this.mReader = dataEmitterReader;
        dataEmitter.setDataCallback(dataEmitterReader);
        parse();
    }

    /* access modifiers changed from: private */
    public void parseOpcode(byte b) throws ProtocolError {
        boolean z = (b & 64) == 64;
        boolean z2 = (b & 32) == 32;
        boolean z3 = (b & 16) == 16;
        if ((this.mDeflate || !z) && !z2 && !z3) {
            this.mFinal = (b & 128) == 128;
            byte b2 = b & Ascii.f53593SI;
            this.mOpcode = b2;
            this.mDeflated = z;
            this.mMask = new byte[0];
            this.mPayload = new byte[0];
            if (!OPCODES.contains(Integer.valueOf(b2))) {
                throw new ProtocolError("Bad opcode");
            } else if (FRAGMENTED_OPCODES.contains(Integer.valueOf(this.mOpcode)) || this.mFinal) {
                this.mStage = 1;
            } else {
                throw new ProtocolError("Expected non-final packet");
            }
        } else {
            throw new ProtocolError("RSV not zero");
        }
    }

    /* access modifiers changed from: private */
    public void parseLength(byte b) {
        boolean z = (b & 128) == 128;
        this.mMasked = z;
        byte b2 = b & Byte.MAX_VALUE;
        this.mLength = b2;
        if (b2 < 0 || b2 > 125) {
            this.mLengthSize = this.mLength == 126 ? 2 : 8;
            this.mStage = 2;
            return;
        }
        this.mStage = z ? 3 : 4;
    }

    /* access modifiers changed from: private */
    public void parseExtendedLength(byte[] bArr) throws ProtocolError {
        this.mLength = getInteger(bArr);
        this.mStage = this.mMasked ? 3 : 4;
    }

    public byte[] frame(String str) {
        return frame(1, str, -1);
    }

    public byte[] frame(byte[] bArr) {
        return frame(2, bArr, -1);
    }

    public byte[] frame(byte[] bArr, int i, int i2) {
        return frame(2, bArr, -1, i, i2);
    }

    public byte[] pingFrame(String str) {
        return frame(9, str, -1);
    }

    public byte[] pongFrame(String str) {
        return frame(10, str, -1);
    }

    private byte[] frame(int i, byte[] bArr, int i2) {
        return frame(i, bArr, i2, 0, bArr.length);
    }

    private byte[] frame(int i, String str, int i2) {
        return frame(i, decode(str), i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] frame(int r22, byte[] r23, int r24, int r25, int r26) {
        /*
            r21 = this;
            r0 = r21
            r1 = r24
            r2 = r25
            boolean r3 = r0.mClosed
            if (r3 == 0) goto L_0x000c
            r1 = 0
            return r1
        L_0x000c:
            r3 = 2
            r4 = 0
            if (r1 <= 0) goto L_0x0012
            r5 = 2
            goto L_0x0013
        L_0x0012:
            r5 = 0
        L_0x0013:
            int r6 = r26 + r5
            int r6 = r6 - r2
            r7 = 65535(0xffff, float:9.1834E-41)
            r8 = 125(0x7d, float:1.75E-43)
            r9 = 4
            if (r6 > r8) goto L_0x0020
            r10 = 2
            goto L_0x0026
        L_0x0020:
            if (r6 > r7) goto L_0x0024
            r10 = 4
            goto L_0x0026
        L_0x0024:
            r10 = 10
        L_0x0026:
            boolean r11 = r0.mMasking
            if (r11 == 0) goto L_0x002c
            r11 = 4
            goto L_0x002d
        L_0x002c:
            r11 = 0
        L_0x002d:
            int r11 = r11 + r10
            boolean r12 = r0.mMasking
            if (r12 == 0) goto L_0x0035
            r12 = 128(0x80, float:1.794E-43)
            goto L_0x0036
        L_0x0035:
            r12 = 0
        L_0x0036:
            int r13 = r6 + r11
            byte[] r13 = new byte[r13]
            r14 = r22
            byte r14 = (byte) r14
            r14 = r14 | -128(0xffffffffffffff80, float:NaN)
            byte r14 = (byte) r14
            r13[r4] = r14
            r14 = 3
            r15 = 1
            if (r6 > r8) goto L_0x004d
            r6 = r6 | r12
            byte r6 = (byte) r6
            r13[r15] = r6
        L_0x004a:
            r20 = r5
            goto L_0x00c2
        L_0x004d:
            if (r6 > r7) goto L_0x005f
            r7 = r12 | 126(0x7e, float:1.77E-43)
            byte r7 = (byte) r7
            r13[r15] = r7
            int r7 = r6 / 256
            byte r7 = (byte) r7
            r13[r3] = r7
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = (byte) r6
            r13[r14] = r6
            goto L_0x004a
        L_0x005f:
            r7 = r12 | 127(0x7f, float:1.78E-43)
            byte r7 = (byte) r7
            r13[r15] = r7
            long r7 = (long) r6
            r16 = 72057594037927936(0x100000000000000, double:7.2911220195563975E-304)
            long r16 = r7 / r16
            r18 = 255(0xff, double:1.26E-321)
            r20 = r5
            long r4 = r16 & r18
            int r5 = (int) r4
            byte r4 = (byte) r5
            r13[r3] = r4
            r4 = 281474976710656(0x1000000000000, double:1.390671161567E-309)
            long r4 = r7 / r4
            long r4 = r4 & r18
            int r5 = (int) r4
            byte r4 = (byte) r5
            r13[r14] = r4
            r4 = 1099511627776(0x10000000000, double:5.43230922487E-312)
            long r4 = r7 / r4
            long r4 = r4 & r18
            int r5 = (int) r4
            byte r4 = (byte) r5
            r13[r9] = r4
            r4 = 5
            r16 = 4294967296(0x100000000, double:2.121995791E-314)
            long r16 = r7 / r16
            long r14 = r16 & r18
            int r15 = (int) r14
            byte r14 = (byte) r15
            r13[r4] = r14
            r4 = 6
            r14 = 16777216(0x1000000, double:8.289046E-317)
            long r14 = r7 / r14
            long r14 = r14 & r18
            int r15 = (int) r14
            byte r14 = (byte) r15
            r13[r4] = r14
            r4 = 7
            r14 = 65536(0x10000, double:3.2379E-319)
            long r14 = r7 / r14
            long r14 = r14 & r18
            int r15 = (int) r14
            byte r14 = (byte) r15
            r13[r4] = r14
            r4 = 8
            r14 = 256(0x100, double:1.265E-321)
            long r7 = r7 / r14
            long r7 = r7 & r18
            int r8 = (int) r7
            byte r7 = (byte) r8
            r13[r4] = r7
            r4 = 9
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = (byte) r6
            r13[r4] = r6
        L_0x00c2:
            if (r1 <= 0) goto L_0x00d2
            int r4 = r1 / 256
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r13[r11] = r4
            int r4 = r11 + 1
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r13[r4] = r1
        L_0x00d2:
            int r1 = r11 + r20
            int r4 = r26 - r2
            r6 = r23
            java.lang.System.arraycopy(r6, r2, r13, r1, r4)
            boolean r1 = r0.mMasking
            if (r1 == 0) goto L_0x0125
            byte[] r1 = new byte[r9]
            double r6 = java.lang.Math.random()
            r14 = 4643211215818981376(0x4070000000000000, double:256.0)
            double r6 = r6 * r14
            double r6 = java.lang.Math.floor(r6)
            int r2 = (int) r6
            byte r2 = (byte) r2
            r4 = 0
            r1[r4] = r2
            double r6 = java.lang.Math.random()
            double r6 = r6 * r14
            double r6 = java.lang.Math.floor(r6)
            int r2 = (int) r6
            byte r2 = (byte) r2
            r4 = 1
            r1[r4] = r2
            double r4 = java.lang.Math.random()
            double r4 = r4 * r14
            double r4 = java.lang.Math.floor(r4)
            int r2 = (int) r4
            byte r2 = (byte) r2
            r1[r3] = r2
            double r2 = java.lang.Math.random()
            double r2 = r2 * r14
            double r2 = java.lang.Math.floor(r2)
            int r2 = (int) r2
            byte r2 = (byte) r2
            r3 = 3
            r1[r3] = r2
            r2 = 0
            java.lang.System.arraycopy(r1, r2, r13, r10, r9)
            mask(r13, r1, r11)
        L_0x0125:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.HybiParser.frame(int, byte[], int, int, int):byte[]");
    }

    public void close(int i, String str) {
        if (!this.mClosed) {
            sendFrame(frame(8, str, i));
            this.mClosed = true;
        }
    }

    /* access modifiers changed from: private */
    public void emitFrame() throws IOException {
        int i = 0;
        byte[] mask = mask(this.mPayload, this.mMask, 0);
        if (this.mDeflated) {
            try {
                mask = inflate(mask);
            } catch (DataFormatException unused) {
                throw new IOException("Invalid deflated data");
            }
        }
        int i2 = this.mOpcode;
        if (i2 == 0) {
            if (this.mMode != 0) {
                this.mBuffer.write(mask);
                if (this.mFinal) {
                    byte[] byteArray = this.mBuffer.toByteArray();
                    if (this.mMode == 1) {
                        onMessage(encode(byteArray));
                    } else {
                        onMessage(byteArray);
                    }
                    reset();
                    return;
                }
                return;
            }
            throw new ProtocolError("Mode was not set.");
        } else if (i2 == 1) {
            if (this.mFinal) {
                onMessage(encode(mask));
                return;
            }
            this.mMode = 1;
            this.mBuffer.write(mask);
        } else if (i2 == 2) {
            if (this.mFinal) {
                onMessage(mask);
                return;
            }
            this.mMode = 2;
            this.mBuffer.write(mask);
        } else if (i2 == 8) {
            if (mask.length >= 2) {
                i = (mask[1] & 255) + ((mask[0] & 255) * 256);
            }
            onDisconnect(i, mask.length > 2 ? encode(slice(mask, 2)) : null);
        } else if (i2 == 9) {
            if (mask.length <= 125) {
                String encode = encode(mask);
                sendFrame(frame(10, mask, -1));
                onPing(encode);
                return;
            }
            throw new ProtocolError("Ping payload too large");
        } else if (i2 == 10) {
            onPong(encode(mask));
        }
    }

    private void reset() {
        this.mMode = 0;
        this.mBuffer.reset();
    }

    private String encode(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] decode(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private int getInteger(byte[] bArr) throws ProtocolError {
        long byteArrayToLong = byteArrayToLong(bArr, 0, bArr.length);
        if (byteArrayToLong >= 0 && byteArrayToLong <= 2147483647L) {
            return (int) byteArrayToLong;
        }
        throw new ProtocolError("Bad integer: " + byteArrayToLong);
    }

    private byte[] slice(byte[] bArr, int i) {
        byte[] bArr2 = new byte[(bArr.length - i)];
        System.arraycopy(bArr, i, bArr2, 0, bArr.length - i);
        return bArr2;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        Inflater inflater = this.mInflater;
        if (inflater != null) {
            try {
                inflater.end();
            } catch (Exception e) {
                SystemUtils.log(6, TAG, "inflater.end failed", e, "com.koushikdutta.async.http.HybiParser", 511);
            }
        }
        super.finalize();
    }

    public static class ProtocolError extends IOException {
        public ProtocolError(String str) {
            super(str);
        }
    }

    private static long byteArrayToLong(byte[] bArr, int i, int i2) {
        if (bArr.length >= i2) {
            long j = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                j += (long) ((bArr[i3 + i] & 255) << (((i2 - 1) - i3) * 8));
            }
            return j;
        }
        throw new IllegalArgumentException("length must be less than or equal to b.length");
    }
}

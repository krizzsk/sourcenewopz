package org.apache.commons.p071io.input;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/* renamed from: org.apache.commons.io.input.ReversedLinesFileReader */
public class ReversedLinesFileReader implements Closeable {
    /* access modifiers changed from: private */
    public final int avoidNewlineSplitBufferSize;
    /* access modifiers changed from: private */
    public final int blockSize;
    /* access modifiers changed from: private */
    public final int byteDecrement;
    private FilePart currentFilePart;
    /* access modifiers changed from: private */
    public final String encoding;
    /* access modifiers changed from: private */
    public final byte[][] newLineSequences;
    /* access modifiers changed from: private */
    public final RandomAccessFile randomAccessFile;
    private final long totalBlockCount;
    private final long totalByteLength;
    private boolean trailingNewlineOfFileSkipped;

    public ReversedLinesFileReader(File file) throws IOException {
        this(file, 4096, Charset.defaultCharset().toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ReversedLinesFileReader(java.io.File r10, int r11, java.lang.String r12) throws java.io.IOException {
        /*
            r9 = this;
            r9.<init>()
            r7 = 0
            r9.trailingNewlineOfFileSkipped = r7
            r9.blockSize = r11
            r9.encoding = r12
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "r"
            r1.<init>(r10, r2)
            r9.randomAccessFile = r1
            long r1 = r1.length()
            r9.totalByteLength = r1
            long r3 = (long) r11
            long r5 = r1 % r3
            int r6 = (int) r5
            if (r6 <= 0) goto L_0x0026
            long r1 = r1 / r3
            r3 = 1
            long r1 = r1 + r3
            r9.totalBlockCount = r1
            goto L_0x0032
        L_0x0026:
            long r3 = r1 / r3
            r9.totalBlockCount = r3
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0032
            r4 = r11
            goto L_0x0033
        L_0x0032:
            r4 = r6
        L_0x0033:
            org.apache.commons.io.input.ReversedLinesFileReader$FilePart r8 = new org.apache.commons.io.input.ReversedLinesFileReader$FilePart
            long r2 = r9.totalBlockCount
            r5 = 0
            r6 = 0
            r0 = r8
            r1 = r9
            r0.<init>(r2, r4, r5)
            r9.currentFilePart = r8
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r12)
            java.nio.charset.CharsetEncoder r1 = r0.newEncoder()
            float r1 = r1.maxBytesPerChar()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 2
            r4 = 1
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0057
            r9.byteDecrement = r4
            goto L_0x00ac
        L_0x0057:
            java.lang.String r1 = "UTF-8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            if (r0 != r1) goto L_0x0062
            r9.byteDecrement = r4
            goto L_0x00ac
        L_0x0062:
            java.lang.String r1 = "Shift_JIS"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            if (r0 != r1) goto L_0x006d
            r9.byteDecrement = r4
            goto L_0x00ac
        L_0x006d:
            java.lang.String r1 = "UTF-16BE"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            if (r0 == r1) goto L_0x00aa
            java.lang.String r1 = "UTF-16LE"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            if (r0 != r1) goto L_0x007e
            goto L_0x00aa
        L_0x007e:
            java.lang.String r1 = "UTF-16"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            if (r0 != r1) goto L_0x008e
            java.io.UnsupportedEncodingException r0 = new java.io.UnsupportedEncodingException
            java.lang.String r1 = "For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)"
            r0.<init>(r1)
            throw r0
        L_0x008e:
            java.io.UnsupportedEncodingException r0 = new java.io.UnsupportedEncodingException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Encoding "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = " is not supported yet (feel free to submit a patch)"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00aa:
            r9.byteDecrement = r3
        L_0x00ac:
            r0 = 3
            byte[][] r0 = new byte[r0][]
            java.lang.String r1 = "\r\n"
            byte[] r1 = r1.getBytes(r12)
            r0[r7] = r1
            java.lang.String r1 = "\n"
            byte[] r1 = r1.getBytes(r12)
            r0[r4] = r1
            java.lang.String r1 = "\r"
            byte[] r1 = r1.getBytes(r12)
            r0[r3] = r1
            r9.newLineSequences = r0
            r0 = r0[r7]
            int r0 = r0.length
            r9.avoidNewlineSplitBufferSize = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p071io.input.ReversedLinesFileReader.<init>(java.io.File, int, java.lang.String):void");
    }

    public String readLine() throws IOException {
        String access$100 = this.currentFilePart.readLine();
        while (access$100 == null) {
            FilePart access$200 = this.currentFilePart.rollOver();
            this.currentFilePart = access$200;
            if (access$200 == null) {
                break;
            }
            access$100 = access$200.readLine();
        }
        if (!"".equals(access$100) || this.trailingNewlineOfFileSkipped) {
            return access$100;
        }
        this.trailingNewlineOfFileSkipped = true;
        return readLine();
    }

    public void close() throws IOException {
        this.randomAccessFile.close();
    }

    /* renamed from: org.apache.commons.io.input.ReversedLinesFileReader$FilePart */
    private class FilePart {
        private int currentLastBytePos;
        private final byte[] data;
        private byte[] leftOver;

        /* renamed from: no */
        private final long f5619no;

        private FilePart(long j, int i, byte[] bArr) throws IOException {
            this.f5619no = j;
            this.data = new byte[((bArr != null ? bArr.length : 0) + i)];
            long access$300 = (j - 1) * ((long) ReversedLinesFileReader.this.blockSize);
            if (j > 0) {
                ReversedLinesFileReader.this.randomAccessFile.seek(access$300);
                if (ReversedLinesFileReader.this.randomAccessFile.read(this.data, 0, i) != i) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, this.data, i, bArr.length);
            }
            this.currentLastBytePos = this.data.length - 1;
            this.leftOver = null;
        }

        /* access modifiers changed from: private */
        public FilePart rollOver() throws IOException {
            if (this.currentLastBytePos <= -1) {
                long j = this.f5619no;
                if (j > 1) {
                    ReversedLinesFileReader reversedLinesFileReader = ReversedLinesFileReader.this;
                    return new FilePart(j - 1, reversedLinesFileReader.blockSize, this.leftOver);
                } else if (this.leftOver == null) {
                    return null;
                } else {
                    throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.this.encoding));
                }
            } else {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
            }
        }

        /* access modifiers changed from: private */
        public String readLine() throws IOException {
            String str;
            boolean z = this.f5619no == 1;
            int i = this.currentLastBytePos;
            while (true) {
                if (i > -1) {
                    if (!z && i < ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
                        createLeftOver();
                        break;
                    }
                    int newLineMatchByteCount = getNewLineMatchByteCount(this.data, i);
                    if (newLineMatchByteCount <= 0) {
                        i -= ReversedLinesFileReader.this.byteDecrement;
                        if (i < 0) {
                            createLeftOver();
                            break;
                        }
                    } else {
                        int i2 = i + 1;
                        int i3 = (this.currentLastBytePos - i2) + 1;
                        if (i3 >= 0) {
                            byte[] bArr = new byte[i3];
                            System.arraycopy(this.data, i2, bArr, 0, i3);
                            str = new String(bArr, ReversedLinesFileReader.this.encoding);
                            this.currentLastBytePos = i - newLineMatchByteCount;
                        } else {
                            throw new IllegalStateException("Unexpected negative line length=" + i3);
                        }
                    }
                } else {
                    break;
                }
            }
            str = null;
            if (!z || this.leftOver == null) {
                return str;
            }
            String str2 = new String(this.leftOver, ReversedLinesFileReader.this.encoding);
            this.leftOver = null;
            return str2;
        }

        private void createLeftOver() {
            int i = this.currentLastBytePos + 1;
            if (i > 0) {
                byte[] bArr = new byte[i];
                this.leftOver = bArr;
                System.arraycopy(this.data, 0, bArr, 0, i);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] bArr, int i) {
            for (byte[] bArr2 : ReversedLinesFileReader.this.newLineSequences) {
                boolean z = true;
                for (int length = bArr2.length - 1; length >= 0; length--) {
                    int length2 = (i + length) - (bArr2.length - 1);
                    z &= length2 >= 0 && bArr[length2] == bArr2[length];
                }
                if (z) {
                    return bArr2.length;
                }
            }
            return 0;
        }
    }
}

package org.apache.commons.p071io.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.p071io.ByteOrderMark;

/* renamed from: org.apache.commons.io.input.BOMInputStream */
public class BOMInputStream extends ProxyInputStream {
    private final List<ByteOrderMark> boms;
    private ByteOrderMark byteOrderMark;
    private int fbIndex;
    private int fbLength;
    private int[] firstBytes;
    private final boolean include;
    private int markFbIndex;
    private boolean markedAtStart;

    public BOMInputStream(InputStream inputStream) {
        this(inputStream, false, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(InputStream inputStream, boolean z) {
        this(inputStream, z, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(InputStream inputStream, ByteOrderMark... byteOrderMarkArr) {
        this(inputStream, false, byteOrderMarkArr);
    }

    public BOMInputStream(InputStream inputStream, boolean z, ByteOrderMark... byteOrderMarkArr) {
        super(inputStream);
        if (byteOrderMarkArr == null || byteOrderMarkArr.length == 0) {
            throw new IllegalArgumentException("No BOMs specified");
        }
        this.include = z;
        this.boms = Arrays.asList(byteOrderMarkArr);
    }

    public boolean hasBOM() throws IOException {
        return getBOM() != null;
    }

    public boolean hasBOM(ByteOrderMark byteOrderMark2) throws IOException {
        if (this.boms.contains(byteOrderMark2)) {
            return this.byteOrderMark != null && getBOM().equals(byteOrderMark2);
        }
        throw new IllegalArgumentException("Stream not configure to detect " + byteOrderMark2);
    }

    public ByteOrderMark getBOM() throws IOException {
        if (this.firstBytes == null) {
            this.fbLength = 0;
            int i = 0;
            for (ByteOrderMark length : this.boms) {
                i = Math.max(i, length.length());
            }
            this.firstBytes = new int[i];
            int i2 = 0;
            while (true) {
                int[] iArr = this.firstBytes;
                if (i2 >= iArr.length) {
                    break;
                }
                iArr[i2] = this.in.read();
                this.fbLength++;
                if (this.firstBytes[i2] < 0) {
                    break;
                }
                ByteOrderMark find = find();
                this.byteOrderMark = find;
                if (find == null) {
                    i2++;
                } else if (!this.include) {
                    this.fbLength = 0;
                }
            }
        }
        return this.byteOrderMark;
    }

    public String getBOMCharsetName() throws IOException {
        getBOM();
        ByteOrderMark byteOrderMark2 = this.byteOrderMark;
        if (byteOrderMark2 == null) {
            return null;
        }
        return byteOrderMark2.getCharsetName();
    }

    private int readFirstBytes() throws IOException {
        getBOM();
        int i = this.fbIndex;
        if (i >= this.fbLength) {
            return -1;
        }
        int[] iArr = this.firstBytes;
        this.fbIndex = i + 1;
        return iArr[i];
    }

    private ByteOrderMark find() {
        for (ByteOrderMark next : this.boms) {
            if (matches(next)) {
                return next;
            }
        }
        return null;
    }

    private boolean matches(ByteOrderMark byteOrderMark2) {
        if (byteOrderMark2.length() != this.fbLength) {
            return false;
        }
        for (int i = 0; i < byteOrderMark2.length(); i++) {
            if (byteOrderMark2.get(i) != this.firstBytes[i]) {
                return false;
            }
        }
        return true;
    }

    public int read() throws IOException {
        int readFirstBytes = readFirstBytes();
        return readFirstBytes >= 0 ? readFirstBytes : this.in.read();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        int i4 = 0;
        while (i2 > 0 && i3 >= 0) {
            i3 = readFirstBytes();
            if (i3 >= 0) {
                bArr[i] = (byte) (i3 & 255);
                i2--;
                i4++;
                i++;
            }
        }
        int read = this.in.read(bArr, i, i2);
        if (read >= 0) {
            return i4 + read;
        }
        if (i4 > 0) {
            return i4;
        }
        return -1;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized void mark(int i) {
        this.markFbIndex = this.fbIndex;
        this.markedAtStart = this.firstBytes == null;
        this.in.mark(i);
    }

    public synchronized void reset() throws IOException {
        this.fbIndex = this.markFbIndex;
        if (this.markedAtStart) {
            this.firstBytes = null;
        }
        this.in.reset();
    }

    public long skip(long j) throws IOException {
        while (j > 0 && readFirstBytes() >= 0) {
            j--;
        }
        return this.in.skip(j);
    }
}

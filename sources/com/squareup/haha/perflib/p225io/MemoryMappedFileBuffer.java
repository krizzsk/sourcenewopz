package com.squareup.haha.perflib.p225io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* renamed from: com.squareup.haha.perflib.io.MemoryMappedFileBuffer */
public class MemoryMappedFileBuffer implements HprofBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_PADDING = 1024;
    private static final int DEFAULT_SIZE = 1073741824;
    private final int mBufferSize;
    private final ByteBuffer[] mByteBuffers;
    private long mCurrentPosition;
    private final long mLength;
    private final int mPadding;

    MemoryMappedFileBuffer(File file, int i, int i2) throws IOException {
        this.mBufferSize = i;
        this.mPadding = i2;
        long length = file.length();
        this.mLength = length;
        int i3 = ((int) (length / ((long) this.mBufferSize))) + 1;
        this.mByteBuffers = new ByteBuffer[i3];
        FileInputStream fileInputStream = new FileInputStream(file);
        int i4 = 0;
        long j = 0;
        while (i4 < i3) {
            try {
                this.mByteBuffers[i4] = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, j, Math.min(this.mLength - j, (long) (this.mBufferSize + this.mPadding)));
                this.mByteBuffers[i4].order(HPROF_BYTE_ORDER);
                j += (long) this.mBufferSize;
                i4++;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        }
        this.mCurrentPosition = 0;
        fileInputStream.close();
    }

    public MemoryMappedFileBuffer(File file) throws IOException {
        this(file, 1073741824, 1024);
    }

    public void dispose() {
        int i = 0;
        while (i < this.mByteBuffers.length) {
            try {
                this.mByteBuffers[i].cleaner().clean();
                i++;
            } catch (Exception unused) {
                return;
            }
        }
    }

    public byte readByte() {
        byte b = this.mByteBuffers[getIndex()].get(getOffset());
        this.mCurrentPosition++;
        return b;
    }

    public void read(byte[] bArr) {
        int index = getIndex();
        this.mByteBuffers[index].position(getOffset());
        if (bArr.length <= this.mByteBuffers[index].remaining()) {
            this.mByteBuffers[index].get(bArr, 0, bArr.length);
        } else {
            int position = this.mBufferSize - this.mByteBuffers[index].position();
            this.mByteBuffers[index].get(bArr, 0, position);
            int i = index + 1;
            this.mByteBuffers[i].position(0);
            this.mByteBuffers[i].get(bArr, position, bArr.length - position);
        }
        this.mCurrentPosition += (long) bArr.length;
    }

    public void readSubSequence(byte[] bArr, int i, int i2) {
        this.mCurrentPosition += (long) i;
        int index = getIndex();
        this.mByteBuffers[index].position(getOffset());
        if (bArr.length <= this.mByteBuffers[index].remaining()) {
            this.mByteBuffers[index].get(bArr, 0, bArr.length);
        } else {
            int position = this.mBufferSize - this.mByteBuffers[index].position();
            this.mByteBuffers[index].get(bArr, 0, position);
            int min = Math.min(i2 - position, bArr.length - position);
            int i3 = this.mBufferSize;
            int i4 = ((min + i3) - 1) / i3;
            for (int i5 = 0; i5 < i4; i5++) {
                int min2 = Math.min(min, this.mBufferSize);
                int i6 = index + 1 + i5;
                this.mByteBuffers[i6].position(0);
                this.mByteBuffers[i6].get(bArr, position, min2);
                position += min2;
                min -= min2;
            }
        }
        this.mCurrentPosition += (long) Math.min(bArr.length, i2);
    }

    public char readChar() {
        char c = this.mByteBuffers[getIndex()].getChar(getOffset());
        this.mCurrentPosition += 2;
        return c;
    }

    public short readShort() {
        short s = this.mByteBuffers[getIndex()].getShort(getOffset());
        this.mCurrentPosition += 2;
        return s;
    }

    public int readInt() {
        int i = this.mByteBuffers[getIndex()].getInt(getOffset());
        this.mCurrentPosition += 4;
        return i;
    }

    public long readLong() {
        long j = this.mByteBuffers[getIndex()].getLong(getOffset());
        this.mCurrentPosition += 8;
        return j;
    }

    public float readFloat() {
        float f = this.mByteBuffers[getIndex()].getFloat(getOffset());
        this.mCurrentPosition += 4;
        return f;
    }

    public double readDouble() {
        double d = this.mByteBuffers[getIndex()].getDouble(getOffset());
        this.mCurrentPosition += 8;
        return d;
    }

    public void setPosition(long j) {
        this.mCurrentPosition = j;
    }

    public long position() {
        return this.mCurrentPosition;
    }

    public boolean hasRemaining() {
        return this.mCurrentPosition < this.mLength;
    }

    public long remaining() {
        return this.mLength - this.mCurrentPosition;
    }

    private int getIndex() {
        return (int) (this.mCurrentPosition / ((long) this.mBufferSize));
    }

    private int getOffset() {
        return (int) (this.mCurrentPosition % ((long) this.mBufferSize));
    }
}

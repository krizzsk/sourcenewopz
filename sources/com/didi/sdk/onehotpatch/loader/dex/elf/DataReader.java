package com.didi.sdk.onehotpatch.loader.dex.elf;

import com.didi.dynamic.manager.utils.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class DataReader implements Closeable {
    private final byte[] mByteBuffer;
    private final File mFile;
    private boolean mIsLittleEndian;
    private final RandomAccessFile mRaf;

    public DataReader(String str) throws FileNotFoundException {
        this(new File(str));
    }

    public DataReader(File file) throws FileNotFoundException {
        this.mByteBuffer = new byte[8];
        this.mFile = file;
        this.mRaf = new RandomAccessFile(this.mFile, "r");
    }

    public void setIsLittleEndian(boolean z) {
        this.mIsLittleEndian = z;
    }

    public void seek(long j) throws IOException {
        this.mRaf.seek(j);
    }

    public final int readBytes(byte[] bArr) throws IOException {
        return this.mRaf.read(bArr);
    }

    public final int readBytes(char[] cArr) throws IOException {
        byte[] bArr = new byte[cArr.length];
        int read = this.mRaf.read(bArr);
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) bArr[i];
        }
        return read;
    }

    public final short readShort() throws IOException {
        short readShort = this.mRaf.readShort();
        if (!this.mIsLittleEndian) {
            return readShort;
        }
        return (short) (((readShort & 65280) >>> 8) | ((readShort & 255) << 8));
    }

    public final int readInt() throws IOException {
        int readInt = this.mRaf.readInt();
        if (!this.mIsLittleEndian) {
            return readInt;
        }
        return ((readInt & -16777216) >>> 24) | ((readInt & 255) << 24) | ((65280 & readInt) << 8) | ((16711680 & readInt) >>> 8);
    }

    public final void readIntArray(int[] iArr) throws IOException {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = readInt();
        }
    }

    public int previewInt() throws IOException {
        long filePointer = this.mRaf.getFilePointer();
        int readInt = readInt();
        this.mRaf.seek(filePointer);
        return readInt;
    }

    public final long readLong() throws IOException {
        if (!this.mIsLittleEndian) {
            return this.mRaf.readLong();
        }
        this.mRaf.readFully(this.mByteBuffer, 0, 8);
        byte[] bArr = this.mByteBuffer;
        return ((long) (bArr[0] & 255)) | (((long) bArr[7]) << 56) | (((long) (bArr[6] & 255)) << 48) | (((long) (bArr[5] & 255)) << 40) | (((long) (bArr[4] & 255)) << 32) | (((long) (bArr[3] & 255)) << 24) | (((long) (bArr[2] & 255)) << 16) | (((long) (bArr[1] & 255)) << 8);
    }

    public final int readRaw(byte[] bArr, int i, int i2) throws IOException {
        return this.mRaf.read(bArr, i, i2);
    }

    public long position() throws IOException {
        return this.mRaf.getFilePointer();
    }

    public File getFile() {
        return this.mFile;
    }

    public FileChannel getChannel() {
        return this.mRaf.getChannel();
    }

    public long length() throws IOException {
        return this.mRaf.length();
    }

    public void close() {
        try {
            this.mRaf.close();
        } catch (IOException e) {
            Log.m14494w("System.err", (Throwable) e);
        }
    }
}

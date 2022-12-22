package net.lingala.zip4j.p067io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.exception.ZipException;

/* renamed from: net.lingala.zip4j.io.outputstream.CountingOutputStream */
public class CountingOutputStream extends OutputStream implements OutputStreamWithSplitZipSupport {

    /* renamed from: a */
    private OutputStream f4877a;

    /* renamed from: b */
    private long f4878b = 0;

    public CountingOutputStream(OutputStream outputStream) {
        this.f4877a = outputStream;
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f4877a.write(bArr, i, i2);
        this.f4878b += (long) i2;
    }

    public int getCurrentSplitFileCounter() {
        if (isSplitZipFile()) {
            return ((SplitOutputStream) this.f4877a).getCurrentSplitFileCounter();
        }
        return 0;
    }

    public long getOffsetForNextEntry() throws IOException {
        OutputStream outputStream = this.f4877a;
        if (outputStream instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream).getFilePointer();
        }
        return this.f4878b;
    }

    public long getSplitLength() {
        if (isSplitZipFile()) {
            return ((SplitOutputStream) this.f4877a).getSplitLength();
        }
        return 0;
    }

    public boolean isSplitZipFile() {
        OutputStream outputStream = this.f4877a;
        return (outputStream instanceof SplitOutputStream) && ((SplitOutputStream) outputStream).isSplitZipFile();
    }

    public long getNumberOfBytesWritten() throws IOException {
        OutputStream outputStream = this.f4877a;
        if (outputStream instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream).getFilePointer();
        }
        return this.f4878b;
    }

    public boolean checkBuffSizeAndStartNextSplitFile(int i) throws ZipException {
        if (!isSplitZipFile()) {
            return false;
        }
        return ((SplitOutputStream) this.f4877a).checkBufferSizeAndStartNextSplitFile(i);
    }

    public long getFilePointer() throws IOException {
        OutputStream outputStream = this.f4877a;
        if (outputStream instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream).getFilePointer();
        }
        return this.f4878b;
    }

    public void close() throws IOException {
        this.f4877a.close();
    }
}

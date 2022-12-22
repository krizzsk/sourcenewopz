package net.lingala.zip4j.p067io.inputstream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.util.FileUtils;

/* renamed from: net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile */
public class NumberedSplitRandomAccessFile extends RandomAccessFile {

    /* renamed from: a */
    private long f4838a;

    /* renamed from: b */
    private File[] f4839b;

    /* renamed from: c */
    private RandomAccessFile f4840c;

    /* renamed from: d */
    private byte[] f4841d;

    /* renamed from: e */
    private int f4842e;

    /* renamed from: f */
    private String f4843f;

    public NumberedSplitRandomAccessFile(String str, String str2) throws IOException {
        this(new File(str), str2);
    }

    public NumberedSplitRandomAccessFile(File file, String str) throws IOException {
        this(file, str, FileUtils.getAllSortedNumberedSplitFiles(file));
    }

    public NumberedSplitRandomAccessFile(File file, String str, File[] fileArr) throws IOException {
        super(file, str);
        this.f4841d = new byte[1];
        this.f4842e = 0;
        super.close();
        if (!RandomAccessFileMode.WRITE.getValue().equals(str)) {
            m3121a(fileArr);
            this.f4840c = new RandomAccessFile(file, str);
            this.f4839b = fileArr;
            this.f4838a = file.length();
            this.f4843f = str;
            return;
        }
        throw new IllegalArgumentException("write mode is not allowed for NumberedSplitRandomAccessFile");
    }

    public int read() throws IOException {
        if (read(this.f4841d) == -1) {
            return -1;
        }
        return this.f4841d[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f4840c.read(bArr, i, i2);
        if (read != -1) {
            return read;
        }
        int i3 = this.f4842e;
        if (i3 == this.f4839b.length - 1) {
            return -1;
        }
        m3120a(i3 + 1);
        return read(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void seek(long j) throws IOException {
        int i = (int) (j / this.f4838a);
        if (i != this.f4842e) {
            m3120a(i);
        }
        this.f4840c.seek(j - (((long) i) * this.f4838a));
    }

    public long getFilePointer() throws IOException {
        return this.f4840c.getFilePointer();
    }

    public long length() throws IOException {
        return this.f4840c.length();
    }

    public void seekInCurrentPart(long j) throws IOException {
        this.f4840c.seek(j);
    }

    public void openLastSplitFileForReading() throws IOException {
        m3120a(this.f4839b.length - 1);
    }

    /* renamed from: a */
    private void m3120a(int i) throws IOException {
        if (this.f4842e != i) {
            if (i <= this.f4839b.length - 1) {
                RandomAccessFile randomAccessFile = this.f4840c;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.f4840c = new RandomAccessFile(this.f4839b[i], this.f4843f);
                this.f4842e = i;
                return;
            }
            throw new IOException("split counter greater than number of split files");
        }
    }

    /* renamed from: a */
    private void m3121a(File[] fileArr) throws IOException {
        int length = fileArr.length;
        int i = 1;
        int i2 = 0;
        while (i2 < length) {
            String fileExtension = FileUtils.getFileExtension(fileArr[i2]);
            try {
                if (i == Integer.parseInt(fileExtension)) {
                    i++;
                    i2++;
                } else {
                    throw new IOException("Split file number " + i + " does not exist");
                }
            } catch (NumberFormatException unused) {
                throw new IOException("Split file extension not in expected format. Found: " + fileExtension + " expected of format: .001, .002, etc");
            }
        }
    }
}

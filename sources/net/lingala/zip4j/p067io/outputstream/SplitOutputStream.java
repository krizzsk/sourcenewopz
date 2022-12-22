package net.lingala.zip4j.p067io.outputstream;

import android.support.p003v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.RawIO;

/* renamed from: net.lingala.zip4j.io.outputstream.SplitOutputStream */
public class SplitOutputStream extends OutputStream implements OutputStreamWithSplitZipSupport {

    /* renamed from: a */
    private RandomAccessFile f4879a;

    /* renamed from: b */
    private long f4880b;

    /* renamed from: c */
    private File f4881c;

    /* renamed from: d */
    private int f4882d;

    /* renamed from: e */
    private long f4883e;

    /* renamed from: f */
    private RawIO f4884f;

    public SplitOutputStream(File file) throws FileNotFoundException, ZipException {
        this(file, -1);
    }

    public SplitOutputStream(File file, long j) throws FileNotFoundException, ZipException {
        this.f4884f = new RawIO();
        if (j < 0 || j >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            this.f4879a = new RandomAccessFile(file, RandomAccessFileMode.WRITE.getValue());
            this.f4880b = j;
            this.f4881c = file;
            this.f4882d = 0;
            this.f4883e = 0;
            return;
        }
        throw new ZipException("split length less than minimum allowed split length of 65536 Bytes");
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            long j = this.f4880b;
            if (j == -1) {
                this.f4879a.write(bArr, i, i2);
                this.f4883e += (long) i2;
                return;
            }
            long j2 = this.f4883e;
            if (j2 >= j) {
                m3162a();
                this.f4879a.write(bArr, i, i2);
                this.f4883e = (long) i2;
                return;
            }
            long j3 = (long) i2;
            if (j2 + j3 <= j) {
                this.f4879a.write(bArr, i, i2);
                this.f4883e += j3;
            } else if (m3164a(bArr)) {
                m3162a();
                this.f4879a.write(bArr, i, i2);
                this.f4883e = j3;
            } else {
                this.f4879a.write(bArr, i, (int) (this.f4880b - this.f4883e));
                m3162a();
                RandomAccessFile randomAccessFile = this.f4879a;
                long j4 = this.f4880b;
                long j5 = this.f4883e;
                randomAccessFile.write(bArr, i + ((int) (j4 - j5)), (int) (j3 - (j4 - j5)));
                this.f4883e = j3 - (this.f4880b - this.f4883e);
            }
        }
    }

    /* renamed from: a */
    private void m3162a() throws IOException {
        String str;
        String zipFileNameWithoutExtension = FileUtils.getZipFileNameWithoutExtension(this.f4881c.getName());
        String absolutePath = this.f4881c.getAbsolutePath();
        if (this.f4881c.getParent() == null) {
            str = "";
        } else {
            str = this.f4881c.getParent() + System.getProperty("file.separator");
        }
        String str2 = ".z0" + (this.f4882d + 1);
        if (this.f4882d >= 9) {
            str2 = ".z" + (this.f4882d + 1);
        }
        File file = new File(str + zipFileNameWithoutExtension + str2);
        this.f4879a.close();
        if (file.exists()) {
            throw new IOException("split file: " + file.getName() + " already exists in the current directory, cannot rename this file");
        } else if (this.f4881c.renameTo(file)) {
            this.f4881c = new File(absolutePath);
            this.f4879a = new RandomAccessFile(this.f4881c, RandomAccessFileMode.WRITE.getValue());
            this.f4882d++;
        } else {
            throw new IOException("cannot rename newly created split file");
        }
    }

    /* renamed from: a */
    private boolean m3164a(byte[] bArr) {
        int readIntLittleEndian = this.f4884f.readIntLittleEndian(bArr);
        for (HeaderSignature headerSignature : HeaderSignature.values()) {
            if (headerSignature != HeaderSignature.SPLIT_ZIP && headerSignature.getValue() == ((long) readIntLittleEndian)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBufferSizeAndStartNextSplitFile(int i) throws ZipException {
        if (i < 0) {
            throw new ZipException("negative buffersize for checkBufferSizeAndStartNextSplitFile");
        } else if (m3163a(i)) {
            return false;
        } else {
            try {
                m3162a();
                this.f4883e = 0;
                return true;
            } catch (IOException e) {
                throw new ZipException((Exception) e);
            }
        }
    }

    /* renamed from: a */
    private boolean m3163a(int i) {
        long j = this.f4880b;
        if (j < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH || this.f4883e + ((long) i) <= j) {
            return true;
        }
        return false;
    }

    public void seek(long j) throws IOException {
        this.f4879a.seek(j);
    }

    public int skipBytes(int i) throws IOException {
        return this.f4879a.skipBytes(i);
    }

    public void close() throws IOException {
        this.f4879a.close();
    }

    public long getFilePointer() throws IOException {
        return this.f4879a.getFilePointer();
    }

    public boolean isSplitZipFile() {
        return this.f4880b != -1;
    }

    public long getSplitLength() {
        return this.f4880b;
    }

    public int getCurrentSplitFileCounter() {
        return this.f4882d;
    }
}

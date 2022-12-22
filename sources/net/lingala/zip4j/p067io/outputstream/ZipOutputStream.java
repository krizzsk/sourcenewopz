package net.lingala.zip4j.p067io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.FileHeaderFactory;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.RawIO;

/* renamed from: net.lingala.zip4j.io.outputstream.ZipOutputStream */
public class ZipOutputStream extends OutputStream {

    /* renamed from: a */
    private CountingOutputStream f4885a;

    /* renamed from: b */
    private char[] f4886b;

    /* renamed from: c */
    private ZipModel f4887c;

    /* renamed from: d */
    private C2393c f4888d;

    /* renamed from: e */
    private FileHeader f4889e;

    /* renamed from: f */
    private LocalFileHeader f4890f;

    /* renamed from: g */
    private FileHeaderFactory f4891g;

    /* renamed from: h */
    private HeaderWriter f4892h;

    /* renamed from: i */
    private CRC32 f4893i;

    /* renamed from: j */
    private RawIO f4894j;

    /* renamed from: k */
    private long f4895k;

    /* renamed from: l */
    private Zip4jConfig f4896l;

    /* renamed from: m */
    private boolean f4897m;

    public ZipOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, (char[]) null, (Charset) null);
    }

    public ZipOutputStream(OutputStream outputStream, Charset charset) throws IOException {
        this(outputStream, (char[]) null, charset);
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr) throws IOException {
        this(outputStream, cArr, (Charset) null);
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr, Charset charset) throws IOException {
        this(outputStream, cArr, new Zip4jConfig(charset, 4096), new ZipModel());
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr, Zip4jConfig zip4jConfig, ZipModel zipModel) throws IOException {
        this.f4891g = new FileHeaderFactory();
        this.f4892h = new HeaderWriter();
        this.f4893i = new CRC32();
        this.f4894j = new RawIO();
        this.f4895k = 0;
        if (zip4jConfig.getBufferSize() >= 512) {
            CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
            this.f4885a = countingOutputStream;
            this.f4886b = cArr;
            this.f4896l = zip4jConfig;
            this.f4887c = m3167a(zipModel, countingOutputStream);
            this.f4897m = false;
            m3174c();
            return;
        }
        throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
    }

    public void putNextEntry(ZipParameters zipParameters) throws IOException {
        m3175c(zipParameters);
        m3169a(zipParameters);
        this.f4888d = m3172b(zipParameters);
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        m3168a();
        this.f4893i.update(bArr, i, i2);
        this.f4888d.write(bArr, i, i2);
        this.f4895k += (long) i2;
    }

    public FileHeader closeEntry() throws IOException {
        this.f4888d.mo24192a();
        long b = this.f4888d.mo24193b();
        this.f4889e.setCompressedSize(b);
        this.f4890f.setCompressedSize(b);
        this.f4889e.setUncompressedSize(this.f4895k);
        this.f4890f.setUncompressedSize(this.f4895k);
        if (m3171a(this.f4889e)) {
            this.f4889e.setCrc(this.f4893i.getValue());
            this.f4890f.setCrc(this.f4893i.getValue());
        }
        this.f4887c.getLocalFileHeaders().add(this.f4890f);
        this.f4887c.getCentralDirectory().getFileHeaders().add(this.f4889e);
        if (this.f4890f.isDataDescriptorExists()) {
            this.f4892h.writeExtendedLocalHeader(this.f4890f, this.f4885a);
        }
        m3173b();
        return this.f4889e;
    }

    public void close() throws IOException {
        this.f4887c.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(this.f4885a.getNumberOfBytesWritten());
        this.f4892h.finalizeZipFile(this.f4887c, this.f4885a, this.f4896l.getCharset());
        this.f4885a.close();
        this.f4897m = true;
    }

    public void setComment(String str) throws IOException {
        m3168a();
        this.f4887c.getEndOfCentralDirectoryRecord().setComment(str);
    }

    /* renamed from: a */
    private void m3168a() throws IOException {
        if (this.f4897m) {
            throw new IOException("Stream is closed");
        }
    }

    /* renamed from: a */
    private ZipModel m3167a(ZipModel zipModel, CountingOutputStream countingOutputStream) {
        if (zipModel == null) {
            zipModel = new ZipModel();
        }
        if (countingOutputStream.isSplitZipFile()) {
            zipModel.setSplitArchive(true);
            zipModel.setSplitLength(countingOutputStream.getSplitLength());
        }
        return zipModel;
    }

    /* renamed from: a */
    private void m3169a(ZipParameters zipParameters) throws IOException {
        FileHeader generateFileHeader = this.f4891g.generateFileHeader(zipParameters, this.f4885a.isSplitZipFile(), this.f4885a.getCurrentSplitFileCounter(), this.f4896l.getCharset(), this.f4894j);
        this.f4889e = generateFileHeader;
        generateFileHeader.setOffsetLocalHeader(this.f4885a.getOffsetForNextEntry());
        LocalFileHeader generateLocalFileHeader = this.f4891g.generateLocalFileHeader(this.f4889e);
        this.f4890f = generateLocalFileHeader;
        this.f4892h.writeLocalFileHeader(this.f4887c, generateLocalFileHeader, this.f4885a, this.f4896l.getCharset());
    }

    /* renamed from: b */
    private void m3173b() throws IOException {
        this.f4895k = 0;
        this.f4893i.reset();
        this.f4888d.close();
    }

    /* renamed from: c */
    private void m3174c() throws IOException {
        if (this.f4885a.isSplitZipFile()) {
            this.f4894j.writeIntLittleEndian(this.f4885a, (int) HeaderSignature.SPLIT_ZIP.getValue());
        }
    }

    /* renamed from: b */
    private C2393c m3172b(ZipParameters zipParameters) throws IOException {
        return m3166a(m3165a(new C2396f(this.f4885a), zipParameters), zipParameters);
    }

    /* renamed from: a */
    private C2392b m3165a(C2396f fVar, ZipParameters zipParameters) throws IOException {
        if (!zipParameters.isEncryptFiles()) {
            return new NoCipherOutputStream(fVar, zipParameters, (char[]) null);
        }
        char[] cArr = this.f4886b;
        if (cArr == null || cArr.length == 0) {
            throw new ZipException("password not set");
        } else if (zipParameters.getEncryptionMethod() == EncryptionMethod.AES) {
            return new C2391a(fVar, zipParameters, this.f4886b);
        } else {
            if (zipParameters.getEncryptionMethod() == EncryptionMethod.ZIP_STANDARD) {
                return new C2397g(fVar, zipParameters, this.f4886b);
            }
            if (zipParameters.getEncryptionMethod() == EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG) {
                throw new ZipException(EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG + " encryption method is not supported");
            }
            throw new ZipException("Invalid encryption method");
        }
    }

    /* renamed from: a */
    private C2393c m3166a(C2392b bVar, ZipParameters zipParameters) {
        if (zipParameters.getCompressionMethod() == CompressionMethod.DEFLATE) {
            return new C2394d(bVar, zipParameters.getCompressionLevel(), this.f4896l.getBufferSize());
        }
        return new C2395e(bVar);
    }

    /* renamed from: c */
    private void m3175c(ZipParameters zipParameters) {
        if (zipParameters.getCompressionMethod() == CompressionMethod.STORE && zipParameters.getEntrySize() < 0 && !m3170a(zipParameters.getFileNameInZip()) && zipParameters.isWriteExtendedLocalFileHeader()) {
            throw new IllegalArgumentException("uncompressed size should be set for zip entries of compression type store");
        }
    }

    /* renamed from: a */
    private boolean m3171a(FileHeader fileHeader) {
        if (!(fileHeader.isEncrypted() && fileHeader.getEncryptionMethod().equals(EncryptionMethod.AES))) {
            return true;
        }
        return fileHeader.getAesExtraDataRecord().getAesVersion().equals(AesVersion.ONE);
    }

    /* renamed from: a */
    private boolean m3170a(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }
}

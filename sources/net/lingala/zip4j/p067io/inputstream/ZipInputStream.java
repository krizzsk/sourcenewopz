package net.lingala.zip4j.p067io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.CRC32;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderReader;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.DataDescriptor;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

/* renamed from: net.lingala.zip4j.io.inputstream.ZipInputStream */
public class ZipInputStream extends InputStream {

    /* renamed from: a */
    private PushbackInputStream f4847a;

    /* renamed from: b */
    private C2387c f4848b;

    /* renamed from: c */
    private HeaderReader f4849c;

    /* renamed from: d */
    private char[] f4850d;

    /* renamed from: e */
    private LocalFileHeader f4851e;

    /* renamed from: f */
    private CRC32 f4852f;

    /* renamed from: g */
    private byte[] f4853g;

    /* renamed from: h */
    private boolean f4854h;

    /* renamed from: i */
    private Zip4jConfig f4855i;

    public ZipInputStream(InputStream inputStream) {
        this(inputStream, (char[]) null, (Charset) null);
    }

    public ZipInputStream(InputStream inputStream, Charset charset) {
        this(inputStream, (char[]) null, charset);
    }

    public ZipInputStream(InputStream inputStream, char[] cArr) {
        this(inputStream, cArr, (Charset) null);
    }

    public ZipInputStream(InputStream inputStream, char[] cArr, Charset charset) {
        this(inputStream, cArr, new Zip4jConfig(charset, 4096));
    }

    public ZipInputStream(InputStream inputStream, char[] cArr, Zip4jConfig zip4jConfig) {
        this.f4849c = new HeaderReader();
        this.f4852f = new CRC32();
        this.f4854h = false;
        if (zip4jConfig.getBufferSize() >= 512) {
            this.f4847a = new PushbackInputStream(inputStream, zip4jConfig.getBufferSize());
            this.f4850d = cArr;
            this.f4855i = zip4jConfig;
            return;
        }
        throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
    }

    public LocalFileHeader getNextEntry() throws IOException {
        return getNextEntry((FileHeader) null);
    }

    public LocalFileHeader getNextEntry(FileHeader fileHeader) throws IOException {
        if (this.f4851e != null) {
            m3134e();
        }
        LocalFileHeader readLocalFileHeader = this.f4849c.readLocalFileHeader(this.f4847a, this.f4855i.getCharset());
        this.f4851e = readLocalFileHeader;
        if (readLocalFileHeader == null) {
            return null;
        }
        m3129b(readLocalFileHeader);
        this.f4852f.reset();
        if (fileHeader != null) {
            this.f4851e.setCrc(fileHeader.getCrc());
            this.f4851e.setCompressedSize(fileHeader.getCompressedSize());
            this.f4851e.setUncompressedSize(fileHeader.getUncompressedSize());
            this.f4851e.setDirectory(fileHeader.isDirectory());
            this.f4854h = true;
        } else {
            this.f4854h = false;
        }
        this.f4848b = m3124a(this.f4851e);
        return this.f4851e;
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative read length");
        } else if (i2 == 0) {
            return 0;
        } else {
            if (this.f4851e == null) {
                return -1;
            }
            try {
                int read = this.f4848b.read(bArr, i, i2);
                if (read == -1) {
                    m3125a();
                } else {
                    this.f4852f.update(bArr, i, read);
                }
                return read;
            } catch (IOException e) {
                if (m3135e(this.f4851e)) {
                    throw new ZipException(e.getMessage(), e.getCause(), ZipException.Type.WRONG_PASSWORD);
                }
                throw e;
            }
        }
    }

    public void close() throws IOException {
        C2387c cVar = this.f4848b;
        if (cVar != null) {
            cVar.close();
        }
    }

    /* renamed from: a */
    private void m3125a() throws IOException {
        this.f4848b.pushBackInputStreamIfNecessary(this.f4847a);
        this.f4848b.endOfEntryReached(this.f4847a);
        m3128b();
        m3131c();
        m3133d();
    }

    /* renamed from: a */
    private C2387c m3124a(LocalFileHeader localFileHeader) throws IOException {
        return m3123a(m3122a(new C2389e(this.f4847a, m3130c(localFileHeader)), localFileHeader), localFileHeader);
    }

    /* renamed from: a */
    private C2386b m3122a(C2389e eVar, LocalFileHeader localFileHeader) throws IOException {
        if (!localFileHeader.isEncrypted()) {
            return new NoCipherInputStream(eVar, localFileHeader, this.f4850d, this.f4855i.getBufferSize());
        }
        if (localFileHeader.getEncryptionMethod() == EncryptionMethod.AES) {
            return new C2385a(eVar, localFileHeader, this.f4850d, this.f4855i.getBufferSize());
        }
        if (localFileHeader.getEncryptionMethod() == EncryptionMethod.ZIP_STANDARD) {
            return new C2390f(eVar, localFileHeader, this.f4850d, this.f4855i.getBufferSize());
        }
        throw new ZipException(String.format("Entry [%s] Strong Encryption not supported", new Object[]{localFileHeader.getFileName()}), ZipException.Type.UNSUPPORTED_ENCRYPTION);
    }

    /* renamed from: a */
    private C2387c m3123a(C2386b bVar, LocalFileHeader localFileHeader) {
        if (Zip4jUtil.getCompressionMethod(localFileHeader) == CompressionMethod.DEFLATE) {
            return new InflaterInputStream(bVar, this.f4855i.getBufferSize());
        }
        return new C2388d(bVar);
    }

    /* renamed from: b */
    private void m3128b() throws IOException {
        if (this.f4851e.isDataDescriptorExists() && !this.f4854h) {
            DataDescriptor readDataDescriptor = this.f4849c.readDataDescriptor(this.f4847a, m3127a(this.f4851e.getExtraDataRecords()));
            this.f4851e.setCompressedSize(readDataDescriptor.getCompressedSize());
            this.f4851e.setUncompressedSize(readDataDescriptor.getUncompressedSize());
            this.f4851e.setCrc(readDataDescriptor.getCrc());
        }
    }

    /* renamed from: b */
    private void m3129b(LocalFileHeader localFileHeader) throws IOException {
        if (!m3126a(localFileHeader.getFileName()) && localFileHeader.getCompressionMethod() == CompressionMethod.STORE && localFileHeader.getUncompressedSize() < 0) {
            throw new IOException("Invalid local file header for: " + localFileHeader.getFileName() + ". Uncompressed size has to be set for entry of compression type store which is not a directory");
        }
    }

    /* renamed from: a */
    private boolean m3127a(List<ExtraDataRecord> list) {
        if (list == null) {
            return false;
        }
        for (ExtraDataRecord header : list) {
            if (header.getHeader() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m3131c() throws IOException {
        if ((this.f4851e.getEncryptionMethod() != EncryptionMethod.AES || !this.f4851e.getAesExtraDataRecord().getAesVersion().equals(AesVersion.TWO)) && this.f4851e.getCrc() != this.f4852f.getValue()) {
            ZipException.Type type = ZipException.Type.CHECKSUM_MISMATCH;
            if (m3135e(this.f4851e)) {
                type = ZipException.Type.WRONG_PASSWORD;
            }
            throw new ZipException("Reached end of entry, but crc verification failed for " + this.f4851e.getFileName(), type);
        }
    }

    /* renamed from: d */
    private void m3133d() {
        this.f4851e = null;
        this.f4852f.reset();
    }

    /* renamed from: a */
    private boolean m3126a(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    /* renamed from: c */
    private long m3130c(LocalFileHeader localFileHeader) {
        if (Zip4jUtil.getCompressionMethod(localFileHeader).equals(CompressionMethod.STORE)) {
            return localFileHeader.getUncompressedSize();
        }
        if (!localFileHeader.isDataDescriptorExists() || this.f4854h) {
            return localFileHeader.getCompressedSize() - ((long) m3132d(localFileHeader));
        }
        return -1;
    }

    /* renamed from: d */
    private int m3132d(LocalFileHeader localFileHeader) {
        if (!localFileHeader.isEncrypted()) {
            return 0;
        }
        if (localFileHeader.getEncryptionMethod().equals(EncryptionMethod.AES)) {
            return localFileHeader.getAesExtraDataRecord().getAesKeyStrength().getSaltLength() + 12;
        }
        if (localFileHeader.getEncryptionMethod().equals(EncryptionMethod.ZIP_STANDARD)) {
            return 12;
        }
        return 0;
    }

    /* renamed from: e */
    private void m3134e() throws IOException {
        if (this.f4851e.isDirectory()) {
            return;
        }
        if (this.f4851e.getCompressedSize() != 0 || this.f4851e.isDataDescriptorExists()) {
            if (this.f4853g == null) {
                this.f4853g = new byte[512];
            }
            do {
            } while (read(this.f4853g) != -1);
        }
    }

    /* renamed from: e */
    private boolean m3135e(LocalFileHeader localFileHeader) {
        return localFileHeader.isEncrypted() && EncryptionMethod.ZIP_STANDARD.equals(localFileHeader.getEncryptionMethod());
    }
}

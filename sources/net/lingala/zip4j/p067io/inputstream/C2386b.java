package net.lingala.zip4j.p067io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.crypto.Decrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

/* renamed from: net.lingala.zip4j.io.inputstream.b */
/* compiled from: CipherInputStream */
abstract class C2386b<T extends Decrypter> extends InputStream {

    /* renamed from: a */
    private C2389e f4866a;

    /* renamed from: b */
    private T f4867b;

    /* renamed from: c */
    private byte[] f4868c;

    /* renamed from: d */
    private byte[] f4869d = new byte[1];

    /* renamed from: e */
    private LocalFileHeader f4870e;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24135a(InputStream inputStream) throws IOException {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract T mo24109b(LocalFileHeader localFileHeader, char[] cArr) throws IOException, ZipException;

    public C2386b(C2389e eVar, LocalFileHeader localFileHeader, char[] cArr, int i) throws IOException {
        this.f4866a = eVar;
        this.f4867b = mo24109b(localFileHeader, cArr);
        this.f4870e = localFileHeader;
        if (Zip4jUtil.getCompressionMethod(localFileHeader).equals(CompressionMethod.DEFLATE)) {
            this.f4868c = new byte[i];
        }
    }

    public int read() throws IOException {
        if (read(this.f4869d) == -1) {
            return -1;
        }
        return this.f4869d[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int readFully = Zip4jUtil.readFully(this.f4866a, bArr, i, i2);
        if (readFully > 0) {
            m3146a(bArr, readFully);
            this.f4867b.decryptData(bArr, i, readFully);
        }
        return readFully;
    }

    public void close() throws IOException {
        this.f4866a.close();
    }

    /* renamed from: a */
    public byte[] mo24141a() {
        return this.f4868c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo24140a(byte[] bArr) throws IOException {
        return this.f4866a.mo24147a(bArr);
    }

    /* renamed from: a */
    private void m3146a(byte[] bArr, int i) {
        byte[] bArr2 = this.f4868c;
        if (bArr2 != null) {
            System.arraycopy(bArr, 0, bArr2, 0, i);
        }
    }

    /* renamed from: b */
    public T mo24142b() {
        return this.f4867b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public long mo24143c() {
        return this.f4866a.mo24148a();
    }

    /* renamed from: d */
    public LocalFileHeader mo24145d() {
        return this.f4870e;
    }
}

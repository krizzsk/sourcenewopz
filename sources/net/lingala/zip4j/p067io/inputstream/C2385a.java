package net.lingala.zip4j.p067io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

/* renamed from: net.lingala.zip4j.io.inputstream.a */
/* compiled from: AesCipherInputStream */
class C2385a extends C2386b<AESDecrypter> {

    /* renamed from: a */
    private byte[] f4857a = new byte[1];

    /* renamed from: b */
    private byte[] f4858b = new byte[16];

    /* renamed from: c */
    private int f4859c = 0;

    /* renamed from: d */
    private int f4860d = 0;

    /* renamed from: e */
    private int f4861e = 0;

    /* renamed from: f */
    private int f4862f = 0;

    /* renamed from: g */
    private int f4863g = 0;

    /* renamed from: h */
    private int f4864h = 0;

    /* renamed from: i */
    private int f4865i = 0;

    public C2385a(C2389e eVar, LocalFileHeader localFileHeader, char[] cArr, int i) throws IOException {
        super(eVar, localFileHeader, cArr, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AESDecrypter mo24109b(LocalFileHeader localFileHeader, char[] cArr) throws IOException {
        return new AESDecrypter(localFileHeader.getAesExtraDataRecord(), cArr, m3138a(localFileHeader), m3141e());
    }

    public int read() throws IOException {
        if (read(this.f4857a) == -1) {
            return -1;
        }
        return this.f4857a[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.f4861e = i2;
        this.f4862f = i;
        this.f4863g = 0;
        if (this.f4860d != 0) {
            m3137a(bArr, i);
            int i3 = this.f4863g;
            if (i3 == i2) {
                return i3;
            }
        }
        if (this.f4861e < 16) {
            byte[] bArr2 = this.f4858b;
            int read = super.read(bArr2, 0, bArr2.length);
            this.f4865i = read;
            this.f4859c = 0;
            if (read == -1) {
                this.f4860d = 0;
                int i4 = this.f4863g;
                if (i4 > 0) {
                    return i4;
                }
                return -1;
            }
            this.f4860d = read;
            m3137a(bArr, this.f4862f);
            int i5 = this.f4863g;
            if (i5 == i2) {
                return i5;
            }
        }
        int i6 = this.f4862f;
        int i7 = this.f4861e;
        int read2 = super.read(bArr, i6, i7 - (i7 % 16));
        if (read2 != -1) {
            return read2 + this.f4863g;
        }
        int i8 = this.f4863g;
        if (i8 > 0) {
            return i8;
        }
        return -1;
    }

    /* renamed from: a */
    private void m3137a(byte[] bArr, int i) {
        int i2 = this.f4861e;
        int i3 = this.f4860d;
        if (i2 >= i3) {
            i2 = i3;
        }
        this.f4864h = i2;
        System.arraycopy(this.f4858b, this.f4859c, bArr, i, i2);
        m3136a(this.f4864h);
        m3139b(this.f4864h);
        int i4 = this.f4863g;
        int i5 = this.f4864h;
        this.f4863g = i4 + i5;
        this.f4861e -= i5;
        this.f4862f += i5;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24135a(InputStream inputStream) throws IOException {
        m3140b(mo24136b(inputStream));
    }

    /* renamed from: b */
    private void m3140b(byte[] bArr) throws IOException {
        if (!mo24145d().isDataDescriptorExists() || !CompressionMethod.DEFLATE.equals(Zip4jUtil.getCompressionMethod(mo24145d()))) {
            byte[] bArr2 = new byte[10];
            System.arraycopy(((AESDecrypter) mo24142b()).getCalculatedAuthenticationBytes(), 0, bArr2, 0, 10);
            if (!Arrays.equals(bArr, bArr2)) {
                throw new IOException("Reached end of data for this entry, but aes verification failed");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public byte[] mo24136b(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[10];
        if (Zip4jUtil.readFully(inputStream, bArr) == 10) {
            return bArr;
        }
        throw new ZipException("Invalid AES Mac bytes. Could not read sufficient data");
    }

    /* renamed from: a */
    private byte[] m3138a(LocalFileHeader localFileHeader) throws IOException {
        if (localFileHeader.getAesExtraDataRecord() != null) {
            byte[] bArr = new byte[localFileHeader.getAesExtraDataRecord().getAesKeyStrength().getSaltLength()];
            mo24140a(bArr);
            return bArr;
        }
        throw new IOException("invalid aes extra data record");
    }

    /* renamed from: e */
    private byte[] m3141e() throws IOException {
        byte[] bArr = new byte[2];
        mo24140a(bArr);
        return bArr;
    }

    /* renamed from: a */
    private void m3136a(int i) {
        int i2 = this.f4859c + i;
        this.f4859c = i2;
        if (i2 >= 15) {
            this.f4859c = 15;
        }
    }

    /* renamed from: b */
    private void m3139b(int i) {
        int i2 = this.f4860d - i;
        this.f4860d = i2;
        if (i2 <= 0) {
            this.f4860d = 0;
        }
    }
}

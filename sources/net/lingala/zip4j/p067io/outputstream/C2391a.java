package net.lingala.zip4j.p067io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.crypto.AESEncrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

/* renamed from: net.lingala.zip4j.io.outputstream.a */
/* compiled from: AesCipherOutputStream */
class C2391a extends C2392b<AESEncrypter> {

    /* renamed from: a */
    private byte[] f4898a = new byte[16];

    /* renamed from: b */
    private int f4899b = 0;

    public C2391a(C2396f fVar, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        super(fVar, zipParameters, cArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AESEncrypter mo24166b(OutputStream outputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        AESEncrypter aESEncrypter = new AESEncrypter(cArr, zipParameters.getAesKeyStrength());
        m3176a(aESEncrypter);
        return aESEncrypter;
    }

    /* renamed from: a */
    private void m3176a(AESEncrypter aESEncrypter) throws IOException {
        mo24188a(aESEncrypter.getSaltBytes());
        mo24188a(aESEncrypter.getDerivedPasswordVerifier());
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = this.f4899b;
        if (i2 >= 16 - i4) {
            System.arraycopy(bArr, i, this.f4898a, i4, 16 - i4);
            byte[] bArr2 = this.f4898a;
            super.write(bArr2, 0, bArr2.length);
            int i5 = 16 - this.f4899b;
            int i6 = i2 - i5;
            this.f4899b = 0;
            if (!(i6 == 0 || (i3 = i6 % 16) == 0)) {
                System.arraycopy(bArr, (i6 + i5) - i3, this.f4898a, 0, i3);
                this.f4899b = i3;
                i6 -= i3;
            }
            super.write(bArr, i5, i6);
            return;
        }
        System.arraycopy(bArr, i, this.f4898a, i4, i2);
        this.f4899b += i2;
    }

    /* renamed from: a */
    public void mo24184a() throws IOException {
        int i = this.f4899b;
        if (i != 0) {
            super.write(this.f4898a, 0, i);
            this.f4899b = 0;
        }
        mo24188a(((AESEncrypter) mo24190c()).getFinalMac());
        super.mo24184a();
    }
}

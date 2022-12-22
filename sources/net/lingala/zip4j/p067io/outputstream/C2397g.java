package net.lingala.zip4j.p067io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.crypto.StandardEncrypter;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jUtil;

/* renamed from: net.lingala.zip4j.io.outputstream.g */
/* compiled from: ZipStandardCipherOutputStream */
class C2397g extends C2392b<StandardEncrypter> {
    public C2397g(C2396f fVar, ZipParameters zipParameters, char[] cArr) throws IOException {
        super(fVar, zipParameters, cArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public StandardEncrypter mo24166b(OutputStream outputStream, ZipParameters zipParameters, char[] cArr) throws IOException {
        StandardEncrypter standardEncrypter = new StandardEncrypter(cArr, m3191a(zipParameters));
        mo24188a(standardEncrypter.getHeaderBytes());
        return standardEncrypter;
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        super.write(bArr, i, i2);
    }

    /* renamed from: a */
    private long m3191a(ZipParameters zipParameters) {
        if (zipParameters.isWriteExtendedLocalFileHeader()) {
            return (Zip4jUtil.epochToExtendedDosTime(zipParameters.getLastModifiedFileTime()) & 65535) << 16;
        }
        return zipParameters.getEntryCRC();
    }
}

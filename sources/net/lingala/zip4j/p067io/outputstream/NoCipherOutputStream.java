package net.lingala.zip4j.p067io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.crypto.Encrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

/* renamed from: net.lingala.zip4j.io.outputstream.NoCipherOutputStream */
class NoCipherOutputStream extends C2392b<NoEncrypter> {
    public NoCipherOutputStream(C2396f fVar, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        super(fVar, zipParameters, cArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public NoEncrypter mo24166b(OutputStream outputStream, ZipParameters zipParameters, char[] cArr) {
        return new NoEncrypter();
    }

    /* renamed from: net.lingala.zip4j.io.outputstream.NoCipherOutputStream$NoEncrypter */
    static class NoEncrypter implements Encrypter {
        public int encryptData(byte[] bArr, int i, int i2) {
            return i2;
        }

        NoEncrypter() {
        }

        public int encryptData(byte[] bArr) {
            return encryptData(bArr, 0, bArr.length);
        }
    }
}

package net.lingala.zip4j.crypto;

import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;

public class StandardDecrypter implements Decrypter {

    /* renamed from: a */
    private ZipCryptoEngine f4811a = new ZipCryptoEngine();

    public StandardDecrypter(char[] cArr, long j, long j2, byte[] bArr) throws ZipException {
        m3065a(bArr, cArr, j2, j);
    }

    public int decryptData(byte[] bArr, int i, int i2) throws ZipException {
        if (i < 0 || i2 < 0) {
            throw new ZipException("one of the input parameters were null in standard decrypt data");
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            byte decryptByte = (byte) (((bArr[i3] & 255) ^ this.f4811a.decryptByte()) & 255);
            this.f4811a.updateKeys(decryptByte);
            bArr[i3] = decryptByte;
        }
        return i2;
    }

    /* renamed from: a */
    private void m3065a(byte[] bArr, char[] cArr, long j, long j2) throws ZipException {
        byte decryptByte;
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("Wrong password!", ZipException.Type.WRONG_PASSWORD);
        }
        this.f4811a.initKeys(cArr);
        int i = 0;
        byte b = bArr[0];
        while (i < 12) {
            i++;
            if (i != 12 || (decryptByte = (byte) (this.f4811a.decryptByte() ^ b)) == ((byte) ((int) (j2 >> 24))) || decryptByte == ((byte) ((int) (j >> 8)))) {
                ZipCryptoEngine zipCryptoEngine = this.f4811a;
                zipCryptoEngine.updateKeys((byte) (zipCryptoEngine.decryptByte() ^ b));
                if (i != 12) {
                    b = bArr[i];
                }
            } else {
                throw new ZipException("Wrong password!", ZipException.Type.WRONG_PASSWORD);
            }
        }
    }
}

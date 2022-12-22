package net.lingala.zip4j.crypto;

import java.security.SecureRandom;
import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;

public class StandardEncrypter implements Encrypter {

    /* renamed from: a */
    private final ZipCryptoEngine f4812a = new ZipCryptoEngine();

    /* renamed from: b */
    private byte[] f4813b;

    public StandardEncrypter(char[] cArr, long j) throws ZipException {
        m3066a(cArr, j);
    }

    /* renamed from: a */
    private void m3066a(char[] cArr, long j) throws ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("input password is null or empty, cannot initialize standard encrypter");
        }
        this.f4812a.initKeys(cArr);
        this.f4813b = generateRandomBytes();
        this.f4812a.initKeys(cArr);
        byte[] bArr = this.f4813b;
        bArr[11] = (byte) ((int) (j >>> 24));
        bArr[10] = (byte) ((int) (j >>> 16));
        encryptData(bArr);
    }

    public int encryptData(byte[] bArr) throws ZipException {
        if (bArr != null) {
            return encryptData(bArr, 0, bArr.length);
        }
        throw null;
    }

    public int encryptData(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 >= 0) {
            for (int i3 = i; i3 < i + i2; i3++) {
                bArr[i3] = encryptByte(bArr[i3]);
            }
            return i2;
        }
        throw new ZipException("invalid length specified to decrpyt data");
    }

    /* access modifiers changed from: protected */
    public byte encryptByte(byte b) {
        byte decryptByte = (byte) ((this.f4812a.decryptByte() & 255) ^ b);
        this.f4812a.updateKeys(b);
        return decryptByte;
    }

    /* access modifiers changed from: protected */
    public byte[] generateRandomBytes() {
        byte[] bArr = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 12; i++) {
            bArr[i] = encryptByte((byte) secureRandom.nextInt(256));
        }
        return bArr;
    }

    public byte[] getHeaderBytes() {
        return this.f4813b;
    }
}

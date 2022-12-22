package net.lingala.zip4j.crypto;

import java.util.Arrays;
import net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF;
import net.lingala.zip4j.crypto.engine.AESEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.enums.AesKeyStrength;

public class AESDecrypter implements Decrypter {

    /* renamed from: a */
    private AESEngine f4789a;

    /* renamed from: b */
    private MacBasedPRF f4790b;

    /* renamed from: c */
    private int f4791c = 1;

    /* renamed from: d */
    private byte[] f4792d = new byte[16];

    /* renamed from: e */
    private byte[] f4793e = new byte[16];

    public AESDecrypter(AESExtraDataRecord aESExtraDataRecord, char[] cArr, byte[] bArr, byte[] bArr2) throws ZipException {
        m3052a(bArr, bArr2, cArr, aESExtraDataRecord);
    }

    /* renamed from: a */
    private void m3052a(byte[] bArr, byte[] bArr2, char[] cArr, AESExtraDataRecord aESExtraDataRecord) throws ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("empty or null password provided for AES decryption");
        }
        AesKeyStrength aesKeyStrength = aESExtraDataRecord.getAesKeyStrength();
        byte[] derivePasswordBasedKey = AesCipherUtil.derivePasswordBasedKey(bArr, cArr, aesKeyStrength);
        if (Arrays.equals(bArr2, AesCipherUtil.derivePasswordVerifier(derivePasswordBasedKey, aesKeyStrength))) {
            this.f4789a = AesCipherUtil.getAESEngine(derivePasswordBasedKey, aesKeyStrength);
            this.f4790b = AesCipherUtil.getMacBasedPRF(derivePasswordBasedKey, aesKeyStrength);
            return;
        }
        throw new ZipException("Wrong Password", ZipException.Type.WRONG_PASSWORD);
    }

    public int decryptData(byte[] bArr, int i, int i2) throws ZipException {
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            if (i3 >= i4) {
                return i2;
            }
            int i5 = i3 + 16;
            int i6 = i5 <= i4 ? 16 : i4 - i3;
            this.f4790b.update(bArr, i3, i6);
            AesCipherUtil.prepareBuffAESIVBytes(this.f4792d, this.f4791c);
            this.f4789a.processBlock(this.f4792d, this.f4793e);
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = i3 + i7;
                bArr[i8] = (byte) (bArr[i8] ^ this.f4793e[i7]);
            }
            this.f4791c++;
            i3 = i5;
        }
    }

    public byte[] getCalculatedAuthenticationBytes() {
        return this.f4790b.doFinal();
    }
}

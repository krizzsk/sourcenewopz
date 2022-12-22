package com.didichuxing.dfbasesdk.encrypt;

import com.didichuxing.dfbasesdk.utils.AESUtils;
import com.didichuxing.dfbasesdk.utils.Base64Utils;
import com.didichuxing.dfbasesdk.utils.GZipUtils;
import com.didichuxing.dfbasesdk.utils.RSAUtils;

public class Decrypter {

    public static class Input {
        public String cipherSecret;
        public String cipherText;
        public String rsaPrivate;
    }

    public static byte[] decipherAesKey(String str, String str2) throws Exception {
        return RSAUtils.decipherToBytes(str, str2);
    }

    public static String decrypt(String str, byte[] bArr) throws Exception {
        return new String(GZipUtils.decompress(AESUtils.aesDecrypt(Base64Utils.decode(str), bArr)), "UTF-8");
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) throws Exception {
        return AESUtils.aesDecrypt(bArr, bArr2);
    }

    public static String decrypt(Input input) throws Exception {
        return new String(GZipUtils.decompress(AESUtils.aesDecrypt(Base64Utils.decode(input.cipherText), RSAUtils.decipherToBytes(input.cipherSecret, input.rsaPrivate))), "UTF-8");
    }
}

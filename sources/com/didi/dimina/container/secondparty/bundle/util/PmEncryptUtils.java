package com.didi.dimina.container.secondparty.bundle.util;

import android.util.Base64;
import com.google.common.base.Ascii;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public final class PmEncryptUtils {

    /* renamed from: a */
    private static final char[] f17099a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private PmEncryptUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String encryptMD2ToString(String str) {
        return (str == null || str.length() == 0) ? "" : encryptMD2ToString(str.getBytes());
    }

    public static String encryptMD2ToString(byte[] bArr) {
        return m12662a(encryptMD2(bArr));
    }

    public static byte[] encryptMD2(byte[] bArr) {
        return m12664a(bArr, MessageDigestAlgorithms.MD2);
    }

    public static String encryptMD5ToString(String str) {
        return (str == null || str.length() == 0) ? "" : encryptMD5ToString(str.getBytes());
    }

    public static String encryptMD5ToString(String str, String str2) {
        if (str == null && str2 == null) {
            return "";
        }
        if (str2 == null) {
            return m12662a(encryptMD5(str.getBytes()));
        }
        if (str == null) {
            return m12662a(encryptMD5(str2.getBytes()));
        }
        return m12662a(encryptMD5((str + str2).getBytes()));
    }

    public static String encryptMD5ToString(byte[] bArr) {
        return m12662a(encryptMD5(bArr));
    }

    public static String encryptMD5ToString(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return "";
        }
        if (bArr2 == null) {
            return m12662a(encryptMD5(bArr));
        }
        if (bArr == null) {
            return m12662a(encryptMD5(bArr2));
        }
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return m12662a(encryptMD5(bArr3));
    }

    public static byte[] encryptMD5(byte[] bArr) {
        return m12664a(bArr, MessageDigestAlgorithms.MD5);
    }

    public static String encryptMD5File2String(String str) {
        return encryptMD5File2String(m12669b(str) ? null : new File(str));
    }

    public static byte[] encryptMD5File(String str) {
        return encryptMD5File(m12669b(str) ? null : new File(str));
    }

    public static String encryptMD5File2String(File file) {
        return m12662a(encryptMD5File(file));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004b A[SYNTHETIC, Splitter:B:31:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] encryptMD5File(java.io.File r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0037, IOException -> 0x0035, all -> 0x0033 }
            r1.<init>(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0037, IOException -> 0x0035, all -> 0x0033 }
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            r2.<init>(r1, r4)     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            r4 = 262144(0x40000, float:3.67342E-40)
            byte[] r4 = new byte[r4]     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
        L_0x0018:
            int r3 = r2.read(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            if (r3 > 0) goto L_0x0018
            java.security.MessageDigest r4 = r2.getMessageDigest()     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            byte[] r4 = r4.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            r1.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002e:
            return r4
        L_0x002f:
            r4 = move-exception
            goto L_0x0039
        L_0x0031:
            r4 = move-exception
            goto L_0x0039
        L_0x0033:
            r4 = move-exception
            goto L_0x0049
        L_0x0035:
            r4 = move-exception
            goto L_0x0038
        L_0x0037:
            r4 = move-exception
        L_0x0038:
            r1 = r0
        L_0x0039:
            r4.printStackTrace()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0046:
            return r0
        L_0x0047:
            r4 = move-exception
            r0 = r1
        L_0x0049:
            if (r0 == 0) goto L_0x0053
            r0.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0053:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.bundle.util.PmEncryptUtils.encryptMD5File(java.io.File):byte[]");
    }

    public static String encryptSHA1ToString(String str) {
        return (str == null || str.length() == 0) ? "" : encryptSHA1ToString(str.getBytes());
    }

    public static String encryptSHA1ToString(byte[] bArr) {
        return m12662a(encryptSHA1(bArr));
    }

    public static byte[] encryptSHA1(byte[] bArr) {
        return m12664a(bArr, "SHA-1");
    }

    public static String encryptSHA224ToString(String str) {
        return (str == null || str.length() == 0) ? "" : encryptSHA224ToString(str.getBytes());
    }

    public static String encryptSHA224ToString(byte[] bArr) {
        return m12662a(encryptSHA224(bArr));
    }

    public static byte[] encryptSHA224(byte[] bArr) {
        return m12664a(bArr, "SHA224");
    }

    public static String encryptSHA256ToString(String str) {
        return (str == null || str.length() == 0) ? "" : encryptSHA256ToString(str.getBytes());
    }

    public static String encryptSHA256ToString(byte[] bArr) {
        return m12662a(encryptSHA256(bArr));
    }

    public static byte[] encryptSHA256(byte[] bArr) {
        return m12664a(bArr, "SHA-256");
    }

    public static String encryptSHA384ToString(String str) {
        return (str == null || str.length() == 0) ? "" : encryptSHA384ToString(str.getBytes());
    }

    public static String encryptSHA384ToString(byte[] bArr) {
        return m12662a(encryptSHA384(bArr));
    }

    public static byte[] encryptSHA384(byte[] bArr) {
        return m12664a(bArr, "SHA-384");
    }

    public static String encryptSHA512ToString(String str) {
        return (str == null || str.length() == 0) ? "" : encryptSHA512ToString(str.getBytes());
    }

    public static String encryptSHA512ToString(byte[] bArr) {
        return m12662a(encryptSHA512(bArr));
    }

    public static byte[] encryptSHA512(byte[] bArr) {
        return m12664a(bArr, "SHA-512");
    }

    /* renamed from: a */
    private static byte[] m12664a(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                instance.update(bArr);
                return instance.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String encryptHmacMD5ToString(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : encryptHmacMD5ToString(str.getBytes(), str2.getBytes());
    }

    public static String encryptHmacMD5ToString(byte[] bArr, byte[] bArr2) {
        return m12662a(encryptHmacMD5(bArr, bArr2));
    }

    public static byte[] encryptHmacMD5(byte[] bArr, byte[] bArr2) {
        return m12666a(bArr, bArr2, "HmacMD5");
    }

    public static String encryptHmacSHA1ToString(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : encryptHmacSHA1ToString(str.getBytes(), str2.getBytes());
    }

    public static String encryptHmacSHA1ToString(byte[] bArr, byte[] bArr2) {
        return m12662a(encryptHmacSHA1(bArr, bArr2));
    }

    public static byte[] encryptHmacSHA1(byte[] bArr, byte[] bArr2) {
        return m12666a(bArr, bArr2, InternalZipConstants.AES_MAC_ALGORITHM);
    }

    public static String encryptHmacSHA224ToString(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : encryptHmacSHA224ToString(str.getBytes(), str2.getBytes());
    }

    public static String encryptHmacSHA224ToString(byte[] bArr, byte[] bArr2) {
        return m12662a(encryptHmacSHA224(bArr, bArr2));
    }

    public static byte[] encryptHmacSHA224(byte[] bArr, byte[] bArr2) {
        return m12666a(bArr, bArr2, "HmacSHA224");
    }

    public static String encryptHmacSHA256ToString(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : encryptHmacSHA256ToString(str.getBytes(), str2.getBytes());
    }

    public static String encryptHmacSHA256ToString(byte[] bArr, byte[] bArr2) {
        return m12662a(encryptHmacSHA256(bArr, bArr2));
    }

    public static byte[] encryptHmacSHA256(byte[] bArr, byte[] bArr2) {
        return m12666a(bArr, bArr2, "HmacSHA256");
    }

    public static String encryptHmacSHA384ToString(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : encryptHmacSHA384ToString(str.getBytes(), str2.getBytes());
    }

    public static String encryptHmacSHA384ToString(byte[] bArr, byte[] bArr2) {
        return m12662a(encryptHmacSHA384(bArr, bArr2));
    }

    public static byte[] encryptHmacSHA384(byte[] bArr, byte[] bArr2) {
        return m12666a(bArr, bArr2, "HmacSHA384");
    }

    public static String encryptHmacSHA512ToString(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : encryptHmacSHA512ToString(str.getBytes(), str2.getBytes());
    }

    public static String encryptHmacSHA512ToString(byte[] bArr, byte[] bArr2) {
        return m12662a(encryptHmacSHA512(bArr, bArr2));
    }

    public static byte[] encryptHmacSHA512(byte[] bArr, byte[] bArr2) {
        return m12666a(bArr, bArr2, "HmacSHA512");
    }

    /* renamed from: a */
    private static byte[] m12666a(byte[] bArr, byte[] bArr2, String str) {
        if (!(bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0)) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, str);
                Mac instance = Mac.getInstance(str);
                instance.init(secretKeySpec);
                return instance.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] encryptDES2Base64(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12670b(encryptDES(bArr, bArr2, str, bArr3));
    }

    public static String encryptDES2HexString(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12662a(encryptDES(bArr, bArr2, str, bArr3));
    }

    public static byte[] encryptDES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12667a(bArr, bArr2, "DES", str, bArr3, true);
    }

    public static byte[] decryptBase64DES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return decryptDES(m12671c(bArr), bArr2, str, bArr3);
    }

    public static byte[] decryptHexStringDES(String str, byte[] bArr, String str2, byte[] bArr2) {
        return decryptDES(m12663a(str), bArr, str2, bArr2);
    }

    public static byte[] decryptDES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12667a(bArr, bArr2, "DES", str, bArr3, false);
    }

    public static byte[] encrypt3DES2Base64(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12670b(encrypt3DES(bArr, bArr2, str, bArr3));
    }

    public static String encrypt3DES2HexString(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12662a(encrypt3DES(bArr, bArr2, str, bArr3));
    }

    public static byte[] encrypt3DES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12667a(bArr, bArr2, "DESede", str, bArr3, true);
    }

    public static byte[] decryptBase64_3DES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return decrypt3DES(m12671c(bArr), bArr2, str, bArr3);
    }

    public static byte[] decryptHexString3DES(String str, byte[] bArr, String str2, byte[] bArr2) {
        return decrypt3DES(m12663a(str), bArr, str2, bArr2);
    }

    public static byte[] decrypt3DES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12667a(bArr, bArr2, "DESede", str, bArr3, false);
    }

    public static byte[] encryptAES2Base64(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12670b(encryptAES(bArr, bArr2, str, bArr3));
    }

    public static String encryptAES2HexString(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12662a(encryptAES(bArr, bArr2, str, bArr3));
    }

    public static byte[] encryptAES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12667a(bArr, bArr2, "AES", str, bArr3, true);
    }

    public static byte[] decryptBase64AES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return decryptAES(m12671c(bArr), bArr2, str, bArr3);
    }

    public static byte[] decryptHexStringAES(String str, byte[] bArr, String str2, byte[] bArr2) {
        return decryptAES(m12663a(str), bArr, str2, bArr2);
    }

    public static byte[] decryptAES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m12667a(bArr, bArr2, "AES", str, bArr3, false);
    }

    /* renamed from: a */
    private static byte[] m12667a(byte[] bArr, byte[] bArr2, String str, String str2, byte[] bArr3, boolean z) {
        SecretKey secretKey;
        if (!(bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0)) {
            try {
                if ("DES".equals(str)) {
                    secretKey = SecretKeyFactory.getInstance(str).generateSecret(new DESKeySpec(bArr2));
                } else {
                    secretKey = new SecretKeySpec(bArr2, str);
                }
                Cipher instance = Cipher.getInstance(str2);
                int i = 1;
                if (bArr3 != null) {
                    if (bArr3.length != 0) {
                        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
                        if (!z) {
                            i = 2;
                        }
                        instance.init(i, secretKey, ivParameterSpec);
                        return instance.doFinal(bArr);
                    }
                }
                if (!z) {
                    i = 2;
                }
                instance.init(i, secretKey);
                return instance.doFinal(bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] encryptRSA2Base64(byte[] bArr, byte[] bArr2, boolean z, String str) {
        return m12670b(encryptRSA(bArr, bArr2, z, str));
    }

    public static String encryptRSA2HexString(byte[] bArr, byte[] bArr2, boolean z, String str) {
        return m12662a(encryptRSA(bArr, bArr2, z, str));
    }

    public static byte[] encryptRSA(byte[] bArr, byte[] bArr2, boolean z, String str) {
        return m12668a(bArr, bArr2, z, str, true);
    }

    public static byte[] decryptBase64RSA(byte[] bArr, byte[] bArr2, boolean z, String str) {
        return decryptRSA(m12671c(bArr), bArr2, z, str);
    }

    public static byte[] decryptHexStringRSA(String str, byte[] bArr, boolean z, String str2) {
        return decryptRSA(m12663a(str), bArr, z, str2);
    }

    public static byte[] decryptRSA(byte[] bArr, byte[] bArr2, boolean z, String str) {
        return m12668a(bArr, bArr2, z, str, false);
    }

    /* renamed from: a */
    private static byte[] m12668a(byte[] bArr, byte[] bArr2, boolean z, String str, boolean z2) {
        Key key;
        if (!(bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0)) {
            if (z) {
                try {
                    key = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e2) {
                    e2.printStackTrace();
                } catch (InvalidKeyException e3) {
                    e3.printStackTrace();
                } catch (BadPaddingException e4) {
                    e4.printStackTrace();
                } catch (IllegalBlockSizeException e5) {
                    e5.printStackTrace();
                } catch (InvalidKeySpecException e6) {
                    e6.printStackTrace();
                }
            } else {
                key = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr2));
            }
            if (key == null) {
                return null;
            }
            Cipher instance = Cipher.getInstance(str);
            instance.init(z2 ? 1 : 2, key);
            int length = bArr.length;
            int i = z2 ? 117 : 128;
            int i2 = length / i;
            if (i2 <= 0) {
                return instance.doFinal(bArr);
            }
            byte[] bArr3 = new byte[0];
            byte[] bArr4 = new byte[i];
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                System.arraycopy(bArr, i3, bArr4, 0, i);
                bArr3 = m12665a(bArr3, instance.doFinal(bArr4));
                i3 += i;
            }
            if (i3 == length) {
                return bArr3;
            }
            int i5 = length - i3;
            byte[] bArr5 = new byte[i5];
            System.arraycopy(bArr, i3, bArr5, 0, i5);
            return m12665a(bArr3, instance.doFinal(bArr5));
        }
        return null;
    }

    /* renamed from: a */
    private static byte[] m12665a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: a */
    private static String m12662a(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return "";
        }
        char[] cArr = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = f17099a;
            cArr[i] = cArr2[(bArr[i2] >> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & Ascii.f53593SI];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    private static byte[] m12663a(String str) {
        if (m12669b(str)) {
            return null;
        }
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length++;
        }
        char[] charArray = str.toUpperCase().toCharArray();
        byte[] bArr = new byte[(length >> 1)];
        for (int i = 0; i < length; i += 2) {
            bArr[i >> 1] = (byte) ((m12661a(charArray[i]) << 4) | m12661a(charArray[i + 1]));
        }
        return bArr;
    }

    /* renamed from: a */
    private static int m12661a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: b */
    private static byte[] m12670b(byte[] bArr) {
        return Base64.encode(bArr, 2);
    }

    /* renamed from: c */
    private static byte[] m12671c(byte[] bArr) {
        return Base64.decode(bArr, 2);
    }

    /* renamed from: b */
    private static boolean m12669b(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

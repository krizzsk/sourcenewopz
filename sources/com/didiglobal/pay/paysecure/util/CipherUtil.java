package com.didiglobal.pay.paysecure.util;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/util/CipherUtil;", "", "()V", "CIPHER_ALGORITHM", "", "CIPHER_ALGORITHM_ECB", "KEY_ALGORITHM", "aesEncrypt", "data", "secretKey", "iv", "", "byteToHexString", "bytes", "decrypt", "content", "aesKey", "encryptRSAToString", "clearText", "publicKey", "getAESIv", "getAESKey", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CipherUtil.kt */
public final class CipherUtil {
    public static final CipherUtil INSTANCE = new CipherUtil();

    /* renamed from: a */
    private static final String f50466a = "AES";

    /* renamed from: b */
    private static final String f50467b = "AES/CBC/PKCS5Padding";

    /* renamed from: c */
    private static final String f50468c = "AES/ECB/PKCS7Padding";

    private CipherUtil() {
    }

    public final String aesEncrypt(String str, String str2, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(str, "data");
        Intrinsics.checkParameterIsNotNull(str2, "secretKey");
        Intrinsics.checkParameterIsNotNull(bArr, "iv");
        try {
            byte[] bytes = str2.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, f50467b);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            Cipher instance = Cipher.getInstance(f50467b);
            Intrinsics.checkExpressionValueIsNotNull(instance, "Cipher.getInstance(CIPHER_ALGORITHM)");
            instance.init(1, secretKeySpec, ivParameterSpec);
            byte[] bytes2 = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes2, "(this as java.lang.String).getBytes(charset)");
            byte[] doFinal = instance.doFinal(bytes2);
            Intrinsics.checkExpressionValueIsNotNull(doFinal, "cipher.doFinal(data.toByteArray())");
            String encodeToString = Base64.encodeToString(doFinal, 2);
            Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(encryptByte, Base64.NO_WRAP)");
            return encodeToString;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final String aesEncrypt(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "data");
        Intrinsics.checkParameterIsNotNull(str2, "secretKey");
        try {
            byte[] bytes = str2.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, f50468c);
            Cipher instance = Cipher.getInstance(f50468c);
            Intrinsics.checkExpressionValueIsNotNull(instance, "Cipher.getInstance(CIPHER_ALGORITHM_ECB)");
            instance.init(1, secretKeySpec);
            byte[] bytes2 = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes2, "(this as java.lang.String).getBytes(charset)");
            byte[] doFinal = instance.doFinal(bytes2);
            Intrinsics.checkExpressionValueIsNotNull(doFinal, "cipher.doFinal(data.toByteArray())");
            String encodeToString = Base64.encodeToString(doFinal, 2);
            Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(encryptByte, Base64.NO_WRAP)");
            return encodeToString;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final String decrypt(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str2, "aesKey");
        try {
            byte[] decode = Base64.decode(str, 2);
            Cipher instance = Cipher.getInstance(f50468c);
            byte[] bytes = str2.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.init(2, new SecretKeySpec(bytes, f50466a));
            byte[] doFinal = instance.doFinal(decode);
            Intrinsics.checkExpressionValueIsNotNull(doFinal, "result");
            return new String(doFinal, Charsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String getAESKey() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(f50466a);
            Intrinsics.checkExpressionValueIsNotNull(instance, "KeyGenerator.getInstance(KEY_ALGORITHM)");
            instance.init(128);
            SecretKey generateKey = instance.generateKey();
            Intrinsics.checkExpressionValueIsNotNull(generateKey, "secretKey");
            byte[] encoded = generateKey.getEncoded();
            Intrinsics.checkExpressionValueIsNotNull(encoded, "secretKey.encoded");
            return m36280a(encoded);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public final String getAESIv() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return m36280a(bArr);
    }

    /* renamed from: a */
    private final String m36280a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte hexString : bArr) {
            String hexString2 = Integer.toHexString(hexString);
            if (hexString2.length() > 3) {
                Intrinsics.checkExpressionValueIsNotNull(hexString2, "strHex");
                if (hexString2 != null) {
                    String substring = hexString2.substring(6);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                    stringBuffer.append(substring);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (hexString2.length() < 2) {
                stringBuffer.append('0' + hexString2);
            } else {
                stringBuffer.append(hexString2);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "sb.toString()");
        return stringBuffer2;
    }

    public final String encryptRSAToString(String str, String str2) {
        String str3;
        Intrinsics.checkParameterIsNotNull(str, "clearText");
        Intrinsics.checkParameterIsNotNull(str2, "publicKey");
        try {
            KeyFactory instance = KeyFactory.getInstance("RSA");
            CharSequence charSequence = str2;
            int length = charSequence.length() - 1;
            int i = 0;
            boolean z = false;
            while (true) {
                if (i > length) {
                    break;
                }
                boolean z2 = charSequence.charAt(!z ? i : length) <= ' ';
                if (!z) {
                    if (!z2) {
                        z = true;
                    } else {
                        i++;
                    }
                } else if (!z2) {
                    break;
                } else {
                    length--;
                }
            }
            String obj = charSequence.subSequence(i, length + 1).toString();
            Charset charset = Charsets.UTF_8;
            if (obj != null) {
                byte[] bytes = obj.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                PublicKey generatePublic = instance.generatePublic(new X509EncodedKeySpec(Base64.decode(bytes, 0)));
                Intrinsics.checkExpressionValueIsNotNull(generatePublic, "keyFac.generatePublic(keySpec)");
                Cipher instance2 = Cipher.getInstance("RSA/None/PKCS1Padding");
                instance2.init(1, generatePublic);
                byte[] bytes2 = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkExpressionValueIsNotNull(bytes2, "(this as java.lang.String).getBytes(charset)");
                byte[] encode = Base64.encode(instance2.doFinal(Base64.encode(bytes2, 2)), 2);
                Intrinsics.checkExpressionValueIsNotNull(encode, "Base64.encode(encryptedBytes, Base64.NO_WRAP)");
                str3 = new String(encode, Charsets.UTF_8);
                return new Regex("(\\r|\\n)").replace((CharSequence) str3, "");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e) {
            e.printStackTrace();
            str3 = "";
        }
    }
}

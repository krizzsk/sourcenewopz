package com.didi.payment.creditcard.base.encryption;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* renamed from: com.didi.payment.creditcard.base.encryption.g */
/* compiled from: RSA */
class C10607g {

    /* renamed from: a */
    private static int f30294a = 1024;

    C10607g() {
    }

    /* renamed from: a */
    public static Map<String, String> m21254a() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(f30294a, secureRandom);
        KeyPair generateKeyPair = instance.generateKeyPair();
        String str = new String(C10602b.m21200b(generateKeyPair.getPublic().getEncoded()), "UTF-8");
        String str2 = new String(C10602b.m21200b(generateKeyPair.getPrivate().getEncoded()), "UTF-8");
        HashMap hashMap = new HashMap();
        hashMap.put("publicKey", str);
        hashMap.put("privateKey", str2);
        hashMap.put("modulus", new String(C10602b.m21200b(((RSAPublicKey) generateKeyPair.getPublic()).getModulus().toByteArray())));
        return hashMap;
    }

    /* renamed from: a */
    public static String m21252a(String str, String str2) throws Exception {
        PublicKey a = m21253a(str2);
        Cipher instance = Cipher.getInstance(C10604d.f30291c);
        instance.init(1, a);
        return new String(C10602b.m21200b(instance.doFinal(str.getBytes())), "UTF-8");
    }

    /* renamed from: b */
    public static String m21256b(String str, String str2) throws Exception {
        PrivateKey b = m21257b(str2);
        Cipher instance = Cipher.getInstance(C10604d.f30291c);
        instance.init(2, b);
        return new String(instance.doFinal(C10602b.m21205e(str.getBytes())));
    }

    /* renamed from: a */
    public static PublicKey m21253a(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C10602b.m21205e(str.getBytes())));
    }

    /* renamed from: b */
    public static PrivateKey m21257b(String str) throws Exception {
        return KeyFactory.getInstance("RSA", BouncyCastleProvider.PROVIDER_NAME).generatePrivate(new PKCS8EncodedKeySpec(C10602b.m21205e(str.getBytes())));
    }

    /* renamed from: c */
    public static String m21258c(String str, String str2) {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C10602b.m21205e(str2.getBytes())));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initSign(generatePrivate);
            instance.update(str.getBytes("UTF-8"));
            return new String(C10602b.m21200b(instance.sign()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public static String m21259d(String str, String str2) {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C10602b.m21205e(str2.getBytes())));
            Signature instance = Signature.getInstance("SHA256WithRSA");
            instance.initSign(generatePrivate);
            instance.update(str.getBytes("UTF-8"));
            return new String(C10602b.m21200b(instance.sign()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m21255a(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C10602b.m21202c(str3)));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initVerify(generatePublic);
            instance.update(str.getBytes("utf-8"));
            return instance.verify(C10602b.m21202c(str2));
        } catch (Exception unused) {
            return false;
        }
    }
}

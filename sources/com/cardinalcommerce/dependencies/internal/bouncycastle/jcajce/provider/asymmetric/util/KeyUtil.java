package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.getProxyAddress;
import org.bouncycastle.asn1.ASN1Encoding;

public class KeyUtil {
    public static byte[] Cardinal(DSASigner.stdDSA stddsa, getProxyAddress getproxyaddress) {
        try {
            return m2209a(new PrivateKeyInfo(stddsa, getproxyaddress.values()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m2209a(PrivateKeyInfo privateKeyInfo) {
        try {
            return privateKeyInfo.init(ASN1Encoding.DER);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] configure(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            return subjectPublicKeyInfo.init(ASN1Encoding.DER);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] getInstance(DSASigner.stdDSA stddsa, getProxyAddress getproxyaddress) {
        try {
            return configure(new SubjectPublicKeyInfo(stddsa, getproxyaddress));
        } catch (Exception unused) {
            return null;
        }
    }
}

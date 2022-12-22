package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.DSASigner;
import java.security.SecureRandom;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.setDrawingCacheEnabled */
public final class setDrawingCacheEnabled {
    public final int Cardinal;

    /* renamed from: a */
    private final int f2761a;
    public final int cca_continue;
    public final int configure;
    public final SecureRandom getInstance;

    public setDrawingCacheEnabled() {
    }

    /* renamed from: a */
    private static byte[] m1982a(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            return subjectPublicKeyInfo.init(ASN1Encoding.DER);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] init(DSASigner.stdDSA stddsa, getProxyAddress getproxyaddress) {
        try {
            return m1982a(new SubjectPublicKeyInfo(stddsa, getproxyaddress));
        } catch (Exception unused) {
            return null;
        }
    }

    public setDrawingCacheEnabled(int i, int i2, int i3, SecureRandom secureRandom, byte b) {
        this(i, i2, i3, secureRandom);
    }

    private setDrawingCacheEnabled(int i, int i2, int i3, SecureRandom secureRandom) {
        this.configure = i;
        this.Cardinal = i2;
        this.cca_continue = i3;
        this.f2761a = -1;
        this.getInstance = secureRandom;
    }
}

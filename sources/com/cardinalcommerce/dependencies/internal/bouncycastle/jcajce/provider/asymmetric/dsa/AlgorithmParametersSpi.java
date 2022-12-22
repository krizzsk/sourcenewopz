package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.cardinalcommerce.p060a.GMCipherSpi;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1Encoding;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {

    /* renamed from: a */
    private DSAParameterSpec f3156a;

    /* renamed from: a */
    private static boolean m2190a(String str) {
        return str == null || str.equals("ASN.1");
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded() {
        try {
            return new GMCipherSpi.SM2withBlake2s(this.f3156a.getP(), this.f3156a.getQ(), this.f3156a.getG()).init(ASN1Encoding.DER);
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding DSAParameters");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded(String str) {
        if (m2190a(str)) {
            return engineGetEncoded();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof DSAParameterSpec) {
            this.f3156a = (DSAParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("DSAParameterSpec required to initialise a DSA algorithm parameters object");
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (m2190a(str) || str.equalsIgnoreCase("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unknown parameter format ".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "DSA Parameters";
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls == null) {
            throw new NullPointerException("argument to getParameterSpec must not be null");
        } else if (cls == DSAParameterSpec.class || cls == AlgorithmParameterSpec.class) {
            return this.f3156a;
        } else {
            throw new InvalidParameterSpecException("unknown parameter spec passed to DSA parameters object.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr) throws IOException {
        try {
            setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(bArr);
            GMCipherSpi.SM2withBlake2s sM2withBlake2s = instance != null ? new GMCipherSpi.SM2withBlake2s(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
            this.f3156a = new DSAParameterSpec(new BigInteger(1, sM2withBlake2s.configure.Cardinal), new BigInteger(1, sM2withBlake2s.cca_continue.Cardinal), new BigInteger(1, sM2withBlake2s.init.Cardinal));
        } catch (ClassCastException unused) {
            throw new IOException("Not a valid DSA Parameter encoding.");
        } catch (ArrayIndexOutOfBoundsException unused2) {
            throw new IOException("Not a valid DSA Parameter encoding.");
        }
    }
}

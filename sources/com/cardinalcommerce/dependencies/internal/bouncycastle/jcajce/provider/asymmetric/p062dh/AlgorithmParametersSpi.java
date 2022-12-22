package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p062dh;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.AlgorithmParametersSpi */
public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {

    /* renamed from: a */
    private DHParameterSpec f3145a;

    /* renamed from: a */
    private static boolean m2188a(String str) {
        return str == null || str.equals("ASN.1");
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded() {
        try {
            return new KeyAgreementSpi.MQVwithSHA384KDF(this.f3145a.getP(), this.f3145a.getG(), this.f3145a.getL()).init(ASN1Encoding.DER);
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding DHParameters");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded(String str) {
        if (m2188a(str)) {
            return engineGetEncoded();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            this.f3145a = (DHParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("DHParameterSpec required to initialise a Diffie-Hellman algorithm parameters object");
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (m2188a(str)) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unknown parameter format ".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "Diffie-Hellman Parameters";
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls == null) {
            throw new NullPointerException("argument to getParameterSpec must not be null");
        } else if (cls == DHParameterSpec.class || cls == AlgorithmParameterSpec.class) {
            return this.f3145a;
        } else {
            throw new InvalidParameterSpecException("unknown parameter spec passed to DH parameters object.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr) throws IOException {
        KeyAgreementSpi.MQVwithSHA384KDF mQVwithSHA384KDF;
        BigInteger bigInteger;
        BigInteger bigInteger2 = null;
        if (bArr != null) {
            try {
                mQVwithSHA384KDF = new KeyAgreementSpi.MQVwithSHA384KDF(setThreeDSRequestorAppURL.cca_continue((Object) bArr));
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid DH Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid DH Parameter encoding.");
            }
        } else {
            mQVwithSHA384KDF = null;
        }
        if (mQVwithSHA384KDF.Cardinal == null) {
            bigInteger = null;
        } else {
            bigInteger = new BigInteger(1, mQVwithSHA384KDF.Cardinal.Cardinal);
        }
        if (bigInteger != null) {
            BigInteger bigInteger3 = new BigInteger(1, mQVwithSHA384KDF.init.Cardinal);
            BigInteger bigInteger4 = new BigInteger(1, mQVwithSHA384KDF.configure.Cardinal);
            if (mQVwithSHA384KDF.Cardinal != null) {
                bigInteger2 = new BigInteger(1, mQVwithSHA384KDF.Cardinal.Cardinal);
            }
            this.f3145a = new DHParameterSpec(bigInteger3, bigInteger4, bigInteger2.intValue());
            return;
        }
        this.f3145a = new DHParameterSpec(new BigInteger(1, mQVwithSHA384KDF.init.Cardinal), new BigInteger(1, mQVwithSHA384KDF.configure.Cardinal));
    }
}

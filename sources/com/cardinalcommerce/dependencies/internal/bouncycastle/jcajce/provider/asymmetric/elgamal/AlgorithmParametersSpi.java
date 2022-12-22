package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.cardinalcommerce.p060a.AsymmetricKeyInfoConverter;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getTransactionStatus;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.asn1.ASN1Encoding;

public class AlgorithmParametersSpi extends AsymmetricKeyInfoConverter {

    /* renamed from: a */
    private getTransactionStatus f3196a;

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded(String str) {
        if (init(str) || str.equalsIgnoreCase("X.509")) {
            return engineGetEncoded();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        boolean z = algorithmParameterSpec instanceof getTransactionStatus;
        if (!z && !(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new InvalidParameterSpecException("DHParameterSpec required to initialise a ElGamal algorithm parameters object");
        } else if (z) {
            this.f3196a = (getTransactionStatus) algorithmParameterSpec;
        } else {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            this.f3196a = new getTransactionStatus(dHParameterSpec.getP(), dHParameterSpec.getG());
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (init(str) || str.equalsIgnoreCase("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unknown parameter format ".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "ElGamal Parameters";
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded() {
        try {
            return new KeyAgreementSpi.MQVwithSHA256CKDF(this.f3196a.configure, this.f3196a.Cardinal).init(ASN1Encoding.DER);
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding ElGamalParameters");
        }
    }

    public final AlgorithmParameterSpec configure(Class cls) throws InvalidParameterSpecException {
        if (cls == getTransactionStatus.class || cls == AlgorithmParameterSpec.class) {
            return this.f3196a;
        }
        if (cls == DHParameterSpec.class) {
            return new DHParameterSpec(this.f3196a.configure, this.f3196a.Cardinal);
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr) throws IOException {
        try {
            setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(bArr);
            KeyAgreementSpi.MQVwithSHA256CKDF mQVwithSHA256CKDF = instance != null ? new KeyAgreementSpi.MQVwithSHA256CKDF(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
            this.f3196a = new getTransactionStatus(new BigInteger(1, mQVwithSHA256CKDF.configure.Cardinal), new BigInteger(1, mQVwithSHA256CKDF.Cardinal.Cardinal));
        } catch (ClassCastException unused) {
            throw new IOException("Not a valid ElGamal Parameter encoding.");
        } catch (ArrayIndexOutOfBoundsException unused2) {
            throw new IOException("Not a valid ElGamal Parameter encoding.");
        }
    }
}

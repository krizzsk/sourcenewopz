package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.gost;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.ProtocolErrorEvent;
import com.cardinalcommerce.p060a.setErrorCode;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1Encoding;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {

    /* renamed from: a */
    private ProtocolErrorEvent f3203a;

    /* renamed from: a */
    private static boolean m2199a(String str) {
        return str == null || str.equals("ASN.1");
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded(String str) {
        if (m2199a(str) || str.equalsIgnoreCase("X.509")) {
            return engineGetEncoded();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof ProtocolErrorEvent) {
            this.f3203a = (ProtocolErrorEvent) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("GOST3410ParameterSpec required to initialise a GOST3410 algorithm parameters object");
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr) throws IOException {
        try {
            this.f3203a = ProtocolErrorEvent.configure(new KeyAgreementSpi.DHwithSHA1CKDF((setThreeDSRequestorAppURL) setLocationDataConsentGiven.getInstance(bArr)));
        } catch (ClassCastException unused) {
            throw new IOException("Not a valid GOST3410 Parameter encoding.");
        } catch (ArrayIndexOutOfBoundsException unused2) {
            throw new IOException("Not a valid GOST3410 Parameter encoding.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (m2199a(str) || str.equalsIgnoreCase("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unknown parameter format ".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "GOST3410 Parameters";
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls == null) {
            throw new NullPointerException("argument to getParameterSpec must not be null");
        } else if (cls == setErrorCode.class || cls == AlgorithmParameterSpec.class) {
            return this.f3203a;
        } else {
            throw new InvalidParameterSpecException("unknown parameter spec passed to GOST3410 parameters object.");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded() {
        try {
            return new KeyAgreementSpi.DHwithSHA1CKDF(new ASN1ObjectIdentifier(this.f3203a.init), new ASN1ObjectIdentifier(this.f3203a.Cardinal), new ASN1ObjectIdentifier(this.f3203a.configure)).init(ASN1Encoding.DER);
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding GOST3410Parameters");
        }
    }
}

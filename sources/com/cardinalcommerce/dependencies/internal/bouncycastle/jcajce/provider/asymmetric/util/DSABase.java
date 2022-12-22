package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.X931SignatureSpi;
import java.math.BigInteger;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;

public abstract class DSABase extends SignatureSpi implements IESCipher.ECIESwithDESedeCBC, KeyFactorySpi {
    public KeyFactorySpi.C1979EC getErrorDescription;
    public KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo getPayment;
    private X931SignatureSpi.RIPEMD128WithRSAEncryption onValidated;

    public DSABase(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, KeyFactorySpi.C1979EC ec, X931SignatureSpi.RIPEMD128WithRSAEncryption rIPEMD128WithRSAEncryption) {
        this.getPayment = mQVwithSHA256KDFAndSharedInfo;
        this.getErrorDescription = ec;
        this.onValidated = rIPEMD128WithRSAEncryption;
    }

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.getPayment.getInstance()];
        this.getPayment.configure(bArr, 0);
        try {
            BigInteger[] configure = this.getErrorDescription.configure(bArr);
            return this.onValidated.getInstance(this.getErrorDescription.cca_continue(), configure[0], configure[1]);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.getPayment.Cardinal(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.getPayment.init(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.getPayment.getInstance()];
        this.getPayment.configure(bArr2, 0);
        try {
            BigInteger[] configure = this.onValidated.configure(this.getErrorDescription.cca_continue(), bArr);
            return this.getErrorDescription.init(bArr2, configure[0], configure[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }
}

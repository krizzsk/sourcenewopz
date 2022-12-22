package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.cardinalcommerce.p060a.BCECGOST3410PrivateKey;
import com.cardinalcommerce.p060a.BCEdDSAPrivateKey;
import com.cardinalcommerce.p060a.BaseAgreementSpi;
import com.cardinalcommerce.p060a.ECGOST2012SignatureSpi512;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;

public class ISOSignatureSpi extends SignatureSpi {
    private BaseAgreementSpi cca_continue;

    public static class RIPEMD160WithRSAEncryption extends ISOSignatureSpi {
        public RIPEMD160WithRSAEncryption() {
            super(new SignatureSpi.ecDetDSASha3_256(), new BCEdDSAPrivateKey());
        }
    }

    public static class WhirlpoolWithRSAEncryption extends ISOSignatureSpi {
        public WhirlpoolWithRSAEncryption() {
            super(new ECGOST2012SignatureSpi512(), new BCEdDSAPrivateKey());
        }
    }

    protected ISOSignatureSpi(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo) {
        this.cca_continue = new BaseAgreementSpi(dHwithSHA384KDFAndSharedInfo, mQVwithSHA256KDFAndSharedInfo);
    }

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        this.cca_continue.cca_continue(true, RSAUtil.m2202a((RSAPrivateKey) privateKey));
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        this.cca_continue.cca_continue(false, RSAUtil.m2203a((RSAPublicKey) publicKey));
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
        try {
            return this.cca_continue.Cardinal();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.cca_continue.init(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.cca_continue.cca_continue(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.cca_continue.init(bArr);
    }

    public static class MD5WithRSAEncryption extends ISOSignatureSpi {
        public MD5WithRSAEncryption() {
            super(new SignatureSpi.ecDetDSA512(), new BCEdDSAPrivateKey());
        }
    }

    public static class SHA1WithRSAEncryption extends ISOSignatureSpi {
        public SHA1WithRSAEncryption() {
            super(new SignatureSpi.ecNR224(), new BCEdDSAPrivateKey());
        }
    }

    public static class SHA224WithRSAEncryption extends ISOSignatureSpi {
        public SHA224WithRSAEncryption() {
            super(new SignatureSpi.ecNR256(), new BCEdDSAPrivateKey());
        }
    }

    public static class SHA256WithRSAEncryption extends ISOSignatureSpi {
        public SHA256WithRSAEncryption() {
            super(new SignatureSpi.ecNR(), new BCEdDSAPrivateKey());
        }
    }

    public static class SHA384WithRSAEncryption extends ISOSignatureSpi {
        public SHA384WithRSAEncryption() {
            super(new SignatureSpi.ecNR384(), new BCEdDSAPrivateKey());
        }
    }

    public static class SHA512WithRSAEncryption extends ISOSignatureSpi {
        public SHA512WithRSAEncryption() {
            super(new BCECGOST3410PrivateKey(), new BCEdDSAPrivateKey());
        }
    }

    public static class SHA512_224WithRSAEncryption extends ISOSignatureSpi {
        public SHA512_224WithRSAEncryption() {
            super(new SignatureSpi.ecPlainDSARP160(224), new BCEdDSAPrivateKey());
        }
    }

    public static class SHA512_256WithRSAEncryption extends ISOSignatureSpi {
        public SHA512_256WithRSAEncryption() {
            super(new SignatureSpi.ecPlainDSARP160(256), new BCEdDSAPrivateKey());
        }
    }
}

package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.cardinalcommerce.p060a.BCECGOST3410PrivateKey;
import com.cardinalcommerce.p060a.DESUtil;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.X931SignatureSpi;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;

public class DSASigner extends SignatureSpi implements IESCipher.ECIESwithDESedeCBC, KeyFactorySpi {
    private X931SignatureSpi.RIPEMD128WithRSAEncryption ASN1ObjectIdentifier = DESUtil.cca_continue;
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo getErrorDescription;
    private KeyFactorySpi.C1979EC getPayment;
    private SecureRandom onValidated;

    public static class noneDSA extends DSASigner {
        public noneDSA() {
            super(new SignatureSpi.ecDetDSASha3_224(), new X931SignatureSpi.RIPEMD160WithRSAEncryption());
        }
    }

    protected DSASigner(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, KeyFactorySpi.C1979EC ec) {
        this.getErrorDescription = mQVwithSHA256KDFAndSharedInfo;
        this.getPayment = ec;
    }

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        KeyAgreementSpi.ECKAEGwithSHA512KDF cca_continue = DSAUtil.cca_continue(privateKey);
        SecureRandom secureRandom = this.onValidated;
        if (secureRandom != null) {
            cca_continue = new ISOSignatureSpi.SHA224WithRSAEncryption(cca_continue, secureRandom);
        }
        this.getErrorDescription.cca_continue();
        this.getPayment.getInstance(true, cca_continue);
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.onValidated = secureRandom;
        engineInitSign(privateKey);
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        setKeyboardNavigationCluster init = DSAUtil.init(publicKey);
        this.getErrorDescription.cca_continue();
        this.getPayment.getInstance(false, init);
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
        byte[] bArr = new byte[this.getErrorDescription.getInstance()];
        this.getErrorDescription.configure(bArr, 0);
        try {
            BigInteger[] configure = this.getPayment.configure(bArr);
            return this.ASN1ObjectIdentifier.getInstance(this.getPayment.cca_continue(), configure[0], configure[1]);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.getErrorDescription.Cardinal(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.getErrorDescription.init(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.getErrorDescription.getInstance()];
        this.getErrorDescription.configure(bArr2, 0);
        try {
            BigInteger[] configure = this.ASN1ObjectIdentifier.configure(this.getPayment.cca_continue(), bArr);
            return this.getPayment.init(bArr2, configure[0], configure[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    public static class detDSA extends DSASigner {
        public detDSA() {
            super(new SignatureSpi.ecNR224(), new X931SignatureSpi.RIPEMD160WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new SignatureSpi.ecNR224())));
        }
    }

    public static class detDSA224 extends DSASigner {
        public detDSA224() {
            super(new SignatureSpi.ecNR256(), new X931SignatureSpi.RIPEMD160WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new SignatureSpi.ecNR256())));
        }
    }

    public static class detDSA256 extends DSASigner {
        public detDSA256() {
            super(new SignatureSpi.ecNR(), new X931SignatureSpi.RIPEMD160WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new SignatureSpi.ecNR())));
        }
    }

    public static class detDSA384 extends DSASigner {
        public detDSA384() {
            super(new SignatureSpi.ecNR384(), new X931SignatureSpi.RIPEMD160WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new SignatureSpi.ecNR384())));
        }
    }

    public static class detDSA512 extends DSASigner {
        public detDSA512() {
            super(new BCECGOST3410PrivateKey(), new X931SignatureSpi.RIPEMD160WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new BCECGOST3410PrivateKey())));
        }
    }

    public static class detDSASha3_224 extends DSASigner {
        public detDSASha3_224() {
            super(new KeyAgreementSpi.ECVKO(224), new X931SignatureSpi.RIPEMD160WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new KeyAgreementSpi.ECVKO(224))));
        }
    }

    public static class detDSASha3_256 extends DSASigner {
        public detDSASha3_256() {
            super(new KeyAgreementSpi.ECVKO(256), new X931SignatureSpi.RIPEMD160WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new KeyAgreementSpi.ECVKO(256))));
        }
    }

    public static class detDSASha3_384 extends DSASigner {
        public detDSASha3_384() {
            super(new KeyAgreementSpi.ECVKO(384), new X931SignatureSpi.RIPEMD160WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new KeyAgreementSpi.ECVKO(384))));
        }
    }

    public static class detDSASha3_512 extends DSASigner {
        public detDSASha3_512() {
            super(new KeyAgreementSpi.ECVKO(512), new X931SignatureSpi.RIPEMD160WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new KeyAgreementSpi.ECVKO(512))));
        }
    }

    public static class dsa224 extends DSASigner {
        public dsa224() {
            super(new SignatureSpi.ecNR256(), new X931SignatureSpi.RIPEMD160WithRSAEncryption());
        }
    }

    public static class dsa256 extends DSASigner {
        public dsa256() {
            super(new SignatureSpi.ecNR(), new X931SignatureSpi.RIPEMD160WithRSAEncryption());
        }
    }

    public static class dsa384 extends DSASigner {
        public dsa384() {
            super(new SignatureSpi.ecNR384(), new X931SignatureSpi.RIPEMD160WithRSAEncryption());
        }
    }

    public static class dsa512 extends DSASigner {
        public dsa512() {
            super(new BCECGOST3410PrivateKey(), new X931SignatureSpi.RIPEMD160WithRSAEncryption());
        }
    }

    public static class dsaSha3_224 extends DSASigner {
        public dsaSha3_224() {
            super(new KeyAgreementSpi.ECVKO(224), new X931SignatureSpi.RIPEMD160WithRSAEncryption());
        }
    }

    public static class dsaSha3_256 extends DSASigner {
        public dsaSha3_256() {
            super(new KeyAgreementSpi.ECVKO(256), new X931SignatureSpi.RIPEMD160WithRSAEncryption());
        }
    }

    public static class dsaSha3_384 extends DSASigner {
        public dsaSha3_384() {
            super(new KeyAgreementSpi.ECVKO(384), new X931SignatureSpi.RIPEMD160WithRSAEncryption());
        }
    }

    public static class dsaSha3_512 extends DSASigner {
        public dsaSha3_512() {
            super(new KeyAgreementSpi.ECVKO(512), new X931SignatureSpi.RIPEMD160WithRSAEncryption());
        }
    }

    public static class stdDSA extends DSASigner {
        public stdDSA() {
            super(new SignatureSpi.ecNR224(), new X931SignatureSpi.RIPEMD160WithRSAEncryption());
        }
    }
}

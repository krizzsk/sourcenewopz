package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.BCECGOST3410PrivateKey;
import com.cardinalcommerce.p060a.BCEdDSAPrivateKey;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.GMCipherSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1Encoding;

public class DigestSignatureSpi extends SignatureSpi {
    private KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo cca_continue;
    private DSASigner.stdDSA configure;
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo init;

    public static class MD2 extends DigestSignatureSpi {
        public MD2() {
            super(KeyFactorySpi.getProxyAddress, new SignatureSpi.ecDetDSA(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class MD4 extends DigestSignatureSpi {
        public MD4() {
            super(KeyFactorySpi.getEnvironment, new SignatureSpi.ecDetDSASha3_384(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class RIPEMD128 extends DigestSignatureSpi {
        public RIPEMD128() {
            super(DSASigner.detDSA512.cca_continue, new SignatureSpi.ecDetDSA384(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class RIPEMD160 extends DigestSignatureSpi {
        public RIPEMD160() {
            super(DSASigner.detDSA512.Cardinal, new SignatureSpi.ecDetDSASha3_256(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class RIPEMD256 extends DigestSignatureSpi {
        public RIPEMD256() {
            super(DSASigner.detDSA512.init, new SignatureSpi.ecDetDSASha3_512(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class noneRSA extends DigestSignatureSpi {
        public noneRSA() {
            super(new SignatureSpi.ecDetDSASha3_224(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    protected DigestSignatureSpi(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo) {
        this.init = mQVwithSHA256KDFAndSharedInfo;
        this.cca_continue = dHwithSHA384KDFAndSharedInfo;
        this.configure = null;
    }

    protected DigestSignatureSpi(ASN1ObjectIdentifier aSN1ObjectIdentifier, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo) {
        this.init = mQVwithSHA256KDFAndSharedInfo;
        this.cca_continue = dHwithSHA384KDFAndSharedInfo;
        this.configure = new DSASigner.stdDSA(aSN1ObjectIdentifier, ECGOST.Mappings.Cardinal);
    }

    private byte[] configure(byte[] bArr) throws IOException {
        DSASigner.stdDSA stddsa = this.configure;
        return stddsa == null ? bArr : new GMCipherSpi.SM2(stddsa, bArr).init(ASN1Encoding.DER);
    }

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        return null;
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        return null;
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
        byte[] bArr = new byte[this.init.getInstance()];
        this.init.configure(bArr, 0);
        try {
            byte[] configure2 = configure(bArr);
            return this.cca_continue.Cardinal(configure2, 0, configure2.length);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new SignatureException("key too small for signature type");
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.init.Cardinal(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.init.init(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.init.getInstance()];
        this.init.configure(bArr2, 0);
        try {
            byte[] Cardinal = this.cca_continue.Cardinal(bArr, 0, bArr.length);
            byte[] configure2 = configure(bArr2);
            if (Cardinal.length == configure2.length) {
                return setForegroundTintBlendMode.init(Cardinal, configure2);
            }
            if (Cardinal.length == configure2.length - 2) {
                configure2[1] = (byte) (configure2[1] - 2);
                configure2[3] = (byte) (configure2[3] - 2);
                int i = configure2[3] + 4;
                int i2 = i + 2;
                byte b = 0;
                for (int i3 = 0; i3 < configure2.length - i2; i3++) {
                    b |= Cardinal[i + i3] ^ configure2[i2 + i3];
                }
                for (int i4 = 0; i4 < i; i4++) {
                    b |= Cardinal[i4] ^ configure2[i4];
                }
                if (b == 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static class MD5 extends DigestSignatureSpi {
        public MD5() {
            super(KeyFactorySpi.getChallengeTimeout, new SignatureSpi.ecDetDSA512(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class SHA1 extends DigestSignatureSpi {
        public SHA1() {
            super(KeyAgreementSpi.MQVwithSHA512KDF.CardinalError, new SignatureSpi.ecNR224(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class SHA224 extends DigestSignatureSpi {
        public SHA224() {
            super(KeyAgreementSpi.MQVwithSHA224KDF.getSDKVersion, new SignatureSpi.ecNR256(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class SHA256 extends DigestSignatureSpi {
        public SHA256() {
            super(KeyAgreementSpi.MQVwithSHA224KDF.Cardinal, new SignatureSpi.ecNR(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class SHA384 extends DigestSignatureSpi {
        public SHA384() {
            super(KeyAgreementSpi.MQVwithSHA224KDF.configure, new SignatureSpi.ecNR384(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class SHA3_224 extends DigestSignatureSpi {
        public SHA3_224() {
            super(KeyAgreementSpi.MQVwithSHA224KDF.cleanup, new KeyAgreementSpi.ECVKO(224), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class SHA3_256 extends DigestSignatureSpi {
        public SHA3_256() {
            super(KeyAgreementSpi.MQVwithSHA224KDF.getWarnings, new KeyAgreementSpi.ECVKO(256), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class SHA3_384 extends DigestSignatureSpi {
        public SHA3_384() {
            super(KeyAgreementSpi.MQVwithSHA224KDF.CardinalActionCode, new KeyAgreementSpi.ECVKO(384), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class SHA3_512 extends DigestSignatureSpi {
        public SHA3_512() {
            super(KeyAgreementSpi.MQVwithSHA224KDF.CardinalUiType, new KeyAgreementSpi.ECVKO(512), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class SHA512 extends DigestSignatureSpi {
        public SHA512() {
            super(KeyAgreementSpi.MQVwithSHA224KDF.getInstance, new BCECGOST3410PrivateKey(), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class SHA512_224 extends DigestSignatureSpi {
        public SHA512_224() {
            super(KeyAgreementSpi.MQVwithSHA224KDF.values, new SignatureSpi.ecPlainDSARP160(224), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class SHA512_256 extends DigestSignatureSpi {
        public SHA512_256() {
            super(KeyAgreementSpi.MQVwithSHA224KDF.CardinalError, new SignatureSpi.ecPlainDSARP160(256), new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof RSAPublicKey)) {
            StringBuilder sb = new StringBuilder("Supplied key (");
            sb.append(publicKey == null ? null : publicKey.getClass().getName());
            sb.append(") is not a RSAPublicKey instance");
            throw new InvalidKeyException(sb.toString());
        }
        ISOSignatureSpi.WhirlpoolWithRSAEncryption a = RSAUtil.m2203a((RSAPublicKey) publicKey);
        this.init.cca_continue();
        this.cca_continue.Cardinal(false, a);
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof RSAPrivateKey)) {
            StringBuilder sb = new StringBuilder("Supplied key (");
            sb.append(privateKey == null ? null : privateKey.getClass().getName());
            sb.append(") is not a RSAPrivateKey instance");
            throw new InvalidKeyException(sb.toString());
        }
        ISOSignatureSpi.WhirlpoolWithRSAEncryption a = RSAUtil.m2202a((RSAPrivateKey) privateKey);
        this.init.cca_continue();
        this.cca_continue.Cardinal(true, a);
    }
}

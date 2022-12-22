package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import com.cardinalcommerce.p060a.ECDSAVerifier;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.JWSVerifier;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.RSAEncrypter;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.X931SignatureSpi;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;

public class SignatureSpi extends java.security.SignatureSpi implements IESCipher.ECIESwithDESedeCBC, KeyFactorySpi {

    /* renamed from: a */
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo f3178a = new SignatureSpi.ecDSASha3_384();

    /* renamed from: b */
    private KeyFactorySpi.C1979EC f3179b = new X931SignatureSpi.SHA1WithRSAEncryption();

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        setKeyboardNavigationCluster instance = privateKey instanceof JWSVerifier ? ECUtil.getInstance(privateKey) : GOST3410Util.init(privateKey);
        this.f3178a.cca_continue();
        if (this.appRandom != null) {
            this.f3179b.getInstance(true, new ISOSignatureSpi.SHA224WithRSAEncryption(instance, this.appRandom));
        } else {
            this.f3179b.getInstance(true, instance);
        }
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
        byte[] bArr = new byte[this.f3178a.getInstance()];
        this.f3178a.configure(bArr, 0);
        try {
            byte[] bArr2 = new byte[64];
            BigInteger[] configure = this.f3179b.configure(bArr);
            byte[] byteArray = configure[0].toByteArray();
            byte[] byteArray2 = configure[1].toByteArray();
            if (byteArray2[0] != 0) {
                System.arraycopy(byteArray2, 0, bArr2, 32 - byteArray2.length, byteArray2.length);
            } else {
                System.arraycopy(byteArray2, 1, bArr2, 32 - (byteArray2.length - 1), byteArray2.length - 1);
            }
            if (byteArray[0] != 0) {
                System.arraycopy(byteArray, 0, bArr2, 64 - byteArray.length, byteArray.length);
            } else {
                System.arraycopy(byteArray, 1, bArr2, 64 - (byteArray.length - 1), byteArray.length - 1);
            }
            return bArr2;
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.f3178a.Cardinal(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f3178a.init(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f3178a.getInstance()];
        this.f3178a.configure(bArr2, 0);
        try {
            byte[] bArr3 = new byte[32];
            byte[] bArr4 = new byte[32];
            System.arraycopy(bArr, 0, bArr4, 0, 32);
            System.arraycopy(bArr, 32, bArr3, 0, 32);
            BigInteger[] bigIntegerArr = {new BigInteger(1, bArr3), new BigInteger(1, bArr4)};
            return this.f3179b.init(bArr2, bigIntegerArr[0], bigIntegerArr[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF;
        if (publicKey instanceof ECDSAVerifier) {
            eCKAEGwithSHA512KDF = publicKey instanceof BCECGOST3410PublicKey ? ((BCECGOST3410PublicKey) publicKey).Cardinal : ECUtil.Cardinal(publicKey);
        } else if (publicKey instanceof RSAEncrypter) {
            eCKAEGwithSHA512KDF = GOST3410Util.cca_continue(publicKey);
        } else {
            try {
                eCKAEGwithSHA512KDF = ECUtil.Cardinal(JWK.getInstance(SubjectPublicKeyInfo.init(publicKey.getEncoded())));
            } catch (Exception unused) {
                throw new InvalidKeyException("can't recognise key type in DSA based signer");
            }
        }
        this.f3178a.cca_continue();
        this.f3179b.getInstance(false, eCKAEGwithSHA512KDF);
    }
}

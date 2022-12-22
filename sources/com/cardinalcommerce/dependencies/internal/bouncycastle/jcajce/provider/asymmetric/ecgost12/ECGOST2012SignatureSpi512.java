package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ECDSAVerifier;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.JWSVerifier;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.X931SignatureSpi;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;

public class ECGOST2012SignatureSpi512 extends SignatureSpi implements IESCipher.ECIESwithDESedeCBC, KeyFactorySpi {

    /* renamed from: a */
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo f3184a = new SignatureSpi.ecDetDSA256();

    /* renamed from: b */
    private KeyFactorySpi.C1979EC f3185b = new X931SignatureSpi.SHA256WithRSAEncryption();

    /* renamed from: c */
    private int f3186c = 128;

    /* renamed from: d */
    private int f3187d = 64;

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
        byte[] bArr = new byte[this.f3184a.getInstance()];
        this.f3184a.configure(bArr, 0);
        try {
            byte[] bArr2 = new byte[this.f3186c];
            BigInteger[] configure = this.f3185b.configure(bArr);
            byte[] byteArray = configure[0].toByteArray();
            byte[] byteArray2 = configure[1].toByteArray();
            if (byteArray2[0] != 0) {
                System.arraycopy(byteArray2, 0, bArr2, this.f3187d - byteArray2.length, byteArray2.length);
            } else {
                System.arraycopy(byteArray2, 1, bArr2, this.f3187d - (byteArray2.length - 1), byteArray2.length - 1);
            }
            if (byteArray[0] != 0) {
                System.arraycopy(byteArray, 0, bArr2, this.f3186c - byteArray.length, byteArray.length);
            } else {
                System.arraycopy(byteArray, 1, bArr2, this.f3186c - (byteArray.length - 1), byteArray.length - 1);
            }
            return bArr2;
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.f3184a.Cardinal(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f3184a.init(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f3184a.getInstance()];
        this.f3184a.configure(bArr2, 0);
        try {
            byte[] bArr3 = new byte[this.f3187d];
            byte[] bArr4 = new byte[this.f3187d];
            System.arraycopy(bArr, 0, bArr4, 0, this.f3187d);
            System.arraycopy(bArr, this.f3187d, bArr3, 0, this.f3187d);
            BigInteger[] bigIntegerArr = {new BigInteger(1, bArr3), new BigInteger(1, bArr4)};
            return this.f3185b.init(bArr2, bigIntegerArr[0], bigIntegerArr[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        DigestSignatureSpi.MD4 md4;
        Object obj;
        if (publicKey instanceof ECDSAVerifier) {
            if (publicKey instanceof BCECGOST3410_2012PublicKey) {
                obj = ((BCECGOST3410_2012PublicKey) publicKey).init;
            } else {
                obj = ECUtil.Cardinal(publicKey);
            }
            md4 = (DigestSignatureSpi.MD4) obj;
        } else {
            try {
                md4 = (DigestSignatureSpi.MD4) ECUtil.Cardinal(JWK.getInstance(SubjectPublicKeyInfo.init(publicKey.getEncoded())));
            } catch (Exception unused) {
                throw new InvalidKeyException("cannot recognise key type in ECGOST-2012-512 signer");
            }
        }
        if (md4.init.cca_continue.bitLength() >= 505) {
            this.f3184a.cca_continue();
            this.f3185b.getInstance(false, md4);
            return;
        }
        throw new InvalidKeyException("key too weak for ECGOST-2012-512");
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof JWSVerifier) {
            DigestSignatureSpi.MD4 md4 = (DigestSignatureSpi.MD4) ECUtil.getInstance(privateKey);
            if (md4.init.cca_continue.bitLength() >= 505) {
                this.f3184a.cca_continue();
                if (this.appRandom != null) {
                    this.f3185b.getInstance(true, new ISOSignatureSpi.SHA224WithRSAEncryption(md4, this.appRandom));
                } else {
                    this.f3185b.getInstance(true, md4);
                }
            } else {
                throw new InvalidKeyException("key too weak for ECGOST-2012-512");
            }
        } else {
            throw new InvalidKeyException("cannot recognise key type in ECGOST-2012-512 signer");
        }
    }
}

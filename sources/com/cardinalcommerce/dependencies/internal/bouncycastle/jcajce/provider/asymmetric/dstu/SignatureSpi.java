package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.EdEC;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.google.common.base.Ascii;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;

public class SignatureSpi extends java.security.SignatureSpi implements IESCipher.ECIESwithDESedeCBC, KeyFactorySpi {

    /* renamed from: a */
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo f3169a;

    /* renamed from: b */
    private KeyFactorySpi.C1979EC f3170b = new PSSSignatureSpi.nonePSS();

    /* renamed from: a */
    private static byte[] m2193a(byte[] bArr) {
        byte[] bArr2 = new byte[128];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i << 1;
            bArr2[i2] = (byte) ((bArr[i] >> 4) & 15);
            bArr2[i2 + 1] = (byte) (bArr[i] & Ascii.f53593SI);
        }
        return bArr2;
    }

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineInitSign(java.security.PrivateKey r5) throws java.security.InvalidKeyException {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey
            if (r0 == 0) goto L_0x0018
            com.cardinalcommerce.a.setKeyboardNavigationCluster r5 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getInstance((java.security.PrivateKey) r5)
            com.cardinalcommerce.a.SignatureSpi$ecDSASha3_384 r0 = new com.cardinalcommerce.a.SignatureSpi$ecDSASha3_384
            byte[] r1 = com.cardinalcommerce.p060a.DSASigner.dsa224.cca_continue()
            byte[] r1 = m2193a(r1)
            r0.<init>((byte[]) r1)
        L_0x0015:
            r4.f3169a = r0
            goto L_0x002f
        L_0x0018:
            boolean r0 = r5 instanceof com.cardinalcommerce.p060a.JWSVerifier
            if (r0 == 0) goto L_0x002e
            com.cardinalcommerce.a.setKeyboardNavigationCluster r5 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getInstance((java.security.PrivateKey) r5)
            com.cardinalcommerce.a.SignatureSpi$ecDSASha3_384 r0 = new com.cardinalcommerce.a.SignatureSpi$ecDSASha3_384
            byte[] r1 = com.cardinalcommerce.p060a.DSASigner.dsa224.cca_continue()
            byte[] r1 = m2193a(r1)
            r0.<init>((byte[]) r1)
            goto L_0x0015
        L_0x002e:
            r5 = 0
        L_0x002f:
            java.security.SecureRandom r0 = r4.appRandom
            r1 = 1
            if (r0 == 0) goto L_0x0041
            com.cardinalcommerce.a.KeyFactorySpi$EC r0 = r4.f3170b
            com.cardinalcommerce.a.ISOSignatureSpi$SHA224WithRSAEncryption r2 = new com.cardinalcommerce.a.ISOSignatureSpi$SHA224WithRSAEncryption
            java.security.SecureRandom r3 = r4.appRandom
            r2.<init>(r5, r3)
            r0.getInstance(r1, r2)
            return
        L_0x0041:
            com.cardinalcommerce.a.KeyFactorySpi$EC r0 = r4.f3170b
            r0.getInstance(r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpi.engineInitSign(java.security.PrivateKey):void");
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
        byte[] bArr = new byte[this.f3169a.getInstance()];
        this.f3169a.configure(bArr, 0);
        try {
            BigInteger[] configure = this.f3170b.configure(bArr);
            byte[] byteArray = configure[0].toByteArray();
            byte[] byteArray2 = configure[1].toByteArray();
            int length = (byteArray.length > byteArray2.length ? byteArray.length : byteArray2.length) << 1;
            byte[] bArr2 = new byte[length];
            System.arraycopy(byteArray2, 0, bArr2, (length / 2) - byteArray2.length, byteArray2.length);
            System.arraycopy(byteArray, 0, bArr2, length - byteArray.length, byteArray.length);
            return new EdEC(bArr2).getEncoded();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.f3169a.Cardinal(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f3169a.init(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f3169a.getInstance()];
        this.f3169a.configure(bArr2, 0);
        try {
            byte[] cca_continue = ((isEnableDFSync) isEnableDFSync.getInstance(bArr)).cca_continue();
            byte[] bArr3 = new byte[(cca_continue.length / 2)];
            byte[] bArr4 = new byte[(cca_continue.length / 2)];
            System.arraycopy(cca_continue, 0, bArr4, 0, cca_continue.length / 2);
            System.arraycopy(cca_continue, cca_continue.length / 2, bArr3, 0, cca_continue.length / 2);
            BigInteger[] bigIntegerArr = {new BigInteger(1, bArr3), new BigInteger(1, bArr4)};
            return this.f3170b.init(bArr2, bigIntegerArr[0], bigIntegerArr[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF;
        if (publicKey instanceof BCDSTU4145PublicKey) {
            BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) publicKey;
            eCKAEGwithSHA512KDF = bCDSTU4145PublicKey.cca_continue;
            this.f3169a = new SignatureSpi.ecDSASha3_384(m2193a(bCDSTU4145PublicKey.init()));
        } else {
            eCKAEGwithSHA512KDF = ECUtil.Cardinal(publicKey);
            this.f3169a = new SignatureSpi.ecDSASha3_384(m2193a(DSASigner.dsa224.cca_continue()));
        }
        this.f3170b.getInstance(false, eCKAEGwithSHA512KDF);
    }
}

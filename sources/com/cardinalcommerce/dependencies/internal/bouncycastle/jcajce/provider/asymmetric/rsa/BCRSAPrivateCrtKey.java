package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.cardinalcommerce.p060a.setAnimation;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;

public class BCRSAPrivateCrtKey extends BCRSAPrivateKey implements RSAPrivateCrtKey {
    private BigInteger Cardinal;
    private BigInteger cca_continue;
    private BigInteger cleanup;
    private BigInteger getInstance;
    private BigInteger getSDKVersion;
    private BigInteger values;

    BCRSAPrivateCrtKey(RSAPrivateCrtKey rSAPrivateCrtKey) {
        this.configure = rSAPrivateCrtKey.getModulus();
        this.Cardinal = rSAPrivateCrtKey.getPublicExponent();
        this.init = rSAPrivateCrtKey.getPrivateExponent();
        this.cca_continue = rSAPrivateCrtKey.getPrimeP();
        this.getInstance = rSAPrivateCrtKey.getPrimeQ();
        this.values = rSAPrivateCrtKey.getPrimeExponentP();
        this.getSDKVersion = rSAPrivateCrtKey.getPrimeExponentQ();
        this.cleanup = rSAPrivateCrtKey.getCrtCoefficient();
    }

    BCRSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) {
        this.configure = rSAPrivateCrtKeySpec.getModulus();
        this.Cardinal = rSAPrivateCrtKeySpec.getPublicExponent();
        this.init = rSAPrivateCrtKeySpec.getPrivateExponent();
        this.cca_continue = rSAPrivateCrtKeySpec.getPrimeP();
        this.getInstance = rSAPrivateCrtKeySpec.getPrimeQ();
        this.values = rSAPrivateCrtKeySpec.getPrimeExponentP();
        this.getSDKVersion = rSAPrivateCrtKeySpec.getPrimeExponentQ();
        this.cleanup = rSAPrivateCrtKeySpec.getCrtCoefficient();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPrivateCrtKey)) {
            return false;
        }
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) obj;
        return getModulus().equals(rSAPrivateCrtKey.getModulus()) && getPublicExponent().equals(rSAPrivateCrtKey.getPublicExponent()) && getPrivateExponent().equals(rSAPrivateCrtKey.getPrivateExponent()) && getPrimeP().equals(rSAPrivateCrtKey.getPrimeP()) && getPrimeQ().equals(rSAPrivateCrtKey.getPrimeQ()) && getPrimeExponentP().equals(rSAPrivateCrtKey.getPrimeExponentP()) && getPrimeExponentQ().equals(rSAPrivateCrtKey.getPrimeExponentQ()) && getCrtCoefficient().equals(rSAPrivateCrtKey.getCrtCoefficient());
    }

    public BigInteger getCrtCoefficient() {
        return this.cleanup;
    }

    public byte[] getEncoded() {
        return KeyUtil.Cardinal(new DSASigner.stdDSA(KeyFactorySpi.configure, ECGOST.Mappings.Cardinal), new DSASigner(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public BigInteger getPrimeExponentP() {
        return this.values;
    }

    public BigInteger getPrimeExponentQ() {
        return this.getSDKVersion;
    }

    public BigInteger getPrimeP() {
        return this.cca_continue;
    }

    public BigInteger getPrimeQ() {
        return this.getInstance;
    }

    public BigInteger getPublicExponent() {
        return this.Cardinal;
    }

    public int hashCode() {
        return (getModulus().hashCode() ^ getPublicExponent().hashCode()) ^ getPrivateExponent().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        stringBuffer.append("RSA Private CRT Key [");
        stringBuffer.append(RSAUtil.m2204a(getModulus()));
        stringBuffer.append("],[");
        stringBuffer.append(RSAUtil.m2205b(getPublicExponent()));
        stringBuffer.append(Const.jaRight);
        stringBuffer.append(instance);
        stringBuffer.append("             modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(instance);
        stringBuffer.append("     public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(instance);
        return stringBuffer.toString();
    }

    BCRSAPrivateCrtKey(PSSSignatureSpi.SHA224withRSA sHA224withRSA) {
        super((ISOSignatureSpi.WhirlpoolWithRSAEncryption) sHA224withRSA);
        this.Cardinal = sHA224withRSA.getInstance;
        this.cca_continue = sHA224withRSA.cca_continue;
        this.getInstance = sHA224withRSA.init;
        this.values = sHA224withRSA.values;
        this.getSDKVersion = sHA224withRSA.CardinalError;
        this.cleanup = sHA224withRSA.getSDKVersion;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    BCRSAPrivateCrtKey(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r2) throws java.io.IOException {
        /*
            r1 = this;
            com.cardinalcommerce.a.isEnableDFSync r2 = r2.init
            byte[] r2 = r2.cca_continue()
            com.cardinalcommerce.a.setLocationDataConsentGiven r2 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r2)
            if (r2 == 0) goto L_0x0016
            com.cardinalcommerce.a.DSASigner r0 = new com.cardinalcommerce.a.DSASigner
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r2 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r2)
            r0.<init>(r2)
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            r1.<init>((com.cardinalcommerce.p060a.DSASigner) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateCrtKey.<init>(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo):void");
    }

    BCRSAPrivateCrtKey(DSASigner dSASigner) {
        this.configure = dSASigner.cca_continue;
        this.Cardinal = dSASigner.configure;
        this.init = dSASigner.getInstance;
        this.cca_continue = dSASigner.init;
        this.getInstance = dSASigner.Cardinal;
        this.values = dSASigner.cleanup;
        this.getSDKVersion = dSASigner.values;
        this.cleanup = dSASigner.CardinalError;
    }
}

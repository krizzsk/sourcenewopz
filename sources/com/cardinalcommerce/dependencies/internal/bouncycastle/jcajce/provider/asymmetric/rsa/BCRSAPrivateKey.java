package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.setAnimation;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;

public class BCRSAPrivateKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF, RSAPrivateKey {
    private static BigInteger getInstance = BigInteger.valueOf(0);
    protected BigInteger configure;
    protected BigInteger init;

    protected BCRSAPrivateKey() {
        new PKCS12BagAttributeCarrierImpl();
    }

    BCRSAPrivateKey(RSAPrivateKey rSAPrivateKey) {
        new PKCS12BagAttributeCarrierImpl();
        this.configure = rSAPrivateKey.getModulus();
        this.init = rSAPrivateKey.getPrivateExponent();
    }

    BCRSAPrivateKey(RSAPrivateKeySpec rSAPrivateKeySpec) {
        new PKCS12BagAttributeCarrierImpl();
        this.configure = rSAPrivateKeySpec.getModulus();
        this.init = rSAPrivateKeySpec.getPrivateExponent();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RSAPrivateKey)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) obj;
        return getModulus().equals(rSAPrivateKey.getModulus()) && getPrivateExponent().equals(rSAPrivateKey.getPrivateExponent());
    }

    public String getAlgorithm() {
        return "RSA";
    }

    public byte[] getEncoded() {
        DSASigner.stdDSA stddsa = new DSASigner.stdDSA(KeyFactorySpi.configure, ECGOST.Mappings.Cardinal);
        BigInteger modulus = getModulus();
        BigInteger bigInteger = getInstance;
        BigInteger privateExponent = getPrivateExponent();
        BigInteger bigInteger2 = getInstance;
        return KeyUtil.Cardinal(stddsa, new DSASigner(modulus, bigInteger, privateExponent, bigInteger2, bigInteger2, bigInteger2, bigInteger2, bigInteger2));
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public BigInteger getModulus() {
        return this.configure;
    }

    public BigInteger getPrivateExponent() {
        return this.init;
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPrivateExponent().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        stringBuffer.append("RSA Private Key [");
        stringBuffer.append(RSAUtil.m2204a(getModulus()));
        stringBuffer.append("],[]");
        stringBuffer.append(instance);
        stringBuffer.append("            modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(instance);
        return stringBuffer.toString();
    }

    BCRSAPrivateKey(ISOSignatureSpi.WhirlpoolWithRSAEncryption whirlpoolWithRSAEncryption) {
        new PKCS12BagAttributeCarrierImpl();
        this.configure = whirlpoolWithRSAEncryption.configure;
        this.init = whirlpoolWithRSAEncryption.Cardinal;
    }

    BCRSAPrivateKey(DSASigner dSASigner) {
        new PKCS12BagAttributeCarrierImpl();
        this.configure = dSASigner.cca_continue;
        this.init = dSASigner.getInstance;
    }
}

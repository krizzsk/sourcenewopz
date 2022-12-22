package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.cardinalcommerce.p060a.BCDSAPublicKey;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.setAnimation;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public class BCRSAPublicKey implements RSAPublicKey {
    private static final DSASigner.stdDSA cca_continue = new DSASigner.stdDSA(KeyFactorySpi.configure, ECGOST.Mappings.Cardinal);
    private BigInteger configure;
    private BigInteger getInstance;
    private transient DSASigner.stdDSA init;

    BCRSAPublicKey(RSAPublicKey rSAPublicKey) {
        this.init = cca_continue;
        this.getInstance = rSAPublicKey.getModulus();
        this.configure = rSAPublicKey.getPublicExponent();
    }

    BCRSAPublicKey(RSAPublicKeySpec rSAPublicKeySpec) {
        this.init = cca_continue;
        this.getInstance = rSAPublicKeySpec.getModulus();
        this.configure = rSAPublicKeySpec.getPublicExponent();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (!this.init.equals(cca_continue)) {
            objectOutputStream.writeObject(this.init.getEncoded());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPublicKey)) {
            return false;
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) obj;
        return getModulus().equals(rSAPublicKey.getModulus()) && getPublicExponent().equals(rSAPublicKey.getPublicExponent());
    }

    public String getAlgorithm() {
        return "RSA";
    }

    public byte[] getEncoded() {
        return KeyUtil.getInstance(this.init, new BCDSAPublicKey(getModulus(), getPublicExponent()));
    }

    public String getFormat() {
        return "X.509";
    }

    public BigInteger getModulus() {
        return this.getInstance;
    }

    public BigInteger getPublicExponent() {
        return this.configure;
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPublicExponent().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        stringBuffer.append("RSA Public Key [");
        stringBuffer.append(RSAUtil.m2204a(getModulus()));
        stringBuffer.append("],[");
        stringBuffer.append(RSAUtil.m2205b(getPublicExponent()));
        stringBuffer.append(Const.jaRight);
        stringBuffer.append(instance);
        stringBuffer.append("        modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(instance);
        stringBuffer.append("public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(instance);
        return stringBuffer.toString();
    }

    BCRSAPublicKey(ISOSignatureSpi.WhirlpoolWithRSAEncryption whirlpoolWithRSAEncryption) {
        this.init = cca_continue;
        this.getInstance = whirlpoolWithRSAEncryption.configure;
        this.configure = whirlpoolWithRSAEncryption.Cardinal;
    }

    BCRSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(subjectPublicKeyInfo.getInstance.cca_continue());
            BCDSAPublicKey bCDSAPublicKey = instance != null ? new BCDSAPublicKey(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
            this.init = subjectPublicKeyInfo.init;
            this.getInstance = bCDSAPublicKey.getInstance;
            this.configure = bCDSAPublicKey.cca_continue;
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in RSA public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        try {
            Object readObject = objectInputStream.readObject();
            this.init = readObject instanceof DSASigner.stdDSA ? (DSASigner.stdDSA) readObject : readObject != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue(readObject)) : null;
        } catch (Exception unused) {
            this.init = cca_continue;
        }
    }
}

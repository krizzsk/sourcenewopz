package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.cardinalcommerce.p060a.AlgorithmParametersSpi;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.GMCipherSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.setAnimation;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setProxyAddress;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;

public class BCDSAPrivateKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF, DSAPrivateKey {
    private BigInteger cca_continue;
    private transient DSAParams configure;

    protected BCDSAPrivateKey() {
        new PKCS12BagAttributeCarrierImpl();
    }

    BCDSAPrivateKey(DSAPrivateKey dSAPrivateKey) {
        new PKCS12BagAttributeCarrierImpl();
        this.cca_continue = dSAPrivateKey.getX();
        this.configure = dSAPrivateKey.getParams();
    }

    BCDSAPrivateKey(DSAPrivateKeySpec dSAPrivateKeySpec) {
        new PKCS12BagAttributeCarrierImpl();
        this.cca_continue = dSAPrivateKeySpec.getX();
        this.configure = new DSAParameterSpec(dSAPrivateKeySpec.getP(), dSAPrivateKeySpec.getQ(), dSAPrivateKeySpec.getG());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.configure = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.configure.getP());
        objectOutputStream.writeObject(this.configure.getQ());
        objectOutputStream.writeObject(this.configure.getG());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAPrivateKey)) {
            return false;
        }
        DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) obj;
        return getX().equals(dSAPrivateKey.getX()) && getParams().getG().equals(dSAPrivateKey.getParams().getG()) && getParams().getP().equals(dSAPrivateKey.getParams().getP()) && getParams().getQ().equals(dSAPrivateKey.getParams().getQ());
    }

    public String getAlgorithm() {
        return "DSA";
    }

    public byte[] getEncoded() {
        return KeyUtil.Cardinal(new DSASigner.stdDSA(KeyAgreementSpi.ECKAEGwithSHA1KDF.Payment, new GMCipherSpi.SM2withBlake2s(this.configure.getP(), this.configure.getQ(), this.configure.getG()).values()), new setProxyAddress(getX()));
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public DSAParams getParams() {
        return this.configure;
    }

    public BigInteger getX() {
        return this.cca_continue;
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        BigInteger modPow = getParams().getG().modPow(this.cca_continue, getParams().getP());
        stringBuffer.append("DSA Private Key [");
        stringBuffer.append(DSAUtil.m2192a(modPow, getParams()));
        stringBuffer.append(Const.jaRight);
        stringBuffer.append(instance);
        stringBuffer.append("            Y: ");
        stringBuffer.append(modPow.toString(16));
        stringBuffer.append(instance);
        return stringBuffer.toString();
    }

    public BCDSAPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        new PKCS12BagAttributeCarrierImpl();
        getProxyAddress getproxyaddress = privateKeyInfo.cca_continue.cca_continue;
        GMCipherSpi.SM2withBlake2s sM2withBlake2s = getproxyaddress instanceof GMCipherSpi.SM2withBlake2s ? (GMCipherSpi.SM2withBlake2s) getproxyaddress : getproxyaddress != null ? new GMCipherSpi.SM2withBlake2s(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null;
        this.cca_continue = new BigInteger(((setProxyAddress) setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue())).Cardinal);
        this.configure = new DSAParameterSpec(new BigInteger(1, sM2withBlake2s.configure.Cardinal), new BigInteger(1, sM2withBlake2s.cca_continue.Cardinal), new BigInteger(1, sM2withBlake2s.init.Cardinal));
    }

    BCDSAPrivateKey(AlgorithmParametersSpi.PSS pss) {
        new PKCS12BagAttributeCarrierImpl();
        this.cca_continue = pss.init;
        this.configure = new DSAParameterSpec(pss.Cardinal.init, pss.Cardinal.getInstance, pss.Cardinal.cca_continue);
    }
}

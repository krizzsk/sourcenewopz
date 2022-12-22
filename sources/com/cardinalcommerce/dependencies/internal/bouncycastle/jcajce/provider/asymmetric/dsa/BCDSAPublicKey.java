package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.cardinalcommerce.p060a.BCGOST3410PrivateKey;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
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
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;

public class BCDSAPublicKey implements DSAPublicKey {
    private static BigInteger init = BigInteger.valueOf(0);
    private transient DSAParams Cardinal;
    transient BCGOST3410PrivateKey configure;
    private BigInteger getInstance;

    BCDSAPublicKey(DSAPublicKey dSAPublicKey) {
        this.getInstance = dSAPublicKey.getY();
        DSAParams params = dSAPublicKey.getParams();
        this.Cardinal = params;
        this.configure = new BCGOST3410PrivateKey(this.getInstance, DSAUtil.m2191a(params));
    }

    BCDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) {
        this.getInstance = dSAPublicKeySpec.getY();
        DSAParameterSpec dSAParameterSpec = new DSAParameterSpec(dSAPublicKeySpec.getP(), dSAPublicKeySpec.getQ(), dSAPublicKeySpec.getG());
        this.Cardinal = dSAParameterSpec;
        this.configure = new BCGOST3410PrivateKey(this.getInstance, DSAUtil.m2191a(dSAParameterSpec));
    }

    private static boolean getInstance(getProxyAddress getproxyaddress) {
        return getproxyaddress != null && !ECGOST.Mappings.Cardinal.equals(getproxyaddress.values());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        BigInteger bigInteger = (BigInteger) objectInputStream.readObject();
        if (bigInteger.equals(init)) {
            this.Cardinal = null;
        } else {
            this.Cardinal = new DSAParameterSpec(bigInteger, (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        }
        this.configure = new BCGOST3410PrivateKey(this.getInstance, DSAUtil.m2191a(this.Cardinal));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        BigInteger g;
        objectOutputStream.defaultWriteObject();
        DSAParams dSAParams = this.Cardinal;
        if (dSAParams == null) {
            g = init;
        } else {
            objectOutputStream.writeObject(dSAParams.getP());
            objectOutputStream.writeObject(this.Cardinal.getQ());
            g = this.Cardinal.getG();
        }
        objectOutputStream.writeObject(g);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAPublicKey)) {
            return false;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
        return this.Cardinal != null ? getY().equals(dSAPublicKey.getY()) && dSAPublicKey.getParams() != null && getParams().getG().equals(dSAPublicKey.getParams().getG()) && getParams().getP().equals(dSAPublicKey.getParams().getP()) && getParams().getQ().equals(dSAPublicKey.getParams().getQ()) : getY().equals(dSAPublicKey.getY()) && dSAPublicKey.getParams() == null;
    }

    public String getAlgorithm() {
        return "DSA";
    }

    public byte[] getEncoded() {
        DSASigner.stdDSA stddsa;
        setProxyAddress setproxyaddress;
        if (this.Cardinal == null) {
            stddsa = new DSASigner.stdDSA(KeyAgreementSpi.ECKAEGwithSHA1KDF.Payment);
            setproxyaddress = new setProxyAddress(this.getInstance);
        } else {
            stddsa = new DSASigner.stdDSA(KeyAgreementSpi.ECKAEGwithSHA1KDF.Payment, new GMCipherSpi.SM2withBlake2s(this.Cardinal.getP(), this.Cardinal.getQ(), this.Cardinal.getG()).values());
            setproxyaddress = new setProxyAddress(this.getInstance);
        }
        return KeyUtil.getInstance(stddsa, setproxyaddress);
    }

    public String getFormat() {
        return "X.509";
    }

    public DSAParams getParams() {
        return this.Cardinal;
    }

    public BigInteger getY() {
        return this.getInstance;
    }

    public int hashCode() {
        return this.Cardinal != null ? ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode() : getY().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        stringBuffer.append("DSA Public Key [");
        stringBuffer.append(DSAUtil.m2192a(this.getInstance, getParams()));
        stringBuffer.append(Const.jaRight);
        stringBuffer.append(instance);
        stringBuffer.append("            Y: ");
        stringBuffer.append(getY().toString(16));
        stringBuffer.append(instance);
        return stringBuffer.toString();
    }

    BCDSAPublicKey(BCGOST3410PrivateKey bCGOST3410PrivateKey) {
        this.getInstance = bCGOST3410PrivateKey.cca_continue;
        this.Cardinal = bCGOST3410PrivateKey != null ? new DSAParameterSpec(bCGOST3410PrivateKey.Cardinal.init, bCGOST3410PrivateKey.Cardinal.getInstance, bCGOST3410PrivateKey.Cardinal.cca_continue) : null;
        this.configure = bCGOST3410PrivateKey;
    }

    public BCDSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            this.getInstance = new BigInteger(((setProxyAddress) setLocationDataConsentGiven.getInstance(subjectPublicKeyInfo.getInstance.cca_continue())).Cardinal);
            GMCipherSpi.SM2withBlake2s sM2withBlake2s = null;
            if (getInstance(subjectPublicKeyInfo.init.cca_continue)) {
                getProxyAddress getproxyaddress = subjectPublicKeyInfo.init.cca_continue;
                if (getproxyaddress instanceof GMCipherSpi.SM2withBlake2s) {
                    sM2withBlake2s = (GMCipherSpi.SM2withBlake2s) getproxyaddress;
                } else if (getproxyaddress != null) {
                    sM2withBlake2s = new GMCipherSpi.SM2withBlake2s(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress));
                }
                this.Cardinal = new DSAParameterSpec(new BigInteger(1, sM2withBlake2s.configure.Cardinal), new BigInteger(1, sM2withBlake2s.cca_continue.Cardinal), new BigInteger(1, sM2withBlake2s.init.Cardinal));
            } else {
                this.Cardinal = null;
            }
            this.configure = new BCGOST3410PrivateKey(this.getInstance, DSAUtil.m2191a(this.Cardinal));
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }
}

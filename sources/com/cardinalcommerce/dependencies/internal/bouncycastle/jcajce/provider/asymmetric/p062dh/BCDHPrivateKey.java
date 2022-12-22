package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p062dh;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.cardinalcommerce.p060a.BCElGamalPublicKey;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.Sphincs256KeyFactorySpi;
import com.cardinalcommerce.p060a.setActivated;
import com.cardinalcommerce.p060a.setAnimation;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setProxyAddress;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPrivateKey */
public class BCDHPrivateKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF, DHPrivateKey {
    private transient PrivateKeyInfo Cardinal;
    private transient DHParameterSpec cca_continue;
    private transient BCElGamalPublicKey configure;
    private BigInteger init;

    protected BCDHPrivateKey() {
        new PKCS12BagAttributeCarrierImpl();
    }

    BCDHPrivateKey(DHPrivateKey dHPrivateKey) {
        new PKCS12BagAttributeCarrierImpl();
        this.init = dHPrivateKey.getX();
        this.cca_continue = dHPrivateKey.getParams();
    }

    BCDHPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        new PKCS12BagAttributeCarrierImpl();
        this.init = dHPrivateKeySpec.getX();
        this.cca_continue = new DHParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.cca_continue = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.Cardinal = null;
        new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.cca_continue.getP());
        objectOutputStream.writeObject(this.cca_continue.getG());
        objectOutputStream.writeInt(this.cca_continue.getL());
    }

    /* access modifiers changed from: package-private */
    public final BCElGamalPublicKey configure() {
        BCElGamalPublicKey bCElGamalPublicKey = this.configure;
        if (bCElGamalPublicKey != null) {
            return bCElGamalPublicKey;
        }
        DHParameterSpec dHParameterSpec = this.cca_continue;
        return dHParameterSpec instanceof Sphincs256KeyFactorySpi ? new BCElGamalPublicKey(this.init, ((Sphincs256KeyFactorySpi) dHParameterSpec).init()) : new BCElGamalPublicKey(this.init, new CipherSpi(dHParameterSpec.getP(), this.cca_continue.getG(), this.cca_continue.getL()));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHPrivateKey)) {
            return false;
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) obj;
        return getX().equals(dHPrivateKey.getX()) && getParams().getG().equals(dHPrivateKey.getParams().getG()) && getParams().getP().equals(dHPrivateKey.getParams().getP()) && getParams().getL() == dHPrivateKey.getParams().getL();
    }

    public String getAlgorithm() {
        return "DH";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public DHParameterSpec getParams() {
        return this.cca_continue;
    }

    public BigInteger getX() {
        return this.init;
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public BCDHPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        new PKCS12BagAttributeCarrierImpl();
        setThreeDSRequestorAppURL cca_continue2 = setThreeDSRequestorAppURL.cca_continue((Object) privateKeyInfo.cca_continue.cca_continue);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.cca_continue.init;
        this.Cardinal = privateKeyInfo;
        this.init = new BigInteger(((setProxyAddress) setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue())).Cardinal);
        BigInteger bigInteger4 = null;
        if (aSN1ObjectIdentifier.equals(KeyFactorySpi.setRequestTimeout)) {
            KeyAgreementSpi.MQVwithSHA384KDF mQVwithSHA384KDF = cca_continue2 != null ? new KeyAgreementSpi.MQVwithSHA384KDF(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue2)) : null;
            if (mQVwithSHA384KDF.Cardinal == null) {
                bigInteger2 = null;
            } else {
                bigInteger2 = new BigInteger(1, mQVwithSHA384KDF.Cardinal.Cardinal);
            }
            if (bigInteger2 != null) {
                BigInteger bigInteger5 = new BigInteger(1, mQVwithSHA384KDF.init.Cardinal);
                BigInteger bigInteger6 = new BigInteger(1, mQVwithSHA384KDF.configure.Cardinal);
                if (mQVwithSHA384KDF.Cardinal == null) {
                    bigInteger3 = null;
                } else {
                    bigInteger3 = new BigInteger(1, mQVwithSHA384KDF.Cardinal.Cardinal);
                }
                this.cca_continue = new DHParameterSpec(bigInteger5, bigInteger6, bigInteger3.intValue());
                this.configure = new BCElGamalPublicKey(this.init, new CipherSpi(new BigInteger(1, mQVwithSHA384KDF.init.Cardinal), new BigInteger(1, mQVwithSHA384KDF.configure.Cardinal), (mQVwithSHA384KDF.Cardinal != null ? new BigInteger(1, mQVwithSHA384KDF.Cardinal.Cardinal) : bigInteger4).intValue()));
                return;
            }
            this.cca_continue = new DHParameterSpec(new BigInteger(1, mQVwithSHA384KDF.init.Cardinal), new BigInteger(1, mQVwithSHA384KDF.configure.Cardinal));
            this.configure = new BCElGamalPublicKey(this.init, new CipherSpi(new BigInteger(1, mQVwithSHA384KDF.init.Cardinal), new BigInteger(1, mQVwithSHA384KDF.configure.Cardinal)));
        } else if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.ECKAEGwithSHA1KDF.onSetupCompleted)) {
            KeyAgreementSpi.CDHwithSHA1KDFAndSharedInfo cDHwithSHA1KDFAndSharedInfo = cca_continue2 != null ? new KeyAgreementSpi.CDHwithSHA1KDFAndSharedInfo(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue2)) : null;
            BigInteger bigInteger7 = new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.Cardinal.Cardinal);
            BigInteger bigInteger8 = new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.getInstance.Cardinal);
            BigInteger bigInteger9 = new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.cca_continue.Cardinal);
            if (cDHwithSHA1KDFAndSharedInfo.init == null) {
                bigInteger = null;
            } else {
                bigInteger = new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.init.Cardinal);
            }
            this.cca_continue = new Sphincs256KeyFactorySpi(bigInteger7, bigInteger8, bigInteger9, bigInteger);
            this.configure = new BCElGamalPublicKey(this.init, new CipherSpi(new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.Cardinal.Cardinal), new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.cca_continue.Cardinal), new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.getInstance.Cardinal), cDHwithSHA1KDFAndSharedInfo.init != null ? new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.init.Cardinal) : bigInteger4, (CipherSpi.NoPadding) null));
        } else {
            throw new IllegalArgumentException("unknown algorithm type: ".concat(String.valueOf(aSN1ObjectIdentifier)));
        }
    }

    BCDHPrivateKey(BCElGamalPublicKey bCElGamalPublicKey) {
        new PKCS12BagAttributeCarrierImpl();
        this.init = bCElGamalPublicKey.Cardinal;
        this.cca_continue = new Sphincs256KeyFactorySpi(bCElGamalPublicKey.configure);
    }

    public byte[] getEncoded() {
        PrivateKeyInfo privateKeyInfo;
        try {
            if (this.Cardinal != null) {
                return this.Cardinal.init(ASN1Encoding.DER);
            }
            if (!(this.cca_continue instanceof Sphincs256KeyFactorySpi) || ((Sphincs256KeyFactorySpi) this.cca_continue).Cardinal == null) {
                privateKeyInfo = new PrivateKeyInfo(new DSASigner.stdDSA(KeyFactorySpi.setRequestTimeout, new KeyAgreementSpi.MQVwithSHA384KDF(this.cca_continue.getP(), this.cca_continue.getG(), this.cca_continue.getL()).values()), new setProxyAddress(getX()));
            } else {
                CipherSpi init2 = ((Sphincs256KeyFactorySpi) this.cca_continue).init();
                CipherSpi.NoPadding noPadding = init2.getWarnings;
                privateKeyInfo = new PrivateKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.ECKAEGwithSHA1KDF.onSetupCompleted, new KeyAgreementSpi.CDHwithSHA1KDFAndSharedInfo(init2.Cardinal, init2.configure, init2.getInstance, init2.cca_continue, noPadding != null ? new KeyAgreementSpi.CDHwithSHA256KDFAndSharedInfo(noPadding.getInstance(), noPadding.configure) : null).values()), new setProxyAddress(getX()));
            }
            return privateKeyInfo.init(ASN1Encoding.DER);
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString() {
        BigInteger bigInteger = this.init;
        CipherSpi cipherSpi = new CipherSpi(this.cca_continue.getP(), this.cca_continue.getG());
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        BigInteger modPow = cipherSpi.configure.modPow(bigInteger, cipherSpi.Cardinal);
        stringBuffer.append("DH");
        stringBuffer.append(" Private Key [");
        stringBuffer.append(new setActivated(setForegroundTintBlendMode.init(modPow.toByteArray(), cipherSpi.Cardinal.toByteArray(), cipherSpi.configure.toByteArray())).toString());
        stringBuffer.append(Const.jaRight);
        stringBuffer.append(instance);
        stringBuffer.append("              Y: ");
        stringBuffer.append(modPow.toString(16));
        stringBuffer.append(instance);
        return stringBuffer.toString();
    }
}

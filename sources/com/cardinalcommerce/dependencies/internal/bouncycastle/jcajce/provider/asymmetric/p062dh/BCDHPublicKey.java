package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p062dh;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
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
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPublicKey */
public class BCDHPublicKey implements DHPublicKey {
    private transient DHParameterSpec Cardinal;
    public transient CipherSpi.PKCS1v1_5Padding cca_continue;
    private BigInteger getInstance;
    private transient SubjectPublicKeyInfo init;

    BCDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.getInstance = bigInteger;
        this.Cardinal = dHParameterSpec;
        this.cca_continue = dHParameterSpec instanceof Sphincs256KeyFactorySpi ? new CipherSpi.PKCS1v1_5Padding(bigInteger, ((Sphincs256KeyFactorySpi) dHParameterSpec).init()) : new CipherSpi.PKCS1v1_5Padding(bigInteger, new CipherSpi(dHParameterSpec.getP(), dHParameterSpec.getG()));
    }

    BCDHPublicKey(DHPublicKey dHPublicKey) {
        this.getInstance = dHPublicKey.getY();
        DHParameterSpec params = dHPublicKey.getParams();
        this.Cardinal = params;
        this.cca_continue = new CipherSpi.PKCS1v1_5Padding(this.getInstance, new CipherSpi(params.getP(), this.Cardinal.getG()));
    }

    BCDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.getInstance = dHPublicKeySpec.getY();
        this.Cardinal = new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
        this.cca_continue = new CipherSpi.PKCS1v1_5Padding(this.getInstance, new CipherSpi(dHPublicKeySpec.getP(), dHPublicKeySpec.getG()));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.Cardinal = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.init = null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.Cardinal.getP());
        objectOutputStream.writeObject(this.Cardinal.getG());
        objectOutputStream.writeInt(this.Cardinal.getL());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        return getY().equals(dHPublicKey.getY()) && getParams().getG().equals(dHPublicKey.getParams().getG()) && getParams().getP().equals(dHPublicKey.getParams().getP()) && getParams().getL() == dHPublicKey.getParams().getL();
    }

    public String getAlgorithm() {
        return "DH";
    }

    public String getFormat() {
        return "X.509";
    }

    public DHParameterSpec getParams() {
        return this.Cardinal;
    }

    public BigInteger getY() {
        return this.getInstance;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    BCDHPublicKey(CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding) {
        this.getInstance = pKCS1v1_5Padding.Cardinal;
        this.Cardinal = new Sphincs256KeyFactorySpi(pKCS1v1_5Padding.configure);
        this.cca_continue = pKCS1v1_5Padding;
    }

    public BCDHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        BigInteger bigInteger;
        this.init = subjectPublicKeyInfo;
        try {
            this.getInstance = new BigInteger(((setProxyAddress) setLocationDataConsentGiven.getInstance(subjectPublicKeyInfo.getInstance.cca_continue())).Cardinal);
            setThreeDSRequestorAppURL cca_continue2 = setThreeDSRequestorAppURL.cca_continue((Object) subjectPublicKeyInfo.init.cca_continue);
            ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.init.init;
            BigInteger bigInteger2 = null;
            if (aSN1ObjectIdentifier.equals(KeyFactorySpi.setRequestTimeout) || configure(cca_continue2)) {
                KeyAgreementSpi.MQVwithSHA384KDF mQVwithSHA384KDF = cca_continue2 != null ? new KeyAgreementSpi.MQVwithSHA384KDF(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue2)) : null;
                if (mQVwithSHA384KDF.Cardinal == null) {
                    bigInteger = null;
                } else {
                    bigInteger = new BigInteger(1, mQVwithSHA384KDF.Cardinal.Cardinal);
                }
                if (bigInteger != null) {
                    this.Cardinal = new DHParameterSpec(new BigInteger(1, mQVwithSHA384KDF.init.Cardinal), new BigInteger(1, mQVwithSHA384KDF.configure.Cardinal), (mQVwithSHA384KDF.Cardinal != null ? new BigInteger(1, mQVwithSHA384KDF.Cardinal.Cardinal) : bigInteger2).intValue());
                } else {
                    this.Cardinal = new DHParameterSpec(new BigInteger(1, mQVwithSHA384KDF.init.Cardinal), new BigInteger(1, mQVwithSHA384KDF.configure.Cardinal));
                }
                this.cca_continue = new CipherSpi.PKCS1v1_5Padding(this.getInstance, new CipherSpi(this.Cardinal.getP(), this.Cardinal.getG()));
            } else if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.ECKAEGwithSHA1KDF.onSetupCompleted)) {
                KeyAgreementSpi.CDHwithSHA1KDFAndSharedInfo cDHwithSHA1KDFAndSharedInfo = cca_continue2 != null ? new KeyAgreementSpi.CDHwithSHA1KDFAndSharedInfo(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue2)) : null;
                KeyAgreementSpi.CDHwithSHA256KDFAndSharedInfo cDHwithSHA256KDFAndSharedInfo = cDHwithSHA1KDFAndSharedInfo.configure;
                if (cDHwithSHA256KDFAndSharedInfo != null) {
                    this.cca_continue = new CipherSpi.PKCS1v1_5Padding(this.getInstance, new CipherSpi(new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.Cardinal.Cardinal), new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.cca_continue.Cardinal), new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.getInstance.Cardinal), cDHwithSHA1KDFAndSharedInfo.init != null ? new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.init.Cardinal) : bigInteger2, new CipherSpi.NoPadding(cDHwithSHA256KDFAndSharedInfo.cca_continue(), new BigInteger(1, cDHwithSHA256KDFAndSharedInfo.getInstance.Cardinal).intValue())));
                } else {
                    this.cca_continue = new CipherSpi.PKCS1v1_5Padding(this.getInstance, new CipherSpi(new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.Cardinal.Cardinal), new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.cca_continue.Cardinal), new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.getInstance.Cardinal), cDHwithSHA1KDFAndSharedInfo.init != null ? new BigInteger(1, cDHwithSHA1KDFAndSharedInfo.init.Cardinal) : bigInteger2, (CipherSpi.NoPadding) null));
                }
                this.Cardinal = new Sphincs256KeyFactorySpi(this.cca_continue.configure);
            } else {
                throw new IllegalArgumentException("unknown algorithm type: ".concat(String.valueOf(aSN1ObjectIdentifier)));
            }
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DH public key");
        }
    }

    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.init;
        if (subjectPublicKeyInfo != null) {
            return KeyUtil.configure(subjectPublicKeyInfo);
        }
        DHParameterSpec dHParameterSpec = this.Cardinal;
        if (!(dHParameterSpec instanceof Sphincs256KeyFactorySpi) || ((Sphincs256KeyFactorySpi) dHParameterSpec).Cardinal == null) {
            return KeyUtil.getInstance(new DSASigner.stdDSA(KeyFactorySpi.setRequestTimeout, new KeyAgreementSpi.MQVwithSHA384KDF(this.Cardinal.getP(), this.Cardinal.getG(), this.Cardinal.getL()).values()), new setProxyAddress(this.getInstance));
        }
        CipherSpi init2 = ((Sphincs256KeyFactorySpi) this.Cardinal).init();
        CipherSpi.NoPadding noPadding = init2.getWarnings;
        KeyAgreementSpi.CDHwithSHA256KDFAndSharedInfo cDHwithSHA256KDFAndSharedInfo = null;
        if (noPadding != null) {
            cDHwithSHA256KDFAndSharedInfo = new KeyAgreementSpi.CDHwithSHA256KDFAndSharedInfo(noPadding.getInstance(), noPadding.configure);
        }
        return KeyUtil.getInstance(new DSASigner.stdDSA(KeyAgreementSpi.ECKAEGwithSHA1KDF.onSetupCompleted, new KeyAgreementSpi.CDHwithSHA1KDFAndSharedInfo(init2.Cardinal, init2.configure, init2.getInstance, init2.cca_continue, cDHwithSHA256KDFAndSharedInfo).values()), new setProxyAddress(this.getInstance));
    }

    public String toString() {
        BigInteger bigInteger = this.getInstance;
        CipherSpi cipherSpi = new CipherSpi(this.Cardinal.getP(), this.Cardinal.getG());
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        stringBuffer.append("DH");
        stringBuffer.append(" Public Key [");
        stringBuffer.append(new setActivated(setForegroundTintBlendMode.init(bigInteger.toByteArray(), cipherSpi.Cardinal.toByteArray(), cipherSpi.configure.toByteArray())).toString());
        stringBuffer.append(Const.jaRight);
        stringBuffer.append(instance);
        stringBuffer.append("             Y: ");
        stringBuffer.append(bigInteger.toString(16));
        stringBuffer.append(instance);
        return stringBuffer.toString();
    }

    private static boolean configure(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        if (setthreedsrequestorappurl.getInstance() == 2) {
            return true;
        }
        if (setthreedsrequestorappurl.getInstance() > 3) {
            return false;
        }
        return new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(2)).Cardinal).compareTo(BigInteger.valueOf((long) new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(0)).Cardinal).bitLength())) <= 0;
    }
}

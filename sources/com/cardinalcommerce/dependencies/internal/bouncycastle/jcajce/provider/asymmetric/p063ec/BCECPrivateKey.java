package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.GOST3410Util;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyLengthException;
import com.cardinalcommerce.p060a.NHKeyFactorySpi;
import com.cardinalcommerce.p060a.PrivateKeyInfo;
import com.cardinalcommerce.p060a.X509CertUtils;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setProxyAddress;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey */
public class BCECPrivateKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF, KeyLengthException, ECPrivateKey {
    private String Cardinal = "EC";
    private transient BigInteger cca_continue;
    private transient NHKeyFactorySpi configure;
    private transient PrivateKeyInfo getInstance;
    private transient ECParameterSpec init;

    protected BCECPrivateKey() {
        new PKCS12BagAttributeCarrierImpl();
    }

    BCECPrivateKey(String str, com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo privateKeyInfo, NHKeyFactorySpi nHKeyFactorySpi) throws IOException {
        new PKCS12BagAttributeCarrierImpl();
        this.Cardinal = str;
        this.configure = nHKeyFactorySpi;
        getInstance(privateKeyInfo);
    }

    public BCECPrivateKey(String str, ECPrivateKeySpec eCPrivateKeySpec, NHKeyFactorySpi nHKeyFactorySpi) {
        new PKCS12BagAttributeCarrierImpl();
        this.Cardinal = str;
        this.cca_continue = eCPrivateKeySpec.getS();
        this.init = eCPrivateKeySpec.getParams();
        this.configure = nHKeyFactorySpi;
    }

    public BCECPrivateKey(ECPrivateKey eCPrivateKey, NHKeyFactorySpi nHKeyFactorySpi) {
        new PKCS12BagAttributeCarrierImpl();
        this.cca_continue = eCPrivateKey.getS();
        this.Cardinal = eCPrivateKey.getAlgorithm();
        this.init = eCPrivateKey.getParams();
        this.configure = nHKeyFactorySpi;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.configure = JWK.getInstance;
        getInstance(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo.init(setLocationDataConsentGiven.getInstance((byte[]) objectInputStream.readObject())));
        new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final Container Cardinal() {
        ECParameterSpec eCParameterSpec = this.init;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.cca_continue(eCParameterSpec);
    }

    public String getAlgorithm() {
        return this.Cardinal;
    }

    public byte[] getEncoded() {
        KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo configure2 = GOST3410Util.configure(this.init);
        ECParameterSpec eCParameterSpec = this.init;
        int init2 = eCParameterSpec == null ? ECUtil.init(this.configure, (BigInteger) null, getS()) : ECUtil.init(this.configure, eCParameterSpec.getOrder(), getS());
        try {
            return new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.ECKAEGwithSHA1KDF.CardinalUiType, configure2), this.getInstance != null ? new DSASigner.detDSASha3_256(init2, getS(), this.getInstance, configure2) : new DSASigner.detDSASha3_256(init2, getS(), configure2)).init(ASN1Encoding.DER);
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public final BigInteger getInstance() {
        return this.cca_continue;
    }

    public ECParameterSpec getParams() {
        return this.init;
    }

    public BigInteger getS() {
        return this.cca_continue;
    }

    public BCECPrivateKey(String str, X509CertUtils x509CertUtils, NHKeyFactorySpi nHKeyFactorySpi) {
        ECParameterSpec eCParameterSpec;
        new PKCS12BagAttributeCarrierImpl();
        this.Cardinal = str;
        this.cca_continue = x509CertUtils.Cardinal;
        if (x509CertUtils.cca_continue != null) {
            getSDKAppID getsdkappid = x509CertUtils.cca_continue.init;
            x509CertUtils.cca_continue.getInstance();
            eCParameterSpec = EC5Util.Cardinal(EC5Util.getInstance(getsdkappid), x509CertUtils.cca_continue);
        } else {
            eCParameterSpec = null;
        }
        this.init = eCParameterSpec;
        this.configure = nHKeyFactorySpi;
    }

    public BCECPrivateKey(String str, DigestSignatureSpi.MD2 md2, BCECPublicKey bCECPublicKey, ECParameterSpec eCParameterSpec, NHKeyFactorySpi nHKeyFactorySpi) {
        new PKCS12BagAttributeCarrierImpl();
        this.Cardinal = str;
        this.cca_continue = md2.Cardinal;
        this.configure = nHKeyFactorySpi;
        if (eCParameterSpec == null) {
            BCRSAPublicKey bCRSAPublicKey = md2.init;
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            eCParameterSpec = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
        }
        this.init = eCParameterSpec;
        this.getInstance = getInstance(bCECPublicKey);
    }

    public BCECPrivateKey(String str, DigestSignatureSpi.MD2 md2, BCECPublicKey bCECPublicKey, Container container, NHKeyFactorySpi nHKeyFactorySpi) {
        new PKCS12BagAttributeCarrierImpl();
        this.Cardinal = str;
        this.cca_continue = md2.Cardinal;
        this.configure = nHKeyFactorySpi;
        if (container == null) {
            BCRSAPublicKey bCRSAPublicKey = md2.init;
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.init = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
        } else {
            getSDKAppID getsdkappid2 = container.init;
            container.getInstance();
            this.init = EC5Util.Cardinal(EC5Util.getInstance(getsdkappid2), container);
        }
        try {
            this.getInstance = getInstance(bCECPublicKey);
        } catch (Exception unused) {
            this.getInstance = null;
        }
    }

    public BCECPrivateKey(String str, DigestSignatureSpi.MD2 md2, NHKeyFactorySpi nHKeyFactorySpi) {
        new PKCS12BagAttributeCarrierImpl();
        this.Cardinal = str;
        this.cca_continue = md2.Cardinal;
        this.init = null;
        this.configure = nHKeyFactorySpi;
    }

    private void getInstance(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo privateKeyInfo) throws IOException {
        KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo init2 = KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo.init(privateKeyInfo.cca_continue.cca_continue);
        this.init = EC5Util.init(init2, EC5Util.getInstance(this.configure, init2));
        setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue());
        if (instance instanceof setProxyAddress) {
            this.cca_continue = new BigInteger(setProxyAddress.Cardinal((Object) instance).Cardinal);
            return;
        }
        DSASigner.detDSASha3_256 detdsasha3_256 = instance != null ? new DSASigner.detDSASha3_256(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
        this.cca_continue = new BigInteger(1, ((isEnableDFSync) detdsasha3_256.init.Cardinal(1)).cca_continue());
        this.getInstance = detdsasha3_256.cca_continue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECPrivateKey)) {
            return false;
        }
        BCECPrivateKey bCECPrivateKey = (BCECPrivateKey) obj;
        if (this.cca_continue.equals(bCECPrivateKey.cca_continue)) {
            ECParameterSpec eCParameterSpec = this.init;
            Container cca_continue2 = eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : this.configure.cca_continue();
            ECParameterSpec eCParameterSpec2 = bCECPrivateKey.init;
            if (cca_continue2.equals(eCParameterSpec2 != null ? EC5Util.cca_continue(eCParameterSpec2) : bCECPrivateKey.configure.cca_continue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.cca_continue.hashCode();
        ECParameterSpec eCParameterSpec = this.init;
        return hashCode ^ (eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : this.configure.cca_continue()).hashCode();
    }

    public String toString() {
        BigInteger bigInteger = this.cca_continue;
        ECParameterSpec eCParameterSpec = this.init;
        return ECUtil.configure("EC", bigInteger, eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : this.configure.cca_continue());
    }

    private static PrivateKeyInfo getInstance(BCECPublicKey bCECPublicKey) {
        try {
            return SubjectPublicKeyInfo.init(setLocationDataConsentGiven.getInstance(bCECPublicKey.getEncoded())).getInstance;
        } catch (IOException unused) {
            return null;
        }
    }
}

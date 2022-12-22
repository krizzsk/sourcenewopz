package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.cardinalcommerce.p060a.AESCBC;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.getSDKTransactionID;
import com.cardinalcommerce.p060a.getTransactionStatus;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setProxyAddress;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.asn1.ASN1Encoding;

public class BCElGamalPrivateKey implements AESCBC, KeyAgreementSpi.ECKAEGwithSHA512KDF, DHPrivateKey {
    private BigInteger Cardinal;
    private transient getTransactionStatus init;

    protected BCElGamalPrivateKey() {
        new PKCS12BagAttributeCarrierImpl();
    }

    BCElGamalPrivateKey(AESCBC aescbc) {
        new PKCS12BagAttributeCarrierImpl();
        this.Cardinal = aescbc.getX();
        this.init = aescbc.getInstance();
    }

    BCElGamalPrivateKey(DHPrivateKey dHPrivateKey) {
        new PKCS12BagAttributeCarrierImpl();
        this.Cardinal = dHPrivateKey.getX();
        this.init = new getTransactionStatus(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
    }

    BCElGamalPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        new PKCS12BagAttributeCarrierImpl();
        this.Cardinal = dHPrivateKeySpec.getX();
        this.init = new getTransactionStatus(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.init = new getTransactionStatus((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        new PKCS12BagAttributeCarrierImpl();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHPrivateKey)) {
            return false;
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) obj;
        return getX().equals(dHPrivateKey.getX()) && getParams().getG().equals(dHPrivateKey.getParams().getG()) && getParams().getP().equals(dHPrivateKey.getParams().getP()) && getParams().getL() == dHPrivateKey.getParams().getL();
    }

    public String getAlgorithm() {
        return "ElGamal";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public final getTransactionStatus getInstance() {
        return this.init;
    }

    public BigInteger getX() {
        return this.Cardinal;
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    BCElGamalPrivateKey(getSDKTransactionID getsdktransactionid) {
        new PKCS12BagAttributeCarrierImpl();
        this.Cardinal = null;
        this.init = new getTransactionStatus(null.configure, null.Cardinal);
    }

    BCElGamalPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        new PKCS12BagAttributeCarrierImpl();
        getProxyAddress getproxyaddress = privateKeyInfo.cca_continue.cca_continue;
        KeyAgreementSpi.MQVwithSHA256CKDF mQVwithSHA256CKDF = getproxyaddress instanceof KeyAgreementSpi.MQVwithSHA256CKDF ? (KeyAgreementSpi.MQVwithSHA256CKDF) getproxyaddress : getproxyaddress != null ? new KeyAgreementSpi.MQVwithSHA256CKDF(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null;
        this.Cardinal = new BigInteger(setProxyAddress.Cardinal((Object) setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue())).Cardinal);
        this.init = new getTransactionStatus(new BigInteger(1, mQVwithSHA256CKDF.configure.Cardinal), new BigInteger(1, mQVwithSHA256CKDF.Cardinal.Cardinal));
    }

    BCElGamalPrivateKey(DigestSignatureSpi.SHA3_256 sha3_256) {
        new PKCS12BagAttributeCarrierImpl();
        this.Cardinal = sha3_256.cca_continue;
        this.init = new getTransactionStatus(sha3_256.configure.init, sha3_256.configure.configure);
    }

    public byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA512KDF.values, new KeyAgreementSpi.MQVwithSHA256CKDF(this.init.configure, this.init.Cardinal)), new setProxyAddress(getX())).init(ASN1Encoding.DER);
        } catch (IOException unused) {
            return null;
        }
    }

    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.init.configure, this.init.Cardinal);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.init.configure);
        objectOutputStream.writeObject(this.init.Cardinal);
    }
}

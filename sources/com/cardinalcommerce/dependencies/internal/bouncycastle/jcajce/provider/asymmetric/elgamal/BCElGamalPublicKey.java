package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.CompletionEvent;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.RSASSAVerifier;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.getTransactionStatus;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setProxyAddress;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1Encoding;

public class BCElGamalPublicKey implements RSASSAVerifier, DHPublicKey {
    private BigInteger Cardinal;
    private transient getTransactionStatus cca_continue;

    BCElGamalPublicKey(RSASSAVerifier rSASSAVerifier) {
        this.Cardinal = rSASSAVerifier.getY();
        this.cca_continue = rSASSAVerifier.getInstance();
    }

    BCElGamalPublicKey(DHPublicKey dHPublicKey) {
        this.Cardinal = dHPublicKey.getY();
        this.cca_continue = new getTransactionStatus(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
    }

    BCElGamalPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.Cardinal = dHPublicKeySpec.getY();
        this.cca_continue = new getTransactionStatus(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.cca_continue = new getTransactionStatus((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        return getY().equals(dHPublicKey.getY()) && getParams().getG().equals(dHPublicKey.getParams().getG()) && getParams().getP().equals(dHPublicKey.getParams().getP()) && getParams().getL() == dHPublicKey.getParams().getL();
    }

    public String getAlgorithm() {
        return "ElGamal";
    }

    public String getFormat() {
        return "X.509";
    }

    public final getTransactionStatus getInstance() {
        return this.cca_continue;
    }

    public BigInteger getY() {
        return this.Cardinal;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    BCElGamalPublicKey(CompletionEvent completionEvent) {
        this.Cardinal = null;
        this.cca_continue = new getTransactionStatus(null.configure, null.Cardinal);
    }

    BCElGamalPublicKey(DigestSignatureSpi.SHA384 sha384) {
        this.Cardinal = sha384.Cardinal;
        this.cca_continue = new getTransactionStatus(sha384.configure.init, sha384.configure.configure);
    }

    BCElGamalPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        getProxyAddress getproxyaddress = subjectPublicKeyInfo.init.cca_continue;
        KeyAgreementSpi.MQVwithSHA256CKDF mQVwithSHA256CKDF = getproxyaddress instanceof KeyAgreementSpi.MQVwithSHA256CKDF ? (KeyAgreementSpi.MQVwithSHA256CKDF) getproxyaddress : getproxyaddress != null ? new KeyAgreementSpi.MQVwithSHA256CKDF(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null;
        try {
            this.Cardinal = new BigInteger(((setProxyAddress) setLocationDataConsentGiven.getInstance(subjectPublicKeyInfo.getInstance.cca_continue())).Cardinal);
            this.cca_continue = new getTransactionStatus(new BigInteger(1, mQVwithSHA256CKDF.configure.Cardinal), new BigInteger(1, mQVwithSHA256CKDF.Cardinal.Cardinal));
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA512KDF.values, new KeyAgreementSpi.MQVwithSHA256CKDF(this.cca_continue.configure, this.cca_continue.Cardinal)), (getProxyAddress) new setProxyAddress(this.Cardinal)).init(ASN1Encoding.DER);
        } catch (IOException unused) {
            return null;
        }
    }

    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.cca_continue.configure, this.cca_continue.Cardinal);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.cca_continue.configure);
        objectOutputStream.writeObject(this.cca_continue.Cardinal);
    }
}

package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.gost;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.cardinalcommerce.p060a.AlgorithmSupportMessage;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DeflateHelper;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.EdEC;
import com.cardinalcommerce.p060a.JWTClaimsSet;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.ProtocolErrorEvent;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.cardinalcommerce.p060a.setActivated;
import com.cardinalcommerce.p060a.setAnimation;
import com.cardinalcommerce.p060a.setErrorCode;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setProxyAddress;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import org.bouncycastle.asn1.ASN1Encoding;

public class BCGOST3410PrivateKey implements AlgorithmSupportMessage, KeyAgreementSpi.ECKAEGwithSHA512KDF {
    private transient DeflateHelper cca_continue;
    private BigInteger configure;

    protected BCGOST3410PrivateKey() {
        new PKCS12BagAttributeCarrierImpl();
    }

    BCGOST3410PrivateKey(AlgorithmSupportMessage algorithmSupportMessage) {
        new PKCS12BagAttributeCarrierImpl();
        this.configure = algorithmSupportMessage.getInstance();
        this.cca_continue = algorithmSupportMessage.cca_continue();
    }

    private static boolean configure(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            this.cca_continue = new ProtocolErrorEvent(str, (String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        } else {
            this.cca_continue = new ProtocolErrorEvent(new setErrorCode((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject()));
            objectInputStream.readObject();
            objectInputStream.readObject();
        }
        new PKCS12BagAttributeCarrierImpl();
    }

    public final DeflateHelper cca_continue() {
        return this.cca_continue;
    }

    public String getAlgorithm() {
        return "GOST3410";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public final BigInteger getInstance() {
        return this.configure;
    }

    BCGOST3410PrivateKey(JWTClaimsSet jWTClaimsSet) {
        new PKCS12BagAttributeCarrierImpl();
        this.configure = jWTClaimsSet.init;
        this.cca_continue = new ProtocolErrorEvent(new setErrorCode(jWTClaimsSet.cca_continue, jWTClaimsSet.configure, jWTClaimsSet.Cardinal));
    }

    BCGOST3410PrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        new PKCS12BagAttributeCarrierImpl();
        getProxyAddress getproxyaddress = privateKeyInfo.cca_continue.cca_continue;
        KeyAgreementSpi.DHwithSHA1CKDF dHwithSHA1CKDF = getproxyaddress instanceof KeyAgreementSpi.DHwithSHA1CKDF ? (KeyAgreementSpi.DHwithSHA1CKDF) getproxyaddress : getproxyaddress != null ? new KeyAgreementSpi.DHwithSHA1CKDF(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null;
        setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue());
        if (instance instanceof setProxyAddress) {
            this.configure = new BigInteger(1, setProxyAddress.Cardinal((Object) instance).Cardinal);
        } else {
            byte[] cca_continue2 = isEnableDFSync.init(setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue())).cca_continue();
            byte[] bArr = new byte[cca_continue2.length];
            for (int i = 0; i != cca_continue2.length; i++) {
                bArr[i] = cca_continue2[(cca_continue2.length - 1) - i];
            }
            this.configure = new BigInteger(1, bArr);
        }
        this.cca_continue = ProtocolErrorEvent.configure(dHwithSHA1CKDF);
    }

    BCGOST3410PrivateKey(DigestSignatureSpi.SHA512_224 sha512_224, ProtocolErrorEvent protocolErrorEvent) {
        new PKCS12BagAttributeCarrierImpl();
        this.configure = sha512_224.configure;
        this.cca_continue = protocolErrorEvent;
        if (protocolErrorEvent == null) {
            throw new IllegalArgumentException("spec is null");
        }
    }

    public byte[] getEncoded() {
        byte[] byteArray = this.configure.toByteArray();
        byte[] bArr = new byte[(byteArray[0] == 0 ? byteArray.length - 1 : byteArray.length)];
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = byteArray[(byteArray.length - 1) - i];
        }
        try {
            return (this.cca_continue instanceof ProtocolErrorEvent ? new PrivateKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.DHUwithSHA512CKDF.getWarnings, new KeyAgreementSpi.DHwithSHA1CKDF(new ASN1ObjectIdentifier(this.cca_continue.configure()), new ASN1ObjectIdentifier(this.cca_continue.Cardinal()))), new EdEC(bArr)) : new PrivateKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.DHUwithSHA512CKDF.getWarnings), new EdEC(bArr))).init(ASN1Encoding.DER);
        } catch (IOException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AlgorithmSupportMessage)) {
            return false;
        }
        AlgorithmSupportMessage algorithmSupportMessage = (AlgorithmSupportMessage) obj;
        if (!this.configure.equals(algorithmSupportMessage.getInstance()) || !this.cca_continue.cca_continue().equals(algorithmSupportMessage.cca_continue().cca_continue()) || !this.cca_continue.Cardinal().equals(algorithmSupportMessage.cca_continue().Cardinal()) || !configure(this.cca_continue.getInstance(), algorithmSupportMessage.cca_continue().getInstance())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.configure.hashCode() ^ this.cca_continue.hashCode();
    }

    public String toString() {
        try {
            BigInteger bigInteger = this.configure;
            DigestSignatureSpi.SHA512_256 sha512_256 = ((DigestSignatureSpi.SHA512_224) GOST3410Util.init(this)).cca_continue;
            StringBuffer stringBuffer = new StringBuffer();
            String instance = setAnimation.getInstance();
            BigInteger modPow = sha512_256.getInstance.modPow(bigInteger, sha512_256.cca_continue);
            stringBuffer.append("GOST3410");
            stringBuffer.append(" Private Key [");
            stringBuffer.append(new setActivated(setForegroundTintBlendMode.init(modPow.toByteArray(), sha512_256.cca_continue.toByteArray(), sha512_256.getInstance.toByteArray())).toString());
            stringBuffer.append(Const.jaRight);
            stringBuffer.append(instance);
            stringBuffer.append("                  Y: ");
            stringBuffer.append(modPow.toString(16));
            stringBuffer.append(instance);
            return stringBuffer.toString();
        } catch (InvalidKeyException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (this.cca_continue.configure() != null) {
            objectOutputStream.writeObject(this.cca_continue.configure());
            objectOutputStream.writeObject(this.cca_continue.Cardinal());
            objectOutputStream.writeObject(this.cca_continue.getInstance());
            return;
        }
        objectOutputStream.writeObject((Object) null);
        objectOutputStream.writeObject(this.cca_continue.cca_continue().configure);
        objectOutputStream.writeObject(this.cca_continue.cca_continue().init);
        objectOutputStream.writeObject(this.cca_continue.cca_continue().getInstance);
        objectOutputStream.writeObject(this.cca_continue.Cardinal());
        objectOutputStream.writeObject(this.cca_continue.getInstance());
    }
}

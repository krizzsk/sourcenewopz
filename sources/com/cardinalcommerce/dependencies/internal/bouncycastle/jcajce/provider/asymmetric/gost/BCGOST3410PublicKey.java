package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.gost;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.cardinalcommerce.p060a.AuthenticatedCipherText;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DeflateHelper;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.EdEC;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.ProtocolErrorEvent;
import com.cardinalcommerce.p060a.RuntimeErrorEvent;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.setActivated;
import com.cardinalcommerce.p060a.setAnimation;
import com.cardinalcommerce.p060a.setErrorCode;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;

public class BCGOST3410PublicKey implements AuthenticatedCipherText {
    private BigInteger configure;
    private transient DeflateHelper getInstance;

    BCGOST3410PublicKey(AuthenticatedCipherText authenticatedCipherText) {
        this.configure = authenticatedCipherText.Cardinal();
        this.getInstance = authenticatedCipherText.cca_continue();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            this.getInstance = new ProtocolErrorEvent(str, (String) objectInputStream.readObject(), (String) objectInputStream.readObject());
            return;
        }
        this.getInstance = new ProtocolErrorEvent(new setErrorCode((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject()));
        objectInputStream.readObject();
        objectInputStream.readObject();
    }

    public final BigInteger Cardinal() {
        return this.configure;
    }

    public final DeflateHelper cca_continue() {
        return this.getInstance;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BCGOST3410PublicKey) {
            BCGOST3410PublicKey bCGOST3410PublicKey = (BCGOST3410PublicKey) obj;
            return this.configure.equals(bCGOST3410PublicKey.configure) && this.getInstance.equals(bCGOST3410PublicKey.getInstance);
        }
    }

    public String getAlgorithm() {
        return "GOST3410";
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.configure.hashCode() ^ this.getInstance.hashCode();
    }

    BCGOST3410PublicKey(RuntimeErrorEvent runtimeErrorEvent) {
        this.configure = runtimeErrorEvent.getInstance;
        this.getInstance = new ProtocolErrorEvent(new setErrorCode(runtimeErrorEvent.Cardinal, runtimeErrorEvent.init, runtimeErrorEvent.configure));
    }

    BCGOST3410PublicKey(DigestSignatureSpi.SHA3_384 sha3_384, ProtocolErrorEvent protocolErrorEvent) {
        this.configure = sha3_384.getInstance;
        this.getInstance = protocolErrorEvent;
    }

    BCGOST3410PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        getProxyAddress getproxyaddress = subjectPublicKeyInfo.init.cca_continue;
        KeyAgreementSpi.DHwithSHA1CKDF dHwithSHA1CKDF = getproxyaddress instanceof KeyAgreementSpi.DHwithSHA1CKDF ? (KeyAgreementSpi.DHwithSHA1CKDF) getproxyaddress : getproxyaddress != null ? new KeyAgreementSpi.DHwithSHA1CKDF(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null;
        try {
            byte[] cca_continue = ((EdEC) setLocationDataConsentGiven.getInstance(subjectPublicKeyInfo.getInstance.cca_continue())).cca_continue();
            byte[] bArr = new byte[cca_continue.length];
            for (int i = 0; i != cca_continue.length; i++) {
                bArr[i] = cca_continue[(cca_continue.length - 1) - i];
            }
            this.configure = new BigInteger(1, bArr);
            this.getInstance = ProtocolErrorEvent.configure(dHwithSHA1CKDF);
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in GOST3410 public key");
        }
    }

    public byte[] getEncoded() {
        byte[] byteArray = this.configure.toByteArray();
        byte[] bArr = new byte[(byteArray[0] == 0 ? byteArray.length - 1 : byteArray.length)];
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = byteArray[(byteArray.length - 1) - i];
        }
        try {
            return KeyUtil.configure(this.getInstance instanceof ProtocolErrorEvent ? this.getInstance.getInstance() != null ? new SubjectPublicKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.DHUwithSHA512CKDF.getWarnings, new KeyAgreementSpi.DHwithSHA1CKDF(new ASN1ObjectIdentifier(this.getInstance.configure()), new ASN1ObjectIdentifier(this.getInstance.Cardinal()), new ASN1ObjectIdentifier(this.getInstance.getInstance()))), (getProxyAddress) new EdEC(bArr)) : new SubjectPublicKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.DHUwithSHA512CKDF.getWarnings, new KeyAgreementSpi.DHwithSHA1CKDF(new ASN1ObjectIdentifier(this.getInstance.configure()), new ASN1ObjectIdentifier(this.getInstance.Cardinal()))), (getProxyAddress) new EdEC(bArr)) : new SubjectPublicKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.DHUwithSHA512CKDF.getWarnings), (getProxyAddress) new EdEC(bArr)));
        } catch (IOException unused) {
            return null;
        }
    }

    public String toString() {
        try {
            BigInteger bigInteger = this.configure;
            DigestSignatureSpi.SHA512_256 sha512_256 = ((DigestSignatureSpi.SHA3_384) GOST3410Util.cca_continue(this)).cca_continue;
            StringBuffer stringBuffer = new StringBuffer();
            String instance = setAnimation.getInstance();
            stringBuffer.append("GOST3410");
            stringBuffer.append(" Public Key [");
            stringBuffer.append(new setActivated(setForegroundTintBlendMode.init(bigInteger.toByteArray(), sha512_256.cca_continue.toByteArray(), sha512_256.getInstance.toByteArray())).toString());
            stringBuffer.append(Const.jaRight);
            stringBuffer.append(instance);
            stringBuffer.append("                 Y: ");
            stringBuffer.append(bigInteger.toString(16));
            stringBuffer.append(instance);
            return stringBuffer.toString();
        } catch (InvalidKeyException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (this.getInstance.configure() != null) {
            objectOutputStream.writeObject(this.getInstance.configure());
            objectOutputStream.writeObject(this.getInstance.Cardinal());
            objectOutputStream.writeObject(this.getInstance.getInstance());
            return;
        }
        objectOutputStream.writeObject((Object) null);
        objectOutputStream.writeObject(this.getInstance.cca_continue().configure);
        objectOutputStream.writeObject(this.getInstance.cca_continue().init);
        objectOutputStream.writeObject(this.getInstance.cca_continue().getInstance);
        objectOutputStream.writeObject(this.getInstance.Cardinal());
        objectOutputStream.writeObject(this.getInstance.getInstance());
    }
}

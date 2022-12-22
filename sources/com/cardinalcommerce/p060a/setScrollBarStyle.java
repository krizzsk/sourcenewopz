package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

/* renamed from: com.cardinalcommerce.a.setScrollBarStyle */
public final class setScrollBarStyle implements KeyAgreementSpi.ECKAEGwithSHA512KDF, PrivateKey {
    private transient ASN1ObjectIdentifier Cardinal;
    private transient setFocusedByDefault configure;
    private transient isEnableLogging getInstance;

    public setScrollBarStyle(PrivateKeyInfo privateKeyInfo) throws IOException {
        Cardinal(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Cardinal(PrivateKeyInfo.init((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof setScrollBarStyle) {
            setScrollBarStyle setscrollbarstyle = (setScrollBarStyle) obj;
            return this.Cardinal.equals(setscrollbarstyle.Cardinal) && setForegroundTintBlendMode.Cardinal(this.configure.cca_continue(), setscrollbarstyle.configure.cca_continue());
        }
    }

    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final int hashCode() {
        return this.Cardinal.hashCode() + (setForegroundTintBlendMode.init(this.configure.cca_continue()) * 37);
    }

    private void Cardinal(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.getInstance = privateKeyInfo.configure;
        getProxyAddress getproxyaddress = privateKeyInfo.cca_continue.cca_continue;
        this.Cardinal = (getproxyaddress instanceof setSoundEffectsEnabled ? (setSoundEffectsEnabled) getproxyaddress : getproxyaddress != null ? new setSoundEffectsEnabled(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null).cca_continue.init;
        this.configure = (setFocusedByDefault) setTransitionVisibility.cca_continue(privateKeyInfo);
    }

    public final byte[] getEncoded() {
        try {
            return (this.configure.init != null ? DSASigner.dsaSha3_384.Cardinal((setKeyboardNavigationCluster) this.configure, this.getInstance) : new PrivateKeyInfo(new DSASigner.stdDSA(PQCObjectIdentifiers.Cardinal, new setSoundEffectsEnabled(new DSASigner.stdDSA(this.Cardinal))), new EdEC(this.configure.cca_continue()), this.getInstance)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }
}

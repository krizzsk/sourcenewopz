package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

/* renamed from: com.cardinalcommerce.a.setClipBounds */
public final class setClipBounds implements KeyAgreementSpi.ECKAEGwithSHA512KDF, PublicKey {
    private transient setHovered cca_continue;
    private transient ASN1ObjectIdentifier configure;

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof setClipBounds) {
            setClipBounds setclipbounds = (setClipBounds) obj;
            return this.configure.equals(setclipbounds.configure) && setForegroundTintBlendMode.Cardinal(this.cca_continue.Cardinal(), setclipbounds.cca_continue.Cardinal());
        }
    }

    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    public final String getFormat() {
        return "X.509";
    }

    public final int hashCode() {
        return this.configure.hashCode() + (setForegroundTintBlendMode.init(this.cca_continue.Cardinal()) * 37);
    }

    public setClipBounds(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        getProxyAddress getproxyaddress = subjectPublicKeyInfo.init.cca_continue;
        this.configure = (getproxyaddress instanceof setSoundEffectsEnabled ? (setSoundEffectsEnabled) getproxyaddress : getproxyaddress != null ? new setSoundEffectsEnabled(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null).cca_continue.init;
        this.cca_continue = (setHovered) setScrollX.init(subjectPublicKeyInfo);
    }

    public final byte[] getEncoded() {
        try {
            return (this.cca_continue.init != null ? DSASigner.dsaSha3_384.getInstance((setKeyboardNavigationCluster) this.cca_continue) : new SubjectPublicKeyInfo(new DSASigner.stdDSA(PQCObjectIdentifiers.Cardinal, new setSoundEffectsEnabled(new DSASigner.stdDSA(this.configure))), this.cca_continue.Cardinal())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        SubjectPublicKeyInfo init = SubjectPublicKeyInfo.init((byte[]) objectInputStream.readObject());
        getProxyAddress getproxyaddress = init.init.cca_continue;
        this.configure = (getproxyaddress instanceof setSoundEffectsEnabled ? (setSoundEffectsEnabled) getproxyaddress : getproxyaddress != null ? new setSoundEffectsEnabled(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null).cca_continue.init;
        this.cca_continue = (setHovered) setScrollX.init(init);
    }
}

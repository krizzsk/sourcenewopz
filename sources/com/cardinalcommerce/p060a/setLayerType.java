package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

/* renamed from: com.cardinalcommerce.a.setLayerType */
public final class setLayerType implements PublicKey {
    private transient setImportantForAccessibility Cardinal;

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final byte[] getEncoded() {
        try {
            return DSASigner.dsaSha3_384.getInstance((setKeyboardNavigationCluster) this.Cardinal).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "X.509";
    }

    public setLayerType(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.Cardinal = (setImportantForAccessibility) setScrollX.init(subjectPublicKeyInfo);
    }

    public final String getAlgorithm() {
        return DSASigner.dsaSha3_384.configure(this.Cardinal.getInstance);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof setLayerType) {
            setLayerType setlayertype = (setLayerType) obj;
            return this.Cardinal.getInstance == setlayertype.Cardinal.getInstance && setForegroundTintBlendMode.Cardinal(this.Cardinal.init(), setlayertype.Cardinal.init());
        }
    }

    public final int hashCode() {
        return this.Cardinal.getInstance + (setForegroundTintBlendMode.init(this.Cardinal.init()) * 37);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.Cardinal = (setImportantForAccessibility) setScrollX.init(SubjectPublicKeyInfo.init((byte[]) objectInputStream.readObject()));
    }
}

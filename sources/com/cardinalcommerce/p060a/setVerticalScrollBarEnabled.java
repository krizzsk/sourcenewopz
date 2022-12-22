package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* renamed from: com.cardinalcommerce.a.setVerticalScrollBarEnabled */
public final class setVerticalScrollBarEnabled implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    private transient setAccessibilityHeading Cardinal;

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof setVerticalScrollBarEnabled)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.Cardinal.configure(), ((setVerticalScrollBarEnabled) obj).Cardinal.configure());
    }

    public final String getAlgorithm() {
        return "NH";
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

    public final int hashCode() {
        return setForegroundTintBlendMode.init(this.Cardinal.configure());
    }

    public setVerticalScrollBarEnabled(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.Cardinal = (setAccessibilityHeading) setScrollX.init(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.Cardinal = (setAccessibilityHeading) setScrollX.init(SubjectPublicKeyInfo.init((byte[]) objectInputStream.readObject()));
    }
}

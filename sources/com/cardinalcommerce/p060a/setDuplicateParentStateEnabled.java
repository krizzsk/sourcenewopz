package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

/* renamed from: com.cardinalcommerce.a.setDuplicateParentStateEnabled */
public final class setDuplicateParentStateEnabled implements PrivateKey {
    private transient setSaveEnabled Cardinal;
    private transient isEnableLogging configure;

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final byte[] getEncoded() {
        try {
            return DSASigner.dsaSha3_384.Cardinal((setKeyboardNavigationCluster) this.Cardinal, this.configure).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public setDuplicateParentStateEnabled(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.configure = privateKeyInfo.configure;
        this.Cardinal = (setSaveEnabled) setTransitionVisibility.cca_continue(privateKeyInfo);
    }

    public final String getAlgorithm() {
        return DSASigner.dsaSha3_384.configure(this.Cardinal.configure);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof setDuplicateParentStateEnabled) {
            setDuplicateParentStateEnabled setduplicateparentstateenabled = (setDuplicateParentStateEnabled) obj;
            return this.Cardinal.configure == setduplicateparentstateenabled.Cardinal.configure && setForegroundTintBlendMode.Cardinal(this.Cardinal.configure(), setduplicateparentstateenabled.Cardinal.configure());
        }
    }

    public final int hashCode() {
        return this.Cardinal.configure + (setForegroundTintBlendMode.init(this.Cardinal.configure()) * 37);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        PrivateKeyInfo init = PrivateKeyInfo.init((byte[]) objectInputStream.readObject());
        this.configure = init.configure;
        this.Cardinal = (setSaveEnabled) setTransitionVisibility.cca_continue(init);
    }
}

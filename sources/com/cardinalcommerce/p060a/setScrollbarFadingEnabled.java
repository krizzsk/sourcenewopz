package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* renamed from: com.cardinalcommerce.a.setScrollbarFadingEnabled */
public final class setScrollbarFadingEnabled implements setOutlineAmbientShadowColor {
    private transient isEnableLogging configure;
    private transient setFilterTouchesWhenObscured getInstance;

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof setScrollbarFadingEnabled)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.getInstance.configure(), ((setScrollbarFadingEnabled) obj).getInstance.configure());
    }

    public final String getAlgorithm() {
        return "NH";
    }

    public final byte[] getEncoded() {
        try {
            return DSASigner.dsaSha3_384.Cardinal((setKeyboardNavigationCluster) this.getInstance, this.configure).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.init(this.getInstance.configure());
    }

    public setScrollbarFadingEnabled(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.configure = privateKeyInfo.configure;
        this.getInstance = (setFilterTouchesWhenObscured) setTransitionVisibility.cca_continue(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        PrivateKeyInfo init = PrivateKeyInfo.init((byte[]) objectInputStream.readObject());
        this.configure = init.configure;
        this.getInstance = (setFilterTouchesWhenObscured) setTransitionVisibility.cca_continue(init);
    }
}

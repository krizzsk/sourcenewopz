package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

/* renamed from: com.cardinalcommerce.a.setLeftTopRightBottom */
public final class setLeftTopRightBottom implements setOutlineAmbientShadowColor, PrivateKey {
    private transient setTranslationZ cca_continue;
    private transient isEnableLogging getInstance;
    private transient ASN1ObjectIdentifier init;

    public setLeftTopRightBottom(PrivateKeyInfo privateKeyInfo) throws IOException {
        cca_continue(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        cca_continue(PrivateKeyInfo.init((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof setLeftTopRightBottom) {
            setLeftTopRightBottom setlefttoprightbottom = (setLeftTopRightBottom) obj;
            return this.init.equals(setlefttoprightbottom.init) && setForegroundTintBlendMode.Cardinal(this.cca_continue.Cardinal(), setlefttoprightbottom.cca_continue.Cardinal());
        }
    }

    public final String getAlgorithm() {
        return "XMSS";
    }

    public final byte[] getEncoded() {
        try {
            return DSASigner.dsaSha3_384.Cardinal((setKeyboardNavigationCluster) this.cca_continue, this.getInstance).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final int hashCode() {
        return this.init.hashCode() + (setForegroundTintBlendMode.init(this.cca_continue.Cardinal()) * 37);
    }

    private void cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.getInstance = privateKeyInfo.configure;
        getProxyAddress getproxyaddress = privateKeyInfo.cca_continue.cca_continue;
        this.init = (getproxyaddress instanceof setHasTransientState ? (setHasTransientState) getproxyaddress : getproxyaddress != null ? new setHasTransientState(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null).getInstance.init;
        this.cca_continue = (setTranslationZ) setTransitionVisibility.cca_continue(privateKeyInfo);
    }
}

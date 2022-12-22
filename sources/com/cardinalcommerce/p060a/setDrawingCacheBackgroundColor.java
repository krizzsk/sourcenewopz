package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

/* renamed from: com.cardinalcommerce.a.setDrawingCacheBackgroundColor */
public final class setDrawingCacheBackgroundColor implements PublicKey {
    private transient ASN1ObjectIdentifier cca_continue;
    private transient setZ init;

    public setDrawingCacheBackgroundColor(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        cca_continue(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        cca_continue(SubjectPublicKeyInfo.init((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof setDrawingCacheBackgroundColor) {
            setDrawingCacheBackgroundColor setdrawingcachebackgroundcolor = (setDrawingCacheBackgroundColor) obj;
            return this.cca_continue.equals(setdrawingcachebackgroundcolor.cca_continue) && setForegroundTintBlendMode.Cardinal(this.init.init(), setdrawingcachebackgroundcolor.init.init());
        }
    }

    public final String getAlgorithm() {
        return "XMSSMT";
    }

    public final byte[] getEncoded() {
        try {
            return DSASigner.dsaSha3_384.getInstance((setKeyboardNavigationCluster) this.init).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "X.509";
    }

    public final int hashCode() {
        return this.cca_continue.hashCode() + (setForegroundTintBlendMode.init(this.init.init()) * 37);
    }

    private void cca_continue(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        getProxyAddress getproxyaddress = subjectPublicKeyInfo.init.cca_continue;
        this.cca_continue = (getproxyaddress instanceof setWillNotCacheDrawing ? (setWillNotCacheDrawing) getproxyaddress : getproxyaddress != null ? new setWillNotCacheDrawing(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null).Cardinal.init;
        this.init = (setZ) setScrollX.init(subjectPublicKeyInfo);
    }
}

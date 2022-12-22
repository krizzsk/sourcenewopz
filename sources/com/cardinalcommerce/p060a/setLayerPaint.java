package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

/* renamed from: com.cardinalcommerce.a.setLayerPaint */
public final class setLayerPaint implements setOutlineAmbientShadowColor, PrivateKey {
    private transient isEnableLogging Cardinal;
    private transient ASN1ObjectIdentifier configure;
    private transient setTranslationX getInstance;

    public setLayerPaint(PrivateKeyInfo privateKeyInfo) throws IOException {
        init(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(PrivateKeyInfo.init((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof setLayerPaint) {
            setLayerPaint setlayerpaint = (setLayerPaint) obj;
            return this.configure.equals(setlayerpaint.configure) && setForegroundTintBlendMode.Cardinal(this.getInstance.Cardinal(), setlayerpaint.getInstance.Cardinal());
        }
    }

    public final String getAlgorithm() {
        return "XMSSMT";
    }

    public final byte[] getEncoded() {
        try {
            return DSASigner.dsaSha3_384.Cardinal((setKeyboardNavigationCluster) this.getInstance, this.Cardinal).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final int hashCode() {
        return this.configure.hashCode() + (setForegroundTintBlendMode.init(this.getInstance.Cardinal()) * 37);
    }

    private void init(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.Cardinal = privateKeyInfo.configure;
        getProxyAddress getproxyaddress = privateKeyInfo.cca_continue.cca_continue;
        this.configure = (getproxyaddress instanceof setWillNotCacheDrawing ? (setWillNotCacheDrawing) getproxyaddress : getproxyaddress != null ? new setWillNotCacheDrawing(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null).Cardinal.init;
        this.getInstance = (setTranslationX) setTransitionVisibility.cca_continue(privateKeyInfo);
    }
}

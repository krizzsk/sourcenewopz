package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.p060a.DSAEncoder;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyUtil;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.cardinalcommerce.p060a.isEnableLogging;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setOnHoverListener;
import com.cardinalcommerce.p060a.setRevealOnFocusHint;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;

public class BCXDHPrivateKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF, PrivateKey {
    private final byte[] Cardinal;
    private final boolean getInstance;
    transient setKeyboardNavigationCluster init;

    BCXDHPrivateKey(setKeyboardNavigationCluster setkeyboardnavigationcluster) {
        this.getInstance = true;
        this.Cardinal = null;
        this.init = setkeyboardnavigationcluster;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        cca_continue(PrivateKeyInfo.init((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXDHPrivateKey)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(((BCXDHPrivateKey) obj).getEncoded(), getEncoded());
    }

    public String getAlgorithm() {
        return this.init instanceof PSSSignatureSpi.SHA512_256withRSA ? XDHParameterSpec.X448 : XDHParameterSpec.X25519;
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return setForegroundTintBlendMode.init(getEncoded());
    }

    BCXDHPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.getInstance = privateKeyInfo.cca_continue();
        this.Cardinal = privateKeyInfo.configure != null ? privateKeyInfo.configure.getEncoded() : null;
        cca_continue(privateKeyInfo);
    }

    private void cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue());
        this.init = KeyAgreementSpi.DHwithSHA256CKDF.configure.equals(privateKeyInfo.cca_continue.init) ? new PSSSignatureSpi.SHA512_256withRSA(isEnableDFSync.init(instance).cca_continue()) : new PSSSignatureSpi.SHA3_224withRSA(isEnableDFSync.init(instance).cca_continue());
    }

    public byte[] getEncoded() {
        try {
            isEnableLogging Cardinal2 = isEnableLogging.Cardinal((Object) this.Cardinal);
            PrivateKeyInfo Cardinal3 = DSAEncoder.Cardinal(this.init, Cardinal2);
            if (this.getInstance) {
                return Cardinal3.getEncoded();
            }
            return new PrivateKeyInfo(Cardinal3.cca_continue, setLocationDataConsentGiven.getInstance(Cardinal3.init.cca_continue()), Cardinal2).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public String toString() {
        setKeyboardNavigationCluster setkeyboardnavigationcluster;
        setKeyboardNavigationCluster setkeyboardnavigationcluster2 = this.init;
        if (setkeyboardnavigationcluster2 instanceof PSSSignatureSpi.SHA512_256withRSA) {
            byte[] bArr = new byte[56];
            setRevealOnFocusHint.Cardinal(((PSSSignatureSpi.SHA512_256withRSA) setkeyboardnavigationcluster2).getInstance, 0, bArr, 0);
            setkeyboardnavigationcluster = new PSSSignatureSpi.SHA3_384withRSA(bArr, 0);
        } else {
            byte[] bArr2 = new byte[32];
            setOnHoverListener.Cardinal(((PSSSignatureSpi.SHA3_224withRSA) setkeyboardnavigationcluster2).configure, 0, bArr2, 0);
            setkeyboardnavigationcluster = new PSSSignatureSpi.SHA3_256withRSA(bArr2, 0);
        }
        return KeyUtil.Cardinal("Private Key", getAlgorithm(), setkeyboardnavigationcluster);
    }
}

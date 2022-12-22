package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyUtil;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;

public class BCXDHPublicKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF, PublicKey {
    transient setKeyboardNavigationCluster cca_continue;

    BCXDHPublicKey(setKeyboardNavigationCluster setkeyboardnavigationcluster) {
        this.cca_continue = setkeyboardnavigationcluster;
    }

    BCXDHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        cca_continue(subjectPublicKeyInfo);
    }

    BCXDHPublicKey(byte[] bArr, byte[] bArr2) throws InvalidKeySpecException {
        setKeyboardNavigationCluster sHA3_256withRSA;
        int length = bArr.length;
        if (KeyUtil.init(bArr, bArr2)) {
            if (bArr2.length - length == 56) {
                sHA3_256withRSA = new PSSSignatureSpi.SHA3_384withRSA(bArr2, length);
            } else if (bArr2.length - length == 32) {
                sHA3_256withRSA = new PSSSignatureSpi.SHA3_256withRSA(bArr2, length);
            } else {
                throw new InvalidKeySpecException("raw key data not recognised");
            }
            this.cca_continue = sHA3_256withRSA;
            return;
        }
        throw new InvalidKeySpecException("raw key data not recognised");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        cca_continue(SubjectPublicKeyInfo.init((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXDHPublicKey)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(((BCXDHPublicKey) obj).getEncoded(), getEncoded());
    }

    public String getAlgorithm() {
        return this.cca_continue instanceof PSSSignatureSpi.SHA3_384withRSA ? XDHParameterSpec.X448 : XDHParameterSpec.X25519;
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return setForegroundTintBlendMode.init(getEncoded());
    }

    public String toString() {
        return KeyUtil.Cardinal("Public Key", getAlgorithm(), this.cca_continue);
    }

    private void cca_continue(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        if (KeyAgreementSpi.DHwithSHA256CKDF.configure.equals(subjectPublicKeyInfo.init.init)) {
            this.cca_continue = new PSSSignatureSpi.SHA3_384withRSA(subjectPublicKeyInfo.getInstance.cca_continue(), 0);
        } else {
            this.cca_continue = new PSSSignatureSpi.SHA3_256withRSA(subjectPublicKeyInfo.getInstance.cca_continue(), 0);
        }
    }

    public byte[] getEncoded() {
        if (this.cca_continue instanceof PSSSignatureSpi.SHA3_384withRSA) {
            byte[] bArr = new byte[(KeyFactorySpi.getInstance.length + 56)];
            System.arraycopy(KeyFactorySpi.getInstance, 0, bArr, 0, KeyFactorySpi.getInstance.length);
            System.arraycopy(((PSSSignatureSpi.SHA3_384withRSA) this.cca_continue).configure, 0, bArr, KeyFactorySpi.getInstance.length, 56);
            return bArr;
        }
        byte[] bArr2 = new byte[(KeyFactorySpi.configure.length + 32)];
        System.arraycopy(KeyFactorySpi.configure, 0, bArr2, 0, KeyFactorySpi.configure.length);
        System.arraycopy(((PSSSignatureSpi.SHA3_256withRSA) this.cca_continue).configure, 0, bArr2, KeyFactorySpi.configure.length, 32);
        return bArr2;
    }
}

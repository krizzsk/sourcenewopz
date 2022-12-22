package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyUtil;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;

public class BCEdDSAPublicKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF, PublicKey {
    transient setKeyboardNavigationCluster init;

    BCEdDSAPublicKey(setKeyboardNavigationCluster setkeyboardnavigationcluster) {
        this.init = setkeyboardnavigationcluster;
    }

    BCEdDSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        configure(subjectPublicKeyInfo);
    }

    BCEdDSAPublicKey(byte[] bArr, byte[] bArr2) throws InvalidKeySpecException {
        setKeyboardNavigationCluster ripemd256;
        int length = bArr.length;
        if (KeyUtil.init(bArr, bArr2)) {
            if (bArr2.length - length == 57) {
                ripemd256 = new DigestSignatureSpi.RIPEMD128(bArr2, length);
            } else if (bArr2.length - length == 32) {
                ripemd256 = new DigestSignatureSpi.RIPEMD256(bArr2, length);
            } else {
                throw new InvalidKeySpecException("raw key data not recognised");
            }
            this.init = ripemd256;
            return;
        }
        throw new InvalidKeySpecException("raw key data not recognised");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        configure(SubjectPublicKeyInfo.init((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCEdDSAPublicKey)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(((BCEdDSAPublicKey) obj).getEncoded(), getEncoded());
    }

    public String getAlgorithm() {
        return this.init instanceof DigestSignatureSpi.RIPEMD128 ? EdDSAParameterSpec.Ed448 : EdDSAParameterSpec.Ed25519;
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return setForegroundTintBlendMode.init(getEncoded());
    }

    public String toString() {
        return KeyUtil.Cardinal("Public Key", getAlgorithm(), this.init);
    }

    private void configure(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        if (KeyAgreementSpi.DHwithSHA256CKDF.init.equals(subjectPublicKeyInfo.init.init)) {
            this.init = new DigestSignatureSpi.RIPEMD128(subjectPublicKeyInfo.getInstance.cca_continue(), 0);
        } else {
            this.init = new DigestSignatureSpi.RIPEMD256(subjectPublicKeyInfo.getInstance.cca_continue(), 0);
        }
    }

    public byte[] getEncoded() {
        if (this.init instanceof DigestSignatureSpi.RIPEMD128) {
            byte[] bArr = new byte[(KeyFactorySpi.cca_continue.length + 57)];
            System.arraycopy(KeyFactorySpi.cca_continue, 0, bArr, 0, KeyFactorySpi.cca_continue.length);
            System.arraycopy(((DigestSignatureSpi.RIPEMD128) this.init).Cardinal, 0, bArr, KeyFactorySpi.cca_continue.length, 57);
            return bArr;
        }
        byte[] bArr2 = new byte[(KeyFactorySpi.init.length + 32)];
        System.arraycopy(KeyFactorySpi.init, 0, bArr2, 0, KeyFactorySpi.init.length);
        System.arraycopy(((DigestSignatureSpi.RIPEMD256) this.init).init, 0, bArr2, KeyFactorySpi.init.length, 32);
        return bArr2;
    }
}

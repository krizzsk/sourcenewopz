package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.p060a.DSAEncoder;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyUtil;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.cardinalcommerce.p060a.isEnableLogging;
import com.cardinalcommerce.p060a.setAutofillId;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setImportantForAutofill;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;

public class BCEdDSAPrivateKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF, PrivateKey {
    private final byte[] Cardinal;
    transient setKeyboardNavigationCluster configure;
    private final boolean init;

    BCEdDSAPrivateKey(setKeyboardNavigationCluster setkeyboardnavigationcluster) {
        this.init = true;
        this.Cardinal = null;
        this.configure = setkeyboardnavigationcluster;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Cardinal(PrivateKeyInfo.init((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCEdDSAPrivateKey)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(((BCEdDSAPrivateKey) obj).getEncoded(), getEncoded());
    }

    public String getAlgorithm() {
        return this.configure instanceof DigestSignatureSpi.SHA1 ? EdDSAParameterSpec.Ed448 : EdDSAParameterSpec.Ed25519;
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return setForegroundTintBlendMode.init(getEncoded());
    }

    BCEdDSAPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.init = privateKeyInfo.cca_continue();
        this.Cardinal = privateKeyInfo.configure != null ? privateKeyInfo.configure.getEncoded() : null;
        Cardinal(privateKeyInfo);
    }

    private void Cardinal(PrivateKeyInfo privateKeyInfo) throws IOException {
        setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue());
        this.configure = KeyAgreementSpi.DHwithSHA256CKDF.init.equals(privateKeyInfo.cca_continue.init) ? new DigestSignatureSpi.SHA1(isEnableDFSync.init(instance).cca_continue()) : new DigestSignatureSpi.MD5(isEnableDFSync.init(instance).cca_continue());
    }

    public byte[] getEncoded() {
        try {
            isEnableLogging Cardinal2 = isEnableLogging.Cardinal((Object) this.Cardinal);
            PrivateKeyInfo Cardinal3 = DSAEncoder.Cardinal(this.configure, Cardinal2);
            if (this.init) {
                return Cardinal3.getEncoded();
            }
            return new PrivateKeyInfo(Cardinal3.cca_continue, setLocationDataConsentGiven.getInstance(Cardinal3.init.cca_continue()), Cardinal2).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public String toString() {
        setKeyboardNavigationCluster setkeyboardnavigationcluster;
        setKeyboardNavigationCluster setkeyboardnavigationcluster2 = this.configure;
        if (setkeyboardnavigationcluster2 instanceof DigestSignatureSpi.SHA1) {
            byte[] bArr = new byte[57];
            setAutofillId.init(((DigestSignatureSpi.SHA1) setkeyboardnavigationcluster2).cca_continue, bArr);
            setkeyboardnavigationcluster = new DigestSignatureSpi.RIPEMD128(bArr, 0);
        } else {
            byte[] bArr2 = new byte[32];
            setImportantForAutofill.cca_continue(((DigestSignatureSpi.MD5) setkeyboardnavigationcluster2).Cardinal, bArr2);
            setkeyboardnavigationcluster = new DigestSignatureSpi.RIPEMD256(bArr2, 0);
        }
        return KeyUtil.Cardinal("Private Key", getAlgorithm(), setkeyboardnavigationcluster);
    }
}

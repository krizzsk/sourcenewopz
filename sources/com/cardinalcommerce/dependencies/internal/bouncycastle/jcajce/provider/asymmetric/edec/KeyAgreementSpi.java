package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import com.cardinalcommerce.p060a.BCECGOST3410PrivateKey;
import com.cardinalcommerce.p060a.JWEHeader;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.cardinalcommerce.p060a.Payload;
import com.cardinalcommerce.p060a.PrimeCertaintyCalculator;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.XMSSKeyFactorySpi;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;

public class KeyAgreementSpi extends BaseAgreementSpi {
    private XMSSKeyFactorySpi cca_continue;
    private KeyFactorySpi.ECMQV configure;
    private byte[] getWarnings;

    public static final class X25519 extends KeyAgreementSpi {
        public X25519() {
            super(XDHParameterSpec.X25519);
        }
    }

    public static final class X448 extends KeyAgreementSpi {
        public X448() {
            super(XDHParameterSpec.X448);
        }
    }

    public static final class XDH extends KeyAgreementSpi {
        public XDH() {
            super("XDH");
        }
    }

    KeyAgreementSpi(String str) {
        super(str, (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) null);
    }

    KeyAgreementSpi(String str, KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo mQVwithSHA224KDFAndSharedInfo) {
        super(str, mQVwithSHA224KDFAndSharedInfo);
    }

    private KeyFactorySpi.ECMQV getInstance(String str) throws InvalidKeyException {
        if (this.init.equals("XDH") || this.init.startsWith(str)) {
            int indexOf = this.init.indexOf(85);
            boolean startsWith = str.startsWith(XDHParameterSpec.X448);
            return indexOf > 0 ? startsWith ? new PrimeCertaintyCalculator(new SignatureSpi.ecDSA384()) : new PrimeCertaintyCalculator(new SignatureSpi.ecDSA256()) : startsWith ? new SignatureSpi.ecDSA384() : new SignatureSpi.ecDSA256();
        }
        StringBuilder sb = new StringBuilder("inappropriate key for ");
        sb.append(this.init);
        throw new InvalidKeyException(sb.toString());
    }

    public final byte[] Cardinal() {
        return this.getWarnings;
    }

    public static class X25519UwithSHA256CKDF extends KeyAgreementSpi {
        public X25519UwithSHA256CKDF() {
            super("X25519UwithSHA256CKDF", new Payload(new SignatureSpi.ecNR()));
        }
    }

    public static class X25519UwithSHA256KDF extends KeyAgreementSpi {
        public X25519UwithSHA256KDF() {
            super("X25519UwithSHA256KDF", new KeyFactorySpi.ED25519(new SignatureSpi.ecNR()));
        }
    }

    public static final class X25519withSHA256CKDF extends KeyAgreementSpi {
        public X25519withSHA256CKDF() {
            super("X25519withSHA256CKDF", new Payload(new SignatureSpi.ecNR()));
        }
    }

    public static final class X25519withSHA256KDF extends KeyAgreementSpi {
        public X25519withSHA256KDF() {
            super("X25519withSHA256KDF", new KeyFactorySpi.ED25519(new SignatureSpi.ecNR()));
        }
    }

    public static class X25519withSHA384CKDF extends KeyAgreementSpi {
        public X25519withSHA384CKDF() {
            super("X25519withSHA384CKDF", new Payload(new SignatureSpi.ecNR384()));
        }
    }

    public static class X25519withSHA512CKDF extends KeyAgreementSpi {
        public X25519withSHA512CKDF() {
            super("X25519withSHA512CKDF", new Payload(new BCECGOST3410PrivateKey()));
        }
    }

    public static class X448UwithSHA512CKDF extends KeyAgreementSpi {
        public X448UwithSHA512CKDF() {
            super("X448UwithSHA512CKDF", new Payload(new BCECGOST3410PrivateKey()));
        }
    }

    public static class X448UwithSHA512KDF extends KeyAgreementSpi {
        public X448UwithSHA512KDF() {
            super("X448UwithSHA512KDF", new KeyFactorySpi.ED25519(new BCECGOST3410PrivateKey()));
        }
    }

    public static final class X448withSHA256CKDF extends KeyAgreementSpi {
        public X448withSHA256CKDF() {
            super("X448withSHA256CKDF", new Payload(new SignatureSpi.ecNR()));
        }
    }

    public static class X448withSHA384CKDF extends KeyAgreementSpi {
        public X448withSHA384CKDF() {
            super("X448withSHA384CKDF", new Payload(new SignatureSpi.ecNR384()));
        }
    }

    public static final class X448withSHA512CKDF extends KeyAgreementSpi {
        public X448withSHA512CKDF() {
            super("X448withSHA512CKDF", new Payload(new BCECGOST3410PrivateKey()));
        }
    }

    public static final class X448withSHA512KDF extends KeyAgreementSpi {
        public X448withSHA512KDF() {
            super("X448withSHA512KDF", new KeyFactorySpi.ED25519(new BCECGOST3410PrivateKey()));
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key instanceof BCXDHPrivateKey) {
            setKeyboardNavigationCluster setkeyboardnavigationcluster = ((BCXDHPrivateKey) key).init;
            this.configure = getInstance(setkeyboardnavigationcluster instanceof PSSSignatureSpi.SHA512_256withRSA ? XDHParameterSpec.X448 : XDHParameterSpec.X25519);
            this.configure.getInstance(setkeyboardnavigationcluster);
            if (this.Cardinal != null) {
                this.getInstance = new byte[0];
            } else {
                this.getInstance = null;
            }
        } else {
            throw new InvalidKeyException("cannot identify XDH private key");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key instanceof BCXDHPrivateKey) {
            setKeyboardNavigationCluster setkeyboardnavigationcluster = ((BCXDHPrivateKey) key).init;
            this.configure = getInstance(setkeyboardnavigationcluster instanceof PSSSignatureSpi.SHA512_256withRSA ? XDHParameterSpec.X448 : XDHParameterSpec.X25519);
            this.getInstance = null;
            if (!(algorithmParameterSpec instanceof XMSSKeyFactorySpi)) {
                this.configure.getInstance(setkeyboardnavigationcluster);
                if (!(algorithmParameterSpec instanceof JWEHeader)) {
                    throw new InvalidAlgorithmParameterException("unknown ParameterSpec");
                } else if (this.Cardinal != null) {
                    this.getInstance = JWEHeader.configure();
                } else {
                    throw new InvalidAlgorithmParameterException("no KDF specified for UserKeyingMaterialSpec");
                }
            } else if (this.init.indexOf(85) >= 0) {
                this.cca_continue = (XMSSKeyFactorySpi) algorithmParameterSpec;
                this.getInstance = XMSSKeyFactorySpi.cca_continue();
                this.configure.getInstance(new PSSSignatureSpi.SHA512withRSA(setkeyboardnavigationcluster, null.init, null.cca_continue));
            } else {
                throw new InvalidAlgorithmParameterException("agreement algorithm not DHU based");
            }
            if (this.Cardinal != null && this.getInstance == null) {
                this.getInstance = new byte[0];
                return;
            }
            return;
        }
        throw new InvalidKeyException("cannot identify XDH private key");
    }

    /* access modifiers changed from: protected */
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        if (this.configure == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.init);
            sb.append(" not initialised.");
            throw new IllegalStateException(sb.toString());
        } else if (!z) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.init);
            sb2.append(" can only be between two parties.");
            throw new IllegalStateException(sb2.toString());
        } else if (key instanceof BCXDHPublicKey) {
            setKeyboardNavigationCluster setkeyboardnavigationcluster = ((BCXDHPublicKey) key).cca_continue;
            byte[] bArr = new byte[this.configure.configure()];
            this.getWarnings = bArr;
            if (this.cca_continue != null) {
                this.configure.configure(new PSSSignatureSpi.SHA3_512withRSA(setkeyboardnavigationcluster, null.cca_continue), this.getWarnings, 0);
            } else {
                this.configure.configure(setkeyboardnavigationcluster, bArr, 0);
            }
            return null;
        } else {
            throw new InvalidKeyException("cannot identify XDH private key");
        }
    }
}

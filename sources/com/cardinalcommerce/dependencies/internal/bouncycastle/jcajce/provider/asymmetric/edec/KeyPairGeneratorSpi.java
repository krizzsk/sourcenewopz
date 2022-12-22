package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec;

import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.Curve;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ExtendedInvalidKeySpecException;
import com.cardinalcommerce.p060a.GOST3410Util;
import com.cardinalcommerce.p060a.JWEAlgorithm;
import com.cardinalcommerce.p060a.JWECryptoParts;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;

public class KeyPairGeneratorSpi extends java.security.KeyPairGeneratorSpi {
    private KeyAgreementSpi.ECKAEGwithRIPEMD160KDF Cardinal;
    private boolean cca_continue;
    private SecureRandom configure;
    private int getInstance;

    public static final class Ed25519 extends KeyPairGeneratorSpi {
        public Ed25519() {
            super(1, new KeyAgreementSpi.X448withSHA512CKDF());
        }
    }

    public static final class Ed448 extends KeyPairGeneratorSpi {
        public Ed448() {
            super(0, new KeyAgreementSpi.X448withSHA512KDF());
        }
    }

    public static final class EdDSA extends KeyPairGeneratorSpi {
        public EdDSA() {
            super(-1, (KeyAgreementSpi.ECKAEGwithRIPEMD160KDF) null);
        }
    }

    public static final class X25519 extends KeyPairGeneratorSpi {
        public X25519() {
            super(3, new KeyFactorySpi.X25519());
        }
    }

    public static final class X448 extends KeyPairGeneratorSpi {
        public X448() {
            super(2, new KeyFactorySpi.X448());
        }
    }

    public static final class XDH extends KeyPairGeneratorSpi {
        public XDH() {
            super(-2, (KeyAgreementSpi.ECKAEGwithRIPEMD160KDF) null);
        }
    }

    KeyPairGeneratorSpi(int i, KeyAgreementSpi.ECKAEGwithRIPEMD160KDF eCKAEGwithRIPEMD160KDF) {
        this.getInstance = i;
        this.Cardinal = eCKAEGwithRIPEMD160KDF;
    }

    private void Cardinal(int i) {
        KeyAgreementSpi.ECKAEGwithRIPEMD160KDF eCKAEGwithRIPEMD160KDF;
        GOST3410Util pKCS1v1_5Padding_PrivateOnly;
        this.cca_continue = true;
        if (this.configure == null) {
            this.configure = new SecureRandom();
        }
        if (i != -2) {
            if (i != -1) {
                if (i == 0) {
                    eCKAEGwithRIPEMD160KDF = this.Cardinal;
                    pKCS1v1_5Padding_PrivateOnly = new DigestSignatureSpi.RIPEMD160(this.configure);
                } else if (i != 1) {
                    if (i == 2) {
                        eCKAEGwithRIPEMD160KDF = this.Cardinal;
                        pKCS1v1_5Padding_PrivateOnly = new PSSSignatureSpi.SHA384withRSA(this.configure);
                    } else if (i != 3) {
                        return;
                    }
                }
                eCKAEGwithRIPEMD160KDF.cca_continue(pKCS1v1_5Padding_PrivateOnly);
                return;
            }
            eCKAEGwithRIPEMD160KDF = this.Cardinal;
            pKCS1v1_5Padding_PrivateOnly = new CipherSpi.PKCS1v1_5Padding_PrivateOnly(this.configure);
            eCKAEGwithRIPEMD160KDF.cca_continue(pKCS1v1_5Padding_PrivateOnly);
            return;
        }
        this.Cardinal.cca_continue(new PSSSignatureSpi.SHA256withRSA(this.configure));
    }

    private void cca_continue(int i) throws InvalidAlgorithmParameterException {
        int i2 = this.getInstance;
        if (i2 == i) {
            return;
        }
        if (i2 == 1 || i2 == 0) {
            throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
        } else if (i2 != -1 || i == 1 || i == 0) {
            int i3 = this.getInstance;
            if (i3 == 3 || i3 == 2) {
                throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
            } else if (i3 != -2 || i == 3 || i == 2) {
                this.getInstance = i;
            } else {
                throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
            }
        } else {
            throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
        }
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.configure = secureRandom;
        if (i == 255 || i == 256) {
            int i2 = this.getInstance;
            if (i2 != -2) {
                if (i2 == -1 || i2 == 1) {
                    Cardinal(1);
                    return;
                } else if (i2 != 3) {
                    throw new InvalidParameterException("key size not configurable");
                }
            }
            Cardinal(3);
        } else if (i == 448) {
            int i3 = this.getInstance;
            if (i3 != -2) {
                if (i3 == -1 || i3 == 0) {
                    Cardinal(0);
                    return;
                } else if (i3 != 2) {
                    throw new InvalidParameterException("key size not configurable");
                }
            }
            Cardinal(2);
        } else {
            throw new InvalidParameterException("unknown key size");
        }
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.configure = secureRandom;
        if (algorithmParameterSpec instanceof ECGenParameterSpec) {
            configure(((ECGenParameterSpec) algorithmParameterSpec).getName());
        } else if (algorithmParameterSpec instanceof Curve) {
            configure((String) null);
        } else if (algorithmParameterSpec instanceof JWEAlgorithm) {
            configure((String) null);
        } else if (algorithmParameterSpec instanceof JWECryptoParts) {
            configure((String) null);
        } else {
            throw new InvalidAlgorithmParameterException("invalid parameterSpec: ".concat(String.valueOf(algorithmParameterSpec)));
        }
    }

    private void configure(String str) throws InvalidAlgorithmParameterException {
        if (str.equalsIgnoreCase(EdDSAParameterSpec.Ed448) || str.equals(KeyAgreementSpi.DHwithSHA256CKDF.init.init)) {
            cca_continue(0);
            this.Cardinal = new KeyAgreementSpi.X448withSHA512KDF();
            Cardinal(0);
        } else if (str.equalsIgnoreCase(EdDSAParameterSpec.Ed25519) || str.equals(KeyAgreementSpi.DHwithSHA256CKDF.Cardinal.init)) {
            cca_continue(1);
            this.Cardinal = new KeyAgreementSpi.X448withSHA512CKDF();
            Cardinal(1);
        } else if (str.equalsIgnoreCase(XDHParameterSpec.X448) || str.equals(KeyAgreementSpi.DHwithSHA256CKDF.configure.init)) {
            cca_continue(2);
            this.Cardinal = new KeyFactorySpi.X448();
            Cardinal(2);
        } else if (str.equalsIgnoreCase(XDHParameterSpec.X25519) || str.equals(KeyAgreementSpi.DHwithSHA256CKDF.cca_continue.init)) {
            cca_continue(3);
            this.Cardinal = new KeyFactorySpi.X25519();
            Cardinal(3);
        }
    }

    public KeyPair generateKeyPair() {
        if (this.Cardinal != null) {
            if (!this.cca_continue) {
                Cardinal(this.getInstance);
            }
            ExtendedInvalidKeySpecException init = this.Cardinal.init();
            int i = this.getInstance;
            if (i == 0) {
                return new KeyPair(new BCEdDSAPublicKey(init.Cardinal), new BCEdDSAPrivateKey(init.cca_continue));
            }
            if (i == 1) {
                return new KeyPair(new BCEdDSAPublicKey(init.Cardinal), new BCEdDSAPrivateKey(init.cca_continue));
            }
            if (i == 2) {
                return new KeyPair(new BCXDHPublicKey(init.Cardinal), new BCXDHPrivateKey(init.cca_continue));
            }
            if (i == 3) {
                return new KeyPair(new BCXDHPublicKey(init.Cardinal), new BCXDHPrivateKey(init.cca_continue));
            }
            throw new IllegalStateException("generator not correctly initialized");
        }
        throw new IllegalStateException("generator not correctly initialized");
    }
}

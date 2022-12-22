package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.p060a.BCRSAPrivateKey;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.Base64URL;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.Curve;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ExtendedInvalidKeySpecException;
import com.cardinalcommerce.p060a.GOST3410Util;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.NHKeyFactorySpi;
import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.Hashtable;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi */
public abstract class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH */
    public static class ECDH extends C2149EC {
        public ECDH() {
            super("ECDH", JWK.getInstance);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDHC */
    public static class ECDHC extends C2149EC {
        public ECDHC() {
            super("ECDHC", JWK.getInstance);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDSA */
    public static class ECDSA extends C2149EC {
        public ECDSA() {
            super("ECDSA", JWK.getInstance);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECMQV */
    public static class ECMQV extends C2149EC {
        public ECMQV() {
            super("ECMQV", JWK.getInstance);
        }
    }

    public KeyPairGeneratorSpi(String str) {
        super(str);
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$EC */
    public static class C2149EC extends KeyPairGeneratorSpi {
        private static Hashtable values;
        private int Cardinal = 239;
        private Object cca_continue = null;
        private String cleanup;
        private BCRSAPrivateKey configure;
        private boolean getInstance;
        private NHKeyFactorySpi getWarnings;
        private KeyAgreementSpi.X448withSHA384CKDF init = new KeyAgreementSpi.X448withSHA384CKDF();

        public C2149EC() {
            super("EC");
            KeyAgreementSpi.MQV.cca_continue();
            this.getInstance = false;
            this.cleanup = "EC";
            this.getWarnings = JWK.getInstance;
        }

        public C2149EC(String str, NHKeyFactorySpi nHKeyFactorySpi) {
            super(str);
            KeyAgreementSpi.MQV.cca_continue();
            this.getInstance = false;
            this.cleanup = str;
            this.getWarnings = nHKeyFactorySpi;
        }

        private static BCRSAPrivateKey init(ECParameterSpec eCParameterSpec, SecureRandom secureRandom) {
            getSDKAppID Cardinal2 = EC5Util.Cardinal(eCParameterSpec.getCurve());
            return new BCRSAPrivateKey(new BCRSAPublicKey(Cardinal2, EC5Util.init(Cardinal2, eCParameterSpec.getGenerator()), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor())), secureRandom);
        }

        public void initialize(int i, SecureRandom secureRandom) {
            this.Cardinal = i;
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) values.get(Integer.valueOf(i));
            if (eCGenParameterSpec != null) {
                try {
                    initialize(eCGenParameterSpec, secureRandom);
                } catch (InvalidAlgorithmParameterException unused) {
                    throw new InvalidParameterException("key size not configurable.");
                }
            } else {
                throw new InvalidParameterException("unknown key size.");
            }
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec == null) {
                Container cca_continue2 = this.getWarnings.cca_continue();
                if (cca_continue2 != null) {
                    this.cca_continue = null;
                    this.configure = new BCRSAPrivateKey(new BCRSAPublicKey(cca_continue2.init, cca_continue2.Cardinal, cca_continue2.getInstance, cca_continue2.cca_continue), secureRandom);
                } else {
                    throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
                }
            } else if (algorithmParameterSpec instanceof Container) {
                this.cca_continue = algorithmParameterSpec;
                Container container = (Container) algorithmParameterSpec;
                this.configure = new BCRSAPrivateKey(new BCRSAPublicKey(container.init, container.Cardinal, container.getInstance, container.cca_continue), secureRandom);
            } else if (algorithmParameterSpec instanceof ECParameterSpec) {
                this.cca_continue = algorithmParameterSpec;
                this.configure = init((ECParameterSpec) algorithmParameterSpec, secureRandom);
            } else if (algorithmParameterSpec instanceof ECGenParameterSpec) {
                Base64URL Cardinal2 = Cardinal(((ECGenParameterSpec) algorithmParameterSpec).getName());
                this.cca_continue = Cardinal2;
                this.configure = init(Cardinal2, secureRandom);
            } else if (algorithmParameterSpec instanceof Curve) {
                Base64URL Cardinal3 = Cardinal((String) null);
                this.cca_continue = Cardinal3;
                this.configure = init(Cardinal3, secureRandom);
            } else {
                throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec");
            }
            this.init.cca_continue(this.configure);
            this.getInstance = true;
        }

        public KeyPair generateKeyPair() {
            if (!this.getInstance) {
                initialize(this.Cardinal, new SecureRandom());
            }
            ExtendedInvalidKeySpecException init2 = this.init.init();
            DigestSignatureSpi digestSignatureSpi = (DigestSignatureSpi) init2.Cardinal;
            DigestSignatureSpi.MD2 md2 = (DigestSignatureSpi.MD2) init2.cca_continue;
            Object obj = this.cca_continue;
            if (obj instanceof Container) {
                Container container = (Container) obj;
                BCECPublicKey bCECPublicKey = new BCECPublicKey(this.cleanup, digestSignatureSpi, container, this.getWarnings);
                return new KeyPair(bCECPublicKey, new BCECPrivateKey(this.cleanup, md2, bCECPublicKey, container, this.getWarnings));
            } else if (obj == null) {
                return new KeyPair(new BCECPublicKey(this.cleanup, digestSignatureSpi, this.getWarnings), new BCECPrivateKey(this.cleanup, md2, this.getWarnings));
            } else {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
                BCECPublicKey bCECPublicKey2 = new BCECPublicKey(this.cleanup, digestSignatureSpi, eCParameterSpec, this.getWarnings);
                return new KeyPair(bCECPublicKey2, new BCECPrivateKey(this.cleanup, md2, bCECPublicKey2, eCParameterSpec, this.getWarnings));
            }
        }

        private Base64URL Cardinal(String str) throws InvalidAlgorithmParameterException {
            KeyAgreementSpi.C1970DH configure2 = GOST3410Util.configure(str);
            if (configure2 == null) {
                try {
                    configure2 = IESCipher.ECIESwithCipher.configure(new ASN1ObjectIdentifier(str));
                    if (configure2 == null) {
                        configure2 = (KeyAgreementSpi.C1970DH) this.getWarnings.Cardinal().get(new ASN1ObjectIdentifier(str));
                        if (configure2 == null) {
                            throw new InvalidAlgorithmParameterException("unknown curve OID: ".concat(String.valueOf(str)));
                        }
                    }
                } catch (IllegalArgumentException unused) {
                    throw new InvalidAlgorithmParameterException("unknown curve name: ".concat(String.valueOf(str)));
                }
            }
            return new Base64URL(str, configure2.cca_continue, configure2.getInstance.cca_continue(), configure2.Cardinal, configure2.init, (byte[]) null);
        }

        static {
            Hashtable hashtable = new Hashtable();
            values = hashtable;
            hashtable.put(192, new ECGenParameterSpec("prime192v1"));
            values.put(239, new ECGenParameterSpec("prime239v1"));
            values.put(256, new ECGenParameterSpec("prime256v1"));
            values.put(224, new ECGenParameterSpec("P-224"));
            values.put(384, new ECGenParameterSpec("P-384"));
            values.put(521, new ECGenParameterSpec("P-521"));
        }
    }
}

package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p062dh;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import com.cardinalcommerce.p060a.BCElGamalPublicKey;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.ExtendedInvalidKeySpecException;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.Sphincs256KeyFactorySpi;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyPairGeneratorSpi */
public class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: a */
    private static Hashtable f3146a = new Hashtable();

    /* renamed from: b */
    private static Object f3147b = new Object();

    /* renamed from: c */
    private SignatureSpi.Ed25519 f3148c;

    /* renamed from: d */
    private KeyAgreementSpi.X25519 f3149d = new KeyAgreementSpi.X25519();

    /* renamed from: e */
    private int f3150e = 2048;

    /* renamed from: f */
    private SecureRandom f3151f = KeyAgreementSpi.MQV.cca_continue();

    /* renamed from: g */
    private boolean f3152g = false;

    public KeyPairGeneratorSpi() {
        super("DH");
    }

    /* renamed from: a */
    private static SignatureSpi.Ed25519 m2189a(SecureRandom secureRandom, DHParameterSpec dHParameterSpec) {
        return dHParameterSpec instanceof Sphincs256KeyFactorySpi ? new SignatureSpi.Ed25519(secureRandom, ((Sphincs256KeyFactorySpi) dHParameterSpec).init()) : new SignatureSpi.Ed25519(secureRandom, new CipherSpi(dHParameterSpec.getP(), dHParameterSpec.getG(), dHParameterSpec.getL()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.f3150e = i;
        this.f3151f = secureRandom;
        this.f3152g = false;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            try {
                SignatureSpi.Ed25519 a = m2189a(secureRandom, (DHParameterSpec) algorithmParameterSpec);
                this.f3148c = a;
                this.f3149d.init = a;
                this.f3152g = true;
            } catch (IllegalArgumentException e) {
                throw new InvalidAlgorithmParameterException(e.getMessage(), e);
            }
        } else {
            throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
        }
    }

    public KeyPair generateKeyPair() {
        SignatureSpi.Ed25519 a;
        if (!this.f3152g) {
            Integer valueOf = Integer.valueOf(this.f3150e);
            if (f3146a.containsKey(valueOf)) {
                a = (SignatureSpi.Ed25519) f3146a.get(valueOf);
            } else {
                DHParameterSpec init = JWK.getInstance.init(this.f3150e);
                if (init != null) {
                    a = m2189a(this.f3151f, init);
                } else {
                    synchronized (f3147b) {
                        if (f3146a.containsKey(valueOf)) {
                            this.f3148c = (SignatureSpi.Ed25519) f3146a.get(valueOf);
                        } else {
                            KeyAgreementSpi.X448 x448 = new KeyAgreementSpi.X448();
                            int i = this.f3150e;
                            int init2 = PrimeCertaintyCalculator.init(this.f3150e);
                            SecureRandom secureRandom = this.f3151f;
                            x448.getInstance = i;
                            x448.Cardinal = init2;
                            x448.init = secureRandom;
                            SignatureSpi.Ed25519 ed25519 = new SignatureSpi.Ed25519(this.f3151f, x448.Cardinal());
                            this.f3148c = ed25519;
                            f3146a.put(valueOf, ed25519);
                        }
                    }
                    this.f3149d.init = this.f3148c;
                    this.f3152g = true;
                }
            }
            this.f3148c = a;
            this.f3149d.init = this.f3148c;
            this.f3152g = true;
        }
        ExtendedInvalidKeySpecException init3 = this.f3149d.init();
        return new KeyPair(new BCDHPublicKey((CipherSpi.PKCS1v1_5Padding) init3.Cardinal), new BCDHPrivateKey((BCElGamalPublicKey) init3.cca_continue));
    }
}

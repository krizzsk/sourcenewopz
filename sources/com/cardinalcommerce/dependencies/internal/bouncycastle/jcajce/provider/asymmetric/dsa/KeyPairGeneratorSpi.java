package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import com.cardinalcommerce.p060a.AlgorithmParametersSpi;
import com.cardinalcommerce.p060a.BCGOST3410PrivateKey;
import com.cardinalcommerce.p060a.BCGOST3410PublicKey;
import com.cardinalcommerce.p060a.ExtendedInvalidKeySpecException;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.setDrawingCacheEnabled;
import com.cardinalcommerce.p060a.setMinimumHeight;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.util.Hashtable;

public class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: a */
    private static Hashtable f3157a = new Hashtable();

    /* renamed from: b */
    private static Object f3158b = new Object();

    /* renamed from: c */
    private AlgorithmParametersSpi.OAEP f3159c;

    /* renamed from: d */
    private KeyAgreementSpi.X25519withSHA512CKDF f3160d = new KeyAgreementSpi.X25519withSHA512CKDF();

    /* renamed from: e */
    private int f3161e = 2048;

    /* renamed from: f */
    private SecureRandom f3162f = KeyAgreementSpi.MQV.cca_continue();

    /* renamed from: g */
    private boolean f3163g = false;

    public KeyPairGeneratorSpi() {
        super("DSA");
    }

    public void initialize(int i, SecureRandom secureRandom) {
        boolean z;
        if (i < 512 || i > 4096 || ((i < 1024 && i % 64 != 0) || (i >= 1024 && i % 1024 != 0))) {
            throw new InvalidParameterException("strength must be from 512 - 4096 and a multiple of 1024 above 1024");
        }
        DSAParameterSpec cca_continue = JWK.getInstance.cca_continue(i);
        if (cca_continue != null) {
            AlgorithmParametersSpi.OAEP oaep = new AlgorithmParametersSpi.OAEP(secureRandom, new BCGOST3410PublicKey(cca_continue.getP(), cca_continue.getQ(), cca_continue.getG()));
            this.f3159c = oaep;
            this.f3160d.configure = oaep;
            z = true;
        } else {
            this.f3161e = i;
            this.f3162f = secureRandom;
            z = false;
        }
        this.f3163g = z;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DSAParameterSpec) {
            DSAParameterSpec dSAParameterSpec = (DSAParameterSpec) algorithmParameterSpec;
            AlgorithmParametersSpi.OAEP oaep = new AlgorithmParametersSpi.OAEP(secureRandom, new BCGOST3410PublicKey(dSAParameterSpec.getP(), dSAParameterSpec.getQ(), dSAParameterSpec.getG()));
            this.f3159c = oaep;
            this.f3160d.configure = oaep;
            this.f3163g = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DSAParameterSpec");
    }

    public KeyPair generateKeyPair() {
        KeyAgreementSpi.X25519withSHA384CKDF x25519withSHA384CKDF;
        int i;
        SecureRandom secureRandom;
        if (!this.f3163g) {
            Integer valueOf = Integer.valueOf(this.f3161e);
            if (f3157a.containsKey(valueOf)) {
                this.f3159c = (AlgorithmParametersSpi.OAEP) f3157a.get(valueOf);
            } else {
                synchronized (f3158b) {
                    if (f3157a.containsKey(valueOf)) {
                        this.f3159c = (AlgorithmParametersSpi.OAEP) f3157a.get(valueOf);
                    } else {
                        int init = PrimeCertaintyCalculator.init(this.f3161e);
                        if (this.f3161e == 1024) {
                            x25519withSHA384CKDF = new KeyAgreementSpi.X25519withSHA384CKDF();
                            if (setMinimumHeight.Cardinal("org.bouncycastle.dsa.FIPS186-2for1024bits")) {
                                i = this.f3161e;
                                secureRandom = this.f3162f;
                            } else {
                                x25519withSHA384CKDF.getInstance(new setDrawingCacheEnabled(1024, 160, init, this.f3162f, (byte) 0));
                                AlgorithmParametersSpi.OAEP oaep = new AlgorithmParametersSpi.OAEP(this.f3162f, x25519withSHA384CKDF.configure());
                                this.f3159c = oaep;
                                f3157a.put(valueOf, oaep);
                            }
                        } else if (this.f3161e > 1024) {
                            setDrawingCacheEnabled setdrawingcacheenabled = new setDrawingCacheEnabled(this.f3161e, 256, init, this.f3162f, (byte) 0);
                            KeyAgreementSpi.X25519withSHA384CKDF x25519withSHA384CKDF2 = new KeyAgreementSpi.X25519withSHA384CKDF(new SignatureSpi.ecNR());
                            x25519withSHA384CKDF2.getInstance(setdrawingcacheenabled);
                            x25519withSHA384CKDF = x25519withSHA384CKDF2;
                            AlgorithmParametersSpi.OAEP oaep2 = new AlgorithmParametersSpi.OAEP(this.f3162f, x25519withSHA384CKDF.configure());
                            this.f3159c = oaep2;
                            f3157a.put(valueOf, oaep2);
                        } else {
                            x25519withSHA384CKDF = new KeyAgreementSpi.X25519withSHA384CKDF();
                            i = this.f3161e;
                            secureRandom = this.f3162f;
                        }
                        x25519withSHA384CKDF.Cardinal(i, init, secureRandom);
                        AlgorithmParametersSpi.OAEP oaep22 = new AlgorithmParametersSpi.OAEP(this.f3162f, x25519withSHA384CKDF.configure());
                        this.f3159c = oaep22;
                        f3157a.put(valueOf, oaep22);
                    }
                }
            }
            this.f3160d.configure = this.f3159c;
            this.f3163g = true;
        }
        ExtendedInvalidKeySpecException init2 = this.f3160d.init();
        return new KeyPair(new BCDSAPublicKey((BCGOST3410PrivateKey) init2.Cardinal), new BCDSAPrivateKey((AlgorithmParametersSpi.PSS) init2.cca_continue));
    }
}

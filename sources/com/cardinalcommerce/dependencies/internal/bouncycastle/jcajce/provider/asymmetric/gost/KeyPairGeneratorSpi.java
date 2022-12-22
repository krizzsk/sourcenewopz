package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.gost;

import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ExtendedInvalidKeySpecException;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.ProtocolErrorEvent;
import com.cardinalcommerce.p060a.setErrorCode;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: a */
    private DigestSignatureSpi.SHA512 f3204a;

    /* renamed from: b */
    private KeyFactorySpi.ED448 f3205b = new KeyFactorySpi.ED448();

    /* renamed from: c */
    private ProtocolErrorEvent f3206c;

    /* renamed from: d */
    private boolean f3207d = false;

    public KeyPairGeneratorSpi() {
        super("GOST3410");
    }

    public void initialize(int i, SecureRandom secureRandom) {
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof ProtocolErrorEvent) {
            m2200a((ProtocolErrorEvent) algorithmParameterSpec, secureRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a GOST3410ParameterSpec");
    }

    /* renamed from: a */
    private void m2200a(ProtocolErrorEvent protocolErrorEvent, SecureRandom secureRandom) {
        setErrorCode seterrorcode = protocolErrorEvent.cca_continue;
        DigestSignatureSpi.SHA512 sha512 = new DigestSignatureSpi.SHA512(secureRandom, new DigestSignatureSpi.SHA512_256(seterrorcode.configure, seterrorcode.init, seterrorcode.getInstance));
        this.f3204a = sha512;
        this.f3205b.Cardinal = sha512;
        this.f3207d = true;
        this.f3206c = protocolErrorEvent;
    }

    public KeyPair generateKeyPair() {
        if (!this.f3207d) {
            m2200a(new ProtocolErrorEvent(KeyAgreementSpi.DHUwithSHA512CKDF.CardinalActionCode.init), KeyAgreementSpi.MQV.cca_continue());
        }
        ExtendedInvalidKeySpecException init = this.f3205b.init();
        return new KeyPair(new BCGOST3410PublicKey((DigestSignatureSpi.SHA3_384) init.Cardinal, this.f3206c), new BCGOST3410PrivateKey((DigestSignatureSpi.SHA512_224) init.cca_continue, this.f3206c));
    }
}

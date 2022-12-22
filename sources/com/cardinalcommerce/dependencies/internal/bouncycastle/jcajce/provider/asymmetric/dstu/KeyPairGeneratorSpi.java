package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.p060a.BCRSAPrivateCrtKey;
import com.cardinalcommerce.p060a.BCRSAPrivateKey;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.Base64URL;
import com.cardinalcommerce.p060a.ChallengeParameters;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.Curve;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ExtendedInvalidKeySpecException;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.PemReader;
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

public class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: a */
    private Object f3164a = null;

    /* renamed from: b */
    private KeyAgreementSpi.X448withSHA384CKDF f3165b = new KeyAgreementSpi.X448UwithSHA512KDF();

    /* renamed from: c */
    private String f3166c = "DSTU4145";

    /* renamed from: d */
    private BCRSAPrivateKey f3167d;

    /* renamed from: e */
    private boolean f3168e = false;

    public KeyPairGeneratorSpi() {
        super("DSTU4145");
    }

    public void initialize(int i, SecureRandom secureRandom) {
        Object obj = this.f3164a;
        if (obj != null) {
            try {
                initialize((ECGenParameterSpec) obj, secureRandom);
            } catch (InvalidAlgorithmParameterException unused) {
                throw new InvalidParameterException("key size not configurable.");
            }
        } else {
            throw new InvalidParameterException("unknown key size.");
        }
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof Container) {
            Container container = (Container) algorithmParameterSpec;
            this.f3164a = algorithmParameterSpec;
            BCRSAPrivateKey bCRSAPrivateKey = new BCRSAPrivateKey(new BCRSAPublicKey(container.init, container.Cardinal, container.getInstance, container.cca_continue), secureRandom);
            this.f3167d = bCRSAPrivateKey;
            this.f3165b.cca_continue(bCRSAPrivateKey);
            this.f3168e = true;
        } else if (algorithmParameterSpec instanceof ECParameterSpec) {
            ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
            this.f3164a = algorithmParameterSpec;
            getSDKAppID Cardinal = EC5Util.Cardinal(eCParameterSpec.getCurve());
            ChallengeParameters init = EC5Util.init(Cardinal, eCParameterSpec.getGenerator());
            this.f3167d = eCParameterSpec instanceof PemReader ? new BCRSAPrivateKey(new BCRSAPrivateCrtKey(new BCRSAPublicKey(Cardinal, init, eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor())), PemReader.getInstance()), secureRandom) : new BCRSAPrivateKey(new BCRSAPublicKey(Cardinal, init, eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor())), secureRandom);
            this.f3165b.cca_continue(this.f3167d);
            this.f3168e = true;
        } else {
            boolean z = algorithmParameterSpec instanceof ECGenParameterSpec;
            if (z || (algorithmParameterSpec instanceof Curve)) {
                String name = z ? ((ECGenParameterSpec) algorithmParameterSpec).getName() : null;
                BCRSAPublicKey init2 = DSASigner.detDSASha3_512.init(new ASN1ObjectIdentifier(name));
                if (init2 != null) {
                    Base64URL base64URL = new Base64URL(name, init2.Cardinal, init2.init, init2.cca_continue, init2.getInstance, init2.init());
                    this.f3164a = base64URL;
                    ECParameterSpec eCParameterSpec2 = base64URL;
                    getSDKAppID Cardinal2 = EC5Util.Cardinal(eCParameterSpec2.getCurve());
                    BCRSAPrivateKey bCRSAPrivateKey2 = new BCRSAPrivateKey(new BCRSAPublicKey(Cardinal2, EC5Util.init(Cardinal2, eCParameterSpec2.getGenerator()), eCParameterSpec2.getOrder(), BigInteger.valueOf((long) eCParameterSpec2.getCofactor())), secureRandom);
                    this.f3167d = bCRSAPrivateKey2;
                    this.f3165b.cca_continue(bCRSAPrivateKey2);
                    this.f3168e = true;
                    return;
                }
                throw new InvalidAlgorithmParameterException("unknown curve name: ".concat(String.valueOf(name)));
            } else if (algorithmParameterSpec == null && JWK.getInstance.cca_continue() != null) {
                Container cca_continue = JWK.getInstance.cca_continue();
                this.f3164a = algorithmParameterSpec;
                BCRSAPrivateKey bCRSAPrivateKey3 = new BCRSAPrivateKey(new BCRSAPublicKey(cca_continue.init, cca_continue.Cardinal, cca_continue.getInstance, cca_continue.cca_continue), secureRandom);
                this.f3167d = bCRSAPrivateKey3;
                this.f3165b.cca_continue(bCRSAPrivateKey3);
                this.f3168e = true;
            } else if (algorithmParameterSpec == null && JWK.getInstance.cca_continue() == null) {
                throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
            } else {
                StringBuilder sb = new StringBuilder("parameter object not a ECParameterSpec: ");
                sb.append(algorithmParameterSpec.getClass().getName());
                throw new InvalidAlgorithmParameterException(sb.toString());
            }
        }
    }

    public KeyPair generateKeyPair() {
        if (this.f3168e) {
            ExtendedInvalidKeySpecException init = this.f3165b.init();
            DigestSignatureSpi digestSignatureSpi = (DigestSignatureSpi) init.Cardinal;
            DigestSignatureSpi.MD2 md2 = (DigestSignatureSpi.MD2) init.cca_continue;
            Object obj = this.f3164a;
            if (obj instanceof Container) {
                Container container = (Container) obj;
                BCDSTU4145PublicKey bCDSTU4145PublicKey = new BCDSTU4145PublicKey(this.f3166c, digestSignatureSpi, container);
                return new KeyPair(bCDSTU4145PublicKey, new BCDSTU4145PrivateKey(this.f3166c, md2, bCDSTU4145PublicKey, container));
            } else if (obj == null) {
                return new KeyPair(new BCDSTU4145PublicKey(this.f3166c, digestSignatureSpi), new BCDSTU4145PrivateKey(this.f3166c, md2));
            } else {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
                BCDSTU4145PublicKey bCDSTU4145PublicKey2 = new BCDSTU4145PublicKey(this.f3166c, digestSignatureSpi, eCParameterSpec);
                return new KeyPair(bCDSTU4145PublicKey2, new BCDSTU4145PrivateKey(this.f3166c, md2, bCDSTU4145PublicKey2, eCParameterSpec));
            }
        } else {
            throw new IllegalStateException("DSTU Key Pair Generator not initialised");
        }
    }
}

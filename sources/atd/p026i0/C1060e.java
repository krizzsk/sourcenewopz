package atd.p026i0;

import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import javax.crypto.KeyAgreement;

/* renamed from: atd.i0.e */
public final class C1060e {
    static {
        C1172a.m764a(-702876146289326L);
        C1172a.m764a(-702889031191214L);
    }

    /* renamed from: a */
    public static ECPublicKey m452a(C1057d dVar, BigInteger bigInteger, BigInteger bigInteger2) {
        try {
            return (ECPublicKey) KeyFactory.getInstance(C1172a.m764a(-702816016747182L)).generatePublic(new ECPublicKeySpec(new ECPoint(bigInteger, bigInteger2), dVar.mo13787b()));
        } catch (GeneralSecurityException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    /* renamed from: a */
    public static ECPrivateKey m451a(C1057d dVar, BigInteger bigInteger) {
        try {
            return (ECPrivateKey) KeyFactory.getInstance(C1172a.m764a(-702828901649070L)).generatePrivate(new ECPrivateKeySpec(bigInteger, dVar.mo13787b()));
        } catch (GeneralSecurityException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    /* renamed from: a */
    public static KeyPair m450a(C1057d dVar) {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(C1172a.m764a(-702841786550958L));
            instance.initialize(dVar.mo13787b(), new SecureRandom());
            return instance.generateKeyPair();
        } catch (GeneralSecurityException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    /* renamed from: a */
    public static byte[] m453a(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) {
        try {
            KeyAgreement instance = KeyAgreement.getInstance(C1172a.m764a(-702854671452846L));
            instance.init(eCPrivateKey);
            instance.doPhase(eCPublicKey, true);
            return instance.generateSecret();
        } catch (GeneralSecurityException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }
}

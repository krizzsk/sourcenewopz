package atd.p026i0;

import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/* renamed from: atd.i0.g */
public final class C1062g {
    static {
        C1172a.m764a(-705607745489582L);
    }

    /* renamed from: a */
    public static RSAPrivateKey m458a(BigInteger bigInteger, BigInteger bigInteger2) {
        try {
            return (RSAPrivateKey) KeyFactory.getInstance(C1172a.m764a(-705573385751214L)).generatePrivate(new RSAPrivateKeySpec(bigInteger, bigInteger2));
        } catch (GeneralSecurityException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    /* renamed from: b */
    public static RSAPublicKey m459b(BigInteger bigInteger, BigInteger bigInteger2) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(C1172a.m764a(-705556205882030L)).generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
        } catch (GeneralSecurityException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }
}

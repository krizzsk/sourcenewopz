package atd.p016d0;

import atd.p014c0.C0972b;
import atd.p014c0.C0974d;
import atd.p020f0.C1028f;
import atd.p022g0.C1033b;
import atd.p022g0.C1035d;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import com.adyen.threeds2.exception.SDKRuntimeException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* renamed from: atd.d0.h */
final class C1011h extends C1008e {

    /* renamed from: a */
    private static final OAEPParameterSpec f268a = new OAEPParameterSpec(C1172a.m764a(-699045035461294L), C1172a.m764a(-699079395199662L), MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);

    static {
        C1172a.m764a(-698825992129198L);
        C1172a.m764a(-698881826704046L);
    }

    C1011h() {
    }

    /* renamed from: a */
    public String mo13603a() {
        return C1172a.m764a(-698606948797102L);
    }

    /* renamed from: a */
    public C0974d mo13730a(C1028f fVar, C1033b bVar) {
        C1033b.m372a(bVar, C1035d.class);
        return mo13733a(fVar.mo13750e());
    }

    /* renamed from: a */
    public C0974d mo13733a(C0972b bVar) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(bVar.mo13614e());
            instance.init(bVar.mo13615f());
            return new C0974d(instance.generateKey(), bVar);
        } catch (NoSuchAlgorithmException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    /* renamed from: a */
    public byte[] mo13732a(C0974d dVar, RSAPublicKey rSAPublicKey) throws SDKRuntimeException {
        try {
            Cipher instance = Cipher.getInstance(C1172a.m764a(-698662783371950L));
            instance.init(3, rSAPublicKey, f268a);
            return instance.wrap(dVar);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }
}

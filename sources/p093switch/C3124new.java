package p093switch;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: switch.new */
/* compiled from: CryptoUtils */
public class C3124new {
    /* renamed from: do */
    public static byte[] m4036do(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.reset();
        return instance.digest(bArr);
    }
}

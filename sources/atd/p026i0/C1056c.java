package atd.p026i0;

import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import com.adyen.threeds2.internal.C1395b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* renamed from: atd.i0.c */
public final class C1056c {
    /* renamed from: a */
    public static byte[] m444a(byte[] bArr, int i, String str, String str2, String str3) {
        byte[] a = m442a(1);
        byte[] a2 = m443a(str);
        byte[] a3 = m443a(str2);
        byte[] a4 = m443a(str3);
        byte[] a5 = m442a(i);
        byte[] bArr2 = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(a);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(a2);
            byteArrayOutputStream.write(a3);
            byteArrayOutputStream.write(a4);
            byteArrayOutputStream.write(a5);
            byteArrayOutputStream.write(bArr2);
            try {
                MessageDigest instance = MessageDigest.getInstance(C1172a.m764a(-700797382118062L));
                instance.update(byteArrayOutputStream.toByteArray());
                return Arrays.copyOf(instance.digest(), i / 8);
            } catch (NoSuchAlgorithmException e) {
                throw C1225c.CRYPTO_FAILURE.mo13983a(e);
            }
        } catch (IOException e2) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e2);
        }
    }

    /* renamed from: a */
    private static byte[] m443a(String str) {
        if (str == null) {
            str = C1172a.m764a(-700831741856430L);
        }
        return ByteBuffer.allocate(str.length() + 4).putInt(str.length()).put(str.getBytes(C1395b.f995a)).array();
    }

    /* renamed from: a */
    private static byte[] m442a(int i) {
        return ByteBuffer.allocate(4).putInt(i).array();
    }
}

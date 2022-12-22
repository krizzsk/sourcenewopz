package atd.p026i0;

import atd.p046s0.C1172a;
import java.math.BigInteger;
import java.util.Arrays;

/* renamed from: atd.i0.b */
public final class C1055b {
    /* renamed from: a */
    public static BigInteger m440a(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    /* renamed from: a */
    public static byte[] m441a(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            byte[] byteArray = bigInteger.toByteArray();
            return (bigInteger.bitLength() % 8 == 0 && byteArray[0] == 0 && byteArray.length > 1) ? Arrays.copyOfRange(byteArray, 1, byteArray.length) : byteArray;
        }
        throw new IllegalArgumentException(C1172a.m764a(-700475259570862L));
    }
}

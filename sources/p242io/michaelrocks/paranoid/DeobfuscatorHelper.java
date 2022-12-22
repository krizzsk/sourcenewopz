package p242io.michaelrocks.paranoid;

import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: io.michaelrocks.paranoid.DeobfuscatorHelper */
public class DeobfuscatorHelper {
    public static final int MAX_CHUNK_LENGTH = 8191;

    private DeobfuscatorHelper() {
    }

    public static String getString(long j, String[] strArr) {
        long next = RandomHelper.next(RandomHelper.seed(InternalZipConstants.ZIP_64_SIZE_LIMIT & j));
        long next2 = RandomHelper.next(next);
        int i = (int) (((j >>> 32) ^ ((next >>> 32) & 65535)) ^ ((next2 >>> 16) & -65536));
        long a = m41772a(i, strArr, next2);
        int i2 = (int) ((a >>> 32) & 65535);
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            a = m41772a(i + i3 + 1, strArr, a);
            cArr[i3] = (char) ((int) ((a >>> 32) & 65535));
        }
        return new String(cArr);
    }

    /* renamed from: a */
    private static long m41772a(int i, String[] strArr, long j) {
        return (((long) strArr[i / 8191].charAt(i % 8191)) << 32) ^ RandomHelper.next(j);
    }
}

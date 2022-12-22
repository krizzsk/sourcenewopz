package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.data;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.data.CRC64 */
public final class CRC64 {
    private static final long[] LOOKUPTABLE = new long[256];
    private static final long POLY64REV = -2882303761517117440L;

    static {
        for (int i = 0; i < 256; i++) {
            long j = (long) i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j & 1) == 1 ? (j >>> 1) ^ POLY64REV : j >>> 1;
            }
            LOOKUPTABLE[i] = j;
        }
    }

    public static long checksum(byte[] bArr) {
        long j = 0;
        for (byte b : bArr) {
            j = (j >>> 8) ^ LOOKUPTABLE[(b ^ ((int) j)) & 255];
        }
        return j;
    }

    private CRC64() {
    }
}

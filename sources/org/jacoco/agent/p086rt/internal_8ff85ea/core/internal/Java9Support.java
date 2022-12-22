package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.Java9Support */
public final class Java9Support {
    public static final int V1_9 = 53;

    private Java9Support() {
    }

    public static byte[] readFully(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void putShort(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >>> 8);
        bArr[i + 1] = (byte) i2;
    }

    private static short readShort(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public static boolean isPatchRequired(byte[] bArr) {
        return readShort(bArr, 6) == 53;
    }

    public static byte[] downgradeIfRequired(byte[] bArr) {
        return isPatchRequired(bArr) ? downgrade(bArr) : bArr;
    }

    public static byte[] downgrade(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        putShort(bArr2, 6, 52);
        return bArr2;
    }

    public static void upgrade(byte[] bArr) {
        putShort(bArr, 6, 53);
    }
}

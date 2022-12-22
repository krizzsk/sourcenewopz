package com.cardinalcommerce.dependencies.internal.nimbusds.jose.util;

import com.cardinalcommerce.p060a.setIndeterminateDrawable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteUtils {
    public static byte[] getInstance(byte[]... bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte[] bArr2 : bArr) {
                if (bArr2 != null) {
                    byteArrayOutputStream.write(bArr2);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public static byte[] getInstance(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static int configure(int i) throws setIndeterminateDrawable {
        long j = ((long) i) << 3;
        int i2 = (int) j;
        if (((long) i2) == j) {
            return i2;
        }
        throw new setIndeterminateDrawable();
    }

    public static int configure(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length << 3;
    }

    public static int Cardinal(byte[] bArr) throws setIndeterminateDrawable {
        if (bArr == null) {
            return 0;
        }
        long length = ((long) bArr.length) << 3;
        int i = (int) length;
        if (((long) i) == length) {
            return i;
        }
        throw new setIndeterminateDrawable();
    }

    public static int init(int i) {
        return i / 8;
    }
}

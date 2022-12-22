package com.didi.sdk.store.util;

import java.nio.ByteBuffer;

public class ByteUtils {

    /* renamed from: a */
    private static ByteBuffer f37546a = ByteBuffer.allocate(8);

    public static byte[] longToBytes(long j) {
        f37546a.putLong(0, j);
        return f37546a.array();
    }

    public static long bytesToLong(byte[] bArr) {
        f37546a.put(bArr, 0, bArr.length);
        f37546a.flip();
        return f37546a.getLong();
    }
}

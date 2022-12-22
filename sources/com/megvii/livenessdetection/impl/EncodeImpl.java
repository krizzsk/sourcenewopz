package com.megvii.livenessdetection.impl;

import android.util.Base64;

public class EncodeImpl {
    private static native String nativeEncode(byte[] bArr, boolean z, boolean z2, int i, String str);

    /* renamed from: a */
    public static byte[] m40188a(byte[] bArr, boolean z, boolean z2, int i, String str) {
        String nativeEncode;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        if (!z && !z2 && str == null) {
            return bArr;
        }
        if (i >= 0 && (nativeEncode = nativeEncode(bArr, z, z2, i, str)) != null) {
            return Base64.decode(nativeEncode, 0);
        }
        return null;
    }

    /* renamed from: a */
    public static byte[] m40187a(byte[] bArr, boolean z, boolean z2, int i) {
        return m40188a(bArr, z, z2, i, (String) null);
    }
}

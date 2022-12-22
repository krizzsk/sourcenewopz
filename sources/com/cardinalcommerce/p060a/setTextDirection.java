package com.cardinalcommerce.p060a;

import java.io.ByteArrayOutputStream;

/* renamed from: com.cardinalcommerce.a.setTextDirection */
public final class setTextDirection {

    /* renamed from: a */
    private static final setNestedScrollingEnabled f3013a = new setScrollCaptureCallback();

    public static byte[] configure(byte[] bArr) {
        return init(bArr, 0, bArr.length);
    }

    public static byte[] getInstance(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f3013a.Cardinal(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("exception decoding Hex string: ");
            sb.append(e.getMessage());
            throw new setPointerIcon(sb.toString(), e);
        }
    }

    public static byte[] init(byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f3013a.configure(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("exception encoding Hex string: ");
            sb.append(e.getMessage());
            throw new setOverScrollMode(sb.toString(), e);
        }
    }

    public static String cca_continue(byte[] bArr) {
        return setAnimation.cca_continue(init(bArr, 0, bArr.length));
    }
}

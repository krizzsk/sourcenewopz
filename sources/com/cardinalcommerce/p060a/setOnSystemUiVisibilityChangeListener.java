package com.cardinalcommerce.p060a;

import java.io.ByteArrayOutputStream;

/* renamed from: com.cardinalcommerce.a.setOnSystemUiVisibilityChangeListener */
public final class setOnSystemUiVisibilityChangeListener {

    /* renamed from: a */
    private static final setNestedScrollingEnabled f2908a = new setTextAlignment();

    /* renamed from: a */
    private static byte[] m2048a(byte[] bArr, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((i + 2) / 3) << 2);
        try {
            f2908a.configure(bArr, 0, i, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("exception encoding base64 string: ");
            sb.append(e.getMessage());
            throw new setOverScrollMode(sb.toString(), e);
        }
    }

    public static byte[] cca_continue(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() / 4) * 3);
        try {
            f2908a.Cardinal(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("unable to decode base64 string: ");
            sb.append(e.getMessage());
            throw new setPointerIcon(sb.toString(), e);
        }
    }

    public static byte[] cca_continue(byte[] bArr) {
        return m2048a(bArr, bArr.length);
    }
}

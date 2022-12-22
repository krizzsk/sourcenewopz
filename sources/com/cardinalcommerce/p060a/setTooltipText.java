package com.cardinalcommerce.p060a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cardinalcommerce.a.setTooltipText */
public final class setTooltipText {

    /* renamed from: a */
    private static int f3067a = 4096;

    /* renamed from: a */
    private static void m2156a(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i = f3067a;
        byte[] bArr = new byte[i];
        while (true) {
            int read = inputStream.read(bArr, 0, i);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static byte[] cca_continue(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m2156a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static int init(InputStream inputStream, byte[] bArr) throws IOException {
        return init(inputStream, bArr, 0, bArr.length);
    }

    public static int init(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read < 0) {
                break;
            }
            i3 += read;
        }
        return i3;
    }
}

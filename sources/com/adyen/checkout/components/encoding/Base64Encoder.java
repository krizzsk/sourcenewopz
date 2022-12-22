package com.adyen.checkout.components.encoding;

import android.util.Base64;
import com.adyen.checkout.core.exception.NoConstructorException;
import java.nio.charset.Charset;

public final class Base64Encoder {

    /* renamed from: a */
    private static final String f665a = "UTF-8";

    /* renamed from: b */
    private static final Charset f666b = (Charset.isSupported("UTF-8") ? Charset.forName("UTF-8") : Charset.defaultCharset());

    public static String encode(String str) {
        return encode(str, 0);
    }

    public static String encode(String str, int i) {
        return Base64.encodeToString(str.getBytes(f666b), i);
    }

    public static String decode(String str) {
        return decode(str, 0);
    }

    public static String decode(String str, int i) {
        return new String(Base64.decode(str, i), f666b);
    }

    private Base64Encoder() {
        throw new NoConstructorException();
    }
}

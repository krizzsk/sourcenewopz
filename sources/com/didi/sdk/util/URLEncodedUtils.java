package com.didi.sdk.util;

import com.didi.sdk.message.NameValuePair;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.List;

public class URLEncodedUtils {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    /* renamed from: a */
    private static final char f37693a = '&';

    /* renamed from: b */
    private static final String f37694b = "=";

    /* renamed from: c */
    private static final BitSet f37695c = new BitSet(256);

    /* renamed from: d */
    private static final BitSet f37696d = new BitSet(256);

    /* renamed from: e */
    private static final BitSet f37697e = new BitSet(256);

    /* renamed from: f */
    private static final BitSet f37698f = new BitSet(256);

    /* renamed from: g */
    private static final BitSet f37699g = new BitSet(256);

    /* renamed from: h */
    private static final BitSet f37700h = new BitSet(256);

    /* renamed from: i */
    private static final BitSet f37701i = new BitSet(256);

    /* renamed from: j */
    private static final int f37702j = 16;

    static {
        for (int i = 97; i <= 122; i++) {
            f37696d.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f37696d.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            f37696d.set(i3);
        }
        f37696d.set(95);
        f37696d.set(45);
        f37696d.set(46);
        f37696d.set(42);
        f37695c.or(f37696d);
        f37696d.set(33);
        f37696d.set(126);
        f37696d.set(39);
        f37696d.set(40);
        f37696d.set(41);
        f37697e.set(44);
        f37697e.set(59);
        f37697e.set(58);
        f37697e.set(36);
        f37697e.set(38);
        f37697e.set(43);
        f37697e.set(61);
        f37698f.or(f37696d);
        f37698f.or(f37697e);
        f37699g.or(f37696d);
        f37699g.set(47);
        f37699g.set(59);
        f37699g.set(58);
        f37699g.set(64);
        f37699g.set(38);
        f37699g.set(61);
        f37699g.set(43);
        f37699g.set(36);
        f37699g.set(44);
        f37701i.set(59);
        f37701i.set(47);
        f37701i.set(63);
        f37701i.set(58);
        f37701i.set(64);
        f37701i.set(38);
        f37701i.set(61);
        f37701i.set(43);
        f37701i.set(36);
        f37701i.set(44);
        f37701i.set(91);
        f37701i.set(93);
        f37700h.or(f37701i);
        f37700h.or(f37696d);
    }

    public static String format(List<? extends NameValuePair> list, String str) {
        return format(list, '&', str);
    }

    public static String format(List<? extends NameValuePair> list, char c, String str) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair nameValuePair : list) {
            String a = m26727a(nameValuePair.getName(), str);
            String a2 = m26727a(nameValuePair.getValue(), str);
            if (sb.length() > 0) {
                sb.append(c);
            }
            sb.append(a);
            if (a2 != null) {
                sb.append("=");
                sb.append(a2);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m26727a(String str, String str2) {
        if (str == null) {
            return null;
        }
        return m26729a(str, str2 != null ? Charset.forName(str2) : UTF_8, f37695c, true);
    }

    /* renamed from: a */
    private static String m26728a(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = UTF_8;
        }
        return m26729a(str, charset, f37695c, true);
    }

    /* renamed from: a */
    private static String m26729a(String str, Charset charset, BitSet bitSet, boolean z) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ByteBuffer encode = charset.encode(str);
        while (encode.hasRemaining()) {
            byte b = encode.get() & 255;
            if (bitSet.get(b)) {
                sb.append((char) b);
            } else if (!z || b != 32) {
                sb.append("%");
                char upperCase = Character.toUpperCase(Character.forDigit((b >> 4) & 15, 16));
                char upperCase2 = Character.toUpperCase(Character.forDigit(b & Ascii.f53593SI, 16));
                sb.append(upperCase);
                sb.append(upperCase2);
            } else {
                sb.append('+');
            }
        }
        return sb.toString();
    }
}

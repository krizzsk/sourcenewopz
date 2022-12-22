package com.didi.entrega.customer.foundation.util;

import android.graphics.Typeface;
import java.util.HashMap;

public final class FontUtils {

    /* renamed from: a */
    private static final int f20139a = 2131296263;

    /* renamed from: b */
    private static HashMap<Integer, Typeface> f20140b = new HashMap<>();

    private FontUtils() {
    }

    public static Typeface getIconTypeface() {
        return m14832a(f20139a);
    }

    /* renamed from: a */
    private static Typeface m14832a(int i) {
        if (f20140b.containsKey(Integer.valueOf(i)) && f20140b.get(Integer.valueOf(i)) != null) {
            return f20140b.get(Integer.valueOf(i));
        }
        Typeface font = ResourceHelper.getFont(i);
        f20140b.put(Integer.valueOf(i), font);
        return font;
    }
}

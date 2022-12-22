package com.didi.soda.customer.foundation.util;

import android.graphics.Typeface;
import java.util.HashMap;

public final class FontUtils {

    /* renamed from: a */
    private static final int f41240a = 2131296258;

    /* renamed from: b */
    private static HashMap<Integer, Typeface> f41241b = new HashMap<>();

    private FontUtils() {
    }

    public static Typeface getIconTypeface() {
        return m29206a(f41240a);
    }

    /* renamed from: a */
    private static Typeface m29206a(int i) {
        if (f41241b.containsKey(Integer.valueOf(i)) && f41241b.get(Integer.valueOf(i)) != null) {
            return f41241b.get(Integer.valueOf(i));
        }
        Typeface font = ResourceHelper.getFont(i);
        f41241b.put(Integer.valueOf(i), font);
        return font;
    }
}

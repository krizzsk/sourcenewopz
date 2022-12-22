package rui.util;

import android.content.Context;
import android.graphics.Typeface;

public final class FontUtil {

    /* renamed from: a */
    private static final String f6823a = "fonts/icon.ttf";

    private FontUtil() {
    }

    /* renamed from: a */
    private static Typeface m3856a(Context context, String str) {
        try {
            return Typeface.createFromAsset(context.getAssets(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Typeface getIconTypeface(Context context) {
        return m3856a(context, f6823a);
    }
}

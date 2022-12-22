package rui.config.parser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import rui.config.RConfigConstants;

public class RResourceDrawableIdHelper {

    /* renamed from: a */
    private static Map<String, Integer> f6764a = new HashMap();

    /* renamed from: b */
    private static final String f6765b = "res";

    /* renamed from: a */
    static void m3844a() {
        f6764a.clear();
    }

    /* renamed from: a */
    static int m3843a(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String replace = str.toLowerCase().replace("-", "_");
        try {
            return Integer.parseInt(replace);
        } catch (NumberFormatException unused) {
            if (f6764a.containsKey(replace)) {
                return f6764a.get(replace).intValue();
            }
            int identifier = context.getResources().getIdentifier(replace, RConfigConstants.TYPE_DRAWABLE, context.getPackageName());
            if (identifier == 0) {
                identifier = context.getResources().getIdentifier(replace, "mipmap", context.getPackageName());
            }
            f6764a.put(replace, Integer.valueOf(identifier));
            return identifier;
        }
    }

    /* renamed from: b */
    static Drawable m3845b(Context context, String str) {
        int a = m3843a(context, str);
        if (a > 0) {
            return context.getResources().getDrawable(a);
        }
        return null;
    }

    /* renamed from: c */
    static Uri m3846c(Context context, String str) {
        int a = m3843a(context, str);
        return a > 0 ? new Uri.Builder().scheme("res").path(String.valueOf(a)).build() : Uri.EMPTY;
    }
}

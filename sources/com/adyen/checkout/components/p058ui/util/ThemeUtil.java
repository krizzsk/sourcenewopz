package com.adyen.checkout.components.p058ui.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.adyen.checkout.core.exception.NoConstructorException;
import com.taxis99.R;

/* renamed from: com.adyen.checkout.components.ui.util.ThemeUtil */
public final class ThemeUtil {
    public static int getPrimaryThemeColor(Context context) {
        return m1055a(context, R.attr.colorPrimary);
    }

    /* renamed from: a */
    private static int m1055a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{i});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    private ThemeUtil() {
        throw new NoConstructorException();
    }
}

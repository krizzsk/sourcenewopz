package com.didichuxing.omega.sdk.uicomponents.floatingview;

import android.content.Context;
import android.os.Build;

/* renamed from: com.didichuxing.omega.sdk.uicomponents.floatingview.Util */
public final class C16159Util {
    private C16159Util() {
    }

    public static int dpToPx(Context context, float f) {
        return Math.round(f * context.getResources().getDisplayMetrics().density);
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }
}

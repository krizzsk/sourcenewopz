package utils;

import android.content.Context;

public final class ContextUtil {

    /* renamed from: a */
    private static Context f6996a;

    public static void initApplicationContext(Context context) {
        f6996a = context.getApplicationContext();
    }

    public static Context getApplicationContext() {
        return f6996a;
    }
}

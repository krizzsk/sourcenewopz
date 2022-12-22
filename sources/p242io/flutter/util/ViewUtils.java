package p242io.flutter.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;

/* renamed from: io.flutter.util.ViewUtils */
public final class ViewUtils {
    public static Activity getActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static int generateViewId(int i) {
        return Build.VERSION.SDK_INT >= 17 ? View.generateViewId() : i;
    }
}

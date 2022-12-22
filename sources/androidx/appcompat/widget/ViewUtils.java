package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                sComputeFitSystemWindowsMethod = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    sComputeFitSystemWindowsMethod.setAccessible(true);
                }
            } catch (NoSuchMethodException unused) {
                SystemUtils.log(3, TAG, "Could not find method computeFitSystemWindows. Oh well.", (Throwable) null, "androidx.appcompat.widget.ViewUtils", 50);
            }
        }
    }

    private ViewUtils() {
    }

    public static boolean isLayoutRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static void computeFitSystemWindows(View view, Rect rect, Rect rect2) {
        Method method = sComputeFitSystemWindowsMethod;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{rect, rect2});
            } catch (Exception e) {
                SystemUtils.log(3, TAG, "Could not invoke computeFitSystemWindows", e, "androidx.appcompat.widget.ViewUtils", 70);
            }
        }
    }

    public static void makeOptionalFitsSystemWindows(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (NoSuchMethodException unused) {
                SystemUtils.log(3, TAG, "Could not find method makeOptionalFitsSystemWindows. Oh well...", (Throwable) null, "androidx.appcompat.widget.ViewUtils", 90);
            } catch (InvocationTargetException e) {
                SystemUtils.log(3, TAG, "Could not invoke makeOptionalFitsSystemWindows", e, "androidx.appcompat.widget.ViewUtils", 92);
            } catch (IllegalAccessException e2) {
                SystemUtils.log(3, TAG, "Could not invoke makeOptionalFitsSystemWindows", e2, "androidx.appcompat.widget.ViewUtils", 94);
            }
        }
    }
}

package com.didi.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.didi.sdk.log.Logger;

@Deprecated
public class WindowUtil {
    public static float SCALE_RATIO = 0.0f;
    public static float SCALE_RATIO_HORIZONTAL = 0.0f;
    public static float SCALE_RATIO_VERTICAL = 0.0f;
    public static int WINDOW_ROTATION = 0;

    /* renamed from: a */
    private static final String f37708a = "strict_mode";

    /* renamed from: b */
    private static final int f37709b = 1800;

    /* renamed from: c */
    private static final int f37710c = 1080;

    /* renamed from: d */
    private static float f37711d = 1.0f;
    public static Context mContext;

    public static void init(Context context) {
        mContext = context;
        computeScaleRatio(context);
        computeScreenDensity(context);
        computeWindowRotation(context);
    }

    public static void computeWindowRotation(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            WINDOW_ROTATION = defaultDisplay.getRotation();
        }
        Logger.m25808d("computeWindowRotation rotation : " + WINDOW_ROTATION, new Object[0]);
    }

    public static void computeScaleRatio(Context context) {
        int windowWidth = getWindowWidth(context);
        int windowHeight = getWindowHeight(context);
        if (windowWidth != 0 && windowHeight != 0) {
            int i = 1800;
            int i2 = windowWidth > windowHeight ? 1800 : 1080;
            if (windowWidth > windowHeight) {
                i = 1080;
            }
            float f = (float) windowWidth;
            float f2 = f / ((float) i2);
            SCALE_RATIO_HORIZONTAL = f2;
            float f3 = (float) windowHeight;
            float f4 = f3 / ((float) i);
            SCALE_RATIO_VERTICAL = f4;
            if (f3 / f < 1.6666666f) {
                f2 = f4;
            }
            SCALE_RATIO = f2;
        }
    }

    public static void computeScreenDensity(Context context) {
        new DisplayMetrics();
        DisplayMetrics displayMetrics = ResourcesHelper.getDisplayMetrics(context);
        if (displayMetrics != null) {
            f37711d = displayMetrics.density;
        }
    }

    public static int getWindowWidth(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public static int getWindowHeight(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static float dip2px(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static float px2dip(Context context, float f) {
        return (f / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static float dip2pxWithResId(Context context, int i) {
        return (context.getResources().getDimension(i) * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static float px2dipWithResId(Context context, int i) {
        return (context.getResources().getDimension(i) / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static void hideSoftInputFromWindow(Context context, View view) {
        if (view != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void hideSoftInputFromWindow(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static boolean resizeRecursively(View view) {
        float f = SCALE_RATIO;
        return m26732a(view, f, f);
    }

    /* renamed from: a */
    private static boolean m26732a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        if (m26731a(view)) {
            float f3 = SCALE_RATIO;
            return m26734b(view, f3, f3);
        } else if (m26733b(view)) {
            return true;
        } else {
            resize(view, f, f2);
            if (!(view instanceof ViewGroup)) {
                return true;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m26732a(viewGroup.getChildAt(i), f, f2);
            }
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m26731a(View view) {
        Object tag = view.getTag();
        if (tag == null) {
            return false;
        }
        return f37708a.equals(String.valueOf(tag));
    }

    /* renamed from: b */
    private static boolean m26734b(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        resizeStrictly(view, f, f2);
        if (!(view instanceof ViewGroup)) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            m26734b(viewGroup.getChildAt(i), f, f2);
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m26733b(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            return "ignore".equals((String) tag);
        }
        return false;
    }

    public static boolean resize(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        resizeWidthAndHeight(view, f, f2);
        repadding(view);
        remargin(view);
        if (!(view instanceof TextView)) {
            return true;
        }
        resizeText((TextView) view);
        return true;
    }

    public static boolean resizeStrictly(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        resizeWidthAndHeight(view, f, f2);
        repadding(view, f, f2);
        remargin(view, f, f2);
        if (!(view instanceof TextView)) {
            return true;
        }
        resizeText((TextView) view);
        return true;
    }

    public static boolean resizeWidthAndHeight(View view, float f, float f2) {
        ViewGroup.LayoutParams layoutParams;
        int i;
        int i2;
        if (view == null) {
            return false;
        }
        Object tag = view.getTag();
        if ((!(tag instanceof String) || !"ignoreSize".equals((String) tag)) && (layoutParams = view.getLayoutParams()) != null) {
            int i3 = layoutParams.width;
            int i4 = layoutParams.height;
            if (!(layoutParams.width == -1 || layoutParams.width == -2 || (i2 = (int) (((float) i3) * f)) <= 1)) {
                layoutParams.width = i2;
            }
            if (!(layoutParams.height == -1 || layoutParams.height == -2 || (i = (int) (((float) i4) * f2)) <= 1)) {
                layoutParams.height = i;
            }
            view.setLayoutParams(layoutParams);
        }
        return true;
    }

    public static boolean repadding(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        view.setPadding((int) (((float) view.getPaddingLeft()) * f), (int) (((float) view.getPaddingTop()) * f2), (int) (((float) view.getPaddingRight()) * f), (int) (((float) view.getPaddingBottom()) * f2));
        if (Build.VERSION.SDK_INT < 17) {
            return true;
        }
        view.setPaddingRelative((int) (((float) view.getPaddingLeft()) * f), (int) (((float) view.getPaddingTop()) * f2), (int) (((float) view.getPaddingRight()) * f), (int) (((float) view.getPaddingBottom()) * f2));
        return true;
    }

    public static void remargin(View view, float f, float f2) {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins((int) (((float) marginLayoutParams.leftMargin) * f), (int) (((float) marginLayoutParams.topMargin) * f2), (int) (((float) marginLayoutParams.rightMargin) * f), (int) (((float) marginLayoutParams.bottomMargin) * f2));
                if (Build.VERSION.SDK_INT >= 17) {
                    marginLayoutParams.setMarginStart(marginLayoutParams.leftMargin);
                    marginLayoutParams.setMarginEnd(marginLayoutParams.rightMargin);
                }
                view.setLayoutParams(marginLayoutParams);
            }
        } catch (ClassCastException unused) {
        }
    }

    public static boolean resizeText(TextView textView) {
        if (textView == null) {
            return false;
        }
        Object tag = textView.getTag();
        if ((tag instanceof String) && "ignoreSize".equals((String) tag)) {
            return true;
        }
        textView.setTextSize(0, textView.getTextSize() * SCALE_RATIO);
        return true;
    }

    public static void remargin(View view) {
        remargin(view, SCALE_RATIO_HORIZONTAL, SCALE_RATIO_VERTICAL);
    }

    public static boolean repadding(View view) {
        return repadding(view, SCALE_RATIO_HORIZONTAL, SCALE_RATIO_VERTICAL);
    }

    public static float computeScaledDimenByBalancedRatio(int i) {
        return computeScaledDimen(i, SCALE_RATIO);
    }

    public static float computeScaledDimen(int i, float f) {
        return computeDimen(i) * f;
    }

    public static float computeDimen(int i) {
        return mContext.getResources().getDimension(i);
    }

    public static int computeScaledVerticalSize(int i) {
        return (int) (((float) i) * SCALE_RATIO_VERTICAL);
    }
}

package com.didichuxing.publicservice.resourcecontrol.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import java.lang.reflect.Method;

public class AssetWindowUtil {
    private static final String AUTO_RESIZE_STRICT_TAG = "strict_mode";
    public static float SCALE_RATIO = 0.0f;
    public static float SCALE_RATIO_HORIZONTAL = 0.0f;
    public static float SCALE_RATIO_VERTICAL = 0.0f;
    private static float SCREEN_DENSITY = 1.0f;
    public static int STATUS_BAR_HEIGHT = 0;
    private static final String TAG = AssetWindowUtil.class.getSimpleName();
    private static final int UI_DESIGN_LANDSCAPE_SIZE = 1080;
    private static final int UI_DESIGN_PORTRAIT_SIZE = 1800;
    public static int WINDOW_ROTATION;

    static {
        computeScaleRatio();
        computeScreenDensity();
        computeWindowRotation();
    }

    public static boolean resize(View view) {
        return resize(view, SCALE_RATIO_HORIZONTAL, SCALE_RATIO);
    }

    public static boolean resizeRecursively(View view) {
        float f = SCALE_RATIO;
        return resizeRecursively(view, f, f);
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

    public static int getScreenHeight(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            try {
                activity.getWindowManager().getDefaultDisplay().getRealSize(point);
                return point.y;
            } catch (NoSuchMethodError unused) {
                return 0;
            }
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
    }

    private static boolean shouldIgnore(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            return "ignore".equals((String) tag);
        }
        return false;
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

    public static boolean repadding(View view) {
        return repadding(view, SCALE_RATIO_HORIZONTAL, SCALE_RATIO_VERTICAL);
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

    public static void remargin(View view) {
        remargin(view, SCALE_RATIO_HORIZONTAL, SCALE_RATIO_VERTICAL);
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

    public static boolean resizeWithHorizontalRatio(View view) {
        float f = SCALE_RATIO_HORIZONTAL;
        return resize(view, f, f);
    }

    public static boolean resizeWithRespectiveRatio(View view) {
        return resize(view, SCALE_RATIO_HORIZONTAL, SCALE_RATIO_VERTICAL);
    }

    public static boolean resizeChildrenRecursively(View view) {
        if (view == null) {
            return false;
        }
        if (!(view instanceof ViewGroup)) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            resizeRecursively(viewGroup.getChildAt(i));
        }
        return true;
    }

    public static boolean resizeRecursivelyWithRespectiveRatio(View view) {
        return resizeRecursively(view, SCALE_RATIO_HORIZONTAL, SCALE_RATIO_VERTICAL);
    }

    public static boolean resizeRecursivelyWithVerticalRatio(View view) {
        float f = SCALE_RATIO_VERTICAL;
        return resizeRecursively(view, f, f);
    }

    private static boolean resizeRecursively(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        if (isStrictMode(view)) {
            float f3 = SCALE_RATIO;
            return resizeStrictRecursively(view, f3, f3);
        } else if (shouldIgnore(view)) {
            return true;
        } else {
            resize(view, f, f2);
            if (!(view instanceof ViewGroup)) {
                return true;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                resizeRecursively(viewGroup.getChildAt(i), f, f2);
            }
            return true;
        }
    }

    private static boolean resizeStrictRecursively(View view, float f, float f2) {
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
            resizeStrictRecursively(viewGroup.getChildAt(i), f, f2);
        }
        return true;
    }

    private static boolean isStrictMode(View view) {
        Object tag = view.getTag();
        if (tag == null) {
            return false;
        }
        return AUTO_RESIZE_STRICT_TAG.equals(String.valueOf(tag));
    }

    public static boolean setWidth(View view, int i) {
        float dimension = AssetResourcesHelper.getDimension(i);
        ViewGroup.LayoutParams layoutParams = view instanceof ViewGroup ? view.getLayoutParams() : null;
        if (layoutParams == null) {
            layoutParams = ((View) view.getParent()).getLayoutParams();
        }
        if (layoutParams == null) {
            return false;
        }
        layoutParams.width = (int) (dimension * SCALE_RATIO_HORIZONTAL);
        view.setLayoutParams(layoutParams);
        return true;
    }

    public static boolean setHeight(View view, int i) {
        if (view == null) {
            return false;
        }
        float dimension = AssetResourcesHelper.getDimension(i);
        ViewGroup.LayoutParams layoutParams = null;
        if (view instanceof ViewGroup) {
            layoutParams = view.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams = ((View) view.getParent()).getLayoutParams();
        }
        if (layoutParams == null) {
            return false;
        }
        layoutParams.height = (int) (dimension * SCALE_RATIO_VERTICAL);
        view.setLayoutParams(layoutParams);
        return true;
    }

    public static boolean setSize(View view, int i, int i2) {
        float dimension = AssetResourcesHelper.getDimension(i);
        float dimension2 = AssetResourcesHelper.getDimension(i2);
        ViewGroup.LayoutParams layoutParams = view instanceof ViewGroup ? view.getLayoutParams() : null;
        if (layoutParams == null) {
            layoutParams = ((View) view.getParent()).getLayoutParams();
        }
        if (layoutParams == null) {
            return false;
        }
        layoutParams.width = (int) (dimension * SCALE_RATIO_HORIZONTAL);
        layoutParams.height = (int) (dimension2 * SCALE_RATIO_HORIZONTAL);
        view.setLayoutParams(layoutParams);
        return true;
    }

    public static boolean setViewHeight(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view instanceof ViewGroup ? view.getLayoutParams() : null;
        if (layoutParams == null) {
            layoutParams = ((View) view.getParent()).getLayoutParams();
        }
        if (layoutParams == null) {
            return false;
        }
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
        return true;
    }

    public static boolean setViewSize(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view instanceof ViewGroup ? view.getLayoutParams() : null;
        if (layoutParams == null) {
            layoutParams = ((View) view.getParent()).getLayoutParams();
        }
        if (layoutParams == null) {
            return false;
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
        return true;
    }

    public static boolean setTextSize(TextView textView, int i) {
        if (textView == null) {
            return false;
        }
        textView.setTextSize(0, AssetResourcesHelper.getDimension(i) * SCALE_RATIO_HORIZONTAL);
        return true;
    }

    public static boolean setMargin(View view, int i, int i2, int i3, int i4) {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams == null) {
                return false;
            }
            marginLayoutParams.leftMargin = i;
            marginLayoutParams.topMargin = i2;
            marginLayoutParams.rightMargin = i3;
            marginLayoutParams.bottomMargin = i4;
            if (Build.VERSION.SDK_INT >= 17) {
                marginLayoutParams.setMarginStart(marginLayoutParams.leftMargin);
                marginLayoutParams.setMarginEnd(marginLayoutParams.rightMargin);
            }
            view.setLayoutParams(marginLayoutParams);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public static boolean setMarginTop(View view, int i) {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams == null) {
                return false;
            }
            marginLayoutParams.topMargin = i;
            view.setLayoutParams(marginLayoutParams);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public static boolean setMarginLeftRes(View view, int i) {
        return setMarginLeft(view, (int) computeScaledDimenByHorizontalRatio(i));
    }

    public static boolean setMarginLeft(View view, int i) {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams == null) {
                return false;
            }
            marginLayoutParams.leftMargin = i;
            if (Build.VERSION.SDK_INT >= 17) {
                marginLayoutParams.setMarginStart(marginLayoutParams.leftMargin);
            }
            view.setLayoutParams(marginLayoutParams);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public static boolean setMarginRight(View view, int i) {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams == null) {
                return false;
            }
            marginLayoutParams.rightMargin = i;
            if (Build.VERSION.SDK_INT >= 17) {
                marginLayoutParams.setMarginEnd(marginLayoutParams.rightMargin);
            }
            view.setLayoutParams(marginLayoutParams);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public static boolean setMarginBottom(View view, int i) {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams == null) {
                return false;
            }
            marginLayoutParams.bottomMargin = i;
            view.setLayoutParams(marginLayoutParams);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public static boolean setPadding(View view, int i, int i2, int i3, int i4) {
        if (view == null) {
            return false;
        }
        view.setPadding(i, i2, i3, i4);
        if (Build.VERSION.SDK_INT < 17) {
            return true;
        }
        view.setPaddingRelative(i, i2, i3, i4);
        return true;
    }

    public static boolean setPaddingTop(View view, int i) {
        if (view == null) {
            return false;
        }
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), view.getPaddingBottom());
        if (Build.VERSION.SDK_INT < 17) {
            return true;
        }
        view.setPaddingRelative(view.getPaddingLeft(), i, view.getPaddingRight(), view.getPaddingBottom());
        return true;
    }

    public static boolean setPaddingLeft(View view, int i) {
        if (view == null) {
            return false;
        }
        view.setPadding(i, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        if (Build.VERSION.SDK_INT < 17) {
            return true;
        }
        view.setPaddingRelative(i, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        return true;
    }

    public static boolean setPaddingRight(View view, int i) {
        if (view == null) {
            return false;
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), i, view.getPaddingBottom());
        if (Build.VERSION.SDK_INT < 17) {
            return true;
        }
        view.setPaddingRelative(view.getPaddingLeft(), view.getPaddingTop(), i, view.getPaddingBottom());
        return true;
    }

    public static boolean setPaddingBottom(View view, int i) {
        if (view == null) {
            return false;
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
        if (Build.VERSION.SDK_INT < 17) {
            return true;
        }
        view.setPaddingRelative(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
        return true;
    }

    public static int getWidth(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return 0;
        }
        return layoutParams.width;
    }

    public static int getHeight(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public static float getHorizontalScaledDimen(int i) {
        return AssetResourcesHelper.getDimension(i) * SCALE_RATIO_HORIZONTAL;
    }

    public static float getVerticalScaledDimen(int i) {
        return AssetResourcesHelper.getDimension(i) * SCALE_RATIO_VERTICAL;
    }

    public static int getWindowWidth() {
        new DisplayMetrics();
        DisplayMetrics displayMetrics = AssetResourcesHelper.getDisplayMetrics();
        if (displayMetrics == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public static int getWindowHeight() {
        new DisplayMetrics();
        DisplayMetrics displayMetrics = AssetResourcesHelper.getDisplayMetrics();
        if (displayMetrics == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public static float computeDimen(int i) {
        return AssetResourcesHelper.getDimension(i);
    }

    public static float computeScaledDimen(int i, float f) {
        return computeDimen(i) * f;
    }

    public static int computeScaledSize(int i) {
        return (int) (((float) i) * SCALE_RATIO);
    }

    public static int computeScaledSize(float f) {
        return (int) (f * SCALE_RATIO);
    }

    public static int computeScaledVerticalSize(int i) {
        return (int) (((float) i) * SCALE_RATIO_VERTICAL);
    }

    public static float computeScaledDimenByVerticalRatio(int i) {
        return computeScaledDimen(i, SCALE_RATIO_VERTICAL);
    }

    public static float computeScaledDimenByHorizontalRatio(int i) {
        return computeScaledDimen(i, SCALE_RATIO_HORIZONTAL);
    }

    public static float computeScaledDimenByBalancedRatio(int i) {
        return computeScaledDimen(i, SCALE_RATIO);
    }

    public static void computeScreenDensity() {
        new DisplayMetrics();
        DisplayMetrics displayMetrics = AssetResourcesHelper.getDisplayMetrics();
        if (displayMetrics != null) {
            SCREEN_DENSITY = displayMetrics.density;
        }
    }

    public static void computeScaleRatio() {
        int windowWidth = getWindowWidth();
        int windowHeight = getWindowHeight();
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

    public static boolean isLandscape() {
        if (AssetResourcesHelper.getConfiguration() == null || AssetResourcesHelper.getConfiguration().orientation != 2) {
            return false;
        }
        return true;
    }

    public static int dip2px(float f) {
        if (AssetResourcesHelper.getDisplayMetrics() != null) {
            return (int) ((f * AssetResourcesHelper.getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static int px2dip(float f) {
        if (AssetResourcesHelper.getDisplayMetrics() != null) {
            return (int) (f / AssetResourcesHelper.getDisplayMetrics().density);
        }
        return 0;
    }

    public static boolean intersects(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getHitRect(rect);
        Rect rect2 = new Rect();
        int x = (int) motionEvent.getX();
        rect2.right = x;
        rect2.left = x;
        int y = (int) motionEvent.getY();
        rect2.top = y;
        rect2.bottom = y;
        return rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    public static int getStatusBarHeight() {
        int i = STATUS_BAR_HEIGHT;
        if (i != 0) {
            return i;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            STATUS_BAR_HEIGHT = AssetResourcesHelper.getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return STATUS_BAR_HEIGHT;
    }

    public static int getStatusBarHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static void computeWindowRotation() {
        WINDOW_ROTATION = ((WindowManager) ResourceManager.getManager().getApplication().getApplicationContext().getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static int getWindowRotation() {
        return WINDOW_ROTATION;
    }

    public static float getScaleRatio() {
        return SCALE_RATIO;
    }

    public static float getMarginTop(View view) {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams == null) {
                return 0.0f;
            }
            return (float) marginLayoutParams.topMargin;
        } catch (ClassCastException unused) {
            return 0.0f;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r4 = r4.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getNavigationBarHeight(android.content.Context r4) {
        /*
            boolean r0 = hasNavBar(r4)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r0 = "navigation_bar_height"
            java.lang.String r2 = "dimen"
            java.lang.String r3 = "android"
            int r0 = r4.getIdentifier(r0, r2, r3)
            if (r0 <= 0) goto L_0x001d
            int r4 = r4.getDimensionPixelSize(r0)
            return r4
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.publicservice.resourcecontrol.utils.AssetWindowUtil.getNavigationBarHeight(android.content.Context):int");
    }

    public static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        String navBarOverride = getNavBarOverride();
        if ("1".equals(navBarOverride)) {
            return false;
        }
        if ("0".equals(navBarOverride)) {
            return true;
        }
        return z;
    }

    private static String getNavBarOverride() {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke((Object) null, new Object[]{"qemu.hw.mainkeys"});
        } catch (Throwable unused) {
            return null;
        }
    }
}

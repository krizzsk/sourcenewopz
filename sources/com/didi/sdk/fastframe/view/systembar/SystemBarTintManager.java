package com.didi.sdk.fastframe.view.systembar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Method;

public class SystemBarTintManager {
    public static final int DEFAULT_TINT_COLOR = -1728053248;

    /* renamed from: a */
    private static final String f35934a = "ro.miui.ui.version.name";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f35935b;

    /* renamed from: c */
    private final SystemBarConfig f35936c;

    /* renamed from: d */
    private boolean f35937d;

    /* renamed from: e */
    private boolean f35938e;

    /* renamed from: f */
    private boolean f35939f;

    /* renamed from: g */
    private boolean f35940g;

    /* renamed from: h */
    private View f35941h;

    /* renamed from: i */
    private View f35942i;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                f35935b = (String) declaredMethod.invoke((Object) null, new Object[]{"qemu.hw.mainkeys"});
            } catch (Throwable unused) {
                f35935b = null;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public SystemBarTintManager(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.f35937d = obtainStyledAttributes.getBoolean(0, false);
                this.f35938e = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f35937d = true;
                }
                if ((attributes.flags & View.NAVIGATION_BAR_TRANSIENT) != 0) {
                    this.f35938e = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        SystemBarConfig systemBarConfig = new SystemBarConfig(activity, this.f35937d, this.f35938e);
        this.f35936c = systemBarConfig;
        if (!systemBarConfig.hasNavigtionBar()) {
            this.f35938e = false;
        }
        if (this.f35937d) {
            m25446a(activity, viewGroup);
        }
        if (this.f35938e) {
            m25447b(activity, viewGroup);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        this.f35939f = z;
        if (this.f35937d) {
            this.f35941h.setVisibility(z ? 0 : 8);
        }
    }

    public void setNavigationBarTintEnabled(boolean z) {
        this.f35940g = z;
        if (this.f35938e) {
            this.f35942i.setVisibility(z ? 0 : 8);
        }
    }

    public void setTintColor(int i) {
        setStatusBarTintColor(i);
        setNavigationBarTintColor(i);
    }

    public void setTintResource(int i) {
        setStatusBarTintResource(i);
        setNavigationBarTintResource(i);
    }

    public void setTintDrawable(Drawable drawable) {
        setStatusBarTintDrawable(drawable);
        setNavigationBarTintDrawable(drawable);
    }

    public void setTintAlpha(float f) {
        setStatusBarAlpha(f);
        setNavigationBarAlpha(f);
    }

    public void setStatusBarTintColor(int i) {
        if (this.f35937d) {
            this.f35941h.setBackgroundColor(i);
        }
    }

    public void setStatusBarTintResource(int i) {
        if (this.f35937d) {
            this.f35941h.setBackgroundResource(i);
        }
    }

    public void setStatusBarTintDrawable(Drawable drawable) {
        if (this.f35937d) {
            this.f35941h.setBackgroundDrawable(drawable);
        }
    }

    public void setStatusBarAlpha(float f) {
        if (this.f35937d && Build.VERSION.SDK_INT >= 11) {
            this.f35941h.setAlpha(f);
        }
    }

    public void setNavigationBarTintColor(int i) {
        if (this.f35938e) {
            this.f35942i.setBackgroundColor(i);
        }
    }

    public void setNavigationBarTintResource(int i) {
        if (this.f35938e) {
            this.f35942i.setBackgroundResource(i);
        }
    }

    public void setNavigationBarTintDrawable(Drawable drawable) {
        if (this.f35938e) {
            this.f35942i.setBackgroundDrawable(drawable);
        }
    }

    public void setNavigationBarAlpha(float f) {
        if (this.f35938e && Build.VERSION.SDK_INT >= 11) {
            this.f35942i.setAlpha(f);
        }
    }

    public SystemBarConfig getConfig() {
        return this.f35936c;
    }

    public boolean isStatusBarTintEnabled() {
        return this.f35939f;
    }

    public boolean isNavBarTintEnabled() {
        return this.f35940g;
    }

    /* renamed from: a */
    private void m25446a(Context context, ViewGroup viewGroup) {
        this.f35941h = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f35936c.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.f35938e && !this.f35936c.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.f35936c.getNavigationBarWidth();
        }
        this.f35941h.setLayoutParams(layoutParams);
        this.f35941h.setBackgroundColor(DEFAULT_TINT_COLOR);
        this.f35941h.setVisibility(8);
        viewGroup.addView(this.f35941h);
    }

    /* renamed from: b */
    private void m25447b(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f35942i = new View(context);
        if (this.f35936c.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f35936c.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f35936c.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.f35942i.setLayoutParams(layoutParams);
        this.f35942i.setBackgroundColor(DEFAULT_TINT_COLOR);
        this.f35942i.setVisibility(8);
        viewGroup.addView(this.f35942i);
    }

    public static class SystemBarConfig {
        private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
        private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
        private static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
        private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
        private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
        private final int mActionBarHeight;
        private final boolean mHasNavigationBar;
        private final boolean mInPortrait;
        private final int mNavigationBarHeight;
        private final int mNavigationBarWidth;
        private final float mSmallestWidthDp;
        private final int mStatusBarHeight;
        private final boolean mTranslucentNavBar;
        private final boolean mTranslucentStatusBar;

        private SystemBarConfig(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            boolean z3 = false;
            this.mInPortrait = resources.getConfiguration().orientation == 1;
            this.mSmallestWidthDp = getSmallestWidthDp(activity);
            this.mStatusBarHeight = getInternalDimensionSize(resources, STATUS_BAR_HEIGHT_RES_NAME);
            this.mActionBarHeight = getActionBarHeight(activity);
            this.mNavigationBarHeight = getNavigationBarHeight(activity);
            this.mNavigationBarWidth = getNavigationBarWidth(activity);
            this.mHasNavigationBar = this.mNavigationBarHeight > 0 ? true : z3;
            this.mTranslucentStatusBar = z;
            this.mTranslucentNavBar = z2;
        }

        private int getActionBarHeight(Context context) {
            if (Build.VERSION.SDK_INT < 14) {
                return 0;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843499, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        private int getNavigationBarHeight(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            return getInternalDimensionSize(resources, this.mInPortrait ? NAV_BAR_HEIGHT_RES_NAME : NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME);
        }

        private int getNavigationBarWidth(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            return getInternalDimensionSize(resources, NAV_BAR_WIDTH_RES_NAME);
        }

        private boolean hasNavBar(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(SHOW_NAV_BAR_RES_NAME, "bool", "android");
            if (identifier == 0) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            boolean z = resources.getBoolean(identifier);
            if ("1".equals(SystemBarTintManager.f35935b)) {
                return false;
            }
            if ("0".equals(SystemBarTintManager.f35935b)) {
                return true;
            }
            return z;
        }

        private int getInternalDimensionSize(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        private float getSmallestWidthDp(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            return Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
        }

        public boolean isNavigationAtBottom() {
            return this.mSmallestWidthDp >= 600.0f || this.mInPortrait;
        }

        public int getStatusBarHeight() {
            return this.mStatusBarHeight;
        }

        public int getActionBarHeight() {
            return this.mActionBarHeight;
        }

        public boolean hasNavigtionBar() {
            return this.mHasNavigationBar;
        }

        public int getNavigationBarHeight() {
            return this.mNavigationBarHeight;
        }

        public int getNavigationBarWidth() {
            return this.mNavigationBarWidth;
        }

        public int getPixelInsetTop(boolean z) {
            int i = 0;
            int i2 = this.mTranslucentStatusBar ? this.mStatusBarHeight : 0;
            if (z) {
                i = this.mActionBarHeight;
            }
            return i2 + i;
        }

        public int getPixelInsetBottom() {
            if (!this.mTranslucentNavBar || !isNavigationAtBottom()) {
                return 0;
            }
            return this.mNavigationBarHeight;
        }

        public int getPixelInsetRight() {
            if (!this.mTranslucentNavBar || isNavigationAtBottom()) {
                return 0;
            }
            return this.mNavigationBarWidth;
        }
    }

    public static void setStatusBarTextColor(Activity activity, int i) {
        if (m25448b()) {
            Window window = activity.getWindow();
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
                int i3 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
                if (i == 0) {
                    method.invoke(window, new Object[]{Integer.valueOf(i2), Integer.valueOf(i2)});
                } else if (i == 1) {
                    method.invoke(window, new Object[]{Integer.valueOf(i3), Integer.valueOf(i3 | i2)});
                } else {
                    method.invoke(window, new Object[]{0, Integer.valueOf(i3)});
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    private static boolean m25448b() {
        try {
            String property = BuildProperties.newInstance().getProperty(f35934a, "");
            if ("V6".equals(property) || Integer.valueOf(property.replaceAll(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "")).intValue() >= 6) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}

package com.didi.dimina.container.p106ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.statusbar.a */
/* compiled from: BarConfig */
class C7681a {

    /* renamed from: a */
    private final int f17752a;

    /* renamed from: b */
    private final int f17753b;

    /* renamed from: c */
    private final boolean f17754c;

    /* renamed from: d */
    private final int f17755d;

    /* renamed from: e */
    private final int f17756e;

    /* renamed from: f */
    private final boolean f17757f;

    /* renamed from: g */
    private final float f17758g;

    C7681a(Activity activity) {
        boolean z = false;
        this.f17757f = activity.getResources().getConfiguration().orientation == 1;
        this.f17758g = m13264c(activity);
        this.f17752a = m13261a(activity, "status_bar_height");
        this.f17753b = m13259a(activity);
        this.f17755d = m13260a((Context) activity);
        this.f17756e = m13262b((Context) activity);
        this.f17754c = this.f17755d > 0 ? true : z;
    }

    /* renamed from: a */
    private int m13259a(Activity activity) {
        int i = 0;
        if (Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        View findViewById = activity.getWindow().findViewById(R.id.action_bar_container);
        if (findViewById != null) {
            i = findViewById.getMeasuredHeight();
        }
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(16843499, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    private int m13260a(Context context) {
        if (Build.VERSION.SDK_INT < 14 || !m13263b((Activity) context)) {
            return 0;
        }
        return m13261a(context, this.f17757f ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    /* renamed from: b */
    private int m13262b(Context context) {
        if (Build.VERSION.SDK_INT < 14 || !m13263b((Activity) context)) {
            return 0;
        }
        return m13261a(context, "navigation_bar_width");
    }

    /* renamed from: b */
    private boolean m13263b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            if (Settings.Global.getInt(activity.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                return false;
            }
            if (OSUtils.isEMUI()) {
                if (OSUtils.isEMUI3_x() || Build.VERSION.SDK_INT < 21) {
                    if (Settings.System.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                        return false;
                    }
                } else if (Settings.Global.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                    return false;
                }
            }
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        }
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i3 = displayMetrics2.heightPixels;
        if (i2 - displayMetrics2.widthPixels > 0 || i - i3 > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private int m13261a(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                float f = (((float) dimensionPixelSize) * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f >= 0.0f ? f + 0.5f : f - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    /* renamed from: c */
    private float m13264c(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 16) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        return Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo56685a() {
        return this.f17758g >= 600.0f || this.f17757f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo56686b() {
        return this.f17752a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo56687c() {
        return this.f17753b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo56688d() {
        return this.f17754c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo56689e() {
        return this.f17755d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo56690f() {
        return this.f17756e;
    }
}

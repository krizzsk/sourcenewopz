package com.didi.hawaii.p118ar.core;

import android.content.Context;
import android.widget.TextView;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.core.ThemeManager */
public class ThemeManager {

    /* renamed from: c */
    private static String f23042c = "上车点";

    /* renamed from: a */
    private Context f23043a;

    /* renamed from: b */
    private int f23044b;

    /* renamed from: com.didi.hawaii.ar.core.ThemeManager$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ThemeManager INSTANCE = new ThemeManager();

        private SingletonHolder() {
        }
    }

    private ThemeManager() {
        this.f23043a = null;
        this.f23044b = 0;
    }

    public static final ThemeManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static String getDestSpotName(int i) {
        if (i == 1) {
            f23042c = "目的站点";
        }
        return f23042c;
    }

    public void init(Context context, int i) {
        this.f23043a = context;
        this.f23044b = i;
    }

    public String getThemeString(int i) {
        Context context = this.f23043a;
        if (context == null) {
            return "";
        }
        if (this.f23044b == 1 && i == R.string.arrival) {
            return context.getString(R.string.arrival_bus);
        }
        return this.f23043a.getString(i);
    }

    public int getThemeResId(int i) {
        return (this.f23043a != null && this.f23044b == 1 && i == R.string.locationSuccess) ? R.string.locationSuccess_bus : i;
    }

    public void changeViewTheme(TextView textView, int i) {
        if (this.f23043a != null && textView != null && this.f23044b == 1) {
            if (i == R.id.guide_title_tv) {
                textView.setText(R.string.guide_title_bus);
            } else if (i == R.id.guide_2_tv) {
                textView.setText(R.string.guide_2_bus);
            }
        }
    }

    public void reset() {
        this.f23043a = null;
        this.f23044b = 0;
    }
}

package com.android.didi.theme;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;

public class ThemeResPicker {
    private Activity mActivity;
    private int mThemeId;

    ThemeResPicker(Context context, DidiThemeManager didiThemeManager) {
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
        } else {
            this.mActivity = ActivityStack.takeInstance();
        }
        this.mThemeId = didiThemeManager.getThemeId(this.mActivity);
    }

    public int getColor(int i) {
        if (!(this.mThemeId == -1 || this.mActivity == null)) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = this.mActivity.getTheme();
            try {
                theme.resolveAttribute(i, typedValue, true);
                if (typedValue.resourceId <= 0) {
                    return typedValue.data;
                }
                return ResourcesCompat.getColor(this.mActivity.getResources(), typedValue.resourceId, theme);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public ColorStateList getColorStateList(int i) {
        if (this.mThemeId == -1 || this.mActivity == null) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = this.mActivity.getTheme();
        try {
            theme.resolveAttribute(i, typedValue, true);
            return ResourcesCompat.getColorStateList(this.mActivity.getResources(), typedValue.resourceId, theme);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Drawable getDrawable(int i) {
        if (!(this.mThemeId == -1 || this.mActivity == null)) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = this.mActivity.getTheme();
            try {
                theme.resolveAttribute(i, typedValue, true);
                return ResourcesCompat.getDrawableForDensity(this.mActivity.getResources(), typedValue.resourceId, this.mActivity.getResources().getDisplayMetrics().densityDpi, theme);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new BitmapDrawable();
    }

    public int getResIdByTheme(int i) {
        if (!(this.mThemeId == -1 || this.mActivity == null)) {
            TypedValue typedValue = new TypedValue();
            try {
                this.mActivity.getTheme().resolveAttribute(i, typedValue, true);
                return typedValue.resourceId;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}

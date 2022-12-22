package com.android.didi.theme;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;

public class DidiThemeManager {
    private boolean isInit;
    private int mApplicationTheme;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final DidiThemeManager _this = new DidiThemeManager();

        private Holder() {
        }
    }

    public static DidiThemeManager getIns() {
        return Holder._this;
    }

    private DidiThemeManager() {
        this.mApplicationTheme = -1;
    }

    public void init(Application application) {
        ActivityStack.init(application);
        this.isInit = true;
    }

    public void setApplicationTheme(Application application, int i) {
        if (application != null && this.isInit) {
            applicationTheme(application, i);
        }
    }

    public void setThemeBeforeInflate(Activity activity, int i) {
        if (activity != null && this.isInit) {
            assentBeforeInflate(activity);
            activityTheme(activity, i);
        }
    }

    public int getCurrentTheme(Activity activity) {
        return getThemeId(activity);
    }

    public int getApplicationTheme() {
        return this.mApplicationTheme;
    }

    public ThemeResPicker getResPicker(Context context) {
        if (!this.isInit) {
            return null;
        }
        return new ThemeResPicker(context, Holder._this);
    }

    /* access modifiers changed from: package-private */
    public int getThemeId(Activity activity) {
        if (!this.isInit) {
            return -1;
        }
        try {
            return ((Integer) activity.getClass().getMethod("getThemeResId", new Class[0]).invoke(activity, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void activityTheme(Activity activity, int i) {
        if (this.isInit) {
            activity.setTheme(i);
        }
    }

    private void applicationTheme(Application application, int i) {
        if (this.isInit) {
            application.setTheme(i);
            this.mApplicationTheme = i;
        }
    }

    private void assentBeforeInflate(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            throw new IllegalStateException("该方法需要在setContentView/LayoutInflate之前调用");
        }
    }
}

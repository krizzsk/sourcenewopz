package com.didichuxing.omega.sdk.uicomponents.floatingview;

import android.app.Activity;
import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingViewConfig;

public class FloatingViewApi {
    private static ActivityLifecycleMonitor activityLifecycleMonitor;
    private static Application app;
    /* access modifiers changed from: private */
    public static FloatingMenuView floatingMenuView;

    @Deprecated
    public static void init(Application application, int i, int i2) {
        init(application);
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.setViewLocation(C16159Util.dpToPx(application, (float) i), C16159Util.dpToPx(application, (float) i2));
        }
    }

    public static void init(Application application) {
        if (floatingMenuView == null && app == null) {
            app = application;
            UIComponentCache.init(application);
            ActivityLifecycleMonitor activityLifecycleMonitor2 = new ActivityLifecycleMonitor();
            activityLifecycleMonitor = activityLifecycleMonitor2;
            application.registerActivityLifecycleCallbacks(activityLifecycleMonitor2);
            try {
                floatingMenuView = new FloatingMenuView(application);
            } catch (Throwable th) {
                SystemUtils.log(3, "floagting view", "init floating view err!\n" + Log.getStackTraceString(th), (Throwable) null, "com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingViewApi", 59);
                floatingMenuView = null;
            }
        }
    }

    public static void init(Application application, Activity activity) {
        init(application);
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null && floatingMenuView2.getCurrentActivity() == null) {
            floatingMenuView.setCurrentActivity(activity);
        }
    }

    public static void uninit() {
        FloatingMenuView floatingMenuView2;
        if (app != null && activityLifecycleMonitor != null && (floatingMenuView2 = floatingMenuView) != null) {
            floatingMenuView2.hiddenSubMenu();
            floatingMenuView.hidden();
            app.unregisterActivityLifecycleCallbacks(activityLifecycleMonitor);
            app = null;
            activityLifecycleMonitor = null;
            floatingMenuView = null;
        }
    }

    public static void show(Activity activity) {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.show(activity);
        }
    }

    public static void addSubMenuItem(Drawable drawable, String str, FloatingViewMenuItemListener floatingViewMenuItemListener) {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.addSubMenuItem(drawable, str, 0, floatingViewMenuItemListener);
        }
    }

    public static void addSubMenuItem(Drawable drawable, String str, int i, FloatingViewMenuItemListener floatingViewMenuItemListener) {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.addSubMenuItem(drawable, str, i, floatingViewMenuItemListener);
        }
    }

    public static void setSubMenuOrderWeight(String str, int i) {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.setSubMenuItemOrderWeight(str, i % 100);
        }
    }

    public static void removeSubMenuItem(String str) {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.removeSubMenuItem(str);
            if (floatingMenuView.getMenuItemCount() == 0) {
                floatingMenuView.hidden();
                floatingMenuView.hiddenSubMenu();
            }
        }
    }

    public static void updateSubMenuItemText(String str, String str2) {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.updateSubMenuItemText(str, str2);
        }
    }

    public static void updateMenuItemount(String str, int i) {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.updateMenuItemount(str, i);
        }
    }

    public static void addHintView(View view, FrameLayout.LayoutParams layoutParams) {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.addHintView(view, layoutParams);
        }
    }

    public static void removeHintView() {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.removeHintView();
        }
    }

    public static void addFloatingViewOnClickLinstener(FloatingViewListener floatingViewListener) {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.addFloatingViewOnClickLinstener(floatingViewListener);
        }
    }

    public static void addExceptActivity(String str) {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.addExceptActivity(str);
        }
    }

    public static boolean isUserClosedFloatingView() {
        return UIComponentCache.isUserClosedFloatingView();
    }

    static class ActivityLifecycleMonitor implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        ActivityLifecycleMonitor() {
        }

        public void onActivityResumed(Activity activity) {
            if (FloatingViewApi.floatingMenuView != null && activity != null) {
                if (FloatingViewApi.floatingMenuView.isExceptActivity(activity)) {
                    FloatingViewApi.floatingMenuView.hidden();
                } else {
                    FloatingViewApi.floatingMenuView.show(activity);
                }
            }
        }

        public void onActivityPaused(Activity activity) {
            if (FloatingViewApi.floatingMenuView != null) {
                FloatingViewApi.floatingMenuView.hidden();
                FloatingViewApi.floatingMenuView.hiddenSubMenu();
            }
        }
    }

    public static void setCurrentActivity(Activity activity) {
        FloatingMenuView floatingMenuView2 = floatingMenuView;
        if (floatingMenuView2 != null) {
            floatingMenuView2.setCurrentActivity(activity);
        }
    }

    public static void setConfig(FloatingViewConfig.IConfig iConfig) {
        FloatingViewConfig.iConfig = iConfig;
    }
}

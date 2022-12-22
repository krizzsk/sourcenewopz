package com.didi.addressnew.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.didi.addressnew.framework.switcher.ISwitcher;
import com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.view.SugViewLayout;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.sdk.env.Page;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class SugMainDialogActivity extends SugMainBaseActivity {

    /* renamed from: b */
    private static final String f4322b = "SugMainDialogActivity";

    /* renamed from: a */
    Application.ActivityLifecycleCallbacks f4323a;

    /* renamed from: c */
    private SugViewLayout f4324c;

    /* access modifiers changed from: protected */
    public int getActLayoutId() {
        return R.layout.sug_main_bottom_dialog_layout;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        ActivityReference.getInstance().setCurrentActivity(this);
        this.f4323a = new processKill();
        getApplication().registerActivityLifecycleCallbacks(this.f4323a);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT <= 22) {
            getWindow().setSoftInputMode(48);
        }
        if (PaxEnvironment.getInstance().getPage() != Page.SUG_PAGE) {
            PaxEnvironment.getInstance().setPage(Page.SUG_PAGE);
        }
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        SugViewLayout sugViewLayout = (SugViewLayout) findViewById(R.id.sugDragViewLayout);
        this.f4324c = sugViewLayout;
        sugViewLayout.setOnDragCompleteListener(this);
        m2629a();
    }

    /* renamed from: a */
    private void m2629a() {
        this.mSugPageContainer.setVisibility(0);
        this.f4324c.setContentTopMargin(DisplayUtils.dp2px(this, 20.0f), m2630b());
    }

    /* renamed from: b */
    private int m2630b() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        int statusBarHeight = ViewUtils.getStatusBarHeight(this);
        int navigationBarHeight = ViewUtils.getNavigationBarHeight(this);
        int i = displayMetrics.heightPixels - statusBarHeight;
        return ViewUtils.isNavigationBarShow(this) ? i - navigationBarHeight : i;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getApplication().unregisterActivityLifecycleCallbacks(this.f4323a);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (getCurrentFocus() != null) {
            getCurrentFocus().clearFocus();
            ViewUtils.hideInputWindow(this, getCurrentFocus());
        }
    }

    public void setPageDragEnable(boolean z) {
        this.f4324c.setDragEnable(z);
    }

    public void onBackPressed() {
        ISwitcher instance = SwitcherImpl.getInstance();
        if (instance != null && instance.onBackPressed()) {
            this.f4324c.startPullAnim();
        }
    }

    class processKill implements Application.ActivityLifecycleCallbacks {
        private int activityCount = 0;

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        processKill() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            ActivityManager.RunningTaskInfo runningTaskInfo;
            if (bundle != null) {
                if (this.activityCount == 0 || activity.isTaskRoot()) {
                    SystemUtils.log(3, SugMainDialogActivity.f4322b, "onActivityCreated: " + this.activityCount, (Throwable) null, "com.didi.addressnew.framework.SugMainDialogActivity$processKill", 123);
                    ActivityManager activityManager = (ActivityManager) SugMainDialogActivity.this.getSystemService("activity");
                    String str = null;
                    if (!(activityManager.getRunningTasks(1) == null || activityManager.getRunningTasks(1).size() <= 0 || (runningTaskInfo = activityManager.getRunningTasks(1).get(0)) == null || runningTaskInfo.topActivity == null)) {
                        str = runningTaskInfo.topActivity.getClassName();
                    }
                    if (str != null && str.equals("com.didi.addressnew.framework.SugMainDialogActivity") && ActivityReference.getInstance().getCurrentActivity() != null) {
                        SystemUtils.log(3, SugMainDialogActivity.f4322b, "onActivityCreated:SugMainDialogActivity finished! ", (Throwable) null, "com.didi.addressnew.framework.SugMainDialogActivity$processKill", 136);
                        ActivityReference.getInstance().getCurrentActivity().finish();
                    }
                }
            }
        }

        public void onActivityStarted(Activity activity) {
            SystemUtils.log(3, SugMainDialogActivity.f4322b, "onActivityStarted: ", (Throwable) null, "com.didi.addressnew.framework.SugMainDialogActivity$processKill", 144);
            this.activityCount++;
        }

        public void onActivityStopped(Activity activity) {
            this.activityCount--;
        }
    }
}

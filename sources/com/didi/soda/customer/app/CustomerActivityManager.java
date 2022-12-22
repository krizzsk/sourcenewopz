package com.didi.soda.customer.app;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import java.util.Stack;

public class CustomerActivityManager {

    /* renamed from: a */
    private static final String f40305a = "CustomerActivityManager";

    /* renamed from: b */
    private static CustomerActivityManager f40306b;

    /* renamed from: c */
    private Stack<Activity> f40307c = new Stack<>();

    public static CustomerActivityManager getInstance() {
        if (f40306b == null) {
            synchronized (CustomerActivityManager.class) {
                if (f40306b == null) {
                    f40306b = new CustomerActivityManager();
                }
            }
        }
        return f40306b;
    }

    public boolean findActivityAlive(Class cls) {
        Stack<Activity> stack = this.f40307c;
        if (stack == null || stack.empty()) {
            LogUtil.m29104i(f40305a, "mActivityStacks isEmpty");
            return false;
        }
        for (int i = 0; i < this.f40307c.size(); i++) {
            LogUtil.m29104i(f40305a, "mActivityStacks name =" + ((Activity) this.f40307c.get(i)).getClass().getSimpleName());
            if (((Activity) this.f40307c.get(i)).getClass().getSimpleName().equals(cls.getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    public boolean findActivityTop(Class cls) {
        Stack<Activity> stack = this.f40307c;
        if (stack != null && !stack.empty()) {
            Stack<Activity> stack2 = this.f40307c;
            if (((Activity) stack2.get(stack2.size() - 1)).getClass().getSimpleName().equals(cls.getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    public void init(Application application) {
        m28574a(application);
    }

    public boolean isEmpty() {
        Stack<Activity> stack = this.f40307c;
        return stack == null || stack.empty();
    }

    public void popToRoot() {
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).popToRootActivity();
    }

    /* renamed from: a */
    private void m28574a(Application application) {
        if (Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                public void onActivityPaused(Activity activity) {
                }

                public void onActivityResumed(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                }

                public void onActivityStopped(Activity activity) {
                }

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    CustomerActivityManager.this.m28573a(activity);
                }

                public void onActivityDestroyed(Activity activity) {
                    CustomerActivityManager.this.m28576b(activity);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28573a(Activity activity) {
        if (activity != null) {
            this.f40307c.add(activity);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28576b(Activity activity) {
        if (activity != null) {
            this.f40307c.remove(activity);
        }
    }
}

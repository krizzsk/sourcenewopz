package com.didi.entrega.customer.app;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IOneSdkService;
import java.util.Stack;

public class CustomerActivityManager {

    /* renamed from: a */
    private static final String f19768a = "CustomerActivityManager";

    /* renamed from: b */
    private static CustomerActivityManager f19769b;

    /* renamed from: c */
    private Stack<Activity> f19770c = new Stack<>();

    public static CustomerActivityManager getInstance() {
        if (f19769b == null) {
            synchronized (CustomerActivityManager.class) {
                if (f19769b == null) {
                    f19769b = new CustomerActivityManager();
                }
            }
        }
        return f19769b;
    }

    public boolean findActivityAlive(Class cls) {
        Stack<Activity> stack = this.f19770c;
        if (stack == null || stack.empty()) {
            LogUtil.m14765i(f19768a, "mActivityStacks isEmpty");
            return false;
        }
        for (int i = 0; i < this.f19770c.size(); i++) {
            LogUtil.m14765i(f19768a, "mActivityStacks name =" + ((Activity) this.f19770c.get(i)).getClass().getSimpleName());
            if (((Activity) this.f19770c.get(i)).getClass().getSimpleName().equals(cls.getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    public boolean findActivityTop(Class cls) {
        Stack<Activity> stack = this.f19770c;
        if (stack != null && !stack.empty()) {
            Stack<Activity> stack2 = this.f19770c;
            if (((Activity) stack2.get(stack2.size() - 1)).getClass().getSimpleName().equals(cls.getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    public void init(Application application) {
        m14655a(application);
    }

    public boolean isEmpty() {
        Stack<Activity> stack = this.f19770c;
        return stack == null || stack.empty();
    }

    public void popToRoot() {
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).popToRootActivity();
    }

    /* renamed from: a */
    private void m14655a(Application application) {
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
                    CustomerActivityManager.this.m14654a(activity);
                }

                public void onActivityDestroyed(Activity activity) {
                    CustomerActivityManager.this.m14657b(activity);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14654a(Activity activity) {
        if (activity != null) {
            this.f19770c.add(activity);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14657b(Activity activity) {
        if (activity != null) {
            this.f19770c.remove(activity);
        }
    }
}

package com.didi.entrega.customer.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.rpc.Clock;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class CustomerApplicationLifecycleHandler {

    /* renamed from: a */
    private static final String f19771a = "CustomerApplicationLifecycleHandler";

    /* renamed from: b */
    private List<ApplicationForegroundListener> f19772b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f19773c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f19774d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f19775e;

    /* renamed from: f */
    private WeakReference<Application> f19776f;

    /* renamed from: g */
    private Application.ActivityLifecycleCallbacks f19777g;

    /* renamed from: h */
    private int f19778h;

    /* renamed from: i */
    private Application.ActivityLifecycleCallbacks f19779i;

    /* renamed from: b */
    static /* synthetic */ int m14663b(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f19773c;
        customerApplicationLifecycleHandler.f19773c = i + 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m14665c(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f19773c;
        customerApplicationLifecycleHandler.f19773c = i - 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m14666d(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f19778h;
        customerApplicationLifecycleHandler.f19778h = i + 1;
        return i;
    }

    /* renamed from: e */
    static /* synthetic */ int m14667e(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f19778h;
        customerApplicationLifecycleHandler.f19778h = i - 1;
        return i;
    }

    private CustomerApplicationLifecycleHandler() {
        this.f19772b = new ArrayList();
        this.f19773c = 0;
        this.f19774d = -1;
        this.f19775e = -1;
        this.f19777g = new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
                RecordTracker.Builder.create().setTag(CustomerApplicationLifecycleHandler.f19771a).setMessage("ActivityLifecycleCallbacks --> onActivityStarted").setOtherParam("mActivityName", activity.getClass().getSimpleName()).setOtherParam("mActivity", String.valueOf(activity)).setOtherParam("mForegroundActNum", Integer.valueOf(CustomerApplicationLifecycleHandler.this.f19773c)).build().info();
                if (CustomerApplicationLifecycleHandler.this.f19773c <= 0) {
                    long unused = CustomerApplicationLifecycleHandler.this.f19774d = Clock.timeAtSeconds();
                    CustomerApplicationLifecycleHandler.this.m14662a(true);
                }
                CustomerApplicationLifecycleHandler.m14663b(CustomerApplicationLifecycleHandler.this);
            }

            public void onActivityStopped(Activity activity) {
                RecordTracker.Builder.create().setTag(CustomerApplicationLifecycleHandler.f19771a).setMessage("ActivityLifecycleCallbacks --> onActivityStopped").setOtherParam("mActivityName", activity.getClass().getSimpleName()).setOtherParam("mActivity", String.valueOf(activity)).setOtherParam("mForegroundActNum", Integer.valueOf(CustomerApplicationLifecycleHandler.this.f19773c)).build().info();
                CustomerApplicationLifecycleHandler.m14665c(CustomerApplicationLifecycleHandler.this);
                if (CustomerApplicationLifecycleHandler.this.f19773c <= 0) {
                    long unused = CustomerApplicationLifecycleHandler.this.f19775e = Clock.timeAtSeconds();
                    CustomerApplicationLifecycleHandler.this.m14662a(false);
                }
            }
        };
        this.f19778h = 0;
        this.f19779i = new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
                CustomerApplicationLifecycleHandler.m14666d(CustomerApplicationLifecycleHandler.this);
            }

            public void onActivityStopped(Activity activity) {
                CustomerApplicationLifecycleHandler.m14667e(CustomerApplicationLifecycleHandler.this);
            }
        };
    }

    public static CustomerApplicationLifecycleHandler getInstance() {
        return Holder.INSTANCE;
    }

    public void clear() {
        synchronized (this.f19772b) {
            this.f19772b.clear();
            this.f19773c = 0;
            this.f19774d = -1;
            this.f19775e = -1;
        }
        WeakReference<Application> weakReference = this.f19776f;
        if (weakReference != null && weakReference.get() != null) {
            ((Application) this.f19776f.get()).unregisterActivityLifecycleCallbacks(this.f19777g);
            this.f19776f.clear();
            this.f19776f = null;
        }
    }

    public void initLifecycle(Application application) {
        this.f19773c = this.f19778h;
        WeakReference<Application> weakReference = new WeakReference<>(application);
        this.f19776f = weakReference;
        ((Application) weakReference.get()).registerActivityLifecycleCallbacks(this.f19777g);
    }

    public void initPreLifecycle(Application application) {
        this.f19778h = 0;
        application.registerActivityLifecycleCallbacks(this.f19779i);
    }

    public void registerForegroundListener(ApplicationForegroundListener applicationForegroundListener) {
        synchronized (this.f19772b) {
            if (applicationForegroundListener != null) {
                if (!this.f19772b.contains(applicationForegroundListener)) {
                    this.f19772b.add(applicationForegroundListener);
                }
            }
        }
    }

    public void unregisterForegroundListener(ApplicationForegroundListener applicationForegroundListener) {
        synchronized (this.f19772b) {
            if (applicationForegroundListener != null) {
                this.f19772b.remove(applicationForegroundListener);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14662a(boolean z) {
        if (this.f19774d > 0 || this.f19775e > 0) {
            synchronized (this.f19772b) {
                ArrayList<ApplicationForegroundListener> arrayList = new ArrayList<>();
                arrayList.addAll(this.f19772b);
                for (ApplicationForegroundListener applicationForegroundListener : arrayList) {
                    if (applicationForegroundListener != null) {
                        if (z) {
                            applicationForegroundListener.onBecomeForeground(this.f19774d, this.f19775e);
                        } else {
                            applicationForegroundListener.onBecomeBackground(this.f19775e, this.f19774d);
                        }
                    }
                }
            }
        }
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerApplicationLifecycleHandler INSTANCE = new CustomerApplicationLifecycleHandler();

        private Holder() {
        }
    }
}

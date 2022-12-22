package com.didi.soda.customer.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.rpc.Clock;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class CustomerApplicationLifecycleHandler {

    /* renamed from: a */
    private static final String f40308a = "CustomerApplicationLifecycleHandler";

    /* renamed from: b */
    private List<ApplicationForegroundListener> f40309b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f40310c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f40311d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f40312e;

    /* renamed from: f */
    private WeakReference<Application> f40313f;

    /* renamed from: g */
    private Application.ActivityLifecycleCallbacks f40314g;

    /* renamed from: h */
    private int f40315h;

    /* renamed from: i */
    private Application.ActivityLifecycleCallbacks f40316i;

    /* renamed from: b */
    static /* synthetic */ int m28582b(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f40310c;
        customerApplicationLifecycleHandler.f40310c = i + 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m28584c(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f40310c;
        customerApplicationLifecycleHandler.f40310c = i - 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m28585d(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f40315h;
        customerApplicationLifecycleHandler.f40315h = i + 1;
        return i;
    }

    /* renamed from: e */
    static /* synthetic */ int m28586e(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f40315h;
        customerApplicationLifecycleHandler.f40315h = i - 1;
        return i;
    }

    private CustomerApplicationLifecycleHandler() {
        this.f40309b = new ArrayList();
        this.f40310c = 0;
        this.f40311d = -1;
        this.f40312e = -1;
        this.f40314g = new Application.ActivityLifecycleCallbacks() {
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
                RecordTracker.Builder.create().setTag(CustomerApplicationLifecycleHandler.f40308a).setMessage("ActivityLifecycleCallbacks --> onActivityStarted").setOtherParam("mActivityName", activity.getClass().getSimpleName()).setOtherParam("mActivity", String.valueOf(activity)).setOtherParam("mForegroundActNum", Integer.valueOf(CustomerApplicationLifecycleHandler.this.f40310c)).build().info();
                if (CustomerApplicationLifecycleHandler.this.f40310c <= 0) {
                    long unused = CustomerApplicationLifecycleHandler.this.f40311d = Clock.timeAtSeconds();
                    CustomerApplicationLifecycleHandler.this.m28581a(true);
                }
                CustomerApplicationLifecycleHandler.m28582b(CustomerApplicationLifecycleHandler.this);
            }

            public void onActivityStopped(Activity activity) {
                RecordTracker.Builder.create().setTag(CustomerApplicationLifecycleHandler.f40308a).setMessage("ActivityLifecycleCallbacks --> onActivityStopped").setOtherParam("mActivityName", activity.getClass().getSimpleName()).setOtherParam("mActivity", String.valueOf(activity)).setOtherParam("mForegroundActNum", Integer.valueOf(CustomerApplicationLifecycleHandler.this.f40310c)).build().info();
                CustomerApplicationLifecycleHandler.m28584c(CustomerApplicationLifecycleHandler.this);
                if (CustomerApplicationLifecycleHandler.this.f40310c <= 0) {
                    long unused = CustomerApplicationLifecycleHandler.this.f40312e = Clock.timeAtSeconds();
                    CustomerApplicationLifecycleHandler.this.m28581a(false);
                }
            }
        };
        this.f40315h = 0;
        this.f40316i = new Application.ActivityLifecycleCallbacks() {
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
                CustomerApplicationLifecycleHandler.m28585d(CustomerApplicationLifecycleHandler.this);
            }

            public void onActivityStopped(Activity activity) {
                CustomerApplicationLifecycleHandler.m28586e(CustomerApplicationLifecycleHandler.this);
            }
        };
    }

    public static CustomerApplicationLifecycleHandler getInstance() {
        return Holder.INSTANCE;
    }

    public void clear() {
        synchronized (this.f40309b) {
            this.f40309b.clear();
            this.f40310c = 0;
            this.f40311d = -1;
            this.f40312e = -1;
        }
        WeakReference<Application> weakReference = this.f40313f;
        if (weakReference != null && weakReference.get() != null) {
            ((Application) this.f40313f.get()).unregisterActivityLifecycleCallbacks(this.f40314g);
            this.f40313f.clear();
            this.f40313f = null;
        }
    }

    public void initLifecycle(Application application) {
        this.f40310c = this.f40315h;
        WeakReference<Application> weakReference = new WeakReference<>(application);
        this.f40313f = weakReference;
        ((Application) weakReference.get()).registerActivityLifecycleCallbacks(this.f40314g);
    }

    public void initPreLifecycle(Application application) {
        this.f40315h = 0;
        application.registerActivityLifecycleCallbacks(this.f40316i);
    }

    public void registerForegroundListener(ApplicationForegroundListener applicationForegroundListener) {
        synchronized (this.f40309b) {
            if (applicationForegroundListener != null) {
                if (!this.f40309b.contains(applicationForegroundListener)) {
                    this.f40309b.add(applicationForegroundListener);
                }
            }
        }
    }

    public void unregisterForegroundListener(ApplicationForegroundListener applicationForegroundListener) {
        synchronized (this.f40309b) {
            if (applicationForegroundListener != null) {
                this.f40309b.remove(applicationForegroundListener);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28581a(boolean z) {
        if (this.f40311d > 0 || this.f40312e > 0) {
            synchronized (this.f40309b) {
                ArrayList<ApplicationForegroundListener> arrayList = new ArrayList<>();
                arrayList.addAll(this.f40309b);
                for (ApplicationForegroundListener applicationForegroundListener : arrayList) {
                    if (applicationForegroundListener != null) {
                        if (z) {
                            applicationForegroundListener.onBecomeForeground(this.f40311d, this.f40312e);
                        } else {
                            applicationForegroundListener.onBecomeBackground(this.f40312e, this.f40311d);
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

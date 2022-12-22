package xcrash;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

class ActivityMonitor$1 implements Application.ActivityLifecycleCallbacks {
    private int activityReferences = 0;
    private boolean isActivityChangingConfigurations = false;
    final /* synthetic */ C3163a this$0;

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    ActivityMonitor$1(C3163a aVar) {
        this.this$0 = aVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.this$0.f7068b.addFirst(activity);
        if (this.this$0.f7068b.size() > 100) {
            this.this$0.f7068b.removeLast();
        }
    }

    public void onActivityStarted(Activity activity) {
        int i = this.activityReferences + 1;
        this.activityReferences = i;
        if (i == 1 && !this.isActivityChangingConfigurations) {
            boolean unused = this.this$0.f7069c = true;
        }
    }

    public void onActivityStopped(Activity activity) {
        boolean isChangingConfigurations = activity.isChangingConfigurations();
        this.isActivityChangingConfigurations = isChangingConfigurations;
        int i = this.activityReferences - 1;
        this.activityReferences = i;
        if (i == 0 && !isChangingConfigurations) {
            boolean unused = this.this$0.f7069c = false;
        }
    }

    public void onActivityDestroyed(Activity activity) {
        this.this$0.f7068b.remove(activity);
    }
}

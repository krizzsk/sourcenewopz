package xcrash;

import android.app.Activity;
import android.app.Application;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: xcrash.a */
/* compiled from: ActivityMonitor */
class C3163a {

    /* renamed from: a */
    private static final C3163a f7066a = new C3163a();

    /* renamed from: d */
    private static final int f7067d = 100;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LinkedList<Activity> f7068b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f7069c = false;

    private C3163a() {
    }

    /* renamed from: a */
    static C3163a m4204a() {
        return f7066a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo38797a(Application application) {
        this.f7068b = new LinkedList<>();
        application.registerActivityLifecycleCallbacks(new ActivityMonitor$1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo38798b() {
        LinkedList<Activity> linkedList = this.f7068b;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((Activity) it.next()).finish();
            }
            this.f7068b.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo38799c() {
        return this.f7069c;
    }
}

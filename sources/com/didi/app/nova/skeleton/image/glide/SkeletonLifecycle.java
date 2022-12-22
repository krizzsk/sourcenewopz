package com.didi.app.nova.skeleton.image.glide;

import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.util.C1850Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class SkeletonLifecycle implements Lifecycle {

    /* renamed from: a */
    private Set<LifecycleListener> f8459a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private boolean f8460b;

    /* renamed from: c */
    private boolean f8461c;

    public void addListener(LifecycleListener lifecycleListener) {
        this.f8459a.add(lifecycleListener);
        if (this.f8460b) {
            lifecycleListener.onDestroy();
        } else if (this.f8461c) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    public void removeListener(LifecycleListener lifecycleListener) {
        this.f8459a.remove(lifecycleListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40974a() {
        this.f8461c = true;
        for (T onStart : C1850Util.getSnapshot(this.f8459a)) {
            onStart.onStart();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo40975b() {
        this.f8461c = false;
        for (T onStop : C1850Util.getSnapshot(this.f8459a)) {
            onStop.onStop();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo40976c() {
        this.f8460b = true;
        for (T onDestroy : C1850Util.getSnapshot(this.f8459a)) {
            onDestroy.onDestroy();
        }
    }
}

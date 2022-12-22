package com.didichuxing.swarm.launcher;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.didichuxing.swarm.launcher.e */
/* compiled from: ViewManagerDelegate */
class C16500e implements ViewManager, Iterable<Map.Entry<View, ViewGroup.LayoutParams>> {

    /* renamed from: a */
    private final ViewManager f49202a;

    /* renamed from: b */
    private final Map<View, ViewGroup.LayoutParams> f49203b = Collections.synchronizedMap(new LinkedHashMap());

    public C16500e(ViewManager viewManager) {
        this.f49202a = viewManager;
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        synchronized (this.f49203b) {
            this.f49202a.addView(view, layoutParams);
            this.f49203b.put(view, layoutParams);
        }
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        this.f49202a.updateViewLayout(view, layoutParams);
        this.f49203b.put(view, layoutParams);
    }

    public void removeView(View view) {
        synchronized (this.f49203b) {
            this.f49202a.removeView(view);
            this.f49203b.remove(view);
        }
    }

    public Iterator<Map.Entry<View, ViewGroup.LayoutParams>> iterator() {
        return this.f49203b.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121214a() {
        synchronized (this.f49203b) {
            for (View visibility : this.f49203b.keySet()) {
                visibility.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo121216b() {
        synchronized (this.f49203b) {
            for (View visibility : this.f49203b.keySet()) {
                visibility.setVisibility(4);
            }
        }
    }
}

package com.didi.component.lifecycle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LifecycleDispatcher implements Lifecycle {

    /* renamed from: a */
    private List<LifecycleListener> f14193a = Collections.synchronizedList(new ArrayList());

    public final void dispatchAdd() {
        for (LifecycleListener onAdd : m9927a()) {
            onAdd.onAdd();
        }
    }

    public final void dispatchPageStart() {
        for (LifecycleListener onPageStart : m9927a()) {
            onPageStart.onPageStart();
        }
    }

    public final void dispatchPageResume() {
        for (LifecycleListener onPageResume : m9927a()) {
            onPageResume.onPageResume();
        }
    }

    public final void dispatchPagePause() {
        for (LifecycleListener onPagePause : m9927a()) {
            onPagePause.onPagePause();
        }
    }

    public final void dispatchPageStop() {
        for (LifecycleListener onPageStop : m9927a()) {
            onPageStop.onPageStop();
        }
    }

    public final void dispatchRemove() {
        for (LifecycleListener onRemove : m9927a()) {
            onRemove.onRemove();
        }
    }

    public final void dispatchPageShow() {
        for (LifecycleListener onPageShow : m9927a()) {
            onPageShow.onPageShow();
        }
    }

    public final void dispatchPageHide() {
        for (LifecycleListener onPageHide : m9927a()) {
            onPageHide.onPageHide();
        }
    }

    public final void dispatchLeaveHome() {
        for (LifecycleListener onLeaveHome : m9927a()) {
            onLeaveHome.onLeaveHome();
        }
    }

    public final void dispatchBackHome() {
        for (LifecycleListener onBackHome : m9927a()) {
            onBackHome.onBackHome();
        }
    }

    public void addLifecycleListener(LifecycleListener lifecycleListener) {
        this.f14193a.add(lifecycleListener);
    }

    /* renamed from: a */
    private LifecycleListener[] m9927a() {
        List<LifecycleListener> list = this.f14193a;
        return (LifecycleListener[]) list.toArray(new LifecycleListener[list.size()]);
    }
}

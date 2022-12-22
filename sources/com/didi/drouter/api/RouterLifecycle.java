package com.didi.drouter.api;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

public class RouterLifecycle implements LifecycleOwner {

    /* renamed from: a */
    private final LifecycleRegistry f19117a;

    public RouterLifecycle() {
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f19117a = lifecycleRegistry;
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public Lifecycle getLifecycle() {
        return this.f19117a;
    }

    public void create() {
        this.f19117a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public void destroy() {
        this.f19117a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }
}

package com.didi.app.nova.skeleton;

import androidx.collection.ArrayMap;
import com.didi.app.nova.skeleton.internal.LiveHandlerImpl;
import java.util.Map;

public abstract class ScopeContextBase implements IScopeLifecycle, ScopeContext {

    /* renamed from: a */
    private INavigator f8261a;

    /* renamed from: b */
    private LiveHandlerImpl f8262b;

    /* renamed from: c */
    private Map<String, Object> f8263c = new ArrayMap();

    public ScopeContext getParent() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract INavigator newNavigator();

    public void onCreate(ILive iLive) {
        m5426a().onCreate(iLive);
    }

    public void onStart(ILive iLive) {
        m5426a().onStart(iLive);
    }

    public void onResume(ILive iLive) {
        m5426a().onResume(iLive);
    }

    public void onPause(ILive iLive) {
        m5426a().onPause(iLive);
    }

    public void onStop(ILive iLive) {
        m5426a().onStop(iLive);
    }

    public void onDestroy(ILive iLive) {
        m5426a().onDestroy(iLive);
    }

    public INavigator getNavigator() {
        if (this.f8261a == null) {
            this.f8261a = newNavigator();
        }
        return this.f8261a;
    }

    public LiveHandler getLiveHandler() {
        return m5426a();
    }

    public boolean addObserver(IScopeLifecycle iScopeLifecycle) {
        return m5426a().addObserver(iScopeLifecycle);
    }

    public boolean removeObserver(IScopeLifecycle iScopeLifecycle) {
        return m5426a().removeObserver(iScopeLifecycle);
    }

    /* renamed from: a */
    private LiveHandlerImpl m5426a() {
        if (this.f8262b == null) {
            this.f8262b = new LiveHandlerImpl();
        }
        return this.f8262b;
    }

    public Object attach(String str, Object obj) {
        return this.f8263c.put(str, obj);
    }

    public Object detach(String str) {
        return this.f8263c.remove(str);
    }

    public Object getObject(String str) {
        return this.f8263c.get(str);
    }

    public void detachAll() {
        this.f8263c.clear();
    }
}

package com.didi.app.nova.skeleton.internal;

import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.LiveHandler;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import java.util.ArrayList;
import java.util.List;

public final class LiveHandlerImpl implements IScopeLifecycle, LiveHandler {

    /* renamed from: a */
    private IScopeLifecycle.PageStatus f8479a;

    /* renamed from: b */
    private List<Cancelable> f8480b = new ArrayList();

    /* renamed from: c */
    private List<IScopeLifecycle> f8481c = new ArrayList();

    public void onCreate(ILive iLive) {
        this.f8479a = IScopeLifecycle.PageStatus.Create;
        m5677a(iLive);
    }

    public void onStart(ILive iLive) {
        this.f8479a = IScopeLifecycle.PageStatus.Start;
        m5677a(iLive);
    }

    public void onResume(ILive iLive) {
        this.f8479a = IScopeLifecycle.PageStatus.Resume;
        m5677a(iLive);
    }

    public void onPause(ILive iLive) {
        this.f8479a = IScopeLifecycle.PageStatus.Pause;
        m5677a(iLive);
    }

    public void onStop(ILive iLive) {
        this.f8479a = IScopeLifecycle.PageStatus.Stop;
        m5677a(iLive);
    }

    public void onDestroy(ILive iLive) {
        this.f8479a = IScopeLifecycle.PageStatus.Destroy;
        m5677a(iLive);
    }

    public boolean addObserver(IScopeLifecycle iScopeLifecycle) {
        return this.f8481c.add(iScopeLifecycle);
    }

    public boolean removeObserver(IScopeLifecycle iScopeLifecycle) {
        return this.f8481c.remove(iScopeLifecycle);
    }

    public void bind(Cancelable cancelable) {
        if (cancelable != null) {
            if (isDestroyed()) {
                cancelable.cancel();
                TraceUtil.trace("LiveHandler", this + "#bind cancel: " + cancelable);
            } else if (!this.f8480b.contains(cancelable)) {
                this.f8480b.add(cancelable);
            }
        }
    }

    public boolean isActive() {
        return this.f8479a == IScopeLifecycle.PageStatus.Create || this.f8479a == IScopeLifecycle.PageStatus.Start || this.f8479a == IScopeLifecycle.PageStatus.Resume;
    }

    public boolean isDestroyed() {
        return this.f8479a == IScopeLifecycle.PageStatus.Destroy;
    }

    /* renamed from: a */
    private void m5677a(ILive iLive) {
        m5678b(iLive);
        if (isDestroyed()) {
            m5676a();
        }
    }

    /* renamed from: b */
    private void m5678b(ILive iLive) {
        for (IScopeLifecycle iScopeLifecycle : new ArrayList(this.f8481c)) {
            if (this.f8479a == IScopeLifecycle.PageStatus.Create) {
                iScopeLifecycle.onCreate(iLive);
            } else if (this.f8479a == IScopeLifecycle.PageStatus.Start) {
                iScopeLifecycle.onStart(iLive);
            } else if (this.f8479a == IScopeLifecycle.PageStatus.Resume) {
                iScopeLifecycle.onResume(iLive);
            } else if (this.f8479a == IScopeLifecycle.PageStatus.Pause) {
                iScopeLifecycle.onPause(iLive);
            } else if (this.f8479a == IScopeLifecycle.PageStatus.Stop) {
                iScopeLifecycle.onStop(iLive);
            } else if (this.f8479a == IScopeLifecycle.PageStatus.Destroy) {
                iScopeLifecycle.onDestroy(iLive);
            }
        }
    }

    /* renamed from: a */
    private void m5676a() {
        for (Cancelable cancelable : new ArrayList(this.f8480b)) {
            if (cancelable != null) {
                cancelable.cancel();
                TraceUtil.trace("LiveHandler", this + "#dispatchDestroyed cancel: " + cancelable);
            }
        }
        this.f8480b.clear();
        this.f8481c.clear();
    }
}

package com.didi.app.nova.skeleton.conductor.internal;

import android.view.View;
import android.view.ViewGroup;

public class ViewAttachHandler implements View.OnAttachStateChangeListener {

    /* renamed from: a */
    private boolean f8408a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f8409b = false;

    /* renamed from: c */
    private boolean f8410c = false;

    /* renamed from: d */
    private ReportedState f8411d = ReportedState.VIEW_DETACHED;

    /* renamed from: e */
    private ViewAttachListener f8412e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnAttachStateChangeListener f8413f;

    private interface ChildAttachListener {
        void onAttached();
    }

    private enum ReportedState {
        VIEW_DETACHED,
        ACTIVITY_STOPPED,
        ATTACHED
    }

    public interface ViewAttachListener {
        void onAttached();

        void onDetached(boolean z);

        void onViewDetachAfterStop();
    }

    public ViewAttachHandler(ViewAttachListener viewAttachListener) {
        this.f8412e = viewAttachListener;
    }

    public void onViewAttachedToWindow(View view) {
        if (!this.f8408a) {
            this.f8408a = true;
            m5605a(view, (ChildAttachListener) new ChildAttachListener() {
                public void onAttached() {
                    boolean unused = ViewAttachHandler.this.f8409b = true;
                    ViewAttachHandler.this.m5604a();
                }
            });
        }
    }

    public void onViewDetachedFromWindow(View view) {
        this.f8408a = false;
        if (this.f8409b) {
            this.f8409b = false;
            m5607a(false);
        }
    }

    public void listenForAttach(View view) {
        view.addOnAttachStateChangeListener(this);
    }

    public void unregisterAttachListener(View view) {
        view.removeOnAttachStateChangeListener(this);
        if (this.f8413f != null && (view instanceof ViewGroup)) {
            m5603a((ViewGroup) view).removeOnAttachStateChangeListener(this.f8413f);
        }
    }

    public void onActivityStarted() {
        this.f8410c = false;
        m5604a();
    }

    public void onActivityStopped() {
        this.f8410c = true;
        m5607a(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5604a() {
        if (this.f8408a && this.f8409b && !this.f8410c && this.f8411d != ReportedState.ATTACHED) {
            this.f8411d = ReportedState.ATTACHED;
            this.f8412e.onAttached();
        }
    }

    /* renamed from: a */
    private void m5607a(boolean z) {
        boolean z2 = this.f8411d == ReportedState.ACTIVITY_STOPPED;
        if (z) {
            this.f8411d = ReportedState.ACTIVITY_STOPPED;
        } else {
            this.f8411d = ReportedState.VIEW_DETACHED;
        }
        if (!z2 || z) {
            this.f8412e.onDetached(z);
        } else {
            this.f8412e.onViewDetachAfterStop();
        }
    }

    /* renamed from: a */
    private void m5605a(View view, final ChildAttachListener childAttachListener) {
        if (!(view instanceof ViewGroup)) {
            childAttachListener.onAttached();
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() == 0) {
            childAttachListener.onAttached();
            return;
        }
        this.f8413f = new View.OnAttachStateChangeListener() {
            boolean attached = false;

            public void onViewDetachedFromWindow(View view) {
            }

            public void onViewAttachedToWindow(View view) {
                if (!this.attached) {
                    this.attached = true;
                    childAttachListener.onAttached();
                    view.removeOnAttachStateChangeListener(this);
                    View.OnAttachStateChangeListener unused = ViewAttachHandler.this.f8413f = null;
                }
            }
        };
        m5603a(viewGroup).addOnAttachStateChangeListener(this.f8413f);
    }

    /* renamed from: a */
    private View m5603a(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() == 0) {
            return viewGroup;
        }
        View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
        return childAt instanceof ViewGroup ? m5603a((ViewGroup) childAt) : childAt;
    }
}

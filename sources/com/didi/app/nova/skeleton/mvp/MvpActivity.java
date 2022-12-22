package com.didi.app.nova.skeleton.mvp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.SkeletonActivity;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;

public abstract class MvpActivity<V extends IView, P extends IPresenter> extends SkeletonActivity {
    public static final int NO_LAYOUT = -1;

    /* renamed from: a */
    P f8495a;

    /* renamed from: b */
    V f8496b;

    public int layoutId() {
        return -1;
    }

    /* access modifiers changed from: protected */
    public V onCreateLogicView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public P onCreatePresenter() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAfterCreate(Bundle bundle) {
        this.f8496b = onCreateLogicView();
        this.f8495a = onCreatePresenter();
        if (layoutId() != -1) {
            setContentView(layoutId());
        }
        V v = this.f8496b;
        if (v != null) {
            v.attachContext(this);
            View inflateView = this.f8496b.inflateView(getLayoutInflater(), (ViewGroup) findViewById(16908290));
            if (layoutId() == -1) {
                setContentView(inflateView);
            }
            this.f8496b.attachPresenter(this.f8495a);
            this.f8496b.onCreate();
        }
        P p = this.f8495a;
        if (p != null) {
            p.attachScopeContext(getScopeContext());
            this.f8495a.attachView(this.f8496b);
            this.f8495a.onCreate();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        V v = this.f8496b;
        if (v != null) {
            v.onStart();
        }
        P p = this.f8495a;
        if (p != null) {
            p.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        V v = this.f8496b;
        if (v != null) {
            v.onResume();
        }
        P p = this.f8495a;
        if (p != null) {
            p.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        V v = this.f8496b;
        if (v != null) {
            v.onPause();
        }
        P p = this.f8495a;
        if (p != null) {
            p.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        V v = this.f8496b;
        if (v != null) {
            v.onStop();
        }
        P p = this.f8495a;
        if (p != null) {
            p.onStop();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        V v = this.f8496b;
        if (v != null) {
            v.onDestroy();
        }
        P p = this.f8495a;
        if (p != null) {
            p.onDestroy();
        }
    }

    /* access modifiers changed from: protected */
    public P getPresenter() {
        return this.f8495a;
    }

    /* access modifiers changed from: protected */
    public V getLogicView() {
        return this.f8496b;
    }
}

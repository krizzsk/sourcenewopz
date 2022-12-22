package com.didi.app.nova.skeleton.mvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.internal.dsl.DslHelper;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import com.didi.soda.nova.skeleton.dsl.ResolveDslResult;
import java.util.List;

public class MvpPage<V extends IView, P extends IPresenter> extends Page {

    /* renamed from: a */
    P f8500a;

    /* renamed from: b */
    V f8501b;

    /* renamed from: c */
    private ResolveDslResult f8502c = null;

    /* access modifiers changed from: protected */
    public V onCreateLogicView(View view) {
        return null;
    }

    /* access modifiers changed from: protected */
    public P onCreatePresenter() {
        return null;
    }

    /* access modifiers changed from: protected */
    public P getPresenter() {
        return this.f8500a;
    }

    /* access modifiers changed from: protected */
    public V getLogicView() {
        return this.f8501b;
    }

    /* access modifiers changed from: protected */
    public final String overrideTitle() {
        ResolveDslResult resolveDslResult = this.f8502c;
        if (resolveDslResult == null) {
            return null;
        }
        if (resolveDslResult.titleStrId != 0) {
            return getString(this.f8502c.titleStrId);
        }
        if (this.f8502c.titleString != null) {
            return this.f8502c.titleString;
        }
        return null;
    }

    public void onInitialize() {
        super.onInitialize();
        String alias = alias();
        TraceUtil.trace(alias, this + " onInitialize start ");
        ResolveDslResult pageDslInfo = DslHelper.getPageDslInfo(getClass());
        this.f8502c = pageDslInfo;
        if (pageDslInfo != null) {
            this.f8500a = (IPresenter) pageDslInfo.presenter;
            this.f8501b = (IView) this.f8502c.logicView;
        }
        if (this.f8500a == null) {
            this.f8500a = onCreatePresenter();
        }
        if (this.f8501b == null) {
            this.f8501b = onCreateLogicView(getView());
        }
        V v = this.f8501b;
        if (v != null) {
            v.attachContext(getBaseContext());
            this.f8501b.attachPresenter(this.f8500a);
        }
        P p = this.f8500a;
        if (p != null) {
            p.attachScopeContext(getScopeContext());
            this.f8500a.attachView(this.f8501b);
        }
        String alias2 = alias();
        TraceUtil.trace(alias2, this + " onInitialize end ");
    }

    public final View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ResolveDslResult resolveDslResult = this.f8502c;
        View inflate = (resolveDslResult == null || resolveDslResult.layoutId == 0) ? null : layoutInflater.inflate(this.f8502c.layoutId, viewGroup, false);
        if (inflate == null) {
            inflate = this.f8501b.inflateView(layoutInflater, viewGroup);
        } else {
            this.f8501b.inflateView(layoutInflater, (ViewGroup) inflate);
        }
        this.f8501b.mView = inflate;
        return inflate;
    }

    public void onCreate(View view) {
        List<Component> newPageComponents;
        if (!(this.f8502c == null || (newPageComponents = DslHelper.newPageComponents(getClass(), this.f8502c, view)) == null || newPageComponents.size() <= 0)) {
            for (Component addComponent : newPageComponents) {
                addComponent(addComponent);
            }
        }
        super.onCreate(view);
        V v = this.f8501b;
        if (v != null) {
            v.onCreate();
        }
        P p = this.f8500a;
        if (p != null) {
            p.onCreate();
        }
    }

    public void onStart() {
        super.onStart();
        V v = this.f8501b;
        if (v != null) {
            v.onStart();
        }
        P p = this.f8500a;
        if (p != null) {
            p.onStart();
        }
    }

    public void onResume() {
        super.onResume();
        V v = this.f8501b;
        if (v != null) {
            v.onResume();
        }
        P p = this.f8500a;
        if (p != null) {
            p.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        P p = this.f8500a;
        if (p != null) {
            p.onPause();
        }
        V v = this.f8501b;
        if (v != null) {
            v.onPause();
        }
    }

    public void onStop() {
        super.onStop();
        P p = this.f8500a;
        if (p != null) {
            p.onStop();
        }
        V v = this.f8501b;
        if (v != null) {
            v.onStop();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        P p = this.f8500a;
        if (p != null) {
            p.onDestroy();
        }
        V v = this.f8501b;
        if (v != null) {
            v.onDestroy();
            this.f8501b.mView = null;
        }
    }
}

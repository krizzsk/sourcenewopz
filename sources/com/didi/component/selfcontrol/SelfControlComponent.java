package com.didi.component.selfcontrol;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.component.config.IComponentEx;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;
import com.didi.component.core.util.CLog;
import com.didi.component.selfcontrol.InflateController;

public abstract class SelfControlComponent<V extends IView, P extends IPresenter, C extends InflateController> implements IComponentEx {
    public static final String BUNDLE_KEY_MUST_INFLATE = "BUNDLE_KEY_MUST_INFLATE";

    /* renamed from: a */
    private V f15493a;

    /* renamed from: b */
    private P f15494b;

    /* renamed from: c */
    private ComponentParams f15495c;

    /* renamed from: d */
    private Bundle f15496d;
    protected C mInflateController;
    public boolean mIsDefaultVisible = true;

    /* access modifiers changed from: protected */
    @Deprecated
    public void bind(ComponentParams componentParams, V v, P p) {
    }

    /* access modifiers changed from: protected */
    public abstract C createInflateController();

    /* access modifiers changed from: protected */
    public abstract P onCreatePresenter(ComponentParams componentParams);

    /* access modifiers changed from: protected */
    public abstract V onCreateView(ComponentParams componentParams, ViewGroup viewGroup);

    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        this.mInflateController = createInflateController();
        if (m11156a(componentParams) || componentParams.extras.getBoolean(BUNDLE_KEY_MUST_INFLATE, false)) {
            this.mIsDefaultVisible = m11157b(componentParams);
            m11155a(componentParams, viewGroup);
            return;
        }
        CLog.m8711w("SelfControlComponent@init, " + componentParams.type + " is not allow to inflate.");
    }

    /* renamed from: a */
    private boolean m11156a(ComponentParams componentParams) {
        C c = this.mInflateController;
        if (c != null) {
            return c.shouldInflate(componentParams);
        }
        return true;
    }

    /* renamed from: b */
    private boolean m11157b(ComponentParams componentParams) {
        C c = this.mInflateController;
        if (c != null) {
            return c.isVisible(componentParams);
        }
        return true;
    }

    /* renamed from: a */
    private void m11155a(ComponentParams componentParams, ViewGroup viewGroup) {
        V v;
        m11158c(componentParams);
        this.f15495c = componentParams;
        this.f15493a = onCreateView(componentParams, viewGroup);
        P onCreatePresenter = onCreatePresenter(componentParams);
        this.f15494b = onCreatePresenter;
        if (!(onCreatePresenter == null || (v = this.f15493a) == null)) {
            onCreatePresenter.setIView(v);
            this.f15493a.setPresenter(this.f15494b);
        }
        bind(componentParams, this.f15493a, this.f15494b);
    }

    public void setExtras(Bundle bundle) {
        this.f15496d = bundle;
    }

    public <T> T getExtra(String str) {
        Bundle bundle = this.f15496d;
        if (bundle == null) {
            return null;
        }
        return bundle.get(str);
    }

    public void changeVisible(boolean z) {
        V v;
        if (this.mIsDefaultVisible != z && (v = this.f15493a) != null) {
            this.mIsDefaultVisible = z;
            if (v.getView() != null) {
                this.f15493a.getView().setVisibility(z ? 0 : 8);
            }
        }
    }

    public V getView() {
        return this.f15493a;
    }

    public P getPresenter() {
        return this.f15494b;
    }

    public ComponentParams getParams() {
        return this.f15495c;
    }

    /* renamed from: c */
    private void m11158c(ComponentParams componentParams) {
        Bundle bundle;
        if (componentParams != null && (bundle = this.f15496d) != null && !bundle.isEmpty()) {
            componentParams.extras.putAll(this.f15496d);
            componentParams.bid = ((Integer) getExtra("BUNDLE_KEY_BID")).intValue();
            componentParams.comboType = ((Integer) getExtra("BUNDLE_KEY_COMBO_TYPE")).intValue();
        }
    }
}

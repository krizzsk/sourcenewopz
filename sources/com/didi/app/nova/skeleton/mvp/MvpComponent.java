package com.didi.app.nova.skeleton.mvp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.internal.dsl.DslHelper;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.nova.skeleton.dsl.ResolveDslResult;
import com.didi.soda.nova.skeleton.dsl.annotations.Layout;

public class MvpComponent<V extends IView, P extends IPresenter> extends Component {

    /* renamed from: a */
    private V f8497a;

    /* renamed from: b */
    private P f8498b;

    /* renamed from: c */
    private ResolveDslResult f8499c;

    /* access modifiers changed from: protected */
    public P onCreatePresenter() {
        return null;
    }

    /* access modifiers changed from: protected */
    public V onCreateView() {
        return null;
    }

    public MvpComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        ResolveDslResult componentDslInfo = DslHelper.getComponentDslInfo(getClass());
        this.f8499c = componentDslInfo;
        if (componentDslInfo != null) {
            this.f8498b = (IPresenter) componentDslInfo.presenter;
            this.f8497a = (IView) this.f8499c.logicView;
        }
        if (this.f8497a == null) {
            this.f8497a = onCreateView();
        }
        if (this.f8498b == null) {
            this.f8498b = onCreatePresenter();
        }
        bind(this.f8497a, this.f8498b);
        V v = this.f8497a;
        if (v != null) {
            v.attachContext(this.mContainer.getContext());
            LayoutInflater from = LayoutInflater.from(this.mContainer.getContext());
            ResolveDslResult resolveDslResult = this.f8499c;
            if (resolveDslResult == null || resolveDslResult.layoutId == 0) {
                Layout layout = (Layout) this.f8497a.getClass().getAnnotation(Layout.class);
                if (layout == null || layout.value() == 0) {
                    V v2 = this.f8497a;
                    v2.mView = v2.inflateView(from, this.mContainer);
                } else {
                    this.f8497a.mView = from.inflate(layout.value(), this.mContainer, true);
                }
            } else {
                this.f8497a.mView = from.inflate(this.f8499c.layoutId, this.mContainer, true);
            }
            if (this.f8497a.mView == null) {
                SystemUtils.log(5, "Component", "mLogicalView.mView is null", (Throwable) null, "com.didi.app.nova.skeleton.mvp.MvpComponent", 66);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void bind(V v, P p) {
        if (v != null) {
            v.attachPresenter(p);
        }
        if (p != null) {
            p.attachScopeContext(this.mScopeContext);
            p.attachView(v);
        }
    }

    public final V getLogicView() {
        return this.f8497a;
    }

    public final P getPresenter() {
        return this.f8498b;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        V v = this.f8497a;
        if (v != null) {
            v.onCreate();
        }
        P p = this.f8498b;
        if (p != null) {
            p.onCreate();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        V v = this.f8497a;
        if (v != null) {
            v.onStart();
        }
        P p = this.f8498b;
        if (p != null) {
            p.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        V v = this.f8497a;
        if (v != null) {
            v.onResume();
        }
        P p = this.f8498b;
        if (p != null) {
            p.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        V v = this.f8497a;
        if (v != null) {
            v.onPause();
        }
        P p = this.f8498b;
        if (p != null) {
            p.onPause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        V v = this.f8497a;
        if (v != null) {
            v.onStop();
        }
        P p = this.f8498b;
        if (p != null) {
            p.onStop();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        P p = this.f8498b;
        if (p != null) {
            p.onDestroy();
        }
        V v = this.f8497a;
        if (v != null) {
            v.onDestroy();
        }
    }
}

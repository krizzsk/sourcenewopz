package com.didi.app.nova.support.view.recyclerview.binder.mvp;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemView;

public abstract class MvpItemPresenter<V extends MvpItemView, T> {

    /* renamed from: a */
    private V f8597a;

    /* renamed from: b */
    private T f8598b;

    /* access modifiers changed from: protected */
    public void onAttach() {
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo41313a(V v) {
        this.f8597a = v;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo41314a(T t) {
        this.f8598b = t;
    }

    public final Context getContext() {
        V v = this.f8597a;
        if (v != null) {
            return v.getContext();
        }
        throw new IllegalStateException("View not callAttach to this view of " + getClass().getName());
    }

    public final V getItemView() {
        return this.f8597a;
    }

    public final T getItem() {
        return this.f8598b;
    }
}

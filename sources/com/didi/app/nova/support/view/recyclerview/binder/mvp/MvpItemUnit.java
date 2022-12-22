package com.didi.app.nova.support.view.recyclerview.binder.mvp;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemPresenter;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemView;

public abstract class MvpItemUnit<V extends MvpItemView<P, VH>, P extends MvpItemPresenter<V, T>, T, VH extends ItemViewHolder<T>> {

    /* renamed from: a */
    private static final int f8599a = 2;

    /* renamed from: b */
    private static final int f8600b = 4;

    /* renamed from: c */
    private int f8601c;

    /* renamed from: d */
    private V f8602d;

    /* renamed from: e */
    private P f8603e;

    /* access modifiers changed from: protected */
    public void onAttach() {
    }

    /* access modifiers changed from: protected */
    public void onBind() {
    }

    /* access modifiers changed from: protected */
    public abstract P onCreatePresenter();

    /* access modifiers changed from: protected */
    public abstract V onCreateView();

    /* access modifiers changed from: protected */
    public void onDetach() {
    }

    /* access modifiers changed from: protected */
    public void setupItemView(V v) {
    }

    /* access modifiers changed from: protected */
    public void setupPresenter(P p) {
    }

    /* renamed from: b */
    private void m5724b(VH vh) {
        Context context = vh.itemView.getContext();
        this.f8602d = onCreateView();
        P onCreatePresenter = onCreatePresenter();
        this.f8603e = onCreatePresenter;
        this.f8602d.mo41338a(onCreatePresenter);
        this.f8603e.mo41313a(this.f8602d);
        this.f8602d.mo41336a(context);
        this.f8603e.mo41314a(vh.getItem());
        this.f8602d.mo41337a(vh);
        setupItemView(this.f8602d);
        setupPresenter(this.f8603e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo41322a(VH vh) {
        m5726d();
        m5724b(vh);
        this.f8602d.updateView(vh);
        onBind();
        if (isAttached()) {
            mo41321a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo41321a() {
        m5723b(4);
        m5722a(2);
        onAttach();
        this.f8602d.onAttach();
        this.f8603e.onAttach();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo41323b() {
        m5723b(2);
        m5722a(4);
        onDetach();
        this.f8602d.onDetach();
        this.f8603e.onDetach();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo41324c() {
        m5726d();
    }

    /* renamed from: d */
    private void m5726d() {
        if (isAttached()) {
            mo41323b();
        }
        V v = this.f8602d;
        if (v != null) {
            v.onDestroy();
        }
        P p = this.f8603e;
        if (p != null) {
            p.onDestroy();
        }
        this.f8602d = null;
        this.f8603e = null;
    }

    public boolean isAttached() {
        ItemViewHolder viewHolder;
        V v = this.f8602d;
        if (v == null || (viewHolder = v.getViewHolder()) == null || viewHolder.itemView == null || viewHolder.itemView.getParent() == null) {
            return false;
        }
        return true;
    }

    public boolean hasAttachFlag() {
        return m5725c(2);
    }

    /* renamed from: a */
    private void m5722a(int i) {
        this.f8601c = i | this.f8601c;
    }

    /* renamed from: b */
    private void m5723b(int i) {
        this.f8601c = (~i) & this.f8601c;
    }

    /* renamed from: c */
    private boolean m5725c(int i) {
        return (i & this.f8601c) != 0;
    }

    /* access modifiers changed from: protected */
    public P getItemPresenter() {
        return this.f8603e;
    }

    /* access modifiers changed from: protected */
    public V getItemView() {
        return this.f8602d;
    }
}

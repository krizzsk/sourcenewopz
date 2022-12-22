package com.didi.app.nova.support.view.recyclerview.binder.mvp;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemPresenter;

public abstract class MvpItemView<P extends MvpItemPresenter, VH extends ItemViewHolder> {

    /* renamed from: a */
    private P f8604a;

    /* renamed from: b */
    private VH f8605b;

    /* renamed from: c */
    private Context f8606c;

    /* access modifiers changed from: protected */
    public void onAttach() {
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
    }

    /* access modifiers changed from: protected */
    public abstract void updateView(VH vh);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo41338a(P p) {
        this.f8604a = p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo41336a(Context context) {
        this.f8606c = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo41337a(VH vh) {
        this.f8605b = vh;
    }

    public final Context getContext() {
        return this.f8606c;
    }

    public final P getItemPresenter() {
        return this.f8604a;
    }

    public final VH getViewHolder() {
        return this.f8605b;
    }
}

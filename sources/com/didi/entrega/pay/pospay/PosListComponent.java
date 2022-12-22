package com.didi.entrega.pay.pospay;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class PosListComponent extends MvpComponent<PosListView, PosListPresenter> {
    public PosListComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public PosListView onCreateView() {
        return new PosListView();
    }

    /* access modifiers changed from: protected */
    public PosListPresenter onCreatePresenter() {
        return new PosListPresenter();
    }
}

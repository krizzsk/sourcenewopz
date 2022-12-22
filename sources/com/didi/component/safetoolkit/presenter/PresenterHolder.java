package com.didi.component.safetoolkit.presenter;

import com.didi.component.core.IPresenter;

public class PresenterHolder {

    /* renamed from: a */
    private IPresenter f15407a;

    private static class Holder {
        /* access modifiers changed from: private */
        public static PresenterHolder _Holder = new PresenterHolder();

        private Holder() {
        }
    }

    private PresenterHolder() {
    }

    public static PresenterHolder getIns() {
        return Holder._Holder;
    }

    public void onAdd(IPresenter iPresenter) {
        this.f15407a = iPresenter;
    }

    public void onRemove() {
        this.f15407a = null;
    }

    public boolean isAdded() {
        return this.f15407a != null;
    }

    public IPresenter getPresenter() {
        return this.f15407a;
    }
}

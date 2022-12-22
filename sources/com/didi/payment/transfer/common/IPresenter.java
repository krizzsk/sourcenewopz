package com.didi.payment.transfer.common;

import android.content.Context;
import com.didi.payment.transfer.common.IPageView;

public abstract class IPresenter<V extends IPageView> {

    /* renamed from: a */
    private V f31319a;

    /* access modifiers changed from: protected */
    public abstract Context getContext();

    /* access modifiers changed from: package-private */
    public abstract void onActivityResult(int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void onAdd();

    /* access modifiers changed from: package-private */
    public abstract void onBackPressed();

    /* access modifiers changed from: protected */
    public abstract void onCreate();

    /* access modifiers changed from: package-private */
    public abstract void onPause();

    /* access modifiers changed from: package-private */
    public abstract void onRemove();

    /* access modifiers changed from: package-private */
    public abstract void onStop();

    /* access modifiers changed from: package-private */
    public void setPageView(V v) {
        this.f31319a = v;
    }
}

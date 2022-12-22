package com.didi.component.servicecontrol.nopay;

import android.os.Bundle;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.servicecontrol.nopay.impl.view.IServiceControlNopayView;
import com.didi.travel.psnger.model.response.CashUnPayInterceptInfo;

public abstract class AbsServiceControlNopayPresenter extends BaseExpressPresenter<IServiceControlNopayView> {
    public void bindCardNextTime() {
    }

    public abstract void close();

    public void havePaid() {
    }

    public void payNow() {
    }

    public AbsServiceControlNopayPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public void showNoPayView(CashUnPayInterceptInfo cashUnPayInterceptInfo) {
        ((IServiceControlNopayView) this.mView).showNoPayView(cashUnPayInterceptInfo);
    }
}

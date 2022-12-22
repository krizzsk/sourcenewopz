package com.didiglobal.passenger.brz.component;

import android.content.Context;
import android.content.Intent;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BrazilCarTypeUtil;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.groupform.presenter.AbsGroupFormPresenter;
import com.didi.component.service.activity.rgltaxiguide.RegularTaxiGuideActivity;

public class BrzGroupFormPresenter extends AbsGroupFormPresenter {

    /* renamed from: a */
    private Context f50297a;

    public BrzGroupFormPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f50297a = componentParams.bizCtx.getContext();
        BrazilCarTypeUtil.initOptionsApollo();
    }

    /* access modifiers changed from: protected */
    public void handleTwoPriceSelectSeatConfirmEvent() {
        onConfirmPriceIntercept();
    }

    public void onConfirmPriceIntercept() {
        if (!m36224b() && !showPinInputPage()) {
            onConfirmPrice();
        }
    }

    public void onConfirmPrice() {
        m36225c();
    }

    /* renamed from: b */
    private boolean m36224b() {
        if (!isPricingTaxi() || GlobalSPUtil.getRegularTaxiGuideHasShow(this.f50297a)) {
            return false;
        }
        GlobalSPUtil.setRegularTaxiGuideHasShow(this.f50297a, true);
        startActivityForResult(RegularTaxiGuideActivity.getIntent(this.f50297a), 100);
        return true;
    }

    public boolean isPricingTaxi() {
        if (FormStore.getInstance().getCarLevel() == 1800) {
            return true;
        }
        return super.isPricingTaxi();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && !showPinInputPage()) {
            m36225c();
        }
        super.onActivityResult(i, i2, intent);
    }

    /* renamed from: c */
    private void m36225c() {
        if (BusinessDataUtil.isPriceValid(FormStore.getInstance().getNewEstimateItem())) {
            super.onConfirmPrice();
        }
    }
}

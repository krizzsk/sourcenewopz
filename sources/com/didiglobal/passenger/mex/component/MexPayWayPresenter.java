package com.didiglobal.passenger.mex.component;

import android.os.Bundle;
import com.didi.component.core.ComponentParams;
import com.didi.component.payway.presenter.PayWayPresenter;
import com.didi.sdk.util.ToastHelper;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.taxis99.R;
import java.util.List;

public class MexPayWayPresenter extends PayWayPresenter {
    public MexPayWayPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public Boolean isInterceptNoPayWay(List<PayWayModel.PayWayItem> list) {
        if (list != null && list.size() != 0) {
            return false;
        }
        ToastHelper.showShortInfo(this.mContext, (int) R.string.pay_way_estimate_no_payway);
        return true;
    }
}

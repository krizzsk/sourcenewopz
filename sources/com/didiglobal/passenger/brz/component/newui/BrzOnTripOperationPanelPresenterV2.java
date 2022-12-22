package com.didiglobal.passenger.brz.component.newui;

import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.OnlineHelpUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.operationpanel.impl.newui.presenter.GlobalOnTripOperationPanelPresenterV2;
import com.didi.sdk.push.ServerParam;
import com.didi.travel.psnger.model.response.CarOrder;

public class BrzOnTripOperationPanelPresenterV2 extends GlobalOnTripOperationPanelPresenterV2 {
    public BrzOnTripOperationPanelPresenterV2(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onHelpClicked() {
        GlobalOmegaUtils.trackEvent("pas_drivercard_needhelp_ck");
        startActivityForResult(OnlineHelpUtil.getStartIntent(this.mContext, "https://help.didiglobal.com/processing-passenger.html", OnlineHelpUtil.DEFAULT_ON_SERVICE_SOURCE_PARAM), 101);
    }

    /* access modifiers changed from: protected */
    public void onEndServiceHelp(CarOrder carOrder) {
        GlobalOmegaUtils.trackEvent("pas_drivercard_help_ck", ServerParam.PARAM_ORDER_TYPE, carOrder.status == 5 ? "1" : "2");
        startActivity(OnlineHelpUtil.getStartIntent(this.mContext, "https://help.didiglobal.com/processing-passenger.html", OnlineHelpUtil.DEFAULT_ON_SERVICE_SOURCE_PARAM));
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }
}

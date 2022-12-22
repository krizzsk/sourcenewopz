package com.didi.component.safetoolkit.sodaentregaapi;

import android.content.Context;
import com.didi.component.business.sharetrip.CommonTripShareManager;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.safetoolkit.presenter.AbsSafeToolkitPresenter;
import com.didi.component.safetoolkit.presenter.PresenterHolder;
import com.didi.safetoolkit.api.ISfShareService;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "sodaEntrega", value = {ISfShareService.class})
public class SodaEntregaShareProvider implements ISfShareService {

    /* renamed from: a */
    private CommonTripShareManager f15417a;

    public void startSocialShare(Context context) {
        CommonTripShareManager commonTripShareManager = this.f15417a;
        if (commonTripShareManager != null) {
            commonTripShareManager.disMissOneKeyShareDialog();
        }
        IPresenter presenter = PresenterHolder.getIns().getPresenter();
        if (presenter instanceof AbsSafeToolkitPresenter) {
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                if (this.f15417a == null) {
                    this.f15417a = new CommonTripShareManager();
                }
                ComponentParams componentParams = ((AbsSafeToolkitPresenter) presenter).getComponentParams();
                if (componentParams != null) {
                    this.f15417a.showShareDialog(componentParams.getActivity(), order.oid, order.productid);
                    return;
                }
                GLog.m7968e("global_share", "componentParams is null");
                return;
            }
            GLog.m7968e("global_share", "carOrder is null");
            return;
        }
        GLog.m7968e("global_share", "startSocialShare failed while IPresenter is null");
    }
}

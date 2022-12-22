package com.didi.carpool.waitrsp;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.CarNotifyManager;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.WaitRspServicePresenter;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class CarPoolWaitRspServicePresenter extends WaitRspServicePresenter {

    /* renamed from: d */
    private static final int f10679d = 39321;

    public CarPoolWaitRspServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void toDealWithOrderByTimeOut() {
        String string = ResourcesHelper.getString(this.mContext, R.string.car_wait_rsp_timeout);
        trackEvent("gp_carpool_noReply_ck");
        Bundle bundle = new Bundle();
        bundle.putString(BaseExtras.ConfirmService.EXTRA_BACK_TO_CONFIRM_TIP, string);
        goBackConfirm(bundle);
        CarNotifyManager.waitRspTimeoutNotify(this.mContext);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAITRSP_LEAVE_PAGE);
        trackEvent("gp_carpool_noReply_sw");
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        super.onDialogAction(i, i2);
        if (i == 39321 && i2 == 1) {
            trackEvent("gp_carpool_noReply_ck");
            goBackConfirm((Bundle) null);
            CarNotifyManager.waitRspTimeoutNotify(this.mContext);
        }
    }
}

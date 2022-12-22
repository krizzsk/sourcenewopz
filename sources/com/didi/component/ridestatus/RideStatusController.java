package com.didi.component.ridestatus;

import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.xpanel.sdk.component.InflateController;
import com.didi.component.common.cache.CacheApolloUtils;
import com.didi.component.core.ComponentParams;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.ReAssignDriverResult;

public class RideStatusController implements InflateController {
    public boolean isVisible(ComponentParams componentParams) {
        return true;
    }

    public boolean shouldInflate(ComponentParams componentParams) {
        return shouldLoadRideStatusComponent() || m11013a();
    }

    /* access modifiers changed from: protected */
    public boolean shouldLoadRideStatusComponent() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (order.assignResult == null && !order.isBooking()) {
                if (order.prepareSCModel != null && !TextUtils.isEmpty(order.prepareSCModel.pushTips)) {
                    order.assignResult = new ReAssignDriverResult();
                    order.assignResult.assignMsg = order.prepareSCModel.pushTips;
                }
            }
            return true;
        }
        if (CacheApolloUtils.openWaitRspOptimization()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m11013a() {
        int nearbyCarNum = FormStore.getInstance().getNearbyCarNum();
        return FormStore.getInstance().isShowNearCarMsg() && (nearbyCarNum <= GlobalApolloUtil.getNoCarCount() || nearbyCarNum <= GlobalApolloUtil.getFewCarCount());
    }
}

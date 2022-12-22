package com.didi.component.homepop.request;

import android.content.Context;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.model.HomeNewCouponModel;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import java.util.Collection;

public class RegisterCouponRequest implements HomePopupRequest {
    public void cancelGroup() {
    }

    public void closeWindow() {
    }

    public void requestByService(Context context, String str) {
        CarRequest.fetchHomeCoupon(context, str, new ResponseListener<HomeNewCouponModel>() {
            public void onSuccess(HomeNewCouponModel homeNewCouponModel) {
                super.onSuccess(homeNewCouponModel);
                if (homeNewCouponModel == null || CollectionUtils.isEmpty((Collection) homeNewCouponModel.couponInfos)) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EVENT_DECIDE_SHOW_TIPS);
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EVENT_HIDEN_NEW_USER_COUPON, homeNewCouponModel);
                    return;
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EVENT_SHOW_NEW_USER_COUPON, homeNewCouponModel);
            }
        });
    }
}

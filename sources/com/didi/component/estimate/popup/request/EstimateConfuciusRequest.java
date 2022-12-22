package com.didi.component.estimate.popup.request;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.common.model.NewGuidDialogModel;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.estimate.view.guidedialog.NewbieDialogManager;
import com.didi.sdk.oneconf.OneConfStore;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;

public class EstimateConfuciusRequest implements EstimatePopupRequest {
    public void cancelGroup() {
    }

    public void closeWindow() {
    }

    public void requestByService(final Context context, String str, final String str2, int i) {
        C55121 r0 = new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                NewGuidDialogModel newGuidDialogModel = new NewGuidDialogModel();
                newGuidDialogModel.parse(jsonObject.toString());
                if (newGuidDialogModel.isAvailable()) {
                    NewbieDialogManager.showNewUIBottomPop(context, newGuidDialogModel, str2, false);
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_HIDE_PAY_POPUP);
                    return;
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_NEW_GUIDE_DIALOG_FAILURE);
            }

            public void onFailure(IOException iOException) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_NEW_GUIDE_DIALOG_FAILURE);
            }
        };
        HashMap hashMap = new HashMap();
        hashMap.put("business_id", Integer.valueOf(Integer.parseInt(BusinessDataUtil.getProductId())));
        hashMap.put("car_level", Integer.valueOf(FormStore.getInstance().getCarLevel()));
        hashMap.put("city_id", Integer.valueOf(OneConfStore.getInstance().getCityId()));
        hashMap.put("country_id", Integer.valueOf(OneConfStore.getInstance().getCountryId()));
        hashMap.put("combo_type", Integer.valueOf(FormStore.getInstance().getCurrentComboType()));
        hashMap.put("origin", Integer.valueOf(i));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_NEW_GUIDE_SHOW).setParams(hashMap).setServiceId(str).setCallback(r0).build());
    }

    public void requestByService(final Context context, String str, int i, int i2, int i3, final String str2, int i4) {
        C55132 r0 = new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                NewGuidDialogModel newGuidDialogModel = new NewGuidDialogModel();
                newGuidDialogModel.parse(jsonObject.toString());
                if (newGuidDialogModel.isAvailable()) {
                    NewbieDialogManager.showNewUIBottomPop(context, newGuidDialogModel, str2, false);
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_HIDE_PAY_POPUP);
                    return;
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_NEW_GUIDE_DIALOG_FAILURE);
            }

            public void onFailure(IOException iOException) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_NEW_GUIDE_DIALOG_FAILURE);
            }
        };
        HashMap hashMap = new HashMap();
        hashMap.put("business_id", Integer.valueOf(i));
        hashMap.put("car_level", Integer.valueOf(i2));
        hashMap.put("city_id", Integer.valueOf(OneConfStore.getInstance().getCityId()));
        hashMap.put("country_id", Integer.valueOf(OneConfStore.getInstance().getCountryId()));
        hashMap.put("combo_type", Integer.valueOf(i3));
        hashMap.put("origin", Integer.valueOf(i4));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_NEW_GUIDE_SHOW).setParams(hashMap).setServiceId(str).setCallback(r0).build());
    }
}

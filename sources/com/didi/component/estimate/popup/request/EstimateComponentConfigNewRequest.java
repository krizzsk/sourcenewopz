package com.didi.component.estimate.popup.request;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.global.globalgenerickit.ComponentConfigManager;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.sdk.oneconf.OneConfStore;
import java.util.HashMap;

public class EstimateComponentConfigNewRequest implements EstimatePopupRequest {
    public void cancelGroup() {
    }

    public void closeWindow() {
    }

    public void requestByService(Context context, String str, String str2, int i) {
        if (context instanceof FragmentActivity) {
            HashMap hashMap = new HashMap();
            try {
                hashMap.put("business_id", Integer.valueOf(Integer.parseInt(BusinessDataUtil.getProductId())));
            } catch (Exception e) {
                e.printStackTrace();
            }
            hashMap.put("car_level", Integer.valueOf(FormStore.getInstance().getCarLevel()));
            hashMap.put("city_id", Integer.valueOf(OneConfStore.getInstance().getCityId()));
            hashMap.put("country_id", Integer.valueOf(OneConfStore.getInstance().getCountryId()));
            hashMap.put("combo_type", Integer.valueOf(FormStore.getInstance().getCurrentComboType()));
            hashMap.put("origin", Integer.valueOf(i));
            GGKConfigManager.requestConfig((FragmentActivity) context, hashMap, ComponentConfigManager.BUSINESS_SCENE_ESTIMATE, str, "passenger_newPopup");
        }
    }

    public void requestByService(Context context, String str, int i, int i2, int i3, String str2, int i4) {
        if (context instanceof FragmentActivity) {
            HashMap hashMap = new HashMap();
            try {
                hashMap.put("business_id", Integer.valueOf(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
            hashMap.put("car_level", Integer.valueOf(i2));
            hashMap.put("city_id", Integer.valueOf(OneConfStore.getInstance().getCityId()));
            hashMap.put("country_id", Integer.valueOf(OneConfStore.getInstance().getCountryId()));
            hashMap.put("combo_type", Integer.valueOf(i3));
            hashMap.put("origin", Integer.valueOf(i4));
            GGKConfigManager.requestConfig((FragmentActivity) context, hashMap, ComponentConfigManager.BUSINESS_SCENE_ESTIMATE, str, "passenger_newPopup");
        }
    }
}

package com.didi.component.estimate.view.guidedialog;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.common.dialog.NewUIBottomGuidePop;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.model.NewGuidDialogModel;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.estimate.popup.manager.EstimatePopupNewManager;
import com.didi.global.globalgenerickit.ComponentConfigManager;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globalgenerickit.net.ParamKeys;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import java.util.HashMap;

public class NewbieDialogManager {
    public static void showNewUIBottomPop(Context context, NewGuidDialogModel newGuidDialogModel, String str, boolean z) {
        if (newGuidDialogModel != null && !TextUtils.isEmpty(newGuidDialogModel.dataString) && !m9038a(str)) {
            new NewUIBottomGuidePop(context, newGuidDialogModel).show(z);
            GlobalSPUtil.setShowNewGuideDialogFlag(context, str);
        }
    }

    /* renamed from: a */
    private static boolean m9038a(String str) {
        return !TextUtils.equals(SceneHelper.getInstance().getLatestKey(), str);
    }

    public static void showNewUIBottomGuideDialog(FragmentActivity fragmentActivity, int i, String str) {
        m9037a(fragmentActivity, i, str);
    }

    /* renamed from: a */
    private static void m9037a(FragmentActivity fragmentActivity, int i, String str) {
        if (!GlobalSPUtil.isShowNewGuideDialogFlag(fragmentActivity, str)) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            HashMap hashMap = new HashMap();
            if (!(newEstimateItem == null || GlobalSPUtil.isShowedFixedPriceTipsDialog(fragmentActivity) || newEstimateItem.carConfig == null)) {
                hashMap.put(ParamKeys.PARAM_COUNT_PRICE_TYPE, Integer.valueOf(newEstimateItem.carConfig.countPriceType));
            }
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
            GGKConfigManager.requestConfig(fragmentActivity, hashMap, ComponentConfigManager.BUSINESS_SCENE_ESTIMATE, (String) null, "passenger_newPopup");
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_NEW_GUIDE_DIALOG_FAILURE);
            return;
        }
        new EstimatePopupNewManager().doRequest(fragmentActivity, str, i);
    }

    public static void onInterceptNewGuideShow(FragmentActivity fragmentActivity, int i, int i2, int i3, int i4, int i5, String str) {
        if (!GlobalSPUtil.isShowNewGuideDialogFlag(fragmentActivity, str)) {
            HashMap hashMap = new HashMap();
            if (!GlobalSPUtil.isShowedFixedPriceTipsDialog(fragmentActivity)) {
                hashMap.put(ParamKeys.PARAM_COUNT_PRICE_TYPE, Integer.valueOf(i));
            }
            try {
                hashMap.put("business_id", Integer.valueOf(i2));
            } catch (Exception e) {
                e.printStackTrace();
            }
            hashMap.put("car_level", Integer.valueOf(i3));
            hashMap.put("city_id", Integer.valueOf(OneConfStore.getInstance().getCityId()));
            hashMap.put("country_id", Integer.valueOf(OneConfStore.getInstance().getCountryId()));
            hashMap.put("combo_type", Integer.valueOf(i4));
            hashMap.put("origin", Integer.valueOf(i5));
            GGKConfigManager.requestConfig(fragmentActivity, hashMap, ComponentConfigManager.BUSINESS_SCENE_ESTIMATE, (String) null, "passenger_newPopup");
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_NEW_GUIDE_DIALOG_FAILURE);
            return;
        }
        new EstimatePopupNewManager().doRequest(fragmentActivity, i2, i3, i4, str, i5);
    }
}

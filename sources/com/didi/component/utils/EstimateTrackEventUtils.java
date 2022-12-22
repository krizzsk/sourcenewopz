package com.didi.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.sdk.address.address.entity.Address;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.unifylogin.api.OneLoginFacade;
import java.util.HashMap;
import java.util.Map;

public class EstimateTrackEventUtils {
    public static void trackEstimateShow(Context context) {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        Address startAddress = FormStore.getInstance().getStartAddress();
        Address endAddress = FormStore.getInstance().getEndAddress();
        HashMap hashMap = new HashMap();
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null)) {
            hashMap.put("bubble_id", newEstimateItem.carConfig.estimateId);
        }
        if (startAddress != null) {
            hashMap.put("from_lat", Double.valueOf(startAddress.latitude));
            hashMap.put("from_lng", Double.valueOf(startAddress.longitude));
            hashMap.put("from_addr", startAddress.address);
            hashMap.put("from_srctag", startAddress.srcTag);
            hashMap.put("from_poi_id", startAddress.poiId);
        }
        if (endAddress != null) {
            hashMap.put("to_lat", Double.valueOf(endAddress.latitude));
            hashMap.put("to_lng", Double.valueOf(endAddress.longitude));
            hashMap.put("to_addr", endAddress.address);
            hashMap.put("to_srctag", endAddress.srcTag);
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, endAddress.poiId);
        }
        hashMap.put("is_login", Integer.valueOf(OneLoginFacade.getStore().isLoginNow() ? 1 : 0));
        SceneHelper instance = SceneHelper.getInstance();
        instance.setFromBubbleHome(true);
        instance.setFromBubbleGuess(true);
        if (instance.isFromBackStackBubble()) {
            hashMap.put("scene", "ABA");
            instance.setFromBackStackBubble(false);
        } else if (instance.isFromPayMethod()) {
            hashMap.put("scene", "APA");
            instance.setFromPayMethod(false);
        } else if (instance.isFromPriceDetail()) {
            hashMap.put("scene", "APA");
            instance.setFromPriceDetail(false);
        } else if (instance.isFromPickupPoint()) {
            hashMap.put("scene", "ARA");
            instance.setFromPickupPoint(false);
        } else if (instance.isOrderIntercepted()) {
            hashMap.put("scene", "ARA");
            instance.setOrderIntercepted(false);
        } else {
            hashMap.put("scene", "AA");
        }
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null || newEstimateItem.carConfig.extraData == null)) {
            newEstimateItem.carConfig.extraData.putAllExtraLog(hashMap);
        }
        GlobalOmegaUtils.trackEvent("pas_orderconfirm_sw", (Map<String, Object>) hashMap);
    }

    public static void trackEstimateDialogShow(Context context) {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        HashMap hashMap = new HashMap();
        hashMap.put("cartype", Integer.valueOf(FormStore.getInstance().getCarLevel()));
        hashMap.put("payment", FormStore.getInstance().getPayWayMsg());
        if (newEstimateItem == null) {
            hashMap.put("ispaymenterror", 1);
        } else {
            hashMap.put("estimate_trace_id", FormStore.getInstance().getEstimateModelTraceId());
            hashMap.put("ispaymenterror", 0);
            if (newEstimateItem.carConfig != null) {
                if (newEstimateItem.carConfig.guideType != null) {
                    hashMap.put(ParamKeys.PARAM_GUIDE_TYPE, newEstimateItem.carConfig.guideType.toString());
                }
                hashMap.put("default_select", newEstimateItem.carConfig.selectDefault);
                hashMap.put("info_list", FormStore.getInstance().getInfoList());
                if (newEstimateItem.carConfig.extraData != null) {
                    newEstimateItem.carConfig.extraData.putAllExtraLog(hashMap);
                }
            }
        }
        hashMap.put("order_type", FormStore.getInstance().getOrderType());
        String estimateAction = SearchIdUploadManager.getInstance().getEstimateAction();
        if (TextUtils.isEmpty(estimateAction)) {
            estimateAction = "other";
        }
        SceneHelper instance = SceneHelper.getInstance();
        if (instance.isHomeOnResume()) {
            hashMap.put("scene", "ABA");
        } else {
            hashMap.put("scene", "AOA");
        }
        if (instance.isFromPayMethod()) {
            instance.setFromPayMethod(false);
            estimateAction = "after_select_pay_method";
        }
        hashMap.put("action", estimateAction);
        if (instance.isAppOnResume()) {
            hashMap.put("scene", "ABA");
        } else {
            hashMap.put("scene", "AOA");
        }
        GlobalOmegaUtils.trackEvent("requireDlg_estimate_sw", (Map<String, Object>) hashMap);
    }

    public static void trackOrderConfirmDialogShow() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        HashMap hashMap = new HashMap();
        if (SceneHelper.getInstance().isHomeOnResume()) {
            hashMap.put("type", 3);
        } else {
            hashMap.put("type", 1);
        }
        if (newEstimateItem != null) {
            if (newEstimateItem.carConfig != null) {
                hashMap.put("bubble_id", newEstimateItem.carConfig.estimateId);
            }
            hashMap.put("estimate_trace_id", FormStore.getInstance().getEstimateModelTraceId());
            hashMap.put("info_list", FormStore.getInstance().getInfoList());
        }
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null || newEstimateItem.carConfig.extraData == null)) {
            newEstimateItem.carConfig.extraData.putAllExtraLog(hashMap);
        }
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        GlobalOmegaUtils.trackEvent("gp_orderconfirm_modeXpanel_sw", (Map<String, Object>) hashMap);
    }

    public static void trackConfirmModeSwitch() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        HashMap hashMap = new HashMap();
        if (newEstimateItem != null) {
            if (newEstimateItem.carConfig != null) {
                hashMap.put("bubble_id", newEstimateItem.carConfig.estimateId);
            }
            hashMap.put("estimate_trace_id", FormStore.getInstance().getEstimateModelTraceId());
            hashMap.put("info_list", FormStore.getInstance().getInfoList());
        }
        GlobalOmegaUtils.trackEvent("pas_orderconfirm_mode_sp", (Map<String, Object>) hashMap);
    }
}

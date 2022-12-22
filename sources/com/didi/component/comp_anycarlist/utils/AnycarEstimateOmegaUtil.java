package com.didi.component.comp_anycarlist.utils;

import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnycarEstimateOmegaUtil {
    public static void trackOrderConfirmDialogShow() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            List<AnyCarEstimateItemModel> allCarItems = confirmListener.getAllCarItems();
            if (!CollectionUtil.isEmpty((Collection<?>) allCarItems)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (AnyCarEstimateItemModel next : allCarItems) {
                    if (!(next == null || next.mAnyCarEstimateNetItem == null || next.mAnyCarEstimateNetItem.carConfig == null)) {
                        arrayList.add(Integer.valueOf(next.mAnyCarEstimateNetItem.carConfig.carLevel));
                        arrayList2.add(Integer.valueOf(next.mAnyCarEstimateNetItem.carConfig.carBussinessId));
                    }
                }
                HashMap hashMap = new HashMap();
                String obj = arrayList.toString();
                String replace = obj.replace(obj.charAt(obj.length() - 1) + "", "");
                hashMap.put("carlevels", replace.replace(replace.charAt(0) + "", ""));
                String obj2 = arrayList2.toString();
                String replace2 = obj2.replace(obj2.charAt(obj2.length() + -1) + "", "");
                hashMap.put("actual_bizlist", replace2.replace(replace2.charAt(0) + "", ""));
                GlobalOmegaUtils.trackEvent("gp_orderconfirm_modeXpanel_sw", (Map<String, Object>) hashMap);
            }
        }
    }
}

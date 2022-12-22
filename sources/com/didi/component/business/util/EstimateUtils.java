package com.didi.component.business.util;

import com.didi.component.business.data.form.FormStore;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import java.util.List;

public class EstimateUtils {
    public static boolean isFixedPricingTypeShowing() {
        return false;
    }

    public static CarInfo getPopByEstimateItem(BusinessContext businessContext, EstimateItemModel estimateItemModel) {
        CarGrop riderGroup;
        int i;
        if (!(businessContext == null || estimateItemModel == null || (riderGroup = BusinessUtils.getRiderGroup(businessContext)) == null || riderGroup.getCarInfo() == null || riderGroup.getCarInfo().size() == 0)) {
            for (CarInfo next : riderGroup.getCarInfo()) {
                int i2 = 0;
                if (estimateItemModel.carConfig != null) {
                    i2 = estimateItemModel.carConfig.carBussinessId;
                    i = estimateItemModel.carConfig.carLevel;
                } else {
                    i = 0;
                }
                if (next != null && next.getBusinessNumId() == i2 && next.getCarLevel() == i && next.getComboType() == 0) {
                    return next;
                }
            }
        }
        return null;
    }

    public static boolean isNewCarPoolCanUseInEstimate(List<EstimateItemModel> list) {
        if (list == null) {
            return false;
        }
        for (EstimateItemModel next : list) {
            if (next.carConfig != null && next.carConfig.carComboType == 4) {
                FormStore.getInstance().setCarpoolRadius(next.carConfig.carCircleRadius);
                return true;
            }
        }
        return false;
    }
}

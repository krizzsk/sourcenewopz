package com.didi.travel.psnger.model.response.estimate;

import com.didi.sdk.util.collection.CollectionUtil;
import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.List;

public class CarDetailInfoListModel {
    @SerializedName("car_detail")
    public List<CarDetailModel> carDetailModels;

    public boolean hasCoupon() {
        if (CollectionUtil.isEmpty((Collection<?>) this.carDetailModels)) {
            return false;
        }
        if (this.carDetailModels.get(0).carDetailFeeInfo != null && !CollectionUtil.isEmpty((Collection<?>) this.carDetailModels.get(0).carDetailFeeInfo.carDeatilCoupon)) {
            return true;
        }
        if (this.carDetailModels.size() <= 1 || this.carDetailModels.get(1).carDetailFeeInfo == null || CollectionUtil.isEmpty((Collection<?>) this.carDetailModels.get(1).carDetailFeeInfo.carDeatilCoupon)) {
            return false;
        }
        return true;
    }
}

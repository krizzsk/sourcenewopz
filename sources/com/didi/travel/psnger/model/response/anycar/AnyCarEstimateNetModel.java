package com.didi.travel.psnger.model.response.anycar;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.estimate.CarBreakModel;
import com.didi.travel.psnger.model.response.estimate.CarBubbleModule;
import com.didi.travel.psnger.model.response.estimate.CarDetailInfoListModel;
import com.didi.travel.psnger.model.response.estimate.CarInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.didi.travel.psnger.model.response.estimate.CarOperationModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AnyCarEstimateNetModel implements BffGsonStruct {
    @SerializedName("break_module")
    public CarBreakModel carBreakModel;
    @SerializedName("bubble_module")
    public CarBubbleModule carBubbleModule;
    @SerializedName("config")
    public AnyCarConfigModel carConfig;
    @SerializedName("cars_info_detail")
    public List<CarDetailInfoListModel> carDetail;
    @SerializedName("car_info")
    public CarInfoModel carInfo;
    @SerializedName("message_module")
    public CarMessageModel carMessage;
    @SerializedName("car_operation")
    public List<CarOperationModel> carOperation;
}

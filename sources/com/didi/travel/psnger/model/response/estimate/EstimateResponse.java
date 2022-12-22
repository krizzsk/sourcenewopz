package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class EstimateResponse implements BffGsonStruct {
    @SerializedName("abnormal_module")
    public List<EstimateAbnormalModel> abnormalModels;
    @SerializedName("estimate_data")
    public List<EstimateGroupModel> allGroups;
    @SerializedName("global_config_info")
    public EstimateGlobalConfigModel globalConfigModel;
    @SerializedName("recommend_list")
    public List<String> recommends;
    @SerializedName("req_id")
    public String req_id;
}

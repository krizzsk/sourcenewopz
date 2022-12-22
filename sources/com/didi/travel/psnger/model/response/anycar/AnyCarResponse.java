package com.didi.travel.psnger.model.response.anycar;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.estimate.EstimateAbnormalModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AnyCarResponse implements BffGsonStruct {
    @SerializedName("abnormal_module")
    public EstimateAbnormalModel abnormalModels;
    @SerializedName("global_config_info")
    public AnyCarGlobalConfig globalConfig;
    public List<AnyCarGroup> groups;
}

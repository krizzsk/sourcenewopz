package com.didi.travel.psnger.model.response.anycar;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.PayEnterpriseInfo;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.estimate.CarBusinessConfig;
import com.didi.travel.psnger.model.response.estimate.CarPayConfigInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarPayGroupInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarPayInfoModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AnyCarPayModel implements BffGsonStruct {
    @SerializedName("business_config")
    public CarBusinessConfig businessConfig;
    @SerializedName("user_pay_group")
    public List<CarPayGroupInfoModel> carPayGroupInfo;
    @SerializedName("user_pay_info")
    public List<CarPayInfoModel> carPayInfo;
    @SerializedName("pay_assistor_module")
    public JsonObject mPayAssistorModule;
    @SerializedName("user_pay_config")
    public CarPayConfigInfoModel payCfgInfo;
    public PayEnterpriseInfo payEnterpriseInfo;
    public List<PayWayModel.PayWayItem> payWayList;

    public PayWayModel.PayWayItem getSelectPayWayItem() {
        List<PayWayModel.PayWayItem> list = this.payWayList;
        if (list != null && list.size() > 0) {
            for (PayWayModel.PayWayItem next : this.payWayList) {
                if (next.isSelected() == 1) {
                    return next;
                }
            }
        }
        return null;
    }
}

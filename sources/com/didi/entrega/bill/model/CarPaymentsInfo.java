package com.didi.entrega.bill.model;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarPaymentsInfo implements IEntity {
    @SerializedName("pay_type")
    public String payType;
    @SerializedName("user_pay_info")
    public CarUserPayInfo userPayInfo;

    public class CarUserPayInfo implements IEntity {
        @SerializedName("busi_payments")
        public List<CarPayInfoModel> busiPayments;
        @SerializedName("group")
        public List<CarPayGroupInfoModel> group;

        public CarUserPayInfo() {
        }
    }
}

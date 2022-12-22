package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> extends WBaseResp {
    @SerializedName("data")
    public T data;
}

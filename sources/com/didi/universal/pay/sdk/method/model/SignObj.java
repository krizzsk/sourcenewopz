package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

public class SignObj implements Serializable {
    @SerializedName("sign_params")
    public Map signParans;
    @SerializedName("sign_url")
    public String signUrl;
}

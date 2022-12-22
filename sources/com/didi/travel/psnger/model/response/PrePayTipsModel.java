package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

public class PrePayTipsModel extends BaseObject {
    @SerializedName("biz_content")
    public String bizContent;
    public String outTradeId;
    public boolean pixPrepay;
    @SerializedName("sign")
    public String sign;
    @SerializedName("sign_type")
    public String signType;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject.has("data") && jSONObject.optJSONObject("data") != null) {
            JsonUtil.objectFromJson(jSONObject.optJSONObject("data").toString(), PrePayTipsModel.class, this);
        }
    }
}

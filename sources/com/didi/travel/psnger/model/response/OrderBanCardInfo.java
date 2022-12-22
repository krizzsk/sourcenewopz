package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class OrderBanCardInfo extends BaseObject {
    public int banStatus;
    public String content;
    public String descLabel;
    public String detailUrl;
    public String globalId;
    public OrderBanPopInfo popInfo;
    public String tips;
    public String title;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.banStatus = optJSONObject.optInt("ban_status");
            this.title = optJSONObject.optString("banner_title");
            this.content = optJSONObject.optString("banner_detail");
            this.tips = optJSONObject.optString("ban_time");
            this.detailUrl = optJSONObject.optString("ban_detail_url");
            this.descLabel = optJSONObject.optString("ban_button");
            this.globalId = optJSONObject.optString("global_id");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("ban_pop_info");
            if (optJSONObject2 != null) {
                OrderBanPopInfo orderBanPopInfo = new OrderBanPopInfo();
                this.popInfo = orderBanPopInfo;
                orderBanPopInfo.parse(optJSONObject2);
            }
        }
    }
}

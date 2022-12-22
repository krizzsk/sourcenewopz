package com.didi.travel.psnger.model.response;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CommentOnPanelOrderInfo extends BaseObject {
    public String departure_time;
    public String dest_name;
    public String order_id;
    public int productId;
    public String short_dest_name;
    public String starting_name;
    public String subTitle;
    public String title;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("order_info");
            this.order_id = optJSONObject2.optString("order_id");
            this.starting_name = optJSONObject2.optString("starting_name");
            this.dest_name = optJSONObject2.optString("dest_name");
            this.departure_time = optJSONObject2.optString("departure_time");
            this.title = optJSONObject2.optString("title");
            this.subTitle = optJSONObject2.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
            this.short_dest_name = optJSONObject2.optString("to_name");
            try {
                this.productId = Integer.valueOf(optJSONObject2.optString("business_id")).intValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}

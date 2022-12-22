package com.didi.travel.psnger.model.response;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class CarPoolMatchInfo extends BaseObject {
    public static final int STYLE_WILL_WAIT = 1;
    public int leftTime;
    public List<MatchItemInfo> matchItemInfoList;
    public int refreshStep;
    public String subTitle;
    public String tips;
    public String title;
    public String titleV2;
    public int willWaitStyle;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.subTitle = jSONObject.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
            this.tips = jSONObject.optString("tips");
            this.refreshStep = jSONObject.optInt("time_step");
            this.leftTime = jSONObject.optInt("left_time");
            this.willWaitStyle = jSONObject.optInt("will_wait_style");
            this.titleV2 = jSONObject.optString("title_v2");
            if (jSONObject.has("match_feature_list") && (optJSONArray = jSONObject.optJSONArray("match_feature_list")) != null) {
                this.matchItemInfoList = new JsonUtil().parseJSONArray(optJSONArray, new MatchItemInfo());
            }
        }
    }
}

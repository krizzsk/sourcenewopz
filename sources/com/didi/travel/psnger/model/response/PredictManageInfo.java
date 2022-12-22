package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PredictManageInfo extends BaseObject {
    public String extraInfo;
    public List<GuideShowInfoData> guideShowInfos;
    public PredictTimeCard predictTimeCard;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("guide_show_info");
        if (optJSONArray != null) {
            this.guideShowInfos = new JsonUtil().parseJSONArray(optJSONArray, new GuideShowInfoData());
        }
        this.extraInfo = jSONObject.optString("extra_info");
        JSONObject optJSONObject = jSONObject.optJSONObject("predict_time_card");
        if (optJSONObject != null) {
            PredictTimeCard predictTimeCard2 = new PredictTimeCard();
            this.predictTimeCard = predictTimeCard2;
            predictTimeCard2.parse(optJSONObject);
        }
    }

    public static class PredictTimeCard extends BaseObject {
        public static final int SHOWFORMAT_DEFAULT = 0;
        public static final int SHOWFORMAT_FLIER_VIP = 3;
        public static final int SHOWFORMAT_MINUTE = 2;
        public static final int SHOWFORMAT_SECOND = 1;
        public String endColor;
        public String iconUrl;
        public String loadTitle;
        public int memberLevelId;
        public int showFormat;
        public String startColor;
        public String text;
        public String time;
        public String title;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.title = jSONObject.optString("title");
            this.loadTitle = jSONObject.optString("load_title");
            this.text = jSONObject.optString("text");
            this.time = jSONObject.optString("time");
            this.iconUrl = jSONObject.optString("icon_url");
            this.showFormat = jSONObject.optInt("show_format");
            this.memberLevelId = jSONObject.optInt("member_level_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("color_list");
            if (optJSONArray != null && optJSONArray.length() == 2) {
                this.startColor = optJSONArray.optString(0);
                this.endColor = optJSONArray.optString(1);
            }
        }
    }
}

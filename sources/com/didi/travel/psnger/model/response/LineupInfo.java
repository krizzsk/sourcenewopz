package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LineupInfo extends BaseObject {
    public String extraInfo;
    public List<GuideShowInfoData> guideShowInfos;
    public QueueInfoData queueInfoData;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("queue_info");
        if (optJSONObject != null) {
            QueueInfoData queueInfoData2 = new QueueInfoData();
            this.queueInfoData = queueInfoData2;
            queueInfoData2.parse(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("guide_show_info");
        if (optJSONArray != null) {
            this.guideShowInfos = new JsonUtil().parseJSONArray(optJSONArray, new GuideShowInfoData());
        }
        this.extraInfo = jSONObject.optString("extra_info");
    }

    public static class QueueInfoData extends BaseObject {
        public String cancelButtonTitle;
        public String cancelText;
        public String cancelTitle;
        public String confirmButtonTitle;
        public String endColor;
        public String iconUrl;
        public String leftText;
        public String leftTitle;
        public int memberLevelId;
        public String rightText;
        public String rightTitle;
        public String startColor;
        public String title;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.title = jSONObject.optString("title");
            this.leftTitle = jSONObject.optString("left_title");
            this.rightTitle = jSONObject.optString("right_title");
            this.leftText = jSONObject.optString("left_text");
            this.rightText = jSONObject.optString("right_text");
            this.cancelTitle = jSONObject.optString("cancel_title");
            this.cancelText = jSONObject.optString("cancel_text");
            this.cancelButtonTitle = jSONObject.optString("cancel_button_title");
            this.confirmButtonTitle = jSONObject.optString("confirm_button_title");
            this.iconUrl = jSONObject.optString("icon_url");
            this.memberLevelId = jSONObject.optInt("member_level_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("color_list");
            if (optJSONArray != null && optJSONArray.length() == 2) {
                this.startColor = optJSONArray.optString(0);
                this.endColor = optJSONArray.optString(1);
            }
        }
    }
}

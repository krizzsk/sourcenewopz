package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class MisBannerItemModel extends BaseObject {
    public String activityId;
    public String closeable;
    public String content;
    public String image;
    public int isTimes;
    public int isUserOperate;
    public String language;
    public String link;
    public String name;
    public String popPeriod;
    public int popType;
    public String senceId;
    public int shType;
    public String sid;
    public long userOperateTime;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.activityId = jSONObject.optString("activity_id", "");
            this.name = jSONObject.optString("name", "");
            this.content = jSONObject.optString("content", "");
            this.closeable = jSONObject.optString("closeable", "");
            this.link = jSONObject.optString("link", "");
            this.popType = jSONObject.optInt("pop_type", 0);
            this.popPeriod = jSONObject.optString("pop_period", "");
            this.image = jSONObject.optString("image", "");
            this.shType = jSONObject.optInt("sh_type", 2);
            this.language = TEBridge.clientConfig().locale();
        }
    }
}

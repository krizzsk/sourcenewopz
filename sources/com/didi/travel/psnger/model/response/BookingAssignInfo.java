package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BookingAssignInfo extends BaseObject {
    public String insuranceMsg;
    public String insuranceUrl;
    public String mCancelAlert;
    public String msg;
    public List<BookingStatusInfo> statusList;
    public int style;
    public String tipsMsg;
    public String title;

    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.msg = jSONObject.optString("msg");
            this.tipsMsg = jSONObject.optString("tips_msg");
            this.insuranceMsg = jSONObject.optString("icon_msg");
            this.insuranceUrl = jSONObject.optString("icon_url");
            this.mCancelAlert = jSONObject.optString("cancel_alert");
            this.style = jSONObject.optInt("style");
            if (jSONObject.has("booking_status") && (optJSONArray = jSONObject.optJSONArray("booking_status")) != null) {
                this.statusList = new JsonUtil().parseJSONArray(optJSONArray, new BookingStatusInfo());
            }
        }
    }

    public static class BookingStatusInfo extends BaseObject {
        public boolean current;
        public String detail;
        public String title;

        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.title = jSONObject.optString("title");
                this.detail = jSONObject.optString("detail");
                boolean z = false;
                if (jSONObject.optInt("current", 0) == 1) {
                    z = true;
                }
                this.current = z;
            }
        }
    }
}

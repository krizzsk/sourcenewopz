package com.didi.component.phoneentrance.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DriverOptionModel extends BaseObject {
    public int action;
    public int clickable;
    public DriverOptionData data;
    public String normalIcon;
    public JSONObject passengerSheetObj;
    public String scheme = "";
    public String selectedIcon;
    public int type;
    public String voipSessionId = "";

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.normalIcon = jSONObject.optString("normal_icon");
            this.selectedIcon = jSONObject.optString("selected_icon");
            this.clickable = jSONObject.optInt("click_enable");
            this.action = jSONObject.optInt("action");
            this.scheme = jSONObject.optString("scheme");
            if (jSONObject.has("data")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                DriverOptionData driverOptionData = new DriverOptionData();
                this.data = driverOptionData;
                driverOptionData.parse(optJSONObject);
            }
            this.voipSessionId = jSONObject.optString("voip_session_id");
            this.passengerSheetObj = jSONObject.optJSONObject("passenger_sheet");
        }
    }
}

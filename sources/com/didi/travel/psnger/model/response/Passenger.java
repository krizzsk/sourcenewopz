package com.didi.travel.psnger.model.response;

import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

public class Passenger extends BaseObject {
    public String avatarUrl;
    public String carpoolHistory;
    public String carpoolSeats;
    public String endAddress;

    /* renamed from: id */
    public String f44225id;
    public String levelName;
    public int levelValue;
    public String name;
    public String nick;
    public String poolSeatTips;
    public String startAddress;
    public int status;
    public String vipInfo;

    public String toString() {
        return "-- uid = " + this.f44225id + "-- passenger_count = " + this.carpoolSeats + "-- status = " + this.status + "-- nick = " + this.nick + "-- starting_name = " + this.startAddress + "-- dest_name = " + this.endAddress + "-- car_pool_complete = " + this.carpoolHistory + "-- level_name = " + this.levelName + "-- level_value = " + this.levelValue + "-- head_url = " + this.avatarUrl + "-- home_page = " + this.vipInfo;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f44225id = jSONObject.optString("uid");
                this.nick = jSONObject.optString("nick");
                this.avatarUrl = jSONObject.optString("head_url");
                this.vipInfo = jSONObject.optString(PrepaidConstant.SCENE_HOME_PAGE);
                this.carpoolSeats = jSONObject.optInt(ParamKeys.PARAM_PASSENGER_COUNT) + "";
                this.name = jSONObject.optString("name");
                this.startAddress = jSONObject.optString("starting_name");
                this.endAddress = jSONObject.optString("dest_name");
                this.levelName = jSONObject.optString(FirebaseAnalytics.Param.LEVEL_NAME);
                this.levelValue = jSONObject.optInt("level_value");
                this.carpoolHistory = jSONObject.optInt("car_pool_complete") + "";
                this.status = jSONObject.optInt("status");
                this.poolSeatTips = jSONObject.optString("pool_seat_tips");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

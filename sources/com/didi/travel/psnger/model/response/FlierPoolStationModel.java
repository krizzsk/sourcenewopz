package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didichuxing.publicservice.p196db.model.ScreenAdNewModel;
import org.json.JSONObject;

public class FlierPoolStationModel extends BaseObject {
    public static final int POP_ONE_BTN_CONFIRM_DIALOG = 2;
    public static final int POP_TWO_BTN_CONFIRM_DIALOG = 1;
    public static final int SELECTED = 1;
    public static final int STATUS_PRE_MATCH_CAR_FRIEND = 3;
    public static final int STATUS_PRE_MATCH_DEFAULT = 0;
    public static final int STATUS_PRE_MATCH_INFO = 5;
    public static final int STATUS_PRE_MATCH_NO_ALL = 1;
    public static final int STATUS_PRE_MATCH_NO_CAR = 2;
    public static final int STATUS_PRE_MATCH_NO_FRIEND = 4;
    public static final int STATUS_PRE_MATCH_WILL_WAIT_COUPON = 6;
    public static final int STATUS_PRE_MATCH_WILL_WAIT_NOCOUPON = 7;
    public static final int TYPE_TIME_STATION = 6;
    public static final int UNPOP_CONFIRM_DIALOG = 0;
    public static final int UNSELECT = 0;
    public String address;
    public int confirmPop = 0;
    public String confirmPopReason;
    public String confirmTopTips;
    public int countDownTime;
    public boolean isDefault;
    public double lat;
    public double lng;
    public String name;
    public String poiId;
    public String readyDepartureTime;
    public String recMsg;
    public int recStatus;
    public String recomReason;
    public int selected;
    public String stationId;
    public String subtitle;
    public String title;
    public String uid;
    public int walkDistance;
    public String walkDistanceTips;
    public int walkTime;
    public String walkTips;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.poiId = jSONObject.optString("poi_id");
            this.title = jSONObject.optString("title");
            this.subtitle = jSONObject.optString("subtitle");
            this.address = jSONObject.optString("address");
            this.countDownTime = jSONObject.optInt("count_down_time");
            this.isDefault = jSONObject.optBoolean(ScreenAdNewModel.ScreenAdNewColumn.IS_DEFAULT);
            this.lat = NumberUtil.strToDouble(jSONObject.optString("lat")).doubleValue();
            this.lng = NumberUtil.strToDouble(jSONObject.optString("lng")).doubleValue();
            this.name = jSONObject.optString("name");
            this.stationId = jSONObject.optString(ParamKeys.PARAM_STATION_ID);
            this.uid = jSONObject.optString("uid");
            this.walkDistance = jSONObject.optInt("walk_distance", 0);
            this.walkTime = jSONObject.optInt("walk_time", 0);
            this.walkTips = jSONObject.optString("walk_tips");
            this.recomReason = jSONObject.optString("rec_reason");
            this.readyDepartureTime = jSONObject.optString("ready_departure_time");
            this.recMsg = jSONObject.optString("rec_msg");
            this.recStatus = jSONObject.optInt("rec_status");
            this.confirmPopReason = jSONObject.optString("confirm_pop_reason");
            this.walkDistanceTips = jSONObject.optString("walk_distance_tips");
            this.selected = jSONObject.optInt("selected");
            this.confirmPop = jSONObject.optInt("confirm_pop");
            this.confirmTopTips = jSONObject.optString("confirm_top_tips");
        }
    }
}

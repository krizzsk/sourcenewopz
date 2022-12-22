package com.didi.travel.psnger.model.response;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrivingMapInfo extends BaseObject {
    public int carpoolType;
    public boolean enable;
    public List<DrivingMapBubbleMsg> mapBubbleMsg = new ArrayList();
    public List<MapBubbleMsg> mapBubbleMsgList = new ArrayList();
    public MapConfig mapConfig;
    public int sceneType = 1;

    public static class MapConfig implements BffGsonStruct {
        public static final int DEPARTED = 1;
        public static final int DEPART_ARRIVED_PICKUP = 4;
        public static final int DEPART_UN_ARRIVED_PICKUP = 3;
        public static final int END_SERVICE_ABOVE_24_H = 7;
        public static final int END_SERVICE_IN_24_H = 6;
        public static final int ON_SERVICE = 5;
        public static final int UN_DEPARTED = 0;
        public static final int UN_DEPART_GREATER_THAN_25_MIN = 1;
        public static final int UN_DEPART_LESS_THAN_25_MIN = 2;
        @SerializedName("map_biz_scene")
        public int bizScene;
        @SerializedName("car_depart")
        public int carDepart;
        @SerializedName("drop_off_threshold")
        public int dropOffThreshold;
        @SerializedName("line_data")
        public MapModel lineData;
        @SerializedName("map_car_icon")
        public String mapCarIcon;
        @SerializedName("map_style")
        public int mapStyle;
        @SerializedName("show_navi_entry")
        public int showNaviEntry;
        @SerializedName("station_board_hint")
        public StationBoardHintModel stationBoardHint;
    }

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray optJSONArray;
        super.parse(jSONObject);
        this.mapBubbleMsg.clear();
        this.mapBubbleMsgList.clear();
        if (jSONObject != null && jSONObject.has("pMapInfo")) {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("pMapInfo");
            for (int i = 0; i < optJSONArray2.length(); i++) {
                JSONObject jSONObject2 = null;
                try {
                    jSONObject2 = optJSONArray2.optJSONObject(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (jSONObject2 != null && jSONObject2.has("map_bubble")) {
                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("map_bubble");
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        JSONObject optJSONObject3 = optJSONArray3.optJSONObject(i2);
                        DrivingMapBubbleMsg drivingMapBubbleMsg = new DrivingMapBubbleMsg();
                        drivingMapBubbleMsg.parse(optJSONObject3);
                        this.mapBubbleMsg.add(drivingMapBubbleMsg);
                        if (drivingMapBubbleMsg.bubbleType == 4) {
                            if (drivingMapBubbleMsg.positionType == 3) {
                                this.carpoolType = 0;
                            } else if (drivingMapBubbleMsg.positionType == 4) {
                                this.carpoolType = 1;
                            } else {
                                this.carpoolType = 2;
                            }
                            MapBubbleMsg mapBubbleMsg2 = new MapBubbleMsg(drivingMapBubbleMsg.msg, this.carpoolType, drivingMapBubbleMsg.carpooOid);
                            int i3 = drivingMapBubbleMsg.carpool_index;
                            if (i3 > this.mapBubbleMsgList.size()) {
                                i3 = this.mapBubbleMsgList.size();
                            }
                            this.mapBubbleMsgList.add(i3, mapBubbleMsg2);
                        }
                    }
                }
                if (jSONObject2 != null && jSONObject2.has("map_scene") && (optJSONArray = jSONObject2.optJSONArray("map_scene")) != null && optJSONArray.length() > 0) {
                    JSONObject optJSONObject4 = optJSONArray.optJSONObject(0);
                    if (optJSONObject4.has("scene_type")) {
                        this.sceneType = optJSONObject4.optInt("scene_type");
                    }
                }
                if (!(jSONObject2 == null || !jSONObject2.has("map_config") || (optJSONObject2 = jSONObject2.optJSONObject("map_config")) == null)) {
                    this.mapConfig = (MapConfig) new Gson().fromJson(optJSONObject2.toString(), MapConfig.class);
                }
                if (jSONObject.has("walk_navigation") && (optJSONObject = jSONObject.optJSONObject("walk_navigation")) != null) {
                    this.enable = optJSONObject.optBoolean("enable");
                }
            }
        }
    }

    public String toString() {
        return "DrivingMapInfo{sceneType=" + this.sceneType + ", enable=" + this.enable + ", mapBubbleMsgList=" + this.mapBubbleMsgList + ", carpoolType=" + this.carpoolType + ", mapBubbleMsg=" + this.mapBubbleMsg + '}';
    }
}

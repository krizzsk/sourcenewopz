package com.didi.travel.psnger.model.response;

import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AirportSpecialListData extends BaseObject {
    public List<AirportPoiData> airport_poi_list;
    public int poi_num;
    public int scene_type;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        super.parse(jSONObject);
        this.scene_type = jSONObject.optInt("scene_type");
        this.poi_num = jSONObject.optInt("poi_num");
        if (jSONObject.has("airport_poi_list") && (optJSONArray = jSONObject.optJSONArray("airport_poi_list")) != null) {
            this.airport_poi_list = new JsonUtil().parseJSONArray(optJSONArray, new AirportPoiData());
        }
    }

    public void parseObject(JSONObject jSONObject) {
        parse(jSONObject);
    }

    public static class AirportPoiData extends BaseObject {
        public String address;
        public int area;
        public String departure_name;
        public String displayname;
        public String gaode_displayname;
        public double gaode_lat;
        public double gaode_lng;
        public boolean is_recommended;
        public double lat;
        public double lng;
        public String poi_id;
        public String show_product;
        public String srcTag;
        public int weight;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.poi_id = jSONObject.optString("poi_id");
            this.displayname = jSONObject.optString("displayname");
            this.departure_name = jSONObject.optString("departure_name");
            this.address = jSONObject.optString("address");
            this.lng = jSONObject.optDouble("lng");
            this.lat = jSONObject.optDouble("lat");
            this.gaode_displayname = jSONObject.optString("gaode_displayname");
            this.gaode_lng = jSONObject.optDouble("gaode_lng");
            this.gaode_lat = jSONObject.optDouble("gaode_lat");
            this.is_recommended = jSONObject.optBoolean("is_recommended");
            this.weight = jSONObject.optInt("weight");
            this.show_product = jSONObject.optString("show_product");
            this.area = jSONObject.optInt("area");
            this.srcTag = jSONObject.optString(DepartureConstants.SRCTAG);
        }
    }
}

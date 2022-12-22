package com.didi.travel.psnger.model.response;

import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.sdk.push.ServerParam;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PoimapRecommendModel extends BaseObject {
    public String sample_info = "";
    public String searchid = "";
    public List<PoimapRecommendToplistItem> toplist = new ArrayList();

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.searchid = jSONObject.optString(ServerParam.PARAMS_SEARCHID);
            this.sample_info = jSONObject.optString("sample_info");
            JSONArray optJSONArray = jSONObject.optJSONArray("toplist");
            if (optJSONArray != null) {
                this.toplist = new JsonUtil().parseJSONArray(optJSONArray, new PoimapRecommendToplistItem());
            }
        }
    }

    public static class PoimapRecommendToplistItem extends BaseObject {
        public String address = "";
        public String addressall = "";
        public long area = 0;
        public String cotype = "";
        public String displayname = "";
        public double lat = 0.0d;
        public double lng = 0.0d;
        public String poi_ui_tag = "";
        public String poiid = "";
        public String srctag = "";

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.displayname = jSONObject.optString("displayname");
                this.address = jSONObject.optString("address");
                this.lat = jSONObject.optDouble("lat");
                this.lng = jSONObject.optDouble("lng");
                this.srctag = jSONObject.optString(DepartureConstants.SRCTAG);
                this.cotype = jSONObject.optString("cotype");
                this.area = jSONObject.optLong("area");
                this.poiid = jSONObject.optString("poiid");
                this.addressall = jSONObject.optString("addressall");
                this.poi_ui_tag = jSONObject.optString("poi_ui_tag");
            }
        }
    }
}

package com.didi.component.indriver.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class IndriverData {
    public LEGORichInfo currentPrice = new LEGORichInfo();
    public List<DriverData> driverDataList = new ArrayList();
    public int folded_show;
    public int pollInterval;
    public String tips;
    public String title;
    public String version;

    public static IndriverData parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        DriverData parse;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return null;
        }
        IndriverData indriverData = new IndriverData();
        indriverData.currentPrice.setInfo(optJSONObject.optString("current_price"));
        if (!(!optJSONObject.has("driver_list") || optJSONObject.optJSONArray("driver_list") == null || (optJSONArray = optJSONObject.optJSONArray("driver_list")) == null)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (!(optJSONObject2 == null || (parse = DriverData.parse(optJSONObject2)) == null || parse.expireTs <= System.currentTimeMillis())) {
                    indriverData.driverDataList.add(parse);
                }
            }
        }
        indriverData.folded_show = optJSONObject.optInt("folded_show");
        int optInt = optJSONObject.optInt("poll_interval");
        if (optInt <= 0) {
            optInt = 5;
        }
        indriverData.pollInterval = optInt * 1000;
        indriverData.tips = optJSONObject.optString("tips");
        indriverData.title = optJSONObject.optString("title");
        indriverData.version = optJSONObject.optString("version");
        return indriverData;
    }
}

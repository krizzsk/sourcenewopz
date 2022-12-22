package com.didi.travel.psnger.model.response;

import com.datadog.android.log.LogAttributes;
import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RegionTimeDataV2 extends BaseObject {
    public int[] carpoolSeatConfig;
    public String leftText;
    public String rightText;
    public List<TimeSpan> timeSpanList = new LinkedList();

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_routes_data");
            if (optJSONObject2 != null) {
                this.leftText = optJSONObject2.optString("left_text");
                this.rightText = optJSONObject2.optString("right_text");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("time_span");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        TimeSpan timeSpan = new TimeSpan();
                        timeSpan.parse(optJSONArray2.optJSONObject(i).toString());
                        this.timeSpanList.add(timeSpan);
                    }
                }
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("extend_data");
            if (optJSONObject3 != null && (optJSONArray = optJSONObject3.optJSONArray("carpool_seat_config")) != null) {
                this.carpoolSeatConfig = new int[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.carpoolSeatConfig[i2] = optJSONArray.optInt(i2);
                }
            }
        }
    }

    public class Range extends BaseObject {
        public String left_label;
        public int price;
        public String price_desc;
        public String right_label;
        public String set_out_now;
        public String tags;
        public String tips;
        public String value;

        public Range() {
        }

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.tags = jSONObject.optString("tags");
                this.tips = jSONObject.optString("tips");
                this.value = jSONObject.optString("value");
                this.price_desc = jSONObject.optString("price_desc");
                this.left_label = jSONObject.optString("left_label");
                this.right_label = jSONObject.optString("right_label");
                this.set_out_now = jSONObject.optString("set_out_now");
                this.price = jSONObject.optInt("price");
            }
        }
    }

    public class TimeSpan extends BaseObject {
        public String date;
        public List<Range> rangeList = new LinkedList();
        public String title;

        public TimeSpan() {
        }

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.title = jSONObject.optString("title");
                this.date = jSONObject.optString(LogAttributes.DATE);
                JSONArray optJSONArray = jSONObject.optJSONArray("range");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        Range range = new Range();
                        range.parse(optJSONArray.optJSONObject(i).toString());
                        this.rangeList.add(range);
                    }
                }
            }
        }
    }
}

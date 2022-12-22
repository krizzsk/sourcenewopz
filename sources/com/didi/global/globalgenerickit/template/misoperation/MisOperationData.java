package com.didi.global.globalgenerickit.template.misoperation;

import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.helper.KitHelper;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MisOperationData extends GGKData {

    /* renamed from: T */
    public String f22196T;
    public String activityId;
    public String[] bottombarImages;
    public String[] bottombarLinks;
    public String[] bottombarTxts;
    public String content;
    public String imageUrl;
    public String link;
    public HashMap<String, Object> logDataMap = new HashMap<>();
    public String title;
    public String type;

    public MisOperationData(GGKData gGKData) {
        this.originalData = gGKData.getOriginalData();
        m16034a();
    }

    /* renamed from: a */
    private MisOperationData m16034a() {
        super.parse(this.originalData);
        this.imageUrl = KitHelper.optString(this.data, "image1", "");
        this.title = KitHelper.optString(this.data, "text0", "");
        this.content = KitHelper.optString(this.data, "text1", "");
        this.link = KitHelper.optString(this.data, "link0", "");
        JSONArray optJSONArray = this.data.optJSONArray("buttons");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            this.bottombarTxts = new String[length];
            this.bottombarImages = new String[length];
            this.bottombarLinks = new String[length];
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    this.bottombarTxts[i] = KitHelper.optString(optJSONObject, "text", "");
                    this.bottombarImages[i] = KitHelper.optString(optJSONObject, "image", "");
                    this.bottombarLinks[i] = KitHelper.optString(optJSONObject, "link", "");
                }
            }
        } else {
            this.bottombarTxts = new String[0];
            this.bottombarImages = new String[0];
            this.bottombarLinks = new String[0];
        }
        if (this.extension != null) {
            this.f22196T = KitHelper.optString(this.extension, "T", "");
            this.activityId = KitHelper.optString(this.extension, "activity_id", "");
            this.type = KitHelper.optString(this.extension, "type", "");
            JSONObject optJSONObject2 = this.extension.optJSONObject("log_data");
            if (optJSONObject2 != null) {
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.logDataMap.put(next, KitHelper.optString(optJSONObject2, next, ""));
                }
            } else {
                this.logDataMap = new HashMap<>();
            }
        }
        return this;
    }
}

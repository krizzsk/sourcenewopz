package com.didi.component.common.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NewGuidDialogModel extends BaseObject {
    public String btText;
    public String dataString;
    public String imgUrl;
    public String popId;
    public List<String> textArray = new ArrayList();
    public String title;

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.popId = optJSONObject.optString("pop_id");
            this.title = optJSONObject.optString("title");
            this.imgUrl = optJSONObject.optString("image");
            this.btText = optJSONObject.optString("button_text");
            JSONArray optJSONArray = optJSONObject.optJSONArray("text");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.textArray.add(optJSONArray.optString(i));
                }
                this.dataString = optJSONObject.toString();
            }
        }
    }
}

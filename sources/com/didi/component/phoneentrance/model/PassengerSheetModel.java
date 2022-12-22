package com.didi.component.phoneentrance.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PassengerSheetModel extends BaseObject {
    public List<SheetOption> options = new ArrayList();
    public String subtitle = "";
    public String title = "";

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.subtitle = jSONObject.optString("subtitle");
            JSONArray optJSONArray = jSONObject.optJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        SheetOption sheetOption = new SheetOption();
                        sheetOption.parse(optJSONObject);
                        this.options.add(sheetOption);
                    }
                }
            }
        }
    }
}

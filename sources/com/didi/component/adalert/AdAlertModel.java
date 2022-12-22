package com.didi.component.adalert;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdAlertModel extends BaseObject {
    public List<AdAlertData> list;

    public class AdAlertData {
        public String adid;
        public String agency;
        public JSONObject mLogData;

        public AdAlertData() {
        }
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        super.parse(jSONObject);
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("ads")) != null) {
                this.list = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    if (!(optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("data")) == null)) {
                        AdAlertData adAlertData = new AdAlertData();
                        adAlertData.agency = optJSONObject.optString("agency");
                        adAlertData.adid = optJSONObject.optString(Constants.JSON_KEY_ANDID);
                        adAlertData.mLogData = optJSONObject3.optJSONObject("log_data");
                        this.list.add(adAlertData);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

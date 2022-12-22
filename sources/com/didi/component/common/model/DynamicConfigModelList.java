package com.didi.component.common.model;

import com.didi.sdk.util.GlobalOmegaUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicConfigModelList extends BaseObject {
    private List<DynamicConfigModel> mDynamicConfigModelList = new ArrayList();

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            try {
                this.mDynamicConfigModelList.clear();
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        DynamicConfigModel dynamicConfigModel = new DynamicConfigModel();
                        dynamicConfigModel.parse(jSONObject2);
                        this.mDynamicConfigModelList.add(dynamicConfigModel);
                    }
                }
            } catch (JSONException e) {
                HashMap hashMap = new HashMap();
                hashMap.put("source", 2);
                GlobalOmegaUtils.trackEvent("tech_gpfile_cache_read", hashMap);
                e.printStackTrace();
            }
        }
    }

    public List<DynamicConfigModel> getDynamicConfigModelList() {
        return this.mDynamicConfigModelList;
    }

    public void setDynamicConfigModelList(List<DynamicConfigModel> list) {
        this.mDynamicConfigModelList = list;
    }
}

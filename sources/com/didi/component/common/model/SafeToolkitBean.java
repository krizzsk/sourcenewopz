package com.didi.component.common.model;

import com.didi.component.common.helper.SceneHelper;
import com.didi.safetoolkit.business.toolkit.model.SfViewMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.travel.psnger.common.net.base.BaseObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SafeToolkitBean extends BaseObject {
    public SafeToolkitData data;
    public List<SafeToolkitData> dataList = new ArrayList();
    public SfViewMonitorMenuModel monitorMenuModel;
    public ArrayList<SfViewMenuModel> sfViewMenuModelList = new ArrayList<>();

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("menus");
                this.sfViewMenuModelList.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    SfViewMenuModel parseType = SfViewMenuModel.parseType(optJSONArray.getJSONObject(i));
                    this.sfViewMenuModelList.add(parseType);
                    if (parseType instanceof SfViewMonitorMenuModel) {
                        this.monitorMenuModel = (SfViewMonitorMenuModel) parseType;
                        SceneHelper.getInstance().pushId = this.monitorMenuModel.pushId;
                    }
                }
                this.dataList.clear();
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("bubbles");
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.dataList.add(SafeToolkitData.parse(optJSONArray2.getJSONObject(i2)));
                }
                if (this.dataList != null && this.dataList.size() > 0) {
                    this.data = this.dataList.get(0);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static class SafeToolkitData implements Serializable {
        public String bubbleId;
        public String content;
        public int show;
        public int state;

        public static SafeToolkitData parse(JSONObject jSONObject) {
            SafeToolkitData safeToolkitData = new SafeToolkitData();
            safeToolkitData.show = jSONObject.optInt("show");
            safeToolkitData.state = jSONObject.optInt("state");
            safeToolkitData.content = jSONObject.optString("content");
            safeToolkitData.bubbleId = jSONObject.optString("bubble_id");
            return safeToolkitData;
        }
    }
}

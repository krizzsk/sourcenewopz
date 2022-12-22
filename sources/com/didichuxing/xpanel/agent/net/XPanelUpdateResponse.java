package com.didichuxing.xpanel.agent.net;

import android.text.TextUtils;
import com.didichuxing.publicservice.p196db.model.ScreenAdNewModel;
import com.didichuxing.xpanel.util.LogcatUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class XPanelUpdateResponse extends BaseObject {
    private final String TAG = "XPanelUpdateResponse";
    private final String X_PANEL_CARD_CDN = ScreenAdNewModel.ScreenAdNewColumn.CDN;
    private final String X_PANEL_CARD_DATA = "data";
    private final String X_PANEL_CARD_EXTENISION = "extension";
    private final String X_PANEL_CARD_ID = "id";
    private final String X_PANEL_CARD_TEMPLATE = "template";
    private final String X_PANEL_CARD_VIEW = "view";
    private List<XPanelAgentData> mResults;
    private String mTag;

    public XPanelUpdateResponse(String str) {
        this.mTag = str;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        this.errno = jSONObject.optInt("error_no", -1);
        this.errmsg = jSONObject.optString("error_msg", "");
        if (this.errno != 0 || (optJSONObject = jSONObject.optJSONObject("result")) == null) {
            return;
        }
        if (TextUtils.isEmpty(this.mTag)) {
            LogcatUtil.m35795e("XPanelUpdateResponse", "tag empty");
            return;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray(this.mTag);
        this.mResults = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
                    XPanelAgentData xPanelAgentData = new XPanelAgentData();
                    xPanelAgentData.originalData = jSONObject2;
                    if (!jSONObject2.isNull("id")) {
                        xPanelAgentData.f49304id = jSONObject2.optString("id");
                    }
                    if (!jSONObject2.isNull("template")) {
                        xPanelAgentData.template = jSONObject2.optString("template");
                    }
                    if (!jSONObject2.isNull("view")) {
                        xPanelAgentData.view = jSONObject2.optString("view");
                    }
                    if (!jSONObject2.isNull(ScreenAdNewModel.ScreenAdNewColumn.CDN)) {
                        xPanelAgentData.cdn = jSONObject2.optString(ScreenAdNewModel.ScreenAdNewColumn.CDN);
                    }
                    xPanelAgentData.extension = jSONObject2.optJSONObject("extension");
                    xPanelAgentData.data = jSONObject2.optJSONObject("data");
                    this.mResults.add(xPanelAgentData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<XPanelAgentData> getResultList() {
        return this.mResults;
    }
}

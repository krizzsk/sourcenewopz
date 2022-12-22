package com.didichuxing.xpanel.agent.net;

import android.text.TextUtils;
import com.didichuxing.publicservice.p196db.model.ScreenAdNewModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class XPanelResponse extends BaseObject {
    private final String X_PANEL_CARD_CDN = ScreenAdNewModel.ScreenAdNewColumn.CDN;
    private final String X_PANEL_CARD_DATA = "data";
    private final String X_PANEL_CARD_EXTENISION = "extension";
    private final String X_PANEL_CARD_ID = "id";
    private final String X_PANEL_CARD_TEMPLATE = "template";
    private final String X_PANEL_CARD_VIEW = "view";
    private List<XPanelAgentData> mResults;
    public boolean mSupportSort;
    private String mTag;

    public boolean isAppend() {
        return true;
    }

    public XPanelResponse(String str) {
        this.mTag = str;
    }

    public List<XPanelAgentData> getResultList() {
        return this.mResults;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null && !TextUtils.isEmpty(this.mTag)) {
            if (jSONObject.has("error_no")) {
                this.errno = jSONObject.optInt("error_no");
            } else if (jSONObject.has("errno")) {
                this.errno = jSONObject.optInt("errno");
            }
            if (jSONObject.has("error_msg")) {
                this.errmsg = jSONObject.optString("error_msg");
            } else if (jSONObject.has("errmsg")) {
                this.errmsg = jSONObject.optString("errmsg");
            }
            if (this.errno == 0) {
                if (jSONObject.has("data")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        Object opt = optJSONObject.opt("result");
                        if (opt instanceof JSONObject) {
                            parseData(((JSONObject) opt).optJSONArray(this.mTag));
                        } else if (opt instanceof JSONArray) {
                            parseData((JSONArray) opt);
                        }
                    }
                    if (optJSONObject.has("sort_support")) {
                        boolean z = false;
                        if (optJSONObject.optInt("sort_support", 0) == 1) {
                            z = true;
                        }
                        this.mSupportSort = z;
                    }
                } else if (jSONObject.has("result")) {
                    parseData(jSONObject.optJSONObject("result").optJSONArray(this.mTag));
                }
            }
        }
    }

    private void parseData(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.mResults = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    XPanelAgentData xPanelAgentData = new XPanelAgentData();
                    xPanelAgentData.originalData = jSONObject;
                    if (!jSONObject.isNull("id")) {
                        xPanelAgentData.f49304id = jSONObject.optString("id");
                    }
                    if (!jSONObject.isNull("template")) {
                        xPanelAgentData.template = jSONObject.optString("template");
                    }
                    if (!jSONObject.isNull("view")) {
                        xPanelAgentData.view = jSONObject.optString("view");
                    }
                    if (!jSONObject.isNull(ScreenAdNewModel.ScreenAdNewColumn.CDN)) {
                        xPanelAgentData.cdn = jSONObject.optString(ScreenAdNewModel.ScreenAdNewColumn.CDN);
                    }
                    xPanelAgentData.extension = jSONObject.optJSONObject("extension");
                    xPanelAgentData.data = jSONObject.optJSONObject("data");
                    this.mResults.add(xPanelAgentData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

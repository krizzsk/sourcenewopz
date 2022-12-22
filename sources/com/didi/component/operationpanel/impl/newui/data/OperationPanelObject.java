package com.didi.component.operationpanel.impl.newui.data;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class OperationPanelObject extends BaseObject {
    public List<OperationModel> list;
    public GlobalRichInfo title;

    public static class OperationModel {
        public String corner_icon;
        public String icon;
        public GlobalRichInfo item_text;
        public int option_id;
        public int style;
        public GlobalRichInfo title;
        public String toast_text;
        public String url;
    }

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("normal")) != null && optJSONObject.has("data") && (optJSONObject2 = optJSONObject.optJSONObject("data")) != null && optJSONObject2.has("title") && optJSONObject2.has(FirebaseAnalytics.Param.ITEMS)) {
            this.title = new GlobalRichInfo();
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("title");
            if (optJSONObject3 != null) {
                this.title.setInfo(optJSONObject3.toString());
            }
            this.list = new ArrayList();
            JSONArray optJSONArray = optJSONObject2.optJSONArray(FirebaseAnalytics.Param.ITEMS);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
                    if (optJSONObject4 != null) {
                        OperationModel operationModel = new OperationModel();
                        operationModel.title = new GlobalRichInfo();
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("title");
                        if (optJSONObject5 != null) {
                            operationModel.title.setInfo(optJSONObject5.toString());
                        }
                        operationModel.style = optJSONObject4.optInt("style");
                        operationModel.icon = optJSONObject4.optString("icon");
                        operationModel.corner_icon = optJSONObject4.optString("corner_icon");
                        operationModel.url = optJSONObject4.optString("url");
                        operationModel.option_id = optJSONObject4.optInt("option_id");
                        GlobalRichInfo globalRichInfo = new GlobalRichInfo();
                        JSONObject optJSONObject6 = optJSONObject4.optJSONObject("item_text");
                        if (optJSONObject6 != null) {
                            globalRichInfo.setInfo(optJSONObject6.toString());
                        }
                        operationModel.item_text = globalRichInfo;
                        operationModel.toast_text = optJSONObject4.optString("toast_text");
                        this.list.add(operationModel);
                    }
                }
            }
        }
    }
}

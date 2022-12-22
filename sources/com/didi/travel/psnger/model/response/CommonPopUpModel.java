package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class CommonPopUpModel extends BaseObject {
    public List<PopUpOptions> options;
    public String showMsg;
    public String title;

    public static class PopUpOptionsData {
        public String url;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.showMsg = jSONObject.optString("show_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            if (optJSONArray != null) {
                this.options = new JsonUtil().parseJSONArray(optJSONArray, new PopUpOptions());
            }
        }
    }

    public static class PopUpOptions extends BaseObject {
        public static final int CANCEL = 0;

        /* renamed from: OK */
        public static final int f44216OK = 1;
        public PopUpOptionsData data;
        public String text;
        public int type;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.text = jSONObject.optString("text");
                this.type = jSONObject.optInt("type");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    PopUpOptionsData popUpOptionsData = new PopUpOptionsData();
                    this.data = popUpOptionsData;
                    popUpOptionsData.url = optJSONObject.optString("url");
                }
            }
        }
    }
}

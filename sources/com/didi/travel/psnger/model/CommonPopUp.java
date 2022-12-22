package com.didi.travel.psnger.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class CommonPopUp extends BaseObject {
    public List<PopUpOptions> options;
    public List<BlockingSelection> selection;
    public String showMsg;
    public String title;

    public interface OnOptionClickListener {
        void onCancel();

        void onConfirm(PopUpOptionsData popUpOptionsData);
    }

    public static class PopUpOptionsData {
        public static final int DRIVER = 2;
        public static final int PAX = 1;
        public int businessId;
        public String orderId;
        public int productId;
        public int role;
        public String tripId;
        public String url;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.showMsg = jSONObject.optString("show_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("selection");
            if (optJSONArray != null) {
                this.selection = new JsonUtil().parseJSONArray(optJSONArray, new BlockingSelection());
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            if (optJSONArray2 != null) {
                this.options = new JsonUtil().parseJSONArray(optJSONArray2, new PopUpOptions());
            }
        }
    }

    public static class BlockingSelection extends BaseObject {
        public String text;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.text = jSONObject.optString("text");
            }
        }
    }

    public static class PopUpOptions extends BaseObject {
        public static final int CANCEL = 0;

        /* renamed from: OK */
        public static final int f44209OK = 1;
        public static final int POP = 2;
        public static final int URL = 3;
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
                    this.data.orderId = optJSONObject.optString("order_id");
                    this.data.productId = optJSONObject.optInt("product_id");
                    this.data.tripId = optJSONObject.optString("trip_id");
                    this.data.businessId = optJSONObject.optInt("business_id");
                    this.data.role = optJSONObject.optInt("role");
                }
            }
        }
    }

    public enum PopUpActionType {
        CANCEL(0),
        CONFIRM(1),
        POPUP(2),
        URL(3);
        
        public int type;

        private PopUpActionType(int i) {
            this.type = i;
        }
    }
}

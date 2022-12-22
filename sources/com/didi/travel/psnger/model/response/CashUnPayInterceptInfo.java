package com.didi.travel.psnger.model.response;

import com.didi.component.common.net.CarServerParam;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class CashUnPayInterceptInfo extends BaseObject {
    public static final String BUTTON_ACTION_CLOSE = "CLOSE";
    public static final String BUTTON_ACTION_HAVE_PAID = "HAVE_PAID";
    public static final String BUTTON_ACTION_LINK = "LINK";
    public static final String BUTTON_ACTION_NEXT_BIND_BIND = "NEXT_PAY";
    public static final String BUTTON_ACTION_PAYNOW = "PAY_NOW";
    public static final int TYPE_CLEAN_FEE = 1;
    public static final int TYPE_HIGHWAY_FEE = 4;
    public static final int TYPE_UNPAY = 2;
    public String cardButtonText;
    public String cardContent;
    public String cardTitle;
    public String content;
    public String endAddress;
    public String endTime;
    public int fee;
    public String feeDisplay;
    public ButtonInfo havePaid;
    public String link;
    public String mCardId;
    public String mEntry;
    public FeedBack mFeedback;
    private JSONObject mLogData;
    public ButtonInfo nextBindCard;
    public String oid;
    public ButtonInfo payNow;
    public String productName;
    public String startAddress;
    public String title;
    public int type;

    public static class FeedBack {
        public String name;
        public String url;
    }

    public void parse(JSONObject jSONObject) {
        this.fee = jSONObject.optInt(CarServerParam.PARAM_FEE);
        this.oid = jSONObject.optString("order_id");
        this.type = jSONObject.optInt("strategy_code");
        this.link = jSONObject.optString("link_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("extension");
        if (optJSONObject != null) {
            this.mLogData = optJSONObject.optJSONObject("log_data");
            this.mCardId = optJSONObject.optString("cardid");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("intercept_info");
        if (optJSONObject2 != null) {
            this.title = optJSONObject2.optString("title");
            this.content = optJSONObject2.optString("content");
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("order_info");
            if (optJSONObject3 != null) {
                this.productName = optJSONObject3.optString("product_name");
                this.feeDisplay = optJSONObject3.optString("format_fee");
                this.endTime = optJSONObject3.optString("report_time");
                this.startAddress = optJSONObject3.optString("starting_name");
                this.endAddress = optJSONObject3.optString("dest_name");
            }
            JSONArray optJSONArray = optJSONObject2.optJSONArray("button_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
                    ButtonInfo buttonInfo = new ButtonInfo(optJSONObject4.optInt(Const.BUTTON_ID), optJSONObject4.optString("name"), optJSONObject4.optString("action"), optJSONObject4.optString(BlocksConst.ACTION_TYPE_TOAST));
                    if (BUTTON_ACTION_PAYNOW.equals(buttonInfo.action)) {
                        this.payNow = buttonInfo;
                    } else if (BUTTON_ACTION_NEXT_BIND_BIND.equals(buttonInfo.action)) {
                        this.nextBindCard = buttonInfo;
                    } else if (BUTTON_ACTION_HAVE_PAID.equals(buttonInfo.action)) {
                        this.havePaid = buttonInfo;
                    }
                }
            }
            JSONObject optJSONObject5 = optJSONObject2.optJSONObject("feedback");
            if (optJSONObject5 != null) {
                FeedBack feedBack = new FeedBack();
                this.mFeedback = feedBack;
                feedBack.name = optJSONObject5.optString("name");
                this.mFeedback.url = optJSONObject5.optString("url");
            }
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("intercept_tips");
        if (optJSONObject6 != null) {
            this.cardTitle = optJSONObject6.optString("title");
            this.cardContent = optJSONObject6.optString("content");
            this.cardButtonText = optJSONObject6.optString("button_text");
        }
    }

    public Map<String, Object> getExtraLog() {
        if (this.mLogData == null) {
            return null;
        }
        try {
            return (Map) new Gson().fromJson(this.mLogData.toString(), new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class ButtonInfo {
        public String action;

        /* renamed from: id */
        public int f44214id;
        public String name;
        public String toast;

        public ButtonInfo(int i, String str, String str2, String str3) {
            this.f44214id = i;
            this.name = str;
            this.action = str2;
            this.toast = str3;
        }
    }
}

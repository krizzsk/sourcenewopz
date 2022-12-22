package com.didi.travel.psnger.model.response;

import com.didi.app.SchemeDispatcherImpl;
import com.didi.soda.business.manager.BusinessDeliveryFeeTipsManager;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.core.model.response.ICarCancelTrip;
import com.google.gson.Gson;
import java.io.Serializable;
import org.json.JSONObject;

public class CarCancelTrip extends BaseObject implements ICarCancelTrip, Serializable {
    public static final int TAG_CANCEL_CONFIRM = 1;
    public static final int TAG_CANCEL_NORMAL = 1;
    public static final int TAG_CANCEL_UNCONFIRM = 0;
    public static final long serialVersionUID = -8294765033562994665L;
    public String adviceMsg;
    public String banGlobalId;
    public OrderBanPopInfo banPopInfo;
    public int banStatus;
    public String cancelButton;
    public CancelReasonInfo cancelReasonInfo;
    public int cancelType;
    public String cancelruleUrl;
    public String canceltitle;
    public String canelLabel;
    public boolean controlNewFlag = false;
    public String controlReminderImage;
    public String explainText;
    public String feeExplainMsg;
    public String feeMsg;
    public int feedback = 0;
    public int firstFree = 0;
    public int follow_global;
    public String freeButton;
    public String freeContent;
    public String freeTitle;
    public int isCancel = 1;
    public int payType;
    public int protectStatus;
    public String reassignOid;
    public String showTips;
    public String showTitle;
    public int show_alert_img;
    public boolean timeout;
    public String tips;
    public String tipsPay;
    public String title;
    public String uncancelButton;

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        this.tips = jSONObject.optString("tipsNew");
        this.cancelType = jSONObject.optInt(SchemeDispatcherImpl.HOST_PAY);
        this.canelLabel = jSONObject.optString("showTxt");
        this.payType = jSONObject.optInt("payType");
        boolean z = false;
        this.protectStatus = jSONObject.optInt(ParamKeys.PARAM_PROTECT_STATUS, 0);
        this.timeout = jSONObject.optInt("is_timeout", 0) != 0;
        this.tipsPay = jSONObject.optString("tipsPay");
        if (jSONObject.optInt(ParamKeys.PARAM_CONTROL) == 1) {
            z = true;
        }
        this.controlNewFlag = z;
        this.adviceMsg = jSONObject.optString("advice_msg");
        this.controlReminderImage = jSONObject.optString("switch_order_image");
        this.feeMsg = jSONObject.optString("fee_msg");
        this.feeExplainMsg = jSONObject.optString("fee_explain_msg");
        this.showTitle = jSONObject.optString("showTitle");
        this.showTips = jSONObject.optString(BusinessDeliveryFeeTipsManager.TIPS_EVENT_NAME);
        int optInt = jSONObject.optInt("first_free");
        this.firstFree = optInt;
        if (optInt == 1) {
            this.freeTitle = jSONObject.optString("free_title");
            this.freeContent = jSONObject.optString("free_content");
            this.freeButton = jSONObject.optString("free_button");
        }
        if (jSONObject.has("passenger_exempt_text") && (optJSONObject = jSONObject.optJSONObject("passenger_exempt_text")) != null) {
            this.title = optJSONObject.optString("title");
            this.explainText = optJSONObject.optString("explainText");
        }
        this.cancelButton = jSONObject.optString("cancel_button");
        this.uncancelButton = jSONObject.optString("uncancel_button");
        this.reassignOid = jSONObject.optString("reassign_oid");
        this.banStatus = jSONObject.optInt("ban_status");
        this.banGlobalId = jSONObject.optString("global_id");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("ban_pop_info");
        if (optJSONObject2 != null) {
            OrderBanPopInfo orderBanPopInfo = new OrderBanPopInfo();
            this.banPopInfo = orderBanPopInfo;
            orderBanPopInfo.parse(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("link_text");
        if (optJSONObject3 != null) {
            this.cancelruleUrl = optJSONObject3.optString("link");
            this.show_alert_img = optJSONObject3.optInt("show_alert_img");
            this.canceltitle = optJSONObject3.optString("title");
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("cancel_reason_info");
        if (optJSONObject4 != null) {
            this.cancelReasonInfo = (CancelReasonInfo) new Gson().fromJson(optJSONObject4.toString(), CancelReasonInfo.class);
        }
        this.follow_global = jSONObject.optInt("follow_global");
    }

    public String toString() {
        return "CarCancelTrip{tips='" + this.tips + '\'' + ", cancelType=" + this.cancelType + ", payType=" + this.payType + ", canelLabel='" + this.canelLabel + '\'' + ", protectStatus=" + this.protectStatus + ", timeout=" + this.timeout + ", isCancel=" + this.isCancel + ", tipsPay='" + this.tipsPay + '\'' + ", feedback=" + this.feedback + ", controlNewFlag=" + this.controlNewFlag + ", adviceMsg='" + this.adviceMsg + '\'' + ", feeMsg='" + this.feeMsg + '\'' + ", feeExplainMsg='" + this.feeExplainMsg + '\'' + ", showTitle='" + this.showTitle + '\'' + ", showTips='" + this.showTips + '\'' + ", firstFree=" + this.firstFree + ", freeTitle='" + this.freeTitle + '\'' + ", freeContent='" + this.freeContent + '\'' + ", freeButton='" + this.freeButton + '\'' + ", title='" + this.title + '\'' + ", explainText='" + this.explainText + '\'' + ", cancelButton='" + this.cancelButton + '\'' + ", uncancelButton='" + this.uncancelButton + '\'' + ", reassignOid='" + this.reassignOid + '\'' + ", controlReminderImage='" + this.controlReminderImage + '\'' + ", cancleruleUrl='" + this.cancelruleUrl + '\'' + ", cancletitle='" + this.canceltitle + '\'' + ", show_alert_img='" + this.show_alert_img + '\'' + '}';
    }
}

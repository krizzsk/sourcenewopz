package com.didi.component.realtimeprice.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.estimate.CarPayConfigInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarPayGroupInfoModel;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PayInfo extends BaseObject {
    public String changeResultText;
    public String engineCommitUrl;
    public JSONObject mLog;
    public JSONObject mPayAssistorModule;
    public String originFee;
    public String payBrandBgEnd;
    public String payBrandBgStart;
    public LEGORichInfo payBrandRich;
    public String payBubbleId;
    public String payBubbleText;
    public CarPayConfigInfoModel payCfgInfo;
    public List<CarPayGroupInfoModel> payGroupList;
    public List<PayWayModel.PayWayItem> payWayList;
    public int paymentsType;
    public List<SelectPaywayItem> paywayItems;
    public int processTime = 0;
    public String totalFee;

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        super.parse(jSONObject);
        if (jSONObject != null) {
            if (jSONObject.has("selected_pay_method") && (optJSONArray3 = jSONObject.optJSONArray("selected_pay_method")) != null && optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.paywayItems = new ArrayList();
                for (int i = 0; i < optJSONArray3.length(); i++) {
                    JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i);
                    if (optJSONObject5 != null) {
                        SelectPaywayItem selectPaywayItem = new SelectPaywayItem();
                        selectPaywayItem.paywayText = optJSONObject5.optString("text");
                        selectPaywayItem.paywayUrl = optJSONObject5.optString("icon_url");
                        this.paywayItems.add(selectPaywayItem);
                    }
                }
            }
            if (jSONObject.has(ParamKeys.PARAM_USER_PAY_INFO) && (optJSONArray2 = jSONObject.optJSONArray(ParamKeys.PARAM_USER_PAY_INFO)) != null) {
                this.payWayList = new JsonUtil().parseJSONArray(optJSONArray2, new PayWayModel.PayWayItem());
            }
            if (jSONObject.has("user_pay_group") && (optJSONArray = jSONObject.optJSONArray("user_pay_group")) != null) {
                this.payGroupList = new JsonUtil().parseJSONArray(optJSONArray, new CarPayGroupInfoModel());
            }
            if (jSONObject.has("user_pay_config") && (optJSONObject4 = jSONObject.optJSONObject("user_pay_config")) != null) {
                CarPayConfigInfoModel carPayConfigInfoModel = new CarPayConfigInfoModel();
                carPayConfigInfoModel.parse(optJSONObject4);
                this.payCfgInfo = carPayConfigInfoModel;
            }
            if (jSONObject.has("pay_assistor_module")) {
                JSONObject optJSONObject6 = jSONObject.optJSONObject("pay_assistor_module");
                this.mPayAssistorModule = optJSONObject6;
                if (optJSONObject6 != null && optJSONObject6.has("extension") && (optJSONObject3 = this.mPayAssistorModule.optJSONObject("extension")) != null && optJSONObject3.has("log_data")) {
                    this.mLog = optJSONObject3.optJSONObject("log_data");
                }
            }
            this.totalFee = jSONObject.optString("total_fee");
            this.originFee = jSONObject.optString("origin_fee");
            if (jSONObject.has("pay_brand") && (optJSONObject2 = jSONObject.optJSONObject("pay_brand")) != null) {
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rich_text");
                if (optJSONObject7 != null) {
                    LEGORichInfo lEGORichInfo = new LEGORichInfo();
                    this.payBrandRich = lEGORichInfo;
                    lEGORichInfo.setInfo(optJSONObject7.toString());
                }
                this.payBrandBgStart = optJSONObject2.optString("color_bg_start");
                this.payBrandBgEnd = optJSONObject2.optString("color_bg_end");
            }
            this.changeResultText = jSONObject.optString("change_result_text");
            if (jSONObject.has("pay_bubble") && (optJSONObject = jSONObject.optJSONObject("pay_bubble")) != null) {
                this.payBubbleText = optJSONObject.optString("text");
                this.payBubbleId = optJSONObject.optString("bubble_id");
            }
            this.processTime = jSONObject.optInt("process_time");
            try {
                this.paymentsType = Integer.parseInt(jSONObject.optString(ParamKeys.PARAM_PAYMENTS_TYPE));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.engineCommitUrl = jSONObject.optString("payment_submit_link");
        }
    }
}

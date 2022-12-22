package com.didi.component.comp_flex.offer_price;

import com.didi.component.business.data.form.FormStore;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.soda.customer.blocks.BlocksConst;
import java.io.Serializable;
import org.json.JSONObject;

public class OfferFlexPriceModel implements Serializable {
    public String button_text;
    public int currency_postion;
    public String currency_symbol;
    public String decimal;
    public JSONObject maxTipsSheet;
    public String max_price;
    public JSONObject minTipsSheet;
    public String min_price;
    public JSONObject offerPriceJson;
    public String order_params;
    public String recommend_price;
    public LEGORichInfo reference_price = new LEGORichInfo();
    public LEGORichInfo sub_title = new LEGORichInfo();
    public LEGORichInfo title = new LEGORichInfo();

    public void parse(String str) {
        try {
            String str2 = "button_text";
            JSONObject jSONObject = new JSONObject(str);
            this.offerPriceJson = jSONObject;
            if (jSONObject.has("recommend_price")) {
                this.recommend_price = jSONObject.getString("recommend_price");
                FormStore.getInstance().setFlex_recommend_price(this.recommend_price);
            }
            if (jSONObject.has("min_tips")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("min_tips");
                if (optJSONObject.has("passenger_newSheet")) {
                    this.minTipsSheet = optJSONObject.optJSONObject("passenger_newSheet");
                }
            }
            if (jSONObject.has("max_tips")) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("max_tips");
                if (optJSONObject2.has("passenger_newSheet")) {
                    this.maxTipsSheet = optJSONObject2.optJSONObject("passenger_newSheet");
                }
            }
            if (jSONObject.has("extension")) {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("extension");
                if (optJSONObject3.has("order_params")) {
                    this.order_params = optJSONObject3.getString("order_params");
                }
            }
            if (jSONObject.has("reference_price")) {
                this.reference_price.setInfo(jSONObject.getString("reference_price"));
            }
            if (jSONObject.has(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE)) {
                this.sub_title.setInfo(jSONObject.getString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE));
            }
            if (jSONObject.has("title")) {
                this.title.setInfo(jSONObject.getString("title"));
            }
            if (jSONObject.has("min_price")) {
                this.min_price = jSONObject.getString("min_price");
            }
            if (jSONObject.has("max_price")) {
                this.max_price = jSONObject.getString("max_price");
            }
            if (jSONObject.has("decimal")) {
                this.decimal = jSONObject.getString("decimal");
            }
            if (jSONObject.has("currency_symbol")) {
                this.currency_symbol = jSONObject.getString("currency_symbol");
            }
            if (jSONObject.has("currency_postion")) {
                this.currency_postion = jSONObject.optInt("currency_postion");
            }
            String str3 = str2;
            if (jSONObject.has(str3)) {
                this.button_text = jSONObject.getString(str3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

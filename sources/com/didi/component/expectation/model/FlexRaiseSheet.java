package com.didi.component.expectation.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FlexRaiseSheet implements Serializable {
    @SerializedName("confirm_btn_link")
    public String btn_submit_link;
    @SerializedName("confirm_btn_text")
    public String btn_title;
    @SerializedName("config")
    public Config config;
    @SerializedName("max_tips")
    public LEGORichInfo max_tips;
    @SerializedName("min_tips")
    public LEGORichInfo min_tips;
    @SerializedName("title")
    public LEGORichInfo title;

    public class Config implements Serializable {
        @SerializedName("addPrice_count")
        public String addPrice_count;
        @SerializedName("currency_postion")
        public int currency_postion;
        @SerializedName("currency_symbol")
        public String currency_symbol;
        @SerializedName("current_price")
        public String current_price;
        @SerializedName("decimal")
        public String decimal;
        @SerializedName("max_price")
        public String max_price;
        @SerializedName("min_price")
        public String min_price;
        @SerializedName("subPrice_count")
        public String subPrice_count;

        public Config() {
        }
    }
}

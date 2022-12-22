package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarInfoModel implements BffGsonStruct {
    @SerializedName("car_desc")
    public GlobalRichInfo carDescText;
    @SerializedName("discount_color")
    public String carDiscountColor;
    @SerializedName("discount_desc")
    public String carDiscountDesc;
    @SerializedName("discount_icon")
    public String carDiscountIcon;
    @SerializedName("dynamic_icon")
    public String carDynamicIcon;
    @SerializedName("extra_desc")
    public GlobalRichInfo carExtraText;
    @SerializedName("icon")
    public String carIcon;
    @SerializedName("name")
    public String carName;
    @SerializedName("origin_price")
    public String carOriginPrice;
    @SerializedName("price_list")
    public List<CarInfoPriceModel> carPriceInfo;
    @SerializedName("seat_count_icon")
    public String carSeatIcon;
    @SerializedName("seat_count_desc")
    public String carSeatNum;
    @SerializedName("selected_desc")
    public GlobalRichInfo carSelectText;
    @SerializedName("hybrid_icon_and_text_list")
    public List<hybridIconAndText> hybridIconAndTextList;
    @SerializedName("order_price")
    public AnyCarOrderPrice orderPrice;
    @SerializedName(alternate = {"tag_bubble_text"}, value = "tag_bubble_icon_url")
    public String tagBubbleText;
    @SerializedName("un_selected_desc")
    public GlobalRichInfo unSelectText;

    public static class AnyCarOrderPrice implements BffGsonStruct {
        @SerializedName("price_level")
        public double priceLevel;
        @SerializedName("price_text")
        public String priceText;
    }

    public static class hybridIconAndText implements BffGsonStruct {
        @SerializedName("color_end")
        public String colorEnd;
        @SerializedName("color_start")
        public String colorStart;
        @SerializedName("icon")
        public String icon;
        @SerializedName("info")
        public GlobalRichInfo info;
        @SerializedName("type")
        public int type;
    }
}

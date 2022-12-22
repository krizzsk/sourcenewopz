package com.didi.component.comp_flex.drivercard;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FlexTemplateDriverModel extends IXEViewModel {
    public TemplateDriverNormal normal;

    public static class OptionBtn implements BffGsonStruct {
        public String link;
        public String text;
        public int type;
    }

    public static class TemplateDriverData implements BffGsonStruct {
        public String avatar;
        @SerializedName("bargain_id")
        public String bargainId;
        @SerializedName("car_brand")
        public LEGORichInfo carBrand;
        @SerializedName("car_img")
        public String carImg;
        @SerializedName("countdown_text")
        public LEGORichInfo countdownText;
        public String did;
        public LEGORichInfo eda;
        public LEGORichInfo eta;
        @SerializedName("expireTs")
        public long expireTs;
        public String name;
        @SerializedName("time_offset")
        public long offset;
        @SerializedName("option_btn_list")
        public List<OptionBtn> optionBtns;
        @SerializedName("price")
        public LEGORichInfo price;
        public double star;
        @SerializedName("star_url")
        public String starUrl;
        public long ttl;
    }

    public static class TemplateDriverNormal implements BffGsonStruct {
        public TemplateDriverData data;
    }
}

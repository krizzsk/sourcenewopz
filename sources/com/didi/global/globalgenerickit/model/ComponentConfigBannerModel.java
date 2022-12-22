package com.didi.global.globalgenerickit.model;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ComponentConfigBannerModel extends ComponentConfigModel {
    public BusinessData businessData;

    public static class BusinessData implements BffGsonStruct {
        @SerializedName("bg_color")
        public String bgColor;
        @SerializedName("close_icon")
        public String closeUrl;
        @SerializedName("icon")
        public String iconUrl;
        @SerializedName("link")
        public String link;
        @SerializedName("sub_title_rich")
        public LEGORichInfo subTitleRich;
        public String title;
        @SerializedName("title_color")
        public String titleColor;
        @SerializedName("title_rich")
        public LEGORichInfo titleRich;
        @SerializedName("title_size")
        public int titleSize;
    }

    public void parse(ComponentConfigModel componentConfigModel) {
        super.parse(componentConfigModel);
        if (componentConfigModel != null && componentConfigModel.data != null) {
            this.businessData = (BusinessData) new Gson().fromJson(componentConfigModel.data.toString(), BusinessData.class);
        }
    }
}

package com.didi.component.comp_flex.option;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OperationPanelModel implements BffGsonStruct {
    @SerializedName("data")
    public Data data;

    public static class Data implements BffGsonStruct {
        @SerializedName("item")
        public List<ItemModel> items;
    }

    public static class ItemModel implements BffGsonStruct {
        @SerializedName("icon_url")
        public String iconUrl;
        @SerializedName("content")
        public LEGORichInfo richBtn;
        @SerializedName("url")
        public String url;
    }
}

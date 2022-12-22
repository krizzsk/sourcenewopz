package com.didi.component.comp_selectseat.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FrequencySelectModel {
    @SerializedName("hint_info")
    public String hint_info;
    @SerializedName("items")
    public List<ItemsBean> items;
    @SerializedName("title")
    public String title;
}

package com.didi.component.comp_selectseat.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SeatListItemModel {
    @SerializedName("content")
    public String content;
    @SerializedName("options")
    public List<SeatOptionsModel> options;
    @SerializedName("title")
    public String title;
    @SerializedName("unique_id")
    public String uniqueId;
}

package com.didi.component.comp_selectseat.model;

import com.google.gson.annotations.SerializedName;

public class SeatSelectModel {
    @SerializedName("com_type")
    public String comType;
    @SerializedName("data")
    public SeatSelectModelData data;
}

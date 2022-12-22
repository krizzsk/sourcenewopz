package com.didi.component.comp_selectseat.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SeatSelectModelData {
    @SerializedName("error_hint")
    public ErrorHint mErrorHint;
    @SerializedName("seat_list")
    public List<SeatListItemModel> seatList;

    public static class ErrorHint {
        @SerializedName("button")
        public String button;
        @SerializedName("content")
        public String content;
        @SerializedName("title")
        public String title;
    }
}

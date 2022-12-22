package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ConfirmTipsInfo implements Serializable {
    @SerializedName("buttons")
    public List<Button> buttons;
    @SerializedName("content")
    public String content;
    @SerializedName("page_title")
    public String page_title;
    @SerializedName("title")
    public String title;

    public static class Button {
        public String text;
        public int type;
    }
}

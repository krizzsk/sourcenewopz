package com.didi.soda.customer.widget.text;

import com.google.gson.annotations.SerializedName;

public class RichTextModel {
    public static final int INT_NOT_SET = 0;
    public static final String STRING_NOT_SET = "";
    @SerializedName("color")
    public String mColor = "";
    @SerializedName("size")
    public int mSize = 0;
    @SerializedName("stroke")
    public int mStroke = 0;
    @SerializedName("text")
    public String mText = "";
    @SerializedName("weight")
    public int mWeight = 0;

    public String toString() {
        return "RichTextModel{mText='" + this.mText + '\'' + ", mColor='" + this.mColor + '\'' + ", mSize=" + this.mSize + ", mStroke=" + this.mStroke + ", mWeight=" + this.mWeight + '}';
    }
}

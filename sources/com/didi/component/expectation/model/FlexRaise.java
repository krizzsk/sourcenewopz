package com.didi.component.expectation.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FlexRaise implements Serializable {
    @SerializedName("current_price")
    public LEGORichInfo price;
    @SerializedName("raise_btn_text")
    public String raise_btn_title;
    @SerializedName("raise_sheet")
    public FlexRaiseSheet raise_sheet;
    @SerializedName("title")
    public LEGORichInfo title;
}

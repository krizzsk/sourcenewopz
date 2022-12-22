package com.didi.component.common.model.bubble;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;

public class CommonBubbleItemModel {
    @SerializedName("bubble_id")
    public String bubbleId;
    @SerializedName("bubble_text")
    public LEGORichInfo bubbleText;
}

package com.didi.component.comp_flex.automatic_match;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AutomaticMatchModel implements Serializable {
    @SerializedName("title")
    public LEGORichInfo title;
    @SerializedName("toggle")
    public int toggle;
    @SerializedName("toggle_submit_link")
    public String toggle_submit_link;
}

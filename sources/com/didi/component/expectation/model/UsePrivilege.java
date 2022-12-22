package com.didi.component.expectation.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UsePrivilege {
    @SerializedName("color")
    public String mColor;
    @SerializedName("font_size")
    public String mFontSize;
    @SerializedName("matching_state")
    public List<UsePrivilegeMatchingState> mMatchingState;
    @SerializedName("text_color")
    public String mTextColor;
    @SerializedName("icon")
    public String nIconUrl;
}

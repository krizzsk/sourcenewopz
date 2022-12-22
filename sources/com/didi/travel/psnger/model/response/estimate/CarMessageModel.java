package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;

public class CarMessageModel implements BffGsonStruct {
    public int level;
    @SerializedName("color_end")
    public String messageBgEnd;
    @SerializedName("color_start")
    public String messageBgStart;
    @SerializedName("cdn")
    public String messageCdn;
    @SerializedName("diversion_level")
    public int messageDiversionLevel;
    @SerializedName("icon")
    public String messageIcon;
    @SerializedName("message_id")
    public String messageId;
    @SerializedName("link")
    public String messageLink;
    @SerializedName("show_arrow")
    public int messageShowArrow;
    @SerializedName("text")
    public String messageTex;
    @SerializedName("text_color")
    public String messageTextColor;
    @SerializedName("type")
    public String messageType;
    @SerializedName("message_type_id")
    public String messageTypeId;
    public LEGORichInfo msg;

    public boolean isTopGuide() {
        return this.messageDiversionLevel == 1;
    }
}

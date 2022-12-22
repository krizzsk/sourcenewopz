package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didiglobal.travel.infra.text.StringUtils;
import com.google.gson.annotations.SerializedName;

public class PayAssistorInfo implements BffGsonStruct {
    @SerializedName("assistor_text")
    private LEGORichInfo assistantText;
    @SerializedName("color_bg_end")
    private String colorEnd = "";
    @SerializedName("color_bg_start")
    private String colorStart = "";
    @SerializedName("icon_url")
    private String iconUrl = "";

    public String getIconUrl() {
        return StringUtils.valueOrEmpty(this.iconUrl);
    }

    public String getColorStart() {
        return StringUtils.valueOrEmpty(this.colorStart);
    }

    public String getColorEnd() {
        return StringUtils.valueOrEmpty(this.colorEnd);
    }

    public LEGORichInfo getAssistorText() {
        return this.assistantText;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setColorStart(String str) {
        this.colorStart = str;
    }

    public void setColorEnd(String str) {
        this.colorEnd = str;
    }

    public void setAssistantText(LEGORichInfo lEGORichInfo) {
        this.assistantText = lEGORichInfo;
    }
}

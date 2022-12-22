package com.didi.component.business.xengine.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.google.gson.annotations.SerializedName;

public class XpTemplateMsgModel extends IXEViewModel {
    public static final int TYPE_COUNT_DOWN_TIME = 4;
    public static final int TYPE_COUNT_UP_TIME = 5;
    public static final int TYPE_ETA_EDA = 6;
    public MsgTemplateNormal normal;

    public static class MsgTemplateData {
        @SerializedName("bg_color")
        public TemplateBgColorModel bgColor;
        @SerializedName("card_click")
        public TemplateButtonModel cardClick;
        @SerializedName("right_icon")
        public String rightIcon;
        public LEGORichInfo subtitle;
        public String subtitleKey;
        public int subtitle_type;
        public LEGORichInfo title;
        public String titleKey;
        @SerializedName("title_left_icon")
        public String titleLeftIcon;
        @SerializedName("title_right_icon")
        public String titleRightIcon;
        public int title_type;
    }

    public static class MsgTemplateNormal {
        public MsgTemplateData data;
        public boolean isNeedAnim = true;
    }
}

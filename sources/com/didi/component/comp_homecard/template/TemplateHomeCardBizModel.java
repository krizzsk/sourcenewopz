package com.didi.component.comp_homecard.template;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.component.business.xengine.model.TemplateBgColorModel;
import com.didi.component.business.xengine.model.TemplateButtonModel;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TemplateHomeCardBizModel extends IXEViewModel {
    @SerializedName("extension")
    public Extension mExtension;
    public BizTemplateNormal normal;

    public static class BizTemplateData {
        @SerializedName("bg_color")
        public TemplateBgColorModel bgColor;
        public Buttons buttons;
        public Config config;
        @SerializedName("right_icon")
        public Icon rightIcon;
        public TitleCk subtitle;
        public TitleCk title;
    }

    public static class BizTemplateNormal {
        public BizTemplateData data;
    }

    public static class ButtonModel extends TemplateButtonModel {
        @SerializedName("extension")
        public Extension mExtension;
        public int position;
        public int style;
        public int theme;
    }

    public static class Buttons {
        @SerializedName("list")
        public List<ButtonModel> buttonList;
    }

    public static class ClickEvent implements BffGsonStruct {
        @SerializedName("event_id")
        public String mCkEventId;
        @SerializedName("event_params")
        public JsonObject mEventParams;
    }

    public static class Config {
        @SerializedName("click_link")
        public String clickLink;
    }

    public static class Extension implements BffGsonStruct {
        @SerializedName("log_data")
        public LogData mLogData;
    }

    public static class Icon {
        public int position;
        public ImageSize size;
        public String url;
    }

    public static class ImageSize {
        public int height;
        public int width;
    }

    public static class LogData implements BffGsonStruct {
        @SerializedName("click_event")
        public ClickEvent mClickEvent;
        @SerializedName("show_event")
        public ShowEvent mShowEvent;
    }

    public static class ShowEvent implements BffGsonStruct {
        @SerializedName("event_params")
        public JsonObject mEventParams;
        @SerializedName("event_id")
        public String mSwEventId;
    }

    public static class TitleCk {
        @SerializedName("rich_text")
        public LEGORichInfo richTitle;
        public String url;
    }
}

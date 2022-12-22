package com.didi.component.comp_new_xpanel.template;

import com.didi.component.business.xengine.model.TemplateBgColorModel;
import com.didi.component.business.xengine.model.TemplateButtonModel;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class XpTemplateBizModel extends IXEViewModel {
    public BizTemplateNormal normal;

    public static class BizTemplateData {
        @SerializedName("bg_color")
        public TemplateBgColorModel bgColor;
        public Buttons buttons;
        @SerializedName("card_click")
        public TemplateButtonModel cardClick;
        @SerializedName("right_icon")
        public Icon rightIcon;
        public LEGORichInfo subtitle;
        public LEGORichInfo title;
    }

    public static class BizTemplateNormal {
        public BizTemplateData data;
    }

    public static class Buttons {
        @SerializedName("list")
        public List<TemplateButtonModel> buttonList;
        public int style;
    }

    public static class Icon {
        public int position;
        public String url;
    }
}

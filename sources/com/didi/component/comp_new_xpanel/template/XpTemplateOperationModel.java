package com.didi.component.comp_new_xpanel.template;

import com.didi.component.comp_new_xpanel.inner.RichInfoCompatible;
import com.didi.component.comp_new_xpanel.inner.TemplateButtonCompatibleModel;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.google.gson.annotations.SerializedName;

public class XpTemplateOperationModel extends IXEViewModel {
    public OperationTemplateNormal normal;

    public static class OperationTemplateData {
        @SerializedName("bg_image")
        public String bgImage;
        @SerializedName(alternate = {"button"}, value = "button_click")
        public TemplateButtonCompatibleModel button;
        @SerializedName("card_click")
        public TemplateButtonCompatibleModel cardClick;
        public RichInfoCompatible title;
    }

    public static class OperationTemplateNormal {
        public OperationTemplateData data;
    }
}

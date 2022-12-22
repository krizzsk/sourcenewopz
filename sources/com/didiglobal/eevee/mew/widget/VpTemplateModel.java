package com.didiglobal.eevee.mew.widget;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didiglobal.common.common.model.EeveeBtnModel;
import com.didiglobal.common.common.model.EeveeRichText;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.google.gson.annotations.SerializedName;

public class VpTemplateModel extends IXEViewModel implements BffGsonStruct {
    public VpTemplateNormal normal;

    public static class VpNormalData {
        public String background;
        @SerializedName("button_arrow")
        public String buttonArrow;
        @SerializedName("button_title")
        public EeveeBtnModel buttonTitle;
        public int interval;
        public EeveeRichText title;
    }

    public static class VpTemplateNormal {
        public VpNormalData data;
    }
}

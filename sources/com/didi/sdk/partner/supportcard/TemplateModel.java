package com.didi.sdk.partner.supportcard;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.google.gson.JsonObject;

public class TemplateModel extends IXEViewModel implements BffGsonStruct {
    public TemplateNormal normal;

    public static class TemplateNormal {
        public JsonObject data;
    }
}

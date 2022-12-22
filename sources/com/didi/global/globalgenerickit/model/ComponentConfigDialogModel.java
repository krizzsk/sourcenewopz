package com.didi.global.globalgenerickit.model;

import android.text.TextUtils;
import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ComponentConfigDialogModel extends ComponentConfigModel {
    public BusinessData businessData;

    public static class BusinessData implements BffGsonStruct {
        public String image;
        public List<ComponentConfigDialogOptionModel> options;
        @SerializedName("show_msg")
        public String showMsg;
        public String title;
    }

    public static class ComponentConfigDialogOptionModel implements BffGsonStruct {
        public String text;
        public int type;
        public String url;
    }

    public void parse(ComponentConfigModel componentConfigModel) {
        super.parse(componentConfigModel);
        if (componentConfigModel != null && componentConfigModel.data != null && isNative()) {
            this.businessData = (BusinessData) new Gson().fromJson(componentConfigModel.data.toString(), BusinessData.class);
        }
    }

    public boolean isNative() {
        return TextUtils.isEmpty(this.cdn) && "template_alert3".equals(this.template);
    }

    public boolean isXml() {
        return !TextUtils.isEmpty(this.cdn);
    }
}

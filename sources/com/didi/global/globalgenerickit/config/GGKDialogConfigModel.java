package com.didi.global.globalgenerickit.config;

import android.text.TextUtils;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GGKDialogConfigModel extends GGKConfigBaseModel {
    public LEGODialogBusinessData dialogData;

    public static class LEGODialogBusinessData {
        public LEGORichInfo body;
        public List<ButtonModel> buttons;
        public CheckBoxModel checkbox;
        @SerializedName("illustration_image")
        public String image;
        public LEGORichInfo title;
    }

    public void parse(GGKConfigBaseModel gGKConfigBaseModel) {
        super.parse(gGKConfigBaseModel);
        if (gGKConfigBaseModel != null && gGKConfigBaseModel.normal != null) {
            if (!TextUtils.isEmpty(gGKConfigBaseModel.normal.cdn)) {
                this.cdn = gGKConfigBaseModel.normal.cdn;
                this.data = gGKConfigBaseModel.normal.data;
            } else if (gGKConfigBaseModel.normal.data != null) {
                try {
                    this.data = gGKConfigBaseModel.normal.data;
                    this.dialogData = (LEGODialogBusinessData) new Gson().fromJson((JsonElement) this.data, LEGODialogBusinessData.class);
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isNative() {
        return TextUtils.isEmpty(this.cdn);
    }

    public boolean isXml() {
        return !TextUtils.isEmpty(this.cdn);
    }
}

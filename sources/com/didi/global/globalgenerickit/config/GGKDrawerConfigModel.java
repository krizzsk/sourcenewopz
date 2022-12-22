package com.didi.global.globalgenerickit.config;

import android.text.TextUtils;
import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GGKDrawerConfigModel extends GGKConfigBaseModel {
    public LEGODrawerBusinessData drawerData;

    public static class LEGODrawerBusinessData implements BffGsonStruct {
        public LEGORichInfo body;
        public List<ButtonModel> buttons;
        public int cancelable;
        public CheckBoxModel checkbox;
        @SerializedName("cover_cancel")
        public int coverCancel;
        @SerializedName("illustration_image")
        public String image;
        @SerializedName("link_action")
        public LinkModel link;
        @SerializedName("selected_action")
        public SelectedActionModel selectedAction;
        public int style;
        public LEGORichInfo title;
    }

    public static class LinkModel {
        @SerializedName("action_id")
        public String actionId;
        public String link;
        public LEGORichInfo title;
    }

    public static class SelectedActionModel {
        @SerializedName("action_id")
        public String actionId;
        public String link;
        @SerializedName("selected_title")
        public String selectedTitle;
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
                    this.drawerData = (LEGODrawerBusinessData) new Gson().fromJson((JsonElement) this.data, LEGODrawerBusinessData.class);
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

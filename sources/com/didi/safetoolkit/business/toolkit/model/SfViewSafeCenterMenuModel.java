package com.didi.safetoolkit.business.toolkit.model;

import com.didi.safetoolkit.util.SfAppUtils;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;
import org.json.JSONObject;

public class SfViewSafeCenterMenuModel extends SfViewMenuModel {
    public int getIconResId() {
        return R.drawable.sf_toolkit_dialog_safe_center_icon;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            super.parse(jSONObject);
        }
    }

    public static SfViewSafeCenterMenuModel buildFallbackModel() {
        SfViewSafeCenterMenuModel sfViewSafeCenterMenuModel = new SfViewSafeCenterMenuModel();
        sfViewSafeCenterMenuModel.isNew = false;
        sfViewSafeCenterMenuModel.title = SfStringGetter.getString(R.string.sf_toolkit_dialog_safety_center_title_text);
        sfViewSafeCenterMenuModel.content = SfStringGetter.getString(R.string.sf_toolkit_dialog_safety_center_subtitle_text, SfAppUtils.getAppName());
        sfViewSafeCenterMenuModel.type = SfViewMenuModel.TYPE_SAFE_CENTER;
        sfViewSafeCenterMenuModel.icon = sfViewSafeCenterMenuModel.getIconResId();
        return sfViewSafeCenterMenuModel;
    }
}

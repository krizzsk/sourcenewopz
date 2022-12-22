package com.didi.global.globalgenerickit.model.sheet;

import android.text.TextUtils;
import com.didi.global.globalgenerickit.model.ComponentUiConfig;
import com.google.gson.Gson;
import java.io.Serializable;

public class ComponentSheetModel implements Serializable {
    public String cdn;
    public ComponentSheetData data;

    /* renamed from: id */
    public String f22194id;
    public String template;
    public ComponentUiConfig ui_config;

    public ComponentSheetModel parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ComponentSheetModel) new Gson().fromJson(str, ComponentSheetModel.class);
    }
}

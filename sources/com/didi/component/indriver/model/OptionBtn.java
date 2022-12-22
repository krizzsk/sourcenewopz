package com.didi.component.indriver.model;

import org.json.JSONObject;

public class OptionBtn {
    public String link;
    public String text;

    public static OptionBtn parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        OptionBtn optionBtn = new OptionBtn();
        optionBtn.text = jSONObject.optString("text");
        optionBtn.link = jSONObject.optString("link");
        return optionBtn;
    }
}

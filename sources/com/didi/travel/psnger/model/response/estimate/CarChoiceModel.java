package com.didi.travel.psnger.model.response.estimate;

import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class CarChoiceModel {
    @SerializedName("text")
    public String choiceText;
    @SerializedName("value")
    public String choiceValue;
    @SerializedName("select_value_params")
    public JsonObject selectValueObject;
    @SerializedName("selected_text")
    public GlobalRichInfo selectedText;

    public SelectedValueParams getselectValue() {
        if (this.selectValueObject != null) {
            return (SelectedValueParams) new Gson().fromJson(this.selectValueObject.toString(), SelectedValueParams.class);
        }
        return null;
    }
}

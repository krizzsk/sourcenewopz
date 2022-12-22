package com.didi.safetoolkit.business.toolkit.model;

import com.taxis99.R;
import org.json.JSONObject;

public class SfViewRecordMenuModel extends SfViewMenuModel {
    public String autoKeepOn;
    public String autoPopContent;
    public String autoPopTitle;
    public String autoTurnOff;
    public int autoVoiceSwitch;
    public boolean canRecord;
    public String detailContent;
    public String detailLawTitle;
    public String detailLawUrl;
    public String manualCancel;
    public String manualPopContent;
    public String manualPopTitle;
    public String manualTurnOn;

    public int getIconResId() {
        return R.drawable.sf_toolkit_dialog_record_audio_close_icon;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            super.parse(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("extra_data");
            boolean z = true;
            if (optJSONObject.optInt("enable") != 1) {
                z = false;
            }
            this.canRecord = z;
            this.detailContent = optJSONObject.optString("detail_page_content");
            this.detailLawUrl = optJSONObject.optString("detail_page_law_url");
            this.detailLawTitle = optJSONObject.optString("detail_page_law_text");
            this.autoVoiceSwitch = optJSONObject.optInt("auto_voice_switch");
            this.autoPopTitle = optJSONObject.optString("auto_pop_title");
            this.autoPopContent = optJSONObject.optString("auto_pop_content");
            this.autoKeepOn = optJSONObject.optString("auto_keep_on");
            this.autoTurnOff = optJSONObject.optString("auto_turn_off");
            this.manualPopTitle = optJSONObject.optString("manual_pop_title");
            this.manualPopContent = optJSONObject.optString("manual_pop_content");
            this.manualTurnOn = optJSONObject.optString("manual_turn_on");
            this.manualCancel = optJSONObject.optString("manual_cancel");
        }
    }
}

package com.didi.component.evaluateentrance.evaluate.model;

import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.didiglobal.enginecore.template.temp.XEExtension;
import org.json.JSONObject;

public class EvaluateModel extends IXEViewModel {
    /* access modifiers changed from: protected */
    public void parseNormal(JSONObject jSONObject) {
    }

    public final void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f50198id = jSONObject.optString("id");
                this.template = jSONObject.optString("template");
                if (jSONObject.has("extension") && jSONObject.optJSONObject("extension") != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("extension");
                    this.extension = new XEExtension();
                    this.extension.log_data = optJSONObject.optJSONObject("log_data");
                    this.extension.biz_params = optJSONObject.optJSONObject("biz_params");
                }
                if (jSONObject.has("normal") && jSONObject.optJSONObject("normal") != null) {
                    parseNormal(jSONObject.optJSONObject("normal"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package com.didiglobal.enginecore.template.temp;

import android.os.Bundle;
import com.android.didi.bfflib.utils.TrackUtil;
import com.didiglobal.enginecore.constant.XENetConstant;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.Serializable;
import org.json.JSONObject;

public abstract class IXEViewModel implements Serializable {
    public XEExtension extension;

    /* renamed from: id */
    public String f50198id;
    public String template;

    public void onExtensionParsed(JsonObject jsonObject) {
    }

    public final void parseExtension(JsonObject jsonObject) {
        XEExtension xEExtension = new XEExtension();
        if (jsonObject != null) {
            int i = -1;
            try {
                if (jsonObject.has("position")) {
                    i = jsonObject.get("position").getAsInt();
                }
                if (i >= 0) {
                    xEExtension.extra = new Bundle();
                    xEExtension.extra.putInt("position", i);
                }
                if (jsonObject.has("extension")) {
                    JsonObject asJsonObject = jsonObject.get("extension").getAsJsonObject();
                    if (asJsonObject.has("biz_params")) {
                        xEExtension.biz_params = new JSONObject(asJsonObject.get("biz_params").getAsJsonObject().toString());
                    }
                    if (asJsonObject.has("log_data")) {
                        xEExtension.log_data = new JSONObject(asJsonObject.get("log_data").getAsJsonObject().toString());
                    }
                }
            } catch (Exception e) {
                TrackUtil.trackError(e instanceof JsonParseException ? 1 : 5, "", e, jsonObject.toString(), XENetConstant.XE_XENGINE_PASSENGER);
                e.printStackTrace();
            }
            this.extension = xEExtension;
            onExtensionParsed(jsonObject);
        }
    }
}

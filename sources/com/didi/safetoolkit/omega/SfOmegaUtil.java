package com.didi.safetoolkit.omega;

import android.text.TextUtils;
import com.didi.safetoolkit.api.ISfOmegaService;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.util.SfLog;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SfOmegaUtil {

    /* renamed from: a */
    private static ISfOmegaService f34532a;

    public static OmgEventAdder addEventId(String str) {
        return new OmgEventAdder(str);
    }

    public static class OmgEventAdder {
        String mEventId;
        Map<String, Object> params = new HashMap(4);

        OmgEventAdder(String str) {
            this.mEventId = str;
        }

        public OmgEventAdder addKeyValue(String str, Object obj) {
            if (obj != null) {
                this.params.put(str, obj);
            }
            return this;
        }

        public OmgEventAdder addKeyValue(Map<String, Object> map) {
            if (map != null) {
                this.params.putAll(map);
            }
            return this;
        }

        public void report() {
            SfOmegaUtil.m24393b(this.mEventId, this.params);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m24393b(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str)) {
            if (f34532a == null) {
                f34532a = (ISfOmegaService) ServiceLoader.load(ISfOmegaService.class, SafeToolKit.getIns().getBusinessType()).get();
            }
            ISfOmegaService iSfOmegaService = f34532a;
            if (iSfOmegaService == null) {
                SfLog.m24403e("app not implements ISfOmegaService !!!");
            } else {
                iSfOmegaService.addOmegaEvent(str, map);
            }
        }
    }

    public static Map<String, Object> getJsonObjectMap(JsonObject jsonObject) {
        HashMap hashMap = new HashMap(4);
        if (jsonObject != null) {
            try {
                JSONObject jSONObject = new JSONObject(jsonObject.toString());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject.opt(next);
                    if (opt != null) {
                        hashMap.put(next, opt);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }
}

package com.didi.safety.god.util;

import com.didichuxing.dfbasesdk.utils.BitmapUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class JpgUtils {
    public static boolean addJpgKeeperId(File file, String str) {
        if (file == null || !file.isFile()) {
            return false;
        }
        String lowerCase = file.getPath().toLowerCase();
        if (!lowerCase.endsWith(".jpg") && !lowerCase.endsWith(".jpeg")) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ki", str);
            BitmapUtils.setJpgUserComment(file, jSONObject.toString());
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }
}

package com.didichuxing.dfbasesdk.logupload2;

import android.net.Uri;
import android.text.TextUtils;
import com.didichuxing.dfbasesdk.encrypt.Encrypter;
import com.didichuxing.dfbasesdk.logupload.LogRecord;
import com.didichuxing.dfbasesdk.logupload.UploadObj;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseLogTask {
    protected static final long EXIT_DELAY = 20000;
    protected static final long UPLOAD_DELAY = 5000;
    protected static final long UPLOAD_INTERVAL = 10000;

    /* renamed from: a */
    static final String f46610a = "BaseLogTask";

    /* renamed from: b */
    static final int f46611b = 15;

    /* renamed from: c */
    static final int f46612c = 1;

    /* renamed from: d */
    static final int f46613d = 2;

    /* renamed from: e */
    static final int f46614e = 3;
    protected static final Map<String, String> postKeys = new HashMap();
    protected volatile String activeUrl;
    public Map<String, Boolean> encryptMap = new HashMap();
    public Map<String, String> versionMap = new HashMap();

    public void setEncrypt(String str, boolean z) {
        this.encryptMap.put(str, Boolean.valueOf(z));
    }

    public void setCallerVersion(String str, String str2) {
        this.versionMap.put(str, str2);
    }

    /* access modifiers changed from: protected */
    public String getPostKey(String str) {
        String str2 = postKeys.get(str);
        if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                str2 = Uri.parse(str).getQueryParameter("postKey");
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "jsonArray";
            }
            postKeys.put(str, str2);
        }
        return str2;
    }

    /* access modifiers changed from: protected */
    public UploadObj buildUploadObj(List<LogRecord> list, String str, String str2) {
        UploadObj uploadObj = new UploadObj();
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            String str3 = list.get(0).extras;
            for (LogRecord next : list) {
                uploadObj.ids.add(next.f46590id);
                jsonArray.add((JsonElement) jsonParser.parse(next.content).getAsJsonObject());
            }
            Boolean bool = this.encryptMap.get(str);
            if (bool == null || !bool.booleanValue()) {
                jsonObject.add(str2, jsonArray);
            } else {
                Encrypter.Input input = new Encrypter.Input();
                input.plainText = jsonArray.toString();
                input.rsaPublic = Encrypter.DEFAULT_RSA_PUBLIC;
                Encrypter.Output encrypt = Encrypter.encrypt(input);
                jsonObject.addProperty(str2, encrypt.cipherText);
                jsonObject.addProperty("sc", encrypt.cipherSecret);
            }
            Map map = (Map) GsonUtils.parseSafely(str3, new TypeToken<Map<String, Object>>() {
            }.getType());
            if (map != null) {
                for (String str4 : map.keySet()) {
                    jsonObject.add(str4, (JsonElement) map.get(str4));
                }
            }
            uploadObj.jsonBody = new Gson().toJson((JsonElement) jsonObject);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        return uploadObj;
    }
}

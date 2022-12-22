package com.didichuxing.xpanel.debug.models;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.xpanel.util.Utils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class DebugInfo {

    /* renamed from: a */
    private String f49480a;

    /* renamed from: b */
    private String f49481b;

    /* renamed from: c */
    private String f49482c;

    /* renamed from: d */
    private String f49483d;

    /* renamed from: e */
    private HashMap<String, Object> f49484e;

    /* renamed from: f */
    private List<String> f49485f = new ArrayList();

    public DebugInfo(String str, HashMap<String, Object> hashMap, String str2) {
        this.f49484e = hashMap;
        StringBuilder sb = new StringBuilder();
        this.f49481b = Utils.formatDate(new Date());
        try {
            if (TextUtils.isEmpty(str)) {
                this.f49483d = "error";
            } else {
                this.f49483d = new JSONObject(str).toString(2);
            }
            this.f49482c = (String) hashMap.get("dimensions");
            for (Map.Entry next : hashMap.entrySet()) {
                String str3 = (String) next.getKey();
                this.f49485f.add(str3);
                sb.append(str3);
                sb.append("=");
                sb.append(next.getValue());
                sb.append(ParamKeys.SIGN_AND);
            }
            String sb2 = sb.toString();
            this.f49480a = str2 + "?" + sb2.substring(0, sb2.length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDimension() {
        return this.f49482c;
    }

    public List<String> getKeyList() {
        return this.f49485f;
    }

    public String getResult() {
        return this.f49483d;
    }

    public HashMap<String, Object> getParams() {
        HashMap<String, Object> hashMap = this.f49484e;
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    public String getRequestUrl() {
        return this.f49480a;
    }

    public String getRequestTime() {
        return this.f49481b;
    }
}

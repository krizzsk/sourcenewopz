package com.didi.rlab.uni_foundation.passport;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class PassportInfo extends UniModel {

    /* renamed from: a */
    private String f34096a;

    /* renamed from: b */
    private String f34097b;

    /* renamed from: c */
    private String f34098c;

    /* renamed from: d */
    private String f34099d;

    /* renamed from: e */
    private long f34100e;

    /* renamed from: f */
    private Map<String, String> f34101f;

    public String getPhone() {
        return this.f34096a;
    }

    public void setPhone(String str) {
        this.f34096a = str;
    }

    public String getEmail() {
        return this.f34097b;
    }

    public void setEmail(String str) {
        this.f34097b = str;
    }

    public String getToken() {
        return this.f34098c;
    }

    public void setToken(String str) {
        this.f34098c = str;
    }

    public String getUid() {
        return this.f34099d;
    }

    public void setUid(String str) {
        this.f34099d = str;
    }

    public long getRole() {
        return this.f34100e;
    }

    public void setRole(long j) {
        this.f34100e = j;
    }

    public Map<String, String> getExtent() {
        return this.f34101f;
    }

    public void setExtent(Map<String, String> map) {
        this.f34101f = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("phone", this.f34096a);
        hashMap.put("email", this.f34097b);
        hashMap.put("token", this.f34098c);
        hashMap.put("uid", this.f34099d);
        hashMap.put("role", Long.valueOf(this.f34100e));
        hashMap.put("extent", this.f34101f);
        return hashMap;
    }

    public static PassportInfo fromMap(Map<String, Object> map) {
        PassportInfo passportInfo = new PassportInfo();
        String str = "";
        passportInfo.f34096a = (!map.containsKey("phone") || map.get("phone") == null) ? str : (String) map.get("phone");
        passportInfo.f34097b = (!map.containsKey("email") || map.get("email") == null) ? str : (String) map.get("email");
        passportInfo.f34098c = (!map.containsKey("token") || map.get("token") == null) ? str : (String) map.get("token");
        if (map.containsKey("uid") && map.get("uid") != null) {
            str = (String) map.get("uid");
        }
        passportInfo.f34099d = str;
        passportInfo.f34100e = (!map.containsKey("role") || map.get("role") == null) ? 0 : ((Number) map.get("role")).longValue();
        passportInfo.f34101f = (!map.containsKey("extent") || map.get("extent") == null) ? new HashMap<>() : (Map) map.get("extent");
        return passportInfo;
    }
}

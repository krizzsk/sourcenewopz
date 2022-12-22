package com.didi.safety.god.manager;

import java.util.Map;

public class SafetyGodResult {

    /* renamed from: a */
    private int f34612a = 100;

    /* renamed from: b */
    private String f34613b;

    /* renamed from: c */
    private String f34614c;

    /* renamed from: d */
    private Map<String, String> f34615d;

    public void setReturnCode(int i) {
        this.f34612a = i;
    }

    public void setMessage(String str) {
        this.f34613b = str;
    }

    public void setKeeperID(String str) {
        this.f34614c = str;
    }

    public void setJson(Map<String, String> map) {
        this.f34615d = map;
    }

    public String getMessage() {
        return this.f34613b;
    }

    public String getKeeperID() {
        return this.f34614c;
    }

    public Map<String, String> getLastConfig() {
        return this.f34615d;
    }

    public int getCode() {
        return this.f34612a;
    }
}

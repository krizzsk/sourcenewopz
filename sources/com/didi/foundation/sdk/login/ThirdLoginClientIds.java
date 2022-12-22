package com.didi.foundation.sdk.login;

import java.util.HashMap;

public class ThirdLoginClientIds {
    public static final String FACEBOOK = "facebook";
    public static final String GOOGLE = "google";

    /* renamed from: a */
    private HashMap<String, String> f21249a = new HashMap<>();

    public @interface ThirdName {
    }

    public ThirdLoginClientIds putAppId(String str, String str2) {
        this.f21249a.put(str, str2);
        return this;
    }

    public String getAppId(String str) {
        return this.f21249a.get(str);
    }
}

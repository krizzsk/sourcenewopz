package com.didi.crossplatform.track.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

public class TrackConfig {
    public static final String TYPE_FLUTTER = "Flutter";
    public static final String TYPE_HUMMER = "Hummer";
    public static final String TYPE_NATIVE = "Native";
    public static final String TYPE_RN = "RN";
    public static final String TYPE_THANOS = "Thanos";
    public static final String TYPE_XINGHE = "XingHe";
    public String appId;
    public String appName;
    public String appVersion;
    public String moduleName;
    public String moduleVersion;
    public String pageUrl;
    public String sdkType;
    public String sdkVersion;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SdkType {
    }

    public Map<String, Object> parseMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("o_type", this.sdkType);
        hashMap.put("o_tv", this.sdkVersion);
        hashMap.put("o_id", this.appId);
        hashMap.put("o_name", this.appName);
        hashMap.put("o_version", this.appVersion);
        hashMap.put("o_mi", this.moduleName);
        hashMap.put("o_mv", this.moduleVersion);
        hashMap.put("o_url", this.pageUrl);
        return hashMap;
    }
}

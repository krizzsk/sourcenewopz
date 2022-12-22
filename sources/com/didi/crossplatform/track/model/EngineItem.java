package com.didi.crossplatform.track.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

public class EngineItem {
    public static final String STATUS_END = "end";
    public static final String STATUS_START = "start";
    public String category;
    public long duration;
    public String errorMsg;
    public String name;
    public String status;
    public boolean success;

    @Retention(RetentionPolicy.SOURCE)
    public @interface STATUS {
    }

    public Map<String, Object> parseMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("var", this.category);
        hashMap.put("name", this.name);
        hashMap.put("result", this.success ? "success" : "failed");
        hashMap.put("status", this.status);
        hashMap.put("duration", Long.valueOf(this.duration));
        hashMap.put("errorMsg", this.errorMsg);
        return hashMap;
    }

    public enum CommonIndicator {
        ENGINE_INIT("sdk_init", "框架初始化"),
        UPDATE_CONFIG("request_update", "拉取配置"),
        DOWNLOAD_BUNDLE("download_bundle", "下载离线包"),
        UNZIP_BUNDLE("unzip_bundle", "解压离线包");
        
        private String category;
        private String name;

        private CommonIndicator(String str, String str2) {
            this.category = str;
            this.name = str2;
        }

        public String getCategory() {
            return this.category;
        }

        public String getName() {
            return this.name;
        }
    }
}

package com.didi.remotereslibrary.utils;

public enum ResourceKeyEnum {
    SCarCoreSProductComConfig("SCarCore/SProductComConfig.json");
    
    private String key;

    private ResourceKeyEnum(String str) {
        this.key = "";
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }
}

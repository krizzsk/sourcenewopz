package com.didi.sdk.logging;

public enum Type {
    LOGBACK("logback"),
    BINARY("binary");
    
    public final String name;

    private Type(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}

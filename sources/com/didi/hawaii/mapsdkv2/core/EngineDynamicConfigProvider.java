package com.didi.hawaii.mapsdkv2.core;

public interface EngineDynamicConfigProvider {

    public static final class DynamicConfig {
        public boolean allow;
        public int intValue;
        public String stringValue;
    }

    DynamicConfig getInt(String str, String str2);

    DynamicConfig getString(String str, String str2);

    DynamicConfig getStringLength(String str, String str2);
}

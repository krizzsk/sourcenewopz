package com.didiglobal.enginecore.cache;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class XECacheModel implements Serializable {
    @SerializedName("cache_strategy")
    int cacheStrategy;
    @SerializedName("expired_strategy")
    ExpiredStrategy expiredStrategy;
    @SerializedName("md5")
    String md5;
    @SerializedName("storage_mode")
    int storageMode;

    public static class ExpiredStrategy implements Serializable {
        @SerializedName("time")
        Time time;
    }

    public static class Time implements Serializable {
        @SerializedName("end")
        Long end;
        @SerializedName("start")
        Long start;
    }
}

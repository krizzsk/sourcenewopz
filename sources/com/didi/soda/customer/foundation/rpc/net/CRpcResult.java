package com.didi.soda.customer.foundation.rpc.net;

import com.google.gson.annotations.SerializedName;

public class CRpcResult<T> extends SFRpcResult<T> {
    @SerializedName("errno")
    private int mCode;
    @SerializedName(alternate = {"result", "groups"}, value = "data")
    private T mData;
    @SerializedName("errmsg")
    private String mMessage;
    @SerializedName("time")
    private long mServiceTime;
    @SerializedName("traceId")
    private String mTraceId;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("version")
    private int mVersion;

    public int getCode() {
        return this.mCode;
    }

    public T getData() {
        return this.mData;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public long getServiceTime() {
        return this.mServiceTime;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public String toString() {
        return "CRpcResult{mCode=" + this.mCode + ", mMessage='" + this.mMessage + '\'' + ", mServiceTime=" + this.mServiceTime + ", mVersion=" + this.mVersion + ", mData=" + this.mData + '}';
    }
}

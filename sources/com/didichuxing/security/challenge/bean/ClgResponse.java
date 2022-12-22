package com.didichuxing.security.challenge.bean;

import com.google.gson.annotations.SerializedName;

public class ClgResponse {
    @SerializedName("code")
    public int code;
    @SerializedName("data")
    public Data data;
    public String url;

    public static class Data {
        @SerializedName("args")
        public String args;
        @SerializedName("chid")
        public String chid;
        @SerializedName("func")
        public String func;
        @SerializedName("func_def")
        public String funcDef;
        @SerializedName("ts")

        /* renamed from: ts */
        public String f48958ts;
    }
}

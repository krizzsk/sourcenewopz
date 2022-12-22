package com.didi.consume.phone.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class CsOperatorListResp implements Serializable {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class DataBean implements Serializable {
        @SerializedName("operators")
        public List<Operator> operators;
    }

    public static class Operator implements Serializable {
        @SerializedName("iconUrl")
        public String iconUrl;
        @SerializedName("operatorId")
        public String operatorId;
        @SerializedName("operatorName")
        public String operatorName;
        public boolean selected;
    }
}

package com.didi.soda.customer.foundation.rpc.entity;

import com.google.gson.annotations.SerializedName;

public class SearchTag implements IEntity {
    private static final long serialVersionUID = 2947748003884209280L;
    @SerializedName("keyword")
    public String mTag;
    @SerializedName("type")
    public int mType;
}

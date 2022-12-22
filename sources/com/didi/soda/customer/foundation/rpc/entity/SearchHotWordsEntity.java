package com.didi.soda.customer.foundation.rpc.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SearchHotWordsEntity implements IEntity {
    private static final long serialVersionUID = 6294103918995353259L;
    @SerializedName("activityCate")
    public String activityCate;
    @SerializedName("activityId")
    public String activityId;
    @SerializedName("bgColor")
    public List<String> bgColor;
    @SerializedName("img")
    public String img;
    @SerializedName("resourceId")
    public String resourceId;
    @SerializedName("type")
    public Integer type;
    @SerializedName("url")
    public String url;
    @SerializedName("word")
    public String word;
}

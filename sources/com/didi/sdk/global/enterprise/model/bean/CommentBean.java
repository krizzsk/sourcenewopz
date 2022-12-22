package com.didi.sdk.global.enterprise.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Deprecated
public class CommentBean implements Serializable {
    public String comment;
    @SerializedName("max_size")
    public int maxSize;
    @SerializedName("min_size")
    public int minSize;
    @SerializedName("required")
    public boolean required;
}

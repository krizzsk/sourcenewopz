package com.didi.soda.customer.foundation.rpc.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BusinessCateEntity implements IEntity {
    private static final long serialVersionUID = 7493018952893705405L;
    public String cateId;
    public String cateName;
    public BusinessCateTipEntity cateTip;
    public String desc;
    public List<GoodsItemEntity> items;
    @SerializedName("compList")
    public List<JsonObject> mJsonComponentList;
    public int type;
}

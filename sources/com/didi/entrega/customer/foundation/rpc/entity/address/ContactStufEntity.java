package com.didi.entrega.customer.foundation.rpc.entity.address;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;

public class ContactStufEntity implements IEntity {
    private static final long serialVersionUID = 4360375924441424364L;
    @SerializedName("cateId")
    public String cateId;
    @SerializedName("cateImg")
    public String cateImg;
    @SerializedName("cateName")
    public String cateName;
    @SerializedName("remark")
    public String remark;
}

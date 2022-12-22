package com.didi.entrega.address.data.entity;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;

public class AddressCheckEntity implements IEntity {
    private static final long serialVersionUID = -1805415723581586029L;
    @SerializedName("content")
    public String content;
    @SerializedName("legal")
    public boolean legal;
    @SerializedName("toastType")
    public int toastType;
}

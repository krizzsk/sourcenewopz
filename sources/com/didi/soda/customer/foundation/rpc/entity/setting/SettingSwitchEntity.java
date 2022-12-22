package com.didi.soda.customer.foundation.rpc.entity.setting;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;

public class SettingSwitchEntity implements IEntity {
    private static final long serialVersionUID = 5837804236071418743L;
    public String desc;

    /* renamed from: id */
    public int f41048id;
    public String name;
    public String popTip;
    @SerializedName("switch")
    public int switchFlag;
}

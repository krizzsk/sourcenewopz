package com.didi.soda.address.manager;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.google.gson.annotations.SerializedName;

public class AddressTipInfo implements IEntity {
    private static final long serialVersionUID = 7931081014214537688L;
    @SerializedName("highLight")
    public int mHighLight;
    public AddressEntity mRecommendAddress;
    @SerializedName("content")
    public String mTip;
    @SerializedName("type")
    public int mTipType = 0;

    public AddressTipInfo() {
    }

    public AddressTipInfo(AddressEntity addressEntity, String str, int i) {
        this.mRecommendAddress = addressEntity;
        this.mTip = str;
        this.mTipType = i;
    }

    public String toString() {
        return "Tip{content='" + this.mTip + '\'' + ", type='" + this.mTipType + '\'' + ", highLight=" + this.mHighLight + '}';
    }
}

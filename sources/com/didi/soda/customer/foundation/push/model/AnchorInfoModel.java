package com.didi.soda.customer.foundation.push.model;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class AnchorInfoModel implements IEntity {
    private static final long serialVersionUID = -3041985704269051877L;
    public int anchorStatus;
    public String itemId;

    public AnchorInfoModel(String str, int i) {
        this.itemId = str;
        this.anchorStatus = i;
    }
}

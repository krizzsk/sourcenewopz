package com.didi.soda.cart.model;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class BusinessState implements IEntity {
    private static final long serialVersionUID = -1917385622970749448L;
    public boolean mHasShowedWineRemind = false;
    public String mWineConfirmDesc;
    public String nextBizTimeDesc;
    public String shopId;
    public int shopStatus;
    public String shopStatusDesc;
}

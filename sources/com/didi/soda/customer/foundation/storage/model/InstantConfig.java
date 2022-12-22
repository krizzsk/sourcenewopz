package com.didi.soda.customer.foundation.storage.model;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class InstantConfig implements IEntity {
    private static final long serialVersionUID = -585468074290764168L;
    public String instant_app;
    public boolean mIsDispatch = false;
    public long time;
    public String timeDate;
    public String urlString;
}

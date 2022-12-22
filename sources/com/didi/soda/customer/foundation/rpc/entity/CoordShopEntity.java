package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.datasource.page.dynamic.DynamicBaseEntity;
import com.google.gson.JsonObject;
import java.util.List;

public class CoordShopEntity extends DynamicBaseEntity {
    private static final long serialVersionUID = 3732078668303312012L;
    public List<JsonObject> compList;
    public String recId;
}

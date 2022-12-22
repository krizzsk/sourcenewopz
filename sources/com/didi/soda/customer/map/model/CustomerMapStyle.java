package com.didi.soda.customer.map.model;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class CustomerMapStyle implements IEntity {
    private static final long serialVersionUID = -6410723462752607801L;
    public boolean buildingEnable = false;
    public String styleJson = "";

    public String toString() {
        return "CustomerMapStyle {styleJson='" + this.styleJson + '\'' + ", buildingEnable=" + this.buildingEnable + '}';
    }
}

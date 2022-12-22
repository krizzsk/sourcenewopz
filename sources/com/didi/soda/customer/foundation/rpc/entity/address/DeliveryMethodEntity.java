package com.didi.soda.customer.foundation.rpc.entity.address;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class DeliveryMethodEntity implements IEntity, Cloneable {
    private static final long serialVersionUID = -9218148716394476022L;
    public String defaultRemark;
    public String disableReason;
    public int isCanChoice;
    public int isSelected;
    public String name;
    public String remark;
    public int type;
}

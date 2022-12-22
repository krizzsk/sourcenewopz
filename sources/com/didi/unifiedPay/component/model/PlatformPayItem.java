package com.didi.unifiedPay.component.model;

import java.io.Serializable;

public class PlatformPayItem extends PayItem implements Serializable {
    public CharSequence balanceDes;
    public boolean canSelect;
    public PlatformDownGradeInfo downGradeInfo;
    public String flags;
    public String name;
    public String payMoney;
    public String payState;
    public boolean selected;
}

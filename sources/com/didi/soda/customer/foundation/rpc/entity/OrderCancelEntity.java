package com.didi.soda.customer.foundation.rpc.entity;

public class OrderCancelEntity implements IEntity {
    private static final long serialVersionUID = -437026516889590358L;
    public int status;
    public String statusDesc;
    public String statusSubDesc;

    public String toString() {
        return "OrderCancelEntity:{status:" + this.status + ",statusDesc:" + this.statusDesc + ",intlSubDesc:" + this.statusSubDesc + "}";
    }
}

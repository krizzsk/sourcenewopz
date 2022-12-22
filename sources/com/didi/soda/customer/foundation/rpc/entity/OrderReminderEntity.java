package com.didi.soda.customer.foundation.rpc.entity;

public class OrderReminderEntity implements IEntity {
    private static final long serialVersionUID = 8065964199787231989L;
    public String tip;

    public String toString() {
        return "OrderReminderEntity:{tip:" + this.tip + "}";
    }
}

package com.didi.soda.customer.foundation.rpc.entity;

public class OrderHandleEntity<E> implements IEntity {
    private static final long serialVersionUID = 8065964199787231989L;
    public int handleType;
    public boolean statusChanged;
    public String tip;

    public OrderHandleEntity() {
    }

    public OrderHandleEntity(int i, boolean z) {
        this.handleType = i;
        this.statusChanged = z;
    }

    public void setHandleType(int i) {
        this.handleType = i;
    }

    public void setStatusChanged(boolean z) {
        this.statusChanged = z;
    }

    public void setTip(String str) {
        this.tip = str;
    }
}

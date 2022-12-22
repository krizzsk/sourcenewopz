package com.didi.soda.customer.foundation.rpc.entity;

public class OrderTipsEntity implements IEntity {
    private static final long serialVersionUID = 1695127337216698171L;
    public String icon;
    public int isAbnormal;
    public String msg;
    public String msgHighLight;
    public int msgStyle;
    public String url;

    public String toString() {
        return "{icon:" + this.icon + ",url:" + this.url + ",msg:" + this.msg + "}";
    }
}

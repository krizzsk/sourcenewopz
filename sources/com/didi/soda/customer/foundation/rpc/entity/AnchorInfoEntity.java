package com.didi.soda.customer.foundation.rpc.entity;

public class AnchorInfoEntity implements IEntity {
    private static final long serialVersionUID = -4205451738219866262L;
    public int anchorStatus;
    public String cateId;
    public String itemId;
    public String itemUniqKey;
    public Reminder reminder;
    public Integer setItemAction;

    public static class Reminder implements IEntity {
        private static final long serialVersionUID = 2109318039027702608L;
        public String content;
    }
}

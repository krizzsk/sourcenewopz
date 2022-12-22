package com.didi.soda.customer.foundation.rpc.entity;

public class BusinessSearchWordEntity implements IEntity {
    private static final long serialVersionUID = 7828932694344304007L;
    public String searchWord;

    public BusinessSearchWordEntity(String str) {
        this.searchWord = str;
    }
}

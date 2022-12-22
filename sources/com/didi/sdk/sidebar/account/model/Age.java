package com.didi.sdk.sidebar.account.model;

import java.io.Serializable;

public class Age implements Serializable {
    private int list_id;
    private String name;

    public int getList_id() {
        return this.list_id;
    }

    public void setList_id(int i) {
        this.list_id = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}

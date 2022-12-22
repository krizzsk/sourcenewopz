package com.didi.unifylogin.base.net.pojo.entity;

import java.io.Serializable;

public class PromptContent implements Serializable {
    public static final int MODLE_ERROR = 1;
    private String msg;
    private String tag;
    private int type;

    public PromptContent setType(int i) {
        this.type = i;
        return this;
    }

    public PromptContent setTag(String str) {
        this.tag = str;
        return this;
    }

    public PromptContent setMsg(String str) {
        this.msg = str;
        return this;
    }

    public int getType() {
        return this.type;
    }

    public String getTag() {
        return this.tag;
    }

    public String getMsg() {
        return this.msg;
    }
}

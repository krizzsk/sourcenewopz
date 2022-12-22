package com.didi.unifylogin.base.net.pojo.entity;

import java.io.Serializable;
import java.util.List;

public class PromptPageData implements Serializable {
    private String btnStr;
    private List<PromptContent> contents;
    private String subSecondTitle;
    private String subTitle;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public List<PromptContent> getContents() {
        return this.contents;
    }

    public String getBtnStr() {
        return this.btnStr;
    }

    public String getSubSecondTitle() {
        return this.subSecondTitle;
    }

    public PromptPageData setTitle(String str) {
        this.title = str;
        return this;
    }

    public PromptPageData setSubTitle(String str) {
        this.subTitle = str;
        return this;
    }

    public PromptPageData setContents(List<PromptContent> list) {
        this.contents = list;
        return this;
    }

    public PromptPageData setBtnStr(String str) {
        this.btnStr = str;
        return this;
    }

    public PromptPageData setSubSecondTitle(String str) {
        this.subSecondTitle = str;
        return this;
    }
}

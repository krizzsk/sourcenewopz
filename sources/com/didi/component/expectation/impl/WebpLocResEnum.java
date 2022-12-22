package com.didi.component.expectation.impl;

import com.taxis99.R;

public enum WebpLocResEnum {
    webp_caa(0, R.drawable.webp_caa),
    webp_cab(1, R.drawable.webp_cab);
    
    private int index;
    private int res;

    private WebpLocResEnum(int i, int i2) {
        this.index = i;
        this.res = i2;
    }

    public String toString() {
        return name() + "(" + this.index + "," + this.res + ")";
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getRes() {
        return this.res;
    }

    public void setRes(int i) {
        this.res = i;
    }

    public static WebpLocResEnum getEnum(int i) {
        for (WebpLocResEnum webpLocResEnum : values()) {
            if (webpLocResEnum.getIndex() == i) {
                return webpLocResEnum;
            }
        }
        return null;
    }
}

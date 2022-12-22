package com.didi.component.expectation.impl;

import com.didi.component.common.performance.pkgsize.RideOnlineImageCacheRegister;
import com.taxis99.R;

public enum WebpResEnum {
    webp_caa(0, R.drawable.global_ic_wait_exception_caa_placeholder, RideOnlineImageCacheRegister.URL_WAIT_RSP_PAGE_WEBP_CAA),
    webp_cab(1, R.drawable.global_ic_wait_exception_cab_placeholder, RideOnlineImageCacheRegister.URL_WAIT_RSP_PAGE_WEBP_CAB);
    
    private int index;
    private int placeHolderRes;
    private String url;

    private WebpResEnum(int i, int i2, String str) {
        this.index = i;
        this.placeHolderRes = i2;
        this.url = str;
    }

    public String toString() {
        return name() + "(index = " + this.index + ", placeHolderRes = " + this.placeHolderRes + ", url = " + this.url + ")";
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public String getUrl() {
        return this.url;
    }

    public int getPlaceHolderRes() {
        return this.placeHolderRes;
    }

    public static WebpResEnum getEnum(int i) {
        for (WebpResEnum webpResEnum : values()) {
            if (webpResEnum.getIndex() == i) {
                return webpResEnum;
            }
        }
        return null;
    }
}

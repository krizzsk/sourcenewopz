package com.didi.travel.psnger.model;

import com.didi.travel.psnger.common.net.base.BaseObject;

public class CarTypeModel extends BaseObject {
    private String carTypeId;
    private int carTypeResId;
    private int carTypeSelectResId;
    private String carTypeSelecteUrl;
    private String carTypeText;
    private String carTypeUrl;

    public String getCarTypeId() {
        return this.carTypeId;
    }

    public void setCarTypeId(String str) {
        this.carTypeId = str;
    }

    public String getCarTypeUrl() {
        return this.carTypeUrl;
    }

    public void setCarTypeUrl(String str) {
        this.carTypeUrl = str;
    }

    public String getCarTypeSelecteUrl() {
        return this.carTypeSelecteUrl;
    }

    public void setCarTypeSelecteUrl(String str) {
        this.carTypeSelecteUrl = str;
    }

    public int getCarTypeResId() {
        return this.carTypeResId;
    }

    public void setCarTypeResId(int i) {
        this.carTypeResId = i;
    }

    public int getCarTypeSelectResId() {
        return this.carTypeSelectResId;
    }

    public void setCarTypeSelectResId(int i) {
        this.carTypeSelectResId = i;
    }

    public String getCarTypeText() {
        return this.carTypeText;
    }

    public void setCarTypeText(String str) {
        this.carTypeText = str;
    }

    public String toString() {
        return "carTypeID = " + this.carTypeId + " carTypeText = " + this.carTypeText;
    }
}

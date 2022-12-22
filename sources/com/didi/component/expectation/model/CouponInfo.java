package com.didi.component.expectation.model;

import com.google.gson.annotations.SerializedName;

public class CouponInfo {
    @SerializedName("batch_cap")
    private float batchCap;
    @SerializedName("batch_type")
    private int batchType;
    @SerializedName("discount")
    private int discount;
    @SerializedName("subsidy")
    private float subsidy;

    public int getBatchType() {
        return this.batchType;
    }

    public void setBatchType(int i) {
        this.batchType = i;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int i) {
        this.discount = i;
    }

    public float getBatchCap() {
        return this.batchCap;
    }

    public void setBatchCap(float f) {
        this.batchCap = f;
    }

    public float getSubsidy() {
        return this.subsidy;
    }

    public void setSubsidy(float f) {
        this.subsidy = f;
    }
}

package com.didi.sdk.sidebar.history.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class HistoryOrder extends AbsHistoryOrder {
    @SerializedName("car_pool")
    private int carPool = 0;
    private String fromAddress;
    private int imUnread = 0;
    private boolean isInvoiceSelected;
    private boolean isSelected = false;
    private int payState;
    private String product_name;
    private String role;
    private List<String> scene;
    @SerializedName("split_fare_tag")
    private String splitFareLabel;
    @SerializedName("tip")
    public String tips;
    private String toAddress;

    public String getSplitFareLabel() {
        return this.splitFareLabel;
    }

    public void setSplitFareLabel(String str) {
        this.splitFareLabel = str;
    }

    public String getFromAddress() {
        return this.fromAddress;
    }

    public void setFromAddress(String str) {
        this.fromAddress = str;
    }

    public String getToAddress() {
        return this.toAddress;
    }

    public void setToAddress(String str) {
        this.toAddress = str;
    }

    public boolean isInvoiceSelected() {
        return this.isInvoiceSelected;
    }

    public void setInvoiceSelected(boolean z) {
        this.isInvoiceSelected = z;
    }

    public String getTips() {
        return "0".equals(this.tips) ? "" : this.tips;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String str) {
        this.role = str;
    }

    public int getCarPool() {
        return this.carPool;
    }

    public void setCarPool(int i) {
        this.carPool = i;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setIsSelected(boolean z) {
        this.isSelected = z;
    }

    public int getImUnread() {
        return this.imUnread;
    }

    public void setImUnread(int i) {
        this.imUnread = i;
    }

    public int getPayState() {
        return this.payState;
    }

    public void setPayState(int i) {
        this.payState = i;
    }

    public String getProductName() {
        return this.product_name;
    }

    public List<String> getScene() {
        return this.scene;
    }

    public String getProduct_name() {
        return this.product_name;
    }
}

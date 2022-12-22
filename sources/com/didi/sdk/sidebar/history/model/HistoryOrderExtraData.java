package com.didi.sdk.sidebar.history.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HistoryOrderExtraData implements Serializable {
    @SerializedName("activity_id")
    private int activityId = 0;
    @SerializedName("bizType")
    private String bizType;
    private String carBrand;
    private String carModel;
    @SerializedName("country_code")
    private String countryCode;
    @SerializedName("country_name")
    private String countryName;
    @SerializedName("expiry_date")
    private String expiryDate;
    @SerializedName("invoice_type")
    private int invoiceType;
    @SerializedName("invoice_url")
    private String invoiceUrl;
    @SerializedName("is_offline_pay")
    private int isOfflinePay = 0;
    @SerializedName("is_pay")
    private int isPay = 0;
    @SerializedName("line_id")
    private String lineId;
    @SerializedName("not_pay_tips")
    private String notPayTips;
    @SerializedName("order_status")
    private int orderStatus;
    @SerializedName("order_type")
    private int orderType;
    @SerializedName("out_trade_id")
    private String outTradeId;
    @SerializedName("pay_version")
    private int payVersion;
    @SerializedName("payed_status")
    private int payedStatus;
    @SerializedName("responsible_type")
    private int responsibleType;
    @SerializedName("ride_id")
    private String rideId;
    @SerializedName("ride_status")
    private int rideStatus;
    @SerializedName("url")
    private String url;
    private int userType;

    public String getNotPayTips() {
        return this.notPayTips;
    }

    public void setNotPayTips(String str) {
        this.notPayTips = str;
    }

    public int getRideStatus() {
        return this.rideStatus;
    }

    public void setRideStatus(int i) {
        this.rideStatus = i;
    }

    public String getRideId() {
        return this.rideId;
    }

    public void setRideId(String str) {
        this.rideId = str;
    }

    public String getLineId() {
        return this.lineId;
    }

    public void setLineId(String str) {
        this.lineId = str;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public void setCarModel(String str) {
        this.carModel = str;
    }

    public String getCarBrand() {
        return this.carBrand;
    }

    public void setCarBrand(String str) {
        this.carBrand = str;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setUserType(int i) {
        this.userType = i;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public HistoryOrderExtraData setOrderType(int i) {
        this.orderType = i;
        return this;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public int getPayedStatus() {
        return this.payedStatus;
    }

    public int getPayVersion() {
        return this.payVersion;
    }

    public void setPayVersion(int i) {
        this.payVersion = i;
    }

    public int getResponsibleType() {
        return this.responsibleType;
    }

    public void setResponsibleType(int i) {
        this.responsibleType = i;
    }

    public int getActivityId() {
        return this.activityId;
    }

    public void setActivityId(int i) {
        this.activityId = i;
    }

    public void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public String getOutTradeId() {
        return this.outTradeId;
    }

    public void setOutTradeId(String str) {
        this.outTradeId = str;
    }

    public void setOrderStatus(int i) {
        this.orderStatus = i;
    }

    public int getIsPay() {
        return this.isPay;
    }

    public void setIsPay(int i) {
        this.isPay = i;
    }

    public String getBizType() {
        return this.bizType;
    }

    public String getUrl() {
        return this.url;
    }

    public void setIsOfflinePay(int i) {
        this.isOfflinePay = i;
    }

    public int getIsOfflinePay() {
        return this.isOfflinePay;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public String getInvoiceUrl() {
        return this.invoiceUrl;
    }

    public void setInvoiceUrl(String str) {
        this.invoiceUrl = str;
    }

    public int getInvoiceType() {
        return this.invoiceType;
    }

    public void setInvoiceType(int i) {
        this.invoiceType = i;
    }
}

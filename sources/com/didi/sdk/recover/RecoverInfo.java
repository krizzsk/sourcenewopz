package com.didi.sdk.recover;

import com.google.gson.annotations.SerializedName;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

public class RecoverInfo {

    /* renamed from: b */
    private static final DateFormat f37092b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    /* renamed from: a */
    private String f37093a;
    @SerializedName("did")
    private String driverId;
    @SerializedName("errmsg")
    private String errorMessage;
    @SerializedName("errno")
    private int errorNo;
    @SerializedName("extra")
    private Map<String, Object> extra;
    @SerializedName("msg")
    private String message;
    @SerializedName("oid")
    private String orderId;
    @SerializedName("order_status")
    private int orderStatus;
    @SerializedName("pay_status")
    private int payStatus;
    @SerializedName("productId")
    private int productId;
    @SerializedName("product_type")
    private String productType;
    @SerializedName("setup_time")
    private String setupTime;
    @SerializedName("type")
    private int type;

    public String getOrderDetail() {
        return this.f37093a;
    }

    public void setOrderDetail(String str) {
        this.f37093a = str;
    }

    public int getErrorNo() {
        return this.errorNo;
    }

    public void setErrorNo(int i) {
        this.errorNo = i;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String str) {
        this.productType = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public long getSetupTime() {
        long time;
        synchronized (f37092b) {
            try {
                time = f37092b.parse(this.setupTime).getTime();
            } catch (ParseException unused) {
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return time;
    }

    public void setSetupTime(String str) {
        this.setupTime = str;
    }

    public String getDriverId() {
        return this.driverId;
    }

    public void setDriverId(String str) {
        this.driverId = str;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(int i) {
        this.orderStatus = i;
    }

    public int getPayStatus() {
        return this.payStatus;
    }

    public void setPayStatus(int i) {
        this.payStatus = i;
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public void setExtra(Map<String, Object> map) {
        this.extra = map;
    }

    public int getProductId() {
        return this.productId;
    }

    public String toString() {
        return "RecoverInfo{" + "errorNo=" + this.errorNo + ", errorMessage='" + this.errorMessage + '\'' + ", productType='" + this.productType + '\'' + ", orderId='" + this.orderId + '\'' + ", type=" + this.type + ", message='" + this.message + '\'' + ", setupTime='" + this.setupTime + '\'' + ", driverId='" + this.driverId + '\'' + ", orderStatus=" + this.orderStatus + ", payStatus=" + this.payStatus + ", extra='" + this.extra + '\'' + '}';
    }
}

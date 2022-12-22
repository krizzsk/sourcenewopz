package com.didi.sdk.sidebar.history.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.util.Map;

public abstract class AbsHistoryOrder implements Serializable {
    public static final int STATUS_DOING = 1;
    public static final int STATUS_FINISH = 0;
    @SerializedName("allow_send_invoice")
    public int allowSendInvoice;
    @SerializedName("extra_data")
    private JsonObject extra;
    @Deprecated
    private transient HistoryOrderExtraData extraData;
    private transient Map<String, Object> extraMap;
    @SerializedName("group_type")
    public String groupType;
    @SerializedName("hisstatus")
    private String hisStatus;
    private String order;
    private String orderId;
    @SerializedName("actual_pay_fee")
    public String priceString;
    private String product;
    @SerializedName("productId")
    private int productId;
    @SerializedName("classtype")
    private int status;
    @SerializedName("setuptime")
    private String time;
    @SerializedName("url")
    public String url;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setStatusDoing() {
        this.status = 1;
    }

    public void setStatusFinish() {
        this.status = 0;
    }

    public String getHisStatus() {
        return this.hisStatus;
    }

    public void setHisStatus(String str) {
        this.hisStatus = str;
    }

    @Deprecated
    public HistoryOrderExtraData getExtraData() {
        if (this.extraData == null && this.extra != null) {
            try {
                this.extraData = (HistoryOrderExtraData) new Gson().fromJson((JsonElement) this.extra, HistoryOrderExtraData.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.extraData;
    }

    public Map<String, Object> getExtraMap() {
        if (this.extraMap == null && this.extra != null) {
            try {
                this.extraMap = (Map) new Gson().fromJson((JsonElement) this.extra, new TypeToken<Map<String, String>>() {
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.extraMap;
    }

    public String getOrder() {
        return this.order;
    }

    public JsonObject getExtra() {
        return this.extra;
    }

    public void setExtra(JsonObject jsonObject) {
        this.extra = jsonObject;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String str) {
        this.product = str;
    }

    public int getProductId() {
        return this.productId;
    }
}

package com.didi.payment.transfer.records;

import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.transfer.net.TransBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class TransHistoryListResp extends TransBaseResp {
    public DataModel data;

    public static class DataModel implements Serializable {
        public int nextIndex = -1;
        public List<HistoryItem> orders;
    }

    public static class HistoryItem implements Serializable {
        public String amount;
        public String currencySymbol;
        @SerializedName("title")
        public String name;
        public String orderId;
        @SerializedName("longOrderId")
        public String orderIdLong;
        @SerializedName("paidBy")
        public String payType;
        @SerializedName("productLine")
        public int productLine;
        @SerializedName("status")
        public PayRichInfo statusDesc;
        @SerializedName("date")
        public String statusTime;

        public String toString() {
            return "title:" + this.name + " oid:" + this.orderId + " datetime= " + this.statusTime;
        }
    }
}

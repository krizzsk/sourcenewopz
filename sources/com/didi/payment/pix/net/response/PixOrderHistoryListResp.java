package com.didi.payment.pix.net.response;

import com.didi.payment.commonsdk.net.IValidator;
import com.didi.payment.commonsdk.net.WBaseRespTemplate;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class PixOrderHistoryListResp extends WBaseRespTemplate<DataModel> {

    public static class DataModel implements IValidator, Serializable {
        public List<OrderItem> entryList;
        public int nextIndex = -1;

        public boolean valid() {
            return true;
        }
    }

    public static class OrderItem implements Serializable {
        public String amount;
        @SerializedName("color")
        public String color4Amount;
        public String ctime;
        @SerializedName("title")
        public String name;
        public String orderId;
        public String status;
        @SerializedName("date")
        public String statusTime;

        public String toString() {
            return "title:" + this.name + " oid:" + this.orderId + " datetime= " + this.statusTime;
        }
    }
}

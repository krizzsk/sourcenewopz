package com.didi.map.global.component.slideCars.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class NearCarDriver implements Serializable {
    @SerializedName("anycar_end_bubble")
    public String anycarEndBubble;
    @SerializedName("anycar_start_bubble")
    public String anycarStartBubble;
    @SerializedName("loc")
    public List<Loc> driverLocations;
    @SerializedName("eta")
    public int eta = 0;
    @SerializedName("eta_distance")
    public int etaDistance = 0;
    @SerializedName("eta_icon")
    public String etaIcon;
    @SerializedName("eta_str")
    public String etaStr = "";
    @SerializedName("eta_str_vice")
    public String etaStrVice;
    @SerializedName("debug_open")
    public int isDebugOpen;
    @SerializedName("isexist_car")
    public int isExistCar;
    @SerializedName("isforbidden_order")
    public int isforbidden_order;
    @SerializedName("loop_interval")
    public int loopInterval;
    @SerializedName("t_eta")
    public DestEta mDestEta = new DestEta();
    @SerializedName("order_stat")
    public int orderState = 0;
    @SerializedName("pq_info")
    public PqInfo pqInfo = new PqInfo();
    @SerializedName("product_id")
    public int productId = 0;
    @SerializedName("redirect")
    public int redirect = 0;
    @SerializedName("isshow_eta")
    public int showEta;

    public static class Coordinate implements Serializable {
        @SerializedName("angle")
        public int angle;
        @SerializedName("timestamp")
        public int timestamp;
        @SerializedName("type")
        public int type;
        @SerializedName("x")

        /* renamed from: x */
        public double f26163x;
        @SerializedName("y")

        /* renamed from: y */
        public double f26164y;
    }

    public static class Loc implements Serializable {
        @SerializedName("car_level")
        public int carLevel;
        @SerializedName("channel")
        public int channel;
        @SerializedName("coords")
        public List<Coordinate> coords;
        @SerializedName("debug_status")
        public int debugStatus;
        @SerializedName("debug_status_detail")
        public String debugStatusDetail;
        @SerializedName("dirverId")
        public long driverId;
        @SerializedName("status")
        public int status;
        @SerializedName("type")
        public int type;
    }

    NearCarDriver() {
    }

    public static class DestEta implements Serializable {
        @SerializedName("eta")
        public int eta = 0;
        @SerializedName("eta_distance")
        public int etaDistance = 0;
        @SerializedName("eta_str")
        public String etaStr = "";

        public String toString() {
            return "{eta=" + this.eta + "etaDistance=" + this.etaDistance + "etaStr=" + this.etaStr + "}";
        }
    }

    public static class PqInfo implements Serializable {
        @SerializedName("eta")
        public int eta;
        @SerializedName("is_queue")
        public int is_queue;
        @SerializedName("len")
        public int len;
        @SerializedName("text")
        public String text;

        public String toString() {
            return "{eta=" + this.eta + "len=" + this.len + "text=" + this.text + "is_queue=" + this.is_queue + "}";
        }
    }
}

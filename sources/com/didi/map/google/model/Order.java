package com.didi.map.google.model;

public class Order {
    public static final int STAGE_ON_FINISHED = 5;
    public static final int STAGE_ON_TRIP = 4;
    public static final int STAGE_PICKUP = 3;
    public String bizType = "";
    public String orderId = "";
    public int scene;

    public Order(String str, String str2, int i) {
        this.orderId = str;
        this.bizType = str2;
        this.scene = i;
    }
}

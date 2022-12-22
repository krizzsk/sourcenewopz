package com.didi.map.global.component.departure.model;

public class AddressSourceType {
    public static final int ADDRESS_SOURCE_TAG_NOT_RECOMMEND = 0;
    public static final int ADDRESS_SOURCE_TAG_RECOMMEND = 1;
    public static final int DEFAULT_RECOMMEND_TAG = 1;
    public static final int NOT_DEFAULT_RECOMEND_TAG = 0;
    public static final String SRC_TYPE_CF = "cf";
    public static final String SRC_TYPE_CF_CROSS = "cfcross";
    public static final String SRC_TYPE_CF_CROSS_FIRST = "cfcross_first";
    public static final String SRC_TYPE_CF_FIRST = "cf_first";
    public static final String SRC_TYPE_DIDISTATION = "didistation";
    public static final String SRC_TYPE_PS = "ps";

    private AddressSourceType() {
    }

    public static boolean isDidiStation(String str) {
        return "didistation".equals(str);
    }
}

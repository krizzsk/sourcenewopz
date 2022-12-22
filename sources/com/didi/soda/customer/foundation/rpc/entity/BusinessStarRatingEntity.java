package com.didi.soda.customer.foundation.rpc.entity;

public class BusinessStarRatingEntity implements IEntity {
    public static int STAR_COLOR_BLACK = 1;
    public static int STAR_COLOR_ORANGE = 2;
    public static int STAR_STATUS_HIDE = 0;
    public static int STAR_STATUS_SHOW = 1;
    private static final long serialVersionUID = 3888583723412645454L;
    public int display;
    public String score;
    public int starColor;
}

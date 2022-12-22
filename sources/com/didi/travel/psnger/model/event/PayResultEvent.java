package com.didi.travel.psnger.model.event;

public class PayResultEvent {
    public static final int PAY_CLOSED = 12;
    public static final int PAY_FAIL = 11;
    public static final int PAY_SUCCESS = 10;
    public static final int PAY_WAIT = 13;
    public int payResultStatus;
    public String payStatusColor;
    public String payStatusLink;
    public String payStatusSubTitle;
    public String payStatusTitle;
}

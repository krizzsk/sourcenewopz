package com.didi.map.global.component.departure.view;

public class DepartureStateFlow {
    public static final int STATE_NORMAL = 0;
    public static final int STATE_SHOW_TERMINAL_VIEW = 2;
    public static final int STATE_SHOW_WAIT_SET_PICKUP = 3;
    public static final int STATE_SHOW_WELCOM_VIEW = 1;
    public int current = 0;
}

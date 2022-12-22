package com.didichuxing.xpanel.util;

public class StateUtil {
    public static final int ACTION_DOWN = 0;
    public static final int ACTION_MASK = 15;
    public static final int ACTION_MOVE = 2;
    public static final int ACTION_UP = 1;
    public static final int BG_MASK = 240;
    public static final int HAS_BG = 16;
    public static final int NO_BG = 0;
    public static final int SCROLL_MASK = 3840;
    public static final int SCROLL_STATE_DRAGGING = 512;
    public static final int SCROLL_STATE_IDLE = 256;
    public static final int SCROLL_STATE_SETTLING = 1024;

    public static int getActionState(int i) {
        return i & 15;
    }

    public static int getMaskState(int i) {
        return i & 240;
    }

    public static int getScrollState(int i) {
        return i & 3840;
    }
}

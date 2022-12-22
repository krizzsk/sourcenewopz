package com.didi.global.globalgenerickit.template.yoga;

public interface ILifecycle {
    public static final String EVENT_CARD_MOVE_IN = "cardMoveIn";
    public static final String EVENT_CARD_MOVE_OUT = "cardMoveOut";
    public static final String EVENT_ONPAUSE = "onPause";
    public static final String EVENT_ONRESUME = "onResume";

    void cardMoveIn();

    void cardMoveOut();

    void onPause();

    void onResume();
}

package com.didi.soda.order.view;

public interface TouchEventSkippable {
    void setSkipState(boolean z);

    boolean skipTouchEvent();
}
